/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.DBInit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import static eventis.EventIS.root;
import java.io.IOException;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**Sets a view to connect to database.
 *
 * @author filip
 */
public abstract class ConnectToDB {
    
    /**Initializes elements and sets the view.
     * 
     */
    public static void setCredentialsInput() {
    VBox credentialsVBox = new VBox(25);
    Label description = new Label("Enter your credentials: ");
    TextField username = new TextField();
    TextField password = new TextField();
    Button btnConnect = new Button("Connect");
    Button btnCancel = new Button("Cancel");
    credentialsVBox.setAlignment(Pos.CENTER);

    username.setMaxWidth(150);
    password.setMaxWidth(150);
    btnConnect.setMaxWidth(100);
    btnCancel.setMaxWidth(100);
    
    username.setPromptText("Enter DB username");
    password.setPromptText("Enter DB password");
    
    btnConnect.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            try {
                DBInit.connectToDatabase(username.getText(), password.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ConnectToDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConnectToDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            root.setCenter(null);
            MainMenu.setMainMenu();
        }
    });
    
    btnCancel.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
            System.exit(0);
        }
    });
    
    root.requestFocus();
    credentialsVBox.getChildren().addAll(description, username, password, btnConnect, btnCancel);
    root.setCenter(credentialsVBox);
    }
    
}
