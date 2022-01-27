package com.smec.service;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserService {

    private MailService mailService;
    static DataSource dataSource;


    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    static List<User> users;

    static List<User> queryStudents() throws SQLException {
        List<User> students = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM springioc ")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    public void setusers() throws SQLException {
        users = queryStudents();
        users.forEach((s) -> {
            System.out.println(s.getName());
        });
    }

    static User extractRow(ResultSet rs) throws SQLException {

        User std = new User();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setEmail(rs.getString("email"));
        std.setPassword(rs.getString("password"));
        return std;
    }

    public User login(String email, String password) throws SQLException {

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public Optional<User> getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public User register(String email, String password, String name) throws SQLException {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        //users.add(user);
        this.insertUsers(email, password, name);
        mailService.sendRegistrationMail(user);
        setusers();
        return user;
    }

    static void insertUsers(String email, String password, String name) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement ps = connection
                    .prepareStatement("insert into springioc (email,password,name) values (?,?,?);"
                            , Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, email);
                ps.setObject(2, password);
                ps.setObject(3, name);
                int n = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next() && n == 1) {
                        long id = rs.getLong(1);
                        System.out.println("Registed   id:" + id);
                    }
                }
            }
        }
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
