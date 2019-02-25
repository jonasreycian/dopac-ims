/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.module.view;

import entity.ChemicalContainersEntity;
import entity.ChemicalInventoriesEntity;
import gui.HomeChemical;
import static gui.Login.loadImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import process.SelectProcess;
import process.UpdateProcess;

/**
 *
 * @author jonsa
 */
public class ViewChemicalInventoryProfile extends javax.swing.JDialog {

    private final SelectProcess selectProcess = new SelectProcess();
    private ResultSet resultSet;
    public static ChemicalContainersEntity chemicalContainersEntity;
    
    public ViewChemicalInventoryProfile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initializeInventoryValues();
        searchContainers(tfSearch.getText());
        
        btnEdit.setVisible(false);
        
        setIconImage(loadImageIcon("/img/cas-logo.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCasrn = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblInventoryID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        lblChemical = new javax.swing.JLabel();
        lblDatePurchased = new javax.swing.JLabel();
        lblDateExpired = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblLastUpdated = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblContainerID = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tfLabel = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taRemarks = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContainers = new javax.swing.JTable();
        btnWithdraw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(760, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel2.setText("ID:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel11.setText("Container size:");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel15.setText("Date expired:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel3.setText("CAS-RN:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel8.setText("Supplier:");

        lblCasrn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCasrn.setText("jLabel5");

        lblLocation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblLocation.setText("jLabel5");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel4.setText("Container:");

        lblInventoryID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblInventoryID.setText("jLabel5");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel13.setText("Date purchased:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel10.setText("Quantity:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Inventory Details:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel12.setText("Location:");

        lblSupplier.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblSupplier.setText("jLabel5");

        lblChemical.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblChemical.setText("jLabel5");

        lblDatePurchased.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDatePurchased.setText("jLabel5");

        lblDateExpired.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDateExpired.setText("jLabel5");

        lblSize.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblSize.setText("jLabel5");

        lblQuantity.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblQuantity.setText("jLabel5");

        btnEdit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/ic_mode_edit_black_18dp_1x.png"))); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel16.setText("Last Updated:");

        lblLastUpdated.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblLastUpdated.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInventoryID)
                                    .addComponent(lblSupplier)
                                    .addComponent(lblLocation)
                                    .addComponent(lblChemical)
                                    .addComponent(lblCasrn))
                                .addGap(193, 193, 193)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDateExpired)
                                            .addComponent(lblDatePurchased)
                                            .addComponent(lblLastUpdated))
                                        .addGap(28, 28, 28))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel10))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblQuantity)
                                                    .addComponent(lblSize))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jSeparator1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblInventoryID)
                    .addComponent(jLabel10)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCasrn)
                    .addComponent(jLabel11)
                    .addComponent(lblSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblChemical)
                    .addComponent(jLabel13)
                    .addComponent(lblDatePurchased))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblSupplier)
                    .addComponent(jLabel15)
                    .addComponent(lblDateExpired))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblLocation)
                    .addComponent(jLabel16)
                    .addComponent(lblLastUpdated))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel20.setText("Container Details:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel21.setText("Updating Section");

        lblContainerID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblContainerID.setText("0");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel23.setText("ID:");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel24.setText("Label:");

        tfLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tfLabel.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel25.setText("Remarks:");

        taRemarks.setColumns(20);
        taRemarks.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        taRemarks.setLineWrap(true);
        taRemarks.setRows(5);
        jScrollPane2.setViewportView(taRemarks);

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblContainerID)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblContainerID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Search:");

        tfSearch.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tfSearch.setPreferredSize(new java.awt.Dimension(14, 30));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        tblContainers.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblContainers.setModel(new javax.swing.table.DefaultTableModel(
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
        tblContainers.setRowHeight(20);
        tblContainers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContainersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContainers);

        btnWithdraw.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addGap(148, 148, 148)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        searchContainers(tfSearch.getText());
    }//GEN-LAST:event_tfSearchKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblContainers.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Please select a container to update!", "Error message!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int id = Integer.valueOf(lblContainerID.getText());
            
            // Set new values
            ChemicalContainersEntity chemicalContainersEntity = new ChemicalContainersEntity(id);
            chemicalContainersEntity.setLabel(tfLabel.getText());
            chemicalContainersEntity.setRemarks(taRemarks.getText());
            
            // Updating process
            UpdateProcess up = new UpdateProcess();
            boolean status = up.updateChemicalContainer(chemicalContainersEntity); // return false if successful

            if(!status){
                JOptionPane.showMessageDialog(this, "Updated successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to update!", "Error message!", JOptionPane.ERROR_MESSAGE);
            }
            
            searchContainers(tfSearch.getText());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        int row = tblContainers.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Please select a container to withdraw!", "Error message!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int id = Integer.valueOf(tblContainers.getValueAt(row, 0).toString());
            chemicalContainersEntity = new ChemicalContainersEntity(id);
            
            new ViewWithdrawSection(null, true).setVisible(true);
            
            searchContainers(tfSearch.getText());
            lblQuantity.setText(HomeChemical.chemicalInventoriesEntity.getQuantity()+ "");
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void tblContainersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContainersMouseClicked
        int row = tblContainers.getSelectedRow();
        
        int id = Integer.valueOf(tblContainers.getValueAt(row, 0).toString());
        
        ChemicalContainersEntity cc = new ChemicalContainersEntity(id);
        lblContainerID.setText(cc.getId() +"");
        tfLabel.setText(cc.getLabel());
        taRemarks.setText(cc.getRemarks());
    }//GEN-LAST:event_tblContainersMouseClicked

    
    private void initializeInventoryValues(){
        ChemicalInventoriesEntity cie = HomeChemical.chemicalInventoriesEntity;
        
        lblInventoryID.setText(cie.getId() +"");
        lblCasrn.setText(cie.getChemicalsEntity().getCasrn());
        lblChemical.setText(cie.getChemicalsEntity().getName());
        lblQuantity.setText(cie.getQuantity() + "");
        lblSize.setText(cie.getSize() + " " + cie.getUnit());
        lblLocation.setText(cie.getRoomLocationsEntity().getRoomsEntity().getName() + " >> " + cie.getRoomLocationsEntity().getName());
        lblDatePurchased.setText(cie.getDate_purchased() + "");
        lblDateExpired.setText(cie.getDate_expired() + "");
        lblSupplier.setText(cie.getSuppliersEntity().getName());
        lblLastUpdated.setText(cie.getDate_updated() + "");
    }
    
    private void searchContainers(String keyword){
        int id = HomeChemical.chemicalInventoriesEntity.getId();
        resultSet = selectProcess.searchChemicalContainers(keyword, id);
        tblContainers.setModel(DbUtils.resultSetToTableModel(resultSet));
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewChemicalInventoryProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = tblContainers.getWidth();
        tblContainers.getColumnModel().getColumn(0).setPreferredWidth((int) (width * .2));
        tblContainers.getColumnModel().getColumn(1).setPreferredWidth((int) (width * .6));
        tblContainers.getColumnModel().getColumn(2).setPreferredWidth((int) (width * .2));
    }
    
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
            java.util.logging.Logger.getLogger(ViewChemicalInventoryProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ViewChemicalInventoryProfile dialog = new ViewChemicalInventoryProfile(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCasrn;
    private javax.swing.JLabel lblChemical;
    private javax.swing.JLabel lblContainerID;
    private javax.swing.JLabel lblDateExpired;
    private javax.swing.JLabel lblDatePurchased;
    private javax.swing.JLabel lblInventoryID;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JTextArea taRemarks;
    private javax.swing.JTable tblContainers;
    private javax.swing.JTextField tfLabel;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
