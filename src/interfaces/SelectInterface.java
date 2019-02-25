/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.ChemicalContainersEntity;
import entity.UsersEntity;
import java.sql.ResultSet;

/**
 *
 * @author jonsa
 */
public interface SelectInterface {
    public ResultSet getAllUsers();
    public ResultSet getAllSuppliers();
    public ResultSet getAllRoomLocations();
    public ResultSet getAllRooms();
    public ResultSet getAllGlasswareOrders();
    public ResultSet getAllGlasswareLogs();
    public ResultSet getAllGlasswareInventories();
    public ResultSet getAllGlasswares();
    public ResultSet getAllChemicalWithdraws();
    public ResultSet getAllChemicalOrders();
    public ResultSet getAllChemicalLogs();
    public ResultSet getAllChemicalInventories();
    public ResultSet getAllChemicalContainers();
    public ResultSet getAllChemicals();
    
    public UsersEntity getUsers(int id);
    public ResultSet getSuppliers(int id);
    public ResultSet getRoomLocations(String room);
    public ResultSet getRooms(int id);
    public ResultSet getGlasswareOrders(int id);
    public ResultSet getGlasswareLogs(int id);
    public ResultSet getGlasswareInventories(int id);
    public ResultSet getGlasswares(int id);
    public ResultSet getChemicalWithdraws(int id);
    public ResultSet getChemicalOrders(int id);
    public ResultSet getChemicalLogs(int id);
    public ResultSet getChemicalInventories(int id);
    public ResultSet getChemicalContainers(int id);
    public ResultSet getChemicals(int id);
    
    public int getRoomLocationID(String room_location);
    public int getSupplierID(String supplier);
    public int getChemicalInventoryID(double quantity, int size, String unit, String date_purchased, String date_expired, 
            int chemical_id, int supplier_id, int room_location_id);
    
    public double getSumOfQuantities(ChemicalContainersEntity cce);
    
    public ResultSet searchUsers(String keywords);
    public ResultSet searchChemicals(String keywords);
    public ResultSet searchSuppliers(String keywords);
    public ResultSet searchChemicalInventories(String keywords);
    public ResultSet searchChemicalContainers(String keyword, int id);
    public ResultSet searchChemicalWithdraws(String keyword);
    public ResultSet searchGlasswareInventory(String keyword);
    public ResultSet searchGlasswares(String keyword);
    public ResultSet searchGlasswareWithdraws(String keywords);
    
    public ResultSet exportInventory(String room, String type1);
    public ResultSet exportGlasswareInventory();
}
