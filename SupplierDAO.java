package dao;

import model.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

    // ➕ ADD SUPPLIER
    public static boolean addSupplier(Supplier s) {

    try {
        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Connection is NULL");
            return false;
        }

        String sql = "INSERT INTO suppliers(id,name, phone) VALUES(? ,?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getPhone());

        int rows = ps.executeUpdate();

        System.out.println("Rows Inserted: " + rows);

        return rows > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

    // 📄 GET ALL SUPPLIERS
   public static java.util.List<Supplier> getAllSuppliers() {

    java.util.List<Supplier> list = new java.util.ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM suppliers";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Supplier s = new Supplier(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone")
            );

            list.add(s);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

    // ✏️ UPDATE SUPPLIER
    public static boolean updateSupplier(Supplier s) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE supplier SET name=?, phone=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getPhone());
            ps.setInt(3, s.getId());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Update Supplier Error: " + e);
            return false;
        }
    }

    // ❌ DELETE SUPPLIER
    public static boolean deleteSupplier(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM supplier WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Delete Supplier Error: " + e);
            return false;
        }
    }
}