import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;

public class CVForge {

public static void main(String[] args) {

    JFrame frame = new JFrame("CV Forge");

    frame.setSize(650, 550);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(null);

    frame.setLocationRelativeTo(null);


    final CardLayout cardLayout = new CardLayout();

    final JPanel mainPanel = new JPanel(cardLayout);

    mainPanel.setBounds(0, 0, 600, 500);



    JPanel inputPanel = new JPanel(null);
    inputPanel.setBackground(new Color(255, 228, 181));   

   

    JLabel headerTitle = new JLabel("CV Information Form");
    headerTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
    headerTitle.setForeground(new Color(0, 102, 204));
    headerTitle.setBounds(200, 0, 300, 30);
    inputPanel.add(headerTitle);


    JLabel nameLabel = new JLabel("Name:");

    nameLabel.setBounds(30, 30, 100, 30);

    nameLabel.setForeground(Color.BLUE);
    nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    inputPanel.add(nameLabel);



    JTextField nameField = new JTextField();

    nameField.setBounds(140, 30, 200, 30);

    inputPanel.add(nameField);



    JLabel emailLabel = new JLabel("Email:");

    emailLabel.setBounds(30, 70, 100, 30);

    emailLabel.setForeground(Color.BLUE);
    
    emailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
    
    inputPanel.add(emailLabel);



    JTextField emailField = new JTextField();

    emailField.setBounds(140, 70, 200, 30);

    inputPanel.add(emailField);



    JLabel phoneLabel = new JLabel("Phone:");

    phoneLabel.setBounds(30, 110, 100, 30);

    phoneLabel.setForeground(Color.BLUE);
    
    phoneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    inputPanel.add(phoneLabel);



    JTextField phoneField = new JTextField();

    phoneField.setBounds(140, 110, 200, 30);

    inputPanel.add(phoneField);
    

    JLabel eduLabel = new JLabel("Education:");

    eduLabel.setBounds(30, 190, 100, 30);

    eduLabel.setForeground(Color.BLUE);
    eduLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    inputPanel.add(eduLabel);



    JTextArea eduArea = new JTextArea();
    eduArea.setLineWrap(true);
    eduArea.setWrapStyleWord(true);
    JScrollPane eduScroll = new JScrollPane(eduArea);
    eduScroll.setBounds(140, 190, 400, 60);
    eduScroll.setBorder(BorderFactory.createTitledBorder("Write your education"));
    inputPanel.add(eduScroll);



    JLabel skillLabel = new JLabel("Skills:");

    skillLabel.setBounds(30, 260, 100, 30);

    skillLabel.setForeground(Color.BLUE);
    
    skillLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    inputPanel.add(skillLabel);



    JTextArea skillArea = new JTextArea();
    skillArea.setLineWrap(true);
    skillArea.setWrapStyleWord(true);
    JScrollPane skillScroll = new JScrollPane(skillArea);
    skillScroll.setBounds(140, 270, 400, 60);
    skillScroll.setBorder(BorderFactory.createTitledBorder("Write your skills"));
    inputPanel.add(skillScroll);
    


    JLabel projLabel = new JLabel("Projects:");

    projLabel.setBounds(30, 330, 100, 30);

    projLabel.setForeground(Color.BLUE);
    projLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

    inputPanel.add(projLabel);



    JTextArea projArea = new JTextArea();
    projArea.setLineWrap(true);
    projArea.setWrapStyleWord(true);
    JScrollPane projScroll = new JScrollPane(projArea);
    projScroll.setBounds(140, 350, 400, 60);
    projScroll.setBorder(BorderFactory.createTitledBorder("Write your projects"));
    inputPanel.add(projScroll);

    
    JLabel genderLabel = new JLabel("Gender:");
    genderLabel.setBounds(30, 150, 100, 30);
    genderLabel.setForeground(Color.BLUE);
    genderLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
    inputPanel.add(genderLabel);

    String[] genders = {"Select", "Male", "Female", "Other"};
    JComboBox<String> genderBox = new JComboBox<>(genders);
    genderBox.setBounds(140, 150, 200, 30);
    inputPanel.add(genderBox);


    JLabel dobLabel = new JLabel("Date Of Birth :");
    dobLabel.setBounds(360, 30, 100, 30);
    dobLabel.setForeground(Color.BLUE);
    dobLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
    inputPanel.add(dobLabel);

    JTextField dobField = new JTextField();
    dobField.setBounds(460, 30, 100, 30);
    inputPanel.add(dobField);

    JButton previewButton = new JButton("Preview");

    previewButton.setBounds(140, 430, 100, 40);

    inputPanel.add(previewButton);


    JPanel previewPanel = new JPanel(null);
   
    previewPanel.setBackground(new Color(255, 250, 240)); 




    JLabel titleLabel = new JLabel("==== Output page ====");

    titleLabel.setBounds(30, 20, 300, 30);

    titleLabel.setForeground(new Color(128, 0, 128));

    previewPanel.add(titleLabel);



    JTextArea previewArea = new JTextArea();

    previewArea.setEditable(false);

    previewArea.setBounds(30, 60, 520, 380);

    previewPanel.add(previewArea);

    


    JButton backButton = new JButton("Back");

    backButton.setBounds(450, 20, 80, 30);

    previewPanel.add(backButton);



    mainPanel.add(inputPanel, "Input");

    mainPanel.add(previewPanel, "Preview");



    frame.add(mainPanel);

    frame.setVisible(true);



    previewButton.addActionListener(e -> {
    	
    	    String name = nameField.getText().trim();
    	    String email = emailField.getText().trim();
    	    String phone = phoneField.getText().trim();
    	    String education = eduArea.getText().trim();
    	    String skills = skillArea.getText().trim();
    	    String projects = projArea.getText().trim();

    	    
    		if (nameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()) {
        	    JOptionPane.showMessageDialog(frame, "Please fill in all required fields: Name, Email, and Phone.", "Missing Information", JOptionPane.ERROR_MESSAGE);
        	    return;
        	}
        	if (!emailField.getText().trim().contains("@") || !emailField.getText().trim().contains(".")) {
        	    JOptionPane.showMessageDialog(frame, "Invalid Email format.", "Error", JOptionPane.ERROR_MESSAGE);
        	    return;
        	}
        	if (!phoneField.getText().trim().matches("\\d{11}")) {
        	    JOptionPane.showMessageDialog(frame, "Phone must be exactly 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
        	    return;
        	}
        	if (genderBox.getSelectedItem().equals("Select")) {
        	    JOptionPane.showMessageDialog(frame, "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
        	    return;
        	}

    	    String gender = (String) genderBox.getSelectedItem();




    	    String cvText = "===== CV Preview =====\n\n"
    	            + "👤 Name: " + name + "\n"
    	            + "📧 Email: " + email + "\n"
    	            + "📞 Phone: " + phone + "\n"
    	            + "⚥ Gender: " + gender + "\n\n"  
    	            + "🎓 Education:\n" + education + "\n\n"
    	            + "🛠 Skills:\n" + skills + "\n\n"
    	            + "💼 Projects:\n" + projects + "\n";


        previewArea.setText(cvText);

       

        cardLayout.show(mainPanel, "Preview");

    });

    

    backButton.addActionListener(e -> {

        cardLayout.show(mainPanel, "Input");

    });





}

}