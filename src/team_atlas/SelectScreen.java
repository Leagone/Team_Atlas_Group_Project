package team_atlas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static team_atlas.AppHandler.*;

public class SelectScreen {
    JButton teacherButton;
    JButton studentButton;
    JPanel BlueButtonPanel;
    JPanel Main;

    public SelectScreen() {
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startStudentHomeScreen();
            }
        });

        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTeacherHomeScreen();
            }
        });
    }
}
