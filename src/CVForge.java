

import java.awt.CardLayout;

import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

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



    // CardLayout setup

    final CardLayout cardLayout = new CardLayout();

    final JPanel mainPanel = new JPanel(cardLayout);

    mainPanel.setBounds(0, 0, 600, 500);

  

    

    JPanel inputPanel = new JPanel(null);

    

   



    JLabel nameLabel = new JLabel("Name:");

    nameLabel.setBounds(30, 30, 100, 30);

    nameLabel.setForeground(Color.BLUE);

    inputPanel.add(nameLabel);



    JTextField nameField = new JTextField();

    nameField.setBounds(140, 30, 200, 30);

    inputPanel.add(nameField);



    JLabel emailLabel = new JLabel("Email:");

    emailLabel.setBounds(30, 70, 100, 30);

    emailLabel.setForeground(Color.BLUE);

    inputPanel.add(emailLabel);



    JTextField emailField = new JTextField();

    emailField.setBounds(140, 70, 200, 30);

    inputPanel.add(emailField);



    JLabel phoneLabel = new JLabel("Phone:");

    phoneLabel.setBounds(30, 110, 100, 30);

    phoneLabel.setForeground(Color.BLUE);

    inputPanel.add(phoneLabel);



    JTextField phoneField = new JTextField();

    phoneField.setBounds(140, 110, 200, 30);

    inputPanel.add(phoneField);

    

    JLabel eduLabel = new JLabel("Education:");

    eduLabel.setBounds(30, 150, 100, 30);

    eduLabel.setForeground(Color.BLUE);

    inputPanel.add(eduLabel);



    JTextArea eduArea = new JTextArea();

    eduArea.setBounds(140, 150, 400, 60);

    inputPanel.add(eduArea);



    JLabel skillLabel = new JLabel("Skills:");

    skillLabel.setBounds(30, 220, 100, 30);

    skillLabel.setForeground(Color.BLUE);

    inputPanel.add(skillLabel);



    JTextArea skillArea = new JTextArea();

    skillArea.setBounds(140, 220, 400, 60);

    inputPanel.add(skillArea);



    JLabel projLabel = new JLabel("Projects:");

    projLabel.setBounds(30, 290, 100, 30);

    projLabel.setForeground(Color.BLUE);

    inputPanel.add(projLabel);



    JTextArea projArea = new JTextArea();

    projArea.setBounds(140, 290, 400, 60);

    inputPanel.add(projArea);



    JButton previewButton = new JButton("Preview");

    previewButton.setBounds(140, 370, 100, 40);

    inputPanel.add(previewButton);

     

     // ====== Preview Panel ======

    JPanel previewPanel = new JPanel(null);



    JLabel titleLabel = new JLabel("==== Output page ====");

    titleLabel.setBounds(30, 20, 300, 30);

    titleLabel.setForeground(new Color(128, 0, 128));

    previewPanel.add(titleLabel);



    JTextArea previewArea = new JTextArea();

    previewArea.setEditable(false);

    previewArea.setBounds(30, 60, 520, 380);

    previewPanel.add(previewArea);

    

 

    // Back button to go to input screen again

    JButton backButton = new JButton("Back");

    backButton.setBounds(450, 20, 80, 30);

    previewPanel.add(backButton);

    

    // Add panels to card layout

    mainPanel.add(inputPanel, "Input");

    mainPanel.add(previewPanel, "Preview");



    frame.add(mainPanel);

    frame.setVisible(true);



    // Action Listener

    previewButton.addActionListener(e -> {

        String name = nameField.getText();

        String email = emailField.getText();

        String phone = phoneField.getText();

        String education = eduArea.getText();

        String skills = skillArea.getText();

        String projects = projArea.getText();



        String cvText = "==== CV Preview ====\n"

                + "Name: " + name + "\n"

                + "Email: " + email + "\n"

                + "Phone: " + phone + "\n"

                + "Education: " + education +"\n"

                + "Skills:" + skills + "\n"

                + "Projects:" + projects + "\n";



        previewArea.setText(cvText);

        

        // Switch to Preview Page

        cardLayout.show(mainPanel, "Preview");

    });

    

    backButton.addActionListener(e -> {

        cardLayout.show(mainPanel, "Input");

    });





}

}