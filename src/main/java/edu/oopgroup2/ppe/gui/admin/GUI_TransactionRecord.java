package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.model.transaction.TransactionManagement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_TransactionRecord extends JFrame {
    public GUI_TransactionRecord() {
        initComponents();
        setLocationRelativeTo(null);
        jPanel2.removeAll();
        jPanel2.add(TranR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadTransactionData();
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        TranR_Home = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransR_tb_TransactionRecord1 = new javax.swing.JTable();
        btn_Search1 = new javax.swing.JButton();
        TranR_lbl_Search = new javax.swing.JLabel();
        TranR_tf_Search = new javax.swing.JTextField();
        btn_Refresh1 = new javax.swing.JButton();
        TranR_DateFilter = new javax.swing.JPanel();
        btn_Search2 = new javax.swing.JButton();
        startDate1 = new com.toedter.calendar.JDateChooser();
        lbl_StartDate1 = new javax.swing.JLabel();
        lbl_EndDate1 = new javax.swing.JLabel();
        endDate1 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        TransR_tb_TransactionRecord2 = new javax.swing.JTable();
        btn_Refresh2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TracR_btn_Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TracR_btn_DateFilter = new javax.swing.JButton();
        TracR_btn_ViewAll = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(224, 247, 250));
        jPanel2.setLayout(new java.awt.CardLayout());

        TranR_Home.setBackground(new java.awt.Color(224, 247, 250));
        TranR_Home.setMinimumSize(new java.awt.Dimension(800, 390));
        TranR_Home.setPreferredSize(new java.awt.Dimension(800, 390));
        TranR_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TransR_tb_TransactionRecord1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TransR_tb_TransactionRecord1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Supplier ID", "Hospital ID", "Quantity", "Type", "Date & Time"
            }
        ));
        TransR_tb_TransactionRecord1.setDefaultEditor(Object.class, null);
        jScrollPane2.setViewportView(TransR_tb_TransactionRecord1);

        TranR_Home.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 720, 300));

        btn_Search1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search1.setText("Search");
        btn_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search1ActionPerformed(evt);
            }
        });
        TranR_Home.add(btn_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 24, 80, -1));

        TranR_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        TranR_lbl_Search.setText("Search:");
        TranR_Home.add(TranR_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 46, 15));

        TranR_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranR_tf_SearchActionPerformed(evt);
            }
        });
        TranR_Home.add(TranR_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 25, 150, 25));

        btn_Refresh1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh1.setText("Refresh");
        btn_Refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh1ActionPerformed(evt);
            }
        });
        TranR_Home.add(btn_Refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 24, 80, -1));

        jPanel2.add(TranR_Home, "card2");

        TranR_DateFilter.setBackground(new java.awt.Color(224, 247, 250));
        TranR_DateFilter.setMinimumSize(new java.awt.Dimension(800, 390));
        TranR_DateFilter.setPreferredSize(new java.awt.Dimension(800, 390));
        TranR_DateFilter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Search2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search2.setText("Search");
        btn_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search2ActionPerformed(evt);
            }
        });
        TranR_DateFilter.add(btn_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 24, 80, -1));
        TranR_DateFilter.add(startDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 28, 120, 20));

        lbl_StartDate1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_StartDate1.setText("Start Date:");
        TranR_DateFilter.add(lbl_StartDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 70, 15));

        lbl_EndDate1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_EndDate1.setText("End Date:");
        TranR_DateFilter.add(lbl_EndDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 63, 15));
        TranR_DateFilter.add(endDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 28, 120, 20));

        TransR_tb_TransactionRecord2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TransR_tb_TransactionRecord2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Supplier ID", "Hospital ID", "Quantity", "Type", "Date & Time"
            }
        ));
        TransR_tb_TransactionRecord2.setDefaultEditor(Object.class, null);
        jScrollPane3.setViewportView(TransR_tb_TransactionRecord2);

        TranR_DateFilter.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 720, 300));

        btn_Refresh2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh2.setText("Refresh");
        btn_Refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh2ActionPerformed(evt);
            }
        });
        TranR_DateFilter.add(btn_Refresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 24, 80, -1));

        jPanel2.add(TranR_DateFilter, "card2");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TracR_btn_Back.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        TracR_btn_Back.setText("Back");
        TracR_btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_btn_BackActionPerformed(evt);
            }
        });
        jPanel1.add(TracR_btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 160, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Transaction Record");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 10, 242, 30));

        TracR_btn_DateFilter.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        TracR_btn_DateFilter.setText("Date Filter");
        TracR_btn_DateFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_btn_DateFilterActionPerformed(evt);
            }
        });
        jPanel1.add(TracR_btn_DateFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, 40));

        TracR_btn_ViewAll.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        TracR_btn_ViewAll.setText("View All");
        TracR_btn_ViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_btn_ViewAllActionPerformed(evt);
            }
        });
        jPanel1.add(TracR_btn_ViewAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        setBounds(0, 0, 815, 498);
    }// </editor-fold>//GEN-END:initComponents

    private void loadTransactionData() {
        DefaultTableModel model = (DefaultTableModel) TransR_tb_TransactionRecord1.getModel();
        model.setRowCount(0);
        List<String> mergedTransactions = TransactionManagement.getMergedTransactions();
        for (String transaction : mergedTransactions) {
            String[] transactionDetails = transaction.split(",");
            model.addRow(transactionDetails);
        }
        if (mergedTransactions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No transactions found.", "Transaction Record", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void applyDateFilter() {
        java.util.Date startDate = startDate1.getDate();
        java.util.Date endDate = endDate1.getDate();
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both start and end dates.", "Invalid Date Range", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        DefaultTableModel model = (DefaultTableModel) TransR_tb_TransactionRecord2.getModel();
        model.setRowCount(0);
        List<String> transactions = TransactionManagement.getFilteredTransactionsByDate(startDateStr, endDateStr);
        for (String transaction : transactions) {
            String[] details = transaction.split(",");
            model.addRow(details);
        }
    }

    private void TracR_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_BackActionPerformed
        // TODO add your handling code here
        new GUI_AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TracR_btn_BackActionPerformed

    private void TracR_btn_ViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_ViewAllActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(TranR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadTransactionData();
        TranR_tf_Search.setText("");
    }//GEN-LAST:event_TracR_btn_ViewAllActionPerformed

    private void btn_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search1ActionPerformed
        // TODO add your handling code here:
        String searchTerm = TranR_tf_Search.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term to search.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<String> searchResults = TransactionManagement.searchTransaction(searchTerm);
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for '" + searchTerm + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            TranR_tf_Search.setText("");
        } else {
            DefaultTableModel model = (DefaultTableModel) TransR_tb_TransactionRecord1.getModel();
            model.setRowCount(0);
            for (String transaction : searchResults) {
                String[] details = transaction.split(",");
                model.addRow(details);
            }
        }
    }//GEN-LAST:event_btn_Search1ActionPerformed

    private void TranR_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranR_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TranR_tf_SearchActionPerformed

    private void btn_Refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh1ActionPerformed
        // TODO add your handling code here:
        loadTransactionData();
        TranR_tf_Search.setText("");
    }//GEN-LAST:event_btn_Refresh1ActionPerformed

    private void btn_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search2ActionPerformed
        // TODO add your handling code here:
        applyDateFilter();
    }//GEN-LAST:event_btn_Search2ActionPerformed

    private void btn_Refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TransR_tb_TransactionRecord2.getModel();
        model.setRowCount(0);
        startDate1.setDate(null);
        endDate1.setDate(null);
    }//GEN-LAST:event_btn_Refresh2ActionPerformed

    private void TracR_btn_DateFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_DateFilterActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(TranR_DateFilter);
        jPanel2.repaint();
        jPanel2.revalidate();
        startDate1.setDate(null);
        endDate1.setDate(null);
    }//GEN-LAST:event_TracR_btn_DateFilterActionPerformed



        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TracR_btn_Back;
    private javax.swing.JButton TracR_btn_DateFilter;
    private javax.swing.JButton TracR_btn_ViewAll;
    private javax.swing.JPanel TranR_DateFilter;
    private javax.swing.JPanel TranR_Home;
    private javax.swing.JLabel TranR_lbl_Search;
    private javax.swing.JTextField TranR_tf_Search;
    private javax.swing.JTable TransR_tb_TransactionRecord1;
    private javax.swing.JTable TransR_tb_TransactionRecord2;
    private javax.swing.JButton btn_Refresh1;
    private javax.swing.JButton btn_Refresh2;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JButton btn_Search2;
    private com.toedter.calendar.JDateChooser endDate1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_EndDate1;
    private javax.swing.JLabel lbl_StartDate1;
    private com.toedter.calendar.JDateChooser startDate1;
    // End of variables declaration//GEN-END:variables
}
