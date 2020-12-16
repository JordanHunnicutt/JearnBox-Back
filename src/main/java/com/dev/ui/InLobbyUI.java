package com.dev.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InLobbyUI implements ActionListener {

    public void lobbyMenu(){
        System.out.println("in lobby");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameplayUI gameplayUi = new GameplayUI();
        gameplayUi.gameUI();
    }
}
