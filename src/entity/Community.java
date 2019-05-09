/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**Represents a Community.
 *
 * @author filip
 */
public class Community extends Organisation {
    
    String mainExpertise;
    
    /**Main Community object constructor.
     * 
     * @param id Community id.
     * @param name Community name.
     * @param address Community address.
     * @param phoneNumber Community phone number.
     * @param email Community email.
     * @param website Community website.
     * @param yearsPartnered Years in which they were partners.
     * @param mainExpertise Community main expertise.
     */
    public Community(int id, String name, String address, String phoneNumber, String email, String website, String yearsPartnered,
            String mainExpertise) {
        super(id, name, address, phoneNumber, email, website, yearsPartnered);
        this.mainExpertise = mainExpertise;
        this.type = "Community";
    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        return  super.toString() +
                "Main Expertise: " + mainExpertise + "\n";
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes() {
        String classAttributes = Organisation.getClassAttributes() + ", MAIN_EXPERTISE";
        return classAttributes;
    }

    /**Returns values of object attributes.
     * 
     * @return Returns all attribute values as a list.
     */
    @Override
    public LinkedList getAttributeValues() { 
        
        LinkedList attributeValues = new LinkedList();
        attributeValues.addAll(super.getAttributeValues());
        attributeValues.add(this.mainExpertise);
        
        return attributeValues;
    }

    public String getMainExpertise() {
        return mainExpertise;
    }

    public void setMainExpertise(String mainExpertise) {
        this.mainExpertise = mainExpertise;
    }
    
    
}
