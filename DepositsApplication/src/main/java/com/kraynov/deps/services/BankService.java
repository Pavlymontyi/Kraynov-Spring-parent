package com.kraynov.deps.services;

import com.kraynov.deps.model.Bank;

import java.util.List;

public interface BankService {

    //looks like these operations are not service-true. It's just wrap for repository/dao level
    List<Bank> findAll();
    Bank findByName(String bankName);
    Bank findById(Long id);
    Bank save(Bank bank);
    void delete(Bank bankd);

    //Example of service-true operation
    void renameBank(String oldName, String newName);
    void addBankProduct();

}
