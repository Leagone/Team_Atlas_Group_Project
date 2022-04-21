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

    // TODO Record login times
    /**
     * Queries the database with the entered details,
     * if they exist, logs the person in and switches to the appropriate home panel.
     */
    private void loginUser() {
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();

        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out both fields");
        } else if (emailInput.contains(" ") || passwordInput.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
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
                User user = AppHandler.queryUser(emailInput);
                if (user != null) {
                    String salt = user.getSalt();
                    String saltedPassword = PasswordUtility.generatePassWithSalt(passwordInput, salt);
                    user = AppHandler.queryUserWithPass(emailInput, saltedPassword);
                    if (user != null) {
                        AppHandler.currentUser = user;
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
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Incorrect login details entered");
                }
            }
        }
    }
}
