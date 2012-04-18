/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author darth
 */
public class RightClickMenuHandlers implements ActionListener{

    public RightClickMenuHandlers(String message)
    {
        this.message = message ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*This will perform different functions depending on the type of action*/
    }
    
    public String toString()
    {
        return message ;
    }
    
    private String message ;
}
