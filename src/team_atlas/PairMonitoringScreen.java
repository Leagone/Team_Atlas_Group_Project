package team_atlas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static team_atlas.AppHandler.MAIN_FRAME;

/**
 * The pair interaction history analytics monitoring panel of the application.
 * Contains two email fields, a button to list the interaction history of the entered users,
 * four buttons to display four analytic charts, a button that takes the admin back to the admin home panel,
 * and a button that logs the admin out.
 *
 * @author Dominik Deak
 */
public class PairMonitoringScreen {

    /**
     * The interaction history table column names.
     */
    private final String[] HISTORY_COLUMN_NAMES = {
            "Date and Time", "Language", "Level", "Context",
            "Sub-context", "Completed", "Number of hints used"
    };
    JPanel pairMonitoringPanel;
    JLabel emailLabel;
    JTextField firstPersonField, secondPersonField;
    JButton historyButton, languageChartButton, levelChartButton, dateGraphButton, hintsChartButton, backButton, logoutButton;
    JScrollPane historyScrollPane;
    String firstPersonEmail, secondPersonEmail;
    /**
     * Holds all Interaction objects between the two users.
     */
    private ArrayList<Interaction> interactions;

    PairMonitoringScreen() {
        System.out.println("Pair interaction history monitoring panel started");
        insertSampleData();
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
        levelChartButton.addActionListener(e -> {
            boolean validInput = validateInput();
            if (validInput) {
                showLevelChart(firstPersonEmail, secondPersonEmail);
            }
        });
        dateGraphButton.addActionListener(e -> {
            boolean validInput = validateInput();
            if (validInput) {
                showDateGraph(firstPersonEmail, secondPersonEmail);
            }
        });
        hintsChartButton.addActionListener(e -> {
            boolean validInput = validateInput();
            if (validInput) {
                showHintsChart(firstPersonEmail, secondPersonEmail);
            }
        });
        backButton.addActionListener(e -> AppHandler.startAdminHomeScreen());
        logoutButton.addActionListener(e -> AppHandler.logout());
    }

