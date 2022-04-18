package team_atlas;

import javax.swing.*;

public class LoginScreen {

    JPanel loginPanel;
    JLabel emailLabel;
    JTextField emailField;
    JLabel passwordLabel;
    JTextField passwordField;
    JButton registerButton;
    JButton loginButton;

    LoginScreen() {
        AppHandler.MAIN_FRAME.setTitle("Team Atlas Language App - Login");

        // Switch to register screen
        registerButton.addActionListener(e -> {
            RegisterScreen registerScreen = new RegisterScreen();
            AppHandler.MAIN_FRAME.setContentPane(registerScreen.registerPanel);
            AppHandler.MAIN_FRAME.setSize(600, 900);
            AppHandler.MAIN_FRAME.setResizable(false);
            AppHandler.MAIN_FRAME.setLocationRelativeTo(null);
            AppHandler.MAIN_FRAME.setVisible(true);
        });

        loginButton.addActionListener(e -> {
            String emailInput = emailField.getText();
            String passwordInput = passwordField.getText();
            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must fill out both fields");
            } else if (emailInput.contains(" ") || passwordInput.contains(" ")) {
                JOptionPane.showMessageDialog(null, "You must not enter any whitespaces");
            } else {
                // TODO Query database for entered login details
            }
        });
    }
}
