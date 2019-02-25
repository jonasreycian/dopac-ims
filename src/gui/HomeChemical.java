/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.ChemicalInventoriesEntity;
import static gui.Login.loadImageIcon;
import gui.menus.AccountSettings;
import gui.menus.ChemicalsManagement;
import gui.menus.SupplierManagement;
import gui.menus.UsersManagement;
import gui.menus.WithdrawLogs;
import gui.module.add.AddContainerToInventory;
import gui.module.view.ViewChemicalInventoryProfile;
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
import support.InventoryReport;
import support.Random;

/**
 *
 * @author jonsa
 */
public class HomeChemical extends javax.swing.JFrame {

    
    private final SelectProcess selectProcess = new SelectProcess();
    public static ChemicalInventoriesEntity chemicalInventoriesEntity;
    
    public HomeChemical() {
        initComponents();
        
        startClock();
        searchChemicalInventory(tfSearchInventory.getText());
        
        if(!Login.usersEntity.getDesignation().equals("Administrator"))
            menuUsersManagement.setVisible(false);
        
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tfSearchInventory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChemicalInventory = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnAddNewItem = new javax.swing.JButton();
        btnViewProfile = new javax.swing.JButton();
        menu_homeChemical = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        menuAccountSettings = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuLogOut = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuUsersManagement = new javax.swing.JMenuItem();
        menuContainerMgmt = new javax.swing.JMenuItem();
        menuManufacturerMgmt = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuWithdrawLogs = new javax.swing.JMenuItem();
        menuGlassware = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tfSearchInventory.setBackground(new java.awt.Color(255, 255, 255));
        tfSearchInventory.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSearchInventory.setForeground(new java.awt.Color(0, 0, 0));
        tfSearchInventory.setPreferredSize(new java.awt.Dimension(14, 35));
        tfSearchInventory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchInventoryKeyReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Search");

        tblChemicalInventory.setBackground(new java.awt.Color(255, 255, 255));
        tblChemicalInventory.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblChemicalInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CAS RN", "Container Name", "Manufacturer", "Qty", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChemicalInventory.setGridColor(new java.awt.Color(102, 102, 102));
        tblChemicalInventory.setRowHeight(22);
        tblChemicalInventory.setRowMargin(2);
        tblChemicalInventory.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tblChemicalInventory.getTableHeader().setReorderingAllowed(false);
        tblChemicalInventory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblChemicalInventoryFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(tblChemicalInventory);

        btnExport.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExport.setText("Export Inventory");
        btnExport.setPreferredSize(new java.awt.Dimension(57, 28));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/inventory.png"))); // NOI18N
        jLabel7.setText(" Current Inventory of the Chemicals");

        btnAddNewItem.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAddNewItem.setText("New Inventory");
        btnAddNewItem.setPreferredSize(new java.awt.Dimension(166, 28));
        btnAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewItemActionPerformed(evt);
            }
        });

        btnViewProfile.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnViewProfile.setText("View Profile");
        btnViewProfile.setPreferredSize(new java.awt.Dimension(98, 35));
        btnViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu_homeChemical.setBackground(new java.awt.Color(0, 0, 0));
        menu_homeChemical.setPreferredSize(new java.awt.Dimension(271, 30));

        menuUser.setText("File");
        menuUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        menuAccountSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuAccountSettings.setBackground(new java.awt.Color(255, 255, 255));
        menuAccountSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/account_setting_icon.png"))); // NOI18N
        menuAccountSettings.setText("Account Settings");
        menuAccountSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAccountSettingsActionPerformed(evt);
            }
        });
        menuUser.add(menuAccountSettings);
        menuUser.add(jSeparator1);

        menuLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        menuLogOut.setBackground(new java.awt.Color(255, 255, 255));
        menuLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/logout.png"))); // NOI18N
        menuLogOut.setText("Log - Out");
        menuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogOutActionPerformed(evt);
            }
        });
        menuUser.add(menuLogOut);

        menu_homeChemical.add(menuUser);

        jMenu3.setText("Manage");

        menuUsersManagement.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuUsersManagement.setBackground(new java.awt.Color(255, 255, 255));
        menuUsersManagement.setText("User Management");
        menuUsersManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsersManagementActionPerformed(evt);
            }
        });
        jMenu3.add(menuUsersManagement);

        menuContainerMgmt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuContainerMgmt.setText("Container Management");
        menuContainerMgmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContainerMgmtActionPerformed(evt);
            }
        });
        jMenu3.add(menuContainerMgmt);

        menuManufacturerMgmt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuManufacturerMgmt.setText("Supplier Management");
        menuManufacturerMgmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManufacturerMgmtActionPerformed(evt);
            }
        });
        jMenu3.add(menuManufacturerMgmt);

        menu_homeChemical.add(jMenu3);

        jMenu1.setText("Logs");

        menuWithdrawLogs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        menuWithdrawLogs.setText("Withdraw");
        menuWithdrawLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuWithdrawLogsActionPerformed(evt);
            }
        });
        jMenu1.add(menuWithdrawLogs);

        menu_homeChemical.add(jMenu1);

        menuGlassware.setText("Glasswares");
        menuGlassware.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGlasswareMouseClicked(evt);
            }
        });
        menu_homeChemical.add(menuGlassware);

        setJMenuBar(menu_homeChemical);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAccountSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAccountSettingsActionPerformed
        new AccountSettings(this, true).setVisible(true);
    }//GEN-LAST:event_menuAccountSettingsActionPerformed

    private void menuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogOutActionPerformed
        int out = JOptionPane.showConfirmDialog(this, "Are you sure you want to log-out?", "Confirm!", JOptionPane.WARNING_MESSAGE);
        
        // 0 = ok; 2 = cancel
        if(out == 0){
            Login.usersEntity = null;
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_menuLogOutActionPerformed

    private void menuUsersManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsersManagementActionPerformed
        new UsersManagement(this, true).setVisible(true);
    }//GEN-LAST:event_menuUsersManagementActionPerformed

    private void menuContainerMgmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContainerMgmtActionPerformed
        new ChemicalsManagement(this, true).setVisible(true);
    }//GEN-LAST:event_menuContainerMgmtActionPerformed

    private void menuManufacturerMgmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManufacturerMgmtActionPerformed
        new SupplierManagement(this, true).setVisible(true);

    }//GEN-LAST:event_menuManufacturerMgmtActionPerformed

    private void tblChemicalInventoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblChemicalInventoryFocusGained
      
    }//GEN-LAST:event_tblChemicalInventoryFocusGained

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String tmpFilename = "" + Random.getFuckingRandomString() + Random.getCurrentDateTime();
        tmpFilename = tmpFilename.replace("-", "").replace(":", "").replaceAll(" ", "");
        
        InventoryReport report = new InventoryReport(tmpFilename);
        
        report.exportData();
        
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        JOptionPane.showMessageDialog(null, "Your file has been saved to " + report.getFilePath(), "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        try {
            Runtime.getRuntime().exec("explorer.exe /select," + report.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewItemActionPerformed
        new AddContainerToInventory(this, true).setVisible(true);
        
        searchChemicalInventory(tfSearchInventory.getText());
    }//GEN-LAST:event_btnAddNewItemActionPerformed

    private void btnViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProfileActionPerformed
        int row = tblChemicalInventory.getSelectedRow();
        
        if(row < 0)
            JOptionPane.showMessageDialog(this, "Please select an item!", "Error message!", JOptionPane.ERROR_MESSAGE);
        else{
            int id = Integer.valueOf(tblChemicalInventory.getValueAt(row, 0).toString());
            System.out.println("ID: "+ id);
            chemicalInventoriesEntity = new ChemicalInventoriesEntity(id);
            
            new ViewChemicalInventoryProfile(null, true).setVisible(true);
            searchChemicalInventory(tfSearchInventory.getText());
        }
    }//GEN-LAST:event_btnViewProfileActionPerformed

    private void tfSearchInventoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchInventoryKeyReleased
        searchChemicalInventory(tfSearchInventory.getText());
    }//GEN-LAST:event_tfSearchInventoryKeyReleased

    private void menuWithdrawLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuWithdrawLogsActionPerformed
        new WithdrawLogs(this, true).setVisible(true);
    }//GEN-LAST:event_menuWithdrawLogsActionPerformed

    private void menuGlasswareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGlasswareMouseClicked
        this.dispose();
        new HomeGlassware().setVisible(true);
    }//GEN-LAST:event_menuGlasswareMouseClicked

    
    public void searchChemicalInventory(String keywords){
        ResultSet resultSet = selectProcess.searchChemicalInventories(tfSearchInventory.getText());
        tblChemicalInventory.setModel(DbUtils.resultSetToTableModel(resultSet));
        
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(HomeChemical.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = tblChemicalInventory.getWidth();
        tblChemicalInventory.getColumnModel().getColumn(0).setPreferredWidth((int) (width * .05));
        tblChemicalInventory.getColumnModel().getColumn(1).setPreferredWidth((int) (width * .23));
        tblChemicalInventory.getColumnModel().getColumn(2).setPreferredWidth((int) (width * .15));
        tblChemicalInventory.getColumnModel().getColumn(3).setPreferredWidth((int) (width * .06));
        tblChemicalInventory.getColumnModel().getColumn(4).setPreferredWidth((int) (width * .06));
        tblChemicalInventory.getColumnModel().getColumn(5).setPreferredWidth((int) (width * .11));
        tblChemicalInventory.getColumnModel().getColumn(6).setPreferredWidth((int) (width * .14));
        tblChemicalInventory.getColumnModel().getColumn(7).setPreferredWidth((int) (width * .1));
        tblChemicalInventory.getColumnModel().getColumn(8).setPreferredWidth((int) (width * .1));
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeChemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HomeChemical().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewItem;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnViewProfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem menuAccountSettings;
    private javax.swing.JMenuItem menuContainerMgmt;
    private javax.swing.JMenu menuGlassware;
    private javax.swing.JMenuItem menuLogOut;
    private javax.swing.JMenuItem menuManufacturerMgmt;
    private javax.swing.JMenu menuUser;
    private javax.swing.JMenuItem menuUsersManagement;
    private javax.swing.JMenuItem menuWithdrawLogs;
    private javax.swing.JMenuBar menu_homeChemical;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tblChemicalInventory;
    private javax.swing.JTextField tfSearchInventory;
    // End of variables declaration//GEN-END:variables
}
