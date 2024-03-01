/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author ndeni
 */
public class MainViewer 
{
    private static MainViewer instance;
    private JFrame appFrame = new JFrame();
    private JTabbedPane mainTabs = new JTabbedPane();//this will be the main tabbed pane
    private JPanel userPan = new JPanel();//this JPanel will hold user info
    private JPanel contactPan = new JPanel();//this JPanel will hold contact info
    
    //constructor + singleton
    private MainViewer(){}//disable constructor to enforce singleton
    
    public static MainViewer getInstance()//singleton means I can only have 1 view and 1 view only
    {
        if(instance == null)
        {
            instance = new MainViewer();
        }
        
        return instance;
    }
    
    //getters and setters
    public JFrame getAppFrame() 
    {
        return appFrame;
    }

    public void setAppFrame(JFrame appFrame) 
    {
        this.appFrame = appFrame;
    }
    
    
    
    public void displayGUI()
    {
        appFrame.setName("CV-Builder");
        
        
        mainTabs.addTab("User", userPan);
        mainTabs.addTab("Contact", contactPan);
        appFrame.add(mainTabs);
        
        appFrame.setSize(800, 500);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
