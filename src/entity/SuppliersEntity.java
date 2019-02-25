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
public class SuppliersEntity {
    private int id;
    private String name;
    private Timestamp date_created;
    private Timestamp date_updated;

    private final SelectProcess selectProcess;
    private final ResultSet resultSet;
    
    public SuppliersEntity(int id) {
        this.id = id;
        
        selectProcess = new SelectProcess();
        resultSet = selectProcess.getAllSuppliers();
        
        try {
            while(resultSet.next()){
                if(id == resultSet.getInt("id")){
                    this.name = resultSet.getString("name");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the supplierName
     */
    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
}
