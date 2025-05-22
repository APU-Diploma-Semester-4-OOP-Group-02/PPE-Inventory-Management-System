package edu.oopgroup2.ppe.gui.staff;

import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.gui.GUI_Login;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GUI_StaffDashboard extends javax.swing.JFrame {
    
    public GUI_StaffDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        String userID = UserSession.getUserID();
        String userName = UserSession.getUserName();
        lbl_UserInfo.setText(userID + " " + userName);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_UserInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_TrackInventory = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_LogOut = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_ManageInventory = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ModifyPersonalDetails = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_ViewTransaction = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(600, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 110));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 110));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("PPE Inventory Management System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("Staff Dashboard");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 65, -1, -1));

        lbl_UserInfo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        lbl_UserInfo.setForeground(new java.awt.Color(242, 242, 242));
        lbl_UserInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_UserInfo.setText("User ID UserName");
        lbl_UserInfo.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(lbl_UserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 90, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 110));

        jPanel2.setBackground(new java.awt.Color(224, 247, 250));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 240));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_TrackInventory.setBackground(new java.awt.Color(4, 99, 174));
        btn_TrackInventory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_TrackInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TrackInventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TrackInventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TrackInventoryMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Track ");
        btn_TrackInventory.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Inventory");
        btn_TrackInventory.add(jLabel2);

        jPanel2.add(btn_TrackInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 27, 130, 75));

        btn_LogOut.setBackground(new java.awt.Color(4, 99, 174));
        btn_LogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LogOutMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Log Out");
        btn_LogOut.add(jLabel3);

        jPanel2.add(btn_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 130, 75));

        btn_ManageInventory.setBackground(new java.awt.Color(4, 99, 174));
        btn_ManageInventory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_ManageInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ManageInventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ManageInventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ManageInventoryMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Manage");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 26));
        btn_ManageInventory.add(jLabel6);

        jLabel5.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Inventory ");
        btn_ManageInventory.add(jLabel5);

        jPanel2.add(btn_ManageInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 27, 130, 75));

        btn_ModifyPersonalDetails.setBackground(new java.awt.Color(4, 99, 174));
        btn_ModifyPersonalDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_ModifyPersonalDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ModifyPersonalDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ModifyPersonalDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ModifyPersonalDetailsMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Modify Personal");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 26));
        btn_ModifyPersonalDetails.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Details");
        btn_ModifyPersonalDetails.add(jLabel8);

        jPanel2.add(btn_ModifyPersonalDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 27, 130, 75));

        btn_ViewTransaction.setBackground(new java.awt.Color(4, 99, 174));
        btn_ViewTransaction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_ViewTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ViewTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ViewTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ViewTransactionMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("View ");
        btn_ViewTransaction.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Transactions");
        btn_ViewTransaction.add(jLabel10);

        jPanel2.add(btn_ViewTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 130, 75));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 240));

        setBounds(0, 0, 614, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_LogOut.setBackground(color);
    }//GEN-LAST:event_btn_LogOutMouseEntered

    private void btn_ViewTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ViewTransactionMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_ViewTransaction.setBackground(color);
    }//GEN-LAST:event_btn_ViewTransactionMouseEntered

    private void btn_TrackInventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackInventoryMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_TrackInventory.setBackground(color);
    }//GEN-LAST:event_btn_TrackInventoryMouseEntered

    private void btn_ManageInventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageInventoryMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_ManageInventory.setBackground(color);
    }//GEN-LAST:event_btn_ManageInventoryMouseEntered

    private void btn_ModifyPersonalDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModifyPersonalDetailsMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_ModifyPersonalDetails.setBackground(color);
    }//GEN-LAST:event_btn_ModifyPersonalDetailsMouseEntered

    private void btn_ModifyPersonalDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModifyPersonalDetailsMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_ModifyPersonalDetails.setBackground(color);
    }//GEN-LAST:event_btn_ModifyPersonalDetailsMouseExited

    private void btn_ManageInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageInventoryMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_ManageInventory.setBackground(color);
    }//GEN-LAST:event_btn_ManageInventoryMouseExited

    private void btn_ViewTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ViewTransactionMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_ViewTransaction.setBackground(color);
    }//GEN-LAST:event_btn_ViewTransactionMouseExited

    private void btn_LogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_LogOut.setBackground(color);
    }//GEN-LAST:event_btn_LogOutMouseExited

    private void btn_TrackInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackInventoryMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_TrackInventory.setBackground(color);
    }//GEN-LAST:event_btn_TrackInventoryMouseExited

    private void btn_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new GUI_Login().setVisible(true); 
            this.dispose(); 
        }
    }//GEN-LAST:event_btn_LogOutMouseClicked

    private void btn_ModifyPersonalDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModifyPersonalDetailsMouseClicked
        // TODO add your handling code here:
        new GUI_ModifyPersonalDetails().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ModifyPersonalDetailsMouseClicked

    private void btn_ManageInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ManageInventoryMouseClicked
        // TODO add your handling code here:
        new GUI_ManageInventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ManageInventoryMouseClicked

    private void btn_TrackInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackInventoryMouseClicked
        // TODO add your handling code here:
        new GUI_TrackInventory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_TrackInventoryMouseClicked

    private void btn_ViewTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ViewTransactionMouseClicked
        // TODO add your handling code here:
        new GUI_ViewTransaction().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ViewTransactionMouseClicked


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_LogOut;
    private javax.swing.JPanel btn_ManageInventory;
    private javax.swing.JPanel btn_ModifyPersonalDetails;
    private javax.swing.JPanel btn_TrackInventory;
    private javax.swing.JPanel btn_ViewTransaction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_UserInfo;
    // End of variables declaration//GEN-END:variables
}
