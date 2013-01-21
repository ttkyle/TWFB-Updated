package com.gmail.ttkyle.src;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.io.*;
import java.util.Scanner;

import static org.apache.commons.lang.StringUtils.substring;

/**
 * The village class holds most of the information for the village
 * and holds most of the methods that manipulate GUI elements
 *
 * The village class will update on the fly when a user selects a
 * village to manipulate.
 */
public class Village {

    //global variables
    private String xLoc;
    private String yLoc;
    public FileOutputStream fout;
    private int numberOfFarms = 1;


    private int villageHQWoodCost;
    private int villageHQClayCost;
    private int villageHQIronCost;
    private boolean villageHQHasCost = true;


    private int barracksWoodCost;
    private int barracksClayCost;
    private int barracksIronCost;
    private boolean barracksHasCost = true;


    private int stableWoodCost;
    private int stableClayCost;
    private int stableIronCost;
    private boolean stableHasCost = true;


    private int workShopWoodCost;
    private int workShopClayCost;
    private int workShopIronCost;
    private boolean workShopHasCost = true;


    private int smithyWoodCost;
    private int smithyClayCost;
    private int smithyIronCost;
    private boolean smithyHasCost = true;


    private int marketWoodCost;
    private int marketClayCost;
    private int marketIronCost;
    private boolean marketHasCost = true;


    private int timberWoodCost;
    private int timberClayCost;
    private int timberIronCost;
    private boolean timberHasCost = true;


    private int clayWoodCost;
    private int clayClayCost;
    private int clayIronCost;
    private boolean clayHasCost = true;


    private int ironWoodCost;
    private int ironClayCost;
    private int ironIronCost;
    private boolean ironHasCost = true;


    private int farmWoodCost;
    private int farmClayCost;
    private int farmIronCost;
    private boolean farmHasCost = true;


    private int wareHouseWoodCost;
    private int wareHouseClayCost;
    private int wareHouseIronCost;
    private boolean wareHouseHasCost = true;


    private int wallWoodCost;
    private int wallClayCost;
    private int wallIronCost;
    private boolean wallHasCost = true;


    private int academyWoodCost;
    private int academyClayCost;
    private int academyIronCost;
    private boolean academyHasCost = true;


    private int hidingPlaceWoodCost;
    private int hidingPlaceClayCost;
    private int hidingPlaceIronCost;
    private boolean hidingPlaceHasCost = true;


    private int currentWood;
    private int currentClay;
    private int currentIron;
    private int currentPopulation;
    private int maxPopulation;





    //Constructor to set village name so that we know what to name text files
    //Also writes the x and y coords for the village to attack
    Village()  {
    }



    //Reads the lines that you tell it to via startLine and endLine
    public void readFile(int startLine, int endLine)  {
        int currentLineNo = 0;
        BufferedReader in = null;
        try {
           // in = new BufferedReader(new FileReader("C:\\Users\\kyle\\Documents\\Tribalwars\\" + villageFileName + ".txt"));
            //read to startLine
            while(currentLineNo < startLine) {
                if (in.readLine() == null) {
                    //early end
                    throw new IOException("File too small");
                }
                currentLineNo++;
            }
            //read until endLine
            while(currentLineNo <= endLine) {
                String line = in.readLine();
                if (line == null) {
                    return;
                }
                System.out.println(line);
                currentLineNo++;
            }
        }
        catch (IOException ex) {
            System.out.println("Problem reading file.\n" + ex.getMessage());
        } finally {
            try { if (in!=null) in.close(); } catch(IOException ignore) {}
        }
    }

    //Reads the x coord of a village file
    public String readX() {
        this.readFile(0, 0);
        return xLoc;
    }

    //Reads the y coord of a village file
    public String readY() {
        this.readFile(1, 1);
        return yLoc;
    }

    //Writes a specified message to the startLine through the endLine
    //I may need to work on this method so that it won't overwrite another x or y coord if the file is already made
    public String writeFile(int startLine, int endLine, String msg) throws IOException {
        int currentLineNo = 0;
        //Get to start line to start writing
        while(currentLineNo < startLine) {
            currentLineNo++;
        }
        // Print a line of text
        while(currentLineNo <= endLine) {
            new PrintStream(fout).println(msg);
            currentLineNo++;
        }
        return msg;
    }


