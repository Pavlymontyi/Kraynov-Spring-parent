package com.kraynov.deps;

import com.kraynov.deps.dao.BankDao;
import com.kraynov.deps.model.Bank;
import com.kraynov.deps.services.BankService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String args[]){
        System.out.println("____________ Kraynov Deposits _______");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("embdb.xml");
        //BankDao bankDao = ctx.getBean("bankDao", BankDao.class);


        BankService bankService = ctx.getBean("bankService", BankService.class);

        for (Bank bank : bankService.findAll()){
            System.out.println("bankService = "+bankService.toString());
            System.out.println(bank.toString());
        }

        System.out.println("bank with 2 id: "+bankService.findById(2L));
        System.out.println("bank with name : "+bankService.findByName("Югра"));

    }
}
