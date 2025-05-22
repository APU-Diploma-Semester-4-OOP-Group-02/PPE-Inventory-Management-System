package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.configuration.DropdownUtils;
import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import javax.swing.JOptionPane;


public class PopUp_IM_UpdateStock extends javax.swing.JFrame {

    private GUI_InventoryManagement parent;
    private boolean isInitializing = true; 
    /**
     * Creates new form PopUp_IM_AddNewItem
     * @param parent
     */
    public PopUp_IM_UpdateStock(GUI_InventoryManagement parent) {
        this.parent = parent;
        initComponents();
        IM_btn_Cancel.addActionListener(e -> dispose());
        IM_btn_Cancel1.addActionListener(e -> dispose());
        jPanel1.removeAll();
        jPanel1.add(Receive);
        jPanel1.repaint();
        jPanel1.revalidate();
        DropdownUtils.populateItemCodeDropdown(IM_cb_ItemCode);
        DropdownUtils.populateItemCodeDropdown(IM_cb_ItemCode1);
        DropdownUtils.populateSupplierIDDropdown(IM_cb_SupplierID);
        IM_cb_SupplierID.setEnabled(false);
        DropdownUtils.populateHospitalIDDropdown(IM_cb_HospitalID);
        isInitializing = false;
    }
    
    private void updateSupplierIDForItem(String itemCode) {
        if (itemCode == null || itemCode.equals("")) {
            IM_cb_SupplierID.setSelectedItem(null);
            IM_cb_SupplierID.setEnabled(false);
            return;
        }
        String supplierCode = InventoryManagement.getSupplierForItem(itemCode);
        if (supplierCode != null && !supplierCode.isEmpty()) {
            IM_cb_SupplierID.setSelectedItem(supplierCode);
            IM_cb_SupplierID.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "No supplier assigned for this item. Please assign a supplier first.", "Supplier Not Assigned", JOptionPane.ERROR_MESSAGE);
            dispose();
            PopUp_IM_SetSupplier setSupplierPopUp = new PopUp_IM_SetSupplier(parent, itemCode);
            setSupplierPopUp.setLocationRelativeTo(this);
            setSupplierPopUp.setVisible(true);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_Distribute = new javax.swing.JButton();
        btn_Receive = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Receive = new javax.swing.JPanel();
        IM_lbl_Quantity = new javax.swing.JLabel();
        IM_lbl_ItemCode = new javax.swing.JLabel();
        IM_lbl_SupplierID = new javax.swing.JLabel();
        IM_tf_Quantity = new javax.swing.JTextField();
        IM_cb_SupplierID = new javax.swing.JComboBox<>();
        IM_btn_Save = new javax.swing.JButton();
        IM_btn_Cancel = new javax.swing.JButton();
        IM_cb_ItemCode = new javax.swing.JComboBox<>();
        Distribute = new javax.swing.JPanel();
        IM_lbl_Quantity1 = new javax.swing.JLabel();
        IM_lbl_ItemCode1 = new javax.swing.JLabel();
        IM_lbl_HospitalID = new javax.swing.JLabel();
        IM_tf_Quantity1 = new javax.swing.JTextField();
        IM_cb_HospitalID = new javax.swing.JComboBox<>();
        IM_btn_Save1 = new javax.swing.JButton();
        IM_btn_Cancel1 = new javax.swing.JButton();
        IM_cb_ItemCode1 = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(4, 99, 174));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 70));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 70));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update Stock");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 0, 164, 30));

        btn_Distribute.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Distribute.setText("Distribute");
        btn_Distribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DistributeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Distribute, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 35, 95, 30));

        btn_Receive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Receive.setText("Receive");
        btn_Receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReceiveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 35, 95, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        jPanel1.setBackground(new java.awt.Color(224, 247, 250));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 230));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 230));
        jPanel1.setLayout(new java.awt.CardLayout());

        Receive.setBackground(new java.awt.Color(224, 247, 250));
        Receive.setMinimumSize(new java.awt.Dimension(500, 230));
        Receive.setPreferredSize(new java.awt.Dimension(500, 230));
        Receive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IM_lbl_Quantity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_Quantity.setText("Quantity:");
        Receive.add(IM_lbl_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 125, 80, 20));

        IM_lbl_ItemCode.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_ItemCode.setText("Item ID:");
        Receive.add(IM_lbl_ItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 35, 80, 20));

        IM_lbl_SupplierID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_SupplierID.setText("Supplier ID:");
        Receive.add(IM_lbl_SupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 80, 20));
        Receive.add(IM_tf_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 122, 180, -1));

        IM_cb_SupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IM_cb_SupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_cb_SupplierIDActionPerformed(evt);
            }
        });
        Receive.add(IM_cb_SupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 77, 180, 25));

        IM_btn_Save.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        IM_btn_Save.setText("Save");
        IM_btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_SaveActionPerformed(evt);
            }
        });
        Receive.add(IM_btn_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 80, 28));

        IM_btn_Cancel.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        IM_btn_Cancel.setText("Cancel");
        Receive.add(IM_btn_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 80, 28));

        IM_cb_ItemCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IM_cb_ItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_cb_ItemCodeActionPerformed(evt);
            }
        });
        Receive.add(IM_cb_ItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 32, 180, 25));

        jPanel1.add(Receive, "card12");

        Distribute.setBackground(new java.awt.Color(224, 247, 250));
        Distribute.setMinimumSize(new java.awt.Dimension(500, 230));
        Distribute.setPreferredSize(new java.awt.Dimension(500, 230));
        Distribute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IM_lbl_Quantity1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_Quantity1.setText("Quantity:");
        Distribute.add(IM_lbl_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 125, 80, 20));

        IM_lbl_ItemCode1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_ItemCode1.setText("Item ID:");
        Distribute.add(IM_lbl_ItemCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 35, 80, 20));

        IM_lbl_HospitalID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        IM_lbl_HospitalID.setText("Hospital ID:");
        Distribute.add(IM_lbl_HospitalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 80, 20));
        Distribute.add(IM_tf_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 122, 180, -1));

        IM_cb_HospitalID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IM_cb_HospitalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_cb_HospitalIDActionPerformed(evt);
            }
        });
        Distribute.add(IM_cb_HospitalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 77, 180, 25));

        IM_btn_Save1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        IM_btn_Save1.setText("Save");
        IM_btn_Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_btn_Save1ActionPerformed(evt);
            }
        });
        Distribute.add(IM_btn_Save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 80, 28));

        IM_btn_Cancel1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        IM_btn_Cancel1.setText("Cancel");
        Distribute.add(IM_btn_Cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 80, 28));

        IM_cb_ItemCode1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IM_cb_ItemCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IM_cb_ItemCode1ActionPerformed(evt);
            }
        });
        Distribute.add(IM_cb_ItemCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 32, 180, 25));

        jPanel1.add(Distribute, "card12");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 500, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IM_cb_SupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_cb_SupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IM_cb_SupplierIDActionPerformed

    private void IM_cb_ItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_cb_ItemCodeActionPerformed
        // TODO add your handling code here:
        if (isInitializing) {
            return;
        }
        String selectedItemCode = (String) IM_cb_ItemCode.getSelectedItem();
        updateSupplierIDForItem(selectedItemCode);
    }//GEN-LAST:event_IM_cb_ItemCodeActionPerformed

    private void IM_cb_HospitalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_cb_HospitalIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IM_cb_HospitalIDActionPerformed

    private void IM_cb_ItemCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_cb_ItemCode1ActionPerformed
        // TODO add your handling code here:
        if (isInitializing) {
            return;
        }
        String selectedItemCode = (String) IM_cb_ItemCode1.getSelectedItem();
        updateSupplierIDForItem(selectedItemCode);
    }//GEN-LAST:event_IM_cb_ItemCode1ActionPerformed

    private void btn_ReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReceiveActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        jPanel1.add(Receive);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_btn_ReceiveActionPerformed

    private void btn_DistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DistributeActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        jPanel1.add(Distribute);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_btn_DistributeActionPerformed

    private void IM_btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_SaveActionPerformed
        // TODO add your handling code here:
        String itemCode = (String) IM_cb_ItemCode.getSelectedItem();
        int quantity;
        if (itemCode == null || itemCode.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a valid item.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            quantity = Integer.parseInt(IM_tf_Quantity.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = InventoryManagement.receivePPEStock(UserSession.getUserID(), itemCode, quantity);
        JOptionPane.showMessageDialog(this, result, "Receive Stock", JOptionPane.INFORMATION_MESSAGE);
        if (result.startsWith("Stock updated successfully")) {
            parent.loadInventoryData();
            dispose();
        }
    }//GEN-LAST:event_IM_btn_SaveActionPerformed

    private void IM_btn_Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IM_btn_Save1ActionPerformed
        // TODO add your handling code here:
        String itemCode = (String) IM_cb_ItemCode1.getSelectedItem();
        String hospitalID = (String) IM_cb_HospitalID.getSelectedItem();
        int quantity;
        if (itemCode == null || itemCode.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a valid item.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            quantity = Integer.parseInt(IM_tf_Quantity1.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hospitalID == null || hospitalID.equals("") || quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = InventoryManagement.distributePPEStock(UserSession.getUserID(), itemCode, hospitalID, quantity);
        JOptionPane.showMessageDialog(this, result, "Distribute Stock", JOptionPane.INFORMATION_MESSAGE);
        if (result.startsWith("Stock updated successfully")) {
            parent.loadInventoryData();
            dispose();
        }
    }//GEN-LAST:event_IM_btn_Save1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Distribute;
    private javax.swing.JButton IM_btn_Cancel;
    private javax.swing.JButton IM_btn_Cancel1;
    private javax.swing.JButton IM_btn_Save;
    private javax.swing.JButton IM_btn_Save1;
    private javax.swing.JComboBox<String> IM_cb_HospitalID;
    private javax.swing.JComboBox<String> IM_cb_ItemCode;
    private javax.swing.JComboBox<String> IM_cb_ItemCode1;
    private javax.swing.JComboBox<String> IM_cb_SupplierID;
    private javax.swing.JLabel IM_lbl_HospitalID;
    private javax.swing.JLabel IM_lbl_ItemCode;
    private javax.swing.JLabel IM_lbl_ItemCode1;
    private javax.swing.JLabel IM_lbl_Quantity;
    private javax.swing.JLabel IM_lbl_Quantity1;
    private javax.swing.JLabel IM_lbl_SupplierID;
    private javax.swing.JTextField IM_tf_Quantity;
    private javax.swing.JTextField IM_tf_Quantity1;
    private javax.swing.JPanel Receive;
    private javax.swing.JButton btn_Distribute;
    private javax.swing.JButton btn_Receive;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
