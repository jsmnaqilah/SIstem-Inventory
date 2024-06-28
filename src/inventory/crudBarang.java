/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author Kelar_Gaye
 */
public class crudBarang extends javax.swing.JFrame {
    private Connection con = new koneksi().connect();
    private Statement stat;
    private ResultSet res;
    /**
     * Creates new form crudBarang
     */
    public crudBarang() {
        initComponents();
        setLocationRelativeTo(getRootPane());
    }
    protected void aktif(){
        tKode.setEnabled(true);
        tNamaBrg.setEnabled(true);
        tKategori.setEnabled(true);
        tJumlahStok.setEnabled(true);
        cbIdSupplier.setEnabled(true);
        tKode.requestFocus();
    }
    protected void clear() {
        tKode.setText("");
        tNamaBrg.setText("");
        tKategori.setText("");
        tJumlahStok.setText("");
        cbIdSupplier.setSelectedItem("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboard = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        tKode = new javax.swing.JTextField();
        tNamaBrg = new javax.swing.JTextField();
        tKategori = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        tJumlahStok = new javax.swing.JTextField();
        cbIdSupplier = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 640));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setPreferredSize(new java.awt.Dimension(900, 640));
        getContentPane().setLayout(null);

        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-H-DASHBOARD.png"))); // NOI18N
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(dashboard);
        dashboard.setBounds(30, 10, 60, 50);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-DELETE.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(690, 340, 100, 40);

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-EDIT.png"))); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(690, 270, 100, 40);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-SAVE.png"))); // NOI18N
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(690, 200, 100, 40);
        getContentPane().add(tKode);
        tKode.setBounds(320, 200, 270, 30);
        getContentPane().add(tNamaBrg);
        tNamaBrg.setBounds(320, 260, 270, 30);
        getContentPane().add(tKategori);
        tKategori.setBounds(320, 320, 270, 30);
        getContentPane().add(tHarga);
        tHarga.setBounds(320, 370, 270, 30);
        getContentPane().add(tJumlahStok);
        tJumlahStok.setBounds(320, 430, 270, 30);

        cbIdSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- PILIH ID SUPPLIER ---" }));
        cbIdSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIdSupplierMouseClicked(evt);
            }
        });
        getContentPane().add(cbIdSupplier);
        cbIdSupplier.setBounds(320, 490, 270, 30);

        back.setBackground(new java.awt.Color(255, 51, 0));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-BACK.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(780, 20, 90, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8HAL CRUD BARANG.png"))); // NOI18N
        bg.setText("--- Pilih ID Supplier ---");
        getContentPane().add(bg);
        bg.setBounds(0, 0, 900, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO barang values(?,?,?,?,?,?)";
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tKode.getText());
            stat.setString(2, tNamaBrg.getText());
            stat.setString(3, tKategori.getText());
            stat.setString(4, tHarga.getText());
            stat.setString(5, tJumlahStok.getText());
            stat.setString(6, cbIdSupplier.getSelectedItem().toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            clear();
            tKode.requestFocus();
            new barang().setVisible(true);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try{
            String sql ="UPDATE barang SET kode=?, namaBrg=?, kategori=?, harga=?,"
                    + "stok=?, idSupplier=? WHERE kode =  '"+tKode.getText()+"'";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tKode.getText());
            stat.setString(2, tNamaBrg.getText());
            stat.setString(3, tKategori.getText());
            stat.setString(4, tHarga.getText());
            stat.setString(5, tJumlahStok.getText());
            stat.setString(6, cbIdSupplier.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            clear();
            tKode.requestFocus();
            new barang().setVisible(true);
            dispose();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal diubah "+e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog",
            JOptionPane.YES_NO_CANCEL_OPTION);
        if(hapus == 0) {
            String sql="DELETE FROM barang WHERE kode =  '"+tKode.getText()+"'";
            try {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                clear();
                tKode.requestFocus();
                new barang().setVisible(true);
                dispose();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new barang().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_dashboardActionPerformed

    private void cbIdSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIdSupplierMouseClicked
        // TODO add your handling code here:
        try {
        String sql = "SELECT DISTINCT idSupplier FROM supplier";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cbIdSupplier.addItem(rs.getString("idSupplier"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbIdSupplierMouseClicked

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
            java.util.logging.Logger.getLogger(crudBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cbIdSupplier;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton save;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tJumlahStok;
    private javax.swing.JTextField tKategori;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNamaBrg;
    // End of variables declaration//GEN-END:variables
}