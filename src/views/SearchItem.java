/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.NaturalPerson;
import entity.Organisation;
import entity.ValueNotAllowedException;
import static eventis.EventIS.root;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**Creates and sets search view.
 *
 * @author filip
 */
public abstract class SearchItem {

    /**Initializes elements and sets the view.
     * 
     */
    public static void setSearchItem() {

        Label errorLabel = new Label();
        errorLabel.setMinSize(300, 20);
        errorLabel.setWrapText(true);
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setTextAlignment(TextAlignment.CENTER);
        errorLabel.setFont(Font.font(18));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        HBox errorBox = new HBox(20);
        errorBox.setPadding(new Insets(0, 0, 20, 0));
        root.setBottom(errorBox);
        errorBox.setAlignment(Pos.CENTER);
        
        
        root.setCenter(null);
        
        VBox centralVBox = new VBox(20);

        TextField matchValue = new TextField();
        matchValue.setMaxWidth(100);
        
        Button btnSearch = new Button("Search");
        btnSearch.setPrefWidth(100);
        
        Label resultText = new Label();
        resultText.setTextAlignment(TextAlignment.JUSTIFY);
        resultText.setPrefSize(200, 200);
        
        ObservableList<String> optionsMain
                = FXCollections.observableArrayList(
                        "PERSON",
                        "ORGANISATION"
                );
        ComboBox comboBoxMain = new ComboBox(optionsMain);
        comboBoxMain.setPrefWidth(200);
        comboBoxMain.getStyleClass().add("center-aligned");
        
        comboBoxMain.setValue("Search for: ");
        centralVBox.setAlignment(Pos.TOP_CENTER);
        centralVBox.getChildren().add(comboBoxMain);
        

        ObservableList<String> optionsPerson
                = FXCollections.observableArrayList(
                        "ID",
                        "EMAIL"
                );
        ComboBox comboBoxPerson = new ComboBox(optionsPerson);
        comboBoxPerson.setValue("Search by: ");
        comboBoxPerson.setPrefWidth(100);
        comboBoxPerson.getStyleClass().add("center-aligned");
        
        ObservableList<String> optionsOrganisation
                = FXCollections.observableArrayList(
                        "ID",
                        "PIN"
                );
        ComboBox comboBoxOrganisation = new ComboBox(optionsOrganisation);
        comboBoxOrganisation.setValue("Search by: ");
        comboBoxOrganisation.setPrefWidth(100);
        comboBoxOrganisation.getStyleClass().add("center-aligned");

        
        VBox.setMargin(comboBoxMain, new Insets(30, 0, 50, 0));
        root.setCenter(centralVBox);
        
        comboBoxMain.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                
//START OF - If person
                if (comboBoxMain.getValue().toString().equals("PERSON")) {

                    centralVBox.getChildren().removeAll(comboBoxPerson, comboBoxOrganisation, matchValue, btnSearch, resultText);
                    centralVBox.getChildren().addAll(comboBoxPerson, matchValue, btnSearch, resultText);

                    comboBoxPerson.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            resultText.setText("");
                            errorBox.getChildren().remove(errorLabel);
                            if (comboBoxPerson.getValue().toString().equals("ID")) {
                                matchValue.setPromptText("Enter ID");
                            } else if (comboBoxPerson.getValue().toString().equals("EMAIL")) {
                                matchValue.setPromptText("Enter EMAIL");
                            }
                        }
                    });

                    btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            errorBox.getChildren().remove(errorLabel);
                            resultText.setText("");
                            if (matchValue.getText().equals(null) || matchValue.getText().equals("")){
                                try {
                                    errorBox.getChildren().add(errorLabel);
                                    errorLabel.setText("Unique value cannot be null or an empty String!");
                                    throw new ValueNotAllowedException("Unique value cannot be null or an empty String!");
                                            } catch (ValueNotAllowedException ex) {
                                    //Logger.getLogger(SearchItem.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println(ex.toString());
                                }
                            }
                            
                            try {
                                NaturalPerson np1 = new NaturalPerson(comboBoxPerson.getValue().toString(), matchValue.getText());
                                resultText.setText(null);
                                resultText.setText(np1.toString());
                            } catch (SQLException ex) {
                                //Logger.getLogger(SearchItem.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex.toString());
                            }
                            
                            
                        }
                    });                 
//END OF - If person

//START OF - If Organisation
                } else if (comboBoxMain.getValue().toString().equals("ORGANISATION")) {

                    centralVBox.getChildren().removeAll(comboBoxOrganisation, comboBoxPerson, matchValue, btnSearch, resultText);
                    centralVBox.getChildren().addAll(comboBoxOrganisation, matchValue, btnSearch, resultText);

                    comboBoxOrganisation.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            resultText.setText("");
                            errorBox.getChildren().remove(errorLabel);
                            if (comboBoxOrganisation.getValue().toString().equals("ID")) {
                                matchValue.setPromptText("Enter ID");
                            } else if (comboBoxOrganisation.getValue().toString().equals("PIN")) {
                                matchValue.setPromptText("Enter PIN");
                            }
                            
                        }
                    });

                    btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            resultText.setText("");
                            errorBox.getChildren().remove(errorLabel);
                            if (matchValue.getText().equals(null) || matchValue.getText().equals("")){
                                try {
                                    errorBox.getChildren().add(errorLabel);
                                    errorLabel.setText("Unique value cannot be null or an empty String!");
                                    throw new ValueNotAllowedException("Unique value cannot be null or an empty String!");
                                            } catch (ValueNotAllowedException ex) {
                                    //Logger.getLogger(SearchItem.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println(ex.toString());
                                }
                            }
                                                        
                            try {
                                Organisation org1 = new Organisation(comboBoxOrganisation.getValue().toString(), 
                                        matchValue.getText());
                                resultText.setText(null);
                                resultText.setText(org1.toString());
                            } catch (SQLException ex) {
                                //Logger.getLogger(SearchItem.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println(ex.toString());
                            }
                            
                        }
                    });
                }
//END OF - If Organisation
            }
        });

    }
}
