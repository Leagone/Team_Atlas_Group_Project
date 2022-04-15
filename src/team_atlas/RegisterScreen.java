package team_atlas;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterScreen {
    JPanel registerPanel;
    JLabel firstNameLabel;
    JTextField firstNameField;
    JLabel lastNameLabel;
    JTextField lastNameField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel passwordLabel;
    JTextField passwordField;
    JButton registerButton;

    RegisterScreen() {
        AppHandler.MAIN_FRAME.setTitle("Team Atlas Language App - Register Screen");

        registerButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String emailAddress = emailField.getText();
            String password = passwordField.getText();
            if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must fill out all fields");
            } else if (firstName.contains(" ") || lastName.contains(" ") || emailAddress.contains(" ") || password.contains(" ")) {
                JOptionPane.showMessageDialog(null, "You must not enter any whitespaces");
            } else {
                boolean detailsValid = validateInput(firstName, lastName, emailAddress, password);
                if (detailsValid) {
                    // TODO Insert details into database
                    LoginScreen loginScreen = new LoginScreen();
                    AppHandler.MAIN_FRAME.setContentPane(loginScreen.loginPanel);
                    AppHandler.MAIN_FRAME.setSize(600, 900);
                    AppHandler.MAIN_FRAME.setResizable(false);
                    AppHandler.MAIN_FRAME.setLocationRelativeTo(null);
                    AppHandler.MAIN_FRAME.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid details entered");
                }
            }
        });
    }

    boolean validateInput(String firstName, String lastName, String emailAddress, String password) {
        boolean firstNameValid = false;
        boolean lastNameValid = false;
        boolean emailAddressValid = false;
        boolean passwordValid = false;

        // Starts with capital letter, followed by lowercase letters
        String nameRegex = "^[A-Z][a-zA-Z]*$";
        // Explanation: https://www.w3schools.blog/validate-email-regular-expression-regex-java
        String emailAddressRegex = "^[_A-Za-z\\d-]+(\\.[_A-Za-z\\d-]+)*@[A-Za-z\\d-]+(\\.[A-Za-z\\d]+)*(\\.[A-Za-z]{2,})$";
        // At least 8 characters, containing an uppercase letter, lowercase letter, number
        String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d).{8,}$";

        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(firstName);
        if (matcher.matches()) {
            firstNameValid = true;
            JOptionPane.showMessageDialog(null, "Valid first name");
        }

        matcher = pattern.matcher(lastName);
        if (matcher.matches()) {
            lastNameValid = true;
            JOptionPane.showMessageDialog(null, "Valid last name");
        }

        pattern = Pattern.compile(emailAddressRegex);
        matcher = pattern.matcher(emailAddress);
        if (matcher.matches()) {
            emailAddressValid = true;
            JOptionPane.showMessageDialog(null, "Valid email");
        }

        pattern = Pattern.compile(passwordRegex);
        matcher = pattern.matcher(password);
        if (matcher.matches()) {
            passwordValid = true;
            JOptionPane.showMessageDialog(null, "Valid password");
        }

        return firstNameValid && lastNameValid && emailAddressValid && passwordValid;
    }
}
