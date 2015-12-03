/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_CLASS_COMPONENT_EDIT_VIEW;
import static ePortfolioMaker.StartupConstants.IMAGE;
import static ePortfolioMaker.StartupConstants.TEXT;
import static ePortfolioMaker.StartupConstants.VIDEO;
import ePortfolioMaker.model.Component;
import ePortfolioMaker.model.TextCompModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

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
   Label imageCaption;
   
   //FOR VIDEO COMPONENTS
   Media videoToView;
   MediaView videoView;
   MediaPlayer videoPlayer;
   Label videoCaption;
   
   public ComponentEditView(Component comp) {
       if(comp.getType().equals(TEXT))
           processTextComponent(comp);
       if(comp.getType().equals(IMAGE))
           processImageComponent(comp);
       if(comp.getType().equals(VIDEO))
           processVideoComponent(comp);
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
       imageCaption = new Label(component.getImageCaption());
       getChildren().add(imageView);
       getChildren().add(imageCaption);
   }
   
   public void processVideoComponent(Component videoComp) {
       this.getStyleClass().add(CSS_CLASS_COMPONENT_EDIT_VIEW);
       component = videoComp;  
       videoToView = videoComp.getVideoComponent();
       videoPlayer = new MediaPlayer(videoToView);
       videoView = new MediaView();
       videoView.setMediaPlayer(videoPlayer);
       videoView.setFitHeight(component.getVideoHeight());
       videoView.setFitWidth(component.getVideoWidth());
       videoCaption = new Label(component.getVideoCaption());
       getChildren().add(videoView);
       getChildren().add(videoCaption);
       Button playButton = new Button("Play");
       Button pauseButton = new Button("Pause");
       playButton.setOnAction(e -> {
           videoPlayer.play();
       });
       pauseButton.setOnAction(e -> {
           videoPlayer.pause();
       });
       getChildren().add(playButton);
       getChildren().add(pauseButton);       
   }
}
