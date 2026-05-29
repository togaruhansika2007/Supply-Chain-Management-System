package ui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    public LoginGUI() {

        setTitle("Login");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("LOGIN");
        title.setBounds(160, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 80, 180, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);
        passLabel.setForeground(Color.WHITE);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 120, 180, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(130, 180, 120, 35);
        loginBtn.setBackground(new Color(46, 204, 113));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        add(loginBtn);

        loginBtn.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (UserDAO.validateLogin(username, password)) {

                JOptionPane.showMessageDialog(this, "Login Successful!");

                dispose();
                new DashboardGUI();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}