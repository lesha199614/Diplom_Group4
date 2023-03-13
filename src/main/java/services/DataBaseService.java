package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DataBaseService {

//    static final String DB_TYPE = "mysql";
//    static final String SERVER_NAME = "sql7.freesqldatabase.com";
//    static final String PORT = "3306";
//    static final String DB_NAME = "sql7602365";
//    static final String DB_USER = "sql7602365";
//    static final String DB_PASSWORD = "Rr26EGcaER";

    static final String DB_TYPE = "postgresql";
    static final String SERVER_NAME = "localhost";
    static final String PORT = "5432";
    static final String DB_NAME = "postgres";

    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "Platenclene987";

    Connection connection;

    Logger logger = LogManager.getLogger(DataBaseService.class);

    public DataBaseService() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbc = "jdbc:" + DB_TYPE + "://" + SERVER_NAME + ":" + PORT + "/" + DB_NAME;

        try {
            connection = DriverManager.getConnection(jdbc, DB_USER, DB_PASSWORD);
            logger.info("DB connected successfully...");
        } catch (SQLException e) {
            logger.info("Something went wrong...");
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        try {
            return this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeSQL(String sql) {
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}