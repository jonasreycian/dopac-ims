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
public class ChemicalInventoriesEntity {
    private int id;
    private double quantity;
    private int size;
    private String unit;
    private Date date_purchased;
    private Date date_expired;
    private int chemical_id;
    private int supplier_id;
    private int room_location_id;
    private Timestamp date_created;
    private Timestamp date_updated;
    
    private ChemicalsEntity chemicalsEntity;
    private SuppliersEntity suppliersEntity;
    private RoomLocationsEntity roomLocationsEntity;

    private final SelectProcess selectProcess = new SelectProcess();
    private ResultSet resultSet;
    
    public ChemicalInventoriesEntity(int id) {
        this.id = id;
        
        resultSet = selectProcess.getAllChemicalInventories();
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.quantity = resultSet.getDouble("quantity");
                    this.size = resultSet.getInt("size");
                    this.unit = resultSet.getString("unit");
                    this.date_purchased = resultSet.getDate("date_purchased");
                    this.date_expired = resultSet.getDate("date_expired");
                    this.chemical_id = resultSet.getInt("chemical_id");
                    this.supplier_id = resultSet.getInt("supplier_id");
                    this.room_location_id = resultSet.getInt("room_location_id");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChemicalInventoriesEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.chemicalsEntity = new ChemicalsEntity(chemical_id);
        this.suppliersEntity = new SuppliersEntity(supplier_id);
        this.roomLocationsEntity = new RoomLocationsEntity(room_location_id);
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
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @return the date_purchased
     */
    public Date getDate_purchased() {
        return date_purchased;
    }

    /**
     * @return the date_expired
     */
    public Date getDate_expired() {
        return date_expired;
    }

    /**
     * @return the chemical_id
     */
    public int getChemical_id() {
        return chemical_id;
    }

    /**
     * @return the supplier_id
     */
    public int getSupplier_id() {
        return supplier_id;
    }

    /**
     * @return the room_location_id
     */
    public int getRoom_location_id() {
        return room_location_id;
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
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @param date_purchased the date_purchased to set
     */
    public void setDate_purchased(Date date_purchased) {
        this.date_purchased = date_purchased;
    }

    /**
     * @param date_expired the date_expired to set
     */
    public void setDate_expired(Date date_expired) {
        this.date_expired = date_expired;
    }

    /**
     * @param chemical_id the chemical_id to set
     */
    public void setChemical_id(int chemical_id) {
        this.chemical_id = chemical_id;
    }

    /**
     * @param supplier_id the supplier_id to set
     */
    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    /**
     * @param room_location_id the room_location_id to set
     */
    public void setRoom_location_id(int room_location_id) {
        this.room_location_id = room_location_id;
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
     * @return the chemicalsEntity
     */
    public ChemicalsEntity getChemicalsEntity() {
        return chemicalsEntity;
    }

    /**
     * @return the suppliersEntity
     */
    public SuppliersEntity getSuppliersEntity() {
        return suppliersEntity;
    }

    /**
     * @return the roomLocationsEntity
     */
    public RoomLocationsEntity getRoomLocationsEntity() {
        return roomLocationsEntity;
    }

    /**
     * @param chemicalsEntity the chemicalsEntity to set
     */
    public void setChemicalsEntity(ChemicalsEntity chemicalsEntity) {
        this.chemicalsEntity = chemicalsEntity;
    }

    /**
     * @param suppliersEntity the suppliersEntity to set
     */
    public void setSuppliersEntity(SuppliersEntity suppliersEntity) {
        this.suppliersEntity = suppliersEntity;
    }

    /**
     * @param roomLocationsEntity the roomLocationsEntity to set
     */
    public void setRoomLocationsEntity(RoomLocationsEntity roomLocationsEntity) {
        this.roomLocationsEntity = roomLocationsEntity;
    }
}
