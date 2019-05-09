/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**Represents a Venue.
 *
 * @author filip
 */
public class Venue extends Firm {
    
    protected int numberOfRooms;
    protected int totalCapacity;
    
    /**Main Venue object constructor.
     * 
     * @param id Venue id.
     * @param name Venue name.
     * @param address Venue address.
     * @param phoneNumber Venue phone number.
     * @param email Venue email.
     * @param website Venue website.
     * @param yearsPartnered Years in which they were partners.
     * @param pin Venue pin.
     * @param bankAccountNo Venue bank account number.
     * @param numberOfRooms Venue number of rooms.
     * @param totalCapacity Venue total capacity.
     */
    public Venue(int id, String name, String address, String phoneNumber, String email, String website, String yearsPartnered, 
            String pin, String bankAccountNo, int numberOfRooms, int totalCapacity) {
        super(id, name, address, phoneNumber, email, website, yearsPartnered, pin, bankAccountNo);
        
        if (numberOfRooms < 0) {
            numberOfRooms = numberOfRooms * (-1);
        }
        if (totalCapacity < 0) {
            totalCapacity = totalCapacity * (-1);
        }
        this.numberOfRooms = numberOfRooms;
        this.totalCapacity = totalCapacity;
        this.type = "Venue";
    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        
        return super.toString() + 
                "Number of Rooms: " + numberOfRooms + "\n" + 
                "Total Capacity: " + totalCapacity;
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes(){
        
        String classAttributes = Firm.getClassAttributes() + ", NUMBER_OF_ROOMS, TOTAL_CAPACITY";
        return classAttributes;
    }
    
    /**Returns values of object attributes.
     * 
     * @return Returns all attribute values as a list.
     */
    @Override
    public LinkedList getAttributeValues() {
    
        LinkedList attributeValues = super.getAttributeValues();
        attributeValues.add(this.numberOfRooms);
        attributeValues.add(this.totalCapacity);

        return attributeValues;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
    
    
}