    /**
     * Validates the entered email addresses.
     *
     * @return true if the details are valid, false otherwise
     */
    private boolean validateInput() {
        firstPersonEmail = firstPersonField.getText();
        secondPersonEmail = secondPersonField.getText();
        if (firstPersonEmail.isEmpty() || secondPersonEmail.isEmpty()) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must fill out all fields");
            return false;
        } else if (firstPersonEmail.contains(" ") || secondPersonEmail.contains(" ")) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You must not enter any whitespaces");
            return false;
        } else if (firstPersonEmail.equals(secondPersonEmail)) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "You can't enter the same email twice");
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

    /**
     * Displays the interaction history of the two users in a JTable.
     * Orders the interactions by date in ascending order.
     *
     * @param firstPersonEmail  The email of the first person
     * @param secondPersonEmail The email of the second person
     */
    private void displayInteractionHistory(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            interactions.sort(Comparator.comparing(Interaction::getInteractionDateAndTime));
            DefaultTableModel tableModel = new DefaultTableModel();
            JTable historyTable = new JTable(tableModel);
            Object[][] tableData = new Object[interactions.size()][HISTORY_COLUMN_NAMES.length];
            for (int i = 0; i < interactions.size(); i++) {
                tableData[i][0] = interactions.get(i).getInteractionDateAndTime().toString();
                tableData[i][1] = interactions.get(i).getLanguage();
                tableData[i][2] = interactions.get(i).getLevel();
                tableData[i][3] = interactions.get(i).getContext();
                tableData[i][4] = interactions.get(i).getSubContext();
                tableData[i][5] = interactions.get(i).isConversationCompleted();
                tableData[i][6] = interactions.get(i).getHintsUsed();
            }
            tableModel.setDataVector(tableData, HISTORY_COLUMN_NAMES);
            historyScrollPane.setViewportView(historyTable);
        }
    }

    /**
     * Displays a pie chart with the languages used in the interactions.
     * Only displays languages that were used at least once.
     *
     * @param firstPersonEmail  The email of the first person
     * @param secondPersonEmail The email of the second person
     */
    private void showLanguageChart(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            int spanishNum = 0, germanNum = 0, portugueseNum = 0, frenchNum = 0, italianNum = 0, russianNum = 0;
            for (Interaction interaction : interactions) {
                if (interaction.getLanguage().equals("Spanish")) {
                    spanishNum++;
                }
                if (interaction.getLanguage().equals("German")) {
                    germanNum++;
                }
                if (interaction.getLanguage().equals("Portuguese")) {
                    portugueseNum++;
                }
                if (interaction.getLanguage().equals("French")) {
                    frenchNum++;
                }
                if (interaction.getLanguage().equals("Italian")) {
                    italianNum++;
                }
                if (interaction.getLanguage().equals("Russian")) {
                    russianNum++;
                }
            }

            HashMap<String, Integer> languageNumbers = new HashMap<>();
            languageNumbers.put("Spanish", spanishNum);
            languageNumbers.put("German", germanNum);
            languageNumbers.put("Portuguese", portugueseNum);
            languageNumbers.put("French", frenchNum);
            languageNumbers.put("Italian", italianNum);
            languageNumbers.put("Russian", russianNum);

            DefaultPieDataset dataset = new DefaultPieDataset();
            for (String language : languageNumbers.keySet()) {
                if (languageNumbers.get(language) != 0) {
                    dataset.setValue(language, languageNumbers.get(language));
                }
            }

            JFreeChart chart = ChartFactory.createPieChart("Language distribution", dataset, true, true, false);
            ChartFrame chartFrame = new ChartFrame("Language distribution", chart);
            chartFrame.setSize(500, 500);
            chartFrame.setLocationRelativeTo(MAIN_FRAME);
            chartFrame.setVisible(true);
        }
    }

    /**
     * Displays a pie chart with the levels used in the interactions.
     * Only displays levels that were used at least once.
     *
     * @param firstPersonEmail  The email of the first person
     * @param secondPersonEmail The email of the second person
     */
    private void showLevelChart(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            int a1Num = 0, a2Num = 0, b1Num = 0, b2Num = 0;
            for (Interaction interaction : interactions) {
                if (interaction.getLevel().equals("A1")) {
                    a1Num++;
                }
                if (interaction.getLevel().equals("A2")) {
                    a2Num++;
                }
                if (interaction.getLevel().equals("B1")) {
                    b1Num++;
                }
                if (interaction.getLevel().equals("B2")) {
                    b2Num++;
                }
            }

            HashMap<String, Integer> levelNumbers = new HashMap<>();
            levelNumbers.put("A1", a1Num);
            levelNumbers.put("A2", a2Num);
            levelNumbers.put("B1", b1Num);
            levelNumbers.put("B2", b2Num);

            DefaultPieDataset dataset = new DefaultPieDataset();
            for (String level : levelNumbers.keySet()) {
                if (levelNumbers.get(level) != 0) {
                    dataset.setValue(level, levelNumbers.get(level));
                }
            }

            JFreeChart chart = ChartFactory.createPieChart("Level distribution", dataset, true, true, false);
            ChartFrame chartFrame = new ChartFrame("Level distribution", chart);
            chartFrame.setSize(500, 500);
            chartFrame.setLocationRelativeTo(MAIN_FRAME);
            chartFrame.setVisible(true);
        }
    }

    /**
     * Displays a graph showing the total number of interactions from the earliest to the latest interaction date.
     *
     * @param firstPersonEmail  The email of the first person
     * @param secondPersonEmail The email of the second person
     */
    private void showDateGraph(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            interactions.sort(Comparator.comparing(Interaction::getInteractionDateAndTime));
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateString;
            int totalInteractions = 0;
            for (Interaction interaction : interactions) {
                totalInteractions++;
                dateString = dateFormat.format(interaction.getInteractionDateAndTime());
                dataset.addValue(totalInteractions, "Number of Interactions", dateString);
            }
            JFreeChart chart = ChartFactory.createLineChart(
                    "Total Interactions by Date", "Date", "Number of Interactions",
                    dataset, PlotOrientation.VERTICAL, true, true, false
            );
            ChartFrame chartFrame = new ChartFrame("Total Interactions by Date", chart);
            chartFrame.setSize(800, 500);
            chartFrame.setLocationRelativeTo(MAIN_FRAME);
            chartFrame.setVisible(true);
        }
    }

    /**
     * Displays a bar chart showing the total number of hints the users have used for each difficulty level.
     * Only displays levels where at least one hint was used.
     *
     * @param firstPersonEmail  The email of the first person
     * @param secondPersonEmail The email of the second person
     */
    private void showHintsChart(String firstPersonEmail, String secondPersonEmail) {
        interactions = AppHandler.queryInteractionsBetween(firstPersonEmail, secondPersonEmail);
        if (interactions == null) {
            JOptionPane.showMessageDialog(MAIN_FRAME, "No interactions found between these users");
        } else {
            int a1Hints = 0, a2Hints = 0, b1Hints = 0, b2Hints = 0;
            for (Interaction interaction : interactions) {
                if (interaction.getLevel().equals("A1")) {
                    a1Hints += interaction.getHintsUsed();
                }
                if (interaction.getLevel().equals("A2")) {
                    a2Hints += interaction.getHintsUsed();
                }
                if (interaction.getLevel().equals("B1")) {
                    b1Hints += interaction.getHintsUsed();
                }
                if (interaction.getLevel().equals("B2")) {
                    b2Hints += interaction.getHintsUsed();
                }
            }

            HashMap<String, Integer> hintNumbers = new HashMap<>();
            hintNumbers.put("A1", a1Hints);
            hintNumbers.put("A2", a2Hints);
            hintNumbers.put("B1", b1Hints);
            hintNumbers.put("B2", b2Hints);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (String level : hintNumbers.keySet()) {
                if (hintNumbers.get(level) != 0) {
                    dataset.setValue(hintNumbers.get(level), "Hints used", level);
                }
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Hints used per level", "Levels", "Hints used",
                    dataset, PlotOrientation.VERTICAL, true, true, false
            );
            ChartFrame chartFrame = new ChartFrame("Hints used per level", chart);
            chartFrame.setSize(500, 500);
            chartFrame.setLocationRelativeTo(MAIN_FRAME);
            chartFrame.setVisible(true);
        }
    }

    /**
     * Inserts ten randomly generated interactions into the database.
     * Used for demonstrating this panel in case there is a lack of interactions in the database.
     */
    private void insertSampleData() {
        System.out.println("Inserting sample interaction data into database");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            AppHandler.addInteraction(new Interaction(
                    "dominik@example.com",
                    "andrzej@example.com",
                    "example",
                    "CONV" + random.nextInt(62),
                    new Date(ThreadLocalRandom.current().nextInt() * 1000L),
                    random.nextInt(10),
                    random.nextBoolean()
            ));
        }
    }
}
