/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.LanguagePropertyType;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_HEADER;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_HYPERLINK;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_LIST;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_LIST_ELEMENT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_ADD_PARAGRAPH;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_REMOVE_LIST_ELEMENT;
import static ePortfolioMaker.LanguagePropertyType.TOOLTIP_SELECT_COMP_FONT;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_PAGE_EDITOR_WORKSPACE;
import static ePortfolioMaker.StartupConstants.CSS_CLASS_TEXT_COMP;
import static ePortfolioMaker.StartupConstants.ICON_ADD_HYPERLINK_SMALL;
import static ePortfolioMaker.StartupConstants.ICON_CHOOSE_FONT_SMALL;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_ADD_LIST_ITEM;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_HEADER;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_LIST;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_COMP_PARAGRAPH;
import static ePortfolioMaker.StartupConstants.ICON_TEXT_REMOVE_LIST_ITEM;
import static ePortfolioMaker.StartupConstants.PATH_ICONS;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import static ePortfolioMaker.StartupConstants.TEXT;
import static ePortfolioMaker.StartupConstants.TEXT_HEADER;
import static ePortfolioMaker.StartupConstants.TEXT_LIST;
import static ePortfolioMaker.StartupConstants.TEXT_PARAGRAPH;
import ePortfolioMaker.controller.PageEditController;
import ePortfolioMaker.controller.TextDialogController;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.HyperlinkComp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleRole.PARAGRAPH;
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
    TextFlow flow;
    ScrollPane listScrollPane;
    Button paragraphButton, headerButton, listButton, compFontButton, okParagraphButton, 
            okHeaderButton, okListButton, addElementToListButton, removeListElemenButton;
    TextArea paragraphTextField;
    TextField headerTextField, listTextField;
    ObservableList<String> listElements;
    ObservableList<Label> listLabels;
    ObservableList<Button> listButtons;
    GridPane displayListElements;
    ePortfolioMakerView ui;
    TextDialogController textDialogController;
    PageEditController pageEditController;
    
    String textType;
    
    Label hyperlinkLabel;
    Button addHyperlinkButton;
    Component textComponent;
    
    public TextDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
        hyperlinkLabel = new Label ("Hyperlinks: ");
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
    
    public TextDialogView(ePortfolioMakerView initUI, Component componentToLoad) {
        ui = initUI;
        hyperlinkLabel = new Label ("Hyperlinks: ");
        textType = componentToLoad.getTextType();
        stage = new Stage();
        
        enterTextLabel = new Label("Enter Text:");
        buttonPane = new FlowPane();
        buttonPane.getStyleClass().add(CSS_CLASS_PAGE_EDITOR_WORKSPACE);
        stage.setWidth(400);
        stage.setHeight(300);
        borderPane = new BorderPane();
        
        if(textType.equals(TEXT_PARAGRAPH)) {
            loadParagraph(componentToLoad);
        }
        
        if(textType.equals(TEXT_HEADER)) {
            loadHeader(componentToLoad);
        }
        
         if(textType.equals(TEXT_LIST)) {
            loadList(componentToLoad);
        }   
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
    
    public void paragraph() {
        paragraphBox = new VBox();
        paragraphBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        
        paragraphTextField = new TextArea();
        paragraphTextField.setPrefSize(50, stage.getWidth());
    //    flow = new TextFlow();
    //    flow.setPrefSize(40, stage.getWidth());
        
       /* addHyperlinkButton = initChildButton(buttonPane, ICON_ADD_HYPERLINK_SMALL, 
                TOOLTIP_ADD_HYPERLINK, CSS_CLASS_FILE_TOOLBAR, false);*/
        
        /*paragraphTextField.setOnMouseEntered(e -> {
            addHyperlinkButton.setDisable(false);
        });
        */
     /*   addHyperlinkButton.setOnAction(e -> {
        AddHyperlinkDialogView hyperlink = new AddHyperlinkDialogView(ui, this);
        hyperlink.setUpDialog();
        });*/
      /*  paragraphTextField.setOnContextMenuRequested(e -> {
            System.out.println("This is the selected text: " + paragraphTextField.getSelectedText());
            String t = paragraphTextField.getSelectedText();
            Hyperlink Link = new Hyperlink("www.google.com");
            int index = paragraphTextField.getAnchor();
            //paragraphTextField.getChildrenUnmodifiable().add(index, Link);
           // paragraphTextField.getSelectedText().
        });*/
          
        paragraphBox.getChildren().add(enterTextLabel);
        paragraphBox.getChildren().add(paragraphTextField);
   //     paragraphBox.getChildren().add(flow);
        okParagraphButton = new Button("Add Component");
        paragraphBox.getChildren().add(okParagraphButton);
        borderPane.setCenter(paragraphBox);
        compFontButton.setDisable(false);
        
        pageEditController = new PageEditController(ui);
        okParagraphButton.setOnAction(e -> {
           pageEditController.processAddComponentRequest(paragraphTextField.getText(), TEXT_PARAGRAPH);
           stage.close();
        });
    }
    
    public void reloadHyperlinks() {
        flow.getChildren().clear();
        for(HyperlinkComp hyperlinkComp : textComponent.getHyperlinkList().getHyperlinks()) {
            HyperlinkEditView hyperlinkView = new HyperlinkEditView(hyperlinkComp);
            flow.getChildren().add(hyperlinkView);
            hyperlinkView.setOnAction(e -> {
                AddHyperlinkDialogView hv = new AddHyperlinkDialogView(ui, this);
                hv.loadHyperlink(hyperlinkComp);
            });
        }
    }
    
    public void loadParagraph(Component comp) {
       textComponent = comp;
       Label paragraphLabel = new Label("Paragraph Component:    ");
       hyperlinkLabel = new Label("Hyperlinks: ");
        
       paragraphBox = new VBox();
       paragraphBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
       
       paragraphTextField = new TextArea();
       paragraphTextField.setPrefSize(50, stage.getWidth());
       paragraphTextField.setText(comp.getTextComponentData());
       
       flow = new TextFlow();
       flow.setPrefSize(50, stage.getWidth());
       
       buttonPane.getChildren().add(paragraphLabel);
       compFontButton = initChildButton(buttonPane, ICON_CHOOSE_FONT_SMALL, 
                TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, true);
       compFontButton.setOnAction(e -> {
           textDialogController.handleFontOptionsRequest();
        });
       
       addHyperlinkButton = initChildButton(buttonPane, ICON_ADD_HYPERLINK_SMALL, 
                TOOLTIP_ADD_HYPERLINK, CSS_CLASS_FILE_TOOLBAR, false);
       
       paragraphBox.getChildren().add(enterTextLabel);
       paragraphBox.getChildren().add(paragraphTextField);
       paragraphBox.getChildren().add(hyperlinkLabel);
       paragraphBox.getChildren().add(flow);
       okParagraphButton = new Button("Ok");
       paragraphBox.getChildren().add(okParagraphButton);
       borderPane.setCenter(paragraphBox);
       compFontButton.setDisable(false);
       
       okParagraphButton.setOnAction(e -> {
          comp.setTextCompData(paragraphTextField.getText());
          ui.reloadPage();
          stage.close();
        });
       
       addHyperlinkButton.setOnAction(e -> {
           AddHyperlinkDialogView hyperlinkView = new AddHyperlinkDialogView(ui, this);
           hyperlinkView.setUpDialog();
       });
       
       reloadHyperlinks();
        borderPane.setTop(buttonPane);
        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public Component getComponent() {
        return textComponent;
    }
    
    public String getParagraphText() {
        return paragraphTextField.getText();
    }
    
    public void header() {
        headerBox = new VBox();
        headerBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        headerTextField = new TextField();
        
        headerBox.getChildren().add(enterTextLabel);
        headerBox.getChildren().add(headerTextField);
        okHeaderButton = new Button("Ok");
        pageEditController = new PageEditController(ui);
        
        okHeaderButton.setOnAction(e -> {
           pageEditController.processAddComponentRequest(headerTextField.getText(), TEXT_HEADER);
           stage.close();
        });
        
        headerBox.getChildren().add(okHeaderButton);
        borderPane.setCenter(headerBox);
        compFontButton.setDisable(false);
        
    }
    
    public void loadHeader(Component comp) {
        Label headerLabel = new Label("Header Component:    ");
        
        buttonPane.getChildren().add(headerLabel);
        headerBox = new VBox();
        headerBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        headerTextField = new TextField();
        
        compFontButton = initChildButton(buttonPane, ICON_CHOOSE_FONT_SMALL, 
                TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, true);
        compFontButton.setOnAction(e -> {
           textDialogController.handleFontOptionsRequest();
        });
        
        headerTextField.setText(comp.getTextComponentData());
        
        headerBox.getChildren().add(enterTextLabel);
        headerBox.getChildren().add(headerTextField);
        okHeaderButton = new Button("Ok");
        
        headerBox.getChildren().add(okHeaderButton);
        borderPane.setCenter(headerBox);
        compFontButton.setDisable(false);
        
        okHeaderButton.setOnAction(e -> {
          comp.setTextCompData(headerTextField.getText());
          ui.reloadPage();
          stage.close();
        });
        
        borderPane.setTop(buttonPane);
        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void list() {
        pageEditController = new PageEditController(ui);
        listBox = new VBox();
        listScrollPane = new ScrollPane(listBox);
        displayListElements = new GridPane();
        listElement = new FlowPane();
        listTextField = new TextField();
        okListButton = new Button("Ok");
        okListButton.setDisable(true);
        listElements = FXCollections.observableArrayList();
        listLabels = FXCollections.observableArrayList();
        listButtons = FXCollections.observableArrayList();
        
        listElement.getChildren().add(listTextField);        
        addElementToListButton = initChildButton(listElement, 
        ICON_TEXT_ADD_LIST_ITEM, TOOLTIP_ADD_LIST_ELEMENT, 
        ICON_TEXT_COMP_PARAGRAPH, false);
        
        listBox.getChildren().add(listElement);
        
        addElementToListButton.setOnAction(e -> {
            addListElement(listTextField.getText());
        });
        
        FlowPane sample = new FlowPane();
        
        okListButton.setOnAction(e -> {
            pageEditController.processAddComponentRequest(listElements, TEXT_LIST);
            stage.close();
        });
        
        listBox.getChildren().add(sample);
        listBox.getChildren().add(displayListElements);
        
        listBox.getChildren().add(okListButton);
        borderPane.setCenter(listScrollPane);
        compFontButton.setDisable(false);
    }
    
    public void loadList(Component comp) {
        listBox = new VBox();
        listScrollPane = new ScrollPane(listBox);
        displayListElements = new GridPane();
        
        Label listLabel = new Label("List Component:    ");
        
        buttonPane.getChildren().add(listLabel);
        listBox.getStyleClass().add(CSS_CLASS_TEXT_COMP);
        
        compFontButton = initChildButton(buttonPane, ICON_CHOOSE_FONT_SMALL, 
                TOOLTIP_SELECT_COMP_FONT, CSS_CLASS_FILE_TOOLBAR, true);
        compFontButton.setOnAction(e -> {
           textDialogController.handleFontOptionsRequest();
        });
        
        listElement = new FlowPane();
        listTextField = new TextField();
        okListButton = new Button("Ok");
        okListButton.setDisable(true);
        listElements = FXCollections.observableArrayList();
        listLabels = FXCollections.observableArrayList();
        listButtons = FXCollections.observableArrayList();
        
        listElement.getChildren().add(listTextField);        
        addElementToListButton = initChildButton(listElement, 
        ICON_TEXT_ADD_LIST_ITEM, TOOLTIP_ADD_LIST_ELEMENT, 
        ICON_TEXT_COMP_PARAGRAPH, false);
        
        listBox.getChildren().add(listElement);
        
        addElementToListButton.setOnAction(e -> {
            addListElement(listTextField.getText());
        });
        
        FlowPane sample = new FlowPane();
        
        okListButton.setOnAction(e -> {
            comp.setTextList(listElements);
            ui.reloadPage();
            stage.close();
        });
        
        listBox.getChildren().add(sample);
        listBox.getChildren().add(displayListElements);
        
        ObservableList<String> getListElements = comp.getTextArray();
        for(int i = 0; i < getListElements.size(); i++) {
            addListElement(getListElements.get(i));
        }
        
        listBox.getChildren().add(okListButton);
        borderPane.setCenter(listScrollPane);
        compFontButton.setDisable(false);
        
        borderPane.setTop(buttonPane);
        scene = new Scene(borderPane);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void addListElement(String elementToAdd){
        listElements.add(elementToAdd);
        Label newLabel = new Label(elementToAdd);
        Button newButton =  initChildButton(ICON_TEXT_REMOVE_LIST_ITEM, 
                TOOLTIP_REMOVE_LIST_ELEMENT, ICON_TEXT_COMP_PARAGRAPH, false);
        newButton.setOnAction(e -> {
            removeListElement(elementToAdd);
        });
        listLabels.add(newLabel);
        listButtons.add(newButton);
        loadListElements();
    }
    
    public void loadListElements(){
        displayListElements.getChildren().clear();
        okListButton.setDisable(true);
        if(listElements!=null && !(listElements.isEmpty())) {
           for(int i = 0; i < listElements.size(); i++) {
                displayListElements.add(listLabels.get(i),0,i);
                displayListElements.add(listButtons.get(i), 1, i);
            }
         okListButton.setDisable(false);
        }        
    }
    
    public void removeListElement(String elementToRemove) {
        int i = listElements.indexOf(elementToRemove);
        listElements.remove(elementToRemove);
        listLabels.remove(i);
        listButtons.remove(i);
        loadListElements();
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
    
    public Button initChildButton(String iconFileName, LanguagePropertyType tooltip, String cssClass, boolean disabled) {
    PropertiesManager props = PropertiesManager.getPropertiesManager();
    String imagePath = "file:" + PATH_ICONS + iconFileName;
    Image buttonImage = new Image(imagePath);
    Button button = new Button();
    button.getStyleClass().add(cssClass);
    button.setDisable(disabled);
    button.setGraphic(new ImageView(buttonImage));
    Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
    button.setTooltip(buttonTooltip);
    return button;
}

}
