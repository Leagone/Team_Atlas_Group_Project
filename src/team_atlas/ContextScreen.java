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
    JPanel MainConPanel;
    private JButton c7;
    private JButton c8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton C11;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;

    String conSelect;

    public ContextScreen(){



        C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C1";
               //AppHandler.startConSelectionScreen(conSelect);

            }
        });


        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C2";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C3";
                //AppHandler.startConSelectionScreen(conSelect);;
            }
        });


        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C4";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });


        C5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C5";
                //ppHandler.startConSelectionScreen(conSelect);
            }
        });


        C6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C6";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C7";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C8";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C9";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C10";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C11";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C12";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        C11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C13";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C14";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C15";
                // AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C16";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C17";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C18";
                // AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C19";
                //AppHandler.startConSelectionScreen(conSelect);
            }
        });

        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conSelect = "C20";
                // AppHandler.startConSelectionScreen(conSelect);
            }
        });



    }

}
