/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

/**
 *
 * @author Jeanmarie
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeanmarie
 */
public class HyperlinkComp {
 //   Component component;
    String target;
    String displayText;
    int insertIndex;
    
    public HyperlinkComp (String t, String d) {
     //   component = comp;
        target = t;
        displayText = d;
        insertIndex = 0;
    }
    
    public void setComponent(Component comp) {
    //    component = comp;
    }
    
    public void setTarget(String t) {
        target = t;
    }
    
    public void setDisplayText(String d) {
        displayText = d;
    }
    
    public void setInsertIndex(int i) {
        insertIndex = i;
    }
    /*public Component getComponent() {
        return component;
    }*/
    
    public String getTarget() {
        return target;
    }
    
    public String getDisplayText() {
        return displayText;
    }
    
    public int getIndex() {
        return insertIndex;
    }
}

