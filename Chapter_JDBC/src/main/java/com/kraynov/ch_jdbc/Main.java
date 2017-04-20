package com.kraynov.ch_jdbc;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String args[]) throws SQLException {
        log.debug("************************");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("app-context-xml.xml");
//        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
//        log.debug("dataSource="+dataSource);
//        Connection con = dataSource.getConnection();

        ContactDAO contactDao = ctx.getBean("contactDao", ContactDAO.class);
        System.out.println("First name for contact id 2 is: " + contactDao.findFirstNameById(2L));
        System.out.println("Last name for contact id 2 is: " + contactDao.findLastNameById(2L));
    }
}
