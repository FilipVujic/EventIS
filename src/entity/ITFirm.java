/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**Represents an IT Firm.
 *
 * @author filip
 */
public class ITFirm extends Firm {
    
    protected String supportedTechnologies;
    protected int size;
    
    /**Main ITFirm object constructor.
     * 
     * @param id ITFirm id.
     * @param name ITFirm name.
     * @param address ITFirm address.
     * @param phoneNumber ITFirm phone number.
     * @param email ITFirm email.
     * @param website ITFirm website.
     * @param yearsPartnered Years in which they were partners.
     * @param pin ITFirm pin.
     * @param bankAccountNo ITFirm bank account number.
     * @param supportedTechnologies ITFirm supported technologies.
     * @param size ITFirm size.
     */
    public ITFirm(int id, String name, String address, String phoneNumber, String email, String website, String yearsPartnered, 
            String pin, String bankAccountNo, String supportedTechnologies, int size) {
        
        super(id, name, address, phoneNumber, email, website, yearsPartnered, pin, bankAccountNo);
        this.supportedTechnologies = supportedTechnologies;
        
        if (size < 0) {
            size = size * (-1);
        }
        this.size = size;
        this.type = "IT Firm";
    }

    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        
        return super.toString() + 
                "Supported Technologies: " + supportedTechnologies + "\n" + 
                "Size: " + size;
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes() {
        
        String classAttributes = Firm.getClassAttributes() + ", SUPPORTED_TECHNOLOGIES, SIZE";

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
        attributeValues.add(this.supportedTechnologies);
        attributeValues.add(this.size);

        System.out.println(attributeValues.toString());
        return attributeValues;
    }

    public String getSupportedTechnologies() {
        return supportedTechnologies;
    }

    public void setSupportedTechnologies(String supportedTechnologies) {
        this.supportedTechnologies = supportedTechnologies;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}
