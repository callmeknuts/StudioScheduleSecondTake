package com.Mike;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mike on 12/12/2015.
 * Program assistance from Timmothy Milligan with LogIn.java file.
 */
public class LogIn extends JDialog{
    private JPanel logInPanel;
    private JTextField nameTextField;
    private JPasswordField passwordField;
    private JButton button1;

    private static String user;
    private static String password = "";

    public LogIn() {
        setContentPane(logInPanel);
        pack();
        setLocationRelativeTo(null);
        setSize(new Dimension(400,200));
        setTitle("Database Log-IN");
        setModal(true);
        getRootPane().setDefaultButton(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grantAccess();
            }
        });
    }
    /** Timmy helped me figure out how to allow use of user inputted variables for USER and PW instead of using hard coded values from MAIN */
    private void grantAccess(){
        user = nameTextField.getText();
        for (char x : passwordField.getPassword()){
            String str = String.valueOf(x);
            password = password + str;
        }
        System.out.println(user + " is connected");
        dispose();

    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
