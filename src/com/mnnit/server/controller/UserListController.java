package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
import com.mnnit.server.event.UserListListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lakhan
 */
public class UserListController {
    
    private List<User> uList;
    private UserListListener listener;
    
    public UserListController(SingletonUIResource resource)
    {
        createUserList();
        this.listener = new UserListListener(resource);
    }
    
    public void createUserList()
    {
        if(uList!=null)
        {
            System.out.println("UserList Already Created");
        }
        else
        {
            uList = new ArrayList();
        }
    }
    
    public void setUserListListener(UserListListener listener)
    {
        this.listener = listener;
    }
    
    public void add(User user)
    {
        if(uList==null)
        {
            System.out.println("User List Null. Unable to add user");
        }
        else
        {
            uList.add(user);
            if(listener!=null)
                listener.userAdded(user);
        }
    }
    
    public void removeUser(User user)
    {
        if(uList==null)
        {
            System.out.println("User List Null. Unable to add user");
        }
        else
        {
            uList.remove(user);
            if(listener!=null)
                listener.userRemoved(user);
        }
    }
    
    public void setAway(final int code, boolean away)
    {
        User user = getUserByCode(code);
        if(user!=null)
        {
            user.setIdle(away);
        }
        if(listener!=null)
            listener.userAway(user);
    }
    
    public User getUserByCode(final int code)
    {
        for(int i=0; i<uList.size(); i++)
            if(uList.get(i).getCode()==code)
                return uList.get(i);
        return null;
    }
    
    public User getUserByNick(String nick)
    {
        for(int i=0; i<uList.size(); i++)
        {
            if(uList.get(i).getNick() == null ? nick == null : uList.get(i).getNick().equals(nick))
                return uList.get(i);
        }
        return null;
    }
    
    public boolean isNickInUse(String nick)
    {
        for(int i=0; i<uList.size(); i++)
        {
             if(uList.get(i).getNick() == null ? nick == null : uList.get(i).getNick().equals(nick))
                 return true;
        }
        return false;
    }
    
    public void changeNick(int code, String nick)
    {
        User user = getUserByCode(code);
        if(user!=null)
        {
        int ind = getUserIndex(user);
        user.setNick(nick);
        uList.set(ind, user);
        if(listener!=null)
            listener.userNickChanged(user, ind);
    
        }
    }
    
    private int getUserIndex(User user) {
        return uList.indexOf(user);
    }
}
