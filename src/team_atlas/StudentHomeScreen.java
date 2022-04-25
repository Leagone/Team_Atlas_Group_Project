package team_atlas;

import javax.swing.*;

/**
 * @author Dominik Deak
 */
public class StudentHomeScreen {

    JPanel studentHomePanel;
    JLabel welcomeLabel;
    JButton rolePlayButton;
    JButton progressButton;
    JButton logoutButton;

    StudentHomeScreen() {
        System.out.println("Student home panel started");
        rolePlayButton.addActionListener(e -> AppHandler.startLangSelectionScreen());
        progressButton.addActionListener(e -> AppHandler.startPersonalProgressScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
