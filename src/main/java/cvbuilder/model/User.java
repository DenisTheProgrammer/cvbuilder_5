/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import java.util.ArrayList;

/**
 *
 * @author ndeni
 */
public class User 
{
    private static User instance;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();
    
    //constructor and singleton
    private User(){}//disable constructor
    
    public static User getInstance()//get instance
    {
        if(instance == null)
        {
            instance = new User();
        }
        return instance;
    }

    //getters and setters

    public ArrayList<String> getTitle() 
    {
        return title;
    }

    public void setTitle(ArrayList<String> title) 
    {
        this.title = title;
    }

    public ArrayList<String> getName() 
    {
        return name;
    }

    public void setName(ArrayList<String> name) 
    {
        this.name = name;
    }

    public ArrayList<String> getEmail() 
    {
        return email;
    }

    public void setEmail(ArrayList<String> email) 
    {
        this.email = email;
    }
    
    @Override
    public String toString()
    {
        return this.getTitle() + " " + this.getName() + " " + this.getEmail();
    }
    
}
