package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentService service
	) {
		return args -> {
			for(int i = 0; i < 100; i++) {
				service.save(Student.builder()
								.firstname("Test " + i)
								.lastname("Test " + i)
								.age(i)
								.build()).subscribe();
			}
		};
	}
}
