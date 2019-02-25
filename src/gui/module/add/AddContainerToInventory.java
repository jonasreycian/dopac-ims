/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.module.add;

import entity.ChemicalsEntity;
import static gui.Login.loadImageIcon;
import gui.module.view.ViewSuppliers;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import process.InsertProcess;
import process.SelectProcess;
import support.LiquidComboBoxModel;
import support.Random;
import support.SolidComboBoxModel;

/**
 *
 * @author Nas
 */
public class AddContainerToInventory extends javax.swing.JDialog {

    private final SelectProcess selectProcess = new SelectProcess();
    private ResultSet resultSet;
    private ChemicalsEntity chemicalsEntity;
    private final String[] MONTH = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
    
    
    public AddContainerToInventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initializeYear();
        initializeRooms();
        initializeRoomLocations(cbRoom.getSelectedItem().toString());
        
        cbRoom.addItemListener((ItemEvent e) -> {
            initializeRoomLocations(cbRoom.getSelectedItem().toString());
        });
        
        searchChemicals(tfSearch.getText());
        
        setIconImage(loadImageIcon("/img/cas-logo.png").getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfContainerName = new javax.swing.JTextField();
        cbRoomLocation = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbUnit = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tfSize = new javax.swing.JTextField();
        cbRoom = new javax.swing.JComboBox();
        tfSupplier = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCASRN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        cbPMonth = new javax.swing.JComboBox();
        cbPDay = new javax.swing.JComboBox();
        cbEMonth = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbEDay = new javax.swing.JComboBox();
        cbPYear = new javax.swing.JComboBox();
        cbEYear = new javax.swing.JComboBox();
        tfLabel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContainer = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(583, 2));

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

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/add_new_container.png"))); // NOI18N
        jLabel1.setText("ADDING NEW CONTAINER TO INVENTORY");

