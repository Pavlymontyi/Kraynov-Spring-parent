package com.kraynov.deps.dao;

import com.kraynov.deps.model.Bank;

import java.util.List;

public interface BankDao {

    List<Bank> findAll();
    Bank findById(Long id);
    Bank findByName(String bankName);
    Bank save(Bank contact);
    void delete(Bank contact);

}
