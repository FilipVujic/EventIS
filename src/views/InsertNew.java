/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import static eventis.EventIS.root;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**Creates and sets insert new view.
 *
 * @author filip
 */
public abstract class InsertNew {
    
    /**Initializes elements and sets the view.
     * 
     */
    public static void insertNew() {
    
        VBox searchAllNodes = new VBox(30);
                searchAllNodes.setAlignment(Pos.CENTER);
                Label addNewPerson = new Label("Add new Person:");
                Label addNewOrganisation = new Label("Add new Organisation:");
                
                HBox addPerson = new HBox(10);
                HBox addOrganisation = new HBox(10);
                HBox addOrganisation2 = new HBox(10);

                addPerson.setAlignment(Pos.CENTER);
                addOrganisation.setAlignment(Pos.CENTER);
                addOrganisation2.setAlignment(Pos.CENTER);

                Button btnAddPerson = new Button("Person");
                Button btnAddOrganisation = new Button("Organisation");
                Button btnAddITFirm = new Button("IT Firm");
                Button btnAddVenue = new Button("Venue");
                
                Button btnAddMedia = new Button("Media");
                Button btnAddCommunity = new Button("Community");

                btnAddPerson.setPrefWidth(150);
                btnAddOrganisation.setPrefWidth(150);
                btnAddITFirm.setPrefWidth(150);
                btnAddVenue.setPrefWidth(150);
                btnAddMedia.setPrefWidth(150);
                btnAddCommunity.setPrefWidth(150);

                addPerson.getChildren().addAll(btnAddPerson);
                addOrganisation.getChildren().addAll(btnAddOrganisation, btnAddITFirm, btnAddVenue);
                addOrganisation2.getChildren().addAll(btnAddMedia, btnAddCommunity);
                
                btnAddPerson.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertPerson.insertPerson();
                    }
                });
                
                btnAddOrganisation.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertOrganisation.insertOrganisation();
                    }
                });

                btnAddITFirm.setOnAction(new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertITFirm.insertFirm();
                    }
                });
                   
                btnAddVenue.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertVenue.insertVenue();
                    }
                });
                
                btnAddMedia.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertMedia.insertMedia();
                    }
                });
                
                btnAddCommunity.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        
                        InsertCommunity.insertCommunity();
                    }
                });

                searchAllNodes.getChildren().addAll(addNewPerson, addPerson, addNewOrganisation, addOrganisation, 
                        addOrganisation2);
                
                root.setCenter(null);
                root.setCenter(searchAllNodes);
                
    }
}
