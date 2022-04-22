package team_atlas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The pair interaction monitoring panel of the application.
 * @author Dominik Deak
 */
public class PairMonitoringScreen {

    JPanel pairMonitoringPanel;
    private JTextField firstPersonField;
    private JTextField secondPersonField;
    private JButton searchButton;
    private DefaultTableModel tableModel;
    private JTable historyTable;
    private JScrollPane historyScrollPane;

    /**
     * The table data displayed to the user.
     */
    private Object[][] tableData;

    /**
     * The table column names.
     */
    private final String[] HISTORY_COLUMN_NAMES = {
            "Date and Time", "Language", "Level", "Context",
            "Sub-context", "Completed", "Number of hints used"
    };

    PairMonitoringScreen() {
        System.out.println("Pair interaction history monitoring panel started");
        searchButton.addActionListener(e -> searchForHistory());
    }

    private void searchForHistory() {
        String firstPersonEmail = firstPersonField.getText();
        String secondPersonEmail = secondPersonField.getText();
        if (firstPersonEmail.isEmpty() || secondPersonEmail.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out all fields");
        } else if (firstPersonEmail.contains(" ") || secondPersonEmail.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
        } else {
            User firstUser = AppHandler.queryUser(firstPersonEmail);
            User secondUser = AppHandler.queryUser(secondPersonEmail);
            if (firstUser == null && secondUser == null) {
                JOptionPane.showMessageDialog(MAIN_FRAME, "No users found");
            } else {
                if (firstUser == null) {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "First user not found");
                }
                if (secondUser == null) {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Second user not found");
                }
                displayInteractionHistory(firstUser, secondUser);
            }
        }
    }

    private void displayInteractionHistory(User firstUser, User secondUser) {
        // TODO Display interaction history
    }
}
