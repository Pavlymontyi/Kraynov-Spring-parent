package com.kraynov.ch_jdbc;

import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String args[]) throws SQLException {
        //Поднятие бина ContactDAO с использованием XML-конфигурации (app-context-xml.xml)
        //com.kraynov.ch_jdbc.xmlconf.Main.main(args);

        //Поднятие бина ContactDAO с использованием аннотаций-конфигурации (app-context-annotation.xml)
        com.kraynov.ch_jdbc.annotations.AnnotationsJdbcDAOExample.main(args);

    }
}
