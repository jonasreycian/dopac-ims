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
public class RoomsEntity {
    private int id;
    private String name;

    protected final SelectProcess selectProcess = new SelectProcess();
    protected ResultSet resultSet;
    
    public RoomsEntity(int id) {
        this.id = id;
        
        resultSet = selectProcess.getAllRooms();
        try {
            while(resultSet.next()){
                if(id == resultSet.getInt("id")){
                    this.name = resultSet.getString("name");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(RoomsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the room
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
     * @param room the room to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
