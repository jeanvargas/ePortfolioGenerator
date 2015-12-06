/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.model;

import ePortfolioMaker.view.TextDialogView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jeanmarie
 */
public class HyperlinkList {
 //   Component component;
    //TextDialogView view;
    ObservableList<HyperlinkComp> hyperlinks;
    HyperlinkComp selectedHyperlink;
    
    public HyperlinkList() {
       // view = initView;
       // component = initComponent;
        hyperlinks = FXCollections.observableArrayList();
        reset();
    }
    
    public boolean isHyperlinkSelected() {
        return selectedHyperlink != null;
    }
    
    public boolean isSelectedHyperlink(HyperlinkComp  h) {
        return selectedHyperlink == h;
    }
    
    public ObservableList<HyperlinkComp> getHyperlinks() {
        return hyperlinks;
    }
    
    public HyperlinkComp getSelectedHyperlink() {
        return selectedHyperlink;
    }
    
    public void setSelectedHyperlink(HyperlinkComp initHyperlink) {
        selectedHyperlink = initHyperlink;
    }
    
    public void addHyperlink(HyperlinkComp hyperlinkToAdd) {
       // HyperlinkComp hyperlinkToAdd = new HyperlinkComp(c, title, data);
        hyperlinks.add(hyperlinkToAdd);
        //reload
    }
    
    public void reset() {
        hyperlinks.clear();
        selectedHyperlink = null;
    }

}
