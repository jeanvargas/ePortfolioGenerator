/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.view;

import ePortfolioMaker.model.HyperlinkComp;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Jeanmarie
 */
public class HyperlinkEditView extends Button{
   HyperlinkComp hyperlink;
   String labelText;
  // Label hyperlinkName;
   
   public HyperlinkEditView(HyperlinkComp initHyperlink) {
       hyperlink = initHyperlink;
       labelText = hyperlink.getDisplayText();
       this.setText(labelText);
   }
   
   public void setHyperlinkName(String name) {
       this.setText(name);
   }
   
   public void setHyperlink(HyperlinkComp h) {
       hyperlink = h;
   }
   
   public HyperlinkComp getHyperlinkComp() {
       return hyperlink;
   }
   
   public String getLinkName() {
       return labelText;
   }
}
