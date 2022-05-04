package team_atlas;

import javax.swing.*;
import java.util.*;

public class startUserSelectionScreen {

    private JButton backHome;
    private JButton Logout;
    public JPanel UserSelectionPanel;
    private JComboBox comboBox1;
    private JButton proceed;


    private ArrayList<Conversation> conversation;
    private ArrayList<User> avalibleUsers;

    private Set<String> avalibleUsersNames;
    private HashMap<String, String> avalibleUsersDetail;
    private String[]  avalibleUsersNamesArray;

    startUserSelectionScreen(ArrayList<Conversation> conversation) {

        this.conversation = conversation;

        backHome.addActionListener(e -> AppHandler.startAdminHomeScreen());
        Logout.addActionListener(e -> AppHandler.logout());
        proceed.addActionListener(e -> System.out.println("to be implemented"));
    }


    private void createUIComponents() {

        avalibleUsers = AppHandler.queryAllUsers();
        avalibleUsersDetail = new HashMap<>();
        avalibleUsersNames = new HashSet<>();


        for (int i = 0; i < avalibleUsers.size(); i++) {

            String userName = avalibleUsers.get(i).getFirstName() + " " + avalibleUsers.get(i).getLastName();
            String userEmail = avalibleUsers.get(i).getEmailAddress();
            avalibleUsersNames.add(userName);
            avalibleUsersDetail.put(userEmail, userName);

        }


        String[] arrayUsers = avalibleUsersNames.toArray(new String[0]);
        this.avalibleUsersNamesArray = arrayUsers;

        this.comboBox1 = new JComboBox(this.avalibleUsersNamesArray);

        comboBox1.addActionListener(e -> {

            String user = comboBox1.getSelectedItem().toString();


            String choosenStudenID = null;


            for (Map.Entry mapElement : avalibleUsersDetail.entrySet()){

                if(mapElement.getValue() == user){
                    choosenStudenID = (String) mapElement.getKey();
                }

            }

            System.out.println("Choosen student : " + choosenStudenID);


        });

    }

}
