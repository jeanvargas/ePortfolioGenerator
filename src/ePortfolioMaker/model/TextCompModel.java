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
public class TextCompModel {
    int id;
    String text;
    
    public TextCompModel(int initID, String initText) {
        id = initID;
        text = initText;
    }
    
    public int getID(){
        return id;
    }
    
    public String getText() {
        return text;
    }
}
