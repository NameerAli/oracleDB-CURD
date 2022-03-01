package oracledb_18606;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class supplies extends javax.swing.JFrame {

    private static final String url = "jdbc:oracle:thin:system/user1234@localhost:1521:orcl";

    Connection Conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    public supplies() {
        initComponents();
        updateDB();
    }

    @SuppressWarnings("unchecked")

    public void updateDB() {

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("select * from supplies");

            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();

            q = StData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {

                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("SUPNR"));
                    columnData.add(rs.getString("PRODNR"));
                    columnData.add(rs.getString("PURCHASE_PRICE"));
                    columnData.add(rs.getString("DELIV_PERIOD"));

                }
                RecordTable.addRow(columnData);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        supp_name = new javax.swing.JTextField();
        supp_num = new javax.swing.JTextField();
        supp_city = new javax.swing.JTextField();
        supp_add = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        supplier_button = new javax.swing.JButton();
        product_button = new javax.swing.JButton();
        supplies_button = new javax.swing.JButton();
        po_button = new javax.swing.JButton();
        pol_button = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel15.setText("Supplies Database ");
        jLabel15.setToolTipText("");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1340, 80));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Number", "Product Number", "Purchase Price", "Delievery Period"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 360));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 790, 380));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Supplier Number:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Product Number:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Purchase Price:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Delievery Period:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        supp_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supp_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(supp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 300, -1));

        supp_num.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supp_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(supp_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 300, -1));

        supp_city.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supp_city.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(supp_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 300, -1));

        supp_add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supp_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(supp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 300, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 500, 380));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(153, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 212, 60));

        btnReset.setBackground(new java.awt.Color(0, 0, 0));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnReset.setForeground(new java.awt.Color(153, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel6.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 212, 60));

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(153, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 212, 60));

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnExit.setForeground(new java.awt.Color(153, 0, 0));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel6.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 212, 60));

        btnAddNew.setBackground(new java.awt.Color(0, 0, 0));
        btnAddNew.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnAddNew.setForeground(new java.awt.Color(153, 0, 0));
        btnAddNew.setText("Add ");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 200, 60));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 1320, 80));

        supplier_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supplier_button.setForeground(new java.awt.Color(153, 0, 0));
        supplier_button.setText("Supplier");
        supplier_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        supplier_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(supplier_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1, 160, 60));

        product_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        product_button.setForeground(new java.awt.Color(153, 0, 0));
        product_button.setText("Product");
        product_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        product_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(product_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 140, 60));

        supplies_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supplies_button.setForeground(new java.awt.Color(153, 0, 0));
        supplies_button.setText("Supplies");
        supplies_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        supplies_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplies_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(supplies_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 160, 60));

        po_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        po_button.setForeground(new java.awt.Color(153, 0, 0));
        po_button.setText("Purchase_Order");
        po_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        po_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                po_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(po_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 180, 60));

        pol_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pol_button.setForeground(new java.awt.Color(153, 0, 0));
        pol_button.setText("PO_Line");
        pol_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pol_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pol_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(pol_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 180, 60));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1340, 540));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 640));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 770, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        supp_num.setText("");
        supp_name.setText("");
        supp_add.setText("");
        supp_city.setText("");

        
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        RecordTable.setRowCount(0);
        updateDB();


    }//GEN-LAST:event_btnResetActionPerformed
    private JFrame frame;
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Store Management Systems",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("insert into supplies(SUPNR,PRODNR,PURCHASE_PRICE,DELIV_PERIOD)values"
                    + "(?,?,?,?)");

            pst.setString(1, supp_num.getText());
            pst.setString(2, supp_name.getText());
            pst.setString(3, supp_add.getText());
            pst.setString(4, supp_city.getText());
        
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Supplies Record Added");
            updateDB();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        String num = supp_num.getText();
        String name = supp_name.getText();
        String add = supp_add.getText();
        String city = supp_city.getText();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("update supplies set PURCHASE_PRICE=?,"
                    + "DELIV_PERIOD=? where SUPNR =? AND PRODNR=?");

            pst.setString(3, num);
            pst.setString(4, name);
            pst.setString(1, add);
            pst.setString(2, city);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Supplies Record updated");
            updateDB();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println(ex);

        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();

        supp_num.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        supp_name.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        supp_add.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        supp_city.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        // sup_status.setText(RecordTable.getValueAt(SelectedRows, 4).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {

                Class.forName("oracle.jdbc.OracleDriver");
                Conn = DriverManager.getConnection(url);
                pst = Conn.prepareStatement("delete from supplies where supnr =?");

                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Supplies Record updated");
                updateDB();

                supp_num.setText("");
                supp_num.requestFocus();
                supp_name.setText("");
                supp_add.setText("");
                supp_city.setText("");
                

            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            System.err.println(ex);

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void supplier_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_buttonActionPerformed
        supplier o1 = new supplier();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_supplier_buttonActionPerformed

    private void product_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_buttonActionPerformed
        product o1 = new product();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_product_buttonActionPerformed

    private void po_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_po_buttonActionPerformed
        purchase_order o1 = new purchase_order();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_po_buttonActionPerformed

    private void pol_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pol_buttonActionPerformed
        po_line o1 = new po_line();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pol_buttonActionPerformed

    private void supplies_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplies_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplies_buttonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton po_button;
    private javax.swing.JButton pol_button;
    private javax.swing.JButton product_button;
    private javax.swing.JTextField supp_add;
    private javax.swing.JTextField supp_city;
    private javax.swing.JTextField supp_name;
    private javax.swing.JTextField supp_num;
    private javax.swing.JButton supplier_button;
    private javax.swing.JButton supplies_button;
    // End of variables declaration//GEN-END:variables
}