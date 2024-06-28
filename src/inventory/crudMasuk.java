/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author Kelar_Gaye
 */
public class crudMasuk extends javax.swing.JFrame {
    private Connection con = new koneksi().connect();
    private Statement stat;
    private ResultSet res;
    /**
     * Creates new form crudMasuk
     */
    public crudMasuk() {
        initComponents();
        setLocationRelativeTo(getRootPane());
    }

    protected void aktif(){
        tId.setEnabled(true);
        cbKode.setEnabled(true);
        tNamaBrg.setEnabled(true);
        tTgl.setEnabled(true);
        tJumlahMasuk.setEnabled(true);
        cbIdSupplier.setEnabled(true);
        cbIdStaff.setEnabled(true);
        tId.requestFocus();
    }
    
    protected void clear() {
        tId.setText("");
        cbKode.setSelectedItem("");
        tNamaBrg.setText("");
        tTgl.setText("");
        tJumlahMasuk.setText("");
        cbIdSupplier.setSelectedItem("");
        cbIdStaff.setSelectedItem("");
    }
    public void updateStok(){
    String kodeBarang = cbKode.getSelectedItem().toString();
        int jumlahMasuk = Integer.parseInt(tJumlahMasuk.getText());

        // Lakukan query update stok
        String updateStokQuery = "UPDATE barang SET stok = stok + ? WHERE kode = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(updateStokQuery);
            preparedStatement.setInt(1, jumlahMasuk);
            preparedStatement.setString(2, kodeBarang);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update Stok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Gagal Update Stok"+ex);
        }
    }
    
    private void updateNamaBarang() {
        String kodeBarang = cbKode.getSelectedItem().toString();
        String query = "SELECT namaBrg FROM barang WHERE kode = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, kodeBarang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String namaBarang = resultSet.getString("namaBrg");
                tNamaBrg.setText(namaBarang);
            } else {
               tNamaBrg.setText("Barang tidak ditemukan");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //tNamaBrg.setText(namaBarang);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        cbKode = new javax.swing.JComboBox<>();
        tNamaBrg = new javax.swing.JTextField();
        tTgl = new javax.swing.JTextField();
        tJumlahMasuk = new javax.swing.JTextField();
        cbIdSupplier = new javax.swing.JComboBox<>();
        cbIdStaff = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 640));
        setMinimumSize(new java.awt.Dimension(900, 640));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("(ID STAFF)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 560, 170, 17);
        getContentPane().add(tId);
        tId.setBounds(320, 180, 300, 30);

        cbKode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- PILIH KODE BARANG ---" }));
        cbKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbKodeMouseClicked(evt);
            }
        });
        getContentPane().add(cbKode);
        cbKode.setBounds(320, 240, 300, 30);

        tNamaBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tNamaBrgMouseClicked(evt);
            }
        });
        getContentPane().add(tNamaBrg);
        tNamaBrg.setBounds(320, 290, 300, 30);
        getContentPane().add(tTgl);
        tTgl.setBounds(320, 350, 300, 30);
        getContentPane().add(tJumlahMasuk);
        tJumlahMasuk.setBounds(320, 410, 300, 30);

        cbIdSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- PILIH ID SUPPLIER ---" }));
        cbIdSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIdSupplierMouseClicked(evt);
            }
        });
        getContentPane().add(cbIdSupplier);
        cbIdSupplier.setBounds(320, 460, 300, 30);

        cbIdStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- PILIH ID STAFF ---" }));
        cbIdStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIdStaffMouseClicked(evt);
            }
        });
        getContentPane().add(cbIdStaff);
        cbIdStaff.setBounds(320, 520, 300, 30);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-SAVE.png"))); // NOI18N
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(700, 180, 100, 40);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-DELETE.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(700, 240, 100, 40);

        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-H-DASHBOARD.png"))); // NOI18N
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(dashboard);
        dashboard.setBounds(30, 10, 60, 50);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-BACK.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(760, 20, 90, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/10HAL CRUD MASUK.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(-1, -2, 900, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new masuk().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void cbKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbKodeMouseClicked
        // TODO add your handling code here:
        try {
        String sql = "SELECT DISTINCT kode FROM barang";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cbKode.addItem(rs.getString("kode"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbKodeMouseClicked

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_dashboardActionPerformed

    private void cbIdSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIdSupplierMouseClicked
        // TODO add your handling code here:
        try {
        String sql = "SELECT DISTINCT idSupplier FROM supplier;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cbIdSupplier.addItem(rs.getString("idSupplier"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbIdSupplierMouseClicked

    private void cbIdStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIdStaffMouseClicked
        // TODO add your handling code here:
        try {
        String sql = "SELECT DISTINCT idStaff FROM staff";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cbIdStaff.addItem(rs.getString("idStaff"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbIdStaffMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO masuk values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tId.getText());
            stat.setString(2, cbKode.getSelectedItem().toString());
            stat.setString(3, tNamaBrg.getText());
            stat.setString(4, tTgl.getText());
            stat.setString(5, tJumlahMasuk.getText());
            stat.setString(6, cbIdSupplier.getSelectedItem().toString());
            stat.setString(7, cbIdStaff.getSelectedItem().toString());
            stat.executeUpdate();
            updateStok();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            clear();
            tId.requestFocus();
            new masuk().setVisible(true);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog",
            JOptionPane.YES_NO_CANCEL_OPTION);
        if(hapus == 0) {
            String sql="DELETE FROM masuk WHERE idMasuk =  '"+tId.getText()+"'";
            try {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                clear();
                tId.requestFocus();
                new masuk().setVisible(true);
                dispose();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void tNamaBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNamaBrgMouseClicked
        // TODO add your handling code here:
        updateNamaBarang();
    }//GEN-LAST:event_tNamaBrgMouseClicked

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
            java.util.logging.Logger.getLogger(crudMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cbIdStaff;
    private javax.swing.JComboBox<String> cbIdSupplier;
    private javax.swing.JComboBox<String> cbKode;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton save;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tJumlahMasuk;
    private javax.swing.JTextField tNamaBrg;
    private javax.swing.JTextField tTgl;
    // End of variables declaration//GEN-END:variables
}