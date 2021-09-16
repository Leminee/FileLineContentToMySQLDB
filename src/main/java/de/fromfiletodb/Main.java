package de.fromfiletodb;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        DBConnection dbConnection = new DBConnection();

        System.out.println("port number for mysql (default 3306):");
        dbConnection.setDbPort(sc.nextInt());
        sc.nextLine();

        System.out.println("database name: ");
        dbConnection.setDatabaseName(sc.nextLine());

        System.out.println("database user account: ");
        dbConnection.setDbUsername(sc.nextLine());

        System.out.println("database user password: ");
        dbConnection.setDbPassword(sc.nextLine());

        dbConnection.initialize();

        String filePath;
        String column;
        String tableName;

        System.out.println("filepath");
        filePath = sc.nextLine();

        System.out.println("table name");
        tableName = sc.nextLine();

        System.out.println("column name");
        column = sc.nextLine();

        String insertQuery = "INSERT INTO " + tableName + " (" + column + ") VALUES (?);";

        System.out.println("Data is written to the database...");

        Script.storeDataIntoDb(new FileReader(filePath), insertQuery);

    }
}
