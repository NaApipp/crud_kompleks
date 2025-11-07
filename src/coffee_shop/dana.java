/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee_shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kataque
 */
public class dana extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;

    /**
     * Creates new form dana
     */
    public dana() {
        initComponents();
        tampilData("");
        tampilkanTotal("");
    }

    private void tampilData(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Meja");
        model.addColumn("Nama");
        model.addColumn("Tanggal Pembelian");
        model.addColumn("Nama Produk");
        model.addColumn("Harga Peoduk");
        model.addColumn("Qty");
        
        
        try{
            Connection conn = koneksi_database.getKoneksi();
            Statement st = conn.createStatement();
            
            String sql;
            if (keyword == null || keyword.trim().isEmpty()) {
            sql = "SELECT * FROM transaksi_checkout ORDER BY id DESC";
            } else {
                // Search query with keyword
                sql = "SELECT * FROM transaksi_checkout WHERE id LIKE '%" + keyword + "%' "
                        + "OR nama LIKE '%" + keyword + "%' " //Cari Berdasarkan kode menu
                        + "OR tanggal_pembelian LIKE '%" + keyword + "%' " //Cari Berdasarkan nama produk
                        + "OR meja LIKE '%" + keyword + "%' " //Cari Berdasarkan meja pelanggan
                        + "ORDER BY id ASC";
            }
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("meja"),
                    rs.getString("nama"),
                    rs.getString("tanggal_pembelian"),
                    rs.getString("nama_produk"),
                    rs.getString("harga"),
                    rs.getString("qty")
                });
            }

            tabel_riwayat_transaksi.setModel(model);
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void tampilkanTotal(String keyword) {
    try {
        Connection conn = koneksi_database.getKoneksi();
        String sql;

        if (keyword == null || keyword.trim().isEmpty()) {
            sql = "SELECT SUM(harga * qty) AS total FROM transaksi_checkout";
        } else {
            sql = "SELECT SUM(harga * qty) AS total FROM transaksi_checkout "
                + "WHERE id LIKE '%" + keyword + "%' "
                + "OR nama LIKE '%" + keyword + "%' "
                + "OR tanggal_pembelian LIKE '%" + keyword + "%' "
                + "OR meja LIKE '%" + keyword + "%'";
        }

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int total = rs.getInt("total");
            total_pemasukan.setText(String.valueOf(total));
        } else {
            total_pemasukan.setText("0");
        }

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_riwayat_transaksi = new javax.swing.JTable();
        input_cari_transaksi = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        halaman_menu = new java.awt.Button();
        halaman_checkout = new java.awt.Button();
        total_pemasukan = new javax.swing.JTextField();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Riwayat Transaksi");

        tabel_riwayat_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_riwayat_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_riwayat_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_riwayat_transaksi);

        input_cari_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_cari_transaksiActionPerformed(evt);
            }
        });
        input_cari_transaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_cari_transaksiKeyReleased(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("Cari Transaksi");

        halaman_menu.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        halaman_menu.setLabel("Ke Halaman Menu");
        halaman_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halaman_menuActionPerformed(evt);
            }
        });

        halaman_checkout.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        halaman_checkout.setLabel("Ke Halaman Checkout");
        halaman_checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halaman_checkoutActionPerformed(evt);
            }
        });

        total_pemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_pemasukanActionPerformed(evt);
            }
        });
        total_pemasukan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                total_pemasukanKeyReleased(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("Total Pemasukan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_cari_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total_pemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(halaman_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(halaman_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_cari_transaksi)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(total_pemasukan)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(halaman_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halaman_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel_riwayat_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_riwayat_transaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_riwayat_transaksiMouseClicked

    private void input_cari_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_cari_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_cari_transaksiActionPerformed

    private void input_cari_transaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_cari_transaksiKeyReleased
        // TODO add your handling code here:
        String keyword = input_cari_transaksi.getText();
        tampilData(keyword);
    }//GEN-LAST:event_input_cari_transaksiKeyReleased

    private void halaman_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halaman_menuActionPerformed
        // TODO add your handling code here:
        ui_list_menu halamanLain = new ui_list_menu(); 
        halamanLain.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_halaman_menuActionPerformed

    private void halaman_checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halaman_checkoutActionPerformed
        // TODO add your handling code here:
        menu halamanLain = new menu(); 
        halamanLain.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_halaman_checkoutActionPerformed

    private void total_pemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_pemasukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_pemasukanActionPerformed

    private void total_pemasukanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_total_pemasukanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_total_pemasukanKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(dana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button halaman_checkout;
    private java.awt.Button halaman_menu;
    private javax.swing.JTextField input_cari_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tabel_riwayat_transaksi;
    private javax.swing.JTextField total_pemasukan;
    // End of variables declaration//GEN-END:variables
}
