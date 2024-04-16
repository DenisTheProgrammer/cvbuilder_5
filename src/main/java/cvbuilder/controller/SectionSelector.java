/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.view.MainViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Denis
 */
public class SectionSelector implements ActionListener
{
    MainViewer view = MainViewer.getInstance();
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("previous"))
        {
            if(view.getMainTabs().getSelectedIndex()>0)//if we are not on the first tab
            {
                view.getMainTabs().setSelectedIndex(view.getMainTabs().getSelectedIndex() - 1);//change to previous tab
            }
        }
        else if(e.getActionCommand().equals("next"))
        {
            if(view.getMainTabs().getSelectedIndex() < view.getMainTabs().getTabCount() - 1)//if we are not on the last tab
            {
                view.getMainTabs().setSelectedIndex(view.getMainTabs().getSelectedIndex() + 1);//go to the next tab
            }
        }
    }
    
}
