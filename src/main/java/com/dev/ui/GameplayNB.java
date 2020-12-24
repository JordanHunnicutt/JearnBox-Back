/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.ui;

import com.dev.model.Player;
import com.dev.model.Settings;
import com.dev.model.SingleResponseQuestion;
import org.springframework.messaging.simp.stomp.DefaultStompSession;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * @author jdh6w
 */
public class GameplayNB extends javax.swing.JPanel {

    /**
     * Creates new form GameplayNB
     */
    public GameplayNB() {
        initComponents();
    }

    /**
     * This constructor is used to set values of different components on the page, including
     * the list of players, the room code, and the timer for questions.
     * @param settings
     * @param roomCode
     * @param players
     */
    public GameplayNB(Settings settings, String roomCode, List<Player> players, List<SingleResponseQuestion> selectedQuestions) {
        initComponents();
        heldSettings = settings;
        heldPlayers = players;
        roomCodeValue.setText(roomCode);
        questionList = selectedQuestions;
        unusedQuestions.addAll(questionList);
        DefaultListModel dml = new DefaultListModel();
        if (!players.isEmpty()) {
            for (Player p : players) {
                dml.addElement(p.getName());
            }
        } else {
            dml.addElement("No players found");
            players.add(new Player(1, "No players found", 123456));
        }

        playerList.setModel(dml);
        timerLabel.setText(settings.getTime().toString());
        timeValue = settings.getTime();

    }

    /**
     * This intro is called before each question begins. It gives everyone five seconds to prepare,
     * then it calls the printQuestion method to get a new question, and it calls the countdownTimer
     * method to start counting down the timer.
     */
    public void intro() {
        questionLabel.setText("Get ready for the next question!");
        timeValue = heldSettings.getTime();
        timerLabel.setText(heldSettings.getTime().toString());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                questionLabel.setText(printQuestion());
                countdownTimer();
            }
        });


    }

    /**
     * This method is used to get a new question, and to format it for multiple lines
     * using a StringBuilder.
     * @return - a string holding the question text
     */
    public String printQuestion() {
        if(unusedQuestions.size() == 0){ //reset the unused questions if every question was asked
            unusedQuestions.addAll(questionList);
        }
        //use math.random to select a random question
        String indexString = String.valueOf(Math.round(Math.random() * (unusedQuestions.size() - 1)));
        int index = Integer.parseInt(indexString);
        String q = unusedQuestions.get(index).getQuestion();
        rightAnswer = unusedQuestions.get(index).getAnswer();
        //make the question readable in the label field
        int questionLength = q.length();
        StringBuilder qWithLines = new StringBuilder("<html>");
        while(questionLength > 30){
            qWithLines.append(q.substring(0,30));
            qWithLines.append("<br/>");
            q = q.substring(30);
            questionLength = q.length();
        }
        qWithLines.append(q);
        qWithLines.append("</html>");
        unusedQuestions.remove(index);
        return qWithLines.toString();
    }

    /**
     * This method displays the answer after the timer runs down. It shows the answer for 5 seconds,
     * then either calls intro() again, or calls outro() if there are no more questions left.
     */
    public void showAnswer() {
        questionLabel.setText("The answer is: ");
        timerLabel.setText(rightAnswer);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentQNumber < heldSettings.getNumQuestions()) {
                    currentQNumber++;
                    qNumValue.setText(currentQNumber.toString());
                    intro();
                } else {
                    outro();
                }
            }
        });
    }

    /**
     * This method is called once all of the questions have been asked. It changes the question and timer text,
     * then after 5 seconds, displays the winner of the game (right now, it only displays player1). It then calls
     * the endApp method to close the application.
     */
    public void outro() {
        questionLabel.setText("That was the last question!");
        timerLabel.setText("Tallying results...");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                questionLabel.setText("The winner is " + (heldPlayers.get(0).getName()) + "!");
                timerLabel.setText("Thanks for playing!");
                endApp();
            }
        });

    }

    /**
     * This method waits 5 seconds after the winner has been revealed, then closes the application.
     */
    public void endApp() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    /**
     * This method changes the timer value every second. First, it checks to see if everyone has responded, and
     * sets the timer to 0 if everyone has. Otherwise, it puts the thread to sleep for 1 second, reduces the timer
     * by one, and either recalls the method, or calls showAnswer() if the timer is 0.
     */
    public void countdownTimer() {

        if(responsesReceived >= heldPlayers.size()){
            timeValue = 0;
            timerLabel.setText(timeValue.toString());
            responsesReceived = 0;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeValue--;
                timerLabel.setText(timeValue.toString());
                if (timeValue > 0) {
                    countdownTimer();
                } else {
                    showAnswer();
                }
            }
        });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList<>();
        roomCodeValue = new javax.swing.JLabel();
        roomCodeLabel = new javax.swing.JLabel();
        playerListLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        qNumLabel = new javax.swing.JLabel();
        qNumValue = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));

        playerList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(playerList);

        roomCodeValue.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        roomCodeValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomCodeValue.setText("123456");

        roomCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomCodeLabel.setLabelFor(roomCodeLabel);
        roomCodeLabel.setText("Room Code:");

        playerListLabel.setLabelFor(playerList);
        playerListLabel.setText("Players:");

        questionLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("Is Java Purely OOP?");

        timerLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("30");

        qNumLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qNumLabel.setText("Question:");

        qNumValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qNumValue.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(qNumLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qNumValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roomCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomCodeValue))
                    .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerListLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomCodeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qNumLabel)
                    .addComponent(qNumValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(playerListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playerList;
    private javax.swing.JLabel playerListLabel;
    private javax.swing.JLabel qNumLabel;
    private javax.swing.JLabel qNumValue;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel roomCodeLabel;
    private javax.swing.JLabel roomCodeValue;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
    private Settings heldSettings;
    private List<Player> heldPlayers = new ArrayList<>();
    private Integer timeValue = 1;
    private Integer currentQNumber = 1;
    private Integer responsesReceived = 0;
    private List<SingleResponseQuestion> questionList = new ArrayList<>();
    private List<SingleResponseQuestion> unusedQuestions = new ArrayList<>();
    private String rightAnswer;

}
