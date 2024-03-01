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
public class UserGroup 
{
    private static UserGroup instance;
    private ArrayList<User> userGroup = new ArrayList<>();
    
    //constructor and singleton
    private UserGroup(){} //disable constructor to enforce the singleton pattern
    public static UserGroup getInstance()
    {
        if(instance == null)
        {
            instance = new UserGroup();
        }
        
        return instance;
    }
    
    //getters and setters

    public ArrayList<User> getUserGroup() 
    {
        return userGroup;
    }

    public void setUserGroup(ArrayList<User> userGroup) 
    {
        this.userGroup = userGroup;
    }
    
    public void addUser(User user)
    {
        userGroup.add(user);
    }
}
