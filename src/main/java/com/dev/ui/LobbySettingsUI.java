package com.dev.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LobbySettingsUI implements ActionListener {

    //components
    public JSpinner timeLimit = new JSpinner();
    public JSpinner playerLimit = new JSpinner();
    public JSpinner questionNum = new JSpinner();
    public JSpinner pointGoal = new JSpinner();
    public JTextField category = new JTextField();
    public JButton openGameButton = new JButton();
    public JPanel menuPanel = new JPanel();
    public SpringLayout sLayout = new SpringLayout();
    public GridLayout gLayout = new GridLayout(6,2);

    //labels
    public JLabel timeLabel = new JLabel("Time per question: (seconds)");
    public JLabel playerLabel = new JLabel("Max players: ");
    public JLabel questionLabel = new JLabel("Number of questions: ");
    public JLabel pointLabel = new JLabel("Point goal: ");
    public JLabel categoryLabel = new JLabel("Category: (leave blank for all questions) ");
    public JLabel emptyLabel = new JLabel("");

    public void LobbyMenu(Scanner scanner, JFrame frame){
        System.out.println("Lobby settings");

        //setup the menu panel
        menuPanel.setLayout(gLayout);
//        menuPanel.setLayout(layout);
        gLayout.setVgap(30);
        gLayout.setHgap(10);

        //setup the time limit
//        Dimension tLDimension = new Dimension(100,25);
//        timeLimit.setBounds(200,200,100,25);
        timeLabel.setHorizontalAlignment(JLabel.RIGHT);

        //setup the player limit
        playerLabel.setHorizontalAlignment(JLabel.RIGHT);

        //setup the question number
        questionLabel.setHorizontalAlignment(JLabel.RIGHT);

        //setup the point goal
        pointLabel.setHorizontalAlignment(JLabel.RIGHT);

        //setup the category
        categoryLabel.setHorizontalAlignment(JLabel.RIGHT);

        //setup the open game button
        openGameButton.setText("Open Lobby");
        openGameButton.addActionListener(this);

        //lastly, add everything to the menu panel and add it to the frame
        menuPanel.add(timeLabel);
        menuPanel.add(timeLimit);
        menuPanel.add(playerLabel);
        menuPanel.add(playerLimit);
        menuPanel.add(questionLabel);
        menuPanel.add(questionNum);
        menuPanel.add(pointLabel);
        menuPanel.add(pointGoal);
        menuPanel.add(categoryLabel);
        menuPanel.add(category);
        menuPanel.add(emptyLabel);
        menuPanel.add(openGameButton);
        frame.add(menuPanel);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        InLobbyUI inLobbyUi = new InLobbyUI();
        inLobbyUi.lobbyMenu();
    }
}
