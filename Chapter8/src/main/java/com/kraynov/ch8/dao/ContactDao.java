package com.kraynov.ch8.dao;

import com.kraynov.ch8.model.Contact;
import com.kraynov.ch8.model.ContactTelDetail;

import java.util.List;

public interface ContactDao {

    List<Contact> findAll();
    List<Contact> findAllWithDetails();
    ContactTelDetail findContactTelDetailById(Long id);
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
