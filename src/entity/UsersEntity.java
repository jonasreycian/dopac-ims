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
public class UsersEntity {
    private int id;
    private String username;
    private String userpass;
    private String firstname;
    private String lastname;
    private String middlename;
    private String name_pref;
    private String designation;
    private String email_address;
    private Timestamp date_created;
    private Timestamp date_updated;
    
    private String fullname;

    private final SelectProcess selectProcess;
    private final ResultSet resultSet;

    public UsersEntity() {
        this.selectProcess = null;
        this.resultSet = null;
    }
    
    public UsersEntity(int id) {
        this.id = id;
        
        selectProcess = new SelectProcess();
        resultSet = selectProcess.getAllUsers();
        
        try {
            while(resultSet.next()){
                if(resultSet.getInt("id") == id){
                    this.username = resultSet.getString("username");
                    this.userpass = resultSet.getString("userpass");
                    this.firstname = resultSet.getString("firstname");
                    this.lastname = resultSet.getString("lastname");
                    this.middlename = resultSet.getString("middlename");
                    this.name_pref = resultSet.getString("name_pref");
                    this.designation = resultSet.getString("designation");
                    this.email_address = resultSet.getString("email_address");
                    this.date_created = resultSet.getTimestamp("date_created");
                    this.date_updated = resultSet.getTimestamp("date_updated");
                }                
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the userpass
     */
    public String getUserpass() {
        return userpass;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @return the name_pref
     */
    public String getName_pref() {
        return name_pref;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @return the email_address
     */
    public String getEmail_address() {
        return email_address;
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
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param userpass the userpass to set
     */
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @param name_pref the name_pref to set
     */
    public void setName_pref(String name_pref) {
        this.name_pref = name_pref;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @param email_address the email_address to set
     */
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
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

    /**
     * @return the fullname
     */
    public String getFullname() {
        return getFirstname() + " " + getMiddlename() + " " + getLastname();
    }

    
}
