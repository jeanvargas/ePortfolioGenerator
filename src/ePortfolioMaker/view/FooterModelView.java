/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import static ePortfolioMaker.StartupConstants.CSS_CLASS_COMPONENT_EDIT_VIEW;
import ePortfolioMaker.model.FooterModel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jeanmarie
 */
public class FooterModelView extends HBox{
    FooterModel footer;
    Label data;
    
    public FooterModelView(FooterModel initFooter) {
        footer = initFooter;
        this.getStyleClass().add(CSS_CLASS_COMPONENT_EDIT_VIEW);
        data = new Label(initFooter.getContent());
        getChildren().add(data);
    }
}
