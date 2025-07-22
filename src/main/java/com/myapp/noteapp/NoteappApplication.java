package com.myapp.noteapp;

import com.myapp.noteapp.entities.User;
import com.myapp.noteapp.payload.UserDto;
import com.myapp.noteapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@SpringBootApplication
public class NoteappApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteappApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return runner -> {
			UserDto user = new UserDto();
			user.setName("Yigit");
			user.setEmail("Unlu");
			user.setEmail("yigitunlumm@gmail.com");

			userService.createUser(user);
			System.out.println("Test user are added!");
		};
	}

}
