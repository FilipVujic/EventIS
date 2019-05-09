/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**Exception for when the value entered is null.
 *
 * @author filip
 */
public class ValueNotAllowedException extends Exception {

    /**Main ValueIsNullException object constructor.
     * 
     * @param message Message to be displayed.
     */
    public ValueNotAllowedException(String message) {
        super(message);
    }
    
    
}
