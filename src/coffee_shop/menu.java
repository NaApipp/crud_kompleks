/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kataque
 */
public class menu extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel model;
    TableModel modelCheckout;

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        tampilData("");

        // set kolom checkout
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode");
        model.addColumn("Nama Produk");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        tabel_checkout.setModel(model);
    }

    private void tampilData(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode");
        model.addColumn("Nama Produk");
        model.addColumn("Harga Produk");

        try {
            Connection conn = koneksi_database.getKoneksi();
            Statement st = conn.createStatement();
            
            String sql;
            
            if (keyword == null || keyword.trim().isEmpty()) {
            sql = "SELECT * FROM produk ORDER BY kode ASC";
            } else {
                // Search query with keyword
                sql = "SELECT * FROM produk WHERE kode LIKE '%" + keyword + "%' "
                        + "OR kode LIKE '%" + keyword + "%' " //Cari Berdasarkan kode menu
                        + "OR nama_produk LIKE '%" + keyword + "%' " //Cari Berdasarkan nama produk
                        + "ORDER BY kode ASC";
            }
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("kode"),
                    rs.getString("nama_produk"),
                    rs.getString("harga_produk")
                });
            }

            tabel_menu.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void hitungTotalHarga() {
    DefaultTableModel model = (DefaultTableModel) tabel_checkout.getModel();
    int rowCount = model.getRowCount();
    int total = 0;

    for (int i = 0; i < rowCount; i++) {
        int harga = Integer.parseInt(model.getValueAt(i, 2).toString()); // kolom ke-2 = Harga
        int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString()); // kolom ke-3 = Jumlah
        total += harga * jumlah;
    }

    total_harga.setText(String.valueOf(total));
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_menu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_checkout = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        input_filter = new javax.swing.JTextField();
        btn_kembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        btn_beli = new javax.swing.JButton();
        btn_saldo = new javax.swing.JButton();
        input_meja = new java.awt.TextField();
        input_nama = new java.awt.TextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        total_harga = new java.awt.TextField();
        input_tanggal = new java.awt.TextField();
        label4 = new java.awt.Label();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU / CHECKOUT");

        tabel_menu.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_menu);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TABEL MENU");

        tabel_checkout.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_checkoutMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_checkout);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CHEKOUT");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cari Menu :");

        input_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_filterActionPerformed(evt);
            }
        });
        input_filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_filterKeyReleased(evt);
            }
        });

        btn_kembali.setText("Kembali List Menu");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Harga...");

        btn_clear.setText("Clear All");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_beli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_beli.setText("Beli");
        btn_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beliActionPerformed(evt);
            }
        });

        btn_saldo.setText("Keuangan Toko");
        btn_saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saldoActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("Meja");

        label3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label3.setText("Nama");

        total_harga.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        total_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_hargaActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label4.setText("Tanggal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(input_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 484, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btn_kembali)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_saldo)))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(129, 129, 129)
                                        .addComponent(btn_clear))
                                    .addComponent(input_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(input_meja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(input_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(input_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btn_clear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(input_meja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btn_kembali)
                    .addComponent(btn_saldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_beli))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_menuMouseClicked
        // TODO add your handling code here:
        int baris = tabel_menu.getSelectedRow(); // ambil baris yang diklik

    if (baris != -1) { // pastikan ada baris yang dipilih
        String kode = tabel_menu.getValueAt(baris, 0).toString();
        String nama = tabel_menu.getValueAt(baris, 1).toString();
        String harga = tabel_menu.getValueAt(baris, 2).toString();

        // tambahkan ke tabel checkout
        DefaultTableModel modelCheckout = (DefaultTableModel) tabel_checkout.getModel();
        modelCheckout.addRow(new Object[]{kode, nama, harga, 1}); // 1 = jumlah default
        hitungTotalHarga(); // <--- panggil setelah tambah data
    }
    }//GEN-LAST:event_tabel_menuMouseClicked

    private void input_filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_filterKeyReleased
        // TODO add your handling code here:
        String keyword = input_filter.getText();
        tampilData(keyword);
    }//GEN-LAST:event_input_filterKeyReleased

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
        ui_list_menu halamanLain = new ui_list_menu(); 
        halamanLain.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_saldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saldoActionPerformed
        // TODO add your handling code here:
        dana halamanLain = new dana(); 
        halamanLain.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_btn_saldoActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel_checkout.getModel();
        model.setRowCount(0); // Menghapus semua baris di tabel
//        input_meja.setText("");
//        input_nama.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tabel_checkoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_checkoutMouseClicked
        
        // TODO add your handling code here:
//        DefaultTableModel modelCheckout = (DefaultTableModel) tabel_checkout.getModel();
//        
//        try{
//            String sql = "SELECT * FROM checkout";
//            PreparedStatement st = con.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            
//            while (rs.next()) {
//                String nama_produk = rs.getString("checkout_produk");
//                String harga_produk = rs.getString("checkout_harga");
//                
//                Object[] rowData = {nama_produk, harga_produk};
//                modelCheckout.addRow(rowData);
//            }
//            rs.close();
//            st.close();
//        }catch(Exception e){
//            System.out.println("gagal "+e.getMessage()); //mssg jika data gagal ke database
//        }
        
    }//GEN-LAST:event_tabel_checkoutMouseClicked

    private void total_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_hargaActionPerformed

    private void btn_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beliActionPerformed
        // TODO add your handling code here:
         try {
        String url = "jdbc:mysql://localhost:3306/db_coffee_shop";
        String user = "root";
        String pass = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String meja = input_meja.getText().trim();
        String nama = input_nama.getText().trim();
        String tanggal_pembelian = input_tanggal.getText().trim();

        if (meja.isEmpty() || nama.isEmpty() || tanggal_pembelian.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Meja, Nama, dan Tanggal Pembelian wajib diisi.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tabel_checkout.getModel();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tabel checkout kosong.");
            return;
        }

        String sql = "INSERT INTO transaksi_checkout "
                   + "(meja, nama, tanggal_pembelian, kode_produk, nama_produk, harga, qty) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql);

        for (int i = 0; i < model.getRowCount(); i++) {

            pst.setString(1, meja);
            pst.setString(2, nama);
            pst.setString(3, tanggal_pembelian);

            pst.setString(4, model.getValueAt(i, 0).toString()); // kode
            pst.setString(5, model.getValueAt(i, 1).toString()); // nama produk
            pst.setInt(6, Integer.parseInt(model.getValueAt(i, 2).toString())); // harga
            pst.setInt(7, Integer.parseInt(model.getValueAt(i, 3).toString())); // qty

            pst.addBatch();
        }

        pst.executeBatch();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");

        input_meja.setText("");
        input_nama.setText("");
        model.setRowCount(0);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
        
    }//GEN-LAST:event_btn_beliActionPerformed

    private void input_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_filterActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_beli;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_saldo;
    private javax.swing.JTextField input_filter;
    private java.awt.TextField input_meja;
    private java.awt.TextField input_nama;
    private java.awt.TextField input_tanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable tabel_checkout;
    private javax.swing.JTable tabel_menu;
    private java.awt.TextField total_harga;
    // End of variables declaration//GEN-END:variables
}
