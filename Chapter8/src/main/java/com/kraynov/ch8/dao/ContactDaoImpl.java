package com.kraynov.ch8.dao;

import com.kraynov.ch8.model.Contact;
import com.kraynov.ch8.model.ContactTelDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao{
    private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @Transactional(readOnly=true)
    public List<Contact> findAllWithDetails() {
        LOG.error("sessionFactory="+sessionFactory.getClass().getName());
        return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();

    }

    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Contact.findById");
        query.setParameter("id", id);
        return (Contact)query.uniqueResult();
    }

    @Transactional(readOnly=true)
    public ContactTelDetail findContactTelDetailById(Long id) {
        return (ContactTelDetail) sessionFactory.getCurrentSession().
                createSQLQuery("select * from CONTACT_TEL_DETAIL where id=:id").setParameter("id", id).uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        LOG.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        LOG.info("Contact deleted with id: " + contact.getId());
    }
}
