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

    //getters and setters
    public ArrayList<JRadioButton> getRadButtons() {
        return radButtons;
    }

    public void setRadButtons(ArrayList<JRadioButton> radButtons) {
        this.radButtons = radButtons;
    }
    
    
    //constructor
    public FileMenuAction(ArrayList<JRadioButton> radButtons)
    {
        this.radButtons = radButtons;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("open"))
        {//finally test the open function on my laptop where the file path is correct to make sure the work around works
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
                view.getAddressPan().removeAll();//clear the content of all pans
                //view.getEndPan().removeAll(); - the bottom elements will also need to be removed for repainting when they get added

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
        else if (e.getActionCommand().equals("save")) //have a look whether you can find a way to save the file directly inside the data folder
        {
            FileManager fileManager = new FileManager();
            String newFileName = JOptionPane.showInputDialog("Enter the name of your new file");//displays an input window
            fileManager.fileSave(newFileName);
        }
        else if(e.getActionCommand().equals("showCV")) //need to make sure that when one radio button is selected the others de select
        {
            User user = User.getInstance();
            Contact contact = Contact.getInstance();
            
            String title = "";
            String name = "";
            
            for(int i = 0; i<radButtons.size();i++)
            {
                if(radButtons.get(i).isSelected() == true)
                {
                    user.findSelected(radButtons.get(i).getText());
                    
                }     
            }
            System.out.println("---------------------------------------------------");
            System.out.println("title: " + user.getSelectedTitle());
            System.out.println("name: " + user.getSelectedName());
            System.out.println("email: " + user.getSelectedEmail());
            System.out.println("---------------------------------------------------");
        }
        else if(e.getActionCommand().equals("saveCV"))
        {
            System.out.println("you are saving your CV");
            //the logic to save the cv goes here
        }
    }
    
}
