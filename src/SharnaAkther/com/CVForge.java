package SharnaAkther.com;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CVForge {
	public static void main(String[] args) {
        JFrame frame = new JFrame("CV Forge");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(140, 30, 200, 30);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(140, 70, 200, 30);
        frame.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 110, 100, 30);
        frame.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(140, 110, 200, 30);
        frame.add(phoneField);

        JButton previewButton = new JButton("Preview");
        previewButton.setBounds(140, 160, 100, 40);
        frame.add(previewButton);

        JTextArea previewArea = new JTextArea();
        previewArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(previewArea);
        scroll.setBounds(30, 220, 520, 200);
        scroll.setBorder(BorderFactory.createTitledBorder("CV Preview"));
        frame.add(scroll);

        // Action Listener
        previewButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            String cvText = "==== CV Preview ====\n"
                    + "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Phone: " + phone + "\n\n"
                    + "Education:\n- \n\n"
                    + "Skills:\n-\n\n"
                    + "Projects:\n-";

            previewArea.setText(cvText);
        });

        frame.setVisible(true);
    }
}



