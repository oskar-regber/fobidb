package org.fobidb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FobidbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FobidbApplication.class, args);
	}

}
