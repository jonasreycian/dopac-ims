/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.GlasswareInventoriesEntity;
import static gui.Login.loadImageIcon;
import gui.menus.AccountSettings;
import gui.menus.GlasswareWithdrawLogs;
import gui.module.add.AddNewGlasswareInventory;
import gui.module.view.ViewWIthdrawGlassware;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;
import process.SelectProcess;
import support.GlasswareInventoryReport;
import support.Random;

/**
 *
 * @author Nas
 */
public class HomeGlassware extends javax.swing.JFrame {
    
    public static GlasswareInventoriesEntity glasswareInventoriesEntity;
    
    public HomeGlassware() {
        initComponents();
        
        startClock();
        searchGlasware(tfSearchGLass.getText());
        
        setIconImage(loadImageIcon("/img/cas-logo.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }
    
    private void startClock() {
        Timer timer = new Timer(500, (ActionEvent e) -> {
            this.setTitle("DoPAC Inventory Management System | TIME: " + DateFormat.getTimeInstance().format(new Date()));
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tfSearchGLass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGlasswareInventory = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();
        btnAddNewItem = new javax.swing.JButton();
        btnWithdraw = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAccountSetting = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        menuLogs = new javax.swing.JMenu();
        menuChemical = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/inventory.png"))); // NOI18N
        jLabel3.setText("Glassware's Current Inventory");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Search:");

        tfSearchGLass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSearchGLass.setPreferredSize(new java.awt.Dimension(14, 30));
        tfSearchGLass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchGLassKeyReleased(evt);
            }
        });

        tblGlasswareInventory.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblGlasswareInventory.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGlasswareInventory.setRowHeight(22);
        tblGlasswareInventory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblGlasswareInventory);

        btnExport.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExport.setText("Export");
        btnExport.setPreferredSize(new java.awt.Dimension(67, 30));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnAddNewItem.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAddNewItem.setText("New Inventory");
        btnAddNewItem.setPreferredSize(new java.awt.Dimension(108, 30));
        btnAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewItemActionPerformed(evt);
            }
        });

        btnWithdraw.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.setPreferredSize(new java.awt.Dimension(67, 30));
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSearchGLass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnWithdraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfSearchGLass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(145, 30));

        jMenu1.setText("File");

        menuAccountSetting.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuAccountSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/account_setting_icon.png"))); // NOI18N
        menuAccountSetting.setText("Account Settings");
        menuAccountSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAccountSettingActionPerformed(evt);
            }
        });
        jMenu1.add(menuAccountSetting);
        jMenu1.add(jSeparator1);

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/logout.png"))); // NOI18N
        menuLogout.setText("Log - Out");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        jMenuBar1.add(jMenu1);

        menuLogs.setText("Logs");
        menuLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogsMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogs);

        menuChemical.setText("Chemicals");
        menuChemical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuChemicalMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuChemical);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewItemActionPerformed
        new AddNewGlasswareInventory(this, true).setVisible(true);
        
        searchGlasware(tfSearchGLass.getText());
    }//GEN-LAST:event_btnAddNewItemActionPerformed

    private void tfSearchGLassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchGLassKeyReleased
        
    }//GEN-LAST:event_tfSearchGLassKeyReleased

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        String tmpFilename = "" + Random.getFuckingRandomString() + Random.getCurrentDateTime();
        tmpFilename = tmpFilename.replace("-", "").replace(":", "").replaceAll(" ", "");
        
        GlasswareInventoryReport gir = new GlasswareInventoryReport(tmpFilename);
        gir.exportData();
        
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        JOptionPane.showMessageDialog(null, "Your file has been saved to " + gir.getFilePath(), "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        try {
            Runtime.getRuntime().exec("explorer.exe /select," + gir.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        int out = JOptionPane.showConfirmDialog(this, "Are you sure you want to log-out?", "Confirm!", JOptionPane.WARNING_MESSAGE);
        
        // 0 = ok; 2 = cancel
        if(out == 0){
            Login.usersEntity = null;
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuAccountSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAccountSettingActionPerformed
        new AccountSettings(this, true).setVisible(true);
    }//GEN-LAST:event_menuAccountSettingActionPerformed

    private void menuLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogsMouseClicked
        new GlasswareWithdrawLogs(this, true).setVisible(true);
    }//GEN-LAST:event_menuLogsMouseClicked

    private void menuChemicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuChemicalMouseClicked
        this.dispose();
        
        new HomeChemical().setVisible(true);
    }//GEN-LAST:event_menuChemicalMouseClicked

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        int row = tblGlasswareInventory.getSelectedRow();
        
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Please select a glassware to withdraw!", "Error message!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int id = Integer.valueOf(tblGlasswareInventory.getValueAt(row, 0).toString());
            glasswareInventoriesEntity = new GlasswareInventoriesEntity(id);
            
            new ViewWIthdrawGlassware(this, true).setVisible(true);
            
            searchGlasware(tfSearchGLass.getText());
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed
 
    private void searchGlasware(String keyword){
        SelectProcess selectProcess = new SelectProcess();
        ResultSet resultSet = selectProcess.searchGlasswareInventory(keyword);
        
        tblGlasswareInventory.setModel(DbUtils.resultSetToTableModel(resultSet));
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(HomeGlassware.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = tblGlasswareInventory.getWidth();
        tblGlasswareInventory.getColumnModel().getColumn(0).setPreferredWidth((int) (width * .08));
        tblGlasswareInventory.getColumnModel().getColumn(1).setPreferredWidth((int) (width * .33));
        tblGlasswareInventory.getColumnModel().getColumn(2).setPreferredWidth((int) (width * .12));
        tblGlasswareInventory.getColumnModel().getColumn(3).setPreferredWidth((int) (width * .2));
        tblGlasswareInventory.getColumnModel().getColumn(4).setPreferredWidth((int) (width * .27));
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeGlassware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGlassware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGlassware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGlassware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeGlassware().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewItem;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem menuAccountSetting;
    private javax.swing.JMenu menuChemical;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuLogs;
    private javax.swing.JTable tblGlasswareInventory;
    private javax.swing.JTextField tfSearchGLass;
    // End of variables declaration//GEN-END:variables
}
