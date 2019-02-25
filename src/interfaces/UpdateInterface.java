/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.ChemicalContainersEntity;
import entity.ChemicalInventoriesEntity;
import entity.ChemicalsEntity;
import entity.GlasswareInventoriesEntity;
import entity.SuppliersEntity;
import entity.UsersEntity;

/**
 *
 * @author jonsa
 */
public interface UpdateInterface {
    boolean updateUser(UsersEntity ue);
    boolean updateSupplier(SuppliersEntity ue);
    boolean updateChemical(ChemicalsEntity ce);
    boolean updateChemicalContainer(ChemicalContainersEntity cc);
    boolean updateChemicalInventories(ChemicalInventoriesEntity cie);
    
    boolean updateGlasswareInventory(GlasswareInventoriesEntity gie);
}
