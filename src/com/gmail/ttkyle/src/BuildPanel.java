package com.gmail.ttkyle.src;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static org.apache.commons.lang.StringUtils.substring;


/**
 * Gets and displays all the building information to the GUI
 */
public class BuildPanel extends JPanel {

    ///////////global variables/////////////
    private static JLabel villageHQLabel;
    private static JLabel barracksLabel;
    private static JLabel stableLabel;
    private static JLabel workShopLabel;
    private static JLabel smithyLabel;
    private static JLabel marketLabel;
    private static JLabel timberLabel;
    private static JLabel clayLabel;
    private static JLabel ironLabel;
    private static JLabel farmLabel;
    private static JLabel wareHouseLabel;
    private static JLabel hidingPlaceLabel;
    private static JLabel wallLabel;
    private static JLabel academyLabel;
    private static JLabel villageWoodAmount;
    private static JLabel villageClayAmount;
    private static JLabel villageIronAmount;
    private static JLabel villageIncoming;
    private static JButton upgradeVillageHQ;
    private static JButton upgradeBarracks;
    private static JButton upgradeStable;
    private static JButton upgradeWorkShop;
    private static JButton upgradeSmithy;
    private static JButton upgradeMarket;
    private static JButton upgradeFarm;
    private static JButton upgradeWall;
    private static JButton upgradeClay;
    private static JButton upgradeTimber;
    private static JButton upgradeWareHouse;
    private static JButton upgradeAcademy;
    private static JButton upgradeIron;
    private static JButton upgradeHidingPlace;


    public BuildPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 600;
        size.height = 258;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        //create the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //set the border color and title of the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Tribal Wars Building Levels"));

        //icons for the various buildings
        ImageIcon villageHQ = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\main.png");
        ImageIcon barracks = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\barracks.png");
        ImageIcon stable = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\stable.png");
        ImageIcon workShop = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\garage.png");
        ImageIcon smithy = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\smith.png");
        ImageIcon market = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\market.png");
        ImageIcon timber = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\wood.png");
        ImageIcon clay = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\stone.png");
        ImageIcon iron = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\iron.png");
        ImageIcon farm = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\farm.png");
        ImageIcon wareHouse = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\storage.png");
        ImageIcon hidingPlace = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\hide.png");
        ImageIcon wall = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\wall.png");
        ImageIcon academy = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\academy.png");
        ImageIcon woodPic = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\woodPic.png");
        ImageIcon clayPic = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\clayPic.png");
        ImageIcon ironPic = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\ironPic.png");
        ImageIcon attPic = new ImageIcon("src\\com\\gmail\\ttkyle\\unitpic\\attack.png");


        //////////Create all the labels///////////////
        villageHQLabel = new JLabel ("Village HQ", villageHQ, JLabel.CENTER);
        villageHQLabel.setVerticalTextPosition(JLabel.TOP);
        villageHQLabel.setHorizontalTextPosition(JLabel.RIGHT);
        villageHQLabel.setBackground(bgColor);
        villageHQLabel.setOpaque(true);
        villageHQLabel.setBorder(null);

        barracksLabel = new JLabel ("Barracks", barracks, JLabel.CENTER);
        barracksLabel.setVerticalTextPosition(JLabel.TOP);
        barracksLabel.setHorizontalTextPosition(JLabel.RIGHT);
        barracksLabel.setBackground(bgColor);
        barracksLabel.setOpaque(true);
        barracksLabel.setBorder(null);

        stableLabel = new JLabel ("Stables", stable, JLabel.CENTER);
        stableLabel.setVerticalTextPosition(JLabel.TOP);
        stableLabel.setHorizontalTextPosition(JLabel.RIGHT);
        stableLabel.setBackground(bgColor);
        stableLabel.setOpaque(true);
        stableLabel.setBorder(null);

        workShopLabel = new JLabel ("Workshop", workShop, JLabel.CENTER);
        workShopLabel.setVerticalTextPosition(JLabel.TOP);
        workShopLabel.setHorizontalTextPosition(JLabel.RIGHT);
        workShopLabel.setBackground(bgColor);
        workShopLabel.setOpaque(true);
        workShopLabel.setBorder(null);

