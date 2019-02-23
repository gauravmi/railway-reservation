package com.tw.listener;

import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;

import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static org.slf4j.LoggerFactory.getLogger;

public class JDBCConnection {
    private static PGPoolingDataSource dataSource;

    public static PGPoolingDataSource getDataSourceInstance() {
        if (dataSource != null)
            return dataSource;
        try {
            dataSource = configureDataSource();
        }catch(Exception e) {
            String message = "could not create data source";
            throw new RuntimeException(message, e);
        }
        return dataSource;
    }

    private static PGPoolingDataSource configureDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setServerName(getProperty("DB_HOST"));
        dataSource.setPortNumber(parseInt(getProperty("DB_PORT")));
        dataSource.setDatabaseName(getProperty("DB_NAME"));
        dataSource.setUser(getProperty("DB_USER"));
        dataSource.setPassword(getProperty("DB_PASS"));
        return dataSource;
    }
}
