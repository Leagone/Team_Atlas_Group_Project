package team_atlas;

import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The pair interaction monitoring panel of the application.
 * @author Dominik Deak
 */
public class PairMonitoringScreen {

    JPanel pairMonitoringPanel;
    JLabel emailLabel;
    JTextField firstPersonField, secondPersonField;
    JButton historyButton, languageChartButton, levelChartButton, contextChartButton, subContextChartButton, backButton, logoutButton;
    JScrollPane historyScrollPane;

    String firstPersonEmail, secondPersonEmail;

    /**
     * The table column names.
     */
    private final String[] HISTORY_COLUMN_NAMES = {
            "Date and Time", "Language", "Level", "Context",
            "Sub-context", "Completed", "Number of hints used"
    };

    /**
     * Holds all interactions between the two users.
     */
    private ArrayList<Interaction> interactions;

    PairMonitoringScreen() {
        System.out.println("Pair interaction history monitoring panel started");
        historyButton.addActionListener(e -> {
            boolean validInput = validateInput();
            if (validInput) {
                displayInteractionHistory(firstPersonEmail, secondPersonEmail);
            }
        });
        languageChartButton.addActionListener(e -> {
            boolean validInput = validateInput();
            if (validInput) {
                showLanguageChart(firstPersonEmail, secondPersonEmail);
            }
        });
        backButton.addActionListener(e -> AppHandler.startAdminHomeScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }

    private boolean validateInput() {
        firstPersonEmail = firstPersonField.getText();
        secondPersonEmail = secondPersonField.getText();
        if (firstPersonEmail.isEmpty() || secondPersonEmail.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out all fields");
            return false;
        } else if (firstPersonEmail.contains(" ") || secondPersonEmail.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
            return false;
        } else {
            User firstUser = AppHandler.queryUser(firstPersonEmail);
            User secondUser = AppHandler.queryUser(secondPersonEmail);
            if (firstUser == null && secondUser == null) {
                JOptionPane.showMessageDialog(MAIN_FRAME, "No users found");
                return false;
            } else {
                if (firstUser == null) {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "First user not found");
                    return false;
                }
                if (secondUser == null) {
                    JOptionPane.showMessageDialog(MAIN_FRAME, "Second user not found");
                    return false;
                }
                return true;
            }
        }
    }

    private void displayInteractionHistory(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            JTable historyTable = new JTable(tableModel);
            pairMonitoringPanel.add(historyScrollPane);
            interactions.sort(Comparator.comparing(Interaction::getInteractionDateAndTime));
            Object[][] tableData = new Object[interactions.size()][HISTORY_COLUMN_NAMES.length];
            for (int i = 0; i < interactions.size(); i++) {
                // FIXME Get language, level, context, sub-context
                tableData[i][0] = interactions.get(i).getInteractionDateAndTime().toString();
                tableData[i][1] = interactions.get(i).isConversationCompleted();
                tableData[i][2] = interactions.get(i).getHintsUsed();
            }
            tableModel.setDataVector(tableData, HISTORY_COLUMN_NAMES);
            historyScrollPane.setViewportView(historyTable);
        }
    }

    private void showLanguageChart(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            // FIXME Get language, level, context, sub-context
            DefaultPieDataset dataset = new DefaultPieDataset();
        }
    }
}
