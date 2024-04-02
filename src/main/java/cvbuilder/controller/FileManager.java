/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.Contact;
import cvbuilder.model.User;
import java.io.BufferedReader;
import java.io.FileReader;
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
}
