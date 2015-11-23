/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class TextDialogView {
    Stage stage;
    Scene scene;
    FlowPane buttonPane;
    BorderPane borderPane;
    Label enterTextLabel;
    Button paragraphButton, headerButton, listButton, doneButton;
    TextField paragraphTextField, headerTextField, listTextField;
    ePortfolioMakerView ui;
    
    public TextDialogView(ePortfolioMakerView initUI) {
        stage = new Stage();
        buttonPane = new FlowPane();
        enterTextLabel = new Label();
        ui = initUI;
    }
    
    public void initButtons() {
        
    }
    
    public void initEventHandlers() {
        
    }
    
    public void showDialog() {
        stage.setWidth(400);
        stage.setHeight(300);
        borderPane = new BorderPane();
        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void closeDialog() {
        
    }
    
    public void paragraph() {
        
    }
    
    public void header() {
        
    }
    
    public void list() {
        
    }
    
    public Button initChildButton(Pane toolbar, String iconFileName, LanguagePropertyType tooltip, String cssClass, boolean disabled) {
    PropertiesManager props = PropertiesManager.getPropertiesManager();
    String imagePath = "file:" + PATH_ICONS + iconFileName;
    Image buttonImage = new Image(imagePath);
    Button button = new Button();
    button.getStyleClass().add(cssClass);
    button.setDisable(disabled);
    button.setGraphic(new ImageView(buttonImage));
    Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
    button.setTooltip(buttonTooltip);
    toolbar.getChildren().add(button);
    return button;
}

}
