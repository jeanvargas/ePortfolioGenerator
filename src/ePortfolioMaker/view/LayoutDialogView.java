/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_TEXT_COMP;
import static ePortfolioMaker.StartupConstants.LAYOUT_FIVE;
import static ePortfolioMaker.StartupConstants.LAYOUT_FOUR;
import static ePortfolioMaker.StartupConstants.LAYOUT_ONE;
import static ePortfolioMaker.StartupConstants.LAYOUT_THREE;
import static ePortfolioMaker.StartupConstants.LAYOUT_TWO;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.model.PageModel;
import ePortfolioMaker.model.ePortfolioModel;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Jeanmarie
 */
public class LayoutDialogView {
    ePortfolioMakerView ui;
    Stage stage;
    Scene scene;
    Button layout1Button, layout2Button, layout3Button, 
            layout4Button, layout5Button;
    VBox layoutOptions;
    
    public LayoutDialogView(ePortfolioMakerView initUI){
     ui = initUI;   
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(300);
        
        layoutOptions = new VBox();
        layoutOptions.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        
        layout1Button = new Button("Layout 1");
        layout2Button = new Button("Layout 2");
        layout3Button = new Button("Layout 3");
        layout4Button = new Button("Layout 4");
        layout5Button = new Button("Layout 5");
        
        layoutOptions.getChildren().add(layout1Button);
        layoutOptions.getChildren().add(layout2Button);
        layoutOptions.getChildren().add(layout3Button);
        layoutOptions.getChildren().add(layout4Button);
        layoutOptions.getChildren().add(layout5Button);
        
        layout1Button.setOnAction(e -> {
            ePortfolioModel ePortfolio = ui.getEPortfolio();
            ui.getPage().setLayout(LAYOUT_ONE);
            stage.close();
        });
        layout2Button.setOnAction(e -> {
            ui.getPage().setLayout(LAYOUT_TWO);
            stage.close();
        });
        layout3Button.setOnAction(e -> {
            ui.getPage().setLayout(LAYOUT_THREE);
            stage.close();
        });
        layout4Button.setOnAction(e -> {
            ui.getPage().setLayout(LAYOUT_FOUR);
            stage.close();
        });
        layout5Button.setOnAction(e -> {
            ui.getPage().setLayout(LAYOUT_FIVE);
            stage.close();
        });

        scene = new Scene(layoutOptions);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
}
