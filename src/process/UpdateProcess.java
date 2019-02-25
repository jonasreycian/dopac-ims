/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import entity.ChemicalContainersEntity;
import entity.ChemicalInventoriesEntity;
import entity.ChemicalsEntity;
import entity.GlasswareInventoriesEntity;
import entity.SuppliersEntity;
import entity.UsersEntity;
import interfaces.UpdateInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonsa
 */
public class UpdateProcess extends ConnectionProcess implements UpdateInterface{

    private PreparedStatement ps;
    public UpdateProcess() {}
    
    @Override
    public boolean updateUser(UsersEntity ue) {
        boolean updateStatus = true;
        String sql = "UPDATE `tbl_users` SET "
                + "`username`=?,"
                + "`userpass`=?,"
                + "`firstname`=?,"
                + "`lastname`=?,"
                + "`middlename`=?,"
                + "`name_pref`=?,"
                + "`designation`=?,"
                + "`email_address`=?, "
                + "`date_updated`= CURRENT_TIMESTAMP "
                + "WHERE id = ?";
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, ue.getUsername());
            ps.setString(2, ue.getUserpass());
            ps.setString(3, ue.getFirstname());
            ps.setString(4, ue.getLastname());
            ps.setString(5, ue.getMiddlename());
            ps.setString(6, ue.getName_pref());
            ps.setString(7, ue.getDesignation());
            ps.setString(8, ue.getEmail_address());
            ps.setInt(9, ue.getId());
            
            updateStatus = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("updateUser Status: " + updateStatus);
        return updateStatus;
    }

    @Override
    public boolean updateSupplier(SuppliersEntity se) {
        boolean status = true;
        String sql = "UPDATE `tbl_suppliers` SET "
                + "`name`=?,`date_updated`=CURRENT_TIMESTAMP "
                + "WHERE `id` = ?";
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, se.getName());
            ps.setInt(2, se.getId());
            
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean updateChemical(ChemicalsEntity ce) {
        boolean status = true;
        String sql = "UPDATE `tbl_chemicals` "
                + "SET `name`=?, `casrn`=?, `formula`=?, "
                + "`msds`=?, `type1`=?, `type2`=?, `date_updated`=CURRENT_TIMESTAMP "
                + "WHERE id = ?";
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, ce.getName());
            ps.setString(2, ce.getCasrn());
            ps.setString(3, ce.getFormula());
            ps.setString(4, ce.getMsds());
            ps.setString(5, ce.getType1());
            ps.setString(6, ce.getType2());
            ps.setInt(7, ce.getId());
            
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean updateChemicalContainer(ChemicalContainersEntity cc) {
        boolean status = true;
        String sql = "UPDATE `tbl_chemical_containers` SET `label`=?,`remarks`=?, quantity = ? WHERE `id` = ?";
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, cc.getLabel());
            ps.setString(2, cc.getRemarks());
            ps.setDouble(3, cc.getQuantity());
            ps.setInt(4, cc.getId());
            
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public boolean updateChemicalInventories(ChemicalInventoriesEntity cie) {
        String sql = "UPDATE `tbl_chemical_inventories` SET `quantity`=?, `date_updated`=CURRENT_TIMESTAMP WHERE id = ?";
        boolean status = true;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setDouble(1, cie.getQuantity());
            ps.setInt(2, cie.getId());
            
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("process.UpdateProcess.updateChemicalInventories() status: " + status);
        return status;
    }

    @Override
    public boolean updateGlasswareInventory(GlasswareInventoriesEntity gie) {
        String sql = "UPDATE `tbl_glassware_inventories` SET `quantity`= ? ,`date_updated`= CURRENT_TIMESTAMP WHERE `id` = ?";
        boolean status = true;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setInt(1, gie.getQuantity());
            ps.setInt(2, gie.getId());
            
            status = ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("process.UpdateProcess.updateGlasswareInventory() status: " + status);
        return status;
    }
    
}
