/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.model;

/**
 *
 * @author Lakhan
 */
public final class Settings {

    private User me;
    private static final Settings SETTINGS = new Settings();
    
    private Settings()
    {
        int code = 10000000 + (int) ( Math.random() * 9999999 );
        
        me = new User("nick", code);
        me.setMe(true);
    }

    public User getMe()
    {
        return me;
    }

    public static Settings getSettings()
    {
        return SETTINGS;
    }
}
