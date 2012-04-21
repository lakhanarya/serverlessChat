package com.mnnit.server.net;

import com.mnnit.server.controller.MainChatController;
import com.mnnit.server.model.SingletonUIResource;
/**
 *
 * @author Lakhan
 */
public class MessageParser {
    
    private SingletonUIResource resource;
    private MainChatController chatController;
    
    public MessageParser(SingletonUIResource resource)
    {
        this.resource = resource;
        chatController = resource.getMainChatController();
    }
    
    public void parseMsg(String msg)
    {
        int ind1 = msg.indexOf('#');
        int ind2 = msg.indexOf('!');
        String code = msg.substring(0, ind1);
        String type = msg.substring(ind1+1, ind2);
        String mainMsg, nick;
        if("CHAT".equals(type)||"NICK".equals(type))
        {
            int ind = msg.indexOf("[");
            nick = msg.substring(ind2+1, ind);
            mainMsg = msg.substring(ind+1, msg.length()-1);
            if("CHAT".equals(type))
                chatController.writeToMainChat(nick + "> " + mainMsg);
            else if ("NICK".equals(type))
            {
                resource.getUserListController().changeNick(nick, mainMsg);
            }
        }
        else
        {
            
        }
    }
}
