package com.kraynov.deps;

import com.kraynov.deps.dao.BankDao;
import com.kraynov.deps.model.Bank;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        System.out.println("_________ Kraynov Application ________");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("embdb.xml");
        BankDao bankDao = (BankDao) ctx.getBean("bankDao");
        for (Bank bank : bankDao.findAll()){
            System.out.println(bank.toString());
        }
    }
}
