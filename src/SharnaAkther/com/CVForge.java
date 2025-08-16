package SharnaAkther.com;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CVForge {
    public static JFrame frame;
    public static String imagePath = null;
    public static CardLayout cardLayout;
    public static JPanel framePanel;
    public static MainPanel mainPanel;
    public static PreviewPanel previewPanel;

    public static void main(String[] args) {
    	
        frame = new JFrame("CV Forge");

        mainPanel = new MainPanel();
        previewPanel = new PreviewPanel();
        cardLayout = new CardLayout();
        framePanel = new JPanel(cardLayout);

        // Add panels to CardLayout
        
        framePanel.add(mainPanel.namePanel, "name");
        framePanel.add(mainPanel.qualificationPanel, "qualification");
        framePanel.add(mainPanel.personalPanel, "personal");
        framePanel.add(previewPanel.previewPanel, "preview");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(framePanel);
        frame.setSize(850, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}