package com.kraynov.ch_jdbc.annotations;

import com.kraynov.ch_jdbc.model.Contact;
import com.kraynov.ch_jdbc.model.ContactDAO;
import com.kraynov.ch_jdbc.model.ContactTelDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDAO implements ContactDAO {
    private static Log log = LogFactory.getLog(JdbcContactDAO.class);

    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;
    private InsertContact insertContact;
    private InsertContactTelDetail insertContactTelDetail;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
        this.insertContact = new InsertContact(dataSource);
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "select c.id, c.first_name, c.last_name, c.bith_date, cd.id as contact_tel_id, cd.tel_type, cd.tel_number " +
                "from contact c left join contact_tel_detail cd on c.id = cd.contact_id";
        return jdbcTemplate.query(sql, (ResultSet rs) -> {
            Map<Long, Contact> map = new HashMap<Long, Contact>();
            Contact contact = null;
            while(rs.next()){
                Long id = rs.getLong("id");
                contact = map.get(id);
                if (contact == null){
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    map.put(id, contact);
                }
                Long contactTelDetail = rs.getLong("contact_tel_id");
                if(contactTelDetail > 0) {
                    ContactTelDetail telDetail = new ContactTelDetail();
                    telDetail.setId(contactTelDetail);
                    telDetail.setTelType(rs.getString("tel_type"));
                    telDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactTelDetails().add(telDetail);
                }
            }
            return new ArrayList<Contact>(map.values());
        });

    }

    @Override
    public List findByFirstName(String firstName) {
        Map<String, Object> paramМap = new HashMap<String, Object>();
        paramМap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramМap);
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {
        Map<String, Object> paramМap = new HashMap<String, Object>();
        paramМap.put("first_name", contact.getFirstName());
        paramМap.put("last_name", contact.getLastName());
        paramМap.put("birth_date", contact.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(paramМap, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
        log.info("New contact inserted with id: " + contact.getId());
    }

    public void insertWithDetail(Contact contact){
        insertContactTelDetail = new InsertContactTelDetail(dataSource);
        insert(contact);
        List<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
        if(contactTelDetails != null){
            for (ContactTelDetail telDetail : contactTelDetails){
                Map<String, Object> paramМap = new HashMap<String, Object>();
                paramМap = new HashMap<String, Object>();
                paramМap.put("contact_id", contact.getId());
                paramМap.put("tel_type", telDetail.getTelType());
                paramМap.put("tel_number", telDetail.getTelNumber());
            }
        }
        insertContactTelDetail.flush();
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("first_name", contact.getFirstName());
        paramsMap.put("last_name", contact.getLastName());
        paramsMap.put("birth_date", contact.getBirthDate());
        paramsMap.put("id", contact.getId());
        updateContact.updateByNamedParam(paramsMap);
        log.info("Existing contact updated wi th id: " + contact.getId());
    }

}
