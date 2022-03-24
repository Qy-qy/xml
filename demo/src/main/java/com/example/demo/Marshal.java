package com.example.demo;

import javax.swing.tree.ExpandVetoException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;


public class Marshal {
   static Customers customers = new Customers();
   static
    {
        customers.setCustomers(new ArrayList<>());
        Customer ded = new Customer("Bob", "Kelsey");
        Customer kek = new Customer("Vad", "Zlobin");
        Customer lol = new Customer("Vova", "Zopin");
        Customer ban = new Customer("Kolja", "Rukop");
        customers.getCustomers().add(ded);
        customers.getCustomers().add(kek);
        customers.getCustomers().add(lol);
        customers.getCustomers().add(ban);
    }

    public static void jaxbObjectToXML() throws JAXBException
    {
        try
        {
            //Create JAXB context
            JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //Required formatting
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Store XML to File
            File file = new File("customer.xml");
            //Writes XML file to file-system
            jaxbMarshaller.marshal(customers, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
