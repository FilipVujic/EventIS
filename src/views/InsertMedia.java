/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.DBOperations;
import entity.Media;
import eventis.EventIS;
import static eventis.EventIS.root;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

/**Creates and sets insert Media view.
 *
 * @author filip
 */
public abstract class InsertMedia {
    
    /**Initializes elements and sets the view.
     * 
     */
    public static void insertMedia() {
    
        VBox centerContainer = new VBox(15);
                        centerContainer.setAlignment(Pos.CENTER);
                        Label title = new Label("Insert new media");
                        TextField id = new TextField();
                        TextField name = new TextField();
                        TextField address = new TextField();
                        TextField phoneNumber = new TextField();
                        TextField email = new TextField();
                        TextField website = new TextField();
                        TextField yearsPartenered = new TextField();
                        ToggleButton isForeign = new ToggleButton("Is Foreign?");
                        isForeign.setAlignment(Pos.CENTER_LEFT);

                        Label report = new Label();
                        
                        id.setMaxWidth(400);
                        name.setMaxWidth(400);
                        address.setMaxWidth(400);
                        phoneNumber.setMaxWidth(400);
                        email.setMaxWidth(400);
                        website.setMaxWidth(400);
                        yearsPartenered.setMaxWidth(400);
                        isForeign.setMaxWidth(100);
              
                        id.setPromptText("Enter ID");
                        name.setPromptText("Enter Name");
                        address.setPromptText("Enter Address");
                        phoneNumber.setPromptText("Enter Phone Number");
                        email.setPromptText("Enter Email");
                        website.setPromptText("Enter Website");
                        yearsPartenered.setPromptText("Enter Years Partnered");

                        
                        Button btnSubmit = new Button("Submit");
                        centerContainer.getChildren().addAll(title, id, name, address, phoneNumber, email, website, yearsPartenered, 
                                isForeign, btnSubmit, report);

                        
                        
                        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Media med1 = new Media(Integer.parseInt(id.getText()), name.getText(), address.getText(), 
                                        phoneNumber.getText(), email.getText(), website.getText(), yearsPartenered.getText(),
                                        isForeign.isSelected());

                                try {
                                    DBOperations.writeToDatabase(med1.getClassName(),
                                            med1.getClassAttributes(), med1.getAttributeValues());
                                } catch (SQLException ex) {
                                    Logger.getLogger(EventIS.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                id.clear();
                                name.clear();
                                address.clear();
                                phoneNumber.clear();
                                email.clear();
                                website.clear();
                                yearsPartenered.clear();
                                
                                report.setText("Insert Successful!");
                            }
                        });
                        
                        root.setCenter(null);
                        root.setCenter(centerContainer);
    }
}
