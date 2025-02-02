/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.FileManager;
import cvbuilder.controller.FileMenuAction;
import cvbuilder.controller.SectionSelector;
import cvbuilder.controller.panelBuilder;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    private JPanel endPan = new JPanel();
    
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem quit = new JMenuItem("Quit");
    
    private JMenu cv = new JMenu("CV");
    private JMenuItem showCV = new JMenuItem("Show CV");
    private JMenuItem saveCV = new JMenuItem("Save CV");
    
    private File openFile;
    
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

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JMenu getFile() {
        return file;
    }

    public void setFile(JMenu file) {
        this.file = file;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public void setOpen(JMenuItem open) {
        this.open = open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public void setSave(JMenuItem save) {
        this.save = save;
    }

    public JMenuItem getQuit() {
        return quit;
    }

    public void setQuit(JMenuItem quit) {
        this.quit = quit;
    }

    public JMenu getCv() {
        return cv;
    }

    public void setCv(JMenu cv) {
        this.cv = cv;
    }

    public JMenuItem getShowCV() {
        return showCV;
    }

    public void setShowCV(JMenuItem showCV) {
        this.showCV = showCV;
    }

    public JMenuItem getSaveCV() {
        return saveCV;
    }

    public void setSaveCV(JMenuItem saveCV) {
        this.saveCV = saveCV;
    }

    public File getOpenFile() {
        return openFile;
    }

    public void setOpenFile(File openFile) {
        this.openFile = openFile;
    }

    public JPanel getEndPan() {
        return endPan;
    }

    public void setEndPan(JPanel endPan) {
        this.endPan = endPan;
    }
    
    
    
    //methods
    public void displayGUI(String fileName)
    {
        appFrame.setName("CV-Builder");
        appFrame.setLayout(new BorderLayout());
        
        //this is the file menu at the top of the page
        menu.add(file);
        menu.add(cv);
        
        file.add(open);
        file.add(save);
        file.add(quit);
        
        cv.add(showCV);
        cv.add(saveCV);//add an action function and link both of these
        
        appFrame.add(menu, BorderLayout.PAGE_START);
        
        //here is the file initiation for the view
        
        FileManager fileManager = new FileManager();
        fileManager.classInitialiser(fileName);
        
        //building panels
        panelBuilder builder = new panelBuilder();
        
        builder.panSetUp(titlePan, "title", fileName, "Title");
        builder.panSetUp(namePan, "name", fileName, "Name");
        builder.panSetUp(emailPan, "email", fileName, "Email");
        
        builder.panSetUp(phonePan, "phoneNumber", fileName, "Phone");
        builder.panSetUp(addressPan, "address", fileName, "Address");
        
        //adding action listeners to all the menu with a reference to all the radio buttons available
        FileMenuAction fileMenuAction = new FileMenuAction(builder.getRadButtons(), builder.getTitleCheck(), builder.getAddressCheck());
        
        open.addActionListener(fileMenuAction);
        open.setActionCommand("open");
        
        save.addActionListener(fileMenuAction);
        save.setActionCommand("save");
        
        quit.addActionListener(fileMenuAction);
        quit.setActionCommand("quit");
        
        showCV.addActionListener(fileMenuAction);
        showCV.setActionCommand("showCV");
        
        saveCV.addActionListener(fileMenuAction);
        saveCV.setActionCommand("saveCV");
        
        
        //add tabs to the main tabs holder then to the frame and set layout
        mainTabs.addTab("User", userPan);
        mainTabs.addTab("Contact", contactPan);
        appFrame.add(mainTabs);
        userPan.setLayout(new BorderLayout());
        contactPan.setLayout(new BorderLayout());
        
        //add the panels to their respective tab menu
        userPan.add(userTabs);
        userTabs.addTab("Title", titlePan);
        userTabs.addTab("Name", namePan);
        userTabs.addTab("Email", emailPan);
        
        contactPan.add(contactTabs);
        contactTabs.addTab("Phone", phonePan);
        contactTabs.addTab("Address", addressPan);
        
        //get the buttons at the bottom of the page and add them
        
        JButton prevSection = new JButton("Prev Section");
        JButton nextSection = new JButton("Next Section");//create the previous and next buttons
        
        prevSection.addActionListener(new SectionSelector());
        nextSection.addActionListener(new SectionSelector());
        
        prevSection.setActionCommand("previous");
        nextSection.setActionCommand("next");
        
        endPan.add(prevSection);
        endPan.add(nextSection);//add buttons to their panel
        appFrame.add(endPan, BorderLayout.PAGE_END);
        
        openFile = new File(fileName);
        
        //set the frame - always do this at the end
        appFrame.setSize(900, 600);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
