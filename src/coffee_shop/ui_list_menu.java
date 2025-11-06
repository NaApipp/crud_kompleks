/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee_shop;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kataque
 */
public class ui_list_menu extends javax.swing.JFrame {
    
public Connection con;
public Statement st;
public ResultSet rs;
public DefaultTableModel model;


    public ui_list_menu() {
        initComponents();
        String[] header = {"kode", "Nama Produk", "Harga Produk"}; //daftar nama kolom pada table db
        model = new DefaultTableModel (header, 0); //membuat model table terbaru sesuai header dimulai dari 0
        tabel.setModel(model); //Menghubungkan model yang baru dibuat tadi ke komponen tabel
        insert();
    }
    
    public void insert() {
        koneksi_database kon = new koneksi_database(); 
        try {
            con = koneksi_database.getKoneksi(); //Membuat objek baru  (con) dari class KoneksiDatabase, Mengambil koneksi ke database menggunakan getKoneksi().
            st = con.createStatement(); //membuat statement sql untuk menjalankan query
            rs = st.executeQuery("SELECT * FROM produk ORDER BY kode DESC");  //Menjalankan query SELECT semua data dari tabel produk.   
            while(rs.next()) { 
                String[] row = {rs.getString(1), rs.getString(2), rs.getString(3)}; //➡Ambil isi kolom ke-1, 2, 3, 4 dari baris saat ini di ResultSet, lalu taruh ke array row.
                model.addRow(row); //Menambahkan array row tadi ke tabel model (DefaultTableModel)
            }
        tabel.setModel(model);
    } catch(SQLException e) { //Kalau terjadi error SQL (contohnya koneksi gagal, query salah),
            System.out.println("gagal " +e.getMessage());
}}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_hapus = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        halaman_menu = new javax.swing.JButton();
        input_harga_produk = new java.awt.TextField();
        btn_clear = new javax.swing.JButton();
        input_nama_produk = new java.awt.TextField();
        input_kode_produk = new java.awt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        halaman_riwayat = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_add.setText("Tambahkan");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        halaman_menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        halaman_menu.setText("Ke Halaman Menu/Checkout");
        halaman_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halaman_menuActionPerformed(evt);
            }
        });

        input_harga_produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                input_harga_produkKeyTyped(evt);
            }
        });

        btn_clear.setText("Clear All");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        input_nama_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nama_produkActionPerformed(evt);
            }
        });

        input_kode_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_kode_produkActionPerformed(evt);
            }
        });
        input_kode_produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                input_kode_produkKeyTyped(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        halaman_riwayat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        halaman_riwayat.setText("Ke Halaman Riwayat Transaksi");
        halaman_riwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halaman_riwayatActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        label1.setText("Input Kode Produk");

        label2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        label2.setText("Input Nama Produk");

        label3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        label3.setText("Input Harga Produk");

        label4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        label4.setText("Tambah Menu / Produk");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_hapus)
                                .addGap(56, 56, 56)
                                .addComponent(btn_add))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(input_harga_produk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(input_nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(input_kode_produk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(halaman_menu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(halaman_riwayat)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_kode_produk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btn_clear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_harga_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add)
                    .addComponent(btn_hapus))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(halaman_riwayat)
                    .addComponent(halaman_menu))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        try{
            String url="jdbc:mysql://localhost:3306/db_coffee_shop"; //koneksi ke database
            String user="root"; //username
            String pass=""; //password
            String query = "INSERT INTO produk VALUES (?, ?, ?)"; //membuat perintah untuk memasukkan data ke tabel produk,dengan 3 data yang nanti diisi menggunakan PreparedStatement supaya aman dan terhindar dari SQL Injection.
            Class.forName("com.mysql.jdbc.Driver"); //Memuat/mendaftarkan driver JDBC MySQL ke program Java, supaya Java bisa terhubung ke database MySQL.
            
            con=DriverManager.getConnection(url, user, pass); //membuka koneksi ke database MySQL, dengan: url, username, dan password
            st=con.createStatement(); //Membuat Statement SQL dari koneksi con tadi, supaya kamu bisa mengirim query SQL ke database.
            
            PreparedStatement sta = con.prepareStatement(query); ///mempersiapkan query sql agar bisa di isi 1/1
            sta.setString(1, input_kode_produk.getText()); //mengisi nilai "?" di query berdasarkan input dari form
            sta.setString(2, input_nama_produk.getText()); //mengisi nilai "?" di query berdasarkan input dari form
            sta.setString(3, input_harga_produk.getText()); //mengisi nilai "?" di query berdasarkan input dari form
                sta.execute(); //Menjalankan query tersebut ke database. (data baru di tambahkan ke tabel)
             
             JOptionPane.showMessageDialog(null, "Data berhasil Diinputkan"); //mssg jika data acc ke database
        }catch(Exception e){
            System.out.println("gagal "+e.getMessage()); //mssg jika data gagal ke database
        } 
        //UPDATE TABEL AUTOMATIC (Mengupdate tabel secara otomatis apa bila ada perubahan
         String[] header = {"kode", "nama_produk", "harga_produk"};
        model = new DefaultTableModel (header, 0);
        tabel.setModel(model);
        insert();
    }//GEN-LAST:event_btn_addActionPerformed

    private void halaman_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halaman_menuActionPerformed
        // TODO add your handling code here:
        menu halamanLain = new menu(); 
        halamanLain.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_halaman_menuActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
         int baris = tabel.rowAtPoint(evt.getPoint()); //untuk menentukan baris keberapa yang diklik di tabel
        
        String kode = tabel.getValueAt(baris, 0).toString();
        input_kode_produk.setText(kode); //Ambil nilai kolom ke-0 (kolom pertama, kode) dari baris yang diklik, lalu tampilkan ke field input_kode_produk.
        
        String nama_produk = tabel.getValueAt(baris, 1).toString();
        input_nama_produk.setText(nama_produk); //Ambil nilai kolom ke-1 (nama_produk) dari baris yang diklik, lalu tampilkan ke field input_nama_produk.
        
        String harga_produk = tabel.getValueAt(baris, 2).toString();
        input_harga_produk.setText(harga_produk); //Ambil nilai kolom ke-2 (harga_produk) dari baris yang diklik, lalu tampilkan ke field input_harga_produk.
    
    }//GEN-LAST:event_tabelMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        con = koneksi_database.getKoneksi();
        
        try {
        String sql = "DELETE FROM produk WHERE kode  ='" +input_kode_produk.getText() + "'"; //query sql delete data berdasarkan kode
            
        PreparedStatement sta = con.prepareStatement(sql);
        sta.execute();
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus"); //mssg jika data berhasil di hapus
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus" + e.getMessage()); //mssg jika data gagal di hapus
        }
        
        //UPDATE TABEL AUTOMATIC (Mengupdate tabel secara otomatis apa bila ada perubahan
        String[] header = {"kode","nama_produk","harga_produk"};
        model=new DefaultTableModel(header, 0);
        tabel.setModel(model);
        insert();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        input_kode_produk.setText("");
        input_nama_produk.setText("");
        input_harga_produk.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void input_kode_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_kode_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_kode_produkActionPerformed

    private void input_kode_produkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_kode_produkKeyTyped
        //       MEMBUAT VALIDASI AGAR USER HANYA BISA INPUT ANGKA
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
        evt.consume(); // abaikan karakter yang bukan angka
    }
    }//GEN-LAST:event_input_kode_produkKeyTyped

    private void input_nama_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nama_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nama_produkActionPerformed

    private void input_harga_produkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_harga_produkKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
        evt.consume(); // abaikan karakter yang bukan angka
    }
    }//GEN-LAST:event_input_harga_produkKeyTyped

    private void halaman_riwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halaman_riwayatActionPerformed
        // TODO add your handling code here:
        dana halamanRiwayat = new dana(); 
        halamanRiwayat.setVisible(true);  // tampilkan halaman baru
        this.dispose();                 // tutup halaman lama
    }//GEN-LAST:event_halaman_riwayatActionPerformed

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
            java.util.logging.Logger.getLogger(ui_list_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui_list_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui_list_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui_list_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui_list_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton halaman_menu;
    private javax.swing.JButton halaman_riwayat;
    private java.awt.TextField input_harga_produk;
    private java.awt.TextField input_kode_produk;
    private java.awt.TextField input_nama_produk;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
