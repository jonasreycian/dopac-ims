/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import interfaces.InsertInterface;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonsa
 */
public class InsertProcess extends ConnectionProcess implements InsertInterface{

    private PreparedStatement ps;
    public InsertProcess() {}
    
    @Override
    public boolean insertUser(String username, String userpass, String firstname, String middlename, String lastname, String name_title, 
            String designation, String email_address) {
        
        boolean status = true;
        String sql = "INSERT INTO `tbl_users`(`username`, `userpass`, `firstname`, `lastname`, `middlename`, `name_pref`, `designation`, `email_address`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
                
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, userpass);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, middlename);
            ps.setString(6, name_title);
            ps.setString(7, designation);
            ps.setString(8, email_address);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("process.InsertProcess.insertUser(): " + status);
        return status;
    }

    @Override
    public boolean insertSupplier(String supplier) {
        boolean status = true;
        String sql = "INSERT INTO `tbl_suppliers`( `name`) VALUES (?)";
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, supplier);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean insertChemical(String chemicalName, String casrn, String formula, String msds, String type1, String type2) {
        boolean status = true;
        String sql = "INSERT INTO `tbl_chemicals`(`name`, `casrn`, `formula`, `msds`, `type1`, `type2`) VALUES (?,?,?,?,?,?)";
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, chemicalName);
            ps.setString(2, casrn);
            ps.setString(3, formula);
            ps.setString(4, msds);
            ps.setString(5, type1);
            ps.setString(6, type2);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean insertChemicalInventory(double quantity, int size, String unit, String date_purchased, String date_expired, int chemical_id, int supplier_id, int room_location_id) {
        String sql = "INSERT INTO `tbl_chemical_inventories` "
                + "( `quantity`, `size`, `unit`, `date_purchased`, `date_expired`, `chemical_id`, `supplier_id`, `room_location_id`) "
                + "VALUES (?,?,?,CAST(? AS DATE),CAST(? AS DATE),?,?,?)";
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setDouble(1, quantity);
            ps.setInt(2, size);
            ps.setString(3, unit);
            ps.setString(4, date_purchased);
            ps.setString(5, date_expired);
            ps.setInt(6, chemical_id);
            ps.setInt(7, supplier_id);
            ps.setInt(8, room_location_id);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean insertChemicalContainer(double quantity, String label, String remarks, int chemical_inventory_id) {
        String sql = "INSERT INTO `tbl_chemical_containers`(`quantity`, `label`, `remarks`, `chemical_inventory_id`) VALUES (?,?,?,?)";
        
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setDouble(1, quantity);
            ps.setString(2, label);
            ps.setString(3, remarks);
            ps.setInt(4, chemical_inventory_id);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean insertChemicalWithdraw(double quantity, int size, String unit, String remarks, int chemical_container_id, int user_id) {
        String sql = "INSERT INTO `tbl_chemical_withdraws`(`quantity`, `size`, `unit`, `remarks`, `chemical_container_id`, `user_id`) VALUES (?,?,?,?,?,?)";
        
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setDouble(1, quantity);
            ps.setInt(2, size);
            ps.setString(3, unit);
            ps.setString(4, remarks);
            ps.setInt(5, chemical_container_id);
            ps.setInt(6, user_id);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertChemicalWithdraw status: " + status);
        return status;
    }
    
    public static void main(String[] args) {
        new InsertProcess().insertChemicalWithdraw(1, 1, "mL", "", 4, 5);
    }

    @Override
    public boolean insertGlasswareInventory(int glassware_id, String size, int quantity, String date_purchased) {
        String sql = "INSERT INTO `tbl_glassware_inventories`(`size`, `quantity`, `glassware_id`, `date_purchased`) VALUES (?,?,?,CAST(? AS DATE));";
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setString(1, size);
            ps.setInt(2, quantity);
            ps.setInt(3, glassware_id);
            ps.setString(4, date_purchased);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertGlasswareInventory status: " + status);
        return status;
    }

    @Override
    public boolean insertGlassware(String glassware) {
        String sql = "INSERT INTO `tbl_glasswares`(name) VALUES (?);";
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setString(1, glassware);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertGlassware status: " + status);
        return status;
    }

    @Override
    public boolean insertGlasswareWithdraw(int quantity, String remarks, int glassware_inventory_id, int user_id) {
        String sql = "INSERT INTO `tbl_glassware_withdraw`(`quantity`, `remarks`, `glassware_inventory_id`, `user_id`) VALUES (?,?,?,?)";
        boolean status = true;
         try {
            ps = open().prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setString(2, remarks);
            ps.setInt(3, glassware_inventory_id);
            ps.setInt(4, user_id);
        
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertGlassware status: " + status);
        return status;
    }
}
