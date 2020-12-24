package com.dev;

import com.dev.controller.QuestionController;
import com.dev.model.SingleResponseQuestion;
import com.dev.ui.MainMenuNB;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Driver {

	private static QuestionController qc;

	private static ApplicationContext ac;

	private static List<SingleResponseQuestion> qs;
    
	public static void main(String[] args) {
		ac = SpringApplication.run(Driver.class, args);
		System.setProperty("java.awt.headless","false");
		qc = ac.getBean(QuestionController.class);
		try{
			qs = qc.findAllQuestions();
		} catch(NullPointerException e){
			System.out.println("no questions found");
		}

		MainMenuNB mmnb = new MainMenuNB(qs);
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
