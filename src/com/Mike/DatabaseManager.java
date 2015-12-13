package com.Mike;

import java.sql.*;

/**
 * Created by Mike on 12/12/2015.
 */
public class DatabaseManager {
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = LogIn.getUser();
    static final String PASSWORD =LogIn.getPassword();

    static Statement statement = null;
    static Connection conn = null;
    public static void setup(){
        try {
            try{
                //check for MySql drivers
                String Driver = "com.mysql.jdbc.Driver";
                Class.forName(Driver);
            } catch (ClassNotFoundException cnfe){
                System.out.println("No database drivers found. Quitting");
                System.exit(-1);
            }
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            // create database
            //TODO java needs database to make connection, do I need to move below statement into the connection block of code??
            String createDatabase = "CREATE DATABASE IF NOT EXISTS clients";
            statement.executeUpdate(createDatabase);

            String useDatabase = "USE clients";
            statement.execute(useDatabase);

            //Create table in the database
            // clients table includes (Name,Phone Number, address, email)
            //TODO add If EXISTS
            String createTableSQL = "CREATE TABLE IF NOT EXISTS clients " +
                    "(id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY (id), name VARCHAR(30),number VARCHAR(14),address VARCHAR(30),email VARCHAR(40))";
            statement.executeUpdate(createTableSQL);
            //System.out.println("Table created");

        } catch (SQLException sqle){
            System.out.println("The client table (might) already exist, verify with following message");
            System.out.println(sqle);
        }
    }

}
