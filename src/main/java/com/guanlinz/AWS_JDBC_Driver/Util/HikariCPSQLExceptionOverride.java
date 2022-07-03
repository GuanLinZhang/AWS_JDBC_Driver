package com.guanlinz.AWS_JDBC_Driver.Util;

import com.zaxxer.hikari.SQLExceptionOverride;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class HikariCPSQLExceptionOverride implements SQLExceptionOverride {
    public Override adjudicate(final SQLException sqlException) {
        String sqlState = sqlException.getSQLState();
        if (sqlState.equalsIgnoreCase("08S02") ||
                sqlState.equalsIgnoreCase("08007")) {
            log.info("HikariCP SQL Connection reused, reason: " + sqlState);
            log.info("HikariCP SQL Connection reused, reason: " + sqlState);
            log.info("HikariCP SQL Connection reused, reason: " + sqlState);
            log.info("HikariCP SQL Connection reused, reason: " + sqlState);
            log.info("HikariCP SQL Connection reused, reason: " + sqlState);
            return Override.DO_NOT_EVICT;
        } else {
            return Override.CONTINUE_EVICT;
        }
    }
}
