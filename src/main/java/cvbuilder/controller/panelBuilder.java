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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ndeni
 */
public class panelBuilder 
{
    private ArrayList<JRadioButton> radButtons = new ArrayList<>();//storing the reference to the radio buttons here, will be useful later
    private ArrayList<JPanel> butPanStorer = new ArrayList<>(); //storing the references of the button panels in here
    private ArrayList<JPanel> panelStorer = new ArrayList<>(); //storing the reference to each panel
    private ArrayList<JTextField> inputStorer = new ArrayList<>();//storing the reference to the input fields
    
    private JCheckBox titleCheck = new JCheckBox("Include");//create a checkbox for the title menu
    private JCheckBox addressCheck = new JCheckBox("Include");//create a checkbox for the address menu
    
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

    public JCheckBox getAddressCheck() {
        return addressCheck;
    }

    public void setAddressCheck(JCheckBox addressCheck) {
        this.addressCheck = addressCheck;
    }

    public ArrayList<JTextField> getInputStorer() {
        return inputStorer;
    }

    public void setInputStorer(ArrayList<JTextField> inputStorer) {
        this.inputStorer = inputStorer;
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
            JPanel titleBoxPanel = new JPanel();
            JPanel addressBoxPanel = new JPanel();
            JPanel inputPanel = new JPanel();
            JPanel butPanel = new JPanel();//create a new panel to store each set of buttons
            butPanStorer.add(butPanel);//keep the reference of the panels
            JRadioButton selButton = null; //initiate the radio button
            JTextField textInput = null; //initialise the input field
            if(menu.equals("title") && i < user.getTitle().size())
            {//figure out how to make the checkbox display before the radButtons
                if (i==0)
                {
                    titleBoxPanel.add(titleCheck);
                }
                selButton = new JRadioButton(String.valueOf(user.getTitle().get(i))); //new Radio Button per attribute
                radButtons.add(selButton);
                if(i == user.getTitle().size() - 1)
                {
                    textInput = new JTextField(10); //create a new input field
                    inputStorer.add(textInput);
                    JButton addButton = new JButton("Add");
                    addButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,"title"));
                    addButton.setActionCommand("add");
                    inputPanel.add(textInput);
                    inputPanel.add(addButton);
                }
            }
            else if(menu.equals("name") && i < (user.getName().size() + user.getTitle().size()) && i > user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(user.getName().get(i - user.getTitle().size())); //new Radio Button per attribute
                radButtons.add(selButton);
                if(i == (user.getName().size() + user.getTitle().size()) - 1)
                {
                    textInput = new JTextField(10); //create a new input field
                    inputStorer.add(textInput);
                    JButton addButton = new JButton("Add");
                    addButton.setActionCommand("add");
                    addButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,"name"));
                    inputPanel.add(textInput);
                    inputPanel.add(addButton);
                }
            }
            else if(menu.equals("email") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size()) && i > user.getName().size() + user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(user.getEmail().get(i - (user.getName().size() + user.getTitle().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
                if(i == (user.getEmail().size() + user.getName().size() + user.getTitle().size()) - 1)
                {
                    textInput = new JTextField(10); //create a new input field
                    inputStorer.add(textInput);
                    JButton addButton = new JButton("Add");
                    addButton.setActionCommand("add");
                    addButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,"email"));
                    inputPanel.add(textInput);
                    inputPanel.add(addButton);
                }
            } 
            else if (menu.equals("phoneNumber") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size()) && i > user.getEmail().size() + user.getName().size() + user.getTitle().size() - 1)
            {
                selButton = new JRadioButton(contact.getPhoneNumber().get(i - (user.getEmail().size() + user.getName().size() + user.getTitle().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
                if(i == (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size()) - 1)
                {
                    textInput = new JTextField(10); //create a new input field
                    inputStorer.add(textInput);
                    JButton addButton = new JButton("Add");
                    addButton.setActionCommand("add");
                    addButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,"phoneNumber"));
                    inputPanel.add(textInput);
                    inputPanel.add(addButton);
                }
            }
            else if (menu.equals("address") && i < (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size() + contact.getAddress().size()) && i > user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size() - 1)
            {
                if (i == user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size())
                {
                    addressBoxPanel.add(addressCheck);
                }
                selButton = new JRadioButton(contact.getAddress().get(i - (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size()))); //new Radio Button per attribute
                radButtons.add(selButton);
                if(i == (user.getEmail().size() + user.getName().size() + user.getTitle().size() + contact.getPhoneNumber().size() + contact.getAddress().size()) - 1)
                {
                    textInput = new JTextField(10); //create a new input field
                    inputStorer.add(textInput);
                    JButton addButton = new JButton("Add");
                    addButton.setActionCommand("add");
                    addButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,"address"));
                    inputPanel.add(textInput);
                    inputPanel.add(addButton);
                }
            }
            else
            {
                int remButPan = butPanStorer.indexOf(butPanel);
                butPanStorer.remove(remButPan);
                continue;
            }
            
            JButton editButton = new JButton("Edit"); //creating the edit button
            JButton deleteButton = new JButton("Delete"); //creating the delete button
            
            editButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,""));//link the button to the class for functionality
            editButton.setActionCommand("edit"); //set the name of the action command
            
            deleteButton.addActionListener(new radListener(selButton, fileName, panel,inputStorer,""));//link the button to the class
            deleteButton.setActionCommand("delete");//set the name of the action command

            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(deleteButton);//add all the buttons to the panel

            
            panel.add(titleBoxPanel,gbc);
            panel.add(addressBoxPanel,gbc);
            panel.add(butPanel, gbc);//add the button panel to the main panel with gbc
            panel.add(inputPanel, gbc);
            panelStorer.add(panel);
            
        }
    }
    
    private class radListener implements ActionListener
    {
        private JRadioButton selButton;
        private String fileName;
        private JPanel panel;
        private ArrayList<JTextField> inputStorer = new ArrayList<>();
        private String id;

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

        public ArrayList<JTextField> getInputStorer() {
            return inputStorer;
        }

        public void setInputStorer(ArrayList<JTextField> inputStorer) {
            this.inputStorer = inputStorer;
        }
        
        //constructor
        public radListener(JRadioButton selButton, String fileName, JPanel panel, ArrayList<JTextField> inputStorer, String id)//constructor that takes a parameter, see edit button
        {
            this.selButton = selButton;
            this.fileName = fileName;
            this.panel = panel;
            this.inputStorer = inputStorer;
            this.id = id;
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
            else if(e.getActionCommand().equals("add"))
            {
                MainViewer view = MainViewer.getInstance();
                for(int i = 0; i<inputStorer.size();i++)
                {
                    if(!(inputStorer.get(i).getText().trim().equals("")))
                    {
                        FileManager fileManager = new FileManager();
                        int indexToCut = (view.getOpenFile().getAbsolutePath().indexOf("cvbuilder_5") + 12);//get the index for string manipulation
                        String openFileName = view.getOpenFile().getAbsolutePath().substring(indexToCut);
                        fileManager.addToTemp(openFileName, inputStorer.get(i).getText().trim(), id);
                        fileManager.overwriterFromTemp(openFileName);
                        inputStorer.get(i).setText("");
                        break;
                    }
                    else if(i == inputStorer.size()-1)
                    {
                        JOptionPane.showMessageDialog(null, "Please enter a valid value in the field", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
                
                User user = User.getInstance();
                Contact contact = Contact.getInstance();//we get the instances of our model, ready to clear their attributes for re initialisation
                
                user.getTitle().clear(); //clear the title arrayList
                user.getName().clear(); //clear the name arrayList
                user.getEmail().clear(); //clear the email arrayList
                
                contact.getAddress().clear(); //clear the address arrayList
                contact.getPhoneNumber().clear(); //clear the phone number arrayList

                FileManager fileManager = new FileManager();
                fileManager.classInitialiser(fileName);//create the new version of the model
                
                MainViewer app = MainViewer.getInstance();
                
                int indexToCut = (view.getOpenFile().getAbsolutePath().indexOf("cvbuilder_5") + 12);//get the index for string manipulation
                String openFileName = view.getOpenFile().getAbsolutePath().substring(indexToCut);//the file getter method only gets the file name and so gives error if the file is in a folder, this bypasses that
                
                app.getTitlePan().removeAll();
                app.getNamePan().removeAll();
                app.getEmailPan().removeAll();
                
                app.getPhonePan().removeAll();
                app.getAddressPan().removeAll();//clear the content of all panels
                
                panelBuilder builder = new panelBuilder();
                builder.panSetUp(app.getTitlePan(), "title", openFileName);
                builder.panSetUp(app.getNamePan(), "name", openFileName);
                builder.panSetUp(app.getEmailPan(), "email", openFileName);

                builder.panSetUp(app.getPhonePan(), "phoneNumber", openFileName);
                builder.panSetUp(app.getAddressPan(), "address", openFileName);//re build panels
                
                app.getUserTabs().revalidate();
                app.getContactTabs().revalidate();
                
                app.getUserTabs().repaint(); 
                app.getContactTabs().repaint();//revalidate and repaint to show all changes to user
            }
        }
        
    }
    
}
