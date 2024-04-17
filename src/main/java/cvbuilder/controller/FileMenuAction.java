/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import cvbuilder.view.MainViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Denis
 */
public class FileMenuAction implements ActionListener
{
    private ArrayList<JRadioButton> radButtons = new ArrayList<>(); //I will be using this to bring the reference to all radio buttons for the purpose of building the CV
    private JCheckBox titleCheck = new JCheckBox();//using this to bring the title check box here to get its status
    private JCheckBox addressCheck = new JCheckBox();//using this to bring the address check box here to get its status
    //getters and setters
    public ArrayList<JRadioButton> getRadButtons() {
        return radButtons;
    }

    public void setRadButtons(ArrayList<JRadioButton> radButtons) {
        this.radButtons = radButtons;
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
    
    //constructor
    public FileMenuAction(ArrayList<JRadioButton> radButtons, JCheckBox titleCheck, JCheckBox addressCheck)
    {
        this.radButtons = radButtons;
        this.titleCheck = titleCheck;
        this.addressCheck = addressCheck;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("open"))
        {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir")); //opens a file chooser to the project directory
            int open = fileChooser.showOpenDialog(new JFrame()); //shows 1 on cancel and 0 on opening a file
            if(open == 0) 
            {
                MainViewer view = MainViewer.getInstance();

                view.setOpenFile(fileChooser.getSelectedFile());//gets the selected file and stores it

                User user = User.getInstance();
                Contact contact = Contact.getInstance();//we get the instances of our model, ready to clear their attributes for re initialisation
                
                user.getTitle().clear(); //clear the title arrayList
                user.getName().clear(); //clear the name arrayList
                user.getEmail().clear(); //clear the email arrayList
                
                contact.getAddress().clear(); //clear the address arrayList
                contact.getPhoneNumber().clear(); //clear the phone number arrayList

                
                view.getTitlePan().removeAll();
                view.getNamePan().removeAll();
                view.getEmailPan().removeAll();
                view.getPhonePan().removeAll();
                view.getAddressPan().removeAll();
                view.getEndPan().removeAll();//clear the content of all pans

                view.getAppFrame().getContentPane().removeAll();//remove all content from the view
                
                view.getOpen().removeActionListener(this);
                view.getSave().removeActionListener(this);
                view.getQuit().removeActionListener(this);
                view.getShowCV().removeActionListener(this);
                view.getSaveCV().removeActionListener(this);
 
                view.getAppFrame().revalidate();
                view.getAppFrame().repaint();
                int indexToCut = (view.getOpenFile().getAbsolutePath().indexOf("cvbuilder_5") + 12);//get the index for string manipulation
                String fileName = view.getOpenFile().getAbsolutePath().substring(indexToCut);//the file getter method only gets the file name and so gives error if the file is in a folder, this bypasses that
                view.displayGUI(fileName);//re populate the view with new content
                    
            }
            else
            {
                System.out.println("Open file cancelled");
            }
                
        }
        else if(e.getActionCommand().equals("quit"))
        {
            System.exit(0); //exits app
        }
        else if (e.getActionCommand().equals("save"))
        {
            FileManager fileManager = new FileManager();
            String newFileName = JOptionPane.showInputDialog("Enter the name of your new file");//displays an input window
            if(newFileName == null)
            {
                System.out.println("File save cancelled");
            }
            else if(newFileName.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid name in the field", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                fileManager.fileSave(newFileName); 
            }
        }
        else if(e.getActionCommand().equals("showCV")) //need to make sure that when one radio button is selected the others de-select
        { 
            User user = User.getInstance();
            Contact contact = Contact.getInstance();
            
            for(int i = 0; i<radButtons.size();i++)//loop through the arraylist containing the reference to all radio buttons
            {
                if(radButtons.get(i).isSelected() == true)//check if the radio button is selected
                {
                    user.findSelected(radButtons.get(i).getText());
                    contact.findSelected(radButtons.get(i).getText());//if so run the function which cheks whether the selected radio button is part of the mofel and prints it
                }     
            }
            System.out.println("---------------------------------------------------");           
            if(titleCheck.isSelected() == true)
            {
                System.out.println("title: " + user.getSelectedTitle());
            }
            System.out.println("name: " + user.getSelectedName());
            System.out.println("email: " + user.getSelectedEmail());
            System.out.println("phone number: " + contact.getSelectedPhoneNumber());
            if(addressCheck.isSelected() == true)
            {
                System.out.println("address: " + contact.getSelectedAddress());
            }
            System.out.println("---------------------------------------------------");
        }
        else if(e.getActionCommand().equals("saveCV"))
        {
            FileManager fileManager = new FileManager();
            String newFileName = JOptionPane.showInputDialog("Enter the name of your new CV");//displays an input window for the name of the new cv
            if(newFileName == null)
            {
                System.out.println("File save cancelled");
            }
            else if(newFileName.trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid name in the field", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                fileManager.cvSave(newFileName, radButtons, titleCheck, addressCheck);
            }
            
        }
    }
    
}
