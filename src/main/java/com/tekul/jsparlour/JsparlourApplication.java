package com.tekul.jsparlour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tekul.jsparlour"})
public class JsparlourApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsparlourApplication.class, args);
	}

}
