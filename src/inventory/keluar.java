/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kelar_Gaye
 */
public class keluar extends javax.swing.JFrame {
    private Connection con = new koneksi().connect();
    private Statement stat;
    private ResultSet res;
    private DefaultTableModel tabmode;
    /**
     * Creates new form keluar
     */
    public keluar() {
        initComponents();
        datatable();
        setLocationRelativeTo(getRootPane());
    }

    protected void datatable() {
        Object[] Baris={"ID KELUAR","KODE BARANG","NAMA BARANG","TANGGAL KELUAR",
            "JUMLAH KELUAR","ID STAFF"};
        tabmode = new DefaultTableModel(null,Baris);
        tableKeluar.setModel(tabmode);
        String sql="SELECT * FROM keluar";
        
        try{
            java.sql.Statement stat=con.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("idKeluar");
                String b = hasil.getString("kode");
                String c = hasil.getString("namaBrg");
                String d = hasil.getString("tglKeluar");
                String e = hasil.getString("jumlahKeluar");
                String f = hasil.getString("idStaff");
            
                String[] data={a,b,c,d,e,f};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKeluar = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        print = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
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

        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKeluarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKeluar);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 210, 780, 320);

        insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-INSERT.png"))); // NOI18N
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert);
        insert.setBounds(340, 550, 100, 40);

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-PRINT.png"))); // NOI18N
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print);
        print.setBounds(470, 550, 100, 40);
        getContentPane().add(tSearch);
        tSearch.setBounds(60, 170, 260, 30);

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BT-SEARCH.png"))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(330, 160, 40, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11HAL KELUAR.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 900, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        new crudKeluar().setVisible(true);
        dispose();
    }//GEN-LAST:event_insertActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_dashboardActionPerformed

    private void tableKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeluarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableKeluarMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
            String path="./src/laporan/lapKeluar.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
            JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada" + ex);
        }
    }//GEN-LAST:event_printActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        Object[] Baris={"ID KELUAR","KODE BARANG","NAMA BARANG","TANGGAL KELUAR",
            "JUMLAH KELUAR","ID STAFF"};
        tabmode = new DefaultTableModel(null,Baris);
        tableKeluar.setModel(tabmode);
        String sql="SELECT * FROM keluar WHERE idKeluar LIKE '%"+tSearch.getText()+"%'";

        try{
            java.sql.Statement stat=con.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("idKeluar");
                String b = hasil.getString("kode");
                String c = hasil.getString("namaBrg");
                String d = hasil.getString("tglKeluar");
                String e = hasil.getString("jumlahKeluar");
                String f = hasil.getString("idStaff");
                String[] data={a,b,c,d,e,f};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data tidak ditemukan"+e);
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new keluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton insert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tableKeluar;
    // End of variables declaration//GEN-END:variables
}
