/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author ndeni
 */
public class FileManager 
{
    public void classInitialiser(String fileName)
    {
        User user = User.getInstance();
        Contact contact = Contact.getInstance();
        try
            (
                FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);
                )
        {
            String line;
            int lineCounter = 0;
            ArrayList<String> sepWords = new ArrayList<>();
            while((line = reader.readLine()) != null)//while there are still lines to be read
            {
                lineCounter++;
                String[] words = line.split(",");//split the words into an array
                for (int i = 0; i < words.length; i++)
                {
                    sepWords.add(words[i]);
                }

                sepWords.remove(0);
                sepWords.remove(0); 

                if(lineCounter == 2)
                {
                    for(String word : sepWords)
                    {
                        user.getName().add(word);
                    }
                }
                else if(lineCounter == 3)
                {
                    for(String word : sepWords)
                    {
                        user.getTitle().add(word);
                    }
                }
                else if(lineCounter == 4)
                {
                    for(String word : sepWords)
                    {
                        user.getEmail().add(word);
                    }
                }
                else if(lineCounter == 5)
                {
                    for(String word : sepWords)
                    {
                        contact.getPhoneNumber().add(word);
                    }
                }
                else if(lineCounter == 6)
                {
                    for(String word : sepWords)
                    {
                        String cleanWord = word.replaceAll("%", " ").replaceAll("/", " ");
                        contact.getAddress().add(cleanWord);

                    }
                }
                
                sepWords.clear();
            }
        }
        
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void tempCreator(String fileName, String change, String comparator, String choice)
    {
        if (choice.equals("modify"))  //just for completion handle the case when the change is empty string
        {
            try //this will be used to create a new temporary file where the modified content is written
                (
                    FileReader file = new FileReader(fileName);
                    BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                    FileWriter myFile = new FileWriter("data/temp.csv");
                    BufferedWriter writer = new BufferedWriter(myFile);
                )
                {    
                    String line;
   
                   while ((line = b.readLine()) != null)
                    {
                        String[] details = line.split(",");
                        for(int i = 0; i < details.length; i ++)
                        {
                            String filterDetails = details[i].replaceAll("%", " ").replaceAll("/", " ");
                            if(!(change.equals(comparator)))
                            {
                               if (comparator.equals(filterDetails))
                               {
                                   if(i == (details.length - 1))
                                    {
                                        writer.write(change); 
                                        break;
                                    }
                        
                                    else
                                    {
                                        writer.write(change + ","); 
                                        i++;
                                    }
                               }
                            }
                            
                           
                            if(i == (details.length - 1))
                            {
                                writer.write(details[i]);  
                            }
                        
                            else
                            {   
                                writer.write(details[i]+","); 
                            }  
                            
                        }
                    
                        writer.newLine();
                    }                      
                     
                }
                catch(Exception s)
                {
                    s.printStackTrace();
                }
        }
        
        else if(choice.equals("delete")) 
        {
       
       
            try(    FileReader file = new FileReader(fileName); //this block deletes one user from the file
                    BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                    FileWriter myFile = new FileWriter("data/temp.csv");
                    BufferedWriter writer = new BufferedWriter(myFile);)
            {
                String line;
   
                while ((line = b.readLine()) != null)
                {
                    String decision = "";
                    String[] words = line.split(",");
                    
                    for (int i = 0; i < words.length; i++)
                    {
                        String filterWords = words[i].replaceAll("%", " ").replaceAll("/", " ");
                        if(change.equals(filterWords))
                        {
                            continue;
                        }
                        else
                        {
                            if(i == (words.length - 1))
                            {
                                writer.write(words[i]); 
                            }
                        
                            else
                            {   
                                writer.write(words[i]+","); 
                            } 
                        }
                    }
                    writer.newLine();           
                }
           
            }
       
            catch(Exception b)
            {
                b.printStackTrace();
            }
        }
        
        else
        {
            System.out.println("You have entered the wrong String for your choise parameter");
        }       
    }
    
    
    public void overwriterFromTemp(String fileName)
    {
       try //this writes the content of the temporary file inside the main file
                (
                    FileReader temp = new FileReader("data/temp.csv");
                    BufferedReader t = new BufferedReader(temp); //initialise file and buffered reader
                    FileWriter userProfile = new FileWriter(fileName);
                    BufferedWriter user = new BufferedWriter(userProfile);
                )
                {

                    String replace;
                    while((replace = t.readLine()) != null)
                    {
                        String[] words = replace.split(",");
                        for(int i = 0; i < words.length; i++)
                        {
                            if(i == (words.length - 1))
                            {
                                user.write(words[i]); 
                            }
                            else
                            {   
                                user.write(words[i] + ",");
                            }                
                        }
                        
                        user.newLine();
                    }
                }
                
                catch(Exception x)
                {
                    x.printStackTrace();
                } 
    }
    
