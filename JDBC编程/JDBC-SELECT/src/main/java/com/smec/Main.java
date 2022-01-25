package com.smec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";
        List<Student> students = queryStudents();
        students.forEach(System.out::println);


    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, 3);
                ps.setInt(2, 60);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }

    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "learn";
    static final String jdbcPassword = "learnpassword";
}
