package dao;

import db.DBConnection;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // ➕ ADD ORDER
    public static boolean addOrder(Order o) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO orders(product_id, quantity) VALUES(?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, o.getProductId());
            ps.setInt(2, o.getQuantity());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // 📄 GET ALL ORDERS
    public static List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM orders";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order o = new Order(
                        rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                );

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ❌ DELETE ORDER
    public static boolean deleteOrder(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM orders WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}