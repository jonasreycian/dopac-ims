/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.SelectProcess;

/**
 *
 * @author jonsa
 */
public class ChemicalContainersEntity {
    private int id;
    private double quantity;
    private String label;
    private String remarks;
    private int chemical_inventory_id;
    private Timestamp date_created;
    private Timestamp date_updated;

    private final ChemicalInventoriesEntity chemicalInventoriesEntity;
    
    private final SelectProcess selectProcess = new SelectProcess();
    private ResultSet resultSet;
    
    public ChemicalContainersEntity(int id) {
        this.id = id;
        
        resultSet = selectProcess.getAllChemicalContainers();
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.quantity = resultSet.getDouble("quantity");
                    this.label = resultSet.getString("label");
                    this.remarks = resultSet.getString("remarks");
                    this.chemical_inventory_id = resultSet.getInt("chemical_inventory_id");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChemicalContainersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chemicalInventoriesEntity = new ChemicalInventoriesEntity(chemical_inventory_id);
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @return the chemical_inventory_id
     */
    public int getChemical_inventory_id() {
        return chemical_inventory_id;
    }

    /**
     * @return the date_created
     */
    public Timestamp getDate_created() {
        return date_created;
    }

    /**
     * @return the date_updated
     */
    public Timestamp getDate_updated() {
        return date_updated;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @param chemical_inventory_id the chemical_inventory_id to set
     */
    public void setChemical_inventory_id(int chemical_inventory_id) {
        this.chemical_inventory_id = chemical_inventory_id;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    /**
     * @param date_updated the date_updated to set
     */
    public void setDate_updated(Timestamp date_updated) {
        this.date_updated = date_updated;
    }

    /**
     * @return the chemicalInventoriesEntity
     */
    public ChemicalInventoriesEntity getChemicalInventoriesEntity() {
        return chemicalInventoriesEntity;
    }
}
