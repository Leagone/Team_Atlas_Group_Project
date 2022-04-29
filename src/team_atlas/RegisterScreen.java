package team_atlas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The registration panel of the application.
 * Contains first/last name fields, an email address field, and password/password confirmation fields.
 * Contains a button that displays information about the password requirements,
 * a button that takes the person back to the login screen and a register button.
 * @author Dominik Deak
 */
public class RegisterScreen {

    JPanel registerPanel, firstNameLabel, lastNameLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    JTextField firstNameField, lastNameField, emailField, passwordField, confirmPasswordField;
    JButton registerButton, backToLoginButton, informationButton;

    RegisterScreen() {
        System.out.println("Registration panel started");
        informationButton.addActionListener(e -> JOptionPane.showMessageDialog(MAIN_FRAME, """
                Your password must contain:
                    - A capital letter
                    - A lowercase letter
                    - A number
                And it must be at least 8 characters long"""));
        backToLoginButton.addActionListener(e -> AppHandler.startLoginScreen());
        registerButton.addActionListener(e -> registerUser());
    }

    /**
     * Registers a new user after successful validation,
     * and if the details are unique to all database entries.
     * For security reasons, registered users will only be added as students.
     */
    private void registerUser() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String emailAddress = emailField.getText();
        String password = passwordField.getText();
        String confirmedPassword = confirmPasswordField.getText();
        if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out all fields");
        } else if (firstName.contains(" ") || lastName.contains(" ") || emailAddress.contains(" ") || password.contains(" ") || confirmedPassword.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
        } else {
            boolean detailsValid = validateInput(firstName, lastName, emailAddress, password, confirmedPassword);
            if (detailsValid) {
                User user = AppHandler.queryUser(emailAddress);
                Admin admin = AppHandler.queryAdmin(emailAddress);
                if (user != null || admin != null) {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Email address is already in use");
                } else {
                    ArrayList<String> existingIDs = AppHandler.queryAllUserIDs();
                    String userID;
                    if (existingIDs != null) {
                        do {
                            userID = "u" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
                        } while (existingIDs.contains(userID));
                    } else {
                        userID = "u" + new Random().nextInt(10) + (10000000 + new Random().nextInt(90000000));
                    }
                    String salt = PasswordUtility.generateSalt();
                    String saltedPassword = PasswordUtility.generatePassWithSalt(password, salt);
                    user = new User(emailAddress, saltedPassword, salt, firstName, lastName, userID, false);
                    AppHandler.addUser(user);
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Registration successful");
                    AppHandler.startLoginScreen();
                }
            } else {
                JOptionPane.showMessageDialog(MAIN_FRAME, "Invalid details entered");
            }
        }
    }

    /**
     * Validates user input using regex.
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param emailAddress The email address of the person
     * @param password The password of the person
     * @param confirmedPassword The confirmed password of the person
     * @return true if the entered details match the specified regex patters, false otherwise
     */
    private boolean validateInput(String firstName, String lastName, String emailAddress, String password, String confirmedPassword) {
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
        if (password.equals(confirmedPassword)) {
            pattern = Pattern.compile(passwordRegex);
            matcher = pattern.matcher(password);
            if (matcher.matches()) {
                passwordValid = true;
            }
        }
        return firstNameValid && lastNameValid && emailAddressValid && passwordValid;
    }
}
