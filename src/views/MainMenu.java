/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import static eventis.EventIS.root;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**Creates and sets Main Menu.
 *
 * @author filip
 */
public abstract class MainMenu {
    
    /**Initializes elements and sets the view.
     * 
     */
    public static void setMainMenu() {
    
        HBox mainMenu = new HBox(20);
        Button btnInsertNew = new Button("Insert New");
        Button btnSearch = new Button("Search");
        Button btnExit = new Button("Exit");
        btnInsertNew.setPrefWidth(100);
        btnSearch.setPrefWidth(100);
        btnExit.setPrefWidth(100);
        Label reports = new Label();
        
        mainMenu.getChildren().addAll(btnInsertNew, btnSearch, btnExit);

        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setPadding(new Insets(20, 0, 0, 0));
        
        btnInsertNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                InsertNew.insertNew();
            }
        });
        
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    
                SearchItem.setSearchItem();
            }
        });
        
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        
        root.setTop(null);
        root.setBottom(null);
        root.setBottom(reports);
        root.setTop(mainMenu);
    }
}
