/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.SelectProcess;

/**
 *
 * @author jonsa
 */
public class GlasswareEntity {
    private int id;
    private String name;

    public GlasswareEntity(int id) {
        this.id = id;
        
        SelectProcess selectProcess = new SelectProcess();
        ResultSet resultSet = selectProcess.getAllGlasswares();
        
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.name = resultSet.getString("name");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlasswareEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
