package eventis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import views.ConnectToDB;

/**Represents EventIS main class.
 *
 * @author filip
 * @version 1.0
 */
public class EventIS extends Application {
    
    public static BorderPane root;
    
    /**Overriden Application start method.
     * 
     * @param primaryStage Primary stage to set.
     */
    @Override
    public void start(Stage primaryStage) {
        
        
        root = new BorderPane();        
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add("css/style.css");
        root.backgroundProperty().set(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                
        ConnectToDB.setCredentialsInput();
        
        primaryStage.setTitle("EventIS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        launch(args);
    }
}
