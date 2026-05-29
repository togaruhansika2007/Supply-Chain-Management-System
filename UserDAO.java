package dao;

import java.sql.*;
import dao.DBConnection;

public class UserDAO {

    public static boolean validateLogin(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}