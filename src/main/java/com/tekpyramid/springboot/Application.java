package com.tekpyramid.springboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


/*
* SpringApplication.run(Class<?> primarySource, String... args) is called.
1. SpringApplication is instantiated.
2. Application environment is prepared using SpringApplicationRunListeners.
3. ApplicationArguments are parsed from the provided command-line arguments.
4. Application context is initialized.
5. Auto-configuration classes are applied.
6. Log configurations are initialized.
7. Application context is refreshed.
8. Application is started, and CommandLineRunner and ApplicationRunner beans are executed.
9. Application is ready to handle requests.
10. Application is fully started.
* */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@Bean
	public ApplicationRunner applicationRunner(){

		return args -> {
			System.out.println("Application runner executed");
		};

	}

	@Bean
	public CommandLineRunner commandLineRunner(){

		return  args -> {
			System.out.println("Command line executed");
		};

	}



}
