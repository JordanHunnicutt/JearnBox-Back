package com.dev.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainMenuUI implements ActionListener {

    public static final Scanner scanner = new Scanner(System.in);

    public void firstMenu(){
        //First, make the frame that will hold everything, and set its attributes
        JFrame frame = new JFrame();
        frame.setSize( 800,600);
        frame.setTitle("JearnBox");
        frame.setResizable(false);

        //next, create the title component, set its properties, and add it to the frame
        JLabel title = new JLabel("JearnBox");
        Font tFont = new Font("default", 0, 72);
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(tFont);
        frame.getContentPane().add(title, BorderLayout.NORTH);

        //this will be a button to create a new game
        JButton startButton = new JButton("New Game");
        startButton.setVerticalAlignment(JLabel.CENTER);
        startButton.setHorizontalAlignment(JLabel.CENTER);
        Dimension sButtonDimension = new Dimension();
        sButtonDimension.setSize(200,100);
        startButton.setMaximumSize(sButtonDimension);
        startButton.addActionListener(this);
        //however, we can't directly add the button to the frame, otherwise it will expand to fill the whole thing.
        //we need to create a jpanel to hold the button first
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        //finally, set the frame to be visible once everything is added
        frame.setVisible(true);
        scanner.next();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("The button was clicked");
        
    }
}
