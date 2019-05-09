/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;



/**Abstract class that adds two new attributes for all subclass entities.
 *
 * @author filip
 */
public abstract class Firm extends Organisation {
    
    protected String pin;
    protected String bankAccountNo;

    /**Main Firm object constructor.
     * 
     * @param id Firm ID.
     * @param name Firm name.
     * @param address Firm address.
     * @param phoneNumber Firm phone number.
     * @param email Firm email.
     * @param website Firm website.
     * @param yearsPartnered Years.
     * @param pin Firm pin. Years in which they were partners.
     * @param bankAccountNo Firm bank account number. 
     */
    public Firm(int id, String name, String address, String phoneNumber, String email, String website, String yearsPartnered, 
            String pin, String bankAccountNo) {
        super(id, name, address, phoneNumber, email, website, yearsPartnered);
        this.pin = pin;
        this.bankAccountNo = bankAccountNo;
    }
    
    /**Overriden toString method.
     * 
     * @return Returns String with all attributes and their values.
     */
    @Override
    public String toString() {
        
        return super.toString() + 
                "PIN: " + pin + "\n" + 
                "Bank Account Number: " + bankAccountNo;
    }
    
    /**Returns database column names for this class.
     * 
     * @return Returns column names of this class as a String.
     */
    public static String getClassAttributes(){
        
        String classAttributes = Organisation.getClassAttributes() + ", PIN, BANK_ACCOUNT_NUMBER";
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
        attributeValues.add(this.pin);
        attributeValues.add(this.bankAccountNo);

        return attributeValues;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }
    
    
}
