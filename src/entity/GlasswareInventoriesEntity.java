/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
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
public class GlasswareInventoriesEntity {
    private int id;
    private String size;
    private int quantity;
    private int glassware_id;
    private Date date_purchased;
    private Timestamp date_created;
    private Timestamp date_updated;
    
    private final GlasswareEntity glasswareEntity;
    
    public GlasswareInventoriesEntity(int id) {
        this.id = id;
        
        SelectProcess selectProcess = new SelectProcess();
        ResultSet resultSet = selectProcess.getAllGlasswareInventories();
        
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.size = resultSet.getString("size");
                    this.quantity = resultSet.getInt("quantity");
                    this.glassware_id = resultSet.getInt("glassware_id");
                    this.date_purchased = resultSet.getDate("date_purchased");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(GlasswareInventoriesEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.glasswareEntity = new GlasswareEntity(glassware_id);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the glassware_id
     */
    public int getGlassware_id() {
        return glassware_id;
    }

    /**
     * @return the date_purchased
     */
    public Date getDate_purchased() {
        return date_purchased;
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
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param glassware_id the glassware_id to set
     */
    public void setGlassware_id(int glassware_id) {
        this.glassware_id = glassware_id;
    }

    /**
     * @param date_purchased the date_purchased to set
     */
    public void setDate_purchased(Date date_purchased) {
        this.date_purchased = date_purchased;
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
     * @return the glasswareEntity
     */
    public GlasswareEntity getGlasswareEntity() {
        return glasswareEntity;
    }
          
}
