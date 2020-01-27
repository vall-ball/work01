package ru.vallball.work01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class Work01Application {

	public static void main(String[] args) {
		SpringApplication.run(Work01Application.class, args);
	}

}
