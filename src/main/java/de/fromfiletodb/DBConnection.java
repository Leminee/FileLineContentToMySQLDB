package de.fromfiletodb;

import java.sql.*;

public class DBConnection {

    public static Connection connection;
    private String dbUsername;
    private String dbPassword;
    private int dbPort;
    private String databaseName;


    public void initialize() {
        try {

            String dbUrl = "jdbc:mysql://localhost:" + dbPort + "/" + databaseName + "?autoReconnect=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }


    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}

