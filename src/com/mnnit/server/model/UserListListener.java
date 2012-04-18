
package com.mnnit.server.model;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author Lakhan
 */
public class UserListListener {
    
    private DefaultListModel listModel;
    private SingletonUIResource resource;
    
    public UserListListener(SingletonUIResource resource)
    {
        this.resource=resource;
        listModel=(DefaultListModel) resource.getUserList().getModel();
    }
    
    public void userAdded(User user) {
        
        listModel.addElement(user);
    }

    public void userRemoved(int index) {
        listModel.removeElementAt(index);
    }
    
}