    public void fileSave(String name)
    {
        try
        (
            FileWriter newFile = new FileWriter("savedFiles/" + name + ".csv");//give a name to the new file
            BufferedWriter writer = new BufferedWriter(newFile); 
        )
        {
            User user = User.getInstance();
            Contact contact = Contact.getInstance();
            
            writer.write("Section,Sub-Section,Variants");
            writer.newLine();
            
            writer.write("User,Name,");
            for(int i = 0; i < user.getName().size();i++)
            {
                if(i == user.getName().size() - 1)
                {
                    writer.write(user.getName().get(i));
                }
                else
                {
                    writer.write(user.getName().get(i)+",");
                }
            }
            
            writer.newLine();
            
            writer.write("User,Title,");
            for(int i = 0; i<user.getTitle().size();i++)
            {
                if(i == user.getTitle().size() - 1)
                {
                    writer.write(user.getTitle().get(i));
                }
                else
                {
                    writer.write(user.getTitle().get(i) + ",");
                }
            }
            
            writer.newLine();
            
            writer.write("User,Email,");
            for(int i = 0; i<user.getEmail().size();i++)
            {
                if(i == user.getEmail().size()-1)
                {
                    writer.write(user.getEmail().get(i));
                }
                else
                {
                    writer.write(user.getEmail().get(i)+",");
                }
            }
            
            writer.newLine();
            
            writer.write("Contact Information,Phone,");
            for(int i = 0 ; i<contact.getPhoneNumber().size();i++)
            {
                if(i==contact.getPhoneNumber().size()-1)
                {
                    writer.write(contact.getPhoneNumber().get(i));
                }
                else
                {
                    writer.write(contact.getPhoneNumber().get(i)+",");
                }
            }
            
            writer.newLine();
            
            writer.write("Contact Information,Address,");
            for(int i = 0;i<contact.getAddress().size();i++)
            {
                if(i==contact.getAddress().size()-1)
                {
                    writer.write(contact.getAddress().get(i));
                }
                else
                {
                    writer.write(contact.getAddress().get(i)+",");
                }
            }
        }
        
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }
    
    public void cvSave(String name, ArrayList<JRadioButton> radButtons, JCheckBox titleCheck, JCheckBox addressCheck)
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
           
        if(titleCheck.isSelected() == true && user.getSelectedTitle().equals("Please select a title"))
        {
            JOptionPane.showMessageDialog(null, "Please select a title", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(user.getSelectedName().equals("Please select a name"))
        {
            JOptionPane.showMessageDialog(null, "Please select a name", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(user.getSelectedEmail().equals("Please select an email address"))
        {
            JOptionPane.showMessageDialog(null, "Please select an email address", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(contact.getSelectedPhoneNumber().equals("Please select a phone number"))
        {
            JOptionPane.showMessageDialog(null, "Please select a phone number", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(addressCheck.isSelected() == true && contact.getSelectedAddress().equals("Please select an address"))
        {
            JOptionPane.showMessageDialog(null, "Please select an address", "Error", JOptionPane.WARNING_MESSAGE);

        }
        else
        {
            try
            (
             FileWriter newFile = new FileWriter("savedCVs/" + name + ".csv");//give a name to the new file
             BufferedWriter writer = new BufferedWriter(newFile); 
                )
            {
                if(titleCheck.isSelected() == true)
                {
                   writer.write("title: " + user.getSelectedTitle()); 
                   writer.newLine();
                }
                writer.write("name: " + user.getSelectedName());
                writer.newLine();
                writer.write("email: " + user.getSelectedEmail());
                writer.newLine();
                writer.write("phone number: " + contact.getSelectedPhoneNumber());
                writer.newLine();
                if(addressCheck.isSelected() == true)
                {
                    writer.write("address: " + contact.getSelectedAddress());
                }
            }
            catch(Exception x)
            {
                x.printStackTrace();
            }
        }
    }
    
    public void addToTemp(String fileName, String input, String id)
    {
        try //this will be used to create a new temporary file where the modified content is written
                (
                    FileReader file = new FileReader(fileName);
                    BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                    FileWriter myFile = new FileWriter("data/temp.csv");
                    BufferedWriter writer = new BufferedWriter(myFile);
                )
                {    
                    String line;
                    int lineCounter = 0;
   
                   while ((line = b.readLine()) != null)
                    {
                        lineCounter ++;
                        if(!(lineCounter==1))
                        {
                            writer.newLine();
                        }
                        String[] words = line.split(",");
                        for(int i = 0; i < words.length; i ++)
                        {
                            String filterWords = words[i].replaceAll("%", " ").replaceAll("/", " ");
                            if(lineCounter == 1)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                            }
                            else if(lineCounter == 3)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                                
                                if(id.equals("title")&& i == words.length - 1)
                                {
                                    writer.write("," + input);
                                }
                            }
                            else if(lineCounter == 2)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                                
                                if(id.equals("name")&& i == words.length - 1)
                                {
                                    writer.write("," + input);
                                } 
                            }
                            else if(lineCounter == 4)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                                
                                if(id.equals("email")&& i == words.length - 1)
                                {
                                    writer.write("," + input);
                                }
                            }
                            else if(lineCounter == 5)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                                
                                if(id.equals("phoneNumber")&& i == words.length - 1)
                                {
                                    writer.write("," + input);
                                }
                            }
                            else if(lineCounter == 6)
                            {
                                if(i == words.length - 1)
                                {
                                    writer.write(filterWords); 
                                }
                                else
                                {
                                   writer.write(filterWords+","); 
                                }
                                
                                if(id.equals("address")&& i == words.length - 1)
                                {
                                    writer.write("," + input);
                                }
                            }
                        }
                    }
                }
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }
 }

