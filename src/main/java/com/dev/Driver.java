package com.dev;

import com.dev.controller.QuestionController;
import com.dev.model.SingleResponseQuestion;
import com.dev.ui.MainMenuNB;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Driver {

        @Autowired
        private QuestionController qc;
    
	public static void main(String[] args) {
		SpringApplication.run(Driver.class, args);
		System.setProperty("java.awt.headless","false");
		MainMenuNB mmnb = new MainMenuNB();
		mmnb.main(args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
