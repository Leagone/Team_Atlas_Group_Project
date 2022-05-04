package team_atlas;

import javax.swing.*;

/**
 * The admin home screen.
 * Only accessible if an admin logs into the application.
 * Contains four buttons that start the four admin panels,
 * and a button that logs the admin out.
 *
 * @author Dominik Deak, Andrzej Baum
 */
public class AdminHomeScreen {

    JPanel adminHomePanel;
    JLabel welcomeLabel;
    JButton studentProgressButton, overallProgressButton, pairHistoryButton, userDataButton, logoutButton;
    JTextField studentEmailField, userEmailField;
    String textFieldValue4;

    AdminHomeScreen() {
        System.out.println("Admin home panel started");
        studentProgressButton.addActionListener(e -> {
            String textFieldValue = studentEmailField.getText();
            AppHandler.startStudentProgressScreen(textFieldValue);
        });
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        pairHistoryButton.addActionListener(e -> AppHandler.startPairHistoryScreen());
        userDataButton.addActionListener(e -> {
            textFieldValue4 = userEmailField.getText();
            AppHandler.startUserDataMonitoringScreen(textFieldValue4);
        });
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
