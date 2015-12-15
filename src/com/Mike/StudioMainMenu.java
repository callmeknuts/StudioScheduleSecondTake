package com.Mike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by Mike on 12/7/2015.
 */
public class StudioMainMenu extends JFrame {
    /** top-level panels   */
    public JPanel rootPanel;
    private JPanel clientPanel;
    public JPanel calenderPanel;
    private JPanel studioPanel;
    private JPanel mainMenuPanel;

    private JButton addRemoveClientButton;
    private JButton checkScheduleButton;
    private JButton studioDescriptionButton;
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
    /** for data entry */
    private JTextField clientFName;
    private JTextField clientLName;
    private JTextField phoneNumber;
    private JTextField clientAddress;
    private JTextField clientEmail;
    /** to  assign data collected during data entry, allowing it to be used */
    private String fNameOfClient;
    private String lNameOfClient;
    private String numberOfClient;

    private String addressOfClient;
    private String emailOfClient;
    private JList clientList;
    private JButton submitButton;

    private JButton studioThreeButton;
    private JButton studioOneButton;
    private JButton studioTwoButton;
    private JPanel studioViewer;
    private JPanel studioOne;
    private JPanel studioTwo;
    private JPanel studioThree;
    private JTextField studioOneEquipmentTextField;
    private JLabel studioName;
    private JButton mainMenuButton;
    //private JButton zButton;

    // Main menu card names
    private static String MAIN_MENU = "Main menu panel";
    private static String CLIENTS = "Client interaction panel";
    private static String CALENDER = "Calender panel";
    private static String STUDIO_DESC = "Studio information";
    // Client panel - Client viewer card names
    private static String VIEW_CLIENTS = "Client list";
    private static String ADD_CLIENTS = "Client Text Inputs";
    private static String DELETE_CLIENTS = "Remove Clients";
    // Studio panel - studioViewer card names
    private static String STUDIO_ONE = "Studio one description";
    private static String STUDIO_TWO = "Studio two description";
    private static String STUDIO_THREE = "Studio three description";

//    private static String CALENDEROBJECT = "Calender";
    //private static String ADD_FIELDS = "add client text inputs";


    StudioMainMenu(){
        // sets gui window to take look of windows from host computer
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e){
            System.out.println(e);}
        catch (InstantiationException e){}
        catch (IllegalAccessException e){}
        catch (UnsupportedLookAndFeelException e){}


        setTitle("Studio Assistant");
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));
        setVisible(true);

        /** Add cards to the root Jpanel. Each  card needs a string to identify it, use constants.*/
        rootPanel.add(mainMenuPanel, MAIN_MENU);
        rootPanel.add(clientPanel, CLIENTS);
        rootPanel.add(calenderPanel, CALENDER);
//        rootPanel.add(calender);
        //TODO Why can't I instiante the calender
        rootPanel.add(studioPanel,STUDIO_DESC);

        /** Add cards to the client panel -> client view (allows the changing of the JPanel
         *  within the client panel to display the different formats*/
        clientViewer.add(viewClients, VIEW_CLIENTS);
        clientViewer.add(addClients, ADD_CLIENTS);
        clientViewer.add(deleteClients, DELETE_CLIENTS);
        /** Add cards to the client      */
        studioViewer.add(studioOne, STUDIO_ONE);
        studioViewer.add(studioTwo, STUDIO_TWO);
        studioViewer.add(studioThree,STUDIO_THREE);




    /**BUTTON FUNCTION FROM MAIN MENU*/
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
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
                CardLayout c1 = (CardLayout) rootPanel.getLayout();
                c1.show(rootPanel,CALENDER);

            }
        });
        studioDescriptionButton.addActionListener(new ActionListener() {
            @ Override
            public void actionPerformed(ActionEvent e){
                CardLayout c1 = (CardLayout) rootPanel.getLayout();
                c1.show(rootPanel,STUDIO_DESC);

            }
        });
        /** BUTTON FUNCTION FROM CALENDER*/
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  Calender calender = new Calender();
                CardLayout c3 = (CardLayout)rootPanel.getLayout();
                c3.show(rootPanel,MAIN_MENU);

            }
        });

        /** BUTTON FUNCTIONS FROM CLIENTS */
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout)rootPanel.getLayout();
                c2.show(rootPanel,MAIN_MENU);
            }
        });
        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout)clientViewer.getLayout();
                c2.show(clientViewer,ADD_CLIENTS);
            }
        });
        viewClientsRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout)clientViewer.getLayout();
                c2.show(clientViewer,VIEW_CLIENTS);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fNameOfClient = clientFName.getText();
                lNameOfClient = clientLName.getText();
                if (isPhoneNumberValid(phoneNumber.getText())){
                    numberOfClient = phoneNumber.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                }
                addressOfClient = clientAddress.getText();
                if(isEmailAddressValid(clientEmail.getText())){
                    emailOfClient = clientEmail.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Please use a valid Email address.");
                }
                System.out.println(fNameOfClient);
                System.out.println(lNameOfClient);
                System.out.println(numberOfClient);
                System.out.println(addressOfClient);
                System.out.println(emailOfClient);
                while (emailOfClient != null && numberOfClient != null) {
                    com.Mike.Main.createUser(fNameOfClient, lNameOfClient, numberOfClient, addressOfClient, emailOfClient);
                    break;
                }
                clientFName.setText("");
                clientLName.setText("");
                phoneNumber.setText("");
                clientAddress.setText("");
                clientEmail.setText("");


            }
        });
        viewClientsRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c3 = (CardLayout)clientViewer.getLayout();
                c3.show(clientViewer,VIEW_CLIENTS);

                com.Mike.Main.showUser(clientList);
            }
        });
        deleteClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.Mike.Main.deleteUser(clientList);

            }
        });
        studioOneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studioName.setText("Studio One");
                CardLayout c4 = (CardLayout)studioViewer.getLayout();
                c4.show(studioViewer, STUDIO_ONE);
            }
        });
        studioTwoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studioName.setText("Studio Two");
                CardLayout c4 = (CardLayout)studioViewer.getLayout();
                c4.show(studioViewer,STUDIO_TWO);
            }
        });
        studioThreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studioName.setText("Studio Three");
                CardLayout c4 = (CardLayout)studioViewer.getLayout();
                c4.show(studioViewer, STUDIO_THREE);
            }
        });
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout)rootPanel.getLayout();
                c2.show(rootPanel,MAIN_MENU);
            }
        });
    }
    /** data validation regex pattern methods to validate JTextfields */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null) return  false;
        if (phoneNumber.matches("\\d{10}")) return true;
        else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        else return false;
    }

    public static boolean isEmailAddressValid(String emailAddress){
        if (emailAddress == null)return false;
        if (emailAddress.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))return  true;
        else return false;
    }


    public static String getCALENDER() {
        return CALENDER;
    }

    /** CREATE CALANDER  */


    public JPanel getStudioPanel() {
        return studioPanel;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

