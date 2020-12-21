/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.ui;

import com.dev.model.Player;
import com.dev.model.Settings;

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

    public GameplayNB(Settings settings, String roomCode, List<Player> players) {
        initComponents();
        heldSettings = settings;
        heldPlayers = players;
        roomCodeValue.setText(roomCode);
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

    public void intro() {
        System.out.println("intro started");
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
                System.out.println("timer done");
                questionLabel.setText(printQuestion());
                countdownTimer();
            }
        });


    }

    public String printQuestion() {
        String q = "This is a test to see how long we can make the question with it still showing everything on screen";
        int questionLength = q.length();
        String qWithLines = "";
        while(questionLength > 30){
            qWithLines.concat(q.substring(0,30));
            qWithLines.concat("\n");
            q = q.substring(30);
            questionLength = q.length();
        }
        qWithLines.concat(q);

        return "Print question ran";
    }


    public void showAnswer() {
        questionLabel.setText("The answer is: ");
        timerLabel.setText("No");

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
                    .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(qNumLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qNumValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roomCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomCodeValue))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerListLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
}
