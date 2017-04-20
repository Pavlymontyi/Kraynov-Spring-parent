package com.kraynov.ch_jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.SQLException;

public class KraynovSQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {

    public KraynovSQLErrorCodesTranslator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
        if (sqlEx.getErrorCode() == -12345) {
            return new DeadlockLoserDataAccessException(task, sqlEx);
        }
        return null;
    }
}
