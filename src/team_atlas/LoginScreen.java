package team_atlas;

import javax.swing.*;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The login panel of the application.
 * @author Dominik Deak
 */
public class LoginScreen {

    JPanel loginPanel;
    JLabel emailLabel;
    JTextField emailField;
    JLabel passwordLabel;
    JTextField passwordField;
    JButton registerButton;
    JButton loginButton;

    LoginScreen() {
        System.out.println("Login panel started");
        registerButton.addActionListener(e -> AppHandler.startRegisterScreen());
        loginButton.addActionListener(e -> loginUser());
    }

    // TODO Hash passwords before attempting to log in
    // TODO Record login times
    /**
     * Queries the database with the entered details,
     * if they exist, logs the user in and switches to the appropriate home panel.
     */
    private void loginUser() {
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();

        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out both fields");
        } else if (emailInput.contains(" ") || passwordInput.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
        } else {
            Admin admin = AppHandler.queryAdminWithPass(emailInput, passwordInput);
            if (admin != null) {
                AppHandler.currentAdmin = admin;
                System.out.println("Admin '" + admin.getEmailAddress() + "' logged in");
                // TODO Switch to the admin home panel
            } else {
                User user = AppHandler.queryUserWithPass(emailInput, passwordInput);
                if (user != null) {
                    if (user.isTeacher()) {
                        AppHandler.currentUser = user;
                        System.out.println("Teacher '" + user.getEmailAddress() + "' logged in");
                        // TODO Switch to the teacher home panel
                    } else {
                        AppHandler.currentUser = user;
                        System.out.println("Student '" + user.getEmailAddress() + "' logged in");
                        // TODO Switch to the student home panel
                    }
                } else {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Incorrect login details entered");
                }
            }
        }
    }
}
