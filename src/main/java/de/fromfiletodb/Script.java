package de.fromfiletodb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Script {

    public static void storeDataIntoDb(FileReader filePath, String insertQuery) throws IOException {


        try (BufferedReader bufferedReader = new BufferedReader(filePath)) {

            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(insertQuery);

            while (bufferedReader.readLine() != null) {

                preparedStatement.setBlob(1, setTransformedString(preparedStatement, bufferedReader.readLine()));
                preparedStatement.executeUpdate();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File was not found");

        } catch (SQLException sqlException) {
            System.err.println("SQL Error");

        }
    }

    private static Blob setTransformedString(PreparedStatement userDataInput, String userName) throws SQLException {
        byte[] byteArray = userName.getBytes();
        Blob blob = userDataInput.getConnection().createBlob();
        blob.setBytes(1, byteArray);

        return blob;
    }

}
