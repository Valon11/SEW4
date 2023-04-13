import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String filename = "img/eichhoernchen.jpg";
        DBManagement dbManagement = null;

        try (FileInputStream input = new FileInputStream("dbconnect.properties")) {

            Properties properties = new Properties();
            properties.load(input);

            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");


            try (Connection con = DriverManager.getConnection(url, user, password)) {
                InputStream inputStream = new BufferedInputStream(new FileInputStream(filename));
                dbManagement = new DBManagement(con);
                dbManagement.createTables();
                dbManagement.insertIntoBenutzerBlog("valon", "hyseni", "valonsBlog", new Date(System.currentTimeMillis()),0);
                dbManagement.preparedInserts();
                dbManagement.fillPreparedInserts(inputStream, new Date(System.currentTimeMillis()), "blablabla", 0,0);
                dbManagement.preparedSelect1();
                dbManagement.preparedSelect2();
                dbManagement.fillPreparedSelects(0, "valon");

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                dbManagement.closePreparedStatements();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}