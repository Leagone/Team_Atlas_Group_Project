package team_atlas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The class representing panel to select the context
 * Takes langId from Language Selection screen
 *
 * @author Andrzej Baum & Khadija Shahzad & Anas Samadi
 */

public class startContextSelectionScreen {

    public JPanel MainContextSelectionPanel;
    private JButton backHome;
    private JButton Logout;
    private JComboBox comboBox1;
    private JButton proceed;


    private final String langID;

    private ArrayList<Conversation> conversationtoPass;
    private ArrayList<Conversation> conversation;
    private Set<String> avalibleContext;
    private String[] stringContextArray;

    startContextSelectionScreen(String langID) {

        this.langID = langID;

        backHome.addActionListener(e -> AppHandler.startStudentHomeScreen());
        Logout.addActionListener(e -> AppHandler.logout());
        proceed.addActionListener(e -> AppHandler.startSubContextSelectionScreen(conversationtoPass));

    }


    private void createUIComponents() {

        avalibleContext = new HashSet<>();

        conversation = AppHandler.queryConversationOfLang(this.langID);

        for (int i = 0; i < conversation.size(); i++) {

            String temp = conversation.get(i).getContextID();
            avalibleContext.add(temp);

        }


        String[] arrayContext = avalibleContext.toArray(new String[0]);
        this.stringContextArray = arrayContext;

        this.comboBox1 = new JComboBox(this.stringContextArray);

        comboBox1.addActionListener(e -> {

            this.conversationtoPass = new ArrayList<>();

            String conID = comboBox1.getSelectedItem().toString();

            for (int i = 0; i < conversation.size(); i++) {

                if (conversation.get(i).getContextID() == conID) {
                    this.conversationtoPass.add(conversation.get(i));
                }

            }

        });

    }

}
