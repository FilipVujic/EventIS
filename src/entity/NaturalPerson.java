/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import database.DBOperations;
import java.sql.SQLException;
import java.util.LinkedList;

/**Represents a Person.
 *
 * @author filip
 */
public class NaturalPerson {
    
    protected int id;
    protected String name;
    protected String surname;
    protected String email;
    protected String phoneNumber;
    protected String position;
    protected String workplace;

    /**Main NaturalPerson object constructor.
     * 
     * @param id NaturalPerson id.
     * @param name NaturalPerson name.
     * @param surname NaturalPerson surname.
     * @param email NaturalPerson email.
     * @param phoneNumber NaturalPerson phone number.
     * @param position NaturalPerson position.
     * @param workplace NaturalPerson workplace.
     */
    public NaturalPerson(int id, String name, String surname, String email, String phoneNumber, String position, 
            String workplace) {
        
        if (id < 0) {
            id = id*(-1);
        }
                
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.workplace = workplace;
    }

    /**Secondary NaturalPerson object constructor for making an object from database data.
     * 
     * @param uniqueColumn Name of the column to search the row from.
     * @param uniqueValue Value to match the row from.
     * @throws SQLException Throws SQLException.
     */
    public NaturalPerson(String uniqueColumn, String uniqueValue) throws SQLException {
    
        String[] columns = NaturalPerson.getClassAttributes().split(", ");
        LinkedList value = new LinkedList();
        try {
            value = DBOperations.returnValuesOfColumns(NaturalPerson.getClassName(),uniqueColumn, uniqueValue, columns);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
                this.id = Integer.parseInt(value.get(0).toString());
                this.name = value.get(1).toString();
                this.surname = value.get(2).toString(); 
                this.email = value.get(3).toString(); 
                this.phoneNumber = value.get(4).toString(); 
                this.position = value.get(5).toString(); 
                this.workplace  = value.get(6).toString();

    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Position: " + position + "\n" +
                "Workplace: " + workplace + "\n";
    }

    /**Returns the name of the corresponding table name.
     * 
     * @return Returns table name as a String.
     */
    public static String getClassName(){
        String className = "naturalperson";
        return className;
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes() {
        String classAttributes = "ID, NAME, SURNAME, EMAIL, PHONE_NUMBER, POSITION, WORKPLACE";
        return classAttributes;
    }

    /**Returns values of object attributes.
     * 
     * @return Returns all attribute values as a list.
     */
    public LinkedList getAttributeValues() { 
        
        LinkedList attributeValues = new LinkedList();
        attributeValues = new LinkedList();
        attributeValues.add(Integer.toString(this.id));
        attributeValues.add(this.name);
        attributeValues.add(this.surname);
        attributeValues.add(this.email);
        attributeValues.add(this.phoneNumber);
        attributeValues.add(this.position);
        attributeValues.add(this.workplace);
        
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    
    
}
