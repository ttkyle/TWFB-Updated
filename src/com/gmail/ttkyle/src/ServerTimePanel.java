package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/10/12
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServerTimePanel extends JPanel {

    private static JLabel serverTime;

    public ServerTimePanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 38;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the border color and title of the JPanel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), ""));



        serverTime = new JLabel ("Server time: ");
        serverTime.setVerticalTextPosition(JLabel.TOP);
        serverTime.setHorizontalTextPosition(JLabel.RIGHT);
        serverTime.setBackground(bgColor);
        serverTime.setOpaque(true);
        serverTime.setBorder(null);

        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.0;
        gc.weighty = 1.0;
        gc.insets = new Insets(0, 0, 0, 45);
        gc.gridx =  0;
        gc.gridy = 0;
        add(serverTime, gc);
    }

    public static void setServerTime(String label) {
        serverTime.setText(label);
    }
}
