/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.module.view;

import entity.ChemicalContainersEntity;
import entity.ChemicalInventoriesEntity;
import gui.HomeChemical;
import gui.Login;
import static gui.Login.loadImageIcon;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import process.InsertProcess;
import process.SelectProcess;
import process.UpdateProcess;
import support.SolidComboBoxModel;

/**
 *
 * @author jonsa
 */
public class ViewWithdrawSection extends javax.swing.JDialog {

    /**
     * Creates new form ViewWithdrawSection
     */
    public ViewWithdrawSection(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initializeValue();        
        
        setIconImage(loadImageIcon("/img/cas-logo.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tfLabel = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taRemarks = new javax.swing.JTextArea();
        btnWithdraw = new javax.swing.JButton();
        tfQuantity = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        tfSize = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbUnits = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setText("Withdraw Section");

        lblID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblID.setText("jLabel5");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel28.setText("ID:");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel29.setText("Label:");

        tfLabel.setEditable(false);
        tfLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfLabel.setPreferredSize(new java.awt.Dimension(14, 30));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel30.setText("Remarks:");

        taRemarks.setColumns(20);
        taRemarks.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        taRemarks.setLineWrap(true);
        taRemarks.setRows(5);
        jScrollPane3.setViewportView(taRemarks);

        btnWithdraw.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        tfQuantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfQuantity.setPreferredSize(new java.awt.Dimension(14, 30));
        tfQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantityKeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel31.setText("Quantity:");

        tfSize.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tfSize.setPreferredSize(new java.awt.Dimension(14, 30));
        tfSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSizeKeyReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel32.setText("Container size:");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jLabel33.setText("Balance:");

        lblBalance.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblBalance.setText("Remarks:");

        cbUnits.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbUnits.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnits.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUnitsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(tfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID)
                                    .addComponent(lblBalance))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnWithdraw))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(tfSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(tfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(cbUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWithdraw)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        double balance = Double.valueOf(lblBalance.getText());
        if(balance < 0){
            JOptionPane.showMessageDialog(null, "Please enter the exact amount only!", "Error message!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertProcess insertProcess = new InsertProcess();
            UpdateProcess updateProcess = new UpdateProcess();        
            SelectProcess selectProcess = new SelectProcess();
            
            try {
                double quantity = Double.valueOf(tfQuantity.getText());
                int size = Integer.valueOf(tfSize.getText());
                String unit = cbUnits.getSelectedItem().toString();
                String remarks = taRemarks.getText();
                int chemical_container_id = Integer.valueOf(lblID.getText());
                int user_id = Login.usersEntity.getId();
                
                boolean status = insertProcess.insertChemicalWithdraw(quantity, size, unit, remarks, chemical_container_id, user_id);
                
                // return false is successfull
                if(!status){
                    ChemicalContainersEntity chemicalContainersEntity = ViewChemicalInventoryProfile.chemicalContainersEntity;
                    chemicalContainersEntity.setQuantity(balance);
                    
                    // Update the quantity of the tbl_chemicalCOntainer
                    updateProcess.updateChemicalContainer(chemicalContainersEntity);
                    
                    double sum_quantity = selectProcess.getSumOfQuantities(chemicalContainersEntity);
                    
                    // Update the quantity of in tbl_chemicalInventoty
                    HomeChemical.chemicalInventoriesEntity.setQuantity(sum_quantity);
                    
                    ViewChemicalInventoryProfile.chemicalContainersEntity = chemicalContainersEntity;
                    
                    updateProcess.updateChemicalInventories(HomeChemical.chemicalInventoriesEntity);
                    this.dispose();
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Failed to withdraw!", "Error message!", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error message!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void tfQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantityKeyReleased
        if(tfQuantity.getText().length() > 0)
            setBalance();
    }//GEN-LAST:event_tfQuantityKeyReleased

    private void tfSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSizeKeyReleased
        if(tfSize.getText().length() > 0)
            setBalance();
    }//GEN-LAST:event_tfSizeKeyReleased

    private void cbUnitsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUnitsItemStateChanged
        setBalance();
    }//GEN-LAST:event_cbUnitsItemStateChanged

    private void setBalance(){
        try {
            double quantity = Double.valueOf(tfQuantity.getText());
            int size = Integer.valueOf(tfSize.getText());
            String unit = cbUnits.getSelectedItem().toString();
            
            double balance = computeBalance(quantity, size, unit);
            lblBalance.setText(balance + "");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "SET balance: " + e.getMessage(), "Error message!", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        }
    }
    
    private void initializeValue(){
        ChemicalContainersEntity cc = ViewChemicalInventoryProfile.chemicalContainersEntity;
        
        lblID.setText(cc.getId() + "");
        tfLabel.setText(cc.getLabel());
        tfQuantity.setText(cc.getQuantity() + "");
        tfSize.setText(cc.getChemicalInventoriesEntity().getSize() + "");
        
        String type1 = cc.getChemicalInventoriesEntity().getChemicalsEntity().getType1();
        cbUnits.removeAllItems();
        if(type1.equals("Solid")){
            
           //{"mg","g","kg"};
            cbUnits.addItem("mg");
            cbUnits.addItem("g");
            cbUnits.addItem("kg");
        }
        else{
            //"mL","L","Gal"};
            cbUnits.addItem("mL");
            cbUnits.addItem("L");
            cbUnits.addItem("Gal");
        }
        
        cbUnits.setSelectedItem(cc.getChemicalInventoriesEntity().getUnit());
        setBalance();
    }
    
    private double computeBalance(double quantity, int size, String unit){
        String type1 = ViewChemicalInventoryProfile.chemicalContainersEntity.getChemicalInventoriesEntity().getChemicalsEntity().getType1();
        String originalUnit = ViewChemicalInventoryProfile.chemicalContainersEntity.getChemicalInventoriesEntity().getUnit();
        String originalQuantity = ViewChemicalInventoryProfile.chemicalContainersEntity.getQuantity() + "";
        String originalSize = ViewChemicalInventoryProfile.chemicalContainersEntity.getChemicalInventoriesEntity().getSize() + "";
        
        double balance = Double.valueOf(originalQuantity) * Double.valueOf(originalSize);
        double originalBalance = balance;
        quantity *= size;
        
        if(type1.equals("Solid")){
            switch(originalUnit){
                case "mg":
                    // mg to mg
                    if(unit.equals("mg"))
                        balance -= quantity;
                    
                    // mg to g
                    if(unit.equals("g"))
                        balance -= quantity*1000;
                                
                    // mg to kg
                    if(unit.equals("kg"))
                        balance -= quantity*1000000;
                    break;
                    
                case "g":
                    // g to mg
                    if(unit.equals("mg"))
                        balance -= (quantity/1000);
                    
                    // g to g
                    if(unit.equals("g"))
                        balance -= quantity;
                                
                    // g to kg
                    if(unit.equals("kg"))
                        balance -= quantity*1000;
                    break;
                    
                case "kg":
                    // kg to mg
                    if(unit.equals("mg"))
                        balance -= (quantity/1000000);
                    
                    // kg to g
                    if(unit.equals("g"))
                        balance -= (quantity/1000);
                                
                    // kg to kg
                    if(unit.equals("kg"))
                        balance -= quantity;
                    break;
            }
        }
        else if(type1.equals("Liquid")){
            switch(originalUnit){
                case "mL":
                    // mL to mL
                    if(unit.equals("mL"))
                        balance -= quantity;
                    
                    // mL to L
                    if(unit.equals("L"))
                        balance -= (quantity*1000);
                    
                    // mL to Gal
                    if(unit.equals("Gal"))
                        balance -= (quantity*1000*4.55);
                    break;
                    
                case "L":
                    // L to mL
                    if(unit.equals("mL"))
                        balance -= (quantity/1000);
                    
                    // L to L
                    if(unit.equals("L"))
                        balance -= quantity;
                    
                    // L to Gal
                    if(unit.equals("Gal"))
                        balance -= (quantity*4.55);
                    
                    break;
                case "Gal":
                    // Gal to mL
                    if(unit.equals("mL"))
                        balance -= (quantity/4550);
                    
                    // Gal to L
                    if(unit.equals("L"))
                        balance -= (quantity/4.55);
                    
                    // Gal to Gal
                    if(unit.equals("Gal"))
                        balance -= quantity;
                    break;
            }
        }
        
        return balance/originalBalance;
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
            java.util.logging.Logger.getLogger(ViewWithdrawSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ViewWithdrawSection dialog = new ViewWithdrawSection(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JComboBox<String> cbUnits;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextArea taRemarks;
    private javax.swing.JTextField tfLabel;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSize;
    // End of variables declaration//GEN-END:variables
}
