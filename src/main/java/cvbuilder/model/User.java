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
    
    private String selectedTitle = "Please select a title";
    private String selectedName = "Please select a name";
    private String selectedEmail = "Please select an email address";
    
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
    
    public String getSelectedTitle() {
        return selectedTitle;
    }

    public void setSelectedTitle(String selectedTitle) {
        this.selectedTitle = selectedTitle;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }

    public String getSelectedEmail() {
        return selectedEmail;
    }

    public void setSelectedEmail(String selectedEmail) {
        this.selectedEmail = selectedEmail;
    }
    
    //methods 
    public void findSelected(String selected)
    {
        //System.out.println("selected is " + selected);
        
         for (int i = 0; i<getTitle().size();i++)
         {
             if(getTitle().get(i).trim().equals(selected.trim()))
             {
                 setSelectedTitle(selected);
             }
         }
         
         for (int i = 0; i<getName().size();i++)
         {
             if(getName().get(i).trim().equals(selected.trim()))
             {
                 setSelectedName(selected);
             }
         }
         
         for(int i = 0; i<getEmail().size();i++)
         {
             if(getEmail().get(i).trim().equals(selected.trim()))
             {
                 setSelectedEmail(selected);
             }
         }
    }
    
    @Override
    public String toString()
    {
        return this.getTitle() + " " + this.getName() + " " + this.getEmail();
    }
    
}
