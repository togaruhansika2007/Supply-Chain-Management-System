package ui;

import service.OrderService;
import model.Order;

import javax.swing.*;
import java.awt.*;

public class OrderGUI extends JFrame {

    public OrderGUI() {

        setTitle("Order Management");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(39, 55, 70));

        JLabel title = new JLabel("ORDER MANAGEMENT");
        title.setBounds(190, 30, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton addBtn = createButton("Add Order", 250, 100);
        JButton viewBtn = createButton("View Orders", 250, 160);
        JButton updateBtn = createButton("Update Order", 250, 220);
        JButton deleteBtn = createButton("Delete Order", 250, 280);
        JButton backBtn = createButton("Back", 250, 340);

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);
        add(backBtn);

        // ➕ ADD
       addBtn.addActionListener(e -> {

    String pidStr = JOptionPane.showInputDialog("Enter Product ID:");
    String qtyStr = JOptionPane.showInputDialog("Enter Quantity:");

    if (pidStr == null || qtyStr == null ||
        pidStr.trim().isEmpty() || qtyStr.trim().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Invalid Input!");
        return;
    }

    int pid = Integer.parseInt(pidStr);
    int qty = Integer.parseInt(qtyStr);

    Order o = new Order(0, pid, qty);

    if (OrderService.add(o)) {
        JOptionPane.showMessageDialog(this, "Order Added");
    } else {
        JOptionPane.showMessageDialog(this, "Failed");
    }
});
        // 📄 VIEW
        viewBtn.addActionListener(e -> {

            java.util.List<Order> list = OrderService.getAll();

            String[][] data = new String[list.size()][3];

            for (int i = 0; i < list.size(); i++) {
                Order o = list.get(i);
                data[i][0] = String.valueOf(o.getId());
                data[i][1] = String.valueOf(o.getProductId());
                data[i][2] = String.valueOf(o.getQuantity());
            }

            JTable table = new JTable(data, new String[]{"ID","Product ID","Qty"});
            JFrame f = new JFrame("Orders");
            f.setSize(500,400);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        });

        // ✏️ UPDATE
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID"));
            int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID"));
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));

            Order o = new Order(id, pid, qty);

            if (OrderService.update(o)) {
                JOptionPane.showMessageDialog(this, "Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
        });

        // ❌ DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID"));

            if (OrderService.delete(id)) {
                JOptionPane.showMessageDialog(this, "Deleted");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
        });

        // 🔙 BACK
        backBtn.addActionListener(e -> {
            dispose();
            new DashboardGUI();
        });

        setVisible(true);
    }

    public JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 200, 40);
        btn.setBackground(new Color(231, 76, 60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new OrderGUI();
    }
}