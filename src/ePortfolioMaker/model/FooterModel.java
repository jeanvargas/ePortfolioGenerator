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
public class FooterModel {
    String content;
    
    public FooterModel(String data) {
        content = data;
    }
    
    public void setContent(String s) {
        content = s;
    }
    
    public String getContent() {
        return content;
    }
}
