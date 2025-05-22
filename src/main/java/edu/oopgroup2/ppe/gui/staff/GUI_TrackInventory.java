package edu.oopgroup2.ppe.gui.staff;

import edu.oopgroup2.ppe.model.tracking.TrackingManagement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_TrackInventory extends javax.swing.JFrame {

    public GUI_TrackInventory() {
        initComponents();
        setLocationRelativeTo(null);
        jPanel2.removeAll();
        jPanel2.add(TracR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadTrackingData();
    }

    private void loadTrackingData() {
        DefaultTableModel model = (DefaultTableModel) TracR_tb_TrackingReport.getModel();
        model.setRowCount(0);
        List<String> trackingData = TrackingManagement.getSummarizedTrackingData();
        for (String data : trackingData) {
            String[] details = data.split(",");
            model.addRow(new Object[]{details[0], details[1], details[2], details[3], details[4], details[5]});
        }
    }
    
    private void loadLowStockData() {
        DefaultTableModel model = (DefaultTableModel) TracR_tb_TrackingReport.getModel();
        model.setRowCount(0);
        List<String> lowStockData = TrackingManagement.getLowStockItems();
        for (String data : lowStockData) {
            String[] details = data.split(",");
            model.addRow(new Object[]{details[0], details[1], details[2], details[3], details[4], details[5]});
        }
    }
    
    private void applyReceiveDateFilter() {
        java.util.Date startDate = startDate4.getDate();
        java.util.Date endDate = endDate4.getDate();
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both start and end dates.", "Invalid Date Range", JOptionPane.WARNING_MESSAGE);
            btn_Distribute.setEnabled(true);
            btn_Distribute1.setEnabled(true);
            btn_Receive.setEnabled(true);
            btn_Receive1.setEnabled(true);
            return;
        }
        String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        DefaultTableModel model = (DefaultTableModel) TracR_Rtb_DateFilter.getModel();
        model.setRowCount(0);
        List<String> filteredData = TrackingManagement.trackItemReceivedByDate(startDateStr, endDateStr);
        if (filteredData == null || filteredData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items received in this period.", "No Records Found", JOptionPane.INFORMATION_MESSAGE);
            btn_Distribute.setEnabled(true);
            btn_Distribute1.setEnabled(true);
            btn_Receive.setEnabled(true);
            btn_Receive1.setEnabled(true);
        } else {
            for (String data : filteredData) {
                String[] details = data.split(",");
                model.addRow(new Object[]{details[0], details[1], details[2], details[3]});
            }
        }
    }
    
    private void applyDistributeDateFilter() {
        java.util.Date startDate = startDate5.getDate();
        java.util.Date endDate = endDate5.getDate();
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both start and end dates.", "Invalid Date Range", JOptionPane.WARNING_MESSAGE);
            btn_Distribute.setEnabled(true);
            btn_Distribute1.setEnabled(true);
            btn_Receive.setEnabled(true);
            btn_Receive1.setEnabled(true);
            return;
        }
        String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        DefaultTableModel model = (DefaultTableModel) TracR_Dtb_DateFilter2.getModel();
        model.setRowCount(0);
        List<String> filteredData = TrackingManagement.trackItemDistributedByDate(startDateStr, endDateStr);
        if (filteredData == null || filteredData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items distributed in this period.", "No Records Found", JOptionPane.INFORMATION_MESSAGE);
            btn_Distribute.setEnabled(true);
            btn_Distribute1.setEnabled(true);
            btn_Receive.setEnabled(true);
            btn_Receive1.setEnabled(true);
        } else {
            for (String data : filteredData) {
                String[] details = data.split(",");
                model.addRow(new Object[]{details[0], details[1], details[2], details[3]});
            }
        }
    }
    
    private void synchronizeDates() {
        if (startDate4.getDate() != null && endDate4.getDate() != null) {
            startDate5.setDate(startDate4.getDate());
            endDate5.setDate(endDate4.getDate());
        } else if (startDate5.getDate() != null && endDate5.getDate() != null) {
            startDate4.setDate(startDate5.getDate());
            endDate4.setDate(endDate5.getDate());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TracR_Home = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TracR_tb_TrackingReport = new javax.swing.JTable();
        btn_Search = new javax.swing.JButton();
        TracR_lbl_Search = new javax.swing.JLabel();
        TracR_tf_Search = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JButton();
        TracR_DateFilter_Receive = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TracR_Rtb_DateFilter = new javax.swing.JTable();
        btn_Receive1 = new javax.swing.JButton();
        startDate4 = new com.toedter.calendar.JDateChooser();
        lbl_StartDate4 = new javax.swing.JLabel();
        lbl_EndDate4 = new javax.swing.JLabel();
        endDate4 = new com.toedter.calendar.JDateChooser();
        btn_Cancel3 = new javax.swing.JButton();
        btn_Refresh4 = new javax.swing.JButton();
        btn_Distribute1 = new javax.swing.JButton();
        TracR_DateFilter_Distribute = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TracR_Dtb_DateFilter2 = new javax.swing.JTable();
        btn_Receive = new javax.swing.JButton();
        startDate5 = new com.toedter.calendar.JDateChooser();
        lbl_StartDate5 = new javax.swing.JLabel();
        lbl_EndDate5 = new javax.swing.JLabel();
        endDate5 = new com.toedter.calendar.JDateChooser();
        btn_Cancel4 = new javax.swing.JButton();
        btn_Refresh5 = new javax.swing.JButton();
        btn_Distribute = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TracR_btn_Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TracR_btn_DateFilter = new javax.swing.JButton();
        TracR_btn_ViewLowStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.CardLayout());

        TracR_Home.setBackground(new java.awt.Color(224, 247, 250));
        TracR_Home.setMinimumSize(new java.awt.Dimension(800, 390));
        TracR_Home.setPreferredSize(new java.awt.Dimension(800, 390));
        TracR_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TracR_tb_TrackingReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TracR_tb_TrackingReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Supplier ID", "Hospital ID", "Total Received", "Total Distributed", "Current Stock"
            }
        ));
        TracR_tb_TrackingReport.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(TracR_tb_TrackingReport);

        TracR_Home.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 720, 300));

        btn_Search.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        TracR_Home.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 24, 80, -1));

        TracR_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        TracR_lbl_Search.setText("Search:");
        TracR_Home.add(TracR_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 46, 15));

        TracR_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_tf_SearchActionPerformed(evt);
            }
        });
        TracR_Home.add(TracR_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 25, 150, 25));

        btn_Refresh.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        TracR_Home.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 24, 80, -1));

        jPanel2.add(TracR_Home, "card2");

        TracR_DateFilter_Receive.setBackground(new java.awt.Color(224, 247, 250));
        TracR_DateFilter_Receive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TracR_Rtb_DateFilter.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TracR_Rtb_DateFilter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Supplier ID", "Quantity", "Date & Time"
            }
        ));
        jScrollPane5.setViewportView(TracR_Rtb_DateFilter);

        TracR_DateFilter_Receive.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 300));

        btn_Receive1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Receive1.setText("Receive");
        btn_Receive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Receive1ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Receive.add(btn_Receive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 24, 80, -1));
        TracR_DateFilter_Receive.add(startDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 28, 120, 20));

        lbl_StartDate4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_StartDate4.setText("Start Date:");
        TracR_DateFilter_Receive.add(lbl_StartDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, 70, 15));

        lbl_EndDate4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_EndDate4.setText("End Date:");
        TracR_DateFilter_Receive.add(lbl_EndDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 30, 63, 15));
        TracR_DateFilter_Receive.add(endDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 28, 120, 20));

        btn_Cancel3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Cancel3.setText("Cancel");
        btn_Cancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancel3ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Receive.add(btn_Cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 24, 80, -1));

        btn_Refresh4.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh4.setText("Refresh");
        btn_Refresh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh4ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Receive.add(btn_Refresh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 24, 80, -1));

        btn_Distribute1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Distribute1.setText("Distribute");
        btn_Distribute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Distribute1ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Receive.add(btn_Distribute1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 24, 88, -1));

        jPanel2.add(TracR_DateFilter_Receive, "card4");

        TracR_DateFilter_Distribute.setBackground(new java.awt.Color(224, 247, 250));
        TracR_DateFilter_Distribute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TracR_Dtb_DateFilter2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TracR_Dtb_DateFilter2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Hospital ID", "Quantity", "Date & Time"
            }
        ));
        jScrollPane6.setViewportView(TracR_Dtb_DateFilter2);

        TracR_DateFilter_Distribute.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 300));

        btn_Receive.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Receive.setText("Receive");
        btn_Receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReceiveActionPerformed(evt);
            }
        });
        TracR_DateFilter_Distribute.add(btn_Receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 24, 80, -1));
        TracR_DateFilter_Distribute.add(startDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 28, 120, 20));

        lbl_StartDate5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_StartDate5.setText("Start Date:");
        TracR_DateFilter_Distribute.add(lbl_StartDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, 70, 15));

        lbl_EndDate5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbl_EndDate5.setText("End Date:");
        TracR_DateFilter_Distribute.add(lbl_EndDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 30, 63, 15));
        TracR_DateFilter_Distribute.add(endDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 28, 120, 20));

        btn_Cancel4.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Cancel4.setText("Cancel");
        btn_Cancel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancel4ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Distribute.add(btn_Cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 24, 80, -1));

        btn_Refresh5.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh5.setText("Refresh");
        btn_Refresh5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh5ActionPerformed(evt);
            }
        });
        TracR_DateFilter_Distribute.add(btn_Refresh5, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 24, 80, -1));

        btn_Distribute.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Distribute.setText("Distribute");
        btn_Distribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DistributeActionPerformed(evt);
            }
        });
        TracR_DateFilter_Distribute.add(btn_Distribute, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 24, 88, -1));

        jPanel2.add(TracR_DateFilter_Distribute, "card4");

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
        jLabel4.setText("Track Inventory");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 200, 30));

        TracR_btn_DateFilter.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        TracR_btn_DateFilter.setText("Date Filter");
        TracR_btn_DateFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_btn_DateFilterActionPerformed(evt);
            }
        });
        jPanel1.add(TracR_btn_DateFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, 40));

        TracR_btn_ViewLowStock.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        TracR_btn_ViewLowStock.setText("View Low Stock");
        TracR_btn_ViewLowStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracR_btn_ViewLowStockActionPerformed(evt);
            }
        });
        jPanel1.add(TracR_btn_ViewLowStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        String searchTerm = TracR_tf_Search.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term to search.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<String> searchResults = TrackingManagement.searchTrackingData(searchTerm);
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for '" + searchTerm + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            TracR_tf_Search.setText("");
        } else { 
           DefaultTableModel model = (DefaultTableModel) TracR_tb_TrackingReport.getModel();
            model.setRowCount(0);
            for (String data : searchResults) {
                String[] details = data.split(",");
                model.addRow(new Object[]{details[0], details[1], details[2], details[3], details[4], details[5]});
            } 
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void TracR_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TracR_tf_SearchActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        loadTrackingData();
        TracR_tf_Search.setText("");
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void TracR_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_BackActionPerformed
        // TODO add your handling code here
        new GUI_StaffDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TracR_btn_BackActionPerformed

    private void TracR_btn_DateFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_DateFilterActionPerformed
        // TODO add your handling code here:
        btn_Distribute.setEnabled(true);
        btn_Distribute1.setEnabled(true);
        btn_Receive.setEnabled(true);
        btn_Receive1.setEnabled(true);
        jPanel2.removeAll();
        jPanel2.add(TracR_DateFilter_Receive);
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_TracR_btn_DateFilterActionPerformed

    private void TracR_btn_ViewLowStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracR_btn_ViewLowStockActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(TracR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadLowStockData();
        TracR_tf_Search.setText("");
    }//GEN-LAST:event_TracR_btn_ViewLowStockActionPerformed

    private void btn_Receive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Receive1ActionPerformed
        // TODO add your handling code here:
        synchronizeDates();
        btn_Distribute.setEnabled(true);
        btn_Distribute1.setEnabled(true);
        btn_Receive.setEnabled(false);
        btn_Receive1.setEnabled(false);
        jPanel2.removeAll();
        jPanel2.add(TracR_DateFilter_Receive);
        jPanel2.repaint();
        jPanel2.revalidate();
        DefaultTableModel model = (DefaultTableModel) TracR_Rtb_DateFilter.getModel();
        model.setRowCount(0);
        applyReceiveDateFilter();
        if (startDate4.getDate() == null || endDate4.getDate() == null) {
            btn_Receive1.setEnabled(true);
        }
    }//GEN-LAST:event_btn_Receive1ActionPerformed

    private void btn_Cancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancel3ActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(TracR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadTrackingData();
    }//GEN-LAST:event_btn_Cancel3ActionPerformed

    private void btn_Refresh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh4ActionPerformed
        // TODO add your handling code here:
        btn_Distribute.setEnabled(true);
        btn_Distribute1.setEnabled(true);
        btn_Receive.setEnabled(true);
        btn_Receive1.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) TracR_Rtb_DateFilter.getModel();
        model.setRowCount(0);
        startDate4.setDate(null);
        endDate4.setDate(null);
        startDate5.setDate(null);
        endDate5.setDate(null);
    }//GEN-LAST:event_btn_Refresh4ActionPerformed

    private void btn_Distribute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Distribute1ActionPerformed
        // TODO add your handling code here:
        synchronizeDates();
        btn_Distribute.setEnabled(false);
        btn_Distribute1.setEnabled(false);
        btn_Receive.setEnabled(true);
        btn_Receive1.setEnabled(true);
        jPanel2.removeAll();
        jPanel2.add(TracR_DateFilter_Distribute);
        jPanel2.repaint();
        jPanel2.revalidate();
        DefaultTableModel model = (DefaultTableModel) TracR_Dtb_DateFilter2.getModel();
        model.setRowCount(0);
        applyDistributeDateFilter();
    }//GEN-LAST:event_btn_Distribute1ActionPerformed

    private void btn_ReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReceiveActionPerformed
        // TODO add your handling code here:
        synchronizeDates();
        btn_Distribute.setEnabled(true);
        btn_Distribute1.setEnabled(true);
        btn_Receive.setEnabled(false);
        btn_Receive1.setEnabled(false);
        jPanel2.removeAll();
        jPanel2.add(TracR_DateFilter_Receive);
        jPanel2.repaint();
        jPanel2.revalidate();
        DefaultTableModel model = (DefaultTableModel) TracR_Rtb_DateFilter.getModel();
        model.setRowCount(0);
        applyReceiveDateFilter();
    }//GEN-LAST:event_btn_ReceiveActionPerformed

    private void btn_Cancel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancel4ActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(TracR_Home);
        jPanel2.repaint();
        jPanel2.revalidate();
        loadTrackingData();
    }//GEN-LAST:event_btn_Cancel4ActionPerformed

    private void btn_Refresh5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh5ActionPerformed
        // TODO add your handling code here:
        btn_Distribute.setEnabled(true);
        btn_Distribute1.setEnabled(true);
        btn_Receive.setEnabled(true);
        btn_Receive1.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) TracR_Dtb_DateFilter2.getModel();
        model.setRowCount(0);
        startDate4.setDate(null);
        endDate4.setDate(null);
        startDate5.setDate(null);
        endDate5.setDate(null);
    }//GEN-LAST:event_btn_Refresh5ActionPerformed

    private void btn_DistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DistributeActionPerformed
        // TODO add your handling code here:
        synchronizeDates();
        btn_Distribute.setEnabled(false);
        btn_Distribute1.setEnabled(false);
        btn_Receive.setEnabled(true);
        btn_Receive1.setEnabled(true);
        jPanel2.removeAll();
        jPanel2.add(TracR_DateFilter_Distribute);
        jPanel2.repaint();
        jPanel2.revalidate();
        DefaultTableModel model = (DefaultTableModel) TracR_Dtb_DateFilter2.getModel();
        model.setRowCount(0);
        applyDistributeDateFilter();
        if (startDate5.getDate() == null || endDate5.getDate() == null) {
            btn_Distribute.setEnabled(true);
        }
    }//GEN-LAST:event_btn_DistributeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TracR_DateFilter_Distribute;
    private javax.swing.JPanel TracR_DateFilter_Receive;
    private javax.swing.JTable TracR_Dtb_DateFilter2;
    private javax.swing.JPanel TracR_Home;
    private javax.swing.JTable TracR_Rtb_DateFilter;
    private javax.swing.JButton TracR_btn_Back;
    private javax.swing.JButton TracR_btn_DateFilter;
    private javax.swing.JButton TracR_btn_ViewLowStock;
    private javax.swing.JLabel TracR_lbl_Search;
    private javax.swing.JTable TracR_tb_TrackingReport;
    private javax.swing.JTextField TracR_tf_Search;
    private javax.swing.JButton btn_Cancel3;
    private javax.swing.JButton btn_Cancel4;
    private javax.swing.JButton btn_Distribute;
    private javax.swing.JButton btn_Distribute1;
    private javax.swing.JButton btn_Receive;
    private javax.swing.JButton btn_Receive1;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_Refresh4;
    private javax.swing.JButton btn_Refresh5;
    private javax.swing.JButton btn_Search;
    private com.toedter.calendar.JDateChooser endDate4;
    private com.toedter.calendar.JDateChooser endDate5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl_EndDate4;
    private javax.swing.JLabel lbl_EndDate5;
    private javax.swing.JLabel lbl_StartDate4;
    private javax.swing.JLabel lbl_StartDate5;
    private com.toedter.calendar.JDateChooser startDate4;
    private com.toedter.calendar.JDateChooser startDate5;
    // End of variables declaration//GEN-END:variables
}
