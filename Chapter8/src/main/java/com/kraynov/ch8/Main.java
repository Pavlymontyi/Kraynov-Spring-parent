package com.kraynov.ch8;

import com.kraynov.ch8.dao.ContactDao;
import com.kraynov.ch8.model.Contact;
import com.kraynov.ch8.model.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("embdb.xml");
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = new Contact("Pavel", "Kraynov", new Date());
        contact.addContactDetail(new ContactTelDetail("mobile", "11111"));
        contact.addContactDetail(new ContactTelDetail("home",   "22222"));

        contactDao.save(contact);
        listContacts(contactDao.findAllWithDetails());

        Contact pav = contactDao.findById(4L);
        pav.removeContactDetail(pav.getContactTelDetails().iterator().next());
        contactDao.save(pav);
        listContacts(Arrays.asList(contactDao.findById(4L)));
        ContactTelDetail deletedDetail = contactDao.findContactTelDetailById(4L);
        System.out.println("Deleted details from Pavel Kraynov:"+deletedDetail);
    }

    private static void listContacts(List<Contact> contacts){
        System.out.println();
        System.out.println("Listing contacts:");
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }
}
