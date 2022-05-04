package team_atlas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The class representing panel to select level of conversation
 * Takes Array list of Conversation objects from
 * sub context selection screen
 *
 * @author Andrzej Baum & Khadija Shahzad & Anas Samadi
 */

public class startLevelSelectionScreen {

    public JPanel MainLevelPanel;
    private JButton backHome;
    private JButton Logout;
    private JComboBox comboBox1;
    private JButton proceed;


    private final ArrayList<Conversation> conversation;
    private ArrayList<Conversation> conversationtoPass;
    private Set<String> avalibleLevels;
    private String[] stringSubContextArray;

    startLevelSelectionScreen(ArrayList<Conversation> conversations) {

        this.conversation = conversations;

        backHome.addActionListener(e -> AppHandler.startStudentHomeScreen());
        Logout.addActionListener(e -> AppHandler.logout());
        proceed.addActionListener(e -> AppHandler.startUserSelectionScreen(conversationtoPass));
    }


    private void createUIComponents() {

        avalibleLevels = new HashSet<>();


        for (int i = 0; i < conversation.size(); i++) {

            String temp = conversation.get(i).getLevelID();
            avalibleLevels.add(temp);

        }


        String[] arrayContext = avalibleLevels.toArray(new String[0]);
        this.stringSubContextArray = arrayContext;

        this.comboBox1 = new JComboBox(this.stringSubContextArray);

        comboBox1.addActionListener(e -> {

            String levelID = comboBox1.getSelectedItem().toString();

            this.conversationtoPass = new ArrayList<>();


            for (int i = 0; i < conversation.size(); i++) {

                if (conversation.get(i).getLevelID() == levelID) {
                    this.conversationtoPass.add(conversation.get(i));
                }

            }


        });

    }

}
