package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/30/12
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddFarmsTroops extends JPanel {

    private static JTextField spearTextFieldFarmAdder;
    private static JTextField swordTextFieldFarmAdder;
    private static JTextField axeTextFieldFarmAdder;
    private static JTextField scoutTextFieldFarmAdder;
    private static JTextField lightCalTextFieldFarmAdder;
    private static JTextField paladinTextFieldFarmAdder;
    private static JTextField catapultTextFieldFarmAdder;
    private static JTextField ramTextFieldFarmAdder;
    private static JTextField heavyCalTextFieldFarmAdder;
    private static JTextField mountedArcherTextFieldFarmAdder;
    private static JTextField archerTextFieldFarmAdder;
    private static JTextField nobleTextFieldFarmAdder;
    public AddFarmsTroops() {

        //create size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 180;

        //set size of panel
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create the colors used for the background and border line
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the border color and title of the JPanel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Number of Troops"));

        //Set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();



        //swing components
        spearTextFieldFarmAdder = new JTextField(5);
        swordTextFieldFarmAdder = new JTextField(5);
        axeTextFieldFarmAdder = new JTextField(5);
        scoutTextFieldFarmAdder = new JTextField(5);
        lightCalTextFieldFarmAdder = new JTextField(5);
        catapultTextFieldFarmAdder = new JTextField(5);
        ramTextFieldFarmAdder = new JTextField(5);
        heavyCalTextFieldFarmAdder = new JTextField(5);
        mountedArcherTextFieldFarmAdder = new JTextField(5);
        archerTextFieldFarmAdder = new JTextField(5);
        nobleTextFieldFarmAdder = new JTextField(5);

        paladinTextFieldFarmAdder = new JTextField(5);
        paladinTextFieldFarmAdder.setEnabled(false);
        paladinTextFieldFarmAdder.setBackground(Color.GRAY);

        JLabel spearIconFarmAdder = new JLabel ("", TroopsDetailPanel.getSpearIcon(), JLabel.CENTER);
        spearIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        spearIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        spearIconFarmAdder.setBackground(bgColor);
        spearIconFarmAdder.setOpaque(true);
        spearIconFarmAdder.setBorder(null);

        JLabel swordIconFarmAdder = new JLabel ("",TroopsDetailPanel.getSwordIcon(), JLabel.CENTER);
        swordIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        swordIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        swordIconFarmAdder.setBackground(bgColor);
        swordIconFarmAdder.setOpaque(true);
        swordIconFarmAdder.setBorder(null);

        JLabel axeIconFarmAdder = new JLabel ("", TroopsDetailPanel.getAxeIcon(), JLabel.CENTER);
        axeIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        axeIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        axeIconFarmAdder.setBackground(bgColor);
        axeIconFarmAdder.setOpaque(true);
        axeIconFarmAdder.setBorder(null);

        JLabel scoutIconFarmAdder = new JLabel ("", TroopsDetailPanel.getScoutIcon(), JLabel.CENTER);
        scoutIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        scoutIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        scoutIconFarmAdder.setBackground(bgColor);
        scoutIconFarmAdder.setOpaque(true);
        scoutIconFarmAdder.setBorder(null);

        JLabel lightCalIconFarmAdder = new JLabel ("", TroopsDetailPanel.getLightCalIcon(), JLabel.CENTER);
        lightCalIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        lightCalIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        lightCalIconFarmAdder.setBackground(bgColor);
        lightCalIconFarmAdder.setOpaque(true);
        lightCalIconFarmAdder.setBorder(null);

        JLabel paladinIconFarmAdder = new JLabel ("", TroopsDetailPanel.getPaladinIcon(), JLabel.CENTER);
        paladinIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        paladinIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        paladinIconFarmAdder.setBackground(bgColor);
        paladinIconFarmAdder.setOpaque(true);
        paladinIconFarmAdder.setBorder(null);

        JLabel catapultIconFarmAdder = new JLabel ("", TroopsDetailPanel.getCatapultIcon(), JLabel.CENTER);
        catapultIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        catapultIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        catapultIconFarmAdder.setBackground(bgColor);
        catapultIconFarmAdder.setOpaque(true);
        catapultIconFarmAdder.setBorder(null);

        JLabel ramIconFarmAdder = new JLabel ("",TroopsDetailPanel.getRamIcon(), JLabel.CENTER);
        ramIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        ramIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        ramIconFarmAdder.setBackground(bgColor);
        ramIconFarmAdder.setOpaque(true);
        ramIconFarmAdder.setBorder(null);

        JLabel heavyCalIconFarmAdder = new JLabel ("", TroopsDetailPanel.getHeavyCalIcon(), JLabel.CENTER);
        heavyCalIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        heavyCalIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        heavyCalIconFarmAdder.setBackground(bgColor);
        heavyCalIconFarmAdder.setOpaque(true);
        heavyCalIconFarmAdder.setBorder(null);

        JLabel mountedArcherIconFarmAdder = new JLabel ("", TroopsDetailPanel.getMountedArcherIcon(), JLabel.CENTER);
        mountedArcherIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        mountedArcherIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        mountedArcherIconFarmAdder.setBackground(bgColor);
        mountedArcherIconFarmAdder.setOpaque(true);
        mountedArcherIconFarmAdder.setBorder(null);

        JLabel archerIconFarmAdder = new JLabel ("", TroopsDetailPanel.getArcherIcon(), JLabel.CENTER);
        archerIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        archerIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        archerIconFarmAdder.setBackground(bgColor);
        archerIconFarmAdder.setOpaque(true);
        archerIconFarmAdder.setBorder(null);

        JLabel nobleIconFarmAdder = new JLabel ("", TroopsDetailPanel.getNobleIcon(), JLabel.CENTER);
        nobleIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        nobleIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        nobleIconFarmAdder.setBackground(bgColor);
        nobleIconFarmAdder.setOpaque(true);
        nobleIconFarmAdder.setBorder(null);



        ///////First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.gridy = 0;
        add(spearIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(swordIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(archerIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(axeIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(mountedArcherIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(paladinIconFarmAdder, gc);



        /////// Second Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(spearTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=1;
        add(swordTextFieldFarmAdder, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(archerTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=3;
        add(axeTextFieldFarmAdder, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(mountedArcherTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=5;
        add(paladinTextFieldFarmAdder, gc);

        ///////Third Column////////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 2;
        gc.gridy = 0;
        add(scoutIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(lightCalIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(heavyCalIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        add(catapultIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        add(ramIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 5;
        add(nobleIconFarmAdder, gc);


        ///////Fourth Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 3;
        gc.gridy = 0;
        add(scoutTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        add(lightCalTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        add(heavyCalTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        add(catapultTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        add(ramTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 5;
        add(nobleTextFieldFarmAdder, gc);
    }

    public static String getSpearTextFieldFarmAdder() {
        return spearTextFieldFarmAdder.getText();
    }

    public static String getSwordTextFieldFarmAdder() {
        return swordTextFieldFarmAdder.getText();
    }

    public static String getAxeTextFieldFarmAdder() {
        return axeTextFieldFarmAdder.getText();
    }

    public static String getScoutTextFieldFarmAdder() {
        return scoutTextFieldFarmAdder.getText();
    }

    public static String getLightCalTextFieldFarmAdder() {
        return lightCalTextFieldFarmAdder.getText();
    }

    public static String getPaladinTextFieldFarmAdder() {
        return paladinTextFieldFarmAdder.getText();
    }

    public static String getCatapultTextFieldFarmAdder() {
        return catapultTextFieldFarmAdder.getText();
    }

    public static String getRamTextFieldFarmAdder() {
        return ramTextFieldFarmAdder.getText();
    }

    public static String getHeavyCalTextFieldFarmAdder() {
        return heavyCalTextFieldFarmAdder.getText();
    }

    public static String getMountedArcherTextFieldFarmAdder() {
        return mountedArcherTextFieldFarmAdder.getText();
    }

    public static String getArcherTextFieldFarmAdder() {
        return archerTextFieldFarmAdder.getText();
    }

    public static String getNobleTextFieldFarmAdder() {
        return nobleTextFieldFarmAdder.getText();
    }

    public static void setSpearTextFieldFarmAdder(String text) {
        AddFarmsTroops.spearTextFieldFarmAdder.setText(text);
    }

    public static void setSwordTextFieldFarmAdder(String text) {
        AddFarmsTroops.swordTextFieldFarmAdder.setText(text);
    }

    public static void setAxeTextFieldFarmAdder(String text) {
        AddFarmsTroops.axeTextFieldFarmAdder.setText(text);
    }

    public static void setScoutTextFieldFarmAdder(String text) {
        AddFarmsTroops.scoutTextFieldFarmAdder.setText(text);
    }

    public static void setLightCalTextFieldFarmAdder(String text) {
        AddFarmsTroops.lightCalTextFieldFarmAdder.setText(text);
    }

    public static void setPaladinTextFieldFarmAdder(String text) {
        AddFarmsTroops.paladinTextFieldFarmAdder.setText(text);
    }

    public static void setCatapultTextFieldFarmAdder(String text) {
        AddFarmsTroops.catapultTextFieldFarmAdder.setText(text);
    }

    public static void setRamTextFieldFarmAdder(String text) {
        AddFarmsTroops.ramTextFieldFarmAdder.setText(text);
    }

    public static void setHeavyCalTextFieldFarmAdder(String text) {
        AddFarmsTroops.heavyCalTextFieldFarmAdder.setText(text);
    }

    public static void setMountedArcherTextFieldFarmAdder(String text) {
        AddFarmsTroops.mountedArcherTextFieldFarmAdder.setText(text);
    }

    public static void setArcherTextFieldFarmAdder(String text) {
        AddFarmsTroops.archerTextFieldFarmAdder.setText(text);
    }

    public static void setNobleTextFieldFarmAdder(String text) {
        AddFarmsTroops.nobleTextFieldFarmAdder.setText(text);
    }
}