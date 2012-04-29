package com.mnnit.server.net;

import com.mnnit.server.controller.MainChatController;
import com.mnnit.server.controller.NetworkController;
import com.mnnit.server.controller.UserListController;
import com.mnnit.server.model.Settings;
import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
/**
 *
 * @author Lakhan
 */
public class MessageParser {
    
    private MessageResponder responder;
    
    public MessageParser(SingletonUIResource resource)
    {
        responder = new MessageResponder(resource);
    }
    
    public void parseMsg(String msg, String ipAddress)
    {
        int ind1 = msg.indexOf('#');
        int ind2 = msg.indexOf('!');
        String codes = msg.substring(0, ind1);
        int code = Integer.parseInt(codes);
        String type = msg.substring(ind1+1, ind2);
        String mainMsg, nick;
        if("CHAT".equals(type))
        {
            int l = msg.indexOf('[');
            nick = msg.substring(ind2+1, l);
            mainMsg = msg.substring(l+1, msg.length()-1);
            responder.messageArrived(code, mainMsg);
        }
        else if ("NICK".equals(type))
        {
            int l = msg.indexOf(':');
            nick = msg.substring(ind2+1, l);
            mainMsg = msg.substring(l+1);
            responder.nickChanged(code, mainMsg);
        }
        else if("LOGON".equals(type))
        {
            nick = msg.substring(ind2+1);
            if(code != Settings.getSettings().getMe().getCode())
            {
                User newUser = new User(nick, code);
                newUser.setIpAddress(ipAddress);
                responder.userLogon(newUser);
            } 
        }
        else if("NICKCRASH".equals(type))
        {
            if(code != Settings.getSettings().getMe().getCode())
            {
                responder.nickCrash();
            }
        }
        
        else if ("EXPOSE".equals(type))
        {
            if(code != Settings.getSettings().getMe().getCode())
            {
                responder.exposeRequested();
            }
        }
        else if ("EXPOSING".equals(type))
        {
            nick = msg.substring(ind2+1);
            if(code != Settings.getSettings().getMe().getCode())
            {
                User newUser = new User(nick, code);
                newUser.setIpAddress(ipAddress);
                responder.userExposing(newUser);
            }
        }
        else if ("LOGOFF".equals(type))
        {
            if(code != Settings.getSettings().getMe().getCode())
            {
                nick = msg.substring(ind2+1);
                responder.userLogoff(nick);
            }
        }
        else if ("IDLE".equals(type))
        {
            if(code != Settings.getSettings().getMe().getCode())
            {
                nick = msg.substring(ind2+1);
                responder.userIdle(nick);
            }
        }
        else if ("BACK".equals(type))
        {
            if(code != Settings.getSettings().getMe().getCode())
            {
                nick = msg.substring(ind2+1);
                responder.userBack(nick);
            }
        }
    }
}
