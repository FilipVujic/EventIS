/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import database.DBOperations;
import java.sql.SQLException;
import java.util.LinkedList;

/**Represents an Organisation.
 *
 * @author filip
 */
public class Organisation {
    
    String type;
    int id;
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected String website;
    protected String yearsPartnered;

    /**Main Organisation object constructor.
     * 
     * @param id Organisation ID.
     * @param name Organisation name.
     * @param address Organisation address.
     * @param phoneNumber Organisation phone number.
     * @param email Organisation email.
     * @param website Organisation website.
     * @param yearsPartnered Years in which they were partners.
     */
    public Organisation (int id, String name, String address, String phoneNumber, String email, String website, 
            String yearsPartnered) {
        if (id < 0) {
            id = id*(-1);
        }
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.yearsPartnered = yearsPartnered;
        this.type = "Organisation";
    }
    
    /**Secondary Organisation object constructor for making an object from database data.
     * 
     * @param uniqueColumn Name of the column to search the row from.
     * @param uniqueValue Value to match the row from.
     * @throws SQLException Throws SQLException.
     */
    public Organisation(String uniqueColumn, String uniqueValue) throws SQLException {
    
        String[] columns = Organisation.getClassAttributes().split(", ");
        LinkedList value = new LinkedList();
        try {
            value = DBOperations.returnValuesOfColumns(Organisation.getClassName(),uniqueColumn, uniqueValue, columns);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
                this.type = value.get(0).toString();
                this.id = Integer.parseInt(value.get(1).toString());
                this.name = value.get(2).toString();
                this.address = value.get(3).toString(); 
                this.phoneNumber = value.get(4).toString(); 
                this.email = value.get(5).toString(); 
                this.website = value.get(6).toString(); 
                this.yearsPartnered  = value.get(7).toString();
                

    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Type: " + type + "\n" +
                "Name: " +  name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Website: " + website + "\n" +
                "Years Partnered: " + yearsPartnered + "\n";
    }

    /**Returns the name of the corresponding table name.
     * 
     * @return Returns table name as a String.
     */
    public static String getClassName() {
        String className = "organisation";
        return className;
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes() {
        String classAttributes = "TYPE, ID, NAME, ADDRESS, PHONE_NUMBER, EMAIL, WEBSITE, YEARS_PARTNERED";
        return classAttributes;
    }

    /**Returns values of object attributes.
     * 
     * @return Returns all attribute values as a list.
     */
    public LinkedList getAttributeValues() { 
        
        LinkedList attributeValues = new LinkedList();
        attributeValues.add(type);
        attributeValues.add(Integer.toString(this.id));
        attributeValues.add(this.name);
        attributeValues.add(this.address);
        attributeValues.add(this.phoneNumber);
        attributeValues.add(this.email);
        attributeValues.add(this.website);
        attributeValues.add(this.yearsPartnered);
        
        return attributeValues;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYearsPartnered() {
        return yearsPartnered;
    }

    public void setYearsPartnered(String yearsPartnered) {
        this.yearsPartnered = yearsPartnered;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
