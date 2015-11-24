/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ePortfolioMaker.controller;

import ePortfolioMaker.view.TextDialogView;

/**
 *
 * @author Jeanmarie
 */
public class TextDialogController {
    TextDialogView textDialog;
    public TextDialogController(TextDialogView initTextDialog) {
        textDialog = initTextDialog;
    }
    
    public void handleParagraphRequest() {
        textDialog.paragraph();
    }
    
    public void handleHeaderRequest() {
        textDialog.header();
    }
    
    public void handleListRequest() {
        textDialog.list();
    }
    
    public void handleFontOptionsRequest() {
        textDialog.fontOptions();
    }
}
