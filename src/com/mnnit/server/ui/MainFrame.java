/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.ui;

import com.mnnit.server.model.Settings;
import com.mnnit.server.model.SingletonUIResource;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Lakhan
 */
public class MainFrame extends javax.swing.JFrame {

    public JMenuItem getAboutChatItem() {
        return aboutChatItem;
    }

    public void setAboutChatItem(JMenuItem aboutChatItem) {
        this.aboutChatItem = aboutChatItem;
    }

    public JMenuItem getClearChatMenuItem() {
        return clearChatMenuItem;
    }

    public void setClearChatMenuItem(JMenuItem clearChatMenuItem) {
        this.clearChatMenuItem = clearChatMenuItem;
    }

    public JMenuItem getConnectMenuItem() {
        return connectMenuItem;
    }

    public void setConnectMenuItem(JMenuItem connectMenuItem) {
        this.connectMenuItem = connectMenuItem;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenu getHelpMenu() {
        return helpMenu;
    }

    public void setHelpMenu(JMenu helpMenu) {
        this.helpMenu = helpMenu;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextArea getMainChatArea() {
        return mainChatArea;
    }

    public void setMainChatArea(JTextArea mainChatArea) {
        this.mainChatArea = mainChatArea;
    }

    public JMenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

    public void setQuitMenuItem(JMenuItem quitMenuItem) {
        this.quitMenuItem = quitMenuItem;
    }

    public JMenuItem getSetAwayChatItem() {
        return setAwayChatItem;
    }

    public void setSetAwayChatItem(JMenuItem setAwayChatItem) {
        this.setAwayChatItem = setAwayChatItem;
    }

    public JMenuItem getSettingsChatItem() {
        return settingsChatItem;
    }

    public void setSettingsChatItem(JMenuItem settingsChatItem) {
        this.settingsChatItem = settingsChatItem;
    }

    public JMenu getToolsMenu() {
        return toolsMenu;
    }

    public void setToolsMenu(JMenu toolsMenu) {
        this.toolsMenu = toolsMenu;
    }

    public JList getUserList() {
        return userList;
    }

    public void setUserList(JList userList) {
        this.userList = userList;
    }

    
    /**
     * Creates new form MainFrame
     */
    public static LookAndFeelInfo getLookAndFeel( final String lnfName )
	{
		LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();

		for ( LookAndFeelInfo lookAndFeelInfo : lookAndFeels )
		{
			if ( lookAndFeelInfo.getName().equals( lnfName ) )
			{
				return lookAndFeelInfo;
			}
		}

		return null;
	}
    public MainFrame() {
        try {
            initComponents();
            LookAndFeelInfo lookAndFeel = getLookAndFeel( "Windows" );

            if ( lookAndFeel != null )
                UIManager.setLookAndFeel( lookAndFeel.getClassName() );
            
            Runtime.getRuntime().addShutdownHook( new Thread( "ControllerShutdownHook" )
                    {
                            @Override
                            public void run()
                            {
                                    logOff(  );
                                                            }
                    } );
            resource = new SingletonUIResource(mainChatArea, jTextField1, userList);
            
            resource.getNetworkController().logOn();
                   ListSelectionListener listSelectionListener = new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        /** Get the particular element selected and act on it accordingly 
                         *  This method is still under Beta Phase and does not have any
                         *  reliability associated with it .This is sparta !!
                         */
                        boolean adjust = e.getValueIsAdjusting();
                        if(!adjust)
                        {
                            JList list = (JList) e.getSource() ;
                            int selections[] = list.getSelectedIndices() ;
                            Object selectionvalues[] = list.getSelectedValues() ;
                            for(int i = 0 ; i< selections.length ; i++)
                            {
                                userSelected = selectionvalues[i].toString();
                                System.out.println(userSelected);
                            }
                        }
                    }
                };
                userList.addListSelectionListener(listSelectionListener);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateUserList(DefaultListModel listModel)
    {
        if(listModel==null)
               throw new NullPointerException("the jlist is null");
        else 
            userList.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainChatArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        connectMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        clearChatMenuItem = new javax.swing.JMenuItem();
        setAwayChatItem = new javax.swing.JMenuItem();
        settingsChatItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutChatItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ServerLEssChat");

        mainChatArea.setColumns(20);
        mainChatArea.setEditable(false);
        mainChatArea.setRows(5);
        jScrollPane1.setViewportView(mainChatArea);

        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                userListMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userListMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(userList);

        jTextField1.setMaximumSize(new java.awt.Dimension(6, 2147483647));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Type Here");

        fileMenu.setText("File");

        connectMenuItem.setText("Reconnect");
        fileMenu.add(connectMenuItem);

        quitMenuItem.setText("Quit");
        fileMenu.add(quitMenuItem);

        jMenuBar1.add(fileMenu);

        toolsMenu.setText("Tools");

        clearChatMenuItem.setText("Clear Chat");
        toolsMenu.add(clearChatMenuItem);

        setAwayChatItem.setText("Set Away");
        setAwayChatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAwayChatItemActionPerformed(evt);
            }
        });
        toolsMenu.add(setAwayChatItem);

