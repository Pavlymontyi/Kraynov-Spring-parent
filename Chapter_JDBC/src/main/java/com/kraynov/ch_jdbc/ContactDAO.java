package com.kraynov.ch_jdbc;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findByFirstName();
    String findLastNameById();
    String findFirstNameById();
    void insert(Contact contact);
    void delete(Contact contact);
    void update(Contact contact);
}
