package team_atlas;

import javax.swing.*;

/**
 * @author Dominik Deak
 */
public class AdminHomeScreen {

    JPanel adminHomePanel;
    JLabel welcomeLabel;
    JButton studentProgressButton;
    JButton overallProgressButton;
    JButton pairHistoryButton;
    JButton userDataButton;
    JButton logoutButton;

    AdminHomeScreen() {
        System.out.println("Admin home panel started");
        studentProgressButton.addActionListener(e -> AppHandler.startStudentProgressScreen());
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        pairHistoryButton.addActionListener(e -> AppHandler.startPairHistoryScreen());
        userDataButton.addActionListener(e -> AppHandler.startUserDataMonitoringScreen());
        logoutButton.addActionListener(e -> {
            System.out.println("Admin: '" + AppHandler.currentUser.getEmailAddress() + "' logged out");
            AppHandler.currentAdmin = null;
            AppHandler.startLoginScreen();
        });
    }
}
