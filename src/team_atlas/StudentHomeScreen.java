package team_atlas;

import javax.swing.*;

/**
 * The student home screen.
 * Only accessible if a student logs into the application.
 * Contains two buttons that start the two student panels,
 * and a button that logs the student out.
 *
 * @author Dominik Deak
 */
public class StudentHomeScreen {

    JPanel studentHomePanel;
    JLabel welcomeLabel;
    JButton rolePlayButton, progressButton, logoutButton;

    StudentHomeScreen() {
        System.out.println("Student home panel started");
        rolePlayButton.addActionListener(e -> AppHandler.startLangSelectionScreen());
        progressButton.addActionListener(e -> AppHandler.startPersonalProgressScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
