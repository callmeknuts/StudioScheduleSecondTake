package com.Mike;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Main {

    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static String DB_NAME = "clients";
    static final String USER = "root";
    static final String PASSWORD ="badmofo-P2";
    static Statement statement = null;
    static Connection conn = null;
    static ResultSet rs;

    public static void main(String[] args) {
        setup();
        StudioMainMenu studioMainMenu = new StudioMainMenu();


    }

    public static void setup(){
        try {
            try{
                String Driver = "com.mysql.jdbc.Driver";
                Class.forName(Driver);
            } catch (ClassNotFoundException cnfe){
                System.out.println("No database drivers found. Quitting");
                System.exit(-1);
            }
            conn = DriverManager.getConnection(DB_CONNECTION_URL +DB_NAME, USER, PASSWORD);
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //Create table in the database
            // clients table includes (Name,Phone Number, address, email)
            String createTableSQL = "CREATE TABLE clients " +
                    "(name varchar(30),number varchar(14),address varchar(30),email varchar(40))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created");

            String createDatabase = "CREATE DATABASE clients";
            statement.executeUpdate(createDatabase);


            // TODO add some data

        } catch (SQLException sqle){
            System.out.println("The client table (might) already exist, verify with following message");
            System.out.println(sqle);
        }
    }

    public static void createUser(String name,String number,String address, String email){
        String createUser = "INSERT INTO clients (name,number,address,email) VALUES ('"+ name + "','" + number + "','" + address + "','" + email + "')";
        System.out.println(createUser);
        try {
            statement.executeUpdate(createUser);
            JOptionPane.showMessageDialog(null, "User" + name + " successfully created.");


        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteUser (){

    }

    public static void showUser(JList clientList){
        String showUsers ="SELECT * FROM clients";
        DefaultListModel listModel = new DefaultListModel();
        try{
            ResultSet rs = statement.executeQuery(showUsers);
            while (rs.next()){
                String name = rs.getString("name");
                String number = rs.getString("number");
                String address = rs.getString("address");
                String email = rs.getString("Email");
                Client client = new Client(name, number,address,email);
                listModel.addElement(client);
            }
            clientList.setModel(listModel);
            clientList.setSelectedIndex(0);

            //JScrollPane listScroller = new JScrollPane(list);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void shutdown(){
        try {
            if(statement != null){
                statement.close();
                System.out.println("Statement closed");
            }
        } catch (SQLException se){
            //close the connection, possible exception
            se.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException se){
            se.printStackTrace();
        }
        System.exit(0);
    }
}
