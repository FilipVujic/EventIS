/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**Represents Media.
 *
 * @author filip
 */
public class Media extends Organisation {
    
    boolean isForeign;
    
    /**Main Media object constructor.
     * 
     * @param id Media id.
     * @param name Media name.
     * @param address Media address.
     * @param phoneNumber Media phone number.
     * @param email Media email.
     * @param website Media website.
     * @param yearsPartnered Years in which they were partners.
     * @param isForeign If Media is foreign.
     */
    public Media(int id, String name, String address, String phoneNumber, String email, String website, String yearsPartnered,
            boolean isForeign) {
        super(id, name, address, phoneNumber, email, website, yearsPartnered);
        this.isForeign = isForeign;
        this.type = "Media";
    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        return  super.toString() +
                "Is Foreign: " + isForeign + "\n";
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes() {
        String classAttributes = Organisation.getClassAttributes() + ", IS_FOREIGN";
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
        if (this.isForeign) {
            attributeValues.add(1);
        } else attributeValues.add(0);
        
        
        return attributeValues;
    }

    public boolean getMainExpertise() {
        return isForeign;
    }

    public void setMainExpertise(boolean mainExpertise) {
        this.isForeign = mainExpertise;
    }
}
