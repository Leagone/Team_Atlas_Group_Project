package team_atlas;

import javax.swing.*;

/**
 * The teacher home screen.
 * Only accessible if a teacher logs into the application.
 * Contains three buttons that start the three teacher panels,
 * and a button that logs the teacher out.
 * @author Dominik Deak
 */
public class TeacherHomeScreen {

    JPanel teacherHomePanel;
    JLabel welcomeLabel;
    JButton rolePlayButton, studentProgressButton, overallProgressButton, logoutButton;
    private JTextField textField1;

    TeacherHomeScreen() {
        System.out.println("Teacher home panel started");
        String textFieldValue = textField1.getText();
        rolePlayButton.addActionListener(e -> AppHandler.startLangSelectionScreen());
        studentProgressButton.addActionListener(e -> AppHandler.startStudentProgressScreen(textFieldValue));
        overallProgressButton.addActionListener(e -> AppHandler.startOverallProgressScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }
}
