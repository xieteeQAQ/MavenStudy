package com.xietee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    private static final String URL =
            "jdbc:mysql://localhost:3306/java_study"
            + "?useUnicode=true"
            + "&characterEncoding=UTF-8"
            + "&serverTimezone=Asia/Shanghai"
            + "&useSSL=false"
            + "&allowPublicKeyRetrieval=true";

    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("数据库连接成功");

            long id = insertUser(conn, "xietee", 18, "xieteeQAQ@outlook.com");
            queryUsers(conn);

            updateUser(conn, id , 19);
            queryUsers(conn);

            deleteUser(conn, id);
            queryUsers(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static long insertUser(
            Connection conn,
            String name,
            int age,
            String email
    ) throws SQLException {
        String sql = "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
        }

        throw new SQLException("插入失败，没有获取到主键");
    }

    private static void queryUsers(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age, email FROM users";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + age + " | " + email);
            }
        }
    }

    private static void updateUser(Connection conn, long id, int age) throws SQLException {
        String sql = "UPDATE users SET age = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, age);
            ps.setLong(2, id);
            System.out.println("更新影响行数: " + ps.executeUpdate());
        }
    }

    private static void deleteUser(Connection conn, long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            System.out.println("删除影响行数: " + ps.executeUpdate());
        }
    }
}
