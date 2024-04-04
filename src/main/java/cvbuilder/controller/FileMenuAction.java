/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Denis
 */
public class FileMenuAction implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("open"))
        {
            System.out.println("You are trying to open");
            //code for the open menu goes here
        }
        else if(e.getActionCommand().equals("quit"))
        {
            System.out.println("You are trying to quit");
            //code for the quit menu goes here
        }
        else if (e.getActionCommand().equals("save"))
        {
            System.out.println("You are trying to save");
            //code for the save menu goes in here
        }
    }
    
}
