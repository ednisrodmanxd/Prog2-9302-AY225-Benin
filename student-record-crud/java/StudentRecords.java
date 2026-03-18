/*
 Programmer: Lance Xedrick Benin - YOUR STUDENT ID
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentRecords extends JFrame {

    DefaultTableModel model;
    JTable table;
    JTextField txtId, txtName, txtGrade;

    public StudentRecords() {
        this.setTitle("Student Records - YOUR NAME YOUR ID");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        model = new DefaultTableModel();
        table = new JTable(model);

        // Columns (simplified)
        model.addColumn("Student ID");
        model.addColumn("Name");
        model.addColumn("Grade");

        loadCSV();

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);

        // Input Panel
        JPanel panel = new JPanel();

        txtId = new JTextField(8);
        txtName = new JTextField(10);
        txtGrade = new JTextField(5);

        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");

        panel.add(new JLabel("ID"));
        panel.add(txtId);
        panel.add(new JLabel("Name"));
        panel.add(txtName);
        panel.add(new JLabel("Grade"));
        panel.add(txtGrade);
        panel.add(btnAdd);
        panel.add(btnDelete);

        add(panel, BorderLayout.SOUTH);

        // ADD
        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{
                    txtId.getText(),
                    txtName.getText(),
                    txtGrade.getText()
            });
        });

        // DELETE
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) model.removeRow(row);
        });

        setVisible(true);
    }

    void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1] + " " + data[2];
                String grade = data[3]; // sample grade

                model.addRow(new Object[]{id, name, grade});
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file");
        }
    }

    public static void main(String[] args) {
        new StudentRecords();
    }
}
