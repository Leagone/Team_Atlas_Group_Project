package team_atlas;

import javax.swing.*;

/**
 * Panel to display Informations about particular user
 *
 * @author Andrzej Baum
 */

public class UserDataMonitoringScreen {
    private JLabel emailAddresLabel;
    private JLabel userIDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel experienceLabel;
    private JLabel teacherLabel;
    private JLabel emailValue;
    private JLabel idValue;
    private JLabel fNameValue;
    private JLabel lNameValue;
    private JLabel expeValue;
    private JLabel teacherValue;
    private JButton Home;
    private JButton logOut;
    public JPanel MonitoringPanel;
    private JButton progress;
    private User currentUser;

    UserDataMonitoringScreen(String emailAddres){

        currentUser = AppHandler.queryUser(emailAddres);
        emailValue.setText(currentUser.getEmailAddress());
        idValue.setText(currentUser.getUserID());
        fNameValue.setText(currentUser.getLastName());
        lNameValue.setText(currentUser.getLastName());
        expeValue.setText(currentUser.getExperienceString());
        if(currentUser.isTeacher() == true){
            teacherValue.setText("Yes");
        }else{
            teacherValue.setText("No");
        }

        Home.addActionListener(e -> AppHandler.startStudentHomeScreen());
        logOut.addActionListener(e -> AppHandler.logout());
        progress.addActionListener(e -> AppHandler.startStudentProgressScreen(emailAddres));


    }


}
