package org.example;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Container container = frame.getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(new JLabel("First Name:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(new JLabel("Last Name:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        container.add(new JLabel("Middle Name:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        container.add(new JLabel("Phone Number:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        container.add(new JLabel("Address:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        container.add(new JLabel("Email address:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        container.add(new JLabel("ID:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        container.add(new JTextField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        container.add(new JLabel("Password:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        container.add(new JPasswordField(20), constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        container.add(new JButton("Sign Up"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 9;
        container.add(new JButton("Cancel"), constraints);

        frame.setVisible(true);
    }
}