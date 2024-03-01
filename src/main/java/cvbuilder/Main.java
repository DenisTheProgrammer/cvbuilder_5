/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder;

import cvbuilder.controller.FileManager;
import cvbuilder.model.UserGroup;

/**
 *
 * @author ndeni
 */
public class Main 
{
    public static void main(String[] args)
    {
        FileManager fileManager = new FileManager();
        fileManager.userInitialiser("userStorer.csv");
        
        UserGroup uGroup = UserGroup.getInstance();
        System.out.println(uGroup.getUserGroup());
    }
}
