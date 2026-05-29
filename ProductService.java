package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductService {

    public static boolean add(Product p) {
        if (p.getName() == null || p.getName().trim().isEmpty()) return false;
        if (p.getPrice() <= 0 || p.getQuantity() < 0) return false;

        return ProductDAO.addProduct(p);
    }

    public static List<Product> getAll() {
        return ProductDAO.getAllProducts();
    }

    public static boolean update(Product p) {
        if (p.getId() <= 0) return false;
        return ProductDAO.updateProduct(p);
    }

    public static boolean delete(int id) {
        if (id <= 0) return false;
        return ProductDAO.deleteProduct(id);
    }
}