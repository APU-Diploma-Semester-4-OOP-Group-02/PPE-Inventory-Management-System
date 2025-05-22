package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.configuration.LogFunction;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_LogActivity extends javax.swing.JFrame {

    public GUI_LogActivity() {
        initComponents();
        setLocationRelativeTo(null);
        loadLogData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UE_btn_Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LogActivities = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LogActivity = new javax.swing.JTable();
        btn_Search1 = new javax.swing.JButton();
        LA_lbl_Search = new javax.swing.JLabel();
        LA_tf_Search = new javax.swing.JTextField();
        btn_Refresh1 = new javax.swing.JButton();

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
        jLabel4.setText("Log Activities");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 10, 172, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        LogActivities.setBackground(new java.awt.Color(224, 247, 250));
        LogActivities.setMinimumSize(new java.awt.Dimension(800, 390));
        LogActivities.setPreferredSize(new java.awt.Dimension(800, 390));
        LogActivities.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogActivity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        LogActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date & Time", "User ID", "Action", "Details"
            }
        ));
        LogActivity.setDefaultEditor(Object.class, null);
        jScrollPane2.setViewportView(LogActivity);

        LogActivities.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 300));

        btn_Search1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search1.setText("Search");
        btn_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search1ActionPerformed(evt);
            }
        });
        LogActivities.add(btn_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 24, 80, -1));

        LA_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LA_lbl_Search.setText("Search:");
        LogActivities.add(LA_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 15));

        LA_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LA_tf_SearchActionPerformed(evt);
            }
        });
        LogActivities.add(LA_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, 180, 25));

        btn_Refresh1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh1.setText("Refresh");
        btn_Refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh1ActionPerformed(evt);
            }
        });
        LogActivities.add(btn_Refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 24, 80, -1));

        getContentPane().add(LogActivities, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadLogData() {
        DefaultTableModel model = (DefaultTableModel) LogActivity.getModel();
        model.setRowCount(0);
        List<String> logList = LogFunction.viewLog();
        for (String log : logList) {
            String[] logDetails = log.split(",");
            model.addRow(logDetails);
        }
    }
    
    private void UE_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_BackActionPerformed
        // TODO add your handling code here:
        new GUI_AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UE_btn_BackActionPerformed

    private void btn_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search1ActionPerformed
        // TODO add your handling code here:
        String searchTerm = LA_tf_Search.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) LogActivity.getModel();
        model.setRowCount(0);
        List<String> filteredLogs = LogFunction.searchLog(searchTerm);
        for (String log : filteredLogs) {
            String[] logDetails = log.split(",");
            model.addRow(logDetails);
        }
    }//GEN-LAST:event_btn_Search1ActionPerformed

    private void LA_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LA_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LA_tf_SearchActionPerformed

    private void btn_Refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh1ActionPerformed
        // TODO add your handling code here:
        loadLogData();
        LA_tf_Search.setText("");
    }//GEN-LAST:event_btn_Refresh1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LA_lbl_Search;
    private javax.swing.JTextField LA_tf_Search;
    private javax.swing.JPanel LogActivities;
    private javax.swing.JTable LogActivity;
    private javax.swing.JButton UE_btn_Back;
    private javax.swing.JButton btn_Refresh1;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