        smithyLabel = new JLabel ("Smithy", smithy, JLabel.CENTER);
        smithyLabel.setVerticalTextPosition(JLabel.TOP);
        smithyLabel.setHorizontalTextPosition(JLabel.RIGHT);
        smithyLabel.setBackground(bgColor);
        smithyLabel.setOpaque(true);
        smithyLabel.setBorder(null);

        marketLabel = new JLabel ("Market", market, JLabel.CENTER);
        marketLabel.setVerticalTextPosition(JLabel.TOP);
        marketLabel.setHorizontalTextPosition(JLabel.RIGHT);
        marketLabel.setBackground(bgColor);
        marketLabel.setOpaque(true);
        marketLabel.setBorder(null);

        timberLabel = new JLabel ("Timber", timber, JLabel.CENTER);
        timberLabel.setVerticalTextPosition(JLabel.TOP);
        timberLabel.setHorizontalTextPosition(JLabel.RIGHT);
        timberLabel.setBackground(bgColor);
        timberLabel.setOpaque(true);
        timberLabel.setBorder(null);

        clayLabel = new JLabel ("Clay", clay, JLabel.CENTER);
        clayLabel.setVerticalTextPosition(JLabel.TOP);
        clayLabel.setHorizontalTextPosition(JLabel.RIGHT);
        clayLabel.setBackground(bgColor);
        clayLabel.setOpaque(true);
        clayLabel.setBorder(null);

        ironLabel = new JLabel ("Iron", iron, JLabel.CENTER);
        ironLabel.setVerticalTextPosition(JLabel.TOP);
        ironLabel.setHorizontalTextPosition(JLabel.RIGHT);
        ironLabel.setBackground(bgColor);
        ironLabel.setOpaque(true);
        ironLabel.setBorder(null);

        farmLabel = new JLabel ("Farm", farm, JLabel.CENTER);
        farmLabel.setVerticalTextPosition(JLabel.TOP);
        farmLabel.setHorizontalTextPosition(JLabel.RIGHT);
        farmLabel.setBackground(bgColor);
        farmLabel.setOpaque(true);
        farmLabel.setBorder(null);

        wareHouseLabel = new JLabel ("Warehouse", wareHouse, JLabel.CENTER);
        wareHouseLabel.setVerticalTextPosition(JLabel.TOP);
        wareHouseLabel.setHorizontalTextPosition(JLabel.RIGHT);
        wareHouseLabel.setBackground(bgColor);
        wareHouseLabel.setOpaque(true);
        wareHouseLabel.setBorder(null);

        hidingPlaceLabel = new JLabel ("Hiding place", hidingPlace, JLabel.CENTER);
        hidingPlaceLabel.setVerticalTextPosition(JLabel.TOP);
        hidingPlaceLabel.setHorizontalTextPosition(JLabel.RIGHT);
        hidingPlaceLabel.setBackground(bgColor);
        hidingPlaceLabel.setOpaque(true);
        hidingPlaceLabel.setBorder(null);

        wallLabel = new JLabel ("Wall", wall, JLabel.CENTER);
        wallLabel.setVerticalTextPosition(JLabel.TOP);
        wallLabel.setHorizontalTextPosition(JLabel.RIGHT);
        wallLabel.setBackground(bgColor);
        wallLabel.setOpaque(true);
        wallLabel.setBorder(null);

        academyLabel = new JLabel ("Academy", academy, JLabel.CENTER);
        academyLabel.setVerticalTextPosition(JLabel.TOP);
        academyLabel.setHorizontalTextPosition(JLabel.RIGHT);
        academyLabel.setBackground(bgColor);
        academyLabel.setOpaque(true);
        academyLabel.setBorder(null);

        villageWoodAmount = new JLabel ("0",woodPic, JLabel.CENTER);
        villageWoodAmount.setVerticalTextPosition(JLabel.TOP);
        villageWoodAmount.setHorizontalTextPosition(JLabel.RIGHT);
        villageWoodAmount.setBackground(bgColor);
        villageWoodAmount.setOpaque(true);
        villageWoodAmount.setBorder(null);

