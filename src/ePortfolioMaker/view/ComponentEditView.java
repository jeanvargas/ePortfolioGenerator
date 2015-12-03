/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_CLASS_COMPONENT_EDIT_VIEW;
import static ePortfolioMaker.StartupConstants.IMAGE;
import static ePortfolioMaker.StartupConstants.TEXT;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.TextCompModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jeanmarie
 */
public class ComponentEditView extends HBox{
   Component component;
   
   //FOR TEXT COMPONENTS
   Label textLabel;
   Label compData;
   
   //FOR IMAGE COMPONENTS
   Image imageToView;
   ImageView imageView;
   
   public ComponentEditView(Component comp) {
       if(comp.getType().equals(TEXT))
           processTextComponent(comp);
       if(comp.getType().equals(IMAGE))
           processImageComponent(comp);
   }
   
   public void processTextComponent(Component textComp) {
       this.getStyleClass().add(CSS_CLASS_COMPONENT_EDIT_VIEW);
       component = textComp;
       String text = component.getTextComponentData();
       textLabel = new Label(text);
       getChildren().add(textLabel);
   }
   
   public void processImageComponent(Component imageComp) {
       this.getStyleClass().add(CSS_CLASS_COMPONENT_EDIT_VIEW);
       component = imageComp;
       imageToView = imageComp.getImageComponent();
       imageView = new ImageView(imageToView);
       imageView.setFitWidth(component.getImageWidth());
       imageView.setFitHeight(component.getImageHeight());
       getChildren().add(imageView);
   }
}
