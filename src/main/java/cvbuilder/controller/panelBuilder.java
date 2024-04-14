/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import cvbuilder.view.MainViewer;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author ndeni
 */
public class panelBuilder 
{
    private ArrayList<JRadioButton> radButtons = new ArrayList<>();//storing the reference to the radio buttons here, will be useful later
    private ArrayList<JPanel> butPanStorer = new ArrayList<>(); //storing the references of the button panels in here
    private ArrayList<JPanel> panelStorer = new ArrayList<>(); //storing the reference to each panel
    private JCheckBox titleCheck = new JCheckBox("Include");
    
    //getters and setters

    public ArrayList<JRadioButton> getRadButtons() 
    {
        return radButtons;
    }

    public void setRadButtons(ArrayList<JRadioButton> radButtons) 
    {
        this.radButtons = radButtons;
    }

    public ArrayList<JPanel> getButPanStorer() 
    {
        return butPanStorer;
    }

    public void setButPanStorer(ArrayList<JPanel> butPanStorer) 
    {
        this.butPanStorer = butPanStorer;
    }

    public ArrayList<JPanel> getPanelStorer() {
        return panelStorer;
    }

    public void setPanelStorer(ArrayList<JPanel> panelStorer) {
        this.panelStorer = panelStorer;
    }

    public JCheckBox getTitleCheck() {
        return titleCheck;
    }

