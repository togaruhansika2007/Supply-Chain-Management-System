package service;

import dao.OrderDAO;
import model.Order;

import java.util.List;

public class OrderService {

    public static boolean add(Order o) {
        if (o.getProductId() <= 0) return false;
        if (o.getQuantity() <= 0) return false;

        return OrderDAO.addOrder(o);
    }

    public static List<Order> getAll() {
        return OrderDAO.getAllOrders();
    }

    public static boolean update(Order o) {
        if (o.getId() <= 0) return false;
        return OrderDAO.updateOrder(o);
    }

    public static boolean delete(int id) {
        if (id <= 0) return false;
        return OrderDAO.deleteOrder(id);
    }
}