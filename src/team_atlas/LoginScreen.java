package team_atlas;

import javax.swing.*;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The login panel of the application.
 * Contains an email and password field with a register and login button.
 * Upon successful login, it takes the user/admin to their respective home screen.
 * Clicking the register button takes the person to the registration screen.
 *
 * @author Dominik Deak
 */
public class LoginScreen {

    JPanel loginPanel;
    JLabel emailLabel, passwordLabel;
    JTextField emailField, passwordField;
    JButton registerButton, loginButton;

    LoginScreen() {
        System.out.println("Login panel started");
        registerButton.addActionListener(e -> AppHandler.startRegisterScreen());
        loginButton.addActionListener(e -> login());
    }

    /**
     * Queries the database for a user/admin with the entered details,
     * if they exist, logs the user/admin in and switches to the appropriate home panel.
     */
    private void login() {
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();
        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out both fields");
        } else if (emailInput.contains(" ") || passwordInput.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
        } else {
            User user = AppHandler.queryUser(emailInput);
            if (user != null) {
                String salt = user.getSalt();
                String saltedPassword = PasswordUtility.generatePassWithSalt(passwordInput, salt);
                user = AppHandler.queryUserWithPass(emailInput, saltedPassword);
                if (user != null) {
                    AppHandler.currentUser = user;
                    AppHandler.currentActivity = new UserActivity(emailInput);
                    if (user.isTeacher()) {
                        System.out.println("Teacher '" + user.getEmailAddress() + "' logged in");
                        AppHandler.startTeacherHomeScreen();
                    } else {
                        System.out.println("Student '" + user.getEmailAddress() + "' logged in");
                        AppHandler.startStudentHomeScreen();
                    }
                } else {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Incorrect login details entered");
                }
            } else {
                Admin admin = AppHandler.queryAdmin(emailInput);
                if (admin != null) {
                    String salt = admin.getSalt();
                    String saltedPassword = PasswordUtility.generatePassWithSalt(passwordInput, salt);
                    admin = AppHandler.queryAdminWithPass(emailInput, saltedPassword);
                    if (admin != null) {
                        AppHandler.currentAdmin = admin;
                        System.out.println("Admin '" + admin.getEmailAddress() + "' logged in");
                        AppHandler.startAdminHomeScreen();
                    } else {
                        JOptionPane.showMessageDialog(MAIN_FRAME, "Incorrect login details entered");
                    }
                } else {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Incorrect login details entered");
                }
            }
        }
    }
}
