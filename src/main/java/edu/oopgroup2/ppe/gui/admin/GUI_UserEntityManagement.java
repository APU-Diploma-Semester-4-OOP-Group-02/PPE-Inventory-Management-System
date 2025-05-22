package edu.oopgroup2.ppe.gui.admin;

import edu.oopgroup2.ppe.configuration.UserSession;
import edu.oopgroup2.ppe.model.hospital.Hospital;
import edu.oopgroup2.ppe.model.hospital.HospitalManagement;
import edu.oopgroup2.ppe.model.staffadmin.StaffAdminManagement;
import edu.oopgroup2.ppe.model.staffadmin.User;
import edu.oopgroup2.ppe.model.supplier.Supplier;
import edu.oopgroup2.ppe.model.supplier.SupplierManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_UserEntityManagement extends JFrame {
    private String currentAction = "";
    private int selectedRow = -1;
    
    public GUI_UserEntityManagement() {
        initComponents();
        setLocationRelativeTo(null);
        selectedRow = -1;
        jPanel2.removeAll();
        jPanel2.add(Admin);
        jPanel2.repaint();
        jPanel2.revalidate();
        disableAllFields();
        loadAdminData();
        btn_Save3.setEnabled(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        UE_btn_Admin = new javax.swing.JButton();
        UE_btn_Staff = new javax.swing.JButton();
        UE_btn_Supplier = new javax.swing.JButton();
        UE_btn_Back = new javax.swing.JButton();
        UE_btn_Hospital = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Staff = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UE_tb_Staff = new javax.swing.JTable();
        UE_lbl_ConfirmPassword = new javax.swing.JLabel();
        UE_lbl_Username = new javax.swing.JLabel();
        UE_lbl_Email = new javax.swing.JLabel();
        UE_lbl_Contact = new javax.swing.JLabel();
        UE_lbl_OldPassword = new javax.swing.JLabel();
        UE_lbl_NewPassword = new javax.swing.JLabel();
        UE_tf_Contact = new javax.swing.JTextField();
        UE_tf_Username = new javax.swing.JTextField();
        UE_tf_Email = new javax.swing.JTextField();
        UE_pf_ConfirmedPassword = new javax.swing.JPasswordField();
        UE_pf_OldPassword = new javax.swing.JPasswordField();
        UE_pf_NewPassword = new javax.swing.JPasswordField();
        btn_Search = new javax.swing.JButton();
        btn_Modify = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        UE_lbl_Search = new javax.swing.JLabel();
        UE_tf_Search = new javax.swing.JTextField();
        btn_Add = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JButton();
        Supplier = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UE_tb_Supplier = new javax.swing.JTable();
        UE_lbl_Username1 = new javax.swing.JLabel();
        UE_lbl_Email1 = new javax.swing.JLabel();
        UE_lbl_Contact1 = new javax.swing.JLabel();
        UE_tf_Contact1 = new javax.swing.JTextField();
        UE_tf_Username1 = new javax.swing.JTextField();
        UE_tf_Email1 = new javax.swing.JTextField();
        btn_Add1 = new javax.swing.JButton();
        btn_Modify1 = new javax.swing.JButton();
        btn_Save1 = new javax.swing.JButton();
        btn_Delete1 = new javax.swing.JButton();
        UE_lbl_Search1 = new javax.swing.JLabel();
        UE_tf_Search1 = new javax.swing.JTextField();
        btn_Search1 = new javax.swing.JButton();
        btn_Refresh1 = new javax.swing.JButton();
        Hospital = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UE_tb_Hospital = new javax.swing.JTable();
        UE_lbl_Username2 = new javax.swing.JLabel();
        UE_lbl_Email2 = new javax.swing.JLabel();
        UE_lbl_Contact2 = new javax.swing.JLabel();
        UE_tf_Contact2 = new javax.swing.JTextField();
        UE_tf_Username2 = new javax.swing.JTextField();
        UE_tf_Email2 = new javax.swing.JTextField();
        btn_Add2 = new javax.swing.JButton();
        btn_Modify2 = new javax.swing.JButton();
        btn_Save2 = new javax.swing.JButton();
        btn_Delete2 = new javax.swing.JButton();
        UE_lbl_Search2 = new javax.swing.JLabel();
        UE_tf_Search2 = new javax.swing.JTextField();
        btn_Search2 = new javax.swing.JButton();
        btn_Refresh2 = new javax.swing.JButton();
        Admin = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        UE_tb_Admin = new javax.swing.JTable();
        UE_lbl_ConfirmPassword1 = new javax.swing.JLabel();
        UE_lbl_Username3 = new javax.swing.JLabel();
        UE_lbl_Email3 = new javax.swing.JLabel();
        UE_lbl_Contact3 = new javax.swing.JLabel();
        UE_lbl_OldPassword1 = new javax.swing.JLabel();
        UE_lbl_NewPassword1 = new javax.swing.JLabel();
        UE_tf_Contact3 = new javax.swing.JTextField();
        UE_tf_Username3 = new javax.swing.JTextField();
        UE_tf_Email3 = new javax.swing.JTextField();
        UE_pf_ConfirmedPassword1 = new javax.swing.JPasswordField();
        UE_pf_OldPassword1 = new javax.swing.JPasswordField();
        UE_pf_NewPassword1 = new javax.swing.JPasswordField();
        btn_Add3 = new javax.swing.JButton();
        btn_Modify3 = new javax.swing.JButton();
        btn_Save3 = new javax.swing.JButton();
        btn_Delete3 = new javax.swing.JButton();
        UE_lbl_Search3 = new javax.swing.JLabel();
        UE_tf_Search3 = new javax.swing.JTextField();
        btn_Search3 = new javax.swing.JButton();
        btn_Refresh3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 99, 174));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_btn_Admin.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Admin.setText("Admin");
        UE_btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_AdminActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, 40));

        UE_btn_Staff.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Staff.setText("Staff");
        UE_btn_Staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_StaffActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 100, 40));

        UE_btn_Supplier.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Supplier.setText("Supplier");
        UE_btn_Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_SupplierActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 100, 40));

        UE_btn_Back.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Back.setText("Back");
        UE_btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_BackActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 100, 40));

        UE_btn_Hospital.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        UE_btn_Hospital.setText("Hospital");
        UE_btn_Hospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_btn_HospitalActionPerformed(evt);
            }
        });
        jPanel1.add(UE_btn_Hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 100, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User & Entity Management");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 10, 335, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanel2.setBackground(new java.awt.Color(224, 247, 250));
        jPanel2.setLayout(new java.awt.CardLayout());

        Staff.setBackground(new java.awt.Color(224, 247, 250));
        Staff.setMinimumSize(new java.awt.Dimension(800, 390));
        Staff.setPreferredSize(new java.awt.Dimension(800, 390));
        Staff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_tb_Staff.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        UE_tb_Staff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Username", "Email", "Contact"
            }
        ));
        UE_tb_Staff.setDefaultEditor(Object.class, null);
        UE_tb_Staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UE_tb_StaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UE_tb_Staff);

        Staff.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        UE_lbl_ConfirmPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_ConfirmPassword.setText("Confirmed Password:");
        Staff.add(UE_lbl_ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 145, 15));

        UE_lbl_Username.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Username.setText("Username:");
        Staff.add(UE_lbl_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 145, 15));

        UE_lbl_Email.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Email.setText("Email:");
        Staff.add(UE_lbl_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 145, 15));

        UE_lbl_Contact.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Contact.setText("Contact:");
        Staff.add(UE_lbl_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 145, 15));

        UE_lbl_OldPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_OldPassword.setText("Old Password:");
        Staff.add(UE_lbl_OldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 145, 15));

        UE_lbl_NewPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_NewPassword.setText("New Password:");
        Staff.add(UE_lbl_NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 145, 15));
        Staff.add(UE_tf_Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 125, 145, 25));
        Staff.add(UE_tf_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 25, 145, 25));
        Staff.add(UE_tf_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 75, 145, 25));
        Staff.add(UE_pf_ConfirmedPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 275, 145, 25));
        Staff.add(UE_pf_OldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 175, 145, 25));
        Staff.add(UE_pf_NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 225, 145, 25));

        btn_Search.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        Staff.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Modify.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Modify.setText("Modify");
        btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifyActionPerformed(evt);
            }
        });
        Staff.add(btn_Modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 330, 76, -1));

        btn_Save.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Save.setText("Save");
        btn_Save.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                btn_SaveAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        Staff.add(btn_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 330, 76, -1));

        btn_Delete.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Delete.setText("Delete");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        Staff.add(btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 330, 76, -1));

        UE_lbl_Search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Search.setText("Search:");
        Staff.add(UE_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));

        UE_tf_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UE_tf_SearchActionPerformed(evt);
            }
        });
        Staff.add(UE_tf_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Add.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Add.setText("Add");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        Staff.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 330, 76, -1));

        btn_Refresh.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        Staff.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        jPanel2.add(Staff, "card2");

        Supplier.setBackground(new java.awt.Color(224, 247, 250));
        Supplier.setMinimumSize(new java.awt.Dimension(800, 390));
        Supplier.setPreferredSize(new java.awt.Dimension(800, 390));
        Supplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_tb_Supplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        UE_tb_Supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Email", "Contact"
            }
        ));
        UE_tb_Supplier.setDefaultEditor(Object.class, null);
        UE_tb_Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UE_tb_SupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(UE_tb_Supplier);

        Supplier.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        UE_lbl_Username1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Username1.setText("Supplier Name:");
        Supplier.add(UE_lbl_Username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 145, 15));

        UE_lbl_Email1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Email1.setText("Email:");
        Supplier.add(UE_lbl_Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 145, 15));

        UE_lbl_Contact1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Contact1.setText("Contact:");
        Supplier.add(UE_lbl_Contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 145, 15));
        Supplier.add(UE_tf_Contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 175, 145, 25));
        Supplier.add(UE_tf_Username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 55, 145, 25));
        Supplier.add(UE_tf_Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 115, 145, 25));

        btn_Add1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Add1.setText("Add");
        btn_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 330, 76, -1));

        btn_Modify1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Modify1.setText("Modify");
        btn_Modify1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modify1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Modify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 330, 76, -1));

        btn_Save1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Save1.setText("Save");
        btn_Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 330, 76, -1));

        btn_Delete1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Delete1.setText("Delete");
        btn_Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 330, 76, -1));

        UE_lbl_Search1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Search1.setText("Search:");
        Supplier.add(UE_lbl_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));
        Supplier.add(UE_tf_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Search1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search1.setText("Search");
        btn_Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Refresh1.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh1.setText("Refresh");
        btn_Refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh1ActionPerformed(evt);
            }
        });
        Supplier.add(btn_Refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        jPanel2.add(Supplier, "card2");

        Hospital.setBackground(new java.awt.Color(224, 247, 250));
        Hospital.setMinimumSize(new java.awt.Dimension(800, 390));
        Hospital.setPreferredSize(new java.awt.Dimension(800, 390));
        Hospital.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_tb_Hospital.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        UE_tb_Hospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital ID", "Hospital Name", "Email", "Contact"
            }
        ));
        UE_tb_Hospital.setDefaultEditor(Object.class, null);
        UE_tb_Hospital.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UE_tb_HospitalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(UE_tb_Hospital);

        Hospital.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        UE_lbl_Username2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Username2.setText("Hospital Name:");
        Hospital.add(UE_lbl_Username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 145, 15));

        UE_lbl_Email2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Email2.setText("Email:");
        Hospital.add(UE_lbl_Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 145, 15));

        UE_lbl_Contact2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Contact2.setText("Contact:");
        Hospital.add(UE_lbl_Contact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 145, 15));
        Hospital.add(UE_tf_Contact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 175, 145, 25));
        Hospital.add(UE_tf_Username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 55, 145, 25));
        Hospital.add(UE_tf_Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 115, 145, 25));

        btn_Add2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Add2.setText("Add");
        btn_Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 330, 76, -1));

        btn_Modify2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Modify2.setText("Modify");
        btn_Modify2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modify2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Modify2, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 330, 76, -1));

        btn_Save2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Save2.setText("Save");
        btn_Save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Save2, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 330, 76, -1));

        btn_Delete2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Delete2.setText("Delete");
        btn_Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Delete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 330, 76, -1));

        UE_lbl_Search2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Search2.setText("Search:");
        Hospital.add(UE_lbl_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));
        Hospital.add(UE_tf_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Search2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search2.setText("Search");
        btn_Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Refresh2.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh2.setText("Refresh");
        btn_Refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh2ActionPerformed(evt);
            }
        });
        Hospital.add(btn_Refresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        jPanel2.add(Hospital, "card2");

        Admin.setBackground(new java.awt.Color(224, 247, 250));
        Admin.setMinimumSize(new java.awt.Dimension(800, 390));
        Admin.setPreferredSize(new java.awt.Dimension(800, 390));
        Admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UE_tb_Admin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        UE_tb_Admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Username", "Email", "Contact"
            }
        ));
        UE_tb_Admin.setDefaultEditor(Object.class, null);
        UE_tb_Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UE_tb_AdminMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(UE_tb_Admin);

        Admin.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 280));

        UE_lbl_ConfirmPassword1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_ConfirmPassword1.setText("Confirmed Password:");
        Admin.add(UE_lbl_ConfirmPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 145, 15));

        UE_lbl_Username3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Username3.setText("Username:");
        Admin.add(UE_lbl_Username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 145, 15));

        UE_lbl_Email3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Email3.setText("Email:");
        Admin.add(UE_lbl_Email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 145, 15));

        UE_lbl_Contact3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Contact3.setText("Contact:");
        Admin.add(UE_lbl_Contact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 145, 15));

        UE_lbl_OldPassword1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_OldPassword1.setText("Old Password:");
        Admin.add(UE_lbl_OldPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 145, 15));

        UE_lbl_NewPassword1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_NewPassword1.setText("New Password:");
        Admin.add(UE_lbl_NewPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 145, 15));
        Admin.add(UE_tf_Contact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 125, 145, 25));
        Admin.add(UE_tf_Username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 25, 145, 25));
        Admin.add(UE_tf_Email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 75, 145, 25));
        Admin.add(UE_pf_ConfirmedPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 275, 145, 25));
        Admin.add(UE_pf_OldPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 175, 145, 25));
        Admin.add(UE_pf_NewPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 225, 145, 25));

        btn_Add3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Add3.setText("Add");
        btn_Add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 330, 76, -1));

        btn_Modify3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Modify3.setText("Modify");
        btn_Modify3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modify3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Modify3, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 330, 76, -1));

        btn_Save3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Save3.setText("Save");
        btn_Save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Save3, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 330, 76, -1));

        btn_Delete3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Delete3.setText("Delete");
        btn_Delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Delete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 330, 76, -1));

        UE_lbl_Search3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        UE_lbl_Search3.setText("Search:");
        Admin.add(UE_lbl_Search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 46, 15));
        Admin.add(UE_tf_Search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 25, 180, 25));

        btn_Search3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Search3.setText("Search");
        btn_Search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 24, 80, -1));

        btn_Refresh3.setFont(new java.awt.Font("Tw Cen MT", 2, 15)); // NOI18N
        btn_Refresh3.setText("Refresh");
        btn_Refresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Refresh3ActionPerformed(evt);
            }
        });
        Admin.add(btn_Refresh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 24, 80, -1));

        jPanel2.add(Admin, "card2");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 390));

        setBounds(0, 0, 814, 498);
    }// </editor-fold>//GEN-END:initComponents
    private void clearFields() {
        JTextField[] textFields = {UE_tf_Search, UE_tf_Search1, UE_tf_Search2, UE_tf_Search3, UE_tf_Username, UE_tf_Username1, UE_tf_Username2, UE_tf_Username3, UE_tf_Contact,  UE_tf_Contact1,  UE_tf_Contact2,  UE_tf_Contact3,  UE_tf_Email, UE_tf_Email1, UE_tf_Email2, UE_tf_Email3};
        JPasswordField[] passwordFields = {UE_pf_OldPassword, UE_pf_OldPassword1, UE_pf_NewPassword, UE_pf_NewPassword1, UE_pf_ConfirmedPassword, UE_pf_ConfirmedPassword1};
        for (JTextField tf : textFields) {
            tf.setText("");
        }
        for (JPasswordField pf : passwordFields) {
            pf.setText("");
        }
    }
    
    private void disableAllFields() {
    JTextField[] textFields = {UE_tf_Username, UE_tf_Username1, UE_tf_Username2, UE_tf_Username3, UE_tf_Contact,  UE_tf_Contact1,  UE_tf_Contact2,  UE_tf_Contact3,  UE_tf_Email, UE_tf_Email1, UE_tf_Email2, UE_tf_Email3};
    JPasswordField[] passwordFields = {UE_pf_OldPassword, UE_pf_OldPassword1, UE_pf_NewPassword, UE_pf_NewPassword1, UE_pf_ConfirmedPassword, UE_pf_ConfirmedPassword1};
    for (JTextField tf : textFields) {
        tf.setEnabled(false);
    }
    for (JPasswordField pf : passwordFields) {
        pf.setEnabled(false);
    }
}

    private void enableFieldsForAction(String action) {
        JTextField[] textFields = {UE_tf_Username, UE_tf_Username1, UE_tf_Username2, UE_tf_Username3, UE_tf_Contact,  UE_tf_Contact1,  UE_tf_Contact2,  UE_tf_Contact3,  UE_tf_Email, UE_tf_Email1, UE_tf_Email2, UE_tf_Email3};
        JPasswordField[] passwordFields = {UE_pf_OldPassword, UE_pf_OldPassword1, UE_pf_NewPassword, UE_pf_NewPassword1, UE_pf_ConfirmedPassword, UE_pf_ConfirmedPassword1};
        if (action.equalsIgnoreCase("Add")){    
        for (JTextField tf : textFields) {
                tf.setEnabled(true);
         }
        UE_pf_NewPassword.setEnabled(true);
        UE_pf_NewPassword1.setEnabled(true);
        UE_pf_ConfirmedPassword.setEnabled(true);
        UE_pf_ConfirmedPassword1.setEnabled(true);
        } else if (action.equalsIgnoreCase("Modify")) {
            for (JTextField tf : textFields) {
                tf.setEnabled(true);
            }
            for (JPasswordField pf : passwordFields) {
                pf.setEnabled(true);
            }
        }
    }
    
    private void loadAdminData() {
        DefaultTableModel model = (DefaultTableModel) UE_tb_Admin.getModel();
        model.setRowCount(0);
        List<String> adminList = StaffAdminManagement.getAllAdmins();
        for (String admin : adminList) {
            String[] adminDetails = admin.split(",");
            model.addRow(new Object[]{adminDetails[0], adminDetails[1], adminDetails[4], adminDetails[5]});
        }
    }
    
    private void loadStaffData() {
        DefaultTableModel model = (DefaultTableModel) UE_tb_Staff.getModel();
        model.setRowCount(0);
        List<String> staffList = StaffAdminManagement.getAllStaffs();
        for (String staff : staffList) {
            String[] staffDetails = staff.split(",");
            model.addRow(new Object[]{staffDetails[0], staffDetails[1], staffDetails[4], staffDetails[5]});
        }
    }
    
    private void loadHospitalData() {
        DefaultTableModel model = (DefaultTableModel) UE_tb_Hospital.getModel();
        model.setRowCount(0);
        List<String> hospitalList = HospitalManagement.getAllHospitals();
        for (String hospital : hospitalList) {
            String[] hospitalDetails = hospital.split(",");
            model.addRow(new Object[]{hospitalDetails[0], hospitalDetails[1], hospitalDetails[2], hospitalDetails[3]});
        }
    }
    
    private void loadSupplierData() {
        DefaultTableModel model = (DefaultTableModel) UE_tb_Supplier.getModel();
        model.setRowCount(0);
        List<String> supplierList = SupplierManagement.getAllSuppliers();
        for (String supplier : supplierList) {
            String[] supplierDetails = supplier.split(",");
            model.addRow(new Object[]{supplierDetails[0], supplierDetails[1], supplierDetails[2], supplierDetails[3]});
        }
    }

    private void UE_btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_AdminActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(Admin);
        jPanel2.repaint();
        jPanel2.revalidate();
        disableAllFields();
        loadAdminData();
        selectedRow = -1;
        UE_tf_Search3.setText("");
        btn_Save3.setEnabled(false);
    }//GEN-LAST:event_UE_btn_AdminActionPerformed

    private void UE_btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_BackActionPerformed
        // TODO add your handling code here:
        new GUI_AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UE_btn_BackActionPerformed

    private void UE_btn_HospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_HospitalActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(Hospital);
        jPanel2.repaint();
        jPanel2.revalidate();
        disableAllFields();
        loadHospitalData();
        selectedRow = -1;
        UE_tf_Search2.setText("");
        btn_Save2.setEnabled(false);
    }//GEN-LAST:event_UE_btn_HospitalActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        btnSearch("Staff");
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        saveData("Staff", currentAction);
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add1ActionPerformed
        // TODO add your handling code here:
        btnAdd("Supplier");
    }//GEN-LAST:event_btn_Add1ActionPerformed

    private void btn_Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save1ActionPerformed
        // TODO add your handling code here:
        saveData("Supplier", currentAction);
    }//GEN-LAST:event_btn_Save1ActionPerformed

    private void btn_Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add2ActionPerformed
        // TODO add your handling code here:
        btnAdd("Hospital");
    }//GEN-LAST:event_btn_Add2ActionPerformed

    private void btn_Save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save2ActionPerformed
        // TODO add your handling code here:
        saveData("Hospital", currentAction);
    }//GEN-LAST:event_btn_Save2ActionPerformed

    private void btn_Add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add3ActionPerformed
        // TODO add your handling code here:
        btnAdd("Admin");
    }//GEN-LAST:event_btn_Add3ActionPerformed

    private void btn_Save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save3ActionPerformed
        // TODO add your handling code here:
        saveData("Admin", currentAction);
    }//GEN-LAST:event_btn_Save3ActionPerformed

    private void UE_btn_SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_SupplierActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(Supplier);
        jPanel2.repaint();
        jPanel2.revalidate();
        disableAllFields();
        loadSupplierData();
        selectedRow = -1;
        UE_tf_Search1.setText("");
        btn_Save1.setEnabled(false);
    }//GEN-LAST:event_UE_btn_SupplierActionPerformed

    private void UE_btn_StaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_btn_StaffActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(Staff);
        jPanel2.repaint();
        jPanel2.revalidate();
        disableAllFields();
        loadStaffData();
        selectedRow = -1;
        UE_tf_Search.setText("");
        btn_Save.setEnabled(false);
    }//GEN-LAST:event_UE_btn_StaffActionPerformed

    private void btn_Modify3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modify3ActionPerformed
        // TODO add your handling code here:
        btnModify("Admin");
    }//GEN-LAST:event_btn_Modify3ActionPerformed

    private void btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifyActionPerformed
        // TODO add your handling code here:
        btnModify("Staff");
    }//GEN-LAST:event_btn_ModifyActionPerformed

    private void btn_Modify1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modify1ActionPerformed
        // TODO add your handling code here:
        btnModify("Supplier");
    }//GEN-LAST:event_btn_Modify1ActionPerformed

    private void btn_Modify2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modify2ActionPerformed
        // TODO add your handling code here:
        btnModify("Hospital");
    }//GEN-LAST:event_btn_Modify2ActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        btnAdd("Staff");
    }//GEN-LAST:event_btn_AddActionPerformed

    private void UE_tf_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UE_tf_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UE_tf_SearchActionPerformed

    private void btn_Search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search2ActionPerformed
        // TODO add your handling code here:
        btnSearch("Hospital");
    }//GEN-LAST:event_btn_Search2ActionPerformed

    private void btn_Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search1ActionPerformed
        // TODO add your handling code here:
        btnSearch("Supplier");
    }//GEN-LAST:event_btn_Search1ActionPerformed

    private void btn_Search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search3ActionPerformed
        // TODO add your handling code here:
        btnSearch("Admin");
    }//GEN-LAST:event_btn_Search3ActionPerformed

    private void UE_tb_AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UE_tb_AdminMouseClicked
        // TODO add your handling code here:
        selectedRow = UE_tb_Admin.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) UE_tb_Admin.getValueAt(selectedRow, 1); 
            String email = (String) UE_tb_Admin.getValueAt(selectedRow, 2);
            String contact = (String) UE_tb_Admin.getValueAt(selectedRow, 3);
            UE_tf_Username3.setText(username);
            UE_tf_Email3.setText(email);
            UE_tf_Contact3.setText(contact);
        }
    }//GEN-LAST:event_UE_tb_AdminMouseClicked

    private void UE_tb_StaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UE_tb_StaffMouseClicked
        // TODO add your handling code here:
        selectedRow = UE_tb_Staff.getSelectedRow(); 
        if (selectedRow != -1) {
            String username = (String) UE_tb_Staff.getValueAt(selectedRow, 1); 
            String email = (String) UE_tb_Staff.getValueAt(selectedRow, 2);
            String contact = (String) UE_tb_Staff.getValueAt(selectedRow, 3);
            UE_tf_Username.setText(username);
            UE_tf_Email.setText(email);
            UE_tf_Contact.setText(contact);
        }
    }//GEN-LAST:event_UE_tb_StaffMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        loadStaffData();
        clearFields();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void btn_Refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh1ActionPerformed
        // TODO add your handling code here:
        loadSupplierData();
        clearFields();
    }//GEN-LAST:event_btn_Refresh1ActionPerformed

    private void btn_Refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh2ActionPerformed
        // TODO add your handling code here:
        loadHospitalData();
        clearFields();
    }//GEN-LAST:event_btn_Refresh2ActionPerformed

    private void btn_Refresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh3ActionPerformed
        // TODO add your handling code here:
        loadAdminData();
        clearFields();
    }//GEN-LAST:event_btn_Refresh3ActionPerformed

    private void UE_tb_SupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UE_tb_SupplierMouseClicked
        // TODO add your handling code here:
        selectedRow = UE_tb_Supplier.getSelectedRow(); 
        if (selectedRow != -1) {
            String name = (String) UE_tb_Supplier.getValueAt(selectedRow, 1); 
            String email = (String) UE_tb_Supplier.getValueAt(selectedRow, 2);
            String contact = (String) UE_tb_Supplier.getValueAt(selectedRow, 3);
            UE_tf_Username1.setText(name);
            UE_tf_Email1.setText(email);
            UE_tf_Contact1.setText(contact);
        }
    }//GEN-LAST:event_UE_tb_SupplierMouseClicked

    private void UE_tb_HospitalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UE_tb_HospitalMouseClicked
        // TODO add your handling code here:
        selectedRow = UE_tb_Hospital.getSelectedRow(); 
        if (selectedRow != -1) {
            String name = (String) UE_tb_Hospital.getValueAt(selectedRow, 1); 
            String email = (String) UE_tb_Hospital.getValueAt(selectedRow, 2);
            String contact = (String) UE_tb_Hospital.getValueAt(selectedRow, 3);
            UE_tf_Username2.setText(name);
            UE_tf_Email2.setText(email);
            UE_tf_Contact2.setText(contact);
        }
    }//GEN-LAST:event_UE_tb_HospitalMouseClicked

    private void btn_SaveAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_btn_SaveAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SaveAncestorMoved

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        btnDelete("Staff");
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete1ActionPerformed
        // TODO add your handling code here:
        btnDelete("Supplier");
    }//GEN-LAST:event_btn_Delete1ActionPerformed

    private void btn_Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete2ActionPerformed
        // TODO add your handling code here:
        btnDelete("Hospital");
    }//GEN-LAST:event_btn_Delete2ActionPerformed

    private void btn_Delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete3ActionPerformed
        // TODO add your handling code here:
        btnDelete("Admin");
    }//GEN-LAST:event_btn_Delete3ActionPerformed

    private void btnSearch(String role) {
        disableAllFields();
        String searchTerm;
        JTable table;
        switch (role) {
            case "Admin":
                searchTerm = UE_tf_Search3.getText().trim();
                table = UE_tb_Admin;
                break;
            case "Staff":
                searchTerm = UE_tf_Search.getText().trim();
                table = UE_tb_Staff;
                break;
            case "Supplier":
                searchTerm = UE_tf_Search1.getText().trim();
                table = UE_tb_Supplier;
                break;
            case "Hospital":
                searchTerm = UE_tf_Search2.getText().trim();
                table = UE_tb_Hospital;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<?> searchResults = new ArrayList<>();
        switch (role) {
            case "Admin":
                searchResults = StaffAdminManagement.searchUser(searchTerm, "Admin");
                break;
            case "Staff":
                searchResults = StaffAdminManagement.searchUser(searchTerm, "Staff");
                break;
            case "Supplier":
                searchResults = SupplierManagement.searchSupplier(searchTerm);
                break;
            case "Hospital":
                searchResults = HospitalManagement.searchHospital(searchTerm);
                break;
        }
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for '" + searchTerm + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Object result : searchResults) {
                if (result instanceof User) {
                    User user = (User) result;
                    model.addRow(new Object[]{
                        user.getID(),
                        user.getName(),
                        user.getUserType(),
                        user.getEmail(),
                        user.getContact()
                    });
                } else if (result instanceof Supplier) {
                    Supplier supplier = (Supplier) result;
                    model.addRow(new Object[]{
                        supplier.getSupplierCode(),
                        supplier.getSupplierName(),
                        supplier.getEmail(),
                        supplier.getContact()
                    });
                } else if (result instanceof Hospital) {
                    Hospital hospital = (Hospital) result;
                    model.addRow(new Object[]{
                        hospital.getHospitalCode(),
                        hospital.getHospitalName(),
                        hospital.getEmail(),
                        hospital.getContact()
                    });
                }
            }
        }
    }
        
    private void btnDelete(String role) {
        disableAllFields();
        String userID = UserSession.getUserID();
        String deleteID;
        switch (role) {
            case "Admin":
                selectedRow = UE_tb_Admin.getSelectedRow();
                break;
            case "Staff":
                selectedRow = UE_tb_Staff.getSelectedRow();
                break;
            case "Supplier":
                selectedRow = UE_tb_Supplier.getSelectedRow();
                break;
            case "Hospital":
                selectedRow = UE_tb_Hospital.getSelectedRow();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        switch (role) {
            case "Admin":
                deleteID = UE_tb_Admin.getValueAt(selectedRow, 0).toString();
                break;
            case "Staff":
                deleteID = UE_tb_Staff.getValueAt(selectedRow, 0).toString();
                break;
            case "Supplier":
                deleteID = UE_tb_Supplier.getValueAt(selectedRow, 0).toString();
                break;
            case "Hospital":
                deleteID = UE_tb_Hospital.getValueAt(selectedRow, 0).toString();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (deleteID.equals(userID)) {
            JOptionPane.showMessageDialog(this, "You cannot delete yourself.", "Deletion Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + role.toLowerCase() + " with ID " + deleteID + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String result;
        switch (role) {
            case "Admin":
            case "Staff":
                result = StaffAdminManagement.deleteUser(userID, deleteID);
                break;
            case "Supplier":
                result = SupplierManagement.deleteSupplier(userID, deleteID);
                break;
            case "Hospital":
                result = HospitalManagement.deleteHospital(userID, deleteID);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        JOptionPane.showMessageDialog(this, result, "Deletion Result", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
        loadAdminData();
        loadStaffData();
        loadSupplierData();
        loadHospitalData();
        selectedRow = -1;
    }
    
    private void btnModify(String role) {
        disableAllFields();
        currentAction = "Modify";
        switch (role) {
            case "Admin":
                selectedRow = UE_tb_Admin.getSelectedRow();
                btn_Save3.setEnabled(true);
                break;
            case "Staff":
                selectedRow = UE_tb_Staff.getSelectedRow();
                btn_Save.setEnabled(true);
                break;
            case "Supplier":
                selectedRow = UE_tb_Supplier.getSelectedRow();
                btn_Save1.setEnabled(true);
                break;
            case "Hospital":
                selectedRow = UE_tb_Hospital.getSelectedRow();
                btn_Save2.setEnabled(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to modify.", "No Selection", JOptionPane.WARNING_MESSAGE);
            btn_Save.setEnabled(false);
            btn_Save1.setEnabled(false);
            btn_Save2.setEnabled(false);
            btn_Save3.setEnabled(false);
            return;
        }
        enableFieldsForAction("Modify");
    }
    
    private void btnAdd(String role) {
        currentAction = "Add";
        int choice;
        switch (role) {
            case "Admin":
                btn_Save3.setEnabled(true);
                choice = JOptionPane.showConfirmDialog(this, "Do you want to add a new admin?", "Confirm Action", JOptionPane.YES_NO_OPTION);
                JOptionPane.showMessageDialog(this, "PS. Password Requirement \n1. Containt at least 8 characters \n2. Contain both uppercase and lowercase letters \n3. Contain both letters and numbers", "Add Admin", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Staff":
                btn_Save.setEnabled(true);
                choice = JOptionPane.showConfirmDialog(this, "Do you want to add a new staff?", "Confirm Action", JOptionPane.YES_NO_OPTION);
                JOptionPane.showMessageDialog(this, "PS. Password Requirement \n1. Containt at least 8 characters \n2. Contain both uppercase and lowercase letters \n3. Contain both letters and numbers", "Add Staff", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Supplier":
                btn_Save1.setEnabled(true);
                choice = JOptionPane.showConfirmDialog(this, "Do you want to add a new supplier?", "Confirm Action", JOptionPane.YES_NO_OPTION);
                break;
            case "Hospital":
                btn_Save2.setEnabled(true);
                choice = JOptionPane.showConfirmDialog(this, "Do you want to add a new hospital?", "Confirm Action", JOptionPane.YES_NO_OPTION);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        if (choice == JOptionPane.YES_OPTION) {
            enableFieldsForAction("Add");
        } else {
            disableAllFields();
            btn_Save.setEnabled(false);
            btn_Save1.setEnabled(false);
            btn_Save2.setEnabled(false);
            btn_Save3.setEnabled(false);
        }
    }
    
    private void saveData(String role, String action) {
        String name, email, contact, oldPassword, newPassword, confirmPassword;
        String userID = UserSession.getUserID();
        String result = " ";
        switch (role) {
            case "Admin":
                btn_Save3.setEnabled(false);
                name = UE_tf_Username3.getText().trim();
                email = UE_tf_Email3.getText().trim();
                contact = UE_tf_Contact3.getText().trim();
                oldPassword = new String(UE_pf_OldPassword1.getPassword());
                newPassword = new String(UE_pf_NewPassword1.getPassword());
                confirmPassword = new String(UE_pf_ConfirmedPassword1.getPassword());
                // add
                if (action.equals("Add")) {
                    result = StaffAdminManagement.addUser(userID, name, "Admin", newPassword, confirmPassword, email, contact);
                } else if (action.equals("Modify")) { // modify
                    selectedRow = UE_tb_Admin.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Please select a row to modify.", "No Selection", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String selectedUserID = (String) UE_tb_Admin.getValueAt(selectedRow, 0);
                    boolean nameChanged = !name.equals((String) UE_tb_Admin.getValueAt(selectedRow, 1));
                    boolean emailChanged = !email.equals((String) UE_tb_Admin.getValueAt(selectedRow, 2));
                    boolean contactChanged = !contact.equals((String) UE_tb_Admin.getValueAt(selectedRow, 3));
                    boolean passwordChanged = !newPassword.isEmpty();
                    if (nameChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "name", name, oldPassword, confirmPassword);
                    }
                    if (emailChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "email", email, oldPassword, confirmPassword);
                    }
                    if (contactChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "contact", contact, oldPassword, confirmPassword);
                    }
                    if (passwordChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "password", newPassword, oldPassword, confirmPassword);
                    }
                    if (!nameChanged && !emailChanged && !contactChanged && !passwordChanged) {
                        result = "No changes detected.";
                    }
                }
                break;
            case "Staff":
                btn_Save.setEnabled(false);
                name = UE_tf_Username.getText().trim();
                email = UE_tf_Email.getText().trim();
                contact = UE_tf_Contact.getText().trim();
                oldPassword = new String(UE_pf_OldPassword.getPassword());
                newPassword = new String(UE_pf_NewPassword.getPassword());
                confirmPassword = new String(UE_pf_ConfirmedPassword.getPassword());
                // add
                if (action.equals("Add")) {
                    result = StaffAdminManagement.addUser(userID, name, "Staff", newPassword, confirmPassword, email, contact);
                } else if (action.equals("Modify")) { // modify
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Please select a row to modify.", "No Selection", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String selectedUserID = (String) UE_tb_Staff.getValueAt(selectedRow, 0);
                    boolean nameChanged = !name.equals((String) UE_tb_Staff.getValueAt(selectedRow, 1));
                    boolean emailChanged = !email.equals((String) UE_tb_Staff.getValueAt(selectedRow, 2));
                    boolean contactChanged = !contact.equals((String) UE_tb_Staff.getValueAt(selectedRow, 3));
                    boolean passwordChanged = !newPassword.isEmpty();
                    if (nameChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "name", name, oldPassword, confirmPassword);
                    }
                    if (emailChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "email", email, oldPassword, confirmPassword);
                    }
                    if (contactChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "contact", contact, oldPassword, confirmPassword);
                    }
                    if (passwordChanged) {
                        result = StaffAdminManagement.adminModify(userID, selectedUserID, "password", newPassword, oldPassword, confirmPassword);
                    }
                    if (!nameChanged && !emailChanged && !contactChanged && !passwordChanged) {
                        result = "No changes detected.";
                    }
                }
                break;
            case "Supplier":
                btn_Save1.setEnabled(false);
                name = UE_tf_Username1.getText().trim();
                email = UE_tf_Email1.getText().trim();
                contact = UE_tf_Contact1.getText().trim();
                // add
                if (action.equals("Add")) {
                    result = SupplierManagement.addSupplier(userID, name, email, contact);
                } else if (action.equals("Modify")) { // modify
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Please select a row to modify.", "No Selection", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String selectedSupplierID = (String) UE_tb_Supplier.getValueAt(selectedRow, 0);
                    boolean nameChanged = !name.equals((String) UE_tb_Supplier.getValueAt(selectedRow, 1));
                    boolean emailChanged = !email.equals((String) UE_tb_Supplier.getValueAt(selectedRow, 2));
                    boolean contactChanged = !contact.equals((String) UE_tb_Supplier.getValueAt(selectedRow, 3));
                    if (nameChanged) {
                        result = SupplierManagement.modifySupplier(userID, selectedSupplierID, "name", name);
                    }
                    if (emailChanged) {
                        result = SupplierManagement.modifySupplier(userID, selectedSupplierID, "email", email);
                    }
                    if (contactChanged) {
                        result = SupplierManagement.modifySupplier(userID, selectedSupplierID, "contact", contact);
                    }
                    if (!nameChanged && !emailChanged && !contactChanged) {
                        result = "No changes detected.";
                    }
                }
                break;
            case "Hospital":
                btn_Save2.setEnabled(false);
                name = UE_tf_Username2.getText().trim();
                email = UE_tf_Email2.getText().trim();
                contact = UE_tf_Contact2.getText().trim();
                // add
                if (action.equals("Add")) {
                    result = HospitalManagement.addHospital(userID, name, email, contact);
                } else if (action.equals("Modify")) { // modify
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Please select a row to modify.", "No Selection", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String selectedHospitalID = (String) UE_tb_Hospital.getValueAt(selectedRow, 0);
                    boolean nameChanged = !name.equals((String) UE_tb_Hospital.getValueAt(selectedRow, 1));
                    boolean emailChanged = !email.equals((String) UE_tb_Hospital.getValueAt(selectedRow, 2));
                    boolean contactChanged = !contact.equals((String) UE_tb_Hospital.getValueAt(selectedRow, 3));
                    if (nameChanged) {
                        result = HospitalManagement.modifyHospital(userID, selectedHospitalID, "name", name);
                    }
                    if (emailChanged) {
                        result = HospitalManagement.modifyHospital(userID, selectedHospitalID, "email", email);
                    }
                    if (contactChanged) {
                        result = HospitalManagement.modifyHospital(userID, selectedHospitalID, "contact", contact);
                    }
                    if (!nameChanged && !emailChanged && !contactChanged) {
                        result = "No changes detected.";
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        JOptionPane.showMessageDialog(this, result);
        clearFields();
        disableAllFields();
        loadAdminData();
        loadStaffData();
        loadSupplierData();
        loadHospitalData();
        currentAction = "";
        selectedRow = -1;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JPanel Hospital;
    private javax.swing.JPanel Staff;
    private javax.swing.JPanel Supplier;
    private javax.swing.JButton UE_btn_Admin;
    private javax.swing.JButton UE_btn_Back;
    private javax.swing.JButton UE_btn_Hospital;
    private javax.swing.JButton UE_btn_Staff;
    private javax.swing.JButton UE_btn_Supplier;
    private javax.swing.JLabel UE_lbl_ConfirmPassword;
    private javax.swing.JLabel UE_lbl_ConfirmPassword1;
    private javax.swing.JLabel UE_lbl_Contact;
    private javax.swing.JLabel UE_lbl_Contact1;
    private javax.swing.JLabel UE_lbl_Contact2;
    private javax.swing.JLabel UE_lbl_Contact3;
    private javax.swing.JLabel UE_lbl_Email;
    private javax.swing.JLabel UE_lbl_Email1;
    private javax.swing.JLabel UE_lbl_Email2;
    private javax.swing.JLabel UE_lbl_Email3;
    private javax.swing.JLabel UE_lbl_NewPassword;
    private javax.swing.JLabel UE_lbl_NewPassword1;
    private javax.swing.JLabel UE_lbl_OldPassword;
    private javax.swing.JLabel UE_lbl_OldPassword1;
    private javax.swing.JLabel UE_lbl_Search;
    private javax.swing.JLabel UE_lbl_Search1;
    private javax.swing.JLabel UE_lbl_Search2;
    private javax.swing.JLabel UE_lbl_Search3;
    private javax.swing.JLabel UE_lbl_Username;
    private javax.swing.JLabel UE_lbl_Username1;
    private javax.swing.JLabel UE_lbl_Username2;
    private javax.swing.JLabel UE_lbl_Username3;
    private javax.swing.JPasswordField UE_pf_ConfirmedPassword;
    private javax.swing.JPasswordField UE_pf_ConfirmedPassword1;
    private javax.swing.JPasswordField UE_pf_NewPassword;
    private javax.swing.JPasswordField UE_pf_NewPassword1;
    private javax.swing.JPasswordField UE_pf_OldPassword;
    private javax.swing.JPasswordField UE_pf_OldPassword1;
    private javax.swing.JTable UE_tb_Admin;
    private javax.swing.JTable UE_tb_Hospital;
    private javax.swing.JTable UE_tb_Staff;
    private javax.swing.JTable UE_tb_Supplier;
    private javax.swing.JTextField UE_tf_Contact;
    private javax.swing.JTextField UE_tf_Contact1;
    private javax.swing.JTextField UE_tf_Contact2;
    private javax.swing.JTextField UE_tf_Contact3;
    private javax.swing.JTextField UE_tf_Email;
    private javax.swing.JTextField UE_tf_Email1;
    private javax.swing.JTextField UE_tf_Email2;
    private javax.swing.JTextField UE_tf_Email3;
    private javax.swing.JTextField UE_tf_Search;
    private javax.swing.JTextField UE_tf_Search1;
    private javax.swing.JTextField UE_tf_Search2;
    private javax.swing.JTextField UE_tf_Search3;
    private javax.swing.JTextField UE_tf_Username;
    private javax.swing.JTextField UE_tf_Username1;
    private javax.swing.JTextField UE_tf_Username2;
    private javax.swing.JTextField UE_tf_Username3;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Add1;
    private javax.swing.JButton btn_Add2;
    private javax.swing.JButton btn_Add3;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Delete1;
    private javax.swing.JButton btn_Delete2;
    private javax.swing.JButton btn_Delete3;
    private javax.swing.JButton btn_Modify;
    private javax.swing.JButton btn_Modify1;
    private javax.swing.JButton btn_Modify2;
    private javax.swing.JButton btn_Modify3;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_Refresh1;
    private javax.swing.JButton btn_Refresh2;
    private javax.swing.JButton btn_Refresh3;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Save1;
    private javax.swing.JButton btn_Save2;
    private javax.swing.JButton btn_Save3;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JButton btn_Search2;
    private javax.swing.JButton btn_Search3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
