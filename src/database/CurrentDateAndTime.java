/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



/**Contains methods to obtain current date and time from the Internet.
 *
 * @author filip
 */
public abstract class CurrentDateAndTime {
    
    /**Gets current time.
     * 
     * @return Returns current time as a String.
     * @throws IOException Throws IOException.
     */
    public static String getCurrentTime() throws IOException {
        
        try {
            String url = "https://www.timeanddate.com/worldclock/serbia/belgrade";
            Document doc = (Document) Jsoup.connect(url).get();
            String currentTime = doc.getElementById("ct").text();
        
        return currentTime;
        
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        return null;
    }
    
    /**Gets current date.
     * 
     * @return Returns current date as a String.
     * @throws IOException Throws IOException.
     */
    public static String getCurrentDate() throws IOException {
        try {
            String url = "https://www.timeanddate.com/worldclock/serbia/belgrade";
            Document doc = (Document) Jsoup.connect(url).get();
            String currentDate = doc.getElementById("ctdat").text();
        
            return currentDate;
        
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 

        return null;
    }
}
