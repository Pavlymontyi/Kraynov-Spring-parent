package com.kraynov.ch_jdbc.xmlconf;

import com.kraynov.ch_jdbc.common.KraynovSQLErrorCodesTranslator;
import com.kraynov.ch_jdbc.model.Contact;
import com.kraynov.ch_jdbc.model.ContactDAO;
import com.kraynov.ch_jdbc.model.ContactTelDetail;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of ContactDAO interface through JdbcTemplate and DataSource.
 * Usage of this implementation is through xml configuration
 */

public class JdbcContactDAO implements ContactDAO, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        KraynovSQLErrorCodesTranslator translator = new KraynovSQLErrorCodesTranslator(dataSource);
        jdbcTemplate.setExceptionTranslator(translator);
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "select id, first_name, last_name birth_date from contact";
        return namedJdbcTemplate.query(sql, (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("bith_date"));
            return contact;
        });
    }

    @Override
    public List<Contact> findAllWithDetail() {
        String sql = "select c.*, d.id contact_tel_id, d.contact_id, " +
                "d.tel_type, d.tel_number from contact c left join CONTACT_TEL_DETAIL d on d.contact_id = c.id";
        return namedJdbcTemplate.query(sql, (rs) -> {
            Map<Long, Contact> map = new HashMap<Long, Contact>();
            Contact contact = null;
            while(rs.next()){
                Long id = rs.getLong("id");
                contact = map.get(id);
                if (contact == null){
                    contact = new Contact();
                    contact.setId(id);
                    contact.setLastName(rs.getString("last_name"));
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    map.put(id, contact);
                }

                Long contactTelDetailid = rs.getLong("contact_tel_id");
                if (contactTelDetailid > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailid);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("tel_type"));
                    contactTelDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }
            return new ArrayList<Contact>(map.values());
        });
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        String sql = "select * from contact where first_name = :firstName";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("firstName", firstName);
        return null; //return namedJdbcTemplate.queryForList(sql, namedParameters);
    }

    @Override
    public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id = :contactld";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("contactld", id);
        return namedJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select first_name from contact where id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
    }

    private static final class ContactMapper implements RowMapper<Contact>{

        @Override
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("bith_date"));
            return contact;
        }
    }
}
