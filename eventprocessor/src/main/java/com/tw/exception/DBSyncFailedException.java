package com.tw.exception;

import java.sql.SQLException;

public class DBSyncFailedException extends RuntimeException {
    public DBSyncFailedException(Exception e) {
        super(e);
    }

    public DBSyncFailedException(String message, Exception exception) {
        super(message, exception);
    }
}
