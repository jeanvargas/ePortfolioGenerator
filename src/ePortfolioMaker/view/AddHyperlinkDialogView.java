/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_CLASS_COLOR_OPTION;
import static ePortfolioMaker.StartupConstants.STYLE_SHEET_UI;
import ePortfolioMaker.model.HyperlinkComp;
import ePortfolioMaker.model.HyperlinkList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
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
    Label displayText, linkText;
    TextField displayField, linkField;
    TextDialogView textDialog;
    HyperlinkComp loadedHyperlink;
   // HyperlinkList hyperlinks;
    
    public AddHyperlinkDialogView(ePortfolioMakerView initUI) {
        ui = initUI;
    }
    
    public AddHyperlinkDialogView(ePortfolioMakerView initUI, TextDialogView initTextUI) {
        ui = initUI;
        textDialog = initTextUI;
      //  hyperlinks = new HyperlinkList();
    }
    
    public void setUpDialog() {
        stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(200);
        
        vBox = new VBox();
        vBox.getStyleClass().add(CSS_CLASS_COLOR_OPTION);
        okButton = new Button("Add Hyperlink");
        
        displayText = new Label("Add display text for hyperlink: ");
        linkText = new Label("Add target link: ");
        displayField = new TextField();
        linkField = new TextField();
       // addHyperlinkLabel = new Label("Add link to be applied to selected text:");
       // hyperlinkTextField = new TextField();
       // vBox.getChildren().add(addHyperlinkLabel);
       // vBox.getChildren().add(hyperlinkTextField);
       // vBox.getChildren().add(okButton);
        okButton.setOnAction(e -> {
               HyperlinkComp hyperlinkToAdd = new HyperlinkComp(linkField.getText(), displayField.getText());
               chooseInsert(hyperlinkToAdd);
               textDialog.getComponent().getHyperlinkList().addHyperlink(hyperlinkToAdd);
            textDialog.reloadHyperlinks();
            stage.close();
        });
        
        vBox.getChildren().add(displayText);
        vBox.getChildren().add(displayField);
        vBox.getChildren().add(linkText);
        vBox.getChildren().add(linkField);
        vBox.getChildren().add(okButton);

        scene = new Scene(vBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
   /* public void addHyperlink() {
        HyperlinkComp hyperlinkToAdd = new HyperlinkComp(linkField.getText(), displayField.getText());
        textDialog.getComponent().getHyperlinkList().addHyperlink(hyperlinkToAdd);
    }*/
    
    public void loadHyperlink(HyperlinkComp comp) {
        loadedHyperlink = comp;
        stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(200);
        
        vBox = new VBox();
        vBox.getStyleClass().add(CSS_CLASS_COLOR_OPTION);
        FlowPane buttonsFlowPane = new FlowPane();
        okButton = new Button("Done");
        Button changeIndexButton = new Button("Change location of this hyperlink");
        Button deleteButton = new Button("Delete this Hyperlink");
        buttonsFlowPane.getChildren().add(okButton);
        buttonsFlowPane.getChildren().add(changeIndexButton);
        buttonsFlowPane.getChildren().add(deleteButton);
        
        displayText = new Label("Add display text for hyperlink: ");
        linkText = new Label("Add target link: ");
        displayField = new TextField();
        linkField = new TextField();
        
        displayField.setText(comp.getDisplayText());
        linkField.setText(comp.getTarget());
       // addHyperlinkLabel = new Label("Add link to be applied to selected text:");
       // hyperlinkTextField = new TextField();
       // vBox.getChildren().add(addHyperlinkLabel);
       // vBox.getChildren().add(hyperlinkTextField);
       // vBox.getChildren().add(okButton);
        okButton.setOnAction(e -> {
            comp.setDisplayText(displayField.getText());
            comp.setTarget(linkField.getText());
            textDialog.reloadHyperlinks();
            stage.close();
        });
        
        deleteButton.setOnAction(e -> {
            textDialog.getComponent().getHyperlinkList().getHyperlinks().remove(comp);
            textDialog.reloadHyperlinks();
            stage.close();
        });
        
        changeIndexButton.setOnAction(e -> {
            chooseInsert(comp);
        });
        
        vBox.getChildren().add(displayText);
        vBox.getChildren().add(displayField);
        vBox.getChildren().add(linkText);
        vBox.getChildren().add(linkField);
        vBox.getChildren().add(buttonsFlowPane);

        scene = new Scene(vBox);
        scene.getStylesheets().add(STYLE_SHEET_UI);
        stage.setScene(scene);
        stage.show();
    }
    
    public void chooseInsert(HyperlinkComp comp) {
        Stage chooseStage = new Stage();
        stage.setWidth(300);
        stage.setHeight(300);
        Label indexLabel = new Label("Click an area of the paragraph where you want to insert the hyperlink.\nThen press the 'OK' Button.");
        Button ok = new Button("OK");
        Scene chooseScene;
        VBox textVBox = new VBox();
        TextArea textField = new TextArea();
        textField.setText(textDialog.getParagraphText());
        
        textVBox.getChildren().add(indexLabel);
        textVBox.getChildren().add(textField);
        textVBox.getChildren().add(ok);
        
        ok.setOnAction(e -> {
            int a = textField.getAnchor();
            System.out.println("anchor: " + a);
            comp.setInsertIndex(a);
            chooseStage.close();
        });
        
        chooseScene = new Scene(textVBox);
        chooseStage.setScene(chooseScene);
        chooseStage.show();
        
    }
}
