
package com.mnnit.server.event;

import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
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
        listModel = new DefaultListModel();
        resource.getUserList().setModel(listModel);
    }
    
    public void userAdded(User user) {
        
        listModel.addElement(user);
    }

    public void userRemoved(int index) {
        listModel.removeElementAt(index);
    }
    
}