        settingsChatItem.setText("change nick");
        settingsChatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsChatItemActionPerformed(evt);
            }
        });
        toolsMenu.add(settingsChatItem);

        jMenuBar1.add(toolsMenu);

        helpMenu.setText("Help");

        aboutChatItem.setText("About");
        aboutChatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutChatItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutChatItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutChatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutChatItemActionPerformed
        Thread th = new Thread(){
                public void run()
                {
                      JFrame aboutFrame = new AboutFrame();
                      if(aboutFrame!=null){
                        aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        aboutFrame.setVisible(true);
                      }
                      else
                      {
                          System.out.println("About frame is null. Do something about it");
                      }
                }
            };
        th.start();
    }//GEN-LAST:event_aboutChatItemActionPerformed

    private void settingsChatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsChatItemActionPerformed
        
        Thread th = new Thread(){
                public void run()
                {
                      JFrame settingsFrame = new NickChangeFrame(Settings.getSettings().getMe().getNick(), resource);
                      settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                      settingsFrame.setVisible(true);
                }
            };
        th.start();
    }//GEN-LAST:event_settingsChatItemActionPerformed
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        resource.getChatTextFieldController().parseAndActOnMessage();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void setAwayChatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAwayChatItemActionPerformed
      if(!away)
      {
          away = true;
          resource.getMainChatController().writeToMainChat("You went away");
        resource.getNetworkController().sendIdleMessage();
        resource.getUserListController().setAway(Settings.getSettings().getMe().getCode(), true);
      }
      else
      {
          away = false;
          resource.getMainChatController().writeToMainChat("You came back");
          resource.getNetworkController().sendBackMessage();
          resource.getUserListController().setAway(Settings.getSettings().getMe().getCode(), false);
      }
    }//GEN-LAST:event_setAwayChatItemActionPerformed

    private void userListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMousePressed
                Point p = evt.getPoint();
			int index = userList.locationToIndex( p );

			if ( index != -1 )
			{
				Rectangle r = userList.getCellBounds( index, index );

				if ( r.x <= p.x && p.x <= r.x + r.width && r.y <= p.y && p.y <= r.y + r.height )
				{
					userList.setSelectedIndex( index );
				}

				else
				{
					userList.clearSelection();
				}
			}        
                    if(evt.isPopupTrigger()&&!userList.isSelectionEmpty())
                    {      PopUpMenu popUpMenu =  new PopUpMenu();
                       popUpMenu.showUser(evt.getComponent(), evt.getX(), evt.getY() , userSelected);}
    }//GEN-LAST:event_userListMousePressed

    private void userListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseReleased
        if(evt.isPopupTrigger()&&!userList.isSelectionEmpty())
                    {      PopUpMenu popUpMenu =  new PopUpMenu();
                       popUpMenu.showUser(evt.getComponent(), evt.getX(), evt.getY() , userSelected);}
    }//GEN-LAST:event_userListMouseReleased
    
    private void logOff()
    {
        resource.getNetworkController().sendLogoffMessage();       
    }
    
    private String userSelected = null ;
    private SingletonUIResource resource;
    private boolean away = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutChatItem;
    private javax.swing.JMenuItem clearChatMenuItem;
    private javax.swing.JMenuItem connectMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea mainChatArea;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JMenuItem setAwayChatItem;
    private javax.swing.JMenuItem settingsChatItem;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables

}
