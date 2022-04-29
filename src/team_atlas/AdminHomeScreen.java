package team_atlas;

import javax.swing.*;

/**
 * The admin home screen.
 * Only accessible if an admin logs into the application.
 * Contains four buttons that start the four admin panels,
 * and a button that logs the admin out.
 * @author Dominik Deak
 */
public class AdminHomeScreen {

    JPanel adminHomePanel;
    JLabel welcomeLabel;
    JButton studentProgressButton, overallProgressButton, pairHistoryButton, userDataButton, logoutButton;

    AdminHomeScreen() {
        System.out.println("Admin home panel started");
        studentProgressButton.addActionListener(e -> AppHandler.startStudentProgressScreen());
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        pairHistoryButton.addActionListener(e -> AppHandler.startPairHistoryScreen());
        userDataButton.addActionListener(e -> AppHandler.startUserDataMonitoringScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
