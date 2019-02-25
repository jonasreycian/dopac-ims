/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author jonsa
 */
public interface InsertInterface {
    boolean insertUser(String username, String userpass, String firstname, String middlename, String lastname, String name_title, 
            String designation, String email_address);
    boolean insertSupplier(String supplier);
    boolean insertChemical(String chemicalName, String casrn, String formula, String msds, String type1, String type2);
    boolean insertChemicalInventory(double quantity, int size, String unit, String date_purchased, String date_expired, int chemical_id, int supplier_id, int room_location_id);
    boolean insertChemicalContainer(double quantity, String label, String remarks, int chemical_inventory_id);
    boolean insertChemicalWithdraw(double quantity, int size, String unit, String remarks, int chemical_container_id, int user_id);
    boolean insertGlasswareInventory(int glassware_id, String size, int quantity, String date_purchased);
    boolean insertGlassware(String glassware);
    boolean insertGlasswareWithdraw(int quantity, String remarks, int glassware_inventory_id, int user_id);
}
