package com.kraynov.deps.dao;

import com.kraynov.deps.model.Bank;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("bankDao")
public class BankDaoSFImpl implements BankDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly=true)
    public List<Bank> findAll() {
        return sessionFactory.getCurrentSession().getNamedQuery("Bank.findAll").list();
    }

    @Transactional(readOnly=true)
    public Bank findById(Long id) {
        Query hibernateQuery = sessionFactory.getCurrentSession().getNamedQuery("Bank.findById");
        hibernateQuery.setParameter("id", id);
        return (Bank) hibernateQuery.uniqueResult();
    }

    @Transactional(readOnly=true)
    public Bank findByName(String bankName) {
        return (Bank) sessionFactory.getCurrentSession().getNamedQuery("Bank.findByName")
                .setParameter("name", bankName).list().iterator().next();
    }

    @Override
    public Bank save(Bank contact) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(Bank contact) {
        throw new UnsupportedOperationException("not implemented yet");
    }

}
