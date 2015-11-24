/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_HEADER;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_LIST;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_LIST_ELEMENT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_PARAGRAPH;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_COMP_FONT;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_PAGE_EDITOR_WORKSPACE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_TEXT_COMP;
import static ePortfolioMaker.StartupConstants.ICON_CHOOSE_FONT_SMALL;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_ADD_LIST_ITEM;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_HEADER;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_LIST;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_PARAGRAPH;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.controller.TextDialogController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class TextDialogView {
    Stage stage;
    Scene scene;
    FlowPane buttonPane, listElement;
    BorderPane borderPane;
    Label enterTextLabel;
    VBox paragraphBox, headerBox, listBox;
    Button paragraphButton, headerButton, listButton, compFontButton, okParagraphButton, 
            okHeaderButton, okListButton, addElementToListButton;
    TextArea paragraphTextField;
    TextField headerTextField, listTextField;
    ePortfolioMakerView ui;
    TextDialogController textDialogController;
    
    public TextDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
        stage = new Stage();
        enterTextLabel = new Label("Enter Text:");
        buttonPane = new FlowPane();
        buttonPane.getStyleClass().add(CSS_CLASS_PAGE_EDITOR_WORKSPACE);
        stage.setWidth(400);
        stage.setHeight(300);
        borderPane = new BorderPane();
        initButtons();
        initEventHandlers();

    }
    
    public void initButtons() {
        paragraphButton = initChildButton(buttonPane, ICON_TEXT_COMP_PARAGRAPH, 
                TOOLTIP_ADD_PARAGRAPH, CSS_CLASS_FILE_TOOLBAR, false);
        headerButton = initChildButton(buttonPane, ICON_TEXT_COMP_HEADER, 
                TOOLTIP_ADD_HEADER, CSS_CLASS_FILE_TOOLBAR, false);
        listButton = initChildButton(buttonPane, ICON_TEXT_COMP_LIST, 
                TOOLTIP_ADD_LIST, CSS_CLASS_FILE_TOOLBAR, false);
        compFontButton = initChildButton(buttonPane, ICON_CHOOSE_FONT_SMALL, 
                TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, true);
    }
    
    public void initEventHandlers() {
        textDialogController = new TextDialogController(this);
        
        paragraphButton.setOnAction(e -> {
           textDialogController.handleParagraphRequest();
        });
        headerButton.setOnAction(e -> {
            textDialogController.handleHeaderRequest();
        });
        listButton.setOnAction(e -> {
            textDialogController.handleListRequest();
        });
        compFontButton.setOnAction(e -> {
           textDialogController.handleFontOptionsRequest();
        });
    }
    
    public void showDialog() {
        borderPane.setTop(buttonPane);
        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void closeDialog() {
        
    }
    
    public void paragraph() {
        paragraphBox = new VBox();
        paragraphBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        
        paragraphTextField = new TextArea();
        paragraphTextField.setPrefSize(50, stage.getWidth());
      //  paragraphTextField.prefWidth(20);
      //  paragraphTextField.minHeight(100);
        
        paragraphBox.getChildren().add(enterTextLabel);
        paragraphBox.getChildren().add(paragraphTextField);
        okParagraphButton = new Button("Ok");
        paragraphBox.getChildren().add(okParagraphButton);
        borderPane.setCenter(paragraphBox);
        compFontButton.setDisable(false);
    }
    
    public void header() {
        headerBox = new VBox();
        headerBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        headerTextField = new TextField();
        
        headerBox.getChildren().add(enterTextLabel);
        headerBox.getChildren().add(headerTextField);
        okHeaderButton = new Button("Ok");
        headerBox.getChildren().add(okHeaderButton);
        borderPane.setCenter(headerBox);
        compFontButton.setDisable(false);
        
    }
    
    public void list() {
        listBox = new VBox();
        listElement = new FlowPane();
        listTextField = new TextField();
        okListButton = new Button("Ok");
        
        listElement.getChildren().add(listTextField);        
        addElementToListButton = initChildButton(listElement, 
       ICON_TEXT_ADD_LIST_ITEM, TOOLTIP_ADD_LIST_ELEMENT, 
       ICON_TEXT_COMP_PARAGRAPH, false);
        
        listBox.getChildren().add(listElement);
        listBox.getChildren().add(okListButton);
        borderPane.setCenter(listBox);
        compFontButton.setDisable(false);
    }
    
    public void fontOptions() {
        FontDialogView fd = new FontDialogView(ui);
        fd.setUpDialog();
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
