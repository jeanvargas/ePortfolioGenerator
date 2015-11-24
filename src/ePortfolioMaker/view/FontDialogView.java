/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class FontDialogView {
    ePortfolioMakerView ui;
    Stage stage;
    Scene scene;
    FlowPane optionPane;
    VBox vBox;
    ComboBox family, style, size;
    ObservableList<String> familyOptions, styleOptions, sizeOptions;
    Button okButton;
    
    public FontDialogView(ePortfolioMakerView initUI) {
     ui = initUI;   
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(300);
        
        optionPane = new FlowPane();
        vBox = new VBox();
        initFamily();
        initStyle();
        initSize();
        
        vBox.getChildren().add(optionPane);
        okButton = new Button("Ok");
        vBox.getChildren().add(okButton);
        
        scene = new Scene(vBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void initFamily() {
       familyOptions = FXCollections.observableArrayList(
        "Dosis",
        "Playfair Display",
        "Raleway",
        "Roboto Condensed",
        "Yanone Kaffeesatz"      
    );
       
       family = new ComboBox(familyOptions);
       family.setPromptText("Select a font");
       optionPane.getChildren().add(family);
       
    }
    
    public void initStyle() {
        styleOptions = FXCollections.observableArrayList(
        "Normal",
        "Bold",
        "Italic"    
    );
        style = new ComboBox(styleOptions);
        style.setPromptText("Select a Style");
        optionPane.getChildren().add(style);
    }
    
    public void initSize() {
        sizeOptions = FXCollections.observableArrayList(
        "Extra Small",
        "Small",
        "Medium",
        "Large",
        "Extra Large"     
    );
        size = new ComboBox(sizeOptions);
        size.setPromptText("Select a Size");
        optionPane.getChildren().add(size);
    }
}
