/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import entity.ChemicalContainersEntity;
import interfaces.SelectInterface;
import entity.UsersEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonsa
 */
public class SelectProcess extends ConnectionProcess implements SelectInterface{

    public SelectProcess() {}
    
    @Override
    public ResultSet getAllUsers(){
        String sql = "SELECT * FROM `tbl_users`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllSuppliers() {
        String sql = "SELECT * FROM `tbl_suppliers`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllRoomLocations() {
        String sql = "SELECT * FROM `tbl_room_locations`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllRooms() {
        String sql = "SELECT * FROM `tbl_rooms`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllGlasswareOrders() {
        String sql = "SELECT * FROM `tbl_glassware_orders`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllGlasswareLogs() {
        String sql = "SELECT * FROM `tbl_glassware_logs`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllGlasswareInventories() {
        String sql = "SELECT * FROM `tbl_glassware_inventories`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllGlasswares() {
        String sql = "SELECT * FROM `tbl_glasswares`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicalWithdraws() {
        String sql = "SELECT * FROM `tbl_chemical_withdraws`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicalOrders() {
        String sql = "SELECT * FROM `tbl_chemical_orders`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicalLogs() {
        String sql = "SELECT * FROM `tbl_chemical_logs`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicalInventories() {
        String sql = "SELECT * FROM `tbl_chemical_inventories`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicalContainers() {
        String sql = "SELECT * FROM `tbl_chemical_containers`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getAllChemicals() {
        String sql = "SELECT * FROM `tbl_chemicals`";
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public UsersEntity getUsers(int id) {
        UsersEntity ue = new UsersEntity();
        ResultSet rs = getAllUsers();
        
        ue.setId(id);
        
        try {
            while(rs.next()){
                if(rs.getInt("id") == id){
                    ue.setUsername(rs.getString("username"));
                    ue.setUserpass(rs.getString("userpass"));
                    ue.setFirstname(rs.getString("firstname"));
                    ue.setLastname(rs.getString("lastname"));
                    ue.setMiddlename(rs.getString("middlename"));
                    ue.setName_pref(rs.getString("name_pref"));
                    ue.setDesignation(rs.getString("designation"));
                    ue.setEmail_address(rs.getString("email_address"));
                    ue.setDate_created(rs.getTimestamp("date_created"));
                    ue.setDate_updated(rs.getTimestamp("date_updated"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ue;
    }

    @Override
    public ResultSet getSuppliers(int id) {
        String sql = "SELECT * FROM `tbl_suppliers` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getRoomLocations(String room) {
        String sql = "SELECT a.* FROM `tbl_room_locations` a, tbl_rooms b WHERE b.name = ? AND a.room_id = b.id";
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, room);
            
            return ps.executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getRooms(int id) {
        String sql = "SELECT * FROM `tbl_rooms` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getGlasswareOrders(int id) {
        String sql = "SELECT * FROM `tbl_glassware_orders` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getGlasswareLogs(int id) {
        String sql = "SELECT * FROM `tbl_glassware_logs` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getGlasswareInventories(int id) {
        String sql = "SELECT * FROM `tbl_glassware_inventories` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getGlasswares(int id) {
        String sql = "SELECT * FROM `tbl_glasswares` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicalWithdraws(int id) {
        String sql = "SELECT * FROM `tbl_chemical_withdraws` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicalOrders(int id) {
        String sql = "SELECT * FROM `tbl_chemical_orders` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicalLogs(int id) {
        String sql = "SELECT * FROM `tbl_chemical_logs` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicalInventories(int id) {
        String sql = "SELECT * FROM `tbl_chemical_inventories` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicalContainers(int id) {
        String sql = "SELECT * FROM `tbl_chemical_containers` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet getChemicals(int id) {
        String sql = "SELECT * FROM `tbl_chemicals` WHERE id = " + id;
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (Exception e) {}
        return null;
    }

    @Override
    public ResultSet searchUsers(String keywords) {
        String sql = "SELECT name_pref as Title, CONCAT(`lastname`,', ', `firstname`, ' ' ,`middlename`) AS 'Name', "
                + "`Designation`, `email_address` AS 'Email Address' FROM `tbl_users` WHERE lastname LIKE ?";
        
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, keywords +"%");
            
           return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchChemicals(String keywords) {
        String sql = "SELECT casrn 'CAS-RN', name 'Chemicals' FROM tbl_chemicals WHERE name LIKE ?";
        
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, keywords +"%");
            
           return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchSuppliers(String keywords) {
        String sql = "SELECT `ID`, `name` as 'Suppliers' FROM `tbl_suppliers` WHERE name LIKE ?";
        
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, keywords +"%");
            
           return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public int getRoomLocationID(String room_location) {
        ResultSet resultSet = getAllRoomLocations();
        
        try {
            while(resultSet.next()){
                if(room_location.equals(resultSet.getString("name")))
                    return resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
    }
    
    @Override
    public int getSupplierID(String supplier){
        ResultSet resultSet = getAllSuppliers();
        
        try {
            while(resultSet.next()){
                if(supplier.equals(resultSet.getString("name")))
                    return resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 70;
    }

    @Override
    public int getChemicalInventoryID(double quantity, int size, String unit, String date_purchased, String date_expired, 
            int chemical_id, int supplier_id, int room_location_id) {
        ResultSet resultSet = getAllChemicalInventories();
        
        try {
            while(resultSet.next()){
                if(quantity == resultSet.getDouble("quantity") && size == resultSet.getInt("size") && unit.equals(resultSet.getString("unit")) 
                        && date_purchased.equals(resultSet.getString("date_purchased")) && date_expired.equals(resultSet.getString("date_expired"))
                        && chemical_id == resultSet.getInt("chemical_id") && supplier_id == resultSet.getInt("supplier_id") 
                                && room_location_id == resultSet.getInt("room_location_id")){
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public ResultSet searchChemicalInventories(String keywords) {
        String sql = "SELECT a.ID, b.casrn 'CAS-RN', b.name 'Containers', a.Quantity, CONCAT(a.Size,' ', a.unit) 'Size', c.name 'Supplier', "
                + "CONCAT(e.name,'->',d.name) 'Location', a.date_purchased 'Date purchased', a.date_expired 'Date expired' "
                + "FROM tbl_chemical_inventories a, tbl_chemicals b, tbl_suppliers c, tbl_room_locations d, tbl_rooms e "
                + "WHERE a.chemical_id = b.id AND a.supplier_id = c.id AND a.room_location_id = d.id AND d.room_id = e.id AND b.name LIKE ? AND a.quantity > 0 "
                + "ORDER BY b.name ASC";
        
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, keywords +"%");
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet searchChemicalContainers(String keywords, int id) {
        String sql = "SELECT a.ID, a.Label, a.Quantity, CONCAT(b.Size, ' ', b.unit) AS Size "
                + "FROM tbl_chemical_containers a, tbl_chemical_inventories b "
                + "WHERE label LIKE ? AND chemical_inventory_id = ? AND a.chemical_inventory_id = b.id "
                + "AND a.quantity > 0";
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setString(1, keywords +"%");
            ps.setInt(2, id);
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public double getSumOfQuantities(ChemicalContainersEntity cce) {
        String sql = "SELECT sum(quantity) FROM tbl_chemical_containers WHERE chemical_inventory_id = ?";
        
        try {
            PreparedStatement ps = open().prepareStatement(sql);
            ps.setInt(1, cce.getChemical_inventory_id());
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                return resultSet.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }

    @Override
    public ResultSet exportInventory(String room, String type1) {
        String sql = "SELECT b.casrn 'CAS-RN', b.name 'Container', e.name 'Supplier', a.Quantity, CONCAT(a.size,' ', a.unit) 'Size', a.date_purchased, a.date_expired, c.name 'Location', b.type2 "
                + "FROM tbl_chemical_inventories a "
                + "INNER JOIN tbl_chemicals b ON b.id = a.chemical_id "
                + "INNER JOIN tbl_room_locations c ON c.id = a.room_location_id "
                + "INNER JOIN tbl_rooms d ON d.id = c.room_id "
                + "INNER JOIN tbl_suppliers e ON e.id = a.supplier_id "
                + "WHERE d.name = ? AND b.type1 = ? AND a.quantity > 0 "
                + "ORDER BY b.name";
        
        PreparedStatement ps;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, room);
            ps.setString(2, type1);
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchChemicalWithdraws(String keyword) {
        String sql = "SELECT a.ID, b.Label, a.Quantity, CONCAT(a.size, ' ', a.unit) 'Size', a.date_created 'Date withdraw', c.username 'User' "
                + "FROM tbl_chemical_withdraws a, tbl_chemical_containers b, tbl_users c "
                + "WHERE a.chemical_container_id = b.id AND a.user_id = c.id AND (b.label LIKE ? OR c.username LIKE ?) "
                + "ORDER BY a.date_created DESC";
        
        PreparedStatement ps;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, keyword +"%");
            ps.setString(2, keyword + "%");
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchGlasswareInventory(String keyword) {
        String sql = "SELECT a.ID, b.name 'Glassware', a.Quantity, a.Size, a.date_updated 'Date updated' "
                + "FROM tbl_glassware_inventories a, tbl_glasswares b "
                + "WHERE b.id = a.glassware_id AND b.name LIKE ? AND a.quantity > 0";
        
        PreparedStatement ps;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, keyword +"%");
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchGlasswares(String keyword) {
        String sql = "SELECT ID, name as 'Glassware' FROM tbl_glasswares WHERE name LIKE ?";
        
        PreparedStatement ps;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, keyword +"%");
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet exportGlasswareInventory() {
        String sql = "SELECT b.name 'Glassware', SUM(a.Quantity), a.Size "
                + "FROM tbl_glassware_inventories a, tbl_glasswares b "
                + "WHERE b.id = a.glassware_id AND a.quantity > 0 "
                + "GROUP BY b.name, a.size "
                + "ORDER BY b.name, a.size ASC";
        
        try {
            return open().prepareStatement(sql).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ResultSet searchGlasswareWithdraws(String keyword) {
        String sql = "SELECT a.ID, c.name 'Glassware', a.Quantity, b.Size, a.Remarks, a.date_created 'Date withdraw', d.username 'User' "
                + "FROM tbl_glassware_withdraw a, tbl_glassware_inventories b, tbl_glasswares c, tbl_users d "
                + "WHERE a.glassware_inventory_id = b.id AND b.glassware_id = c.id AND a.user_id = d.id AND (c.name LIKE ? OR d.username LIKE ?) "
                + "ORDER BY a.date_created DESC";
        
        PreparedStatement ps;
        
        try {
            ps = open().prepareStatement(sql);
            ps.setString(1, keyword +"%");
            ps.setString(2, keyword + "%");
            
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SelectProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
