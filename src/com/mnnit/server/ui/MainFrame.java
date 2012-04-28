/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.ui;

import com.mnnit.server.model.SingletonUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
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
    
    public MainFrame() {
        initComponents();
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
        
        
        /* adding the mouse listener to the list */
        userList.addMouseListener(new MouseAdapter() {
               public void mousePressed(MouseEvent e)
               {
                   if(e.isPopupTrigger())
                       doPop(e);
               }
               
               public void mouseReleased(MouseEvent e)
               {
                   if(e.isPopupTrigger())
                       doPop(e);
               }
               
               public void doPop(MouseEvent e)
               {
                   PopUpMenu popUpMenu =  new PopUpMenu();
                   popUpMenu.showUser(e.getComponent(), e.getX(), e.getY() , userSelected);
               }
            });       
               ListSelectionListener listSelectionListener = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    /** Get the particular element selected and act on it accordingly 
                     *  This method is still under Beta Phase and does not have any
                     *  reliability associated with it .This is sparta !!
                     */
                    System.out.println("first selection : " + e.getFirstIndex());
                    System.out.println("last selection : " + e.getLastIndex());
                    
                    boolean adjust = e.getValueIsAdjusting();
                    System.out.println(" adjusting ? "+ adjust);
                    if(!adjust)
                    {
                        JList list = (JList) e.getSource() ;
                        int selections[] = list.getSelectedIndices() ;
                        Object selectionvalues[] = list.getSelectedValues() ;
                        for(int i = 0 ; i< selections.length ; i++)
                        {
                            if(i==0)
                                System.out.println("Selections :");
                            System.out.println(selections[i]+ "/"+ selectionvalues[i]);
                            userSelected = (String) selectionvalues[i];
                        }
                    }
                }
            };
            userList.addListSelectionListener(listSelectionListener);
    }
    
    public void populateUserList(DefaultListModel listModel)
    {
        if(listModel==null)
               throw new NullPointerException("the jlist is null");
        else 
            userList.setModel(listModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
                      JFrame settingsFrame = new SettingsFrame();
                      settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                      settingsFrame.setVisible(true);
                }
            };
        th.start();
    }//GEN-LAST:event_settingsChatItemActionPerformed
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        resource.getChatTextFieldController().parseAndActOnMessage();
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    private void logOff()
    {
        resource.getNetworkController().sendLogoffMessage();
        
    }
    
    private String userSelected = null ;
    private SingletonUIResource resource;
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
