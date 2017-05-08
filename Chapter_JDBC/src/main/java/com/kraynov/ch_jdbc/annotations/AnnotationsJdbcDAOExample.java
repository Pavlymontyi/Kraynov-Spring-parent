package com.kraynov.ch_jdbc.annotations;

import com.kraynov.ch_jdbc.model.Contact;
import com.kraynov.ch_jdbc.model.ContactDAO;
import com.kraynov.ch_jdbc.model.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;

public class AnnotationsJdbcDAOExample {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();

        ContactDAO contactDao = (ContactDAO) ctx.getBean("contactDao");
        System.out.println(contactDao.findAll());

        System.out.println("****************************************************");
        Contact contact = new Contact();
        contact.setFirstName("Pavel");
        contact.setLastName("Kraynov");
        contact.setBirthDate(new Date(GregorianCalendar.getInstance().getTime().getTime()));

        ContactTelDetail telDetails = new ContactTelDetail();
        telDetails.setTelType("Mobile");
        telDetails.setTelNumber("892771434**");
        contact.getContactTelDetails().add(telDetails);

        telDetails = new ContactTelDetail();
        telDetails.setTelType("Home");
        telDetails.setTelNumber("892771434**");

        contact.getContactTelDetails().add(telDetails);
        contactDao.insertWithDetail(contact);
        System.out.println(contactDao.findAll());
//        Contact scott = (Contact) contactDao.findByFirstName("Scott").get(0);
//        System.out.println(scott);
//
//        scott.setLastName(scott.getLastName()+" UPDATED");
//        scott.setFirstName(scott.getFirstName()+" UPDATED 2");
//        contactDao.update(scott);
//        System.out.println(contactDao.findByFirstName("Scott UPDATED 2"));
//
//        Contact pavel = new Contact();
//        pavel.setFirstName("Pavel");
//        pavel.setLastName("Kraynov");
//        pavel.setBirthDate(new Date(new GregorianCalendar(1990, 4, 10).getTime().getTime()));
//        contactDao.insert(pavel);

    }
}
