/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.COLOR_BLACK;
import static ePortfolioMaker.StartupConstants.COLOR_BLUE;
import static ePortfolioMaker.StartupConstants.COLOR_GREEN;
import static ePortfolioMaker.StartupConstants.COLOR_ORANGE;
import static ePortfolioMaker.StartupConstants.COLOR_WHITE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_COLOR_OPTION;
import static ePortfolioMaker.StartupConstants.LAYOUT_FIVE;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class ColorThemeDialog {
    ePortfolioMakerView ui;
    Rectangle blue, green, black, white, orange;
    Button blueButton, greenButton, blackButton, whiteButton, orangeButton;
    Label choose;
    Stage stage;
    Scene scene;
    VBox colorOptions;
    
    public ColorThemeDialog(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(300);
        
        colorOptions = new VBox();
        colorOptions.getStyleClass().add(CSS_CLASS_COLOR_OPTION);
        choose = new Label("Choose a Color Theme:");
        colorOptions.getChildren().add(choose);
        
        blue = new Rectangle(0,0,120,25);
        blue.setFill(Color.rgb(144, 212, 207, .4));
        blueButton = new Button();
        blueButton.setGraphic(blue);
        colorOptions.getChildren().add(blueButton);
        
        blue.setOnMousePressed(e -> {
            ui.getPage().setColor(COLOR_BLUE);
            stage.close();
        });
        
        green = new Rectangle(0,0,120,25);
        green.setFill(Color.rgb(191,229,155,0.4));
        greenButton = new Button();
        greenButton.setGraphic(green);
        colorOptions.getChildren().add(greenButton);
        
        green.setOnMousePressed(e -> {
            ui.getPage().setColor(COLOR_GREEN);
            stage.close();
        });
        
        orange = new Rectangle(0,0,120,25);
        orange.setFill(Color.rgb(242, 198, 113, 1.0));
        orangeButton = new Button();
        orangeButton.setGraphic(orange);
        colorOptions.getChildren().add(orangeButton);
        
        orange.setOnMousePressed(e -> {
            ui.getPage().setColor(COLOR_ORANGE);
            stage.close();
        });
        
        white = new Rectangle(0,0,120,25);
        white.setFill(Color.rgb(255, 255, 255, 1.0));
        whiteButton = new Button();
        whiteButton.setGraphic(white);
        colorOptions.getChildren().add(whiteButton);
        
        white.setOnMousePressed(e -> {
            ui.getPage().setColor(COLOR_WHITE);
            stage.close();
        });
        
        black = new Rectangle(0,0,120,25);
        black.setFill(Color.rgb(0, 0, 0, 1.0));
        blackButton = new Button();
        blackButton.setGraphic(white);
        colorOptions.getChildren().add(blackButton);
        
        black.setOnMousePressed(e -> {
            ui.getPage().setColor(COLOR_BLACK);
            stage.close();
        });
        
        
        
        //CSS_CLASS_COLOR_OPTION
       // Rectangle rect1 = new Rectangle(10, 10, 200, 200);
       // rect1.setFill(Color.BLUE);
        //Button one = new Button();
        //one.setGraphic(blue);
        
        scene = new Scene(colorOptions);
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
