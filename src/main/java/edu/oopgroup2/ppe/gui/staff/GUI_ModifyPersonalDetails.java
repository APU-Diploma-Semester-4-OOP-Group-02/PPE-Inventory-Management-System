package edu.oopgroup2.ppe.gui.staff;

import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.model.staffadmin.StaffAdminManagement;
import edu.oopgroup2.ppe.model.staffadmin.User;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class GUI_ModifyPersonalDetails extends javax.swing.JFrame {
    private static boolean passwordRequirement = false;
    private String originalName, originalEmail, originalContact;
    
    public GUI_ModifyPersonalDetails() {
        initComponents();
        setLocationRelativeTo(null);  
        tf_UserID.setEnabled(false);
        tf_Username.setEnabled(false);
        loadStaffData();
    }
    
    private void loadStaffData() {
        String userID = UserSession.getUserID();
        List<User> searchResults = StaffAdminManagement.searchUser(userID, "Staff");
        if (!searchResults.isEmpty()) {
            User staff = searchResults.get(0);
            tf_UserID.setText(staff.getID());
            tf_Username.setText(staff.getName());
            tf_Email.setText(staff.getEmail());
            tf_Contact.setText(staff.getContact());
            pf_OldPassword.setText("");
            pf_NewPassword.setText("");
            pf_ConfirmedPassword.setText("");
            originalName = staff.getName();
            originalEmail = staff.getEmail();
            originalContact = staff.getContact();
        } else {
            JOptionPane.showMessageDialog(this, "Staff data not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (!passwordRequirement) {
            Timer timer = new Timer(800, e -> {
                JOptionPane.showMessageDialog(this, "PS. Password Requirement \n1. Contain at least 8 characters \n2. Contain both uppercase and lowercase letters \n3. Contain both letters and numbers", "Modify password", JOptionPane.INFORMATION_MESSAGE);
                passwordRequirement = true;
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    private void saveData() {
        String userID = UserSession.getUserID();
        String name = tf_Username.getText().trim();
        String email = tf_Email.getText().trim();
        String contact = tf_Contact.getText().trim();
        String oldPassword = new String(pf_OldPassword.getPassword());
        String newPassword = new String(pf_NewPassword.getPassword());
        String confirmPassword = new String(pf_ConfirmedPassword.getPassword());
        boolean nameChanged = !name.equals(originalName);
        boolean emailChanged = !email.equals(originalEmail);
        boolean contactChanged = !contact.equals(originalContact);
        boolean passwordChanged = !newPassword.isEmpty();
        String result = "No changes detected.";
        if (nameChanged || emailChanged || contactChanged || passwordChanged) {
            if (nameChanged) {
                result = StaffAdminManagement.staffModify(userID, "name", name, oldPassword, confirmPassword);
                if (result.contains("successfully")) {
                    originalName = name;
                }
            }
            if (emailChanged) {
                result = StaffAdminManagement.staffModify(userID, "email", email, oldPassword, confirmPassword);
                if (result.contains("successfully")) {
                    originalEmail = email;
                }
            }
            if (contactChanged) {
                result = StaffAdminManagement.staffModify(userID, "contact", contact, oldPassword, confirmPassword);
                if (result.contains("successfully")) {
                    originalContact = contact;
                }
            }
            if (passwordChanged) {
                result = StaffAdminManagement.staffModify(userID, "password", newPassword, oldPassword, confirmPassword);
            }
        }
        JOptionPane.showMessageDialog(this, result);
        loadStaffData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UE_btn_Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ModifyPersonalDetails = new javax.swing.JPanel();
        lbl_ConfirmPassword = new javax.swing.JLabel();
        lbl_Username = new javax.swing.JLabel();
        lbl_Email = new javax.swing.JLabel();
        lbl_Contact = new javax.swing.JLabel();
        lbl_OldPassword = new javax.swing.JLabel();
        lbl_NewPassword = new javax.swing.JLabel();
        tf_Contact = new javax.swing.JTextField();
        tf_Username = new javax.swing.JTextField();
        tf_Email = new javax.swing.JTextField();
        pf_ConfirmedPassword = new javax.swing.JPasswordField();
        pf_OldPassword = new javax.swing.JPasswordField();
        pf_NewPassword = new javax.swing.JPasswordField();
        btn_Save = new javax.swing.JButton();
        lbl_UserID = new javax.swing.JLabel();
        tf_UserID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_btn_Back.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Back.setText("Back");
        UE_btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_BackActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 100, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modify Personal Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 300, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        ModifyPersonalDetails.setBackground(new java.awt.Color(224, 247, 250));
        ModifyPersonalDetails.setMinimumSize(new java.awt.Dimension(800, 390));
        ModifyPersonalDetails.setPreferredSize(new java.awt.Dimension(800, 390));
        ModifyPersonalDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ConfirmPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_ConfirmPassword.setText("Confirmed Password:");
        ModifyPersonalDetails.add(lbl_ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 250, 145, 15));

        lbl_Username.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_Username.setText("Username:");
        ModifyPersonalDetails.add(lbl_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 145, 15));

        lbl_Email.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_Email.setText("Email:");
        ModifyPersonalDetails.add(lbl_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 145, 15));

        lbl_Contact.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_Contact.setText("Contact:");
        ModifyPersonalDetails.add(lbl_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 145, 15));

        lbl_OldPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_OldPassword.setText("Old Password:");
        ModifyPersonalDetails.add(lbl_OldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 130, 145, 15));

        lbl_NewPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_NewPassword.setText("New Password:");
        ModifyPersonalDetails.add(lbl_NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 190, 145, 15));
        ModifyPersonalDetails.add(tf_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 245, 145, 25));

        tf_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_UsernameActionPerformed(evt);
            }
        });
        ModifyPersonalDetails.add(tf_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 125, 145, 25));
        ModifyPersonalDetails.add(tf_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 185, 145, 25));
        ModifyPersonalDetails.add(pf_ConfirmedPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 245, 145, 25));
        ModifyPersonalDetails.add(pf_OldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 125, 145, 25));
        ModifyPersonalDetails.add(pf_NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 185, 145, 25));

        btn_Save.setFont(new java.awt.Font("Tw Cen MT", 2, 16)); // NOI18N
        btn_Save.setText("Save");
        btn_Save.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                btn_SaveAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        ModifyPersonalDetails.add(btn_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 80, 30));

        lbl_UserID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_UserID.setText("User ID:");
        ModifyPersonalDetails.add(lbl_UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 145, 15));

        tf_UserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_UserIDActionPerformed(evt);
            }
        });
        ModifyPersonalDetails.add(tf_UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 65, 145, 25));

        getContentPane().add(ModifyPersonalDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UE_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_BackActionPerformed
        // TODO add your handling code here:
        new GUI_StaffDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UE_btn_BackActionPerformed

    private void btn_SaveAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btn_SaveAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SaveAncestorMoved

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void tf_UserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_UserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_UserIDActionPerformed

    private void tf_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_UsernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ModifyPersonalDetails;
    private javax.swing.JButton UE_btn_Back;
    private javax.swing.JButton btn_Save;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_ConfirmPassword;
    private javax.swing.JLabel lbl_Contact;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_NewPassword;
    private javax.swing.JLabel lbl_OldPassword;
    private javax.swing.JLabel lbl_UserID;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JPasswordField pf_ConfirmedPassword;
    private javax.swing.JPasswordField pf_NewPassword;
    private javax.swing.JPasswordField pf_OldPassword;
    private javax.swing.JTextField tf_Contact;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_UserID;
    private javax.swing.JTextField tf_Username;
    // End of variables declaration//GEN-END:variables

    
}