    public void setTitleCheck(JCheckBox titleCheck) {
        this.titleCheck = titleCheck;
    }
    
    
    //get instances of user and contact
    User user = User.getInstance();
    Contact contact = Contact.getInstance();
    
    
    //methods
    public void panSetUp(JPanel panel, String menu, String fileName)
    {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        for(int i = 0; i < (user.getTitle().size() + user.getName().size() + user.getEmail().size() + contact.getPhoneNumber().size() + contact.getAddress().size());i++)
        {
            JPanel boxPanel = new JPanel();
            JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
            butPanStorer.add(butPanel);//keep the reference of the panels
            JRadioButton selButton = null; //initiate the radio button
            if(menu.equals("title") && i < user.getTitle().size())
            {//figure out how to make the checkbox display before the radButtons
                if (i==0)
                {
                    boxPanel.add(titleCheck);
                }
                selButton = new JRadioButton(String.valueOf(user.getTitle().get(i))); //new Radio Button per attribute
                radButtons.add(selButton);
            }
            else if(menu.equals("name") && i < (user.getName().size() + user.getTitle().size()) && i > user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(user.getName().get(i - user.getTitle().size())); //new Radio Button per attribute
                radButtons.add(selButton);
            }
            else if(menu.equals("email") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size()) && i > user.getName().size() + user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(user.getEmail().get(i - (user.getName().size() + user.getTitle().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
            } 
            else if (menu.equals("phoneNumber") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size()) && i > user.getEmail().size() + user.getName().size() + user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(contact.getPhoneNumber().get(i - (user.getEmail().size() + user.getName().size() + user.getTitle().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
            }
            else if (menu.equals("address") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size() + contact.getAddress().size()) && i > user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size() - 1)
            {
                selButton = new JRadioButton(contact.getAddress().get(i - (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
            }
            else
            {
                int remButPan = butPanStorer.indexOf(butPanel);
                butPanStorer.remove(remButPan);
                continue;
            }
            
            JButton editButton = new JButton("Edit"); //creating the edit button
            JButton deleteButton = new JButton("Delete"); //creating the delete button
            
            editButton.addActionListener(new radListener(selButton, fileName, panel));//link the button to the class for functionality
            editButton.setActionCommand("edit"); //set the name of the action command
            
            deleteButton.addActionListener(new radListener(selButton, fileName, panel));//link the button to the class
            deleteButton.setActionCommand("delete");//set the name of the action command

            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(deleteButton);//add all the buttons to the panel

            panel.add(boxPanel,gbc);
            panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            panelStorer.add(panel);
            
        }
        
        //have a look at refactoring this when brain is fresh
        
        /*if(menu.equals("title"))
        {
            for(int i = 0; i < user.getTitle().size(); i++)
            {
                JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
                butPanStorer.add(butPanel);//keep the reference of the panels
                
                JRadioButton selButton = new JRadioButton(user.getTitle().get(i)); //new Radio Button per attribute
                radButtons.add(selButton);
                
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(deleteButton);//add all the buttons to the panel
                
                panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            }
        }
        else if(menu.equals("name"))
        {
            for(int i = 0; i < user.getName().size(); i++)
            {
                JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
                butPanStorer.add(butPanel);//keep the reference of the panels
                
                JRadioButton selButton = new JRadioButton(user.getName().get(i)); //new Radio Button per attribute
                radButtons.add(selButton);
                
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(deleteButton);//add all the buttons to the panel
                
                panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            }
        }
        else if(menu.equals("email"))
        {
            for(int i = 0; i < user.getEmail().size(); i++)
            {
                JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
                butPanStorer.add(butPanel);//keep the reference of the panels
                
                JRadioButton selButton = new JRadioButton(user.getEmail().get(i)); //new Radio Button per attribute
                radButtons.add(selButton);
                
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(deleteButton);//add all the buttons to the panel
                
                panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            }
        } 
        else if (menu.equals("phoneNumber"))
        {
            for(int i = 0; i < contact.getPhoneNumber().size(); i++)
            {
                JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
                butPanStorer.add(butPanel);//keep the reference of the panels
                
                JRadioButton selButton = new JRadioButton(contact.getPhoneNumber().get(i)); //new Radio Button per attribute
                radButtons.add(selButton);
                
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(deleteButton);//add all the buttons to the panel
                
                panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            }
        }
        else if (menu.equals("address"))
        {
            for(int i = 0; i < contact.getAddress().size(); i++)
            {
                JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
                butPanStorer.add(butPanel);//keep the reference of the panels
                
                JRadioButton selButton = new JRadioButton(contact.getAddress().get(i)); //new Radio Button per attribute
                radButtons.add(selButton);
                
                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(deleteButton);//add all the buttons to the panel
                
                panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            }
        }*/
    }
    
    private class radListener implements ActionListener
    {
        private JRadioButton selButton;
        private String fileName;
        private JPanel panel;

        //getters and setters
        public String getFileName() {
            return fileName;
        }
        
        public void setFileName(String fileName) {        
            this.fileName = fileName;
        }

        public JRadioButton getSelButton() {
            return selButton;
        }

        public void setSelButton(JRadioButton selButton) {
            this.selButton = selButton;
        }

        public JPanel getPanel() {
            return panel;
        }

        public void setPanel(JPanel panel) {
            this.panel = panel;
        }
        
        
        //constructor
        public radListener(JRadioButton selButton, String fileName, JPanel panel)//constructor that takes a parameter, see edit button
        {
            this.selButton = selButton;
            this.fileName = fileName;
            this.panel = panel;
        }
        
        //methods
        
        //file manager controller needs to be upgraded for Denis sake before continuing with functionality, maybe make the optimisation more readable:/
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equals("edit")) //handles the edit button
            {
                String input = JOptionPane.showInputDialog("Enter new text:",selButton.getText());//create a JOptionPane that allows user input
                                                                                                          //and displays the existing radio text
                //System.out.println(input);
                FileManager fileManager = new FileManager();
                fileManager.tempCreator(fileName, input, selButton.getText(),"modify"); //this function writes to the temporary file
                fileManager.overwriterFromTemp(fileName);

                selButton.setText(input);
                
                User user = User.getInstance();
                Contact contact = Contact.getInstance();//we get the instances of our model, ready to clear their attributes for re initialisation
                
                user.getTitle().clear(); //clear the title arrayList
                user.getName().clear(); //clear the name arrayList
                user.getEmail().clear(); //clear the email arrayList
                
                contact.getAddress().clear(); //clear the address arrayList
                contact.getPhoneNumber().clear(); //clear the phone number arrayList
                
                fileManager.classInitialiser(fileName); //we re initialise to keep the model in step with our view
            }
            else if(e.getActionCommand().equalsIgnoreCase("delete")) //handles the delete button
            {
                FileManager fileManager = new FileManager();//create a new instance of our fresh class
                fileManager.tempCreator(fileName, selButton.getText(), "", "delete");//this function modifies the temp file, removing the user deleted
                fileManager.overwriterFromTemp(fileName);//this overwrites the file

                User user = User.getInstance();
                Contact contact = Contact.getInstance();//we get the instances of our model, ready to clear their attributes for re initialisation
                
                user.getTitle().clear(); //clear the title arrayList
                user.getName().clear(); //clear the name arrayList
                user.getEmail().clear(); //clear the email arrayList
                
                contact.getAddress().clear(); //clear the address arrayList
                contact.getPhoneNumber().clear(); //clear the phone number arrayList

                fileManager.classInitialiser(fileName);//create the new version of the arrayList
                
                MainViewer app = MainViewer.getInstance();
                
                int indexRad = getRadButtons().indexOf(selButton);
                int indexPan = panelStorer.indexOf(panel);
                panelStorer.get(indexPan).remove(butPanStorer.get(indexRad));
                
                app.getUserTabs().revalidate();
                app.getContactTabs().revalidate();
                
                app.getUserTabs().repaint(); 
                app.getContactTabs().repaint();
            }
        }
        
    }
    
}
