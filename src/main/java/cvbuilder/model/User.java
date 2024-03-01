/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

/**
 *
 * @author ndeni
 */
public class User 
{
    private String userNumber;
    private String title;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    
    //constructor
    public User(String userNumber,String title, String name, String email, String phoneNumber, String address)
    {
        this.userNumber = userNumber;
        this.title = title;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    //getters and setters
    public String getUserNumber() 
    {
        return userNumber;
    }
    
    public void setUserNumber(String userNumber) 
    {
        this.userNumber = userNumber;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

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
    
    @Override
    public String toString()
    {
        return this.getUserNumber() + " " + this.getTitle() + " " + this.getName() + " " + this.getEmail()+ " " + this.getPhoneNumber() + " " + this.getAddress();
    }
    
}
