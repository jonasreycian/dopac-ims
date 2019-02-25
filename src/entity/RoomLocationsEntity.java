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
public class RoomLocationsEntity{
    
    private int id;
    private String name;
    private RoomsEntity roomsEntity;
    
    private final SelectProcess selectProcess = new SelectProcess();
    private ResultSet resultSet;
    
    public RoomLocationsEntity(int id) {
        this.id = id;
        
        resultSet = selectProcess.getAllRoomLocations();
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.name = resultSet.getString("name");
                    this.roomsEntity = new RoomsEntity(resultSet.getInt("room_id"));
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(RoomLocationsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the room_location
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the roomsEntity
     */
    public RoomsEntity getRoomsEntity() {
        return roomsEntity;
    }
}
