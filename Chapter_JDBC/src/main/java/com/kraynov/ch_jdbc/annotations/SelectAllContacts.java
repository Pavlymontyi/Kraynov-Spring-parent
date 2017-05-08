package com.kraynov.ch_jdbc.annotations;

import com.kraynov.ch_jdbc.model.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery {
    private static final String SQL_SELECT_ALL_CONTACT =
            "select c.id, c.first_name, c.last_name, c.birth_date from contact c";

    public SelectAllContacts(DataSource ds) {
        super(ds, SQL_SELECT_ALL_CONTACT);
    }

    @Override
    protected Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthDate(resultSet.getDate("birth_date"));

        return contact;
    }


}
