package SharnaAkther.com;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SavePDF {

    SavePDF(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save your CV as a PDF File");
        int userSelection = fileChooser.showSaveDialog(CVForge.frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                fileToSave = new File(filePath + ".pdf");
            }

            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();

                // Get data from MainPanel (where the form fields are located)
                MainPanel mp = CVForge.mainPanel;

                String father = mp.fatherField.getText().trim();
                String mother = mp.motherField.getText().trim();
                String nid = mp.nidField.getText().trim();
                String nationality = mp.nationalityField.getText().trim();
                String religion = mp.religionField.getText().trim();
                String blood = (String) mp.bloodCombo.getSelectedItem();
       
                String name = mp.nameField.getText().trim();
                String email = mp.emailField.getText().trim();
                String phone = mp.phoneField.getText().trim();
                String dob = mp.dobField.getText().trim();
                String gender = (String) mp.genderBox.getSelectedItem();
                String address = mp.addressArea.getText().trim();
                String objective = mp.objArea.getText().trim();
                String education = mp.eduArea.getText().trim();
                String skills = mp.skillArea.getText().trim();
                String projects = mp.projArea.getText().trim();
                String languages = mp.langArea.getText().trim();
                String village = mp.villField.getText().trim();
                String po = mp.poField.getText().trim();
                String thana = mp.thanaField.getText().trim();
                String district = mp.distField.getText().trim();

                com.itextpdf.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
                com.itextpdf.text.Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
                com.itextpdf.text.Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

                PdfPTable mainHeaderTable = new PdfPTable(2);
                mainHeaderTable.setWidthPercentage(100);
                mainHeaderTable.setWidths(new float[]{3f, 1f});

                PdfPCell nameCell = new PdfPCell();
                nameCell.setBorder(0);
                nameCell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_TOP);

                // Create paragraphs first, then add to cell
                Paragraph nameParagraph = new Paragraph(name, titleFont);
                nameParagraph.setSpacingAfter(5f);
                nameCell.addElement(nameParagraph);
                
                // Mailing Address Label
                Paragraph mailingLabel = new Paragraph("Mailing Address:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                mailingLabel.setSpacingAfter(2f);
                nameCell.addElement(mailingLabel);

                // User Provided Address
                if(address != null && !address.trim().isEmpty()) {
                    Paragraph mailingAddress = new Paragraph(address, bodyFont);
                    mailingAddress.setSpacingAfter(5f); // thoda space after address
                    nameCell.addElement(mailingAddress);
                }
                
                // Email Label
                Paragraph emailParagraph = new Paragraph();
                Chunk emailLabel = new Chunk("Email: ", FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK));
                Chunk emailValue = new Chunk(email, FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLUE));
                emailParagraph.add(emailLabel);
                emailParagraph.add(emailValue);
                emailParagraph.setSpacingAfter(5f);
                nameCell.addElement(emailParagraph);

                Paragraph phoneParagraph = new Paragraph("Phone: " + phone, bodyFont);
                nameCell.addElement(phoneParagraph);

                // Add the complete nameCell to table
                mainHeaderTable.addCell(nameCell);

                PdfPCell imageCell = new PdfPCell();
                imageCell.setPaddingTop(12);
                imageCell.setBorder(0);
                imageCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                imageCell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_TOP);

                if (CVForge.imagePath != null) {
                    try {
                        com.itextpdf.text.Image photo = com.itextpdf.text.Image.getInstance(CVForge.imagePath);
                        photo.scaleToFit(100, 100);
                        imageCell.addElement(photo);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                mainHeaderTable.addCell(imageCell);

                document.add(mainHeaderTable);
                document.add(new Paragraph("\n"));

                
             // Objective Section
                if (objective != null && !objective.trim().isEmpty()) {
                    PdfPTable objectiveHeaderTable = new PdfPTable(1);
                    objectiveHeaderTable.setWidthPercentage(100);
                    PdfPCell objectiveCell = new PdfPCell(new Paragraph("🎯 OBJECTIVE", headingFont));
                    objectiveCell.setBackgroundColor(new BaseColor(220, 220, 220));
                    objectiveCell.setBorder(0);
                    objectiveHeaderTable.addCell(objectiveCell);
                    document.add(objectiveHeaderTable);
                    document.add(new Paragraph(objective, bodyFont));
                    document.add(new Paragraph("\n"));
                }
                

             // Academic Background Section
             if (education != null && !education.trim().isEmpty()) {
                 PdfPTable educationHeaderTable = new PdfPTable(1);
                 educationHeaderTable.setWidthPercentage(100);
                 PdfPCell educationCell = new PdfPCell(new Paragraph("🎓 ACADEMIC BACKGROUND", headingFont));
                 educationCell.setBackgroundColor(new BaseColor(220, 220, 220));
                 educationCell.setBorder(0);
                 educationHeaderTable.addCell(educationCell);
                 document.add(educationHeaderTable);
                 document.add(new Paragraph(education, bodyFont));
                 document.add(new Paragraph("\n"));
             }


                // Skills Section
                if (skills != null && !skills.trim().isEmpty()) {
                    PdfPTable skillsHeaderTable = new PdfPTable(1);
                    skillsHeaderTable.setWidthPercentage(100);
                    PdfPCell skillsCell = new PdfPCell(new Paragraph("🛠 SKILLS", headingFont));
                    skillsCell.setBackgroundColor(new BaseColor(220, 220, 220));
                    skillsCell.setBorder(0);
                    skillsHeaderTable.addCell(skillsCell);
                    document.add(skillsHeaderTable);
                    document.add(new Paragraph(skills, bodyFont));
                    document.add(new Paragraph("\n"));
                }
                
                // Projects Section
                if (projects != null && !projects.trim().isEmpty()) {
                    PdfPTable projectsHeaderTable = new PdfPTable(1);
                    projectsHeaderTable.setWidthPercentage(100);
                    PdfPCell projectsCell = new PdfPCell(new Paragraph("💼 PROJECTS", headingFont));
                    projectsCell.setBackgroundColor(new BaseColor(220, 220, 220));
                    projectsCell.setBorder(0);
                    projectsHeaderTable.addCell(projectsCell);
                    document.add(projectsHeaderTable);

                    document.add(new Paragraph(projects, bodyFont));
                    document.add(new Paragraph("\n"));
                }
                
               // Collect Languages from JTable (with proficiency)
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mp.model.getRowCount(); i++) {
                    String lang = mp.model.getValueAt(i, 0).toString();
                    String prof = mp.model.getValueAt(i, 1).toString();
                    sb.append(lang).append(" - ").append(prof).append("\n");
                }
                languages = sb.toString(); 
                
                 // Language Skills Section
                if(languages != null && !languages.trim().isEmpty()) {
                    PdfPTable langTable = new PdfPTable(2);
                    langTable.setWidthPercentage(100);
                    String[] langList = languages.split("\n");
                    
                    
                    for(String lang : langList) {
                        String[] parts = lang.split("-");
                        langTable.addCell(new PdfPCell(new Paragraph(parts[0].trim(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12))));
                        langTable.addCell(new PdfPCell(new Paragraph(parts[1].trim(), FontFactory.getFont(FontFactory.HELVETICA, 12))));
                    }
                    
                    PdfPTable langHeaderTable = new PdfPTable(1);
                    langHeaderTable.setWidthPercentage(100);
                    PdfPCell langHeaderCell = new PdfPCell(new Paragraph("🌐 LANGUAGE SKILLS", headingFont));
                    langHeaderCell.setBackgroundColor(new BaseColor(220, 220, 220));
                    langHeaderCell.setBorder(0);
                    langHeaderCell.setPadding(5); 
                    langHeaderTable.addCell(langHeaderCell);
                    document.add(langHeaderTable);
                    document.add(langTable);
                    document.add(new Paragraph("\n"));
                }

 
          // Header
             PdfPTable personalInfoHeaderTable = new PdfPTable(1);
             personalInfoHeaderTable.setWidthPercentage(100);
             PdfPCell personalInfoCell = new PdfPCell(new Paragraph("👪 PERSONAL INFORMATION", headingFont));
             personalInfoCell.setBackgroundColor(new BaseColor(220, 220, 220));
             personalInfoCell.setBorder(0);
             personalInfoHeaderTable.addCell(personalInfoCell);
             document.add(personalInfoHeaderTable);
             document.add(new Paragraph("\n"));

             // Add info neatly
             Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
             Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

             if(father != null && !father.trim().isEmpty())
                 document.add(new Paragraph("Father’s Name : " + father, valueFont));
             if(mother != null && !mother.trim().isEmpty())
                 document.add(new Paragraph("Mother’s Name : " + mother, valueFont));
             if(gender != null && !gender.trim().isEmpty())
                 document.add(new Paragraph("Gender        : " + gender, valueFont));
             if(dob != null && !dob.trim().isEmpty())
                 document.add(new Paragraph("Date of Birth : " + dob, valueFont));
             if(nid != null && !nid.trim().isEmpty())
                 document.add(new Paragraph("National ID   : " + nid, valueFont));
             if(nationality != null && !nationality.trim().isEmpty())
                 document.add(new Paragraph("Nationality   : " + nationality, valueFont));
             if(religion != null && !religion.trim().isEmpty())
                 document.add(new Paragraph("Religion      : " + religion, valueFont));
             if(blood != null && !blood.trim().isEmpty())
                 document.add(new Paragraph("Blood Group   : " + blood, valueFont));

             // Permanent Address
             if((village != null && !village.isEmpty()) || (po != null && !po.isEmpty()) || 
                (thana != null && !thana.isEmpty()) || (district != null && !district.isEmpty())) {
                 Paragraph addrPara = new Paragraph("Permanent Address:", labelFont);
                 document.add(addrPara);

                 StringBuilder addr = new StringBuilder();
                 if(village != null && !village.isEmpty()) addr.append("Village: " + village + ", ");
                 if(po != null && !po.isEmpty()) addr.append("P.O: " + po + ", ");
                 if(thana != null && !thana.isEmpty()) addr.append("Thana: " + thana + ", ");
                 if(district != null && !district.isEmpty()) addr.append("District: " + district);

                 Paragraph addrDetail = new Paragraph(addr.toString(), valueFont);
                 document.add(addrDetail);
             }

             // Contact Number
             if(phone != null && !phone.trim().isEmpty())
                 document.add(new Paragraph("Contact No.   : " + phone, valueFont));

             document.add(new Paragraph("\n"));



                // Declaration section
                if (mp.declarationCheckBox.isSelected()) {
                    PdfPTable declarationHeaderTable = new PdfPTable(1);
                    declarationHeaderTable.setWidthPercentage(100);
                    PdfPCell declarationCell = new PdfPCell(new Paragraph("📢 DECLARATION", headingFont));
                    declarationCell.setBackgroundColor(new BaseColor(220, 220, 220));
                    declarationCell.setBorder(0);
                    declarationHeaderTable.addCell(declarationCell);
                    document.add(declarationHeaderTable);
                    document.add(new Paragraph("I hereby certify that the above information is true and I will render my service to the best of my ability.", bodyFont));
                    document.add(new Paragraph("\n"));
                }

                document.add(new Paragraph("Signed: " + name, bodyFont));

                document.close();
                JOptionPane.showMessageDialog(CVForge.frame, "CV saved successfully to " + fileToSave.getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(CVForge.frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}

