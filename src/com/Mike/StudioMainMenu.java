package com.Mike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mike on 12/7/2015.
 */
public class StudioMainMenu extends JFrame {

    private JPanel rootPanel;
    private JPanel clientPanel;
    private JPanel calenderPanel;
    private JPanel mainMenuPanel;
    private JButton addRemoveClientButton;
    private JButton checkScheduleButton;
    private JButton bookSessionButton;
    private JButton quitButton;
    private JButton addClientButton;
    private JButton deleteClientButton;
    private JButton viewClientsRecordsButton;
    private JButton backToMenuButton;
    private JButton returnToMenuButton;
    private JPanel viewClients;
    private JPanel addClients;
    private JPanel deleteClients;
    private JPanel clientViewer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton zButton;

    // Main menu card names
    private static String MAIN_MENU = "Main menu panel";
    private static String CLIENTS = "Client interaction panel";
    private  static String CALENDER = "Calender panel";
    // Client panel - Client viewer card names
    private static String VIEW_CLIENTS = "Client list";
    private static String ADD_CLIENTS = "Client Text Inputs";
    private static String DELETE_CLIENTS = "Remove Clients";


    StudioMainMenu(){

        setTitle("Studio Assistant");
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));
        setVisible(true);

        // Add cards to the root Jpanel. Each  card needs a string to identify it, use constants.
        rootPanel.add(mainMenuPanel, MAIN_MENU);
        rootPanel.add(clientPanel, CLIENTS);
        rootPanel.add(calenderPanel, CALENDER);
        // Add cards to the client panel -> client view (allows the changing of the JPanel within the client panel to display the different formats
//        clientPanel.add(clientViewer,ADD_CLIENTS);
//        clientPanel.add(clientViewer,VIEW_CLIENTS);
//        clientPanel.add(clientViewer,DELETE_CLIENTS);



        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // BUTTON FUNCTION FROM MAIN MENU
        addRemoveClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout) rootPanel.getLayout();
                c1.show(rootPanel, CLIENTS);

            }
        });
        checkScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout) rootPanel.getLayout();
                c2.show(rootPanel,CALENDER);
            }
        });
        // BUTTON FUNCTION FROM CALENDER
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout)rootPanel.getLayout();
                c1.show(rootPanel,MAIN_MENU);

            }
        });

        // BUTTON FUNCTIONS FROM CLIENTS
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout)rootPanel.getLayout();
                c1.show(rootPanel,MAIN_MENU);
            }
        });
    }
}
