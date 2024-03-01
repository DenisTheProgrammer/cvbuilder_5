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
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();
    
    //constructor
    public User(String title, String name, String email)
    {
        this.title.add(title);
        this.name.add(name);
        this.email.add(email);
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
