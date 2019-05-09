/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.DBOperations;
import entity.NaturalPerson;
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
import javafx.scene.layout.VBox;

/**Creates and sets insert Person view.
 *
 * @author filip
 */
public abstract class InsertPerson {

    /**Initializes elements and sets the view.
     * 
     */
    public static void insertPerson() {

        VBox centerContainer = new VBox(15);
        centerContainer.setAlignment(Pos.CENTER);
        Label title = new Label("Insert a new person");
        TextField id = new TextField();
        TextField name = new TextField();
        TextField surname = new TextField();
        TextField email = new TextField();
        TextField phoneNumber = new TextField();
        TextField position = new TextField();
        TextField workplace = new TextField();
        Label report = new Label();

        id.setMaxWidth(400);
        name.setMaxWidth(400);
        surname.setMaxWidth(400);
        email.setMaxWidth(400);
        phoneNumber.setMaxWidth(400);
        position.setMaxWidth(400);
        workplace.setMaxWidth(400);

        id.setPromptText("Enter ID");
        name.setPromptText("Enter Name");
        surname.setPromptText("Enter Surname");
        email.setPromptText("Enter Email");
        phoneNumber.setPromptText("Enter Phone Number");
        position.setPromptText("Enter Position");
        workplace.setPromptText("Enter Workplace");

        Button btnSubmit = new Button("Submit");
        centerContainer.getChildren().addAll(title, id, name, surname, email, phoneNumber, position, workplace,
                btnSubmit, report);
        

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                NaturalPerson np1 = new NaturalPerson(Integer.parseInt(id.getText()), name.getText(), surname.getText(),
                        email.getText(), phoneNumber.getText(), position.getText(), workplace.getText());

                try {
                    DBOperations.writeToDatabase(np1.getClassName(),
                            np1.getClassAttributes(), np1.getAttributeValues());
                } catch (SQLException ex) {
                    Logger.getLogger(EventIS.class.getName()).log(Level.SEVERE, null, ex);
                }
                id.clear();
                name.clear();
                surname.clear();
                email.clear();
                phoneNumber.clear();
                position.clear();
                workplace.clear();

                report.setText("Insert Successful!");
            }
        });
        
        root.setCenter(null);
        root.setCenter(centerContainer);
    }
}
