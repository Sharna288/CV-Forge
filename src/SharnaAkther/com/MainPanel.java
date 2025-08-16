package SharnaAkther.com;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MainPanel {
	
    // Panels
	
    JPanel namePanel = new JPanel();
    JPanel qualificationPanel = new JPanel();
    JPanel personalPanel = new JPanel();

    // Name Panel Components
    
    JLabel headerTitle = new JLabel("CV Information Form");
    JLabel nameLabel = new JLabel("Name     :");
    JTextField nameField = new JTextField();
    JLabel emailLabel = new JLabel("Email     :");
    JTextField emailField = new JTextField();
    JLabel phoneLabel = new JLabel("Phone    :");
    JTextField phoneField = new JTextField();

    JLabel addressLabel = new JLabel("Address :");
    JTextArea addressArea = new JTextArea();
    JButton nextButtonN = new JButton("Next");

    // Qualification Panel Components
    
    JLabel objLabel = new JLabel("Objective:");
    JTextArea objArea = new JTextArea();
    JLabel eduLabel = new JLabel("Education:");
    JTextArea eduArea = new JTextArea();
    JLabel skillLabel = new JLabel("Skills   :");
    JTextArea skillArea = new JTextArea();
    // Language Selection
    JLabel langLabel = new JLabel("Languages:");
    String[] languages = {"English", "Bengali", "Hindi", "French", "Spanish"};
    JList<String> langList = new JList<>(languages); 
  

    String[] proficiency = {"Basic", "Conversational", "Fluent", "Native"};
    JComboBox<String> profCombo = new JComboBox<>(proficiency);

    JButton addLangButton = new JButton("Add Language");

    // Table for storing selected languages + proficiency
    String[] columns = {"Language", "Proficiency"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable langTable = new JTable(model);
    JScrollPane tableScroll = new JScrollPane(langTable);

    JTextArea langArea = new JTextArea();
    JLabel projLabel = new JLabel("Projects :");
    JTextArea projArea = new JTextArea();
    JButton backButtonQ = new JButton("Back");
    JButton nextButtonQ = new JButton("Next");

    // Personal Panel Components
    
    JLabel fatherLabel = new JLabel("Father's Name:");
    JTextField fatherField = new JTextField();
    JLabel motherLabel = new JLabel("Mother's Name:");
    JTextField motherField = new JTextField();
    JLabel paddressLabel = new JLabel("Permanent Address:");
    JTextField paddressField = new JTextField();
    JTextField villField = new JTextField();
    JTextField poField = new JTextField();
    JTextField thanaField = new JTextField();
    JTextField distField = new JTextField();
    JLabel genderLabel = new JLabel("Gender :");
    String[] genders = {"Select", "Male", "Female", "Other"};
    JComboBox<String> genderBox = new JComboBox<>(genders);
    JLabel dobLabel = new JLabel("Date Of Birth:");
    JTextField dobField = new JTextField();
    JLabel contactLabel = new JLabel("Contact No :");
    JTextField contactField = new JTextField();
    JLabel nidLabel = new JLabel("National ID:");
    JTextField nidField = new JTextField();
    JLabel nationalityLabel = new JLabel("Nationality:");
    JTextField nationalityField = new JTextField();
    JLabel religionLabel = new JLabel("Religion:");
    JTextField religionField = new JTextField();
    JLabel bloodLabel = new JLabel("Blood Group:");
    public JComboBox<String> bloodCombo;
    JCheckBox declarationCheckBox = new JCheckBox("I hereby certify that the above information is true and I will render my service to the best of my ability.");
    JButton addPhotoButton = new JButton("Add Photo");
    JButton backButtonP = new JButton("Back");
    JButton previewButton = new JButton("Preview");

    MainPanel() {
    	
        setupNamePanel();
        setupQualificationPanel();
        setupPersonalPanel();
        setupActionListeners();
    }

    private void setupNamePanel() {
    	
        namePanel.setLayout(null);
        namePanel.setBackground(new Color(255, 250, 240));

        // Header
        headerTitle.setBounds(300, 25, 300, 40);
        headerTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        headerTitle.setForeground(new Color(0, 102, 204));
        namePanel.add(headerTitle);

        // Name
        nameLabel.setBounds(100, 90, 100, 40);
        nameLabel.setForeground(new Color(0, 102, 204));
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        namePanel.add(nameLabel);
        nameField.setBounds(200, 100, 400, 30);
        namePanel.add(nameField);

        // Email
        emailLabel.setBounds(100, 140, 100, 40);
        emailLabel.setForeground(new Color(0, 102, 204));
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        namePanel.add(emailLabel);
        emailField.setBounds(200, 150, 400, 30);
        namePanel.add(emailField);

        // Phone
        phoneLabel.setBounds(100, 190, 100, 40);
        phoneLabel.setForeground(new Color(0, 102, 204));
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        namePanel.add(phoneLabel);
        phoneField.setBounds(200, 200, 400, 30);
        namePanel.add(phoneField);

        // Address
        addressLabel.setBounds(100, 240, 100, 40);
        addressLabel.setForeground(new Color(0, 102, 204));
        addressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        namePanel.add(addressLabel);

        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addressScroll = new JScrollPane(addressArea);
        addressScroll.setBounds(200, 250, 400, 60);
        addressScroll.setBorder(BorderFactory.createTitledBorder("Enter your mailing address"));
        namePanel.add(addressScroll);

        // Next Button
        nextButtonN.setBounds(550, 500, 100, 35);
        nextButtonN.setBackground(new Color(120, 148, 255));
        nextButtonN.setForeground(Color.WHITE);
        namePanel.add(nextButtonN);
    }

    private void setupQualificationPanel() {
        qualificationPanel.setLayout(null);
        qualificationPanel.setBackground(new Color(255, 250, 240));

        // Title
        JLabel qualTitle = new JLabel("Qualification Details");
        qualTitle.setBounds(300, 25, 300, 40);
        qualTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        qualTitle.setForeground(new Color(0, 102, 204));
        qualificationPanel.add(qualTitle);

        // Objective
        objLabel.setBounds(100, 90, 100, 30);
        objLabel.setForeground(new Color(0, 102, 204));
        objLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        qualificationPanel.add(objLabel);

        objArea.setLineWrap(true);
        objArea.setWrapStyleWord(true);
        JScrollPane objScroll = new JScrollPane(objArea);
        objScroll.setBounds(190, 90, 400, 60);
        objScroll.setBorder(BorderFactory.createTitledBorder("Write your career objective"));
        qualificationPanel.add(objScroll);

        // Education
        eduLabel.setBounds(100, 160, 100, 30);
        eduLabel.setForeground(new Color(0, 102, 204));
        eduLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        qualificationPanel.add(eduLabel);

        eduArea.setLineWrap(true);
        eduArea.setWrapStyleWord(true);
        JScrollPane eduScroll = new JScrollPane(eduArea);
        eduScroll.setBounds(190, 160, 400, 60);
        eduScroll.setBorder(BorderFactory.createTitledBorder("Write Your Academic Details"));
        qualificationPanel.add(eduScroll);

        // Skills
        skillLabel.setBounds(100, 230, 100, 30);
        skillLabel.setForeground(new Color(0, 102, 204));
        skillLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        qualificationPanel.add(skillLabel);

        skillArea.setLineWrap(true);
        skillArea.setWrapStyleWord(true);
        JScrollPane skillScroll = new JScrollPane(skillArea);
        skillScroll.setBounds(190, 230, 400, 60);
        skillScroll.setBorder(BorderFactory.createTitledBorder("Write your skills"));
        qualificationPanel.add(skillScroll);

        // Language
        langLabel.setBounds(100, 380, 100, 30);
        langLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        langLabel.setForeground(new Color(0, 102, 204));
        qualificationPanel.add(langLabel);

        // JList for language (scrollable, small height like dropdown)
        langList.setVisibleRowCount(1); 
        langList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScroll = new JScrollPane(langList);
        listScroll.setBounds(190, 380, 150, 30);  
        qualificationPanel.add(listScroll);

        // ComboBox for proficiency
        profCombo.setBounds(360, 380, 150, 30);
        qualificationPanel.add(profCombo);

        // Add button
        addLangButton.setBounds(520, 380, 120, 30);
        qualificationPanel.add(addLangButton);

        // JTable for selected languages
        tableScroll.setBounds(190, 420, 450, 60);
        qualificationPanel.add(tableScroll);

        // ActionListener
        addLangButton.addActionListener(e -> {
            List<String> selectedLangs = langList.getSelectedValuesList();
            String prof = (String) profCombo.getSelectedItem();
            for(String lang : selectedLangs){
                boolean exists = false;
                for(int i = 0; i < model.getRowCount(); i++){
                    if(model.getValueAt(i, 0).equals(lang)) {
                        exists = true; break;
                    }
                }
                if(!exists){
                    model.addRow(new Object[]{lang, prof});
                }
            }
        });

        // Project section (moved down to avoid overlap)
        projLabel.setBounds(100, 300, 100, 30); 
        projLabel.setForeground(new Color(0, 102, 204));
        projLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        qualificationPanel.add(projLabel);

        projArea.setLineWrap(true);
        projArea.setWrapStyleWord(true);
        JScrollPane projScroll = new JScrollPane(projArea);
        projScroll.setBounds(190, 300, 400, 60); 
        projScroll.setBorder(BorderFactory.createTitledBorder("Write your projects"));
        qualificationPanel.add(projScroll);

        
   

        // Buttons
        backButtonQ.setBounds(450, 500, 100, 35);
        backButtonQ.setBackground(new Color(120, 148, 255));
        backButtonQ.setForeground(Color.WHITE);
        qualificationPanel.add(backButtonQ);

        nextButtonQ.setBounds(550, 500, 100, 35);
        nextButtonQ.setBackground(new Color(120, 148, 255));
        nextButtonQ.setForeground(Color.WHITE);
        qualificationPanel.add(nextButtonQ);
    }

    private void setupPersonalPanel() {
        personalPanel.setLayout(null);
        personalPanel.setBackground(new Color(255, 250, 240));

        // Title
        JLabel personalTitle = new JLabel("Personal Information");
        personalTitle.setBounds(300, 25, 300, 40);
        personalTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        personalTitle.setForeground(new Color(0, 102, 204));
        personalPanel.add(personalTitle);

        // Father's Name
        fatherLabel.setBounds(60, 90, 120, 25);
        fatherLabel.setForeground(new Color(0, 102, 204));
        fatherLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(fatherLabel);
        fatherField.setBounds(210, 95, 200, 25);
        personalPanel.add(fatherField);

        // Mother's Name
        motherLabel.setBounds(60, 130, 120, 25);
        motherLabel.setForeground(new Color(0, 102, 204));
        motherLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(motherLabel);
        motherField.setBounds(210, 135, 200, 25);
        personalPanel.add(motherField);
        
        // National ID
        nidLabel.setBounds(60, 170, 120, 25);
        nidLabel.setForeground(new Color(0, 102, 204));
        nidLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(nidLabel);
        nidField.setBounds(210, 175, 200, 25);
        personalPanel.add(nidField);

        // Nationality
        nationalityLabel.setBounds(430, 90, 120, 25);
        nationalityLabel.setForeground(new Color(0, 102, 204));
        nationalityLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(nationalityLabel);
        nationalityField.setBounds(550, 95, 200, 25);
        personalPanel.add(nationalityField);

        // Religion
        religionLabel.setBounds(430, 130, 120, 25);
        religionLabel.setForeground(new Color(0, 102, 204));
        religionLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(religionLabel);
        religionField.setBounds(550, 135, 200, 25);
        personalPanel.add(religionField);

        // Blood Group
        bloodLabel.setBounds(430, 170, 120, 25);
        bloodLabel.setForeground(new Color(0, 102, 204));
        bloodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(bloodLabel);
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        bloodCombo = new JComboBox<>(bloodGroups);
        bloodCombo.setBounds(550, 170, 200, 25); 
        personalPanel.add(bloodCombo);

        
        // Gender
        genderLabel.setBounds(60, 210, 120, 25);
        genderLabel.setForeground(new Color(0, 102, 204));
        genderLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(genderLabel);
        genderBox.setBounds(210, 215, 200, 25);
        personalPanel.add(genderBox);

        // DOB
        dobLabel.setBounds(430, 210, 120, 25);
        dobLabel.setForeground(new Color(0, 102, 204));
        dobLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(dobLabel);
        dobField.setBounds(550, 215, 200, 25);
        personalPanel.add(dobField);
        
        // Contact No.
        contactLabel.setBounds(60, 250, 150, 25);
        contactLabel.setForeground(new Color(0, 102, 204));
        contactLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(contactLabel);
        contactField.setBounds(210, 255, 200, 25);
        personalPanel.add(contactField);
        
        // Permanent Address
        paddressLabel.setBounds(60, 290, 150, 25);
        paddressLabel.setForeground(new Color(0, 102, 204));
        paddressLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(paddressLabel);

        
        // Village
        JLabel villLabel = new JLabel("Village:");
        villLabel.setBounds(150, 325, 70, 25);
        villLabel.setForeground(new Color(0, 102, 204));
        villLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(villLabel);
        villField.setBounds(220, 325, 150, 25);
        personalPanel.add(villField);

        // P.O
        JLabel poLabel = new JLabel("P.O:");
        poLabel.setBounds(390, 325, 70, 25);
        poLabel.setForeground(new Color(0, 102, 204));
        poLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(poLabel);
        poField.setBounds(450, 325, 150, 25);
        personalPanel.add(poField);

        // Thana
        JLabel thanaLabel = new JLabel("Thana:");
        thanaLabel.setBounds(150, 360, 50, 25);
        thanaLabel.setForeground(new Color(0, 102, 204));
        thanaLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(thanaLabel);
        thanaField.setBounds(220, 360, 150, 25);
        personalPanel.add(thanaField);

        // District
        JLabel distLabel = new JLabel("District:");
        distLabel.setBounds(390, 360, 60, 25);
        distLabel.setForeground(new Color(0, 102, 204));
        distLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        personalPanel.add(distLabel);
        distField.setBounds(450, 360, 150, 25);
        personalPanel.add(distField);



        // Declaration
        declarationCheckBox.setBounds(60, 400, 800, 30);
        personalPanel.add(declarationCheckBox);
        
        // Add Photo Button
        addPhotoButton.setBounds(60, 440, 120, 35);
        addPhotoButton.setBackground(new Color(120, 148, 255));
        addPhotoButton.setForeground(Color.WHITE);
        personalPanel.add(addPhotoButton);

        // Buttons
        backButtonP.setBounds(450, 500, 100, 35);
        backButtonP.setBackground(new Color(120, 148, 255));
        backButtonP.setForeground(Color.WHITE);
        personalPanel.add(backButtonP);

        previewButton.setBounds(550, 500, 100, 35);
        previewButton.setBackground(new Color(120, 148, 255));
        previewButton.setForeground(Color.WHITE);
        personalPanel.add(previewButton);
    }

    private void setupActionListeners() { 
    	
        // Navigation buttons
        nextButtonN.addActionListener(e -> {
            if (validateNamePanel()) {
                CVForge.cardLayout.show(CVForge.framePanel, "qualification");
            }
        });

        backButtonQ.addActionListener(e -> {
            CVForge.cardLayout.show(CVForge.framePanel, "name");
        });

        nextButtonQ.addActionListener(e -> {
            CVForge.cardLayout.show(CVForge.framePanel, "personal");
        });

        backButtonP.addActionListener(e -> {
            CVForge.cardLayout.show(CVForge.framePanel, "qualification");
        });

        // Add Photo Action
        addPhotoButton.addActionListener(e -> {
            addPhotoAction();
        });

        // Preview Button Action
        previewButton.addActionListener(e -> {
            if (validateAllFields()) {
                generatePreview();
                CVForge.cardLayout.show(CVForge.framePanel, "preview");
            }
        });
    }

    private boolean validateNamePanel() {
        if (nameField.getText().trim().isEmpty() ||
                emailField.getText().trim().isEmpty() ||
                phoneField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(CVForge.frame,
                    "Please fill in all required fields: Name, Email, and Phone.",
                    "Missing Information", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!emailField.getText().trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ) {
            JOptionPane.showMessageDialog(CVForge.frame,
                    "Invalid Email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!phoneField.getText().trim().matches("01\\d{9}")) {
            JOptionPane.showMessageDialog(CVForge.frame,
            		"Phone must start with 01 and be exactly 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean validateAllFields() {
    	
        if (Objects.equals(genderBox.getSelectedItem(), "Select")) {
            JOptionPane.showMessageDialog(CVForge.frame,
                    "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return validateNamePanel(); // Add more validation as needed
    }

    void addPhotoAction() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a photo");
        
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter(
                        "Image Files", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        
        int userSelection = fileChooser.showOpenDialog(CVForge.frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            CVForge.imagePath = file.getAbsolutePath();
            JOptionPane.showMessageDialog(CVForge.frame,
                    "Photo selected successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void generatePreview() {
        // Clear previous content
        CVForge.previewPanel.cvContentPanel.removeAll();
        CVForge.previewPanel.cvContentPanel.setLayout(new GridBagLayout());
        CVForge.previewPanel.cvContentPanel.setBackground(Color.WHITE);

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String dob = dobField.getText().trim();
        String gender = (String) genderBox.getSelectedItem();
        String address = addressArea.getText().trim();
        String objective = objArea.getText().trim();
        String education = eduArea.getText().trim();
        String skills = skillArea.getText().trim();
        String projects = projArea.getText().trim();

        String father = fatherField.getText().trim();
        String mother = motherField.getText().trim();
        String nid = nidField.getText().trim();
        String nationality = nationalityField.getText().trim();
        String religion = religionField.getText().trim();
        String blood = (String) bloodCombo.getSelectedItem();
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;

        int y = 0;

        // Name and Photo Header
        JPanel namePhotoPanel = new JPanel(new GridBagLayout());
        namePhotoPanel.setBackground(Color.WHITE);

        GridBagConstraints namePhotoGbc = new GridBagConstraints();
        namePhotoGbc.insets = new Insets(0, 0, 0, 10);
        namePhotoGbc.anchor = GridBagConstraints.WEST;
        namePhotoGbc.fill = GridBagConstraints.HORIZONTAL;

        // Name and Contact Info Panel
        JPanel nameContactPanel = new JPanel();
        nameContactPanel.setLayout(new BoxLayout(nameContactPanel, BoxLayout.Y_AXIS));
        nameContactPanel.setBackground(Color.WHITE);
        GridBagConstraints nameContactGbc = new GridBagConstraints();
        nameContactGbc.insets = new Insets(5, 0, 0, 0);
        nameContactGbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabelPreview = new JLabel(name);
        nameLabelPreview.setFont(new Font("SansSerif", Font.BOLD, 24));
        nameContactGbc.gridy = 0;
        nameContactPanel.add(nameLabelPreview, nameContactGbc);

        JLabel contactLabelPreview = new JLabel("<html>Email: <font color='blue'>" + email +
                "</font><br>Phone: " + phone + "<br>Address: " + address + "</html>");

        contactLabelPreview.setFont(new Font("SansSerif", Font.PLAIN, 12));
        nameContactGbc.gridy = 1;
        nameContactPanel.add(contactLabelPreview, nameContactGbc);

        namePhotoGbc.gridx = 0;
        namePhotoGbc.weightx = 1.0;
        namePhotoPanel.add(nameContactPanel, namePhotoGbc);

        if (CVForge.imagePath != null) {
            try {
                ImageIcon originalIcon = new ImageIcon(CVForge.imagePath);
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                JLabel photoLabel = new JLabel(resizedIcon);

                namePhotoGbc.gridx = 1;
                namePhotoGbc.weightx = 0.0;
                namePhotoGbc.anchor = GridBagConstraints.EAST;
                namePhotoPanel.add(photoLabel, namePhotoGbc);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        gbc.gridy = y++;
        CVForge.previewPanel.cvContentPanel.add(namePhotoPanel, gbc);

        // Objective Section
        if (objective != null && !objective.trim().isEmpty()) {
            addSection("🎯 OBJECTIVE", objective, gbc, y++);
        }
        
        // Academic Background Section
        if (education != null && !education.trim().isEmpty()) {
            addSection("🎓 ACADEMIC BACKGROUND", education, gbc, y++);
        }

        // Language Skills Section

        if(model.getRowCount() > 0){
            StringBuilder langContent = new StringBuilder();
            for(int i=0; i<model.getRowCount(); i++){
                langContent.append(model.getValueAt(i, 0)).append(" - ")
                           .append(model.getValueAt(i, 1)).append("\n");
            }
            addSection("🌐 LANGUAGE SKILLS", langContent.toString(), gbc, y++);
        }

        // Skills Section
        if (skills != null && !skills.trim().isEmpty()) {
            addSection("🛠 SKILLS", skills, gbc, y++);
        }

        // Projects Section
        if (projects != null && !projects.trim().isEmpty()) {
            addSection("💼 PROJECTS", projects, gbc, y++);
        }

        // Personal Info Section
        if ((father != null && !father.trim().isEmpty()) ||
            (mother != null && !mother.trim().isEmpty()) ||
            (gender != null && !gender.trim().isEmpty()) ||
            (dob != null && !dob.trim().isEmpty()) ||
            (nid != null && !nid.trim().isEmpty()) ||
            (nationality != null && !nationality.trim().isEmpty()) ||
            (religion != null && !religion.trim().isEmpty()) ||
            (blood != null && !blood.trim().isEmpty()) ||
            (address != null && !address.trim().isEmpty()) ||
            (phone != null && !phone.trim().isEmpty())) {

            String personalInfo = "";
            if(father != null && !father.trim().isEmpty()) personalInfo +=           "Father's Name : " + father + "\n";
            if(mother != null && !mother.trim().isEmpty()) personalInfo +=           "Mother's Name : " + mother + "\n";
            if(gender != null && !gender.trim().isEmpty()) personalInfo +=           "Gender        : " + gender + "\n";
            if(dob != null && !dob.trim().isEmpty()) personalInfo +=                 "Date of Birth : " + dob + "\n";
            if(nid != null && !nid.trim().isEmpty()) personalInfo +=                 "National ID   : " + nid + "\n";
            if(nationality != null && !nationality.trim().isEmpty()) personalInfo += "Nationality   : " + nationality + "\n";
            if(religion != null && !religion.trim().isEmpty()) personalInfo +=       "Religion      : " + religion + "\n";
            if(blood != null && !blood.trim().isEmpty()) personalInfo +=             "Blood Group   : " + blood + "\n";
            String permAddress = "";
            if(!villField.getText().trim().isEmpty()) permAddress +=                 "Village       : " + villField.getText().trim() + ", ";
            if(!poField.getText().trim().isEmpty()) permAddress +=                   "P.O           : " + poField.getText().trim() + ", "+"\n";
            if(!thanaField.getText().trim().isEmpty()) permAddress +=                "Thana         : " + thanaField.getText().trim() + ", ";
            if(!distField.getText().trim().isEmpty()) permAddress +=                 "District      : " + distField.getText().trim();

            if(!permAddress.isEmpty()) personalInfo += "Permanent Address: " + permAddress + "\n";

            if(phone != null && !phone.trim().isEmpty()) personalInfo += "Contact No.: " + phone + "\n";

            addSection("👪 PERSONAL INFORMATION", personalInfo, gbc, y++);
        }

        if (declarationCheckBox.isSelected()) {
            addSection("📢 DECLARATION",
                    "I hereby certify that the above information is true and I will render my service to the best of my ability.",
                    gbc, y++);
        }

        CVForge.previewPanel.cvContentPanel.revalidate();
        CVForge.previewPanel.cvContentPanel.repaint();
    }

    private void addSection(String title, String content, GridBagConstraints gbc, int y) {
        // Header
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setBackground(new Color(220, 220, 220));
        JLabel label = new JLabel(title);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.add(label);
        gbc.gridy = y * 2;
        CVForge.previewPanel.cvContentPanel.add(header, gbc);

        // Content
        JTextArea textArea = new JTextArea(content);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEmptyBorder());
        gbc.gridy = y * 2 + 1;
        CVForge.previewPanel.cvContentPanel.add(textArea, gbc);
    }
}
