/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

/**
 *
 * @author ndeni
 */
public class Contact 
{
    private String phoneNumber;
    private String address;
    
    //constructor
    public Contact(String phoneNumber, String address)
    {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    //getters and setters

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }
    
}