        btnAdd.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(105, 35));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Container Name:");

        tfContainerName.setEditable(false);
        tfContainerName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfContainerName.setPreferredSize(new java.awt.Dimension(14, 30));

        cbRoomLocation.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbRoomLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRoomLocation.setPreferredSize(new java.awt.Dimension(66, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Brand Name:");

        cbUnit.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mg", "g", "kg", "mL", "L", "Gal" }));
        cbUnit.setPreferredSize(new java.awt.Dimension(66, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Location:");

        tfSize.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSize.setPreferredSize(new java.awt.Dimension(14, 30));

        cbRoom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRoom.setPreferredSize(new java.awt.Dimension(66, 30));
        cbRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRoomItemStateChanged(evt);
            }
        });

        tfSupplier.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSupplier.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Container Size:");

        tfCASRN.setEditable(false);
        tfCASRN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfCASRN.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("CAS RN:");

        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new java.awt.Dimension(71, 30));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Quantity:");

        tfQuantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfQuantity.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Date Purchased:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("ID:");

        lblID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblID.setText("0");

        cbPMonth.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbPMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbPMonth.setPreferredSize(new java.awt.Dimension(66, 30));

        cbPDay.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbPDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbPDay.setPreferredSize(new java.awt.Dimension(66, 30));

        cbEMonth.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbEMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbEMonth.setPreferredSize(new java.awt.Dimension(66, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Date Expired:");

        cbEDay.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbEDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbEDay.setPreferredSize(new java.awt.Dimension(66, 30));

        cbPYear.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbPYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbPYear.setPreferredSize(new java.awt.Dimension(66, 30));

        cbEYear.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbEYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbEYear.setPreferredSize(new java.awt.Dimension(66, 30));

        tfLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfLabel.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Containers' label:");

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
                            .addComponent(tfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(tfCASRN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfContainerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tfSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbEDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbEYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbPDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRoomLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContainerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCASRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRoomLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbPMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbEDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Search:");

        tfSearch.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSearch.setPreferredSize(new java.awt.Dimension(73, 35));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        tblContainer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblContainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContainer.setRowHeight(22);
        tblContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContainerMouseClicked(evt);
            }
        });
        tblContainer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblContainerKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblContainer);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnNew.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNew.setText("New");
        btnNew.setPreferredSize(new java.awt.Dimension(105, 35));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        new ViewSuppliers(null, true).setVisible(true);
        
        if(ViewSuppliers.suppliersEntity != null)
            tfSupplier.setText(ViewSuppliers.suppliersEntity.getName());
        else
            tfSupplier.setText("");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(lblID.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Please select a container to add in the inventory!", "Error message!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            // second level validation
            String quantityStr = tfQuantity.getText();
            String sizeStr = tfSize.getText();
            String supplier = tfSupplier.getText();

            if(supplier.isEmpty() && quantityStr.isEmpty() && sizeStr.isEmpty()){
                JOptionPane.showMessageDialog(null, "Quantity, container size, and supplier must not be empty!", "Error message!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    double quantity = Double.valueOf(quantityStr);
                    int size = Integer.valueOf(sizeStr);
                    String unit = cbUnit.getSelectedItem().toString();
                    String date_purchased = cbPYear.getSelectedItem()+"-"+parseDay((cbPMonth.getSelectedIndex()+1) +"")+"-"+parseDay(cbPDay.getSelectedItem().toString());
                    String date_expired = cbEYear.getSelectedItem()+"-"+parseDay((cbPMonth.getSelectedIndex()+1) + "")+"-"+parseDay(cbEDay.getSelectedItem().toString());
                    int chemical_id = Integer.valueOf(lblID.getText());
                    int supplier_id = selectProcess.getSupplierID(supplier);
                    int room_location_id = selectProcess.getRoomLocationID(cbRoomLocation.getSelectedItem().toString());
                    
                    InsertProcess insertProcess = new InsertProcess();

                    // return false if successful
                    boolean status = insertProcess.insertChemicalInventory(quantity, size, unit, date_purchased, date_expired, chemical_id, supplier_id, room_location_id);

                    if(!status){
                        // insert container's data
                        String label = tfLabel.getText();
                        int chemical_inventory_id = selectProcess.getChemicalInventoryID(quantity, size, unit, date_purchased, date_expired, chemical_id, 
                                supplier_id, room_location_id);
                        
                        for(int i=1; i<=quantity; i++){
                            insertProcess.insertChemicalContainer(1, label + "-" + parseNumber(i), "", chemical_inventory_id);
                        }
                        JOptionPane.showMessageDialog(this, "Successfully added to inventory", "Success!", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Failed to add!", "Error message!", JOptionPane.ERROR_MESSAGE);
                        this.dispose();
                    }
                } catch (NumberFormatException | HeadlessException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage() , "Error message!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRoomItemStateChanged
        
    }//GEN-LAST:event_cbRoomItemStateChanged

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        searchChemicals(tfSearch.getText());
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tblContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContainerMouseClicked
        int row = tblContainer.getSelectedRow();
        String casrn = tblContainer.getValueAt(row, 0).toString();
        String chemical = tblContainer.getValueAt(row, 1).toString();

        resultSet = selectProcess.getAllChemicals();
        try {
            while(resultSet.next()){
                if(casrn.equals(resultSet.getString("casrn")) && chemical.equals(resultSet.getString("name"))){
                     chemicalsEntity = new ChemicalsEntity(resultSet.getInt("id"));
                }
            }
            resultSet.close();
        } catch (SQLException ex) {}

        // Setting up values
        lblID.setText(chemicalsEntity.getId() +"");
        tfContainerName.setText(chemicalsEntity.getName());
        tfCASRN.setText(chemicalsEntity.getCasrn());
        tfSupplier.setText("");
        
        if(chemicalsEntity.getType1().equals("Solid"))
            cbUnit.setModel(new SolidComboBoxModel());
        else
            cbUnit.setModel(new LiquidComboBoxModel());
        
        cbUnit.setSelectedIndex(0);
        tfLabel.setText(Random.getFuckingRandomString());
    }//GEN-LAST:event_tblContainerMouseClicked

    private void tblContainerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblContainerKeyReleased

    }//GEN-LAST:event_tblContainerKeyReleased

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        new AddChemical(null, true).setVisible(true);
        searchChemicals(tfSearch.getText());
    }//GEN-LAST:event_btnNewActionPerformed

    private void searchChemicals(String keywords){
        resultSet = selectProcess.searchChemicals(keywords);
        tblContainer.setModel(DbUtils.resultSetToTableModel(resultSet));

        int width = tblContainer.getWidth();
        tblContainer.getColumnModel().getColumn(0).setPreferredWidth((int) (width * .3));
        tblContainer.getColumnModel().getColumn(1).setPreferredWidth((int) (width * .7));

    }
    
    
    private void initializeRooms(){
        resultSet = selectProcess.getAllRooms();
        
        cbRoom.removeAllItems();
        try {
            while(resultSet.next())
                cbRoom.addItem(resultSet.getString("name"));
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddContainerToInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cbRoom.setSelectedIndex(0);
    }
    
    private void initializeRoomLocations(String rooms){
        resultSet = selectProcess.getRoomLocations(rooms);
        
        cbRoomLocation.removeAllItems();
        try {
            while(resultSet.next()){
                cbRoomLocation.addItem(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddContainerToInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeYear(){
        cbEYear.removeAllItems();
        cbPYear.removeAllItems();
        
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        
        for(int yy = year-1; yy<=year; yy++)
            cbPYear.addItem(yy);
        
        for(int yy = year; yy<= year+7; yy++)
            cbEYear.addItem(yy);
        
        // Set the year to current year
        cbPYear.setSelectedIndex(0); 
        cbEYear.setSelectedIndex(0);
        
        // Set month
        cbPMonth.setSelectedItem(MONTH[calendar.get(calendar.MONTH)]);
        cbPDay.setSelectedItem(calendar.get(calendar.DAY_OF_MONTH));
    }
    
    private String parseDay(String day){
        return day.length()==1? "0"+day : day;
    }
    
     private String parseNumber(int x){
        String str = "";
        if(String.valueOf(x).length() == 1)
            str = "00" + x;
        else if(String.valueOf(x).length() == 2)
            str = "0" + x;
        
        return str;
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
            java.util.logging.Logger.getLogger(AddContainerToInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AddContainerToInventory dialog = new AddContainerToInventory(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbEDay;
    private javax.swing.JComboBox cbEMonth;
    private javax.swing.JComboBox cbEYear;
    private javax.swing.JComboBox cbPDay;
    private javax.swing.JComboBox cbPMonth;
    private javax.swing.JComboBox cbPYear;
    private javax.swing.JComboBox cbRoom;
    private javax.swing.JComboBox cbRoomLocation;
    private javax.swing.JComboBox cbUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblContainer;
    private javax.swing.JTextField tfCASRN;
    private javax.swing.JTextField tfContainerName;
    private javax.swing.JTextField tfLabel;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSize;
    private javax.swing.JTextField tfSupplier;
    // End of variables declaration//GEN-END:variables

   
}
