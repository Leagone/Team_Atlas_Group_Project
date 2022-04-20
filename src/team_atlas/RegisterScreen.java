package team_atlas;

import javax.swing.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The registration panel of the application.
 * @author Dominik Deak
 */
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
        System.out.println("Registration panel started");
        registerButton.addActionListener(e -> registerUser());
    }

    private void registerUser() {
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
                String userID = "u" + (100000000 + new Random().nextInt(900000000));
                User user = new User(emailAddress, password, firstName, lastName, userID, false);
                // TODO Use hashing on user details
                AppHandler.addUser(user);
                JOptionPane.showMessageDialog(null, "Registration successful");
                AppHandler.startLoginScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid details entered");
            }
        }
    }

    private boolean validateInput(String firstName, String lastName, String emailAddress, String password) {
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
        }

        matcher = pattern.matcher(lastName);
        if (matcher.matches()) {
            lastNameValid = true;
        }

        pattern = Pattern.compile(emailAddressRegex);
        matcher = pattern.matcher(emailAddress);
        if (matcher.matches()) {
            emailAddressValid = true;
        }

        pattern = Pattern.compile(passwordRegex);
        matcher = pattern.matcher(password);
        if (matcher.matches()) {
            passwordValid = true;
        }

        return firstNameValid && lastNameValid && emailAddressValid && passwordValid;
    }
}
