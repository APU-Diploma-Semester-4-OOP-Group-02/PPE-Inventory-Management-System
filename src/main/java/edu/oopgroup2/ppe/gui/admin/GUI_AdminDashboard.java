package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.gui.GUI_Login;
import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GUI_AdminDashboard extends javax.swing.JFrame {
    
    public GUI_AdminDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        String userID = UserSession.getUserID();
        String userName = UserSession.getUserName();
        lbl_UserInfo.setText(userID + " " + userName);
        Timer timer = new Timer(600, e -> {
            checkStockInitialization();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void checkStockInitialization() {
        if (!InventoryManagement.isStockInitialized()) {
            String result = InventoryManagement.initializePPEStock();
            JOptionPane.showMessageDialog(this, result, "Initialize Stock", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this,
                "Stock has been initialized. You can now assign suppliers.",
                "Assign Suppliers",
                JOptionPane.INFORMATION_MESSAGE);
            btn_InventoryManagementMouseClicked(null);
            GUI_InventoryManagement inventoryManagement = new GUI_InventoryManagement();
            Timer timer = new Timer(1000, e -> {
                PopUp_IM_SetSupplier popUp = new PopUp_IM_SetSupplier(inventoryManagement, null);
                popUp.setLocationRelativeTo(this);
                popUp.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_UserInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_TransactionRecords = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_LogOut = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_InventoryManagement = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_UserEntityManagement = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_LogActivities = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_TrackingReport = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 110));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 110));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PPE Inventory Management System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Admin Dashboard");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 65, -1, -1));

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

        btn_TransactionRecords.setBackground(new java.awt.Color(4, 99, 174));
        btn_TransactionRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_TransactionRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TransactionRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TransactionRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TransactionRecordsMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaction");
        btn_TransactionRecords.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Records");
        btn_TransactionRecords.add(jLabel2);

        jPanel2.add(btn_TransactionRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 27, 130, 75));

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
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Log Out");
        btn_LogOut.add(jLabel3);

        jPanel2.add(btn_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 130, 75));

        btn_InventoryManagement.setBackground(new java.awt.Color(4, 99, 174));
        btn_InventoryManagement.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_InventoryManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_InventoryManagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_InventoryManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_InventoryManagementMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Inventory ");
        btn_InventoryManagement.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Management");
        btn_InventoryManagement.add(jLabel6);

        jPanel2.add(btn_InventoryManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 27, 130, 75));

        btn_UserEntityManagement.setBackground(new java.awt.Color(4, 99, 174));
        btn_UserEntityManagement.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_UserEntityManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UserEntityManagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_UserEntityManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_UserEntityManagementMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("User & Entity");
        btn_UserEntityManagement.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Management");
        btn_UserEntityManagement.add(jLabel8);

        jPanel2.add(btn_UserEntityManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 27, 130, 75));

        btn_LogActivities.setBackground(new java.awt.Color(4, 99, 174));
        btn_LogActivities.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_LogActivities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogActivitiesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LogActivitiesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LogActivitiesMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Log Activities");
        btn_LogActivities.add(jLabel9);

        jPanel2.add(btn_LogActivities, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 130, 130, 75));

        btn_TrackingReport.setBackground(new java.awt.Color(4, 99, 174));
        btn_TrackingReport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_TrackingReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TrackingReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TrackingReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TrackingReportMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tracking &");
        btn_TrackingReport.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reports");
        btn_TrackingReport.add(jLabel13);

        jPanel2.add(btn_TrackingReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 130, 130, 75));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 240));

        setBounds(0, 0, 614, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_LogOut.setBackground(color);
    }//GEN-LAST:event_btn_LogOutMouseEntered

    private void btn_LogActivitiesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogActivitiesMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_LogActivities.setBackground(color);
    }//GEN-LAST:event_btn_LogActivitiesMouseEntered

    private void btn_TransactionRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TransactionRecordsMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_TransactionRecords.setBackground(color);
    }//GEN-LAST:event_btn_TransactionRecordsMouseEntered

    private void btn_InventoryManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InventoryManagementMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_InventoryManagement.setBackground(color);
    }//GEN-LAST:event_btn_InventoryManagementMouseEntered

    private void btn_UserEntityManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserEntityManagementMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_UserEntityManagement.setBackground(color);
    }//GEN-LAST:event_btn_UserEntityManagementMouseEntered

    private void btn_UserEntityManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserEntityManagementMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_UserEntityManagement.setBackground(color);
    }//GEN-LAST:event_btn_UserEntityManagementMouseExited

    private void btn_InventoryManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InventoryManagementMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_InventoryManagement.setBackground(color);
    }//GEN-LAST:event_btn_InventoryManagementMouseExited

    private void btn_TransactionRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TransactionRecordsMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_TransactionRecords.setBackground(color);
    }//GEN-LAST:event_btn_TransactionRecordsMouseExited

    private void btn_LogActivitiesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogActivitiesMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_LogActivities.setBackground(color);
    }//GEN-LAST:event_btn_LogActivitiesMouseExited

    private void btn_LogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_LogOut.setBackground(color);
    }//GEN-LAST:event_btn_LogOutMouseExited

    private void btn_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new GUI_Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_LogOutMouseClicked

    private void btn_TrackingReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackingReportMouseEntered
        // TODO add your handling code here:
        Color color = new Color(0,210,210);
        btn_TrackingReport.setBackground(color);
    }//GEN-LAST:event_btn_TrackingReportMouseEntered

    private void btn_TrackingReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackingReportMouseExited
        // TODO add your handling code here:
        Color color = new Color(0,99,174);
        btn_TrackingReport.setBackground(color);
    }//GEN-LAST:event_btn_TrackingReportMouseExited

    private void btn_UserEntityManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserEntityManagementMouseClicked
        // TODO add your handling code here:
        new GUI_UserEntityManagement().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_UserEntityManagementMouseClicked

    private void btn_InventoryManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InventoryManagementMouseClicked
        // TODO add your handling code here:
        new GUI_InventoryManagement().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_InventoryManagementMouseClicked

    private void btn_TrackingReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TrackingReportMouseClicked
        // TODO add your handling code here:
        new GUI_TrackingReport().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_TrackingReportMouseClicked

    private void btn_TransactionRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TransactionRecordsMouseClicked
        // TODO add your handling code here:
        new GUI_TransactionRecord().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_TransactionRecordsMouseClicked

    private void btn_LogActivitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogActivitiesMouseClicked
        // TODO add your handling code here:
        new GUI_LogActivity().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LogActivitiesMouseClicked


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_InventoryManagement;
    private javax.swing.JPanel btn_LogActivities;
    private javax.swing.JPanel btn_LogOut;
    private javax.swing.JPanel btn_TrackingReport;
    private javax.swing.JPanel btn_TransactionRecords;
    private javax.swing.JPanel btn_UserEntityManagement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
