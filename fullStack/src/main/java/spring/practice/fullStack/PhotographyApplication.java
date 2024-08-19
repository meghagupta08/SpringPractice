package spring.practice.fullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude  = SecurityAutoConfiguration.class)
public class PhotographyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographyApplication.class, args);
	}

}
