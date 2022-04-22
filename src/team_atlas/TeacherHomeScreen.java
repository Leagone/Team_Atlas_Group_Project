package team_atlas;

import javax.swing.*;

/**
 * @author Dominik Deak
 */
public class TeacherHomeScreen {

    JPanel teacherHomePanel;
    JLabel welcomeLabel;
    JButton rolePlayButton;
    JButton studentProgressButton;
    JButton overallProgressButton;
    JButton logoutButton;

    TeacherHomeScreen() {
        System.out.println("Teacher home panel started");
        rolePlayButton.addActionListener(e -> AppHandler.startLangSelectionScreen());
        studentProgressButton.addActionListener(e -> AppHandler.startStudentProgressScreen());
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        logoutButton.addActionListener(e -> {
            System.out.println("Teacher: '" + AppHandler.currentUser.getEmailAddress() + "' logged out");
            AppHandler.currentUser = null;
            // TODO Record logout time
            AppHandler.startLoginScreen();
        });
    }
}
