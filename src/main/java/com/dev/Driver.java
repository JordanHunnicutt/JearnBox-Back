package com.dev;

import com.dev.ui.MainMenuNB;
import com.dev.ui.MainMenuUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Driver {

	public static void main(String[] args) {
//		SpringApplication.run(Driver.class, args);
//		MainMenuUI mu = new MainMenuUI();
//		mu.firstMenu();
		MainMenuNB mmnb = new MainMenuNB();
		mmnb.setVisible(true);
	}

}
