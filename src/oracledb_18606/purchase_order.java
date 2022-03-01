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

public class purchase_order extends javax.swing.JFrame {

    private static final String url = "jdbc:oracle:thin:system/user1234@localhost:1521:orcl";

    Connection Conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    public purchase_order() {
        initComponents();
        updateDB();
    }

    @SuppressWarnings("unchecked")

    public void updateDB() {

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("select * from purchase_order");

            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();

            q = StData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) table_db.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {

                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("PONR"));
                    columnData.add(rs.getString("PODATE"));
                    columnData.add(rs.getString("SUPNR"));

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
        table_db = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        po_date = new javax.swing.JTextField();
        po_num = new javax.swing.JTextField();
        sup_num = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        update_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
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
        jLabel15.setText("Purchase Order Database ");
        jLabel15.setToolTipText("");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1340, 80));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_db.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_db.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PO Number", "PO Date", "Supplier Number"
            }
        ));
        table_db.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_db);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 360));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 790, 380));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 4));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("PO Number:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("PO Date:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Supplier Number:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 170, -1));

        po_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        po_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(po_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 300, -1));

        po_num.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        po_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(po_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 300, -1));

        sup_num.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sup_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(sup_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 300, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 500, 380));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 4));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_button.setBackground(new java.awt.Color(0, 0, 0));
        update_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        update_button.setForeground(new java.awt.Color(153, 0, 0));
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(update_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 212, 60));

        reset_button.setBackground(new java.awt.Color(0, 0, 0));
        reset_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        reset_button.setForeground(new java.awt.Color(153, 0, 0));
        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(reset_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 212, 60));

        delete_button.setBackground(new java.awt.Color(0, 0, 0));
        delete_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        delete_button.setForeground(new java.awt.Color(153, 0, 0));
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(delete_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 212, 60));

        exit_button.setBackground(new java.awt.Color(0, 0, 0));
        exit_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        exit_button.setForeground(new java.awt.Color(153, 0, 0));
        exit_button.setText("Exit");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 212, 60));

        add_button.setBackground(new java.awt.Color(0, 0, 0));
        add_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        add_button.setForeground(new java.awt.Color(153, 0, 0));
        add_button.setText("Add ");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        jPanel6.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 200, 60));

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
        jPanel5.add(supplier_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1, 150, 60));

        product_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        product_button.setForeground(new java.awt.Color(153, 0, 0));
        product_button.setText("Product");
        product_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        product_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(product_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 160, 60));

        supplies_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supplies_button.setForeground(new java.awt.Color(153, 0, 0));
        supplies_button.setText("Supplies");
        supplies_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        supplies_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplies_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(supplies_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 160, 60));

        po_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        po_button.setForeground(new java.awt.Color(153, 0, 0));
        po_button.setText("Purchase_Order");
        po_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        po_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                po_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(po_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 190, 60));

        pol_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pol_button.setForeground(new java.awt.Color(153, 0, 0));
        pol_button.setText("PO_Line");
        pol_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pol_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pol_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(pol_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 170, 60));

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

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed

        po_num.setText("");
        po_date.setText("");
        sup_num.setText("");
        //supp_city.setText("");

        //sup_status.setText("");
        DefaultTableModel RecordTable = (DefaultTableModel) table_db.getModel();
        RecordTable.setRowCount(0);
        updateDB();


    }//GEN-LAST:event_reset_buttonActionPerformed
    private JFrame frame;
    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed

        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Store Management Systems",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("insert into purchase_order(PONR,PODATE,SUPNR)values"
                    + "(?,?,?)");

            pst.setString(1, po_num.getText());
            pst.setString(2, po_date.getText());
            pst.setString(3, sup_num.getText());
            // pst.setString(4, supp_city.getText());
            //pst.setString(5, sup_status.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product Record Added");
            updateDB();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_add_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed

        DefaultTableModel RecordTable = (DefaultTableModel) table_db.getModel();
        int SelectedRows = table_db.getSelectedRow();
        String num = po_num.getText();
        String name = po_date.getText();
        String add = sup_num.getText();
        
        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());

            Class.forName("oracle.jdbc.OracleDriver");
            Conn = DriverManager.getConnection(url);
            pst = Conn.prepareStatement("update purchase_order set PODATE=?,SUPNR=? where PONR =?");

            pst.setString(3, num);
            pst.setString(1, name);
            pst.setString(2, add);
        

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "purchase Record updated");
            updateDB();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println(ex);

        }

    }//GEN-LAST:event_update_buttonActionPerformed

    private void table_dbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dbMouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel) table_db.getModel();
        int SelectedRows = table_db.getSelectedRow();

        po_num.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        po_date.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        sup_num.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        //supp_city.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        // sup_status.setText(RecordTable.getValueAt(SelectedRows, 4).toString());

    }//GEN-LAST:event_table_dbMouseClicked

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed

        DefaultTableModel RecordTable = (DefaultTableModel) table_db.getModel();
        int SelectedRows = table_db.getSelectedRow();

        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {

                Class.forName("oracle.jdbc.OracleDriver");
                Conn = DriverManager.getConnection(url);
                pst = Conn.prepareStatement("delete from purchase_order where PONR =?");

                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "purchase Record updated");
                updateDB();

                po_num.setText("");
                //supp_num.requestFocus();
                po_date.setText("");
                sup_num.setText("");
                //supp_city.setText("");
                //sup_status.setText("");

            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (SQLException ex) {
            System.err.println(ex);

        }

    }//GEN-LAST:event_delete_buttonActionPerformed

    private void supplier_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_buttonActionPerformed
        supplier o1 = new supplier();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_supplier_buttonActionPerformed

    private void product_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_buttonActionPerformed

    }//GEN-LAST:event_product_buttonActionPerformed

    private void supplies_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplies_buttonActionPerformed
        supplies o1 = new supplies();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_supplies_buttonActionPerformed

    private void pol_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pol_buttonActionPerformed
        po_line o1 = new po_line();
        o1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pol_buttonActionPerformed

    private void po_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_po_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_po_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchase_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new purchase_order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton po_button;
    private javax.swing.JTextField po_date;
    private javax.swing.JTextField po_num;
    private javax.swing.JButton pol_button;
    private javax.swing.JButton product_button;
    private javax.swing.JButton reset_button;
    private javax.swing.JTextField sup_num;
    private javax.swing.JButton supplier_button;
    private javax.swing.JButton supplies_button;
    private javax.swing.JTable table_db;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
