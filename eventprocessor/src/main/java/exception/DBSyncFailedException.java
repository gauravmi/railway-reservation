package exception;

import java.sql.SQLException;

public class DBSyncFailedException extends RuntimeException {
    public DBSyncFailedException(SQLException e) {
        super(e);
    }
}
