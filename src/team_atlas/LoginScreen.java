package team_atlas;

import javax.swing.*;

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
        loginButton.addActionListener(e -> loginUser());
        registerButton.addActionListener(e -> AppHandler.startRegisterScreen());
    }

    /**
     * Queries the database with the entered details,
     * if they exist, logs the user in and switches to the home panel.
     */
    private void loginUser() {
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();

        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must fill out both fields");
        } else if (emailInput.contains(" ") || passwordInput.contains(" ")) {
            JOptionPane.showMessageDialog(null, "You must not enter any whitespaces");
        } else {
            Admin admin = AppHandler.queryAdminWithPass(emailInput, passwordInput);
            if (admin != null) {
                AppHandler.currentAdmin = admin;
                System.out.println("Admin '" + admin.getEmailAddress() + "' logged in");
                // TODO Switch to the admin home panel
            } else {
                User user = AppHandler.queryUserWithPass(emailInput, passwordInput);
                if (user != null) {
                    AppHandler.currentUser = user;
                    System.out.println("User '" + user.getEmailAddress() + "' logged in");
                    // TODO Switch to the user home panel
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect login details entered");
                }
            }
        }
    }
}
