package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class Unmarshal {
    @Autowired
    CustomerRepository customerRepository;

    @Scheduled(fixedRate = Long.MAX_VALUE)
    public void jaxbXmlFileToObject() {
        File xmlFile = new File("customer.xml");

        JAXBContext jaxbContext;
        try {
            //Create JAXB context
            jaxbContext = JAXBContext.newInstance(Customers.class);
            //Create Unmarshal
            Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();
            //Class which need to convert
            Customers customers = (Customers) jaxbUnmarshall.unmarshal(xmlFile);

            for (Customer customer : customers.getCustomers()) {
                System.out.println("[" + "Name: " + customer.getFirstName() + ", " + "Last name: " + customer.getLastName() + "]");
                customerRepository.save(customer);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
