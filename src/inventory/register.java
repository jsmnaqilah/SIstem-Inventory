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
public class register extends javax.swing.JFrame {
    private Connection con = new koneksi().connect();
    private Statement stat;
    private ResultSet res;
    /**
     * Creates new form register
     */
    public register() {
        initComponents();
        setLocationRelativeTo(getRootPane());
    }
    
    protected void clear() {
        tUsername.setText("");
        tPassword.setText("");
        cbHak.setSelectedItem("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        hak = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        tPassword = new javax.swing.JPasswordField();
        cbHak = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        save = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 640));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setPreferredSize(new java.awt.Dimension(900, 640));
        getContentPane().setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-H-DASHBOARD.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(30, 14, 60, 50);

        hak.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        hak.setText("Hak Akses");
        getContentPane().add(hak);
        hak.setBounds(230, 420, 120, 20);

        tUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tUsername);
        tUsername.setBounds(360, 260, 310, 30);

        tPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tPassword);
        tPassword.setBounds(360, 340, 310, 30);

        cbHak.setBackground(new java.awt.Color(204, 204, 204));
        cbHak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff", "Manager", " " }));
        cbHak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHakActionPerformed(evt);
            }
        });
        getContentPane().add(cbHak);
        cbHak.setBounds(360, 410, 220, 30);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-DELETE.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(560, 500, 110, 40);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-BACK.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(40, 550, 90, 40);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-SAVE.png"))); // NOI18N
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(370, 500, 110, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3HAL AKUN.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 900, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbHakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHakActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO login values(?,?,?)";
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tUsername.getText());
            stat.setString(2, tPassword.getText());
            stat.setString(3, cbHak.getSelectedItem().toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
            tUsername.requestFocus();
            clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog",
            JOptionPane.YES_NO_CANCEL_OPTION);
        if(hapus == 0) {
            String sql="DELETE FROM login WHERE username =  '"+tUsername.getText()+"'";
            try {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                tUsername.requestFocus();
                clear();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and displabgorm */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cbHak;
    private javax.swing.JButton delete;
    private javax.swing.JLabel hak;
    private javax.swing.JLabel logo;
    private javax.swing.JButton save;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}
