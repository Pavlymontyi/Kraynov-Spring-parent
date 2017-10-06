package com.kraynov.deps.services;

import com.kraynov.deps.dao.BankDao;
import com.kraynov.deps.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bankService")
public class BankServiceImpl implements BankService{

    @Autowired
    BankDao bankDao;

    @Override
    public List<Bank> findAll() {
        return bankDao.findAll();
    }

    @Override
    public Bank findByName(String bankName) {
        return bankDao.findByName(bankName);
    }

    @Override
    public Bank findById(Long id) {
        return bankDao.findById(id);
    }

    @Override
    public Bank save(Bank bank) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(Bank bankd) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void renameBank(String oldName, String newName) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void addBankProduct() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
