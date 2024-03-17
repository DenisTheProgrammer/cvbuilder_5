/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder;

import cvbuilder.controller.FileManager;
import cvbuilder.view.MainViewer;

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
        fileManager.contactInitialiser("contactStorer.csv");
        
        
        MainViewer view = MainViewer.getInstance();
        view.displayGUI();
    }
}
