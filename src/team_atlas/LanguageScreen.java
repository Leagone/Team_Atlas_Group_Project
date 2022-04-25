package team_atlas;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageScreen  {
    private JButton italianButton;
    private JButton russianButton;
    private JButton frenchButton;
    private JButton spanishButton;
    private JButton germanButton;
    private JButton portugeseButton;
    public JPanel BluePanel;


   JPanel jp = new JPanel();

    public LanguageScreen(){

        jp.setSize(775, 250);

        //listeners For the French Button

        frenchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //listeners For the Russian Button

        russianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //listeners For the Spanish Button
        spanishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //listeners For the Italian Button

        italianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //listeners For the German Button

        germanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //listeners For the Portugese Button

        portugeseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}
