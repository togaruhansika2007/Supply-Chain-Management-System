package ui;

import dao.ProductDAO;
import dao.OrderDAO;
import dao.SupplierDAO;

import javax.swing.*;
import java.awt.*;

public class AnalyticsGUI extends JFrame {

    public AnalyticsGUI() {

        setTitle("Analytics Dashboard");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(26, 188, 156));
        JLabel status = new JLabel("System Status: ACTIVE");
        JLabel title = new JLabel("ANALYTICS DASHBOARD");
        title.setBounds(180, 30, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        int products = ProductDAO.getAllProducts().size();
        int suppliers = SupplierDAO.getAllSuppliers().size();
        int orders = OrderDAO.getAllOrders().size();

        JLabel pLabel = new JLabel("Total Products: " + products);
        JLabel sLabel = new JLabel("Total Suppliers: " + suppliers);
        JLabel oLabel = new JLabel("Total Orders: " + orders);

        pLabel.setBounds(250, 120, 300, 30);
        sLabel.setBounds(250, 170, 300, 30);
        oLabel.setBounds(250, 220, 300, 30);

        pLabel.setForeground(Color.WHITE);
        sLabel.setForeground(Color.WHITE);
        oLabel.setForeground(Color.WHITE);

        pLabel.setFont(new Font("Arial", Font.BOLD, 18));
        sLabel.setFont(new Font("Arial", Font.BOLD, 18));
        oLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(pLabel);
        add(sLabel);
        add(oLabel);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(250, 320, 200, 40);
        backBtn.setBackground(new Color(52, 73, 94));
        backBtn.setForeground(Color.WHITE);
        add(backBtn);

        backBtn.addActionListener(e -> {
            dispose();
            new DashboardGUI();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AnalyticsGUI();
    }
}