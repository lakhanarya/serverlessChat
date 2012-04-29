/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MessageResponder {
    
    private final SingletonUIResource resource;
   private final User me;
    private final Settings settings = Settings.getSettings();
    
    public MessageResponder(SingletonUIResource resource)
    {
        this.resource = resource;
        me = settings.getMe();
    }
    
    public void messageArrived(final int userCode, final String msg)
    {
        User user = resource.getUserListController().getUserByCode(userCode);
        resource.getMainChatController().writeToMainChat(msg, user.getNick());
    }
    
    public void userLogon(final User newUser)
    {
        if(me.getNick().trim().equals(newUser.getNick()))
        {
            resource.getNetworkController().sendNickCrashMessage(newUser.getNick());
            newUser.setNick(""+newUser.getCode());
        }
        else if (resource.getUserListController().isNickInUse(newUser.getNick()))
        {
            newUser.setNick(""+newUser.getCode());
        }
        resource.getUserListController().add(newUser);
        resource.getMainChatController().writeToMainChat(newUser.getNick() + " loggon on from " + newUser.getIpAddress());
    }

    public void nickCrash() {
        resource.getUserListController().changeNick(me.getCode(), ""+me.getCode());
        resource.getMainChatController().writeToMainChat("Nick Crashed. Setting nick to " + me.getCode());
    }
    
    public void exposeRequested() {
        resource.getNetworkController().sendExposingMessage();
    }

    void userExposing(User newUser) {
        if(resource.getUserListController().getUserByNick(newUser.getNick())==null)
        resource.getUserListController().add(newUser);
    }

    void nickChanged(int code, String nick) {
        if(!resource.getUserListController().isNickInUse(nick))
        {
            String oldNick = resource.getUserListController().getUserByCode(code).getNick();
            resource.getUserListController().changeNick(code, nick);
            resource.getMainChatController().writeToMainChat(oldNick + " changed Nick to " + nick);
        }
        
    }

    void userLogoff(String nick) {
        User user = resource.getUserListController().getUserByNick(nick);
        resource.getUserListController().removeUser(user);
        resource.getMainChatController().writeToMainChat(nick + " Logged off");
    }

    void userIdle(String nick) {
        User user = resource.getUserListController().getUserByNick(nick);
        resource.getMainChatController().writeToMainChat(nick + " went away");
    }
    
    void userBack (String nick) {
        User user = resource.getUserListController().getUserByNick(nick);
        resource.getMainChatController().writeToMainChat(nick + " came back");
    }
}
