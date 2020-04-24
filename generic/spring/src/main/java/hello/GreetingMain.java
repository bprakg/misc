package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingMain {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}