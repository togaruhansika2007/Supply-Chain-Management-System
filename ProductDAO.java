package dao;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // ➕ CREATE (Add Product)
    public static boolean addProduct(Product p) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO product(name, price, quantity) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Add Product Error: " + e);
            return false;
        }
    }

    // 📄 READ (Get All Products)
    public static List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM product";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );

                list.add(p);
            }

        } catch (Exception e) {
            System.out.println("Fetch Error: " + e);
        }

        return list;
    }

    // ✏️ UPDATE PRODUCT
    public static boolean updateProduct(Product p) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE product SET name=?, price=?, quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.setInt(4, p.getId());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Update Error: " + e);
            return false;
        }
    }

    // ❌ DELETE PRODUCT
    public static boolean deleteProduct(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Delete Error: " + e);
            return false;
        }
    }
}