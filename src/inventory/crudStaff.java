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
 * @author KELAR_GAYE
 */
public class crudStaff extends javax.swing.JFrame {
    private Connection con = new koneksi().connect();
    private Statement stat;
    private ResultSet res;
    /**
     * Creates new form crudStaff
     */
    public crudStaff() {
        initComponents();
        setLocationRelativeTo(getRootPane());
    }

    protected void aktif(){
        tIdStaff.setEnabled(true);
        tNik.setEnabled(true);
        tNama.setEnabled(true);
        tNoHp.setEnabled(true);
        tTtl.setEnabled(true);
        tAlamat.setEnabled(true);
        tIdStaff.requestFocus();
    }
    
    protected void clear() {
        tIdStaff.setText("");
        tNik.setText("");
        tNama.setText("");
        tNoHp.setText("");
        tTtl.setText("");
        tAlamat.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tIdStaff = new javax.swing.JTextField();
        tNik = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        tNoHp = new javax.swing.JTextField();
        tTtl = new javax.swing.JTextField();
        tAlamat = new javax.swing.JTextField();
        dashboard = new javax.swing.JButton();
        back = new javax.swing.JButton();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 640));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setPreferredSize(new java.awt.Dimension(900, 640));
        getContentPane().setLayout(null);
        getContentPane().add(tIdStaff);
        tIdStaff.setBounds(300, 170, 330, 30);
        getContentPane().add(tNik);
        tNik.setBounds(300, 230, 330, 30);
        getContentPane().add(tNama);
        tNama.setBounds(300, 290, 330, 30);
        getContentPane().add(tNoHp);
        tNoHp.setBounds(300, 340, 330, 30);
        getContentPane().add(tTtl);
        tTtl.setBounds(300, 400, 330, 30);
        getContentPane().add(tAlamat);
        tAlamat.setBounds(300, 450, 330, 30);

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

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-SAVE.png"))); // NOI18N
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(300, 530, 100, 40);

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-EDIT.png"))); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(420, 530, 100, 40);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-DELETE.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(540, 530, 100, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5HAL CRUDSTAFF.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 900, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try{
            String sql ="UPDATE staff SET idStaff=?, nik=?, nama=?, noHp=?,"
                    + "ttl=?, alamat=? WHERE IdStaff =  '"+tIdStaff.getText()+"'";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tIdStaff.getText());
            stat.setString(2, tNik.getText());
            stat.setString(3, tNama.getText());
            stat.setString(4, tNoHp.getText());
            stat.setString(5, tTtl.getText());
            stat.setString(6, tAlamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah");
            clear();
            tIdStaff.requestFocus();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal diubah "+e);
        }
        new staff().setVisible(true);
        dispose();
    }//GEN-LAST:event_editActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO staff values(?,?,?,?,?,?)";
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tIdStaff.getText());
            stat.setString(2, tNik.getText());
            stat.setString(3, tNama.getText());
            stat.setString(4, tNoHp.getText());
            stat.setString(5, tTtl.getText());
            stat.setString(6, tAlamat.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            clear();
            tIdStaff.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
        new staff().setVisible(true);
        dispose();
    }//GEN-LAST:event_saveActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_dashboardActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new staff().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog",
            JOptionPane.YES_NO_CANCEL_OPTION);
        if(hapus == 0) {
            String sql="DELETE FROM staff WHERE idStaff =  '"+tIdStaff.getText()+"'";
            try {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                clear();
                tIdStaff.requestFocus();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal dihapus"+e);
            }
        }
        new staff().setVisible(true);
        dispose();
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(crudStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton save;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tIdStaff;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNik;
    private javax.swing.JTextField tNoHp;
    private javax.swing.JTextField tTtl;
    // End of variables declaration//GEN-END:variables
}