    // Writes the X coord based on user input
    //This method needs to be made so that it won't overwrite an X coord that is already entered
    public void writeX() throws IOException {
        System.out.println("Type x coord, it can only be 3 numbers long.");
        Scanner userInputXLoc = new Scanner(System.in);
        xLoc = userInputXLoc.next();
        while(xLoc.length() != 3) {
            System.out.println("Please re-enter x coord.");
            xLoc = userInputXLoc.next();
        }
        System.out.println(xLoc);
        writeFile(0, 0, xLoc);
    }


    //Writes the Y coord based on user input
    //This method needs to be made so that it won't overwrite an Y coord that is already entered
    public void writeY() throws IOException {
        System.out.println("Type y coord, it can only be 3 numbers long.");
        Scanner userInputXLoc = new Scanner(System.in);
        yLoc = userInputXLoc.next();
        while(yLoc.length() != 3) {
            System.out.println("Please re-enter y coord.");
            yLoc = userInputXLoc.next();
        }
        writeFile(1, 1, yLoc);
        fout.close();
    }

    //Gets the file names in the tribalwars folder

    //Eventually need to make a method that goes through every file and pulls the X and Y coord data out
    //of the text files
    public void getFileName() {
        File folder = new File("C:\\Users\\kyle\\Documents\\Tribalwars");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
            else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    //Sends number of spears to the GUI
    public  void setSpears() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String spearLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(spearLabel, 2, 7).equals("Spear") || substring(spearLabel, 3, 8).equals("Spear") || substring(spearLabel, 4, 9).equals("Spear")
                || substring(spearLabel, 5, 10).equals("Spear") ||  substring(spearLabel, 6, 11).equals("Spear") ||  substring(spearLabel, 7, 12).equals("Spear")) {
                    TroopsDetailPanel.setSpearLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSpearLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of Swords to the GUI
    public  void setSwords() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String swordLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(swordLabel, 2, 7).equals("Sword") || substring(swordLabel, 3, 8).equals("Sword") || substring(swordLabel, 4, 9).equals("Sword")
                || substring(swordLabel, 5, 10).equals("Sword") || substring(swordLabel, 6, 11).equals("Sword") || substring(swordLabel, 7, 12).equals("Sword")) {
                    TroopsDetailPanel.setSwordLabelLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSwordLabelLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of axes to the GUI
    public  void setAxes() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String axeLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(axeLabel, 1, 4).equals("Axe") || substring(axeLabel, 2, 5).equals("Axe") || substring(axeLabel, 3, 6).equals("Axe")
                || substring(axeLabel, 4, 7).equals("Axe") || substring(axeLabel, 5, 8).equals("Axe") || substring(axeLabel, 6, 9).equals("Axe")
                || substring(axeLabel, 7, 10).equals("Axe")) {
                    TroopsDetailPanel.setAxeLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setAxeLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of scouts to the GUI
    public  void setSpies() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String spyLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(spyLabel, 2, 7).equals("Scout") || substring(spyLabel, 3, 8).equals("Scout") || substring(spyLabel, 4, 9).equals("Scout")
                || substring(spyLabel, 5, 10).equals("Scout") || substring(spyLabel, 6, 11).equals("Scout") || substring(spyLabel, 7, 12).equals("Scout")) {
                    TroopsDetailPanel.setSpyLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSpyLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of light cal to the GUI
    public  void setLightCal() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String lightCalLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(lightCalLabel, 2, 7).equals("Light") || substring(lightCalLabel, 3, 8).equals("Light") || substring(lightCalLabel, 4, 9).equals("Light")
                || substring(lightCalLabel, 5, 10).equals("Light") || substring(lightCalLabel, 6, 11).equals("Light") || substring(lightCalLabel, 7, 12).equals("Light")) {
                    TroopsDetailPanel.setLightCalLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setLightCalLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends whether or not the village has a paladin
    public  void setPaladin() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String paladinLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(paladinLabel, 0, 7).equals("Paladin")) {
                    TroopsDetailPanel.setPaladinLabel("1");
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setPaladinLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends the number of catapults to the GUI
    public  void setCatapult() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String catapultLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(catapultLabel, 2, 10).equals("Catapult") || substring(catapultLabel, 3, 11).equals("Catapult") || substring(catapultLabel, 4, 12).equals("Catapult")
                || substring(catapultLabel, 5, 13).equals("Catapult") || substring(catapultLabel, 6, 14).equals("Catapult") || substring(catapultLabel, 7, 15).equals("Catapult")) {
                    TroopsDetailPanel.setCatapultLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setCatapultLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends the number of Rams to the GUI
    public  void setRam() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String ramLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(ramLabel, 3, 6).equals("Ram") || substring(ramLabel, 4, 7).equals("Catapult") || substring(ramLabel, 5, 8).equals("Ram")
                        || substring(ramLabel, 6, 9).equals("Ram") || substring(ramLabel, 7, 10).equals("Ram") || substring(ramLabel, 8, 11).equals("Ram")) {
                    TroopsDetailPanel.setRamLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setRamLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends the level of villageHQ to the GUI
    public  void setVillageHQ() {

        VillageBuildings villageBuilding = null;
        try {
            villageBuilding = new VillageBuildings("Village", 0, 7, 21, 31);
            villageBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeVillageHQLabel("Cannot upgrade");
            BuildPanel.setVillageHQButtonTrueOrFalse(false);
            BuildPanel.setVillageHQLabel(villageBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of barracks to the GUI
    public  void setBarracks() {

        VillageBuildings barracksBuilding = null;
        try {
            barracksBuilding = new VillageBuildings("Barracks", 0, 8, 9, 20);
            barracksBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeBarracksLabel("Cannot upgrade");
            BuildPanel.setBarracksButtonTrueOrFalse(false);
            BuildPanel.setBarracksLabel(barracksBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of stable to the GUI
    public  void setStable() {

        VillageBuildings stableBuilding = null;
        try {
            stableBuilding = new VillageBuildings("Stable", 0, 6, 7, 17);
            stableBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeStableLabel("Cannot upgrade");
            BuildPanel.setStableButtonTrueOrFalse(false);
            BuildPanel.setStableLabel(stableBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of workshop to the GUI
    public  void setWorkShop() {


        VillageBuildings workShopBuilding = null;
        try {
            workShopBuilding = new VillageBuildings("Workshop", 0, 8, 9, 19);
            workShopBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeWorkShopLabel("Cannot upgrade");
            BuildPanel.setWorkShopButtonTrueOrFalse(false);
            BuildPanel.setWorkShopLabel(workShopBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of smithy to the GUI
    public  void setSmithy() {

        VillageBuildings smithyBuilding = null;
        try {
            smithyBuilding = new VillageBuildings("Smithy", 0, 6, 7, 17);
            smithyBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeSmithyLabel("Cannot upgrade");
            BuildPanel.setSmithyButtonTrueOrFalse(false);
            BuildPanel.setSmithyLabel(smithyBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of market to the GUI
    public  void setMarket() {

        VillageBuildings marketBuilding = null;
        try {
            marketBuilding = new VillageBuildings("Market", 0, 6, 7, 17);
            marketBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeMarketLabel("Cannot upgrade");
            BuildPanel.setMarketButtonTrueOrFalse(false);
            BuildPanel.setMarketLabel(marketBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of timber to the GUI
    public  void setTimber() {

        VillageBuildings timberBuilding = null;
        try {
            timberBuilding = new VillageBuildings("Timber", 0, 6, 7, 17);
            timberBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeTimberLabel("Cannot upgrade");
            BuildPanel.setTimberButtonTrueOrFalse(false);
            BuildPanel.setTimberLabel(timberBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of clay to the GUI
    public  void setClay() {

        VillageBuildings clayBuilding = null;
        try {
            clayBuilding = new VillageBuildings("Clay", 0, 4, 5, 19);
            clayBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeClayLabel("Cannot upgrade");
            BuildPanel.setClayButtonTrueOrFalse(false);
            BuildPanel.setClayLabel(clayBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of iron to the GUI
    public  void setIron() {

        VillageBuildings ironBuilding = null;
        try {
            ironBuilding = new VillageBuildings("Iron", 0, 4, 5, 20);
            ironBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeIronLabel("Cannot upgrade");
            BuildPanel.setIronButtonTrueOrFalse(false);
            BuildPanel.setIronLabel(ironBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of farm to the GUI
    public  void setFarm() {

        VillageBuildings farmBuilding = null;
        try {
            farmBuilding = new VillageBuildings("Farm", 0, 4, 5, 15);
            farmBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeFarmLabel("Cannot upgrade");
            BuildPanel.setFarmButtonTrueOrFalse(false);
            BuildPanel.setFarmLabel(farmBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of warehouse to the GUI
    public  void setWarehouse() {

        VillageBuildings wareHouseBuilding = null;
        try {
            wareHouseBuilding = new VillageBuildings("Warehouse", 0, 9, 10, 20);
            wareHouseBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeWareHouseLabel("Cannot upgrade");
            BuildPanel.setWareHouseButtonTrueOrFalse(false);
            BuildPanel.setWareHouseLabel(wareHouseBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of hiding place to the GUI
    public  void setHidingPlace() {

        VillageBuildings hidingBuilding = null;
        try {
            hidingBuilding = new VillageBuildings("Hiding", 0, 6, 7, 22);
            hidingBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeHidingPlaceLabel("Cannot upgrade");
            BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
            BuildPanel.setHidingPlaceLabel(hidingBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of wall to the GUI
    public  void setWall() {

        VillageBuildings wallBuilding = null;
        try {
            wallBuilding = new VillageBuildings("Wall", 0, 4, 5, 14);
            wallBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeWallLabel("Cannot upgrade");
            BuildPanel.setWallButtonTrueOrFalse(false);
            BuildPanel.setWallLabel(wallBuilding.getBuildingName() + " max level");
        }
    }

    //Sends the level of academy to the GUI
    public  void setAcademy() {

        VillageBuildings academyBuilding = null;
        try {
            academyBuilding = new VillageBuildings("Academy", 0, 7, 8, 16);
            academyBuilding.setBuilding();
        }
        catch (NoSuchElementException e) {
            BuildPanel.setUpgradeAcademyLabel("Cannot upgrade");
            BuildPanel.setAcademyButtonTrueOrFalse(false);
            BuildPanel.setAcademyLabel(academyBuilding.getBuildingName() + " max level");
        }
    }


    //Sends the level of wood generation to the GUI
    public  void setWoodResource() {

        try {
            String wood;
            wood = WebAutomation.driver.findElement(By.xpath("//*[@id=\"wood\"]")).getText();
            BuildPanel.setVillageWoodAmountLabel(wood);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //Sends the level of clay generation to the GUI
    public  void setClayResource() {

        try {
            String clay;
            clay = WebAutomation.driver.findElement(By.xpath("//*[@id=\"stone\"]")).getText();
            BuildPanel.setVillageClayAmountLabel(clay);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    ////Sends the level of iron generation to the GUI
    public  void setIronResource() {

        try {
            String iron;
            iron = WebAutomation.driver.findElement(By.xpath("//*[@id=\"iron\"]")).getText();
            BuildPanel.setVillageIronAmountLabel(iron);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //Tells the user if they are being attacked
    public  void isAttacked() {

        try {

            String incoming;
            incoming = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_incoming_units\"]/h4")).getText();

            if(substring(incoming, 0, 8).equals("Incoming")) {
                BuildPanel.setVillageIncomingLabel(WebAutomation.driver.findElement(By.xpath("//*[@id=\"header_info\"]" +
                        "/tbody/tr/td[7]/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText() +
                        " Attacks incoming");
            }
        }
        catch(NoSuchElementException e) {
        }
    }

    //Sends the population to the GUI
    public  void setPopulation() {

        try {
            String setPopulaton;
            setPopulaton = WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_current_label\"]")).getText();

            String setPopulationMax;
            setPopulationMax = WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_max_label\"]")).getText();

            TroopsDetailPanel.setPopulationCountLabel(setPopulaton + "/" + setPopulationMax);
        }

        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //updates just the buildings
    public  void updateBuildings() {
        setVillageHQ();
        setBarracks();
        setStable();
        setWorkShop();
        setSmithy();
        setMarket();
        setTimber();
        setClay();
        setIron();
        setFarm();
        setWarehouse();
        setHidingPlace();
        setWall();
        setAcademy();
        //constructionOne();
    }

    //contains all the troop update functions
    public  void updateTroops() {
        setSwords();
        setAxes();
        setSpears();
        setSpies();
        setLightCal();
        setPaladin();
        setCatapult();
        setRam();
    }

    //gets the village HQ cost
    public  void getVillageHQCost() {
        try {
            villageHQWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[2]")).getText());
            villageHQClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[3]")).getText());
            villageHQIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[4]")).getText());
        }
        //if the costs arent found then it cant be built
        catch(NoSuchElementException e) {
            villageHQHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getBarracksCost() {
        try {
            barracksWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[2]")).getText());
            barracksClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[3]")).getText());
            barracksIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            barracksHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getStableCost() {
        try {
            stableWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[2]")).getText());
            stableClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[3]")).getText());
            stableIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            stableHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getWorkShopCost() {
        try {
            workShopWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[2]")).getText());
            workShopClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[3]")).getText());
            workShopIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            workShopHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getSmithtyCost() {
        try {
            smithyWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[2]")).getText());
            smithyClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[3]")).getText());
            smithyIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            smithyHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getMarketCost() {
        try {
            marketWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[2]")).getText());
            marketClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[3]")).getText());
            marketIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            marketHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getTimberCost() {
        try {
            timberWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[2]")).getText());
            timberClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[3]")).getText());
            timberIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            timberHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }

    }

    public  void getClayCost() {
        try {
            clayWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[2]")).getText());
            clayClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[3]")).getText());
            clayIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            clayHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getIronCost() {
        try {
            ironWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[2]")).getText());
            ironClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[3]")).getText());
            ironIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            ironHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getFarmCost() {
        try {
            farmWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[2]")).getText());
            farmClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[3]")).getText());
            farmIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            farmHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getWareHouseCost() {
        try {
            wareHouseWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[2]")).getText());
            wareHouseClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[3]")).getText());
            wareHouseIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            wareHouseHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getWallCost() {
        try {
            wallWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[2]")).getText());
            wallClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[3]")).getText());
            wallIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            wallHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public  void getAcademyCost() {
        try {
            academyWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[2]")).getText());
            academyClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[3]")).getText());
            academyIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            academyHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public void getHidingPlaceCost() {
        try {
            hidingPlaceWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[2]")).getText());
            hidingPlaceClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[3]")).getText());
            hidingPlaceIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            hidingPlaceHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //method to easily get all the building costs
    public  void getAllBuildingCosts() {
        getVillageHQCost();
        getBarracksCost();
        getStableCost();
        getWorkShopCost();
        getSmithtyCost();
        getMarketCost();
        getTimberCost();
        getClayCost();
        getIronCost();
        getFarmCost();
        getWareHouseCost();
        getWallCost();
        getAcademyCost();
        getHidingPlaceCost();
    }

    public String getxLoc() {
        return xLoc;
    }

    public void setxLoc(String xLocation) {
        xLoc = xLocation;
    }

    public String getyLoc() {
        return yLoc;
    }

    public void setyLoc(String yLocation) {
        yLoc = yLocation;
    }

    public int getNumberOfFarms() {
        return numberOfFarms;
    }

    public void setNumberOfFarms(int newNumber) {
        numberOfFarms = newNumber;
    }

    public int getVillageHQWoodCost() {
        return villageHQWoodCost;
    }

    public void setVillageHQWoodCost(int newNumber) {
        villageHQWoodCost = newNumber;
    }

    public int getVillageHQClayCost() {
        return villageHQClayCost;
    }

    public void setVillageHQClayCost(int newNumber) {
        villageHQClayCost = newNumber;
    }

    public int getVillageHQIronCost() {
        return villageHQIronCost;
    }

    public void setVillageHQIronCost(int newNumber) {
        villageHQIronCost = newNumber;
    }

    public  boolean isVillageHQHasCost() {
        return villageHQHasCost;
    }

    public void setVillageHQHasCost(boolean newBoolean) {
        villageHQHasCost = newBoolean;
    }

    public int getBarracksWoodCost() {
        return barracksWoodCost;
    }

    public void setBarracksWoodCost(int newNumber) {
         barracksWoodCost = newNumber;
    }

    public int getBarracksClayCost() {
        return barracksClayCost;
    }

    public void setBarracksClayCost(int newNumber) {
         barracksClayCost = newNumber;
    }

    public int getBarracksIronCost() {
        return barracksIronCost;
    }

    public void setBarracksIronCost(int newNumber) {
        barracksIronCost = newNumber;
    }

    public boolean isBarracksHasCost() {
        return barracksHasCost;
    }

    public void setBarracksHasCost(boolean newBoolean) {
        barracksHasCost = newBoolean;
    }

    public int getStableWoodCost() {
        return stableWoodCost;
    }

    public void setStableWoodCost(int newNumber) {
        stableWoodCost = newNumber;
    }

    public int getStableClayCost() {
        return stableClayCost;
    }

    public void setStableClayCost(int newNumber) {
        stableClayCost = newNumber;
    }

    public int getStableIronCost() {
        return stableIronCost;
    }

    public void setStableIronCost(int newNumber) {
        stableIronCost = newNumber;
    }

    public boolean isStableHasCost() {
        return stableHasCost;
    }

    public  void setStableHasCost(boolean newBoolean) {
        stableHasCost = newBoolean;
    }

    public  int getWorkShopWoodCost() {
        return workShopWoodCost;
    }

    public  void setWorkShopWoodCost(int newNumber) {
        workShopWoodCost = newNumber;
    }

    public  int getWorkShopClayCost() {
        return workShopClayCost;
    }

    public  void setWorkShopClayCost(int newNumber) {
        workShopClayCost = newNumber;
    }

    public  int getWorkShopIronCost() {
        return workShopIronCost;
    }

    public  void setWorkShopIronCost(int newNumber) {
         workShopIronCost = newNumber;
    }

    public  boolean isWorkShopHasCost() {
        return workShopHasCost;
    }

    public  void setWorkShopHasCost(boolean newBoolean) {
        workShopHasCost = newBoolean;
    }

    public  int getSmithyWoodCost() {
        return smithyWoodCost;
    }

    public  void setSmithyWoodCost(int newNumber) {
        smithyWoodCost = newNumber;
    }

    public  int getSmithyClayCost() {
        return smithyClayCost;
    }

    public  void setSmithyClayCost(int newNumber) {
        smithyClayCost = newNumber;
    }

    public  int getSmithyIronCost() {
        return smithyIronCost;
    }

    public  void setSmithyIronCost(int newNumber) {
        smithyIronCost = newNumber;
    }

    public  boolean isSmithyHasCost() {
        return smithyHasCost;
    }

    public  void setSmithyHasCost(boolean newBoolean) {
        smithyHasCost = newBoolean;
    }

    public  int getMarketWoodCost() {
        return marketWoodCost;
    }

    public  void setMarketWoodCost(int newNumber) {
        marketWoodCost = newNumber;
    }

    public  int getMarketClayCost() {
        return marketClayCost;
    }

    public  void setMarketClayCost(int newNumber) {
        marketClayCost = newNumber;
    }

    public  int getMarketIronCost() {
        return marketIronCost;
    }

    public  void setMarketIronCost(int newNumber) {
        marketIronCost = newNumber;
    }

    public  boolean isMarketHasCost() {
        return marketHasCost;
    }

    public  void setMarketHasCost(boolean newBoolean) {
        marketHasCost = newBoolean;
    }

    public  int getTimberWoodCost() {
        return timberWoodCost;
    }

    public  void setTimberWoodCost(int newNumber) {
         timberWoodCost = newNumber;
    }

    public  int getTimberClayCost() {
        return timberClayCost;
    }

    public  void setTimberClayCost(int newNumber) {
        timberClayCost = newNumber;
    }

    public  int getTimberIronCost() {
        return timberIronCost;
    }

    public  void setTimberIronCost(int newNumber) {
        timberIronCost = newNumber;
    }

    public  boolean isTimberHasCost() {
        return timberHasCost;
    }

    public  void setTimberHasCost(boolean newBoolean) {
        timberHasCost = newBoolean;
    }

    public  int getClayWoodCost() {
        return clayWoodCost;
    }

    public  void setClayWoodCost(int newNumber) {
        clayWoodCost = newNumber;
    }

    public  int getClayClayCost() {
        return clayClayCost;
    }

    public  void setClayClayCost(int newNumber) {
        clayClayCost = newNumber;
    }

    public  int getClayIronCost() {
        return clayIronCost;
    }

    public  void setClayIronCost(int newNumber) {
        clayIronCost = newNumber;
    }

    public  boolean isClayHasCost() {
        return clayHasCost;
    }

    public  void setClayHasCost(boolean newBoolean) {
        clayHasCost = newBoolean;
    }

    public  int getIronWoodCost() {
        return ironWoodCost;
    }

    public  void setIronWoodCost(int newNumber) {
        ironWoodCost = newNumber;
    }

    public  int getIronClayCost() {
        return ironClayCost;
    }

    public  void setIronClayCost(int newNumber) {
        ironClayCost = newNumber;
    }

    public  int getIronIronCost() {
        return ironIronCost;
    }

    public  void setIronIronCost(int newNumber) {
        ironIronCost = newNumber;
    }

    public  boolean isIronHasCost() {
        return ironHasCost;
    }

    public  void setIronHasCost(boolean newBoolean) {
        ironHasCost = newBoolean;
    }

    public  int getFarmWoodCost() {
        return farmWoodCost;
    }

    public  void setFarmWoodCost(int newNumber) {
         farmWoodCost = newNumber;
    }

    public  int getFarmClayCost() {
        return farmClayCost;
    }

    public  void setFarmClayCost(int newNumber) {
         farmClayCost = newNumber;
    }

    public  int getFarmIronCost() {
        return farmIronCost;
    }

    public  void setFarmIronCost(int newNumber) {
         farmIronCost = newNumber;
    }

    public  boolean isFarmHasCost() {
        return farmHasCost;
    }

    public  void setFarmHasCost(boolean newBoolean) {
        farmHasCost = newBoolean;
    }

    public  int getWareHouseWoodCost() {
        return wareHouseWoodCost;
    }

    public  void setWareHouseWoodCost(int newNumber) {
        wareHouseWoodCost = newNumber;
    }

    public  int getWareHouseClayCost() {
        return wareHouseClayCost;
    }

    public  void setWareHouseClayCost(int newNumber) {
         wareHouseClayCost = newNumber;
    }

    public  int getWareHouseIronCost() {
        return wareHouseIronCost;
    }

    public  void setWareHouseIronCost(int newNumber) {
         wareHouseIronCost = newNumber;
    }

    public  boolean isWareHouseHasCost() {
        return wareHouseHasCost;
    }

    public  void setWareHouseHasCost(boolean newBoolean) {
        wareHouseHasCost = newBoolean;
    }

    public  int getWallWoodCost() {
        return wallWoodCost;
    }

    public  void setWallWoodCost(int newNumber) {
        wallWoodCost = newNumber;
    }

    public  int getWallClayCost() {
        return wallClayCost;
    }

    public  void setWallClayCost(int newNumber) {
        wallClayCost = newNumber;
    }

    public  int getWallIronCost() {
        return wallIronCost;
    }

    public  void setWallIronCost(int newNumber) {
        wallIronCost = newNumber;
    }

    public  boolean isWallHasCost() {
        return wallHasCost;
    }

    public  void setWallHasCost(boolean newBoolean) {
        wallHasCost = newBoolean;
    }

    public int getAcademyWoodCost() {
        return academyWoodCost;
    }

    public void setAcademyWoodCost(int newNumber) {
        academyWoodCost = newNumber;
    }

    public int getAcademyClayCost() {
        return academyClayCost;
    }

    public void setAcademyClayCost(int newNumber) {
        academyClayCost = newNumber;
    }

    public int getAcademyIronCost() {
        return academyIronCost;
    }

    public void setAcademyIronCost(int newNumber) {
        academyIronCost = newNumber;
    }

    public boolean isAcademyHasCost() {
        return academyHasCost;
    }

    public void setAcademyHasCost(boolean newBoolean) {
        academyHasCost = newBoolean;
    }

    public int getHidingPlaceWoodCost() {
        return hidingPlaceWoodCost;
    }

    public void setHidingPlaceWoodCost(int newNumber) {
        hidingPlaceWoodCost = newNumber;
    }

    public int getHidingPlaceClayCost() {
        return hidingPlaceClayCost;
    }

    public void setHidingPlaceClayCost(int newNumber) {
        hidingPlaceClayCost = newNumber;
    }

    public int getHidingPlaceIronCost() {
        return hidingPlaceIronCost;
    }

    public void setHidingPlaceIronCost(int newNumber) {
        hidingPlaceIronCost = newNumber;
    }

    public boolean isHidingPlaceHasCost() {
        return hidingPlaceHasCost;
    }

    public void setHidingPlaceHasCost(boolean newBoolean) {
        hidingPlaceHasCost = newBoolean;
    }

    public int getCurrentWood() {
        return currentWood;
    }

    public void setCurrentWood(int newNumber) {
        currentWood = newNumber;
    }

    public int getCurrentClay() {
        return currentClay;
    }

    public void setCurrentClay(int newNumber) {
        currentClay = newNumber;
    }

    public int getCurrentIron() {
        return currentIron;
    }

    public void setCurrentIron(int newNumber) {
        currentIron = newNumber;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int newNumber) {
        currentPopulation = newNumber;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public void setMaxPopulation(int newNumber) {
        maxPopulation = newNumber;
    }
}

