/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ndeni
 */
public class FileManager 
{
    public void userInitialiser(String fileName)
    {
        User user = User.getInstance();
        try
            (
                FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);
                )
        {
            String line;
            int lineCounter = 0;
            while((line = reader.readLine()) != null)//while there are still lines to be read
            {
                lineCounter++;
                String[] words = line.split(",");//split the words into an array
                if(lineCounter == 1)
                {
                    for(String word : words)
                    {
                        user.getTitle().add(word);
                    }
                }
                else if(lineCounter == 2)
                {
                    for(String word : words)
                    {
                        user.getName().add(word);
                    }
                }
                else if(lineCounter == 3)
                {
                    for(String word : words)
                    {
                        user.getEmail().add(word);
                    }
                }
            }
        }
        
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void contactInitialiser(String fileName)
    {
        Contact contact = Contact.getInstance();
        try
            (
                FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);
                )
        {
            String line;
            int lineCounter = 0;
            while((line = reader.readLine()) != null)//while there are still lines to be read
            {
                lineCounter++;
                String[] words = line.split(",");//split the words into an array
                if(lineCounter == 1)
                {
                    for(String word : words)
                    {
                        contact.getPhoneNumber().add(word);
                    }
                }
                else if(lineCounter == 2)
                {
                    for(String word : words)
                    {
                        contact.getAddress().add(word);
                    }
                }
            }
        }
        
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}