        villageClayAmount = new JLabel ("0",clayPic, JLabel.CENTER);
        villageClayAmount.setVerticalTextPosition(JLabel.TOP);
        villageClayAmount.setHorizontalTextPosition(JLabel.RIGHT);
        villageClayAmount.setBackground(bgColor);
        villageClayAmount.setOpaque(true);
        villageClayAmount.setBorder(null);

        villageIronAmount = new JLabel ("0",ironPic, JLabel.CENTER);
        villageIronAmount.setVerticalTextPosition(JLabel.TOP);
        villageIronAmount.setHorizontalTextPosition(JLabel.RIGHT);
        villageIronAmount.setBackground(bgColor);
        villageIronAmount.setOpaque(true);
        villageIronAmount.setBorder(null);

        villageIncoming = new JLabel ("0 Attacks Incoming", attPic, JLabel.CENTER);
        villageIncoming.setVerticalTextPosition(JLabel.TOP);
        villageIncoming.setHorizontalTextPosition(JLabel.RIGHT);
        villageIncoming.setBackground(bgColor);
        villageIncoming.setOpaque(true);
        villageIncoming.setBorder(null);


        //button will upgrade villageHQ and update building costs
        upgradeVillageHQ = new JButton("Upgrade Village HQ");
        upgradeVillageHQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_main.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade barracks and update building costs
        upgradeBarracks = new JButton("Upgrade Barracks  ");
        upgradeBarracks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_barracks.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade stable and update building costs
        upgradeStable = new JButton("   Upgrade Stable    ");
        upgradeStable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_stable.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade workshop and update building costs
        upgradeWorkShop = new JButton("Upgrade Workshop");
        upgradeWorkShop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_garage.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade smithy and update building costs
        upgradeSmithy = new JButton("   Upgrade Smithy    ");
        upgradeSmithy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_smith.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade market and update building costs
        upgradeMarket = new JButton("   Upgrade Market   ");
        upgradeMarket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_market.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade farm and update building costs
        upgradeFarm = new JButton("      Upgrade Farm       ");
        upgradeFarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_farm.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade wall and update building costs
        upgradeWall = new JButton("     Upgrade Wall      ");
        upgradeWall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_wall.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade timber and update building costs
        upgradeTimber = new JButton("    Upgrade Timber     ");
        upgradeTimber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(1500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_wood.click()");
                    Thread.sleep(1500);
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1000);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade clay and update building costs
        upgradeClay = new JButton("       Upgrade Clay       ");
        upgradeClay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(2500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_stone.click()");
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1500);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade iron and update building costs
        upgradeIron = new JButton("        Upgrade Iron       ");
        upgradeIron.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(2500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_iron.click()");
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1500);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade warehouse and update building costs
        upgradeWareHouse = new JButton("Upgrade Warehouse ");
        upgradeWareHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(2500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_storage.click()");
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1500);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade academy and update building costs
        upgradeAcademy = new JButton("   Upgrade Academy  ");
        upgradeAcademy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    Thread.sleep(2500);
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_snob.click()");
                    Village.constructionOne();
                    Village.constructionTwo();
                    Thread.sleep(1500);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch (InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });

        //button will upgrade hidingplace and update building costs
        upgradeHidingPlace = new JButton("Upgrade Hiding place");
        upgradeHidingPlace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?village=86805&screen=main");
                    Twfb.twfbAppGui.frame.getAllBuildingCosts();
                    Village.updateBuildings();
                    JavascriptExecutor js = (JavascriptExecutor) WebAutomation.driver;
                    js.executeScript("main_buildlink_hide.click()");
                    Thread.sleep(2500);

                    Village.constructionOne();
                    Village.constructionTwo();
                    Village.constructionOneGetNumbers();
                    Village.constructionOneGetTime();

                    if(Village.getTotalOne() > 0) {
                        ConstructOneThread.constructionFlagOne = true;
                    }
                    Thread.sleep(1500);
                    WebAutomation.driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");
                }
                catch(InterruptedException e1) {
                }
                catch(NoSuchElementException e2) {
                }
            }
        });


        ////// First Column///////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .5;
        gc.weighty = .5;

        gc.gridx =  0;
        gc.gridy = 0;
        add(villageWoodAmount, gc);

        gc.weightx = 1;
        gc.weighty = 0;
        gc.gridx =  0;
        gc.gridy = 1;
        add(villageHQLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(barracksLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(stableLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(workShopLabel, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(smithyLabel, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(marketLabel, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        add(wallLabel, gc);



        ////////Second Column////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx =  1;
        gc.gridy = 0;
        add(villageClayAmount, gc);


        gc.gridx = 1;
        gc.gridy = 1;
        add(upgradeVillageHQ, gc);


        gc.gridx = 1;
        gc.gridy = 2;
        add(upgradeBarracks, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(upgradeStable, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(upgradeWorkShop, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        add(upgradeSmithy, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        add(upgradeMarket, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        add(upgradeWall, gc);

        ////////Third Column////////////
        gc.gridx =  2;
        gc.gridy = 0;
        add(villageIronAmount, gc);

        gc.weightx = 10;
        gc.weighty = 0 ;
        gc.gridx =  2;
        gc.gridy = 1;
        add(timberLabel, gc);


        gc.gridx = 2;
        gc.gridy = 2;
        add(clayLabel, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        add(ironLabel, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        add(farmLabel, gc);

        gc.gridx = 2;
        gc.gridy = 5;
        add(wareHouseLabel, gc);

        gc.gridx = 2;
        gc.gridy = 6;
        add(hidingPlaceLabel, gc);

        gc.gridx = 2;
        gc.gridy = 7;
        add(academyLabel, gc);

        /////////Fourth Column///////////
        gc.weightx = 10;
        gc.weighty = 0 ;
        gc.gridx =  3;
        gc.gridy = 1;
        add(upgradeTimber, gc);


        gc.gridx =  3;
        gc.gridy = 2;
        add(upgradeClay, gc);

        gc.gridx =  3;
        gc.gridy = 3;
        add(upgradeIron, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        add(upgradeFarm, gc);

        gc.gridx = 3;
        gc.gridy = 5;
        add(upgradeWareHouse, gc);

        gc.gridx = 3;
        gc.gridy = 6;
        add(upgradeHidingPlace, gc);

        gc.gridx = 3;
        gc.gridy = 7;
        add(upgradeAcademy, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        add(villageIncoming, gc);
    }


    //////////setters for building labels///////////////
    public static void setVillageHQLabel(String label) {
        villageHQLabel.setText(label);
    }

    public static void setBarracksLabel(String label) {
        barracksLabel.setText(label);
    }

    public static void setStableLabel(String label) {
        stableLabel.setText(label);
    }

    public static void setWorkShopLabel(String label) {
        workShopLabel.setText(label);
    }

    public static void setSmithyLabel(String label) {
        smithyLabel.setText(label);
    }

    public static void setMarketLabel(String label) {
        marketLabel.setText(label);
    }

    public static void setTimberLabel(String label) {
        timberLabel.setText(label);
    }

    public static void setClayLabel(String label) {
        clayLabel.setText(label);
    }

    public static void setIronLabel(String label) {
        ironLabel.setText(label);
    }

    public static void setFarmLabel(String label) {
        farmLabel.setText(label);
    }

    public static void setWareHouseLabel(String label) {
        wareHouseLabel.setText(label);
    }

    public static void setHidingPlaceLabel(String label) {
        hidingPlaceLabel.setText(label);
    }

    public static void setWallLabel(String label) {
        wallLabel.setText(label);
    }

    public static void setAcademyLabel(String label) {
        academyLabel.setText(label);
    }

    public static void setVillageWoodAmountLabel(String label) {
        villageWoodAmount.setText(label);
    }

    public static void setVillageClayAmountLabel(String label) {
        villageClayAmount.setText(label);
    }

    public static void setVillageIronAmountLabel(String label) {
        villageIronAmount.setText(label);
    }

    public static void setVillageIncomingLabel(String label) {
        villageIncoming.setText(label);
    }



    //////////setters for village upgrade buttons/////////////
    public static void setUpgradeVillageHQLabel(String label) {
        upgradeVillageHQ.setText(label);
    }

    public static void setUpgradeBarracksLabel(String label) {
        upgradeBarracks.setText(label);
    }

    public static void setUpgradeStableLabel(String label) {
        upgradeStable.setText(label);
    }

    public static void setUpgradeWorkShopLabel(String label) {
        upgradeWorkShop.setText(label);
    }

    public static void setUpgradeSmithyLabel(String label) {
        upgradeSmithy.setText(label);
    }

    public static void setUpgradeMarketLabel(String label) {
        upgradeMarket.setText(label);
    }

    public static void setUpgradeFarmLabel(String label) {
        upgradeFarm.setText(label);
    }

    public static void setUpgradeWallLabel(String label) {
        upgradeWall.setText(label);
    }

    public static void setUpgradeClayLabel(String label) {
        upgradeClay.setText(label);
    }

    public static void setUpgradeTimberLabel(String label) {
        upgradeTimber.setText(label);
    }

    public static void setUpgradeWareHouseLabel(String label) {
        upgradeWareHouse.setText(label);
    }

    public static void setUpgradeAcademyLabel(String label) {
        upgradeAcademy.setText(label);
    }

    public static void setUpgradeIronLabel(String label) {
        upgradeIron.setText(label);
    }

    public static void setUpgradeHidingPlaceLabel(String label) {
        upgradeHidingPlace.setText(label);
    }



    ///////////set upgrade buttons enabled or disabled////////////////
    public static void setVillageHQButtonTrueOrFalse(Boolean bool) {
        upgradeVillageHQ.setEnabled(bool);
    }

    public static void setBarracksButtonTrueOrFalse(Boolean bool) {
        upgradeBarracks.setEnabled(bool);
    }

    public static void setStableButtonTrueOrFalse(Boolean bool) {
        upgradeStable.setEnabled(bool);
    }

    public static void setWorkShopButtonTrueOrFalse(Boolean bool) {
        upgradeWorkShop.setEnabled(bool);
    }

    public static void setSmithyButtonTrueOrFalse(Boolean bool) {
        upgradeSmithy.setEnabled(bool);
    }

    public static void setMarketButtonTrueOrFalse(Boolean bool) {
        upgradeMarket.setEnabled(bool);
    }

    public static void setFarmButtonTrueOrFalse(Boolean bool) {
        upgradeFarm.setEnabled(bool);
    }

    public static void setWallButtonTrueOrFalse(Boolean bool) {
        upgradeWall.setEnabled(bool);
    }

    public static void setTimberButtonTrueOrFalse(Boolean bool) {
        upgradeTimber.setEnabled(bool);
    }

    public static void setClayButtonTrueOrFalse(Boolean bool) {
        upgradeClay.setEnabled(bool);
    }

    public static void setIronButtonTrueOrFalse(Boolean bool) {
        upgradeIron.setEnabled(bool);
    }

    public static void setWareHouseButtonTrueOrFalse(Boolean bool) {
        upgradeWareHouse.setEnabled(bool);
    }

    public static void setAcademyButtonTrueOrFalse(Boolean bool) {
        upgradeAcademy.setEnabled(bool);
    }

    public static void setHidingPlaceButtonTrueOrFalse(Boolean bool) {
        upgradeHidingPlace.setEnabled(bool);
    }

    public static JButton getUpgradeVillageHQ() {
        return upgradeVillageHQ;
    }

    public static JButton getUpgradeBarracks() {
        return upgradeBarracks;
    }

    public static JButton getUpgradeStable() {
        return upgradeStable;
    }

    public static JButton getUpgradeWorkShop() {
        return upgradeWorkShop;
    }

    public static JButton getUpgradeSmithy() {
        return upgradeSmithy;
    }

    public static JButton getUpgradeMarket() {
        return upgradeMarket;
    }

    public static JButton getUpgradeFarm() {
        return upgradeFarm;
    }

    public static JButton getUpgradeWall() {
        return upgradeWall;
    }

    public static JButton getUpgradeClay() {
        return upgradeClay;
    }

    public static JButton getUpgradeTimber() {
        return upgradeTimber;
    }

    public static JButton getUpgradeWareHouse() {
        return upgradeWareHouse;
    }

    public static JButton getUpgradeAcademy() {
        return upgradeAcademy;
    }

    public static JButton getUpgradeIron() {
        return upgradeIron;
    }

    public static JButton getUpgradeHidingPlace() {
        return upgradeHidingPlace;
    }
}

