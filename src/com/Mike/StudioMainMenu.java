package com.Mike;

import javax.swing.*;
import java.awt.*;

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

    private static String MAIN_MENU = "Main menu panel";
    private static String CLIENTS = "Client interaction panel";
    private  static String CALENDER = "Calender panel";


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
    }
}
