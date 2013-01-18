package com.gmail.ttkyle.src;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the panel that contains the login and password textfields
 * Uses user supplied paramaters to log in to tribalwars.
 */
public class DetailsPanel extends JPanel {



    private EventListenerList listenerList = new EventListenerList();
    private static JComboBox serverListComboBox;

    public  DetailsPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 120;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the color and title of the border
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Tribal Wars Details"));

        //text fields for the user to supply user name and password
        final JTextField nameField = new JTextField(10);
        final JTextField passwordField = new JTextField(10);

        String[] serverList = {"World en58       "    , "World en59", "World en60", "World en61", "World en62",
                               "World en63", "World en64", "World en65", "World en66"};

        serverListComboBox = new JComboBox(serverList);
        serverListComboBox.setSelectedIndex(7);
        serverListComboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                //later
            }
        });

        String currentlySelectedServer = DetailsPanel.getServerListComboBox().getSelectedItem().toString();
        System.out.println(currentlySelectedServer.substring(6, 10));

        //labels to let the user know what the textfields are for
        JLabel  nameLabel = new JLabel("User:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel server = new JLabel("Server");

        //the login button
        JButton loginButton = new JButton("        Login" + "        ");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String pass = passwordField.getText();

                try {
                    WebAutomation.login(name, pass);
                }
                catch (InterruptedException e1) {
                }

                fireDetailEvent(new DetailEvent(this));

            }
        });

        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx =  0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(passwordLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(server, gc);

        ////// Second column /////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(passwordField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(serverListComboBox, gc);

        ///final row
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .0;
        gc.weighty = .0;

        gc.gridx = 1;
        gc.gridy = 3;
        add(loginButton, gc);
    }


    //Steps through events and fires them
    public void fireDetailEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if(listeners[i] == DetailListener.class) {
                ((DetailListener)listeners[i+1]).detailEventOccurred(event);
            }
        }
    }

    //adds detail listeners to detail panel
    public void addDetailListener(DetailListener listener) {
        listenerList.add(DetailListener.class, listener);
    }

    //removes detail listeners to detail panel
    public void removeDetailListener(DetailListener listener) {
        listenerList.remove(DetailListener.class, listener);
    }

    public static JComboBox getServerListComboBox() {
        return serverListComboBox;
    }

    public static void setServerListComboBox(JComboBox serverListComboBox) {
        DetailsPanel.serverListComboBox = serverListComboBox;
    }
}
