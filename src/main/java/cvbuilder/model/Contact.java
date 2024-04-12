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
    
    private String selectedPhoneNumber = "Please select a phone number";
    private String selectedAddress = "Please select an address";
    
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
    
    public String getSelectedPhoneNumber() {
        return selectedPhoneNumber;
    }

    public void setSelectedPhoneNumber(String selectedPhoneNumber) {
        this.selectedPhoneNumber = selectedPhoneNumber;
    }

    public String getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(String selectedAddress) {
        this.selectedAddress = selectedAddress;
    }
    
    //methods
    
    public void findSelected(String selected)
    {
        for(int i = 0; i<getPhoneNumber().size();i++)
        {
           if(getPhoneNumber().get(i).trim().equals(selected.trim()))
           {
               selectedPhoneNumber = selected;
           }
        }
        for(int i = 0; i<getAddress().size();i++)
        {
            if(getAddress().get(i).trim().equals(selected.trim()))
            {
                selectedAddress = selected;
            }
        }
    }

    
}
