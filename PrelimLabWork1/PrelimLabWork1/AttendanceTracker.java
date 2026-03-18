package PrelimLabWork1;
// Import Swing and other required libraries
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * LAB Work 1
 * Java Swing Attendance Tracker
 */
public class AttendanceTracker {

    public static void main(String[] args) {

        // Create the JFrame window
        JFrame frame = new JFrame("Attendance Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Create a JPanel to organize components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create labels
        JLabel nameLabel = new JLabel("Attendance Name:");
        JLabel courseLabel = new JLabel("Course / Year:");
        JLabel timeInLabel = new JLabel("Time In:");
        JLabel signatureLabel = new JLabel("E-Signature:");

        // Create text fields
        JTextField nameField = new JTextField(20);
        JTextField courseField = new JTextField(20);
        JTextField timeInField = new JTextField(20);
        JTextField signatureField = new JTextField(20);

        // Make Time In and E-Signature fields read-only
        timeInField.setEditable(false);
        signatureField.setEditable(false);

        // Get system date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeIn = now.format(formatter);
        timeInField.setText(timeIn);

        // Generate E-Signature using UUID
        String eSignature = UUID.randomUUID().toString();
        signatureField.setText(eSignature);

        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(courseLabel, gbc);
        gbc.gridx = 1;
        panel.add(courseField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(timeInLabel, gbc);
        gbc.gridx = 1;
        panel.add(timeInField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(signatureLabel, gbc);
        gbc.gridx = 1;
        panel.add(signatureField, gbc);

        // Add panel to frame
        frame.add(panel);

        // Display the window
        frame.setVisible(true);
    }
}
