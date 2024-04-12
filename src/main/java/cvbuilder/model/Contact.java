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
public class Contact 
{
    private static Contact instance;
    private ArrayList<String> phoneNumber = new ArrayList<>();
    private ArrayList<String> address = new ArrayList<>();
    
    //constructor and singleton
    private Contact(){}//disable constructor
    public static Contact getInstance()
    {
        if(instance == null)
        {
            instance = new Contact(); 
        }
        return instance;
    }

    //getters and setters

    public ArrayList<String> getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(ArrayList<String> phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String> getAddress() 
    {
        return address;
    }

    public void setAddress(ArrayList<String> address) 
    {
        this.address = address;
    }
    
    //methods
}
