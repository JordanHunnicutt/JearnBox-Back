package com.dev.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainMenuUI implements ActionListener {

    public static final Scanner scanner = new Scanner(System.in);

    //components
    public JFrame frame = new JFrame();
    public JLabel title = new JLabel("JearnBox");
    public Font tFont = new Font("default", 0, 72);
    public JButton startButton = new JButton("New Game");
    public Dimension sButtonDimension = new Dimension();
    public JPanel buttonPanel = new JPanel();

    public void firstMenu(){
        //First, make the frame that will hold everything, and set its attributes
        frame.setSize( 800,600);
        frame.setTitle("JearnBox");
        frame.setResizable(false);

        //next, create the title component, set its properties, and add it to the frame
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(tFont);
        frame.getContentPane().add(title, BorderLayout.NORTH);

        //this will be a button to create a new game
        startButton.setVerticalAlignment(JLabel.CENTER);
        startButton.setHorizontalAlignment(JLabel.CENTER);
        sButtonDimension.setSize(200,100);
        startButton.setMaximumSize(sButtonDimension);
        startButton.addActionListener(this);
        //however, we can't directly add the button to the frame, otherwise it will expand to fill the whole thing.
        //we need to create a jpanel to hold the button first
        buttonPanel.add(startButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        //finally, set the frame to be visible once everything is added
        frame.setVisible(true);
        scanner.next();
    }


    //when the new game button is clicked, remove the button and open the lobby ui
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("The button was clicked");
        buttonPanel.setVisible(false);
        frame.getContentPane().remove(buttonPanel);
        LobbySettingsUI lobbySettingsUI = new LobbySettingsUI();
        lobbySettingsUI.LobbyMenu(scanner, frame);
    }
}
