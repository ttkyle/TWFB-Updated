/**
 * Used to display number of troops in village.
 */
package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class TroopsDetailPanel extends JPanel {

    //global variables
    private static JLabel spearLabel;
    private static JLabel swordLabel;
    private static JLabel axeLabel;
    private static JLabel spyLabel;
    private static JLabel lightCalLabel;
    private static JLabel paladinLabel;
    private static JLabel catapultLabel;
    private static JLabel populationCountLabel;
    private static JLabel ramLabel;
    private static JLabel nobleLabel;
    private static JLabel mountedArcherLabel;
    private static JLabel heavyCalLabel;
    private static JLabel archerLabel;
    private static ImageIcon spearIcon;
    private static ImageIcon axeIcon;
    private static ImageIcon lightCalIcon;
    private static ImageIcon scoutIcon;
    private static ImageIcon swordIcon;
    private static ImageIcon paladinIcon;
    private static ImageIcon catapultIcon;
    private static ImageIcon nobleIcon;
    private static ImageIcon populationCountIcon;
    private static ImageIcon ramIcon;
    private static ImageIcon mountedArcherIcon;
    private static ImageIcon heavyCalIcon;
    private static ImageIcon archerIcon;




    public TroopsDetailPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 238;   //262    275
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //various troop icons
         spearIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\spear.png");
         axeIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\axe.png");
         lightCalIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\lightcal.png");
         scoutIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\scout.png");
         swordIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\sword.png");
         paladinIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\paladin.png");
         catapultIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\catapult.png");
         populationCountIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\farmFace.png");
         nobleIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\snob.png");
         ramIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\unit_ram.png");
         mountedArcherIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\unit_marcher.png");
         heavyCalIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\unit_heavy.png");
         archerIcon = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\unit_archer.png");

        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //sets the border color and title
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Tribal Wars Troop Count"));


        /////////////////troop count labels///////////////
        populationCountLabel = new JLabel ("0 " + "/ " + "0", populationCountIcon, JLabel.CENTER);
        populationCountLabel.setVerticalTextPosition(JLabel.TOP);
        populationCountLabel.setHorizontalTextPosition(JLabel.RIGHT);
        populationCountLabel.setBackground(bgColor);
        populationCountLabel.setOpaque(true);
        populationCountLabel.setBorder(null);

        spearLabel = new JLabel ("0", spearIcon, JLabel.CENTER);
        spearLabel.setVerticalTextPosition(JLabel.TOP);
        spearLabel.setHorizontalTextPosition(JLabel.RIGHT);
        spearLabel.setBackground(bgColor);
        spearLabel.setOpaque(true);
        spearLabel.setBorder(null);

        swordLabel = new JLabel ("0", swordIcon, JLabel.CENTER);
        swordLabel.setVerticalTextPosition(JLabel.TOP);
        swordLabel.setHorizontalTextPosition(JLabel.RIGHT);
        swordLabel.setBackground(bgColor);
        swordLabel.setOpaque(true);
        swordLabel.setBorder(null);

        axeLabel = new JLabel ("0", axeIcon, JLabel.CENTER);
        axeLabel.setVerticalTextPosition(JLabel.TOP);
        axeLabel.setHorizontalTextPosition(JLabel.RIGHT);
        axeLabel.setBackground(bgColor);
        axeLabel.setOpaque(true);
        axeLabel.setBorder(null);

        spyLabel = new JLabel ("0", scoutIcon, JLabel.CENTER);
        spyLabel.setVerticalTextPosition(JLabel.TOP);
        spyLabel.setHorizontalTextPosition(JLabel.RIGHT);
        spyLabel.setBackground(bgColor);
        spyLabel.setOpaque(true);
        spyLabel.setBorder(null);

        lightCalLabel = new JLabel ("0", lightCalIcon, JLabel.CENTER);
        lightCalLabel.setVerticalTextPosition(JLabel.TOP);
        lightCalLabel.setHorizontalTextPosition(JLabel.RIGHT);
        lightCalLabel.setBackground(bgColor);
        lightCalLabel.setOpaque(true);
        lightCalLabel.setBorder(null);


        paladinLabel = new JLabel ("0", paladinIcon, JLabel.CENTER);
        paladinLabel.setVerticalTextPosition(JLabel.TOP);
        paladinLabel.setHorizontalTextPosition(JLabel.RIGHT);
        paladinLabel.setBackground(bgColor);
        paladinLabel.setOpaque(true);
        paladinLabel.setBorder(null);

        catapultLabel = new JLabel ("0", catapultIcon, JLabel.CENTER);
        catapultLabel.setVerticalTextPosition(JLabel.TOP);
        catapultLabel.setHorizontalTextPosition(JLabel.RIGHT);
        catapultLabel.setBackground(bgColor);
        catapultLabel.setOpaque(true);
        catapultLabel.setBorder(null);

        ramLabel = new JLabel ("0", ramIcon, JLabel.CENTER);
        ramLabel.setVerticalTextPosition(JLabel.TOP);
        ramLabel.setHorizontalTextPosition(JLabel.RIGHT);
        ramLabel.setBackground(bgColor);
        ramLabel.setOpaque(true);
        ramLabel.setBorder(null);

        heavyCalLabel = new JLabel ("0", heavyCalIcon, JLabel.CENTER);
        heavyCalLabel.setVerticalTextPosition(JLabel.TOP);
        heavyCalLabel.setHorizontalTextPosition(JLabel.RIGHT);
        heavyCalLabel.setBackground(bgColor);
        heavyCalLabel.setOpaque(true);
        heavyCalLabel.setBorder(null);

        mountedArcherLabel = new JLabel ("0", mountedArcherIcon, JLabel.CENTER);
        mountedArcherLabel.setVerticalTextPosition(JLabel.TOP);
        mountedArcherLabel.setHorizontalTextPosition(JLabel.RIGHT);
        mountedArcherLabel.setBackground(bgColor);
        mountedArcherLabel.setOpaque(true);
        mountedArcherLabel.setBorder(null);

        archerLabel = new JLabel ("0", archerIcon, JLabel.CENTER);
        archerLabel.setVerticalTextPosition(JLabel.TOP);
        archerLabel.setHorizontalTextPosition(JLabel.RIGHT);
        archerLabel.setBackground(bgColor);
        archerLabel.setOpaque(true);
        archerLabel.setBorder(null);

        nobleLabel = new JLabel ("0", nobleIcon, JLabel.CENTER);
        nobleLabel.setVerticalTextPosition(JLabel.TOP);
        nobleLabel.setHorizontalTextPosition(JLabel.RIGHT);
        nobleLabel.setBackground(bgColor);
        nobleLabel.setOpaque(true);
        nobleLabel.setBorder(null);




        ////// First Column///////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .1;
        gc.weighty = .1;

        gc.gridx = 0;
        gc.gridy = 1;
        add(populationCountLabel, gc);

        gc.gridx =  0;
        gc.gridy = 2;
        add(spearLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(swordLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(axeLabel, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(spyLabel, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(lightCalLabel, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        add(paladinLabel, gc);

        ////////Second Column ////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .1;
        gc.weighty = .1;

        gc.gridx =  1;
        gc.gridy = 2;
        add(catapultLabel, gc);

        gc.gridx =  1;
        gc.gridy = 3;
        add(ramLabel, gc);

        gc.gridx =  1;
        gc.gridy = 4;
        add(heavyCalLabel, gc);

        gc.gridx =  1;
        gc.gridy = 5;
        add(mountedArcherLabel, gc);

        gc.gridx =  1;
        gc.gridy = 6;
        add(archerLabel, gc);

        gc.gridx =  1;
        gc.gridy = 7;
        add(nobleLabel, gc);
    }


    ////////////Troop setters/////////////
    public static void setSpearLabel(String label) {
        spearLabel.setText(label);
    }

    public static void setSwordLabelLabel(String label) {
        swordLabel.setText(label);
    }

    public static void setAxeLabel(String label) {
        axeLabel.setText(label);
    }

    public static void setSpyLabel(String label) {
        spyLabel.setText(label);
    }

    public static void setLightCalLabel(String label) {
        lightCalLabel.setText(label);
    }

    public static void setPaladinLabel(String label) {
        paladinLabel.setText(label);
    }

    public static void setCatapultLabel(String label) {
        catapultLabel.setText(label);
    }

    public static void setPopulationCountLabel(String label) {
        populationCountLabel.setText(label);
    }

    public static void setRamLabel(String label) {
        ramLabel.setText(label);
    }

    public static void setNobleLabel(String label) {
        nobleLabel.setText(label);
    }

    public static void setMountedArcherLabel(String label) {
        mountedArcherLabel.setText(label);
    }

    public static void setHeavyCalLabel(String label) {
        heavyCalLabel.setText(label);
    }

    public static void setArcherLabel(String label) {
        archerLabel.setText(label);
    }


    ///////////Troop getters///////////
    public static String getSpearLabel() {
        return spearLabel.getText();
    }

    public static String getSwordLabel() {
        return swordLabel.getText();
    }

    public static String getAxeLabel() {
        return axeLabel.getText();
    }

    public static String getSpyLabel() {
        return spyLabel.getText();
    }

    public static String getLightCalLabel() {
        return lightCalLabel.getText();
    }

    public static String getPaladinLabel() {
        return paladinLabel.getText();
    }

    public static String getCatapultLabel() {
        return catapultLabel.getText();
    }

    public static String getPopulationLabel() {
        return populationCountLabel.getText();
    }

    public static String getRamLabel() {
        return ramLabel.getText();
    }

    public static String getNobelLabel() {
        return nobleLabel.getText();
    }

    public static String getMountedArcherLabel() {
        return mountedArcherLabel.getText();
    }

    public static String getHeavyCalLabel() {
        return heavyCalLabel.getText();
    }

    public static String getArcherLabel() {
        return archerLabel.getText();
    }

    public static ImageIcon getSpearIcon() {
        return spearIcon;
    }

    public static JLabel getPopulationCountLabel() {
        return populationCountLabel;
    }

    public static JLabel getNobleLabel() {
        return nobleLabel;
    }

    public static ImageIcon getAxeIcon() {
        return axeIcon;
    }

    public static ImageIcon getLightCalIcon() {
        return lightCalIcon;
    }

    public static ImageIcon getScoutIcon() {
        return scoutIcon;
    }

    public static ImageIcon getSwordIcon() {
        return swordIcon;
    }

    public static ImageIcon getPaladinIcon() {
        return paladinIcon;
    }

    public static ImageIcon getCatapultIcon() {
        return catapultIcon;
    }

    public static ImageIcon getNobleIcon() {
        return nobleIcon;
    }

    public static ImageIcon getPopulationCountIcon() {
        return populationCountIcon;
    }

    public static ImageIcon getRamIcon() {
        return ramIcon;
    }

    public static ImageIcon getMountedArcherIcon() {
        return mountedArcherIcon;
    }

    public static ImageIcon getHeavyCalIcon() {
        return heavyCalIcon;
    }

    public static ImageIcon getArcherIcon() {
        return archerIcon;
    }
}

