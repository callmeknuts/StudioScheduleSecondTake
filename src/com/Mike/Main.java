package com.Mike;
import javax.swing.*;
import java.sql.*;


public class Main {


    public static void main(String[] args) {

        /** set log-in fields for DB connection */
        LogIn logIn = new LogIn();
        logIn.pack();
        logIn.setVisible(true);

        DatabaseManager.setup();
        StudioMainMenu studioMainMenu = new StudioMainMenu();
        //shutdown();
    }

    public static void createUser(String name,String number,String address, String email){
        String createUser = "INSERT INTO clients (name,number,address,email) VALUES ('"+ name + "','" + number + "','" + address + "','" + email + "')";
        System.out.println(createUser);
        try {
            DatabaseManager.statement.executeUpdate(createUser);
            JOptionPane.showMessageDialog(null, "User" + name + " successfully created.");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteUser (JList clientList){
        ListModel listModel = clientList.getModel();
        Client client = (Client) listModel.getElementAt(clientList.getSelectedIndex());
        String delete ="DELETE FROM clients WHERE id = '" + client.getId() + "'";
        System.out.println(delete);
        // TODO stop exception being thrown when delete button is pressed with empty database
            try {
                DatabaseManager.statement.execute(delete);
                System.out.println(clientList.getSelectedIndex());
                clientList.remove(clientList.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "User deleted.");
                clientList.updateUI();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public static void showUser(JList clientList){
        String showUsers ="SELECT * FROM clients";
        DefaultListModel listModel = new DefaultListModel();
        try{
            ResultSet rs = DatabaseManager.statement.executeQuery(showUsers);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String number = rs.getString("number");
                String address = rs.getString("address");
                String email = rs.getString("Email");
                Client client = new Client(id, name, number,address,email);
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
            if(DatabaseManager.statement != null){
                DatabaseManager.statement.close();
                System.out.println("Statement closed");
            }
        } catch (SQLException se){
            //close the connection, possible exception
            se.printStackTrace();
        }
        try {
            if(DatabaseManager.conn != null){
                DatabaseManager.conn.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException se){
            se.printStackTrace();
        }
        System.exit(0);
    }
}
