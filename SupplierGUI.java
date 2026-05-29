package ui;

import service.SupplierService;
import model.Supplier;

import javax.swing.*;
import java.awt.*;

public class SupplierGUI extends JFrame {

    public SupplierGUI() {

        setTitle("Supplier Management");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(52, 73, 94));

        JLabel title = new JLabel("SUPPLIER MANAGEMENT");
        title.setBounds(170, 30, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton addBtn = createButton("Add Supplier", 250, 100);
        JButton viewBtn = createButton("View Suppliers", 250, 160);
        JButton updateBtn = createButton("Update Supplier", 250, 220);
        JButton deleteBtn = createButton("Delete Supplier", 250, 280);
        JButton backBtn = createButton("Back", 250, 340);

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);
        add(backBtn);

        // ➕ ADD
       addBtn.addActionListener(e -> {

    String name = JOptionPane.showInputDialog("Enter Supplier Name:");
    String phone = JOptionPane.showInputDialog("Enter Phone:");

    if (name == null || phone == null || 
        name.trim().isEmpty() || phone.trim().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Invalid Input!");
        return;
    }

    Supplier s = new Supplier(0, name, phone);

    if (SupplierService.add(s)) {
        JOptionPane.showMessageDialog(this, "Supplier Added");
    } else {
        JOptionPane.showMessageDialog(this, "Failed");
    }
});

        // 📄 VIEW
        viewBtn.addActionListener(e -> {

            java.util.List<Supplier> list = SupplierService.getAll();

            String[][] data = new String[list.size()][3];

            for (int i = 0; i < list.size(); i++) {
                Supplier s = list.get(i);
                data[i][0] = String.valueOf(s.getId());
                data[i][1] = s.getName();
                data[i][2] = s.getPhone();
            }

            JTable table = new JTable(data, new String[]{"ID","Name","Phone"});
            JFrame f = new JFrame("Suppliers");
            f.setSize(500,400);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        });

        // ✏️ UPDATE
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
            String name = JOptionPane.showInputDialog("Enter Name");
            String phone = JOptionPane.showInputDialog("Enter Phone");

            Supplier s = new Supplier(id, name, phone);

            if (SupplierService.update(s)) {
                JOptionPane.showMessageDialog(this, "Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
        });

        // ❌ DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));

            if (SupplierService.delete(id)) {
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
        btn.setBackground(new Color(46, 204, 113));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new SupplierGUI();
    }
}