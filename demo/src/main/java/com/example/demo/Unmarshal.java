package com.example.demo;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Unmarshal {

public static void jaxbXmlFileToObject(String fileName) {
    File xmlFile = new File(fileName);

    JAXBContext jaxbContext;
    try
    {
        //Create JAXB context
        jaxbContext = JAXBContext.newInstance(Customers.class);
        //Create Unmarshal
        Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();
        //Class which need to convert
        Customers customers = (Customers) jaxbUnmarshall.unmarshal(xmlFile);

        for(Customer customer : customers.getCustomers())
        {
            System.out.println("[" + "Name: " + customer.getFirstName() + ", " + "Last name: " + customer.getLastName() + "]");
        }
    }
    catch (JAXBException e)
    {
        e.printStackTrace();
    }
}
}
