package team_atlas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class startSubContextSelectionScreen {

    private JButton backHome;
    private JButton Logout;
    public JPanel MainSubConPanel;
    private JComboBox comboBox1;
    private JButton proceed;


    private ArrayList<Conversation> conversation;
    private ArrayList<Conversation> conversationtoPass;
    private Set<String> avalibleSubContext;
    private String[] stringSubContextArray;

    startSubContextSelectionScreen(ArrayList<Conversation> conversations) {

        this.conversation = conversations;

        backHome.addActionListener(e -> AppHandler.startAdminHomeScreen());
        Logout.addActionListener(e -> AppHandler.logout());
        proceed.addActionListener(e-> AppHandler.startLevelSelectionScreen(conversationtoPass));
    }


    private void createUIComponents() {

        avalibleSubContext = new HashSet<>();


        for (int i = 0; i < conversation.size(); i++) {

            String temp = conversation.get(i).getSubContextID();
            avalibleSubContext.add(temp);

        }


        String[] arrayContext = avalibleSubContext.toArray(new String[0]);
        this.stringSubContextArray = arrayContext;

        this.comboBox1 = new JComboBox(this.stringSubContextArray);

        comboBox1.addActionListener(e -> {

            String subConID = comboBox1.getSelectedItem().toString();

            this.conversationtoPass = new ArrayList<>();


            for (int i = 0; i < conversation.size(); i++) {

                if (conversation.get(i).getSubContextID() == subConID) {
                    this.conversationtoPass.add(conversation.get(i));
                }

            }


        });

    }

}
