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
public class Page {
    String title;
    
    public Page(String initTitle) {
        title = initTitle;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    
    public String getTitle() {
        return title;
    }
}
