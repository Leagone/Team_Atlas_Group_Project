package team_atlas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Author Chris Sofroniou w1780164

public class LanguageScreen  {
    JButton italianButton;
    JButton russianButton;
    JButton frenchButton;
    JButton spanishButton;
    JButton germanButton;
    JButton portugeseButton;
    JPanel BluePanel;
    JPanel MainLangPanel;

    String langSelect;

    public LanguageScreen(){


        //listeners For the French Button

        frenchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               langSelect = "L4";
            }
        });

        //listeners For the Russian Button

        russianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langSelect = "L6";
            }
        });

        //listeners For the Spanish Button
        spanishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langSelect = "L1";
            }
        });

        //listeners For the Italian Button

        italianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langSelect = "L5";
            }
        });

        //listeners For the German Button

        germanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langSelect = "L2";
            }
        });

        //listeners For the Portugese Button

        portugeseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langSelect = "L3";
            }
        });
    }

}
