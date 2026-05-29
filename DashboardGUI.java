package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardGUI extends JFrame {

    public DashboardGUI() {

        setTitle("Dashboard");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(34, 49, 63));

        JLabel title = new JLabel("SUPPLY CHAIN DASHBOARD");
        title.setBounds(180, 30, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton productBtn = createButton("Products", 250, 100);
        JButton supplierBtn = createButton("Suppliers", 250, 160);
        JButton orderBtn = createButton("Orders", 250, 220);
        JButton analyticsBtn = createButton("Analytics", 250, 280);
        JButton logoutBtn = createButton("Logout", 250, 340);

        add(productBtn);
        add(supplierBtn);
        add(orderBtn);
        add(analyticsBtn);
        add(logoutBtn);

        // NAVIGATION CONNECT
        productBtn.addActionListener(e -> {
            dispose();
            new ProductGUI();
        });

        supplierBtn.addActionListener(e -> {
            dispose();
            new SupplierGUI();
        });

        orderBtn.addActionListener(e -> {
            dispose();
            new OrderGUI();
        });

        analyticsBtn.addActionListener(e -> {
            dispose();
            new AnalyticsGUI();
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginGUI();
        });

        setVisible(true);
    }

    public JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 200, 40);
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new DashboardGUI();
    }
}