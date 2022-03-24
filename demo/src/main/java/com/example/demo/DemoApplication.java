package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.bind.JAXBException;



@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(DemoApplication.class, args);

		Marshal.jaxbObjectToXML();
	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args -> {

//		});
//	}
}




