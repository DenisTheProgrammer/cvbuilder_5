/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder;

import cvbuilder.view.MainViewer;

/**
 *
 * @author ndeni
 */
public class Main 
{
    public static void main(String[] args)
    {
        MainViewer view = MainViewer.getInstance();
        view.displayGUI("data/cv_repo_5.csv");
    }
}
