
package com.mnnit.server;

import com.mnnit.server.ui.MainFrame;
import javax.swing.JFrame;

/**
 *
 * @author Lakhan
 */
public class Main {
 
        public static void main ( String args[])
        {
            //Load UI
            Thread th = new Thread(){
                public void run()
                {
                      JFrame mainFrame = new MainFrame();
                      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      mainFrame.setVisible(true);
                }
            };
            th.start();    
        }
}
