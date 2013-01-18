package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;

/**
 * This panel will let the user know what village that they are
 * currently manipulating or which village the bot is currently
 * manipulating.
 *
 * This class is a work in progress!!!
 */
public class CurrentVillagePanel extends JPanel {

    //public static JLabel villageNumLabel;
    public static JLabel villageNameLabel;
    public static JLabel villageCoordLabel;

    public CurrentVillagePanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 105;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the color and title of the border
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Current Village"));


        //JLables to let the user know what they are manipulating
        JLabel villageNum = new JLabel("Village Num: ");
        JLabel villageName = new JLabel("Village Name: ");
        JLabel villageCoords = new JLabel("Village Coord: ");

         /*
        villageNumLabel = new JLabel (" 0");
        villageNumLabel.setVerticalTextPosition(JLabel.TOP);
        villageNumLabel.setHorizontalTextPosition(JLabel.RIGHT);
        villageNumLabel.setBackground(bgColor);
        villageNumLabel.setOpaque(true);
        villageNumLabel.setBorder(null);
        */

        //labels that will change depending on which village
        //the  user selects from the drop down box
        villageNameLabel = new JLabel (" 0");
        villageNameLabel.setVerticalTextPosition(JLabel.TOP);
        villageNameLabel.setHorizontalTextPosition(JLabel.RIGHT);
        villageNameLabel.setBackground(bgColor);
        villageNameLabel.setOpaque(true);
        villageNameLabel.setBorder(null);

        villageCoordLabel = new JLabel (" 0");
        villageCoordLabel.setVerticalTextPosition(JLabel.TOP);
        villageCoordLabel.setHorizontalTextPosition(JLabel.RIGHT);
        villageCoordLabel.setBackground(bgColor);
        villageCoordLabel.setOpaque(true);
        villageCoordLabel.setBorder(null);


        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //test array to populate the combobox
        String[] villageStrings = { "Test Village 1", "Test Village 2", "Test Village 3", "Test Village 4", "Test Village 5" };
        JComboBox villageList = new JComboBox(villageStrings);

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.0;
        gc.weighty = 0.0;

        gc.gridx =  0;
        gc.gridy = 0;
        add(villageNum, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(villageName, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(villageCoords, gc);


        //////////Second Column//////////////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx =  1;
        gc.gridy = 0;
        add(villageList, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(villageNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(villageCoordLabel, gc);
    }
}
