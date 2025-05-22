package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.model.inventory.Inventory;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_InventoryManagement extends JFrame {
    public GUI_InventoryManagement() {
        initComponents();
        setLocationRelativeTo(null);
        loadInventoryData();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        IM_btn_ViewLowStock = new javax.swing.JButton();
        IM_btn_AddNewItem = new javax.swing.JButton();
        IM_btn_SetSupplier = new javax.swing.JButton();
        IM_btn_Back = new javax.swing.JButton();
        IM_btn_UpdateStock = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        InventoryManagementHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IM_tb_Inventory = new javax.swing.JTable();
        btn_Search = new javax.swing.JButton();
        IM_lbl_Search = new javax.swing.JLabel();
        IM_tf_Search = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IM_btn_ViewLowStock.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        IM_btn_ViewLowStock.setText("View Low Stock");
        IM_btn_ViewLowStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_ViewLowStockActionPerformed(evt);
            }
        });
        jPanel1.add(IM_btn_ViewLowStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 50, 134, 40));

        IM_btn_AddNewItem.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        IM_btn_AddNewItem.setText("Add New Item");
        IM_btn_AddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_AddNewItemActionPerformed(evt);
            }
        });
        jPanel1.add(IM_btn_AddNewItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 50, 134, 40));

        IM_btn_SetSupplier.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        IM_btn_SetSupplier.setText("Set Supplier");
        IM_btn_SetSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_SetSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(IM_btn_SetSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 50, 134, 40));

        IM_btn_Back.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        IM_btn_Back.setText("Back");
        IM_btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_BackActionPerformed(evt);
            }
        });
        jPanel1.add(IM_btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 50, 134, 40));

        IM_btn_UpdateStock.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        IM_btn_UpdateStock.setText("Update Stock");
        IM_btn_UpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_UpdateStockActionPerformed(evt);
            }
        });
        jPanel1.add(IM_btn_UpdateStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 50, 134, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inventory Management");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 10, 295, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanel2.setBackground(new java.awt.Color(224, 247, 250));
        jPanel2.setLayout(new java.awt.CardLayout());

        InventoryManagementHome.setBackground(new java.awt.Color(224, 247, 250));
        InventoryManagementHome.setMinimumSize(new java.awt.Dimension(800, 390));
        InventoryManagementHome.setPreferredSize(new java.awt.Dimension(800, 390));
        InventoryManagementHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IM_tb_Inventory.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        IM_tb_Inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Quantity In Stock", "Supplier ID"
            }
        ));
        IM_tb_Inventory.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(IM_tb_Inventory);

        InventoryManagementHome.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 300));

        btn_Search.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        InventoryManagementHome.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 24, 80, -1));

        IM_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_Search.setText("Search:");
        InventoryManagementHome.add(IM_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 15));

        IM_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_tf_SearchActionPerformed(evt);
            }
        });
        InventoryManagementHome.add(IM_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, 180, 25));

        btn_Refresh.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        InventoryManagementHome.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 24, 80, -1));

        jPanel2.add(InventoryManagementHome, "card2");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        setBounds(0, 0, 814, 498);
    }// </editor-fold>//GEN-END:initComponents

    
    protected void loadInventoryData() {
        DefaultTableModel model = (DefaultTableModel) IM_tb_Inventory.getModel();
        model.setRowCount(0);
        List<String> inventoryList = InventoryManagement.viewCurrentStock();
        for (String inv : inventoryList) {
            String[] inventoryDetails = inv.split(",");
            model.addRow(new Object[]{inventoryDetails[0], inventoryDetails[1], inventoryDetails[3], inventoryDetails[2]});
        }
    }

    private void IM_btn_ViewLowStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_ViewLowStockActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) IM_tb_Inventory.getModel();
        model.setRowCount(0);
        List<String> inventoryList = InventoryManagement.viewLowStock();
        if (inventoryList == null) {
            JOptionPane.showMessageDialog(this, "Error retrieving low stock items.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (inventoryList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No stock items with less than 25 boxes.", "Low Stock", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (String inv : inventoryList) {
                String[] inventoryDetails = inv.split(",");
                model.addRow(new Object[]{
                    inventoryDetails[0],
                    inventoryDetails[1],
                    inventoryDetails[3],
                    inventoryDetails[2]
                });
            }
        }
    }//GEN-LAST:event_IM_btn_ViewLowStockActionPerformed

    private void IM_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_BackActionPerformed
        // TODO add your handling code here:
        new GUI_AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_IM_btn_BackActionPerformed

    private void IM_btn_UpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_UpdateStockActionPerformed
        // TODO add your handling code here:
        PopUp_IM_UpdateStock popUp = new PopUp_IM_UpdateStock(this);
        popUp.setLocationRelativeTo(this);
        popUp.setVisible(true);
    }//GEN-LAST:event_IM_btn_UpdateStockActionPerformed

    private void IM_btn_SetSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_SetSupplierActionPerformed
        // TODO add your handling code here:
        PopUp_IM_SetSupplier popUp = new PopUp_IM_SetSupplier(this,null);
        popUp.setLocationRelativeTo(this);
        popUp.setVisible(true);
    }//GEN-LAST:event_IM_btn_SetSupplierActionPerformed

    private void IM_btn_AddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_AddNewItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "PS. Item ID can only two letters", "Add New PPE Item", JOptionPane.INFORMATION_MESSAGE);
        PopUp_IM_AddNewItem popUp = new PopUp_IM_AddNewItem(this);
        popUp.setLocationRelativeTo(this);
        popUp.setVisible(true);
    }//GEN-LAST:event_IM_btn_AddNewItemActionPerformed

    private void IM_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IM_tf_SearchActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        String searchTerm = IM_tf_Search.getText().trim();
        JTable table = IM_tb_Inventory;
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<?> searchResults = new ArrayList<>();
        searchResults = InventoryManagement.searchInventory(searchTerm);
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for '" + searchTerm + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            IM_tf_Search.setText("");
        } else {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Object result : searchResults) {
                if (result instanceof Inventory) {
                    Inventory inv = (Inventory) result;
                    model.addRow(new Object[]{inv.getItemCode(),inv.getItemName(),inv.getQuantityInStock(),inv.getSupplierCode()});
                }
            }
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        loadInventoryData();
        IM_tf_Search.setText("");
    }//GEN-LAST:event_btn_RefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IM_btn_AddNewItem;
    private javax.swing.JButton IM_btn_Back;
    private javax.swing.JButton IM_btn_SetSupplier;
    private javax.swing.JButton IM_btn_UpdateStock;
    private javax.swing.JButton IM_btn_ViewLowStock;
    private javax.swing.JLabel IM_lbl_Search;
    private javax.swing.JTable IM_tb_Inventory;
    private javax.swing.JTextField IM_tf_Search;
    private javax.swing.JPanel InventoryManagementHome;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_Search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
