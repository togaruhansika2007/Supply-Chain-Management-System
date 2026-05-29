package service;

import dao.SupplierDAO;
import model.Supplier;

import java.util.List;

public class SupplierService {

    public static boolean add(Supplier s) {
        if (s.getName() == null || s.getName().trim().isEmpty()) return false;
        if (s.getPhone() == null || s.getPhone().trim().isEmpty()) return false;

        return SupplierDAO.addSupplier(s);
    }

    public static List<Supplier> getAll() {
        return SupplierDAO.getAllSuppliers();
    }

    public static boolean update(Supplier s) {
        if (s.getId() <= 0) return false;
        return SupplierDAO.updateSupplier(s);
    }

    public static boolean delete(int id) {
        if (id <= 0) return false;
        return SupplierDAO.deleteSupplier(id);
    }
}