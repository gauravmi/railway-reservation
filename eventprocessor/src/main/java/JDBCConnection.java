import org.postgresql.ds.PGPoolingDataSource;

import static java.lang.Integer.parseInt;
import static java.lang.System.getenv;

final class JDBCConnection {

    private static PGPoolingDataSource dataSource;

    static PGPoolingDataSource getDataSourceInstance() {
        if (dataSource != null)
            return dataSource;

        dataSource = configureDataSource();
        return dataSource;
    }

    private static PGPoolingDataSource configureDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setServerName(getenv("DB_HOST"));
        dataSource.setPortNumber(parseInt(getenv("DB_PORT")));
        dataSource.setDatabaseName(getenv("DB_NAME"));
        dataSource.setUser(getenv("DB_USER"));
        dataSource.setPassword(getenv("DB_PASS"));
        return dataSource;
    }
}
