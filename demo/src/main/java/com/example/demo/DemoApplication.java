package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.bind.JAXBException;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(DemoApplication.class, args);

		Marshal.jaxbObjectToXML();

		Unmarshal.jaxbXmlFileToObject("customer.xml");
	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args -> {

//		});
//	}
}




