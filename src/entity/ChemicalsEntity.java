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
public class ChemicalsEntity {
    private int id;
    private String name;
    private String casrn;
    private String formula;
    private String msds;
    private String type1;
    private String type2;
    private Timestamp date_created;
    private Timestamp date_updated;

    private final SelectProcess selectProcess = new SelectProcess();
    private final ResultSet resultSet;
    
    public ChemicalsEntity(int id) {
        this.id = id;
        
        resultSet = selectProcess.getAllChemicals();
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == this.id){
                    this.name = resultSet.getString("name");
                    this.casrn = resultSet.getString("casrn");
                    this.formula = resultSet.getString("formula");
                    this.msds = resultSet.getString("msds");
                    this.type1 = resultSet.getString("type1");
                    this.type2 = resultSet.getString("type1");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChemicalsEntity.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the casrn
     */
    public String getCasrn() {
        return casrn;
    }

    /**
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * @return the msds
     */
    public String getMsds() {
        return msds;
    }

    /**
     * @return the type1
     */
    public String getType1() {
        return type1;
    }

    /**
     * @return the type2
     */
    public String getType2() {
        return type2;
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

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param casrn the casrn to set
     */
    public void setCasrn(String casrn) {
        this.casrn = casrn;
    }

    /**
     * @param formula the formula to set
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * @param msds the msds to set
     */
    public void setMsds(String msds) {
        this.msds = msds;
    }

    /**
     * @param type1 the type1 to set
     */
    public void setType1(String type1) {
        this.type1 = type1;
    }

    /**
     * @param type2 the type2 to set
     */
    public void setType2(String type2) {
        this.type2 = type2;
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
