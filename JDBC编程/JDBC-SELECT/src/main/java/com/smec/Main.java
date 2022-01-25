package com.smec;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";
        //   System.out.println("insert "+insertStudents()+" student.");
        //   System.out.println("UNDATE "+updateStudents()+" student.");
        //   System.out.println("DELETE "+deleteStudents()+" student.");
        //  insertStudents("七海大鲨鱼",false,3,97);
        //  insertStudentsBatch();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername("learn");
        config.setPassword("learnpassword");
        config.addDataSourceProperty("connectionTimeout","1000");
        config.addDataSourceProperty("idleTimeout","60000");
        config.addDataSourceProperty("maximumPoolSize","10");
        ds = new HikariDataSource(config);
        List<Student> students = queryStudentsDataSource(3);
        students.forEach(System.out::println);


    }
    static List<Student> queryStudentsDataSource(int w) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, w);
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
    static void insertStudentsBatch() throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT students (name,gender,grade,score) VALUES (?,?,?,?)")) {
                List<Student> students = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    students.add(new Student("CSV" + i, true, 3, 90 + i));
                }
                for (Student s : students) {
                    ps.setObject(1, s.getName());
                    ps.setObject(2, s.isGender());
                    ps.setObject(3, s.getGrade());
                    ps.setObject(4, s.getScore());
                    ps.addBatch();
                }
                int[] ns = ps.executeBatch();
                for (int n : ns) {
                    System.out.println(n + " inserted.");
                }
            }
        }

    }

    static int deleteStudents() throws SQLException {
        int z;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {
                int n[] = insertStudents();

                List<Student> students = queryStudents(1);
                students.forEach(System.out::println);

                ps.setObject(1, n[1]);
                z = ps.executeUpdate();
                System.out.println("DELETEING...    id:" + n[1]);
            }
        }
        return z;
    }

    static int[] insertStudents() throws SQLException {
        int n[] = new int[2];
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO students (grade,name,gender,score) VALUES (?,?,?,?)"
                            , Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 1);
                ps.setObject(2, "美食家王刚");
                ps.setObject(3, 0);
                ps.setObject(4, 93);
                n[0] = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        n[1] = (int) id;
                        System.out.println("INSERTING...    id:" + id);
                    }
                }
            }
        }
        return n;
    }

    static void insertStudents(String name, boolean gender, int grade, int score) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            boolean isAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false); // 关闭自动提交事务
            try (PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, name);
                ps.setBoolean(2, gender);
                ps.setInt(3, grade);
                ps.setInt(4, score);
                int n = ps.executeUpdate();
                System.out.println(n + " inserted.");
            }
            if (score > 100) {
                conn.rollback();
                System.out.println("rollback.");

            } else {
                conn.commit();
                System.out.println("commit.");
            }
            conn.setAutoCommit(isAutoCommit); // 恢复AutoCommit设置
        }
    }

    static int updateStudents() throws SQLException {
        int n;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name = ? WHERE id = ?")) {
                ps.setString(1, "日铁牛");
                ps.setLong(2, 13);
                n = ps.executeUpdate();

                System.out.println("UNDATETING...    id:13");
            }
        }
        return n;
    }

    static List<Student> queryStudents(int w) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, w);
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
        Student std = new StudentBuilder().createStudent();
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
    static HikariConfig config = new HikariConfig();
    static DataSource ds = new HikariDataSource();
}
