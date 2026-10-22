/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.dbconnection;
import java.sql.*;



public class UserDAO {
     public User validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User u = new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
                u.setUserId(rs.getInt("user_id"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createUser(User user) {
        String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRole());
            int res = pst.executeUpdate();
            return res > 0;

        } catch (SQLIntegrityConstraintViolationException ex) {
            // username unique constraint
            System.err.println("Username already exists.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

