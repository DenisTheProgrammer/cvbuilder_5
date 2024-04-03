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
}
