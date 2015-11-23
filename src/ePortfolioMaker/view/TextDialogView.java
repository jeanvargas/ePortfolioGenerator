/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

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
    
    public TextDialogView() {
        stage = new Stage();
        buttonPane = new FlowPane();
        enterTextLabel = new Label();
    }
    
    public void initButtons() {
        
    }
    
    public void initEventHandlers() {
        
    }
    
    public void showDialog() {
        
    }
    
    public void closeDialog() {
        
    }
    
    public void paragraph() {
        
    }
    
    public void header() {
        
    }
    
    public void list() {
        
    }

}
