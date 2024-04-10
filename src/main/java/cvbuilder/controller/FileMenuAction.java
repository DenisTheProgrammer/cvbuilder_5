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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Denis
 */
public class FileMenuAction implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("open")) //test that all delete and edit work as intended, also test whether it still works when dummy file is moved inside the data folder :)
        {//open currently has an issue where files inside a folder cannot be opened, have a look at this
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir")); //opens a file chooser to the project directory
            int open = fileChooser.showOpenDialog(new JFrame()); //shows 1 on cancel and 0 on opening a file
            if(open == 0) 
            {
                MainViewer view = MainViewer.getInstance();
                view.setOpenFile(fileChooser.getSelectedFile());//gets the selected file and stores it
                //System.out.println(file);

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

                view.getAppFrame().revalidate();
                view.getAppFrame().repaint();
                view.displayGUI(view.getOpenFile().getName());//re populate the view with new content
                    
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
        else if(e.getActionCommand().equals("showCV"))
        {
            System.out.println("You are showing your CV");
            //the logic to show the cv goes in here
        }
        else if(e.getActionCommand().equals("saveCV"))
        {
            System.out.println("you are saving your CV");
            //the logic to save the cv goes here
        }
    }
    
}
