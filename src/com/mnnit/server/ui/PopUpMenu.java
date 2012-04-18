/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author darth
 */
public class PopUpMenu extends JPopupMenu{
    private String selectedUser = null ;
    JMenuItem privateChatItem ; /*For the send private chat in the user list*/
    JMenuItem blockFromChatItem ; /*For blocking a particular user from the chat list*/
    public PopUpMenu()
    {
        privateChatItem = new JMenuItem("send private chat");
        blockFromChatItem = new JMenuItem("block from chat");
        privateChatItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("send private chat to user " + selectedUser+ "is selected ");
            }
        });
        
        blockFromChatItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("user"+ selectedUser+ "is blocked from the mainchat");
                
            }
        });
        
        add(privateChatItem);
        add(blockFromChatItem);
    }

    void showUser(Component component, int x, int y, String userSelected) {
            this.selectedUser = userSelected ;
            show(component , x , y ) ;
    }
}
