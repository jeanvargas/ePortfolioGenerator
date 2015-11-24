/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_CLASS_COLOR_OPTION;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jeanmarie
 */
public class AddHyperlinkDialogView {
    ePortfolioMakerView ui;
    Stage stage;
    Scene scene;
    VBox vBox;
    Button okButton;
    Label addHyperlinkLabel;
    TextField hyperlinkTextField;
    
    public AddHyperlinkDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(200);
        
        vBox = new VBox();
        vBox.getStyleClass().add(CSS_CLASS_COLOR_OPTION);
        okButton = new Button("Ok");
        addHyperlinkLabel = new Label("Add link to be applied to selected text:");
        hyperlinkTextField = new TextField();
        vBox.getChildren().add(addHyperlinkLabel);
        vBox.getChildren().add(hyperlinkTextField);
        vBox.getChildren().add(okButton);
        
        scene = new Scene(vBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
}
