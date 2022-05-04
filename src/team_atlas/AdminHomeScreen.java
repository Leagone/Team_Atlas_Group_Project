package team_atlas;

import javax.swing.*;

/**
 * The admin home screen.
 * Only accessible if an admin logs into the application.
 * Contains four buttons that start the four admin panels,
 * and a button that logs the admin out.
 *
 * @author Dominik Deak
 */
public class AdminHomeScreen {

    JPanel adminHomePanel;
    JLabel welcomeLabel;
    JButton studentProgressButton, overallProgressButton, pairHistoryButton, userDataButton, logoutButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    AdminHomeScreen() {
        System.out.println("Admin home panel started");
        String textFieldValue = textField1.getText();
        String textFieldValue4 = textField4.getText();
        studentProgressButton.addActionListener(e -> AppHandler.startStudentProgressScreen(textFieldValue));
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        pairHistoryButton.addActionListener(e -> AppHandler.startPairHistoryScreen());
        userDataButton.addActionListener(e -> AppHandler.startUserDataMonitoringScreen(textFieldValue4));
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
