package com.dev;

import com.dev.ui.LobbySettingsNB;
import com.dev.ui.MainMenuNB;
import com.dev.ui.MainMenuUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Driver {

	public static void main(String[] args) {
		SpringApplication.run(Driver.class, args);
		System.setProperty("java.awt.headless","false");
		MainMenuNB mmnb = new MainMenuNB();
		mmnb.main(args);
	}

	@Bean
	public WebMvcConfigurer corsConfiguerer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
