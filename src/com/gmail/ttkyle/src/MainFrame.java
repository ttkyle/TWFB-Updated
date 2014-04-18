package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

/**
 * The main frame that you see for the GUI
 */
public class MainFrame extends JFrame {

    public static AttackTable attackTable2;
    public TroopsDetailPanel troopsDetailPanel;
    public static AddFarmsDialog addFarmsDialog;
    public static serverNotOnAccountDialog serverNotOnAccountDialog;
    public BuildingConstructionPanel buildingConstructionPanel;
    public Village village;

    public MainFrame(String title) throws IOException {
        super(title);


        setLocation(400, 0);
        //Create Swing components
        DetailsPanel detailsPanel = new DetailsPanel();
        troopsDetailPanel = new TroopsDetailPanel();
        BuildPanel buildPanel = new BuildPanel();
        CurrentVillagePanel currentVillagePanel = new CurrentVillagePanel();
        AddVillagePanel addVillagePanel = new AddVillagePanel();
        buildingConstructionPanel = new BuildingConstructionPanel();
        ServerTimePanel serverTimePanel = new ServerTimePanel();
        attackTable2 = new AttackTable();
        addFarmsDialog = new AddFarmsDialog();
        serverNotOnAccountDialog = new serverNotOnAccountDialog();
        village = new Village();


        File village2 = new File("village.txt");
        village2.delete();
        //Disables frames on GUI creation
        disableButtons();

         TestDownLoadThread testDownLoadThread = new TestDownLoadThread();
        //Details panel listener
        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event) {
            }
        });

        //Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                File village = new File("village.txt");
                village.delete();
            }
        });


        ////////////First Column/////////////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 350, 595);
        gc.gridx =  0;
        gc.gridy = 0;
        add(detailsPanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .5;
        gc.weighty = .5;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-420, 0, 0, 595);    //-352, 0, 0, 595
        gc.gridx = 0;
        gc.gridy = 1;
        add(troopsDetailPanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .5;
        gc.weighty = .5;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-150, 0, 0, 595);      //-96, 0, 0, 595           -130
        gc.gridx = 0;
        gc.gridy = 3;
        add(currentVillagePanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-152, 0, -50, 595);
        gc.gridx = 0;
        gc.gridy = 4;
        add(addVillagePanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 2, 0, 597);
        gc.gridx = 0;
        gc.gridy = 5;
        add(serverTimePanel, gc);


        ////////////Second Column////////////////
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, -595 , 280, -1);     //0, -595, 188, -1
        gc.gridx = 1;
        gc.gridy = 0;
        add(buildPanel, gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-568, -595 , 0, -1);      //-432, -595, 0, -1
        gc.gridx = 1;
        gc.gridy = 1;
        add(buildingConstructionPanel, gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-435, 3 , 0, -1);    //-338, 3, 0, -1
        gc.gridx = 0;
        gc.gridy = 2;
        add(attackTable2, gc);
    }

    //used to disable all the buttons once ui created
    public static void disableButtons() {
        BuildPanel.setVillageHQButtonTrueOrFalse(false);
        BuildPanel.setBarracksButtonTrueOrFalse(false);
        BuildPanel.setStableButtonTrueOrFalse(false);
        BuildPanel.setWorkShopButtonTrueOrFalse(false);
        BuildPanel.setSmithyButtonTrueOrFalse(false);
        BuildPanel.setMarketButtonTrueOrFalse(false);
        BuildPanel.setFarmButtonTrueOrFalse(false);
        BuildPanel.setWallButtonTrueOrFalse(false);
        BuildPanel.setClayButtonTrueOrFalse(false);
        BuildPanel.setTimberButtonTrueOrFalse(false);
        BuildPanel.setWareHouseButtonTrueOrFalse(false);
        BuildPanel.setAcademyButtonTrueOrFalse(false);
        BuildPanel.setIronButtonTrueOrFalse(false);
        BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
    }

    //used to enable all the buttons once user is logged in
    public static void enableButtons () {
        BuildPanel.setVillageHQButtonTrueOrFalse(true);
        BuildPanel.setBarracksButtonTrueOrFalse(true);
        BuildPanel.setStableButtonTrueOrFalse(true);
        BuildPanel.setWorkShopButtonTrueOrFalse(true);
        BuildPanel.setSmithyButtonTrueOrFalse(true);
        BuildPanel.setMarketButtonTrueOrFalse(true);
        BuildPanel.setFarmButtonTrueOrFalse(true);
        BuildPanel.setWallButtonTrueOrFalse(true);
        BuildPanel.setClayButtonTrueOrFalse(true);
        BuildPanel.setTimberButtonTrueOrFalse(true);
        BuildPanel.setWareHouseButtonTrueOrFalse(true);
        BuildPanel.setAcademyButtonTrueOrFalse(true);
        BuildPanel.setIronButtonTrueOrFalse(true);
        BuildPanel.setHidingPlaceButtonTrueOrFalse(true);
    }

    public void setAssignmentOne(String args) {
        buildingConstructionPanel.setAssignmentOne(args);
    }

    public void setAssignmentTwo(String args) {
        buildingConstructionPanel.setAssignmentTwo(args);
    }

    public void setDurationOne(String args) {
        buildingConstructionPanel.setDurationOne(args);
    }

    public void setDurationTwo(String args) {
        buildingConstructionPanel.setDurationTwo(args);
    }

    public void setCompletionOne(String args) {
        buildingConstructionPanel.setCompletionOne(args);
    }

    public void setCompletionTwo(String args) {
        buildingConstructionPanel.setCompletionTwo(args);
    }

    public int getVillageHQWoodCost() {
        return village.getVillageHQWoodCost();
    }

    public void setVillageHQWoodCost(int newNumber) {
        village.setVillageHQWoodCost(newNumber);
    }

    public  int getVillageHQClayCost() {
        return village.getVillageHQClayCost();
    }

    public void setVillageHQClayCost(int newNumber) {
        village.setVillageHQClayCost(newNumber);
    }

    public int getVillageHQIronCost() {
        return village.getVillageHQClayCost();
    }

    public void setVillageHQIronCost(int newNumber) {
        village.setVillageHQIronCost(newNumber);
    }

    public boolean isVillageHQHasCost() {
        return village.isVillageHQHasCost();
    }

    public void setVillageHQHasCost(boolean newBoolean) {
        village.villageHQHasCost(newBoolean);
    }

    public int getBarracksWoodCost() {
        return village.getBarracksWoodCost();
    }

    public void setBarracksWoodCost(int newNumber) {
        village.setBarracksWoodCost(newNumber);
    }

    public int getBarracksClayCost() {
        return village.getBarracksClayCost();
    }

    public void setBarracksClayCost(int newNumber) {
        village.setBarracksClayCost(newNumber);
    }

    public int getBarracksIronCost() {
        return village.getBarracksIronCost();
    }

    public void setBarracksIronCost(int newNumber) {
        village.setBarracksIronCost(newNumber);
    }

    public boolean barracksHasCost() {
        return village.wareHouseHasCost();
    }

    public void setBarracksHasCost(boolean newBoolean) {
        village.setBarracksHasCost(newBoolean);
    }

    public int getStableWoodCost() {
        return village.getStableWoodCost();
    }

    public void setStableWoodCost(int newNumber) {
      village.setStableWoodCost(newNumber);
    }

    public int getStableClayCost() {
        return village.getStableClayCost();
    }

    public void setStableClayCost(int newNumber) {
        village.setStableClayCost(newNumber);
    }

    public int getStableIronCost() {
        return village.getStableIronCost();
    }

    public void setStableIronCost(int newNumber) {
        village.setStableIronCost(newNumber);
    }

    public boolean stableHasCost() {
        return village.stableHasCost();
    }

    public void setStableHasCost(boolean newBoolean) {
        village.setStableHasCost(newBoolean);
    }

    public int getWorkShopWoodCost() {
        return village.getWorkShopWoodCost();
    }

    public void setWorkShopWoodCost(int newNumber) {
        village.setWorkShopWoodCost(newNumber);
    }

    public int getWorkShopClayCost() {
        return village.getWorkShopClayCost();
    }

    public void setWorkShopClayCost(int newNumber) {
        village.setWorkShopClayCost(newNumber);
    }

    public int getWorkShopIronCost() {
        return village.getWorkShopIronCost();
    }

    public void setWorkShopIronCost(int newNumber) {
        village.setWorkShopIronCost(newNumber);
    }

    public boolean workShopHasCost() {
        return village.workShopHasCost();
    }

    public void setWorkShopHasCost(boolean newBoolean) {
        village.setWorkShopHasCost(newBoolean);
    }

    public int getSmithyWoodCost() {
        return village.getSmithyWoodCost();
    }

    public void setSmithyWoodCost(int newNumber) {
        village.setSmithyWoodCost(newNumber);
    }

    public int getSmithyClayCost() {
        return village.getSmithyClayCost();
    }

    public void setSmithyClayCost(int newNumber) {
        village.setSmithyClayCost(newNumber);
    }

    public int getSmithyIronCost() {
        return village.getSmithyIronCost();
    }

    public void setSmithyIronCost(int newNumber) {
        village.setSmithyIronCost(newNumber);
    }

    public boolean smithyHasCost() {
        return village.smithyHasCost();
    }

    public void setSmithyHasCost(boolean newBoolean) {
        village.setSmithyHasCost(newBoolean);
    }

    public int getMarketWoodCost() {
        return village.getMarketWoodCost();
    }

    public void setMarketWoodCost(int newNumber) {
        village.setMarketWoodCost(newNumber);
    }

    public int getMarketClayCost() {
        return village.getMarketClayCost();
    }

    public void setMarketClayCost(int newNumber) {
        village.setMarketClayCost(newNumber);
    }

    public int getMarketIronCost() {
        return village.getMarketIronCost();
    }

    public void setMarketIronCost(int newNumber) {
        village.setMarketIronCost(newNumber);
    }

    public boolean marketHasCost() {
        return village.marketHasCost();
    }

    public void setMarketHasCost(boolean newBoolean) {
        village.setMarketHasCost(newBoolean);
    }

    public int getTimberWoodCost() {
        return village.getTimberWoodCost();
    }

    public void setTimberWoodCost(int newNumber) {
        village.setTimberWoodCost(newNumber);
    }

    public int getTimberClayCost() {
        return village.getTimberClayCost();
    }

    public  void setTimberClayCost(int newNumber) {
        village.setTimberClayCost(newNumber);
    }

    public int getTimberIronCost() {
        return village.getTimberIronCost();
    }

    public void setTimberIronCost(int newNumber) {
        village.setTimberIronCost(newNumber);
    }

    public boolean timberHasCost() {
        return village.timberHasCost();
    }

    public void setTimberHasCost(boolean newBoolean) {
        village.setTimberHasCost(newBoolean);
    }

    public int getClayWoodCost() {
        return village.getClayWoodCost();
    }

    public void setClayWoodCost(int newNumber) {
        village.setClayWoodCost(newNumber);
    }

    public int getClayClayCost() {
        return village.getClayClayCost();
    }

    public void setClayClayCost(int newNumber) {
        village.setClayClayCost(newNumber);
    }

    public int getClayIronCost() {
        return village.getClayIronCost();
    }

    public void setClayIronCost(int newNumber) {
        village.setClayIronCost(newNumber);
    }

    public boolean clayHasCost() {
        return village.clayHasCost();
    }

    public void setClayHasCost(boolean newBoolean) {
        village.setClayHasCost(newBoolean);
    }

    public int getIronWoodCost() {
        return village.getIronWoodCost();
    }

    public void setIronWoodCost(int newNumber) {
        village.setIronWoodCost(newNumber);
    }

    public int getIronClayCost() {
        return village.getIronClayCost();
    }

    public void setIronClayCost(int newNumber) {
        village.setIronClayCost(newNumber);
    }

    public int getIronIronCost() {
        return village.getIronIronCost();
    }

    public void setIronIronCost(int newNumber) {
        village.setIronIronCost(newNumber);
    }

    public boolean ironHasCost() {
        return village.ironHasCost();
    }

    public void setIronHasCost(boolean newBoolean) {
        village.setIronHasCost(newBoolean);
    }

    public int getFarmWoodCost() {
        return village.getFarmWoodCost();
    }

    public void setFarmWoodCost(int newNumber) {
        village.setFarmWoodCost(newNumber);
    }

    public int getFarmClayCost() {
        return village.getFarmClayCost();
    }

    public void setFarmClayCost(int newNumber) {
        village.setFarmClayCost(newNumber);
    }

    public int getFarmIronCost() {
        return village.getFarmIronCost();
    }

    public void setFarmIronCost(int newNumber) {
        village.setFarmIronCost(newNumber);
    }

    public boolean farmHasCost() {
        return village.farmHasCost();
    }

    public void setFarmHasCost(boolean newBoolean) {
        village.setFarmHasCost(newBoolean);
    }

    public int getWareHouseWoodCost() {
        return village.getWareHouseWoodCost();
    }

    public void setWareHouseWoodCost(int newNumber) {
        village.setWareHouseWoodCost(newNumber);
    }

    public int getWareHouseClayCost() {
        return village.getWareHouseClayCost();
    }

    public void setWareHouseClayCost(int newNumber) {
        village.setWareHouseClayCost(newNumber);
    }

    public int getWareHouseIronCost() {
        return village.getWareHouseIronCost();
    }

    public void setWareHouseIronCost(int newNumber) {
        village.setWareHouseIronCost(newNumber);
    }

    public boolean wareHouseHasCost() {
        return village.wareHouseHasCost();
    }

    public void setWareHouseHasCost(boolean newBoolean) {
        village.setWareHouseHasCost(newBoolean);
    }

    public int getWallWoodCost() {
        return village.getWallWoodCost();
    }

    public void setWallWoodCost(int newNumber) {
        village.setWallWoodCost(newNumber);
    }

    public int getWallClayCost() {
        return village.getWallClayCost();
    }

    public void setWallClayCost(int newNumber) {
        village.setWallClayCost(newNumber);
    }

    public int getWallIronCost() {
        return village.getWallIronCost();
    }

    public void setWallIronCost(int newNumber) {
        village.setWallIronCost(newNumber);
    }

    public boolean wallHasCost() {
        return village.wallHasCost();
    }

    public void setWallHasCost(boolean newBoolean) {
        village.setWallHasCost(newBoolean);
    }

    public int getAcademyWoodCost() {
        return village.getAcademyWoodCost();
    }

    public void setAcademyWoodCost(int newNumber) {
        village.setAcademyWoodCost(newNumber);
    }

    public int getAcademyClayCost() {
        return village.getAcademyClayCost();
    }

    public void setAcademyClayCost(int newNumber) {
        village.setAcademyClayCost(newNumber);
    }

    public int getAcademyIronCost() {
        return village.getAcademyIronCost();
    }

    public void setAcademyIronCost(int newNumber) {
        village.setAcademyIronCost(newNumber);
    }

    public boolean academyHasCost() {
        return village.academyHasCost();
    }

    public void setAcademyHasCost(boolean newBoolean) {
        village.setAcademyHasCost(newBoolean);
    }

    public int getHidingPlaceWoodCost() {
        return village.getHidingPlaceWoodCost();
    }

    public void setHidingPlaceWoodCost(int newNumber) {
        village.setHidingPlaceWoodCost(newNumber);
    }

    public int getHidingPlaceClayCost() {
        return village.getHidingPlaceClayCost();
    }

    public void setHidingPlaceClayCost(int newNumber) {
        village.setHidingPlaceClayCost(newNumber);
    }

    public int getHidingPlaceIronCost() {
        return village.getHidingPlaceIronCost();
    }

    public void setHidingPlaceIronCost(int newNumber) {
        village.setHidingPlaceIronCost(newNumber);
    }

    public boolean hidingPlaceHasCost() {
        return village.hidingPlaceHasCost();
    }

    public void setHidingPlaceHasCost(boolean newBoolean) {
        village.setHidingPlaceHasCost(newBoolean);
    }

    public int getCurrentWood() {
        return village.getCurrentWood();
    }

    public void setCurrentWood(int newNumber) {
        village.setCurrentWood(newNumber);
    }

    public int getCurrentClay() {
        return village.getCurrentClay();
    }

    public void setCurrentClay(int newNumber) {
        village.setCurrentClay(newNumber);
    }

    public int getCurrentIron() {
        return village.getCurrentIron();
    }

    public void setCurrentIron(int newNumber) {
        village.setCurrentIron(newNumber);
    }

    public int getCurrentPopulation() {
        return village.getCurrentPopulation();
    }

    public void setCurrentPopulation(int newNumber) {
        village.setCurrentPopulation(newNumber);
    }

    public int getMaxPopulation() {
        return village.getMaxPopulation();
    }

    public void setMaxPopulation(int newNumber) {
        village.setMaxPopulation(newNumber);
    }

    public void getAllBuildingCosts() {
        village.getVillageHQCost();
        village.getBarracksCost();
        village.getStableCost();
        village.getWorkShopCost();
        village.getSmithtyCost();
        village.getMarketCost();
        village.getTimberCost();
        village.getClayCost();
        village.getIronCost();
        village.getFarmCost();
        village.getWareHouseCost();
        village.getWallCost();
        village.getAcademyCost();
        village.getHidingPlaceCost();
    }

}