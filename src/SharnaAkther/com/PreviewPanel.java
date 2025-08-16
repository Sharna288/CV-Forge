package SharnaAkther.com;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PreviewPanel { 
	
	JPanel cvContentPanel = new JPanel();
    JLabel titleLabel = new JLabel("CV Preview", JLabel.CENTER);
    JPanel previewPanel = new JPanel();
    JButton backButton = new JButton("Back");

    JButton savePdfButton = new JButton("Save as PDF");

    PreviewPanel() {
    	
         previewPanel.setLayout(null);
         previewPanel.setBackground(new Color(255, 250, 240));

         JScrollPane contentScrollPane = new JScrollPane(cvContentPanel);
         contentScrollPane.setBounds(50, 60, 750, 550);
         previewPanel.add(contentScrollPane);

         titleLabel.setBounds(300, 15, 300, 40);
         titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
         titleLabel.setForeground(new Color(120, 148, 255));
         previewPanel.add(titleLabel);

         backButton.setBounds(450, 620, 100, 35);
         backButton.setBackground(new Color(120, 148, 255));
         backButton.setForeground(Color.WHITE);
         previewPanel.add(backButton);


         savePdfButton.setBounds(550, 620, 150, 35);
         savePdfButton.setBackground(new Color(120, 148, 255));
         savePdfButton.setForeground(Color.WHITE);
         previewPanel.add(savePdfButton);

         // Action Listeners
         backButton.addActionListener(e -> {
        	 
             CVForge.cardLayout.show(CVForge.framePanel, "personal");
         });

         savePdfButton.addActionListener(e -> {
             SavePDF savePDF = new SavePDF();
         });


       }

}
