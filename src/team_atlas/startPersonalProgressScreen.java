package team_atlas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class startPersonalProgressScreen {

    private User currentUser;
    private ArrayList<Interaction> interactions;
    private HashMap<String, Integer> extractInfo;
    private int experience;
    private int level = 0;
    private JButton backHome;
    private JButton logOut;
    private JLabel userDetails;
    private JLabel allHints;
    private JLabel hintPerInteraction;
    private JLabel conversationCompleted;
    private JPanel completedPerTotal;
    private JLabel completedVsTotal;
    private JLabel bestLang;
    private JLabel worstLang;
    private JLabel progress;
    private JLabel hintCount;
    private JLabel hintAvarage;
    private JLabel completedCount;
    private JLabel langID;
    private JLabel wLangId;
    private JLabel comVsTotCount;
    private JProgressBar progressBar1;
    private JLabel levelLabel;
    private JLabel exp;


    startPersonalProgressScreen(User currentUser) {

        this.currentUser = currentUser;
        this.experience = currentUser.getExperience();
        interactions = AppHandler.queryAllInteractionsOf(currentUser.getEmailAddress());
        this.extractInfo = extractInfo(interactions);

        backHome.addActionListener(e -> AppHandler.startAdminHomeScreen());
        logOut.addActionListener(e -> AppHandler.logout());

        progressBar1.setValue(0);

        int min = 0;
        int max = 100;
        int experienceToDisply = experience;
        boolean sentilen = true;

        while(sentilen){
            if(experienceToDisply  > max){
                max = max + 20;
                experienceToDisply = experienceToDisply - max;
                level++;
            }else{
                progressBar1.setValue(experienceToDisply);
                progressBar1 = new JProgressBar(min, max);
            }
        }

        userDetails.setText("Current user" + currentUser.getFirstName() + " " + currentUser.getLastName());
        hintCount.setText(Integer.toString(extractInfo.get(0)));
        hintAvarage.setText(Integer.toString(extractInfo.get(1)));
        completedCount.setText(Integer.toString(extractInfo.get(2)));
        langID.setText("None");
        wLangId.setText("None");
        comVsTotCount.setText(Integer.toString(extractInfo.get(5)));
        levelLabel.setText(Integer.toString(level));
        exp.setText(Integer.toString(experience));





    }



    public HashMap<String, Integer> extractInfo(ArrayList<Interaction> interaciton) {

        HashMap<String, Integer> output = new HashMap<>();

        HashMap<String, Integer> langOverwiev = new HashMap<>();

        int hintsCount = 0;
        int completedCount = 0;
        int totalConversationCount = 0;
        int avarageHintPerInteraction = 0;
        int avarageCompletedCount = 0;
        String bestLang;
        String worstLang;

        ArrayList<Language> languages = AppHandler.queryAllLanguages();

        for (int i = 0; i < languages.size(); i++) {

            Language currentLang = languages.get(i);
            langOverwiev.put(currentLang.getLanguageID(), 0);

        }


        for (int i = 0; i < interaciton.size(); i++) {
            Interaction currentInteraction = interaciton.get(i);
            int hintsUsed = currentInteraction.getHintsUsed();
            hintsCount = hintsCount + hintsUsed;

            if (currentInteraction.isConversationCompleted() == true) {
                completedCount++;
            }
            totalConversationCount++;


        }

        avarageHintPerInteraction = hintsCount / totalConversationCount;
        avarageCompletedCount = completedCount / totalConversationCount;

        output.put("allHints", hintsCount);
        output.put("hintPerInteraction", avarageHintPerInteraction);
        output.put("conversationCompleted", totalConversationCount);
        output.put("bestLang", 0);
        output.put("worstLang", 0);
        output.put("completedVsTotal", avarageCompletedCount);
        output.put("experience", currentUser.getExperience());


        return output;
    }

}
