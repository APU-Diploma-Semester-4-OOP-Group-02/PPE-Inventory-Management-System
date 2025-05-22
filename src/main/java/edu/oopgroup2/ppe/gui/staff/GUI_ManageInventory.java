package edu.oopgroup2.ppe.gui.staff;

import edu.oopgroup2.ppe.configuration.DropdownUtils;
import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.model.inventory.Inventory;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_ManageInventory extends javax.swing.JFrame {
    public GUI_ManageInventory() {
        initComponents();
        Card_ManageInventory.removeAll();
        Card_ManageInventory.add(ManageInventoryHome);
        Card_ManageInventory.revalidate();
        Card_ManageInventory.repaint();
        setLocationRelativeTo(null);
        initializeStock();
        loadInventoryData("Home");
    }

    private void initializeStock() {
        if (!InventoryManagement.isStockInitialized()) {
            String result = InventoryManagement.initializePPEStock();
            JOptionPane.showMessageDialog(this, result, "Initialize Stock", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void loadInventoryData(String panel) {
        JTable table;
        switch (panel) {
            case "Home":
                table = MI_tb_Home;
                break;
            case "Receive":
                table = tb_Receive;
                break;
            case "Distribute":
                table = tb_Distribute;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid table.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<String> inventoryList = InventoryManagement.viewCurrentStock();
        for (String inv : inventoryList) {
            String[] inventoryDetails = inv.split(",");
            model.addRow(new Object[]{inventoryDetails[0], inventoryDetails[1], inventoryDetails[3], inventoryDetails[2]});
        }
    }
    
    private void updateSupplierIDForItem(String itemCode) {
        if (itemCode == null || itemCode.equals("")) {
            MI_cb_SupplierID.setSelectedItem(null);
            MI_cb_SupplierID.setEnabled(false);
            return;
        }
        String supplierCode = InventoryManagement.getSupplierForItem(itemCode);
        if (supplierCode != null && !supplierCode.isEmpty()) {
            MI_cb_SupplierID.setSelectedItem(supplierCode);
            MI_cb_SupplierID.setEnabled(false);
        } else {
            MI_cb_SupplierID.setSelectedItem(null);
            MI_cb_SupplierID.setEnabled(false);
            JOptionPane.showMessageDialog(this, "No supplier assigned for this item. Please contact the admin to assign a supplier.", "Supplier Not Assigned", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Receive = new javax.swing.JButton();
        UE_btn_Back = new javax.swing.JButton();
        btn_Distribute = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Card_ManageInventory = new javax.swing.JPanel();
        Distribute = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Distribute = new javax.swing.JTable();
        MI_lbl_ItemCode = new javax.swing.JLabel();
        MI_lbl_HospitalID = new javax.swing.JLabel();
        MI_lbl_Quatity = new javax.swing.JLabel();
        MI_tf_Quantity = new javax.swing.JTextField();
        btn_Search1 = new javax.swing.JButton();
        btn_Save1 = new javax.swing.JButton();
        btn_Cancel1 = new javax.swing.JButton();
        MI_lbl_Search1 = new javax.swing.JLabel();
        MI_tf_Search1 = new javax.swing.JTextField();
        btn_Refresh2 = new javax.swing.JButton();
        MI_cb_ItemCode = new javax.swing.JComboBox<>();
        MI_cb_HospitalID = new javax.swing.JComboBox<>();
        Receive = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Receive = new javax.swing.JTable();
        MI_lbl_ItemCode1 = new javax.swing.JLabel();
        MI_lbl_SupplierID = new javax.swing.JLabel();
        MI_lbl_Quatity1 = new javax.swing.JLabel();
        MI_tf_Quantity1 = new javax.swing.JTextField();
        btn_Search2 = new javax.swing.JButton();
        btn_Save2 = new javax.swing.JButton();
        btn_Cancel2 = new javax.swing.JButton();
        MI_lbl_Search2 = new javax.swing.JLabel();
        MI_tf_Search2 = new javax.swing.JTextField();
        btn_Refresh3 = new javax.swing.JButton();
        MI_cb_ItemCode1 = new javax.swing.JComboBox<>();
        MI_cb_SupplierID = new javax.swing.JComboBox<>();
        ManageInventoryHome = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MI_tb_Home = new javax.swing.JTable();
        btn_Search = new javax.swing.JButton();
        IM_lbl_Search = new javax.swing.JLabel();
        IM_tf_Search = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Receive.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        btn_Receive.setText("Receive");
        btn_Receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReceiveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 134, 40));

        UE_btn_Back.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        UE_btn_Back.setText("Back");
        UE_btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_BackActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 50, 134, 40));

        btn_Distribute.setFont(new java.awt.Font("Tw Cen MT", 1, 15)); // NOI18N
        btn_Distribute.setText("Distribute");
        btn_Distribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DistributeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Distribute, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 50, 134, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Inventory");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        Card_ManageInventory.setLayout(new java.awt.CardLayout());

        Distribute.setBackground(new java.awt.Color(224, 247, 250));
        Distribute.setMinimumSize(new java.awt.Dimension(800, 390));
        Distribute.setPreferredSize(new java.awt.Dimension(800, 390));
        Distribute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Distribute.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tb_Distribute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Quantity In Stock", "Supplier ID"
            }
        ));
        tb_Distribute.setDefaultEditor(Object.class, null);
        tb_Distribute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_DistributeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_Distribute);

        Distribute.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        MI_lbl_ItemCode.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_ItemCode.setText("Item Code:");
        Distribute.add(MI_lbl_ItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 145, 15));

        MI_lbl_HospitalID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_HospitalID.setText("Hospital ID:");
        Distribute.add(MI_lbl_HospitalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 145, 15));

        MI_lbl_Quatity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_Quatity.setText("Quantity:");
        Distribute.add(MI_lbl_Quatity, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 145, 15));
        Distribute.add(MI_tf_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 215, 145, 25));

        btn_Search1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search1.setText("Search");
        btn_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search1ActionPerformed(evt);
            }
        });
        Distribute.add(btn_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Save1.setFont(new java.awt.Font("Tw Cen MT", 2, 16)); // NOI18N
        btn_Save1.setText("Save");
        btn_Save1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                btn_Save1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btn_Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save1ActionPerformed(evt);
            }
        });
        Distribute.add(btn_Save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 80, 30));

        btn_Cancel1.setFont(new java.awt.Font("Tw Cen MT", 2, 16)); // NOI18N
        btn_Cancel1.setText("Cancel");
        btn_Cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancel1ActionPerformed(evt);
            }
        });
        Distribute.add(btn_Cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 320, 80, 30));

        MI_lbl_Search1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_Search1.setText("Search:");
        Distribute.add(MI_lbl_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));

        MI_tf_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_tf_Search1ActionPerformed(evt);
            }
        });
        Distribute.add(MI_tf_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Refresh2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh2.setText("Refresh");
        btn_Refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh2ActionPerformed(evt);
            }
        });
        Distribute.add(btn_Refresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        MI_cb_ItemCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MI_cb_ItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_cb_ItemCodeActionPerformed(evt);
            }
        });
        Distribute.add(MI_cb_ItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 75, 145, 25));

        MI_cb_HospitalID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Distribute.add(MI_cb_HospitalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 145, 145, 25));

        Card_ManageInventory.add(Distribute, "card2");

        Receive.setBackground(new java.awt.Color(224, 247, 250));
        Receive.setMinimumSize(new java.awt.Dimension(800, 390));
        Receive.setPreferredSize(new java.awt.Dimension(800, 390));
        Receive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Receive.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tb_Receive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Quantity In Stock", "Supplier ID"
            }
        ));
        tb_Receive.setDefaultEditor(Object.class, null);
        tb_Receive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ReceiveMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_Receive);

        Receive.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        MI_lbl_ItemCode1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_ItemCode1.setText("Item Code:");
        Receive.add(MI_lbl_ItemCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 145, 15));

        MI_lbl_SupplierID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_SupplierID.setText("Supplier ID:");
        Receive.add(MI_lbl_SupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 145, 15));

        MI_lbl_Quatity1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_Quatity1.setText("Quantity:");
        Receive.add(MI_lbl_Quatity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 145, 15));
        Receive.add(MI_tf_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 215, 145, 25));

        btn_Search2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search2.setText("Search");
        btn_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search2ActionPerformed(evt);
            }
        });
        Receive.add(btn_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Save2.setFont(new java.awt.Font("Tw Cen MT", 2, 16)); // NOI18N
        btn_Save2.setText("Save");
        btn_Save2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                btn_Save2AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btn_Save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save2ActionPerformed(evt);
            }
        });
        Receive.add(btn_Save2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 80, 30));

        btn_Cancel2.setFont(new java.awt.Font("Tw Cen MT", 2, 16)); // NOI18N
        btn_Cancel2.setText("Cancel");
        btn_Cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancel2ActionPerformed(evt);
            }
        });
        Receive.add(btn_Cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 320, 80, 30));

        MI_lbl_Search2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        MI_lbl_Search2.setText("Search:");
        Receive.add(MI_lbl_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));

        MI_tf_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_tf_Search2ActionPerformed(evt);
            }
        });
        Receive.add(MI_tf_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Refresh3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh3.setText("Refresh");
        btn_Refresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh3ActionPerformed(evt);
            }
        });
        Receive.add(btn_Refresh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        MI_cb_ItemCode1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MI_cb_ItemCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_cb_ItemCode1ActionPerformed(evt);
            }
        });
        Receive.add(MI_cb_ItemCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 75, 145, 25));

        MI_cb_SupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Receive.add(MI_cb_SupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 145, 145, 25));

        Card_ManageInventory.add(Receive, "card2");

        ManageInventoryHome.setBackground(new java.awt.Color(224, 247, 250));
        ManageInventoryHome.setMinimumSize(new java.awt.Dimension(800, 390));
        ManageInventoryHome.setPreferredSize(new java.awt.Dimension(800, 390));
        ManageInventoryHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MI_tb_Home.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        MI_tb_Home.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Quantity In Stock", "Supplier ID"
            }
        ));
        MI_tb_Home.setDefaultEditor(Object.class, null);
        jScrollPane2.setViewportView(MI_tb_Home);

        ManageInventoryHome.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 300));

        btn_Search.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        ManageInventoryHome.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 24, 80, -1));

        IM_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_Search.setText("Search:");
        ManageInventoryHome.add(IM_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 15));

        IM_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_tf_SearchActionPerformed(evt);
            }
        });
        ManageInventoryHome.add(IM_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, 180, 25));

        btn_Refresh.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        ManageInventoryHome.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 24, 80, -1));

        Card_ManageInventory.add(ManageInventoryHome, "card2");

        getContentPane().add(Card_ManageInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        btnSearch("Home");
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void IM_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IM_tf_SearchActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        btnRefresh("Home");
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void btn_ReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReceiveActionPerformed
        // TODO add your handling code here:
        Card_ManageInventory.removeAll();
        Card_ManageInventory.add(Receive);
        Card_ManageInventory.revalidate();
        Card_ManageInventory.repaint();
        loadInventoryData("Receive");
        MI_tf_Search2.setText("");
        DropdownUtils.populateItemCodeDropdown(MI_cb_ItemCode1);
        DropdownUtils.populateSupplierIDDropdown(MI_cb_SupplierID);
        MI_cb_SupplierID.setEnabled(false);
    }//GEN-LAST:event_btn_ReceiveActionPerformed

    private void UE_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_BackActionPerformed
        // TODO add your handling code here:
        new GUI_StaffDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UE_btn_BackActionPerformed

    private void btn_DistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DistributeActionPerformed
        // TODO add your handling code here:
        Card_ManageInventory.removeAll();
        Card_ManageInventory.add(Distribute);
        Card_ManageInventory.revalidate();
        Card_ManageInventory.repaint();
        loadInventoryData("Distribute");
        MI_tf_Search1.setText("");
        DropdownUtils.populateItemCodeDropdown(MI_cb_ItemCode);
        DropdownUtils.populateHospitalIDDropdown(MI_cb_HospitalID);
    }//GEN-LAST:event_btn_DistributeActionPerformed

    private void tb_DistributeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DistributeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_DistributeMouseClicked

    private void btn_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search1ActionPerformed
        // TODO add your handling code here:
        btnSearch("Distribute");
    }//GEN-LAST:event_btn_Search1ActionPerformed

    private void btn_Save1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btn_Save1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Save1AncestorMoved

    private void btn_Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save1ActionPerformed
        // TODO add your handling code here:
        String itemCode = (String) MI_cb_ItemCode.getSelectedItem();
        String hospitalID = (String) MI_cb_HospitalID.getSelectedItem();
        int quantity;
        if (itemCode == null || itemCode.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a valid item.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            quantity = Integer.parseInt(MI_tf_Quantity.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hospitalID == null || hospitalID.equals("") || quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String supplierCode = InventoryManagement.getSupplierForItem(itemCode);
        if (supplierCode == null || supplierCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No supplier assigned for this item. Please contact the admin to assign a supplier.", "Supplier Not Assigned", JOptionPane.WARNING_MESSAGE);
            MI_tf_Quantity.setText("");
            return;
        }
        String result = InventoryManagement.distributePPEStock(UserSession.getUserID(), itemCode, hospitalID, quantity);
        JOptionPane.showMessageDialog(this, result, "Distribute Stock", JOptionPane.INFORMATION_MESSAGE);
        if (result.startsWith("Stock updated successfully")) {
            loadInventoryData("Distribute");
            MI_tf_Quantity.setText("");
        }
    }//GEN-LAST:event_btn_Save1ActionPerformed

    private void btn_Cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancel1ActionPerformed
        // TODO add your handling code here:
        Card_ManageInventory.removeAll();
        Card_ManageInventory.add(ManageInventoryHome);
        Card_ManageInventory.revalidate();
        Card_ManageInventory.repaint();
        loadInventoryData("Home");
        IM_tf_Search.setText("");
    }//GEN-LAST:event_btn_Cancel1ActionPerformed

    private void MI_tf_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_tf_Search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_tf_Search1ActionPerformed

    private void btn_Refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh2ActionPerformed
        // TODO add your handling code here:
        btnRefresh("Distribute");
    }//GEN-LAST:event_btn_Refresh2ActionPerformed

    private void tb_ReceiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ReceiveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_ReceiveMouseClicked

    private void btn_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search2ActionPerformed
        // TODO add your handling code here:
        btnSearch("Receive");
    }//GEN-LAST:event_btn_Search2ActionPerformed

    private void btn_Save2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btn_Save2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Save2AncestorMoved

    private void btn_Save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save2ActionPerformed
        // TODO add your handling code here:
        String itemCode = (String) MI_cb_ItemCode1.getSelectedItem();
        int quantity;
        if (itemCode == null || itemCode.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a valid item.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            quantity = Integer.parseInt(MI_tf_Quantity1.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String supplierCode = InventoryManagement.getSupplierForItem(itemCode);
        if (supplierCode == null || supplierCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No supplier assigned for this item. Please contact the admin to assign a supplier.", "Supplier Not Assigned", JOptionPane.WARNING_MESSAGE);
            MI_tf_Quantity1.setText("");
            return;
        }
        String result = InventoryManagement.receivePPEStock(UserSession.getUserID(), itemCode, quantity);
        JOptionPane.showMessageDialog(this, result, "Receive Stock", JOptionPane.INFORMATION_MESSAGE);
        if (result.startsWith("Stock updated successfully")) {
            loadInventoryData("Receive");
            MI_tf_Quantity1.setText("");
        }
    }//GEN-LAST:event_btn_Save2ActionPerformed

    private void btn_Cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancel2ActionPerformed
        // TODO add your handling code here:
        Card_ManageInventory.removeAll();
        Card_ManageInventory.add(ManageInventoryHome);
        Card_ManageInventory.revalidate();
        Card_ManageInventory.repaint();
        loadInventoryData("Home");
        IM_tf_Search.setText("");
    }//GEN-LAST:event_btn_Cancel2ActionPerformed

    private void MI_tf_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_tf_Search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_tf_Search2ActionPerformed

    private void btn_Refresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh3ActionPerformed
        // TODO add your handling code here:
        btnRefresh("Receive");
    }//GEN-LAST:event_btn_Refresh3ActionPerformed

    private void MI_cb_ItemCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_cb_ItemCode1ActionPerformed
        // TODO add your handling code here:
        String selectedItemCode = (String) MI_cb_ItemCode1.getSelectedItem();
        if (selectedItemCode != null && !selectedItemCode.isEmpty()) {
            updateSupplierIDForItem(selectedItemCode);
        }
    }//GEN-LAST:event_MI_cb_ItemCode1ActionPerformed

    private void MI_cb_ItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_cb_ItemCodeActionPerformed
        // TODO add your handling code here:
        String selectedItemCode = (String) MI_cb_ItemCode.getSelectedItem();
        if (selectedItemCode != null && !selectedItemCode.isEmpty()) {
            updateSupplierIDForItem(selectedItemCode);
        }
    }//GEN-LAST:event_MI_cb_ItemCodeActionPerformed

    private void btnSearch(String panel) {
        JTable table;
        String searchTerm;
        JTextField textField;
        switch (panel) {
            case "Home":
                table = MI_tb_Home;
                textField = IM_tf_Search;
                searchTerm = textField.getText();
                break;
            case "Receive":
                table = tb_Receive;
                textField = MI_tf_Search2;
                searchTerm = textField.getText();
                break;
            case "Distribute":
                table = tb_Distribute;
                textField = MI_tf_Search1;
                searchTerm = textField.getText();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid table.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<?> searchResults = InventoryManagement.searchInventory(searchTerm);
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for '" + searchTerm + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            textField.setText("");
        } else {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Object result : searchResults) {
                if (result instanceof Inventory) {
                    Inventory inv = (Inventory) result;
                    model.addRow(new Object[]{inv.getItemCode(), inv.getItemName(), inv.getQuantityInStock(), inv.getSupplierCode()});
                }
            }
        }
    }
    
    private void btnRefresh(String panel){
        JTextField textField;
        switch (panel) {
            case "Home":
                textField = IM_tf_Search;
                textField.setText("");
                break;
            case "Receive":
                textField = MI_tf_Search2;
                textField.setText("");
                break;
            case "Distribute":
                textField = MI_tf_Search1;
                textField.setText("");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid table.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        loadInventoryData(panel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card_ManageInventory;
    private javax.swing.JPanel Distribute;
    private javax.swing.JLabel IM_lbl_Search;
    private javax.swing.JTextField IM_tf_Search;
    private javax.swing.JComboBox<String> MI_cb_HospitalID;
    private javax.swing.JComboBox<String> MI_cb_ItemCode;
    private javax.swing.JComboBox<String> MI_cb_ItemCode1;
    private javax.swing.JComboBox<String> MI_cb_SupplierID;
    private javax.swing.JLabel MI_lbl_HospitalID;
    private javax.swing.JLabel MI_lbl_ItemCode;
    private javax.swing.JLabel MI_lbl_ItemCode1;
    private javax.swing.JLabel MI_lbl_Quatity;
    private javax.swing.JLabel MI_lbl_Quatity1;
    private javax.swing.JLabel MI_lbl_Search1;
    private javax.swing.JLabel MI_lbl_Search2;
    private javax.swing.JLabel MI_lbl_SupplierID;
    private javax.swing.JTable MI_tb_Home;
    private javax.swing.JTextField MI_tf_Quantity;
    private javax.swing.JTextField MI_tf_Quantity1;
    private javax.swing.JTextField MI_tf_Search1;
    private javax.swing.JTextField MI_tf_Search2;
    private javax.swing.JPanel ManageInventoryHome;
    private javax.swing.JPanel Receive;
    private javax.swing.JButton UE_btn_Back;
    private javax.swing.JButton btn_Cancel1;
    private javax.swing.JButton btn_Cancel2;
    private javax.swing.JButton btn_Distribute;
    private javax.swing.JButton btn_Receive;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_Refresh2;
    private javax.swing.JButton btn_Refresh3;
    private javax.swing.JButton btn_Save1;
    private javax.swing.JButton btn_Save2;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JButton btn_Search2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tb_Distribute;
    private javax.swing.JTable tb_Receive;
    // End of variables declaration//GEN-END:variables
}
