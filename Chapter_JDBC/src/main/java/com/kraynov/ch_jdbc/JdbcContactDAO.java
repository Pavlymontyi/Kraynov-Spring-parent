package com.kraynov.ch_jdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return null;
    }

    @Override
    public List<Contact> findByFirstName() {
        return null;
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
}
