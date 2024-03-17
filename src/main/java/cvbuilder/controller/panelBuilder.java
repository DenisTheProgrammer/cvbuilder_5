/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
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
    
    //getters and setters

    public ArrayList<JRadioButton> getRadButtons() 
    {
        return radButtons;
    }

    public void setRadButtons(ArrayList<JRadioButton> radButtons) 
    {
        this.radButtons = radButtons;
    }
    
    //get instances of user and contact
    User user = User.getInstance();
    Contact contact = Contact.getInstance();
    
    
    //methods
    public void userPanSetUp(JPanel panel, String menu, String fileName)
    {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        if(menu.equals("title"))
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
    }
    
    public void contactPanSetUp(JPanel panel, String menu, String fileName)
    {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        if (menu.equals("phoneNumber"))
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
        }
    }
}
