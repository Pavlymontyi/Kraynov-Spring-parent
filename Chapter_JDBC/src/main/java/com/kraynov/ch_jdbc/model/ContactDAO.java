package com.kraynov.ch_jdbc.model;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    List findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Contact contact);
    void insertWithDetail(Contact contact);
    void delete(Contact contact);
    void update(Contact contact);
}
