package team_atlas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PairInteractionMonitoringScreen {

    JPanel pairInteractionMonitoringPanel;
    private JTextField firstPersonField;
    private JTextField secondPersonField;
    private JButton searchButton;
    private DefaultTableModel tableModel;
    private JTable historyTable;
    private JScrollPane historyScrollPane;

    private final String[] HISTORY_COLUMN_NAMES = {
            "Date and Time", "Language", "Level", "Context",
            "Sub-context", "Completed", "Number of hints used"
    };

    private Object[] historyTableData;

    PairInteractionMonitoringScreen() {
        AppHandler.MAIN_FRAME.setTitle("Team Atlas Language App - Pair Interaction History");

        searchButton.addActionListener(e -> {
            String firstPersonName = firstPersonField.getText();
            String secondPersonName = secondPersonField.getText();
            if (firstPersonName.isEmpty() || secondPersonName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must fill out all fields");
            } else if (firstPersonName.contains(" ") || secondPersonName.contains(" ")) {
                JOptionPane.showMessageDialog(null, "You must not enter any whitespaces");
            } else {
                // TODO Query database for the 2 people
            }
        });
    }
}
