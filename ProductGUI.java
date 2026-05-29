package ui;

import service.ProductService;
import model.Product;

import javax.swing.*;
import java.awt.*;

public class ProductGUI extends JFrame {

    public ProductGUI() {

        setTitle("Product Management");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("PRODUCT MANAGEMENT");
        title.setBounds(180, 30, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton addBtn = createButton("Add Product", 250, 100);
        JButton viewBtn = createButton("View Products", 250, 160);
        JButton updateBtn = createButton("Update Product", 250, 220);
        JButton deleteBtn = createButton("Delete Product", 250, 280);
        JButton backBtn = createButton("Back", 250, 340);

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);
        add(backBtn);

        // ➕ ADD
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Product Name:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));

            Product p = new Product(0, name, price, qty);

            if (ProductService.add(p)) {
                JOptionPane.showMessageDialog(this, "Product Added");
            } else {
                JOptionPane.showMessageDialog(this, "Failed / Invalid Input");
            }
        });

        // 📄 VIEW
        viewBtn.addActionListener(e -> {

            java.util.List<Product> list = ProductService.getAll();

            String[][] data = new String[list.size()][4];

            for (int i = 0; i < list.size(); i++) {
                Product p = list.get(i);
                data[i][0] = String.valueOf(p.getId());
                data[i][1] = p.getName();
                data[i][2] = String.valueOf(p.getPrice());
                data[i][3] = String.valueOf(p.getQuantity());
            }

            JTable table = new JTable(data, new String[]{"ID","Name","Price","Qty"});
            JFrame f = new JFrame("Products");
            f.setSize(500,400);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        });

        // ✏️ UPDATE
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
            String name = JOptionPane.showInputDialog("Enter Name");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price"));
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Qty"));

            Product p = new Product(id, name, price, qty);

            if (ProductService.update(p)) {
                JOptionPane.showMessageDialog(this, "Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
        });

        // ❌ DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));

            if (ProductService.delete(id)) {
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
        btn.setBackground(new Color(41, 128, 185));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new ProductGUI();
    }
}