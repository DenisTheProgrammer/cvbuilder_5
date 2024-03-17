/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.panelBuilder;
import cvbuilder.model.User;
import java.awt.BorderLayout;
import java.awt.Component;
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
    private JTabbedPane userTabs = new JTabbedPane();
    private JTabbedPane contactTabs = new JTabbedPane();
    private JPanel userPan = new JPanel();//this JPanel will hold user info
    private JPanel contactPan = new JPanel();//this JPanel will hold contact info
    private JPanel titlePan = new JPanel();
    private JPanel namePan = new JPanel();
    private JPanel emailPan = new JPanel();
    private JPanel phonePan = new JPanel();
    private JPanel addressPan = new JPanel();
    
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

    public JTabbedPane getMainTabs() 
    {
        return mainTabs;
    }

    public void setMainTabs(JTabbedPane mainTabs) 
    {
        this.mainTabs = mainTabs;
    }

    public JTabbedPane getUserTabs() 
    {
        return userTabs;
    }

    public void setUserTabs(JTabbedPane userTabs) 
    {
        this.userTabs = userTabs;
    }

    public JTabbedPane getContactTabs() 
    {
        return contactTabs;
    }

    public void setContactTabs(JTabbedPane contactTabs) 
    {
        this.contactTabs = contactTabs;
    }

    public JPanel getUserPan() 
    {
        return userPan;
    }

    public void setUserPan(JPanel userPan) 
    {
        this.userPan = userPan;
    }

    public JPanel getContactPan() 
    {
        return contactPan;
    }

    public void setContactPan(JPanel contactPan) 
    {
        this.contactPan = contactPan;
    }

    public JPanel getTitlePan() 
    {
        return titlePan;
    }

    public void setTitlePan(JPanel titlePan) 
    {
        this.titlePan = titlePan;
    }

    public JPanel getNamePan() 
    {
        return namePan;
    }

    public void setNamePan(JPanel namePan) 
    {
        this.namePan = namePan;
    }

    public JPanel getEmailPan() 
    {
        return emailPan;
    }

    public void setEmailPan(JPanel emailPan) 
    {
        this.emailPan = emailPan;
    }

    public JPanel getPhonePan() 
    {
        return phonePan;
    }

    public void setPhonePan(JPanel phonePan) 
    {
        this.phonePan = phonePan;
    }

    public JPanel getAddressPan() 
    {
        return addressPan;
    }

    public void setAddressPan(JPanel addressPan) 
    {
        this.addressPan = addressPan;
    }
    
    
    
    
    
    public void displayGUI()
    {
        appFrame.setName("CV-Builder");
        appFrame.setLayout(new BorderLayout());
        
        
        panelBuilder builder = new panelBuilder();
        builder.userPanSetUp(titlePan, "title", "userStorer.csv");
        builder.userPanSetUp(namePan, "name", "userStorer.csv");
        builder.userPanSetUp(emailPan, "email", "userStorer.csv");
        
        builder.contactPanSetUp(phonePan, "phoneNumber", "contactStorer.csv");
        builder.contactPanSetUp(addressPan, "address", "contactStorer.csv");
        
        
        
        mainTabs.addTab("User", userPan);
        mainTabs.addTab("Contact", contactPan);
        appFrame.add(mainTabs);
        userPan.setLayout(new BorderLayout());
        contactPan.setLayout(new BorderLayout());
        
        userPan.add(userTabs);
        userTabs.addTab("Title", titlePan);
        userTabs.addTab("Name", namePan);
        userTabs.addTab("Email", emailPan);
        
        contactPan.add(contactTabs);
        contactTabs.addTab("Phone", phonePan);
        contactTabs.addTab("Address", addressPan);
        
        appFrame.setSize(800, 500);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
