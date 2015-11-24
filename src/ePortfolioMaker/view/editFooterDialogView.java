/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_COMP_FONT;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_TEXT_COMP;
import static ePortfolioMaker.StartupConstants.ICON_CHOOSE_FONT_SMALL;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class editFooterDialogView {
    Stage stage;
    Scene scene;
    FlowPane buttonPane;
    BorderPane borderPane;
    Label enterTextLabel;
    VBox paragraphBox;
    TextArea paragraphTextField;
    Button okButton, compFontButton;
    ePortfolioMakerView ui;
    
    public editFooterDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(300);
        buttonPane = new FlowPane();
        
        compFontButton = initChildButton(buttonPane, ICON_CHOOSE_FONT_SMALL, 
                TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, false);
         compFontButton.setOnAction(e -> {
           FontDialogView fd = new FontDialogView(ui);
           fd.setUpDialog();
        });
         
         borderPane = new BorderPane();
         borderPane.setTop(buttonPane);
         
         paragraphBox = new VBox();
         paragraphBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
         enterTextLabel = new Label("Enter Text:");
         paragraphBox.getChildren().add(enterTextLabel);
         
         paragraphTextField = new TextArea();
         paragraphTextField.setPrefSize(50, stage.getWidth());
         paragraphBox.getChildren().add(paragraphTextField);
         
         okButton = new Button("Ok");
         paragraphBox.getChildren().add(okButton);
         borderPane.setCenter(paragraphBox);

        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
        
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
