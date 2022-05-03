package team_atlas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Author Chris Sofroniou w1780164

public class ContextScreen  {
    JButton c4;
    JButton c2;
    JButton C1;
    JButton c3;
    JButton C5;
    JButton C6;
    JPanel BluePanel;
    JPanel MainLangPanel;
    private JButton c7;
    private JButton c8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;

    String conSelect;

    public ContextScreen(){


        //listeners For the French Button

        C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
               AppHandler.startConSelectionScreen(conSelect);

            }
        });

        //listeners For the Russian Button

        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });

        //listeners For the Spanish Button
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);;
            }
        });

        //listeners For the Italian Button

        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });

        //listeners For the German Button

        C5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });

        //listeners For the Portugese Button

        C6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });

        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });

        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
                AppHandler.startConSelectionScreen(conSelect);
            }
        });



    }

}
