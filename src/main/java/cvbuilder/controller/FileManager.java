/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.User;
import cvbuilder.model.UserGroup;
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
        UserGroup uGroup = UserGroup.getInstance();
        try
            (
                FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);
                )
        {
            String line;
            while((line = reader.readLine()) != null)//while there are still lines to be read
            {
                String[] words = line.split(",");//split the words into an array
                User u = new User(words[0], words[1], words[2], words[3], words[4], words[5]);//plug the words into the constructor to create a new user
                uGroup.addUser(u);//add the user to the group
            }
        }
        
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}
