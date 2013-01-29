
package com.gmail.ttkyle.src;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

/**
 * This thread runs every 5 seconds. The purpose of this thread
 * is to use information gathered when the user logs in or
 * selects another village that they own to determine if the user
 * has the required resources (wood, clay, iron) to construct
 * a building.
 *
 * If the user has the required resources the build button
 * for a building will be lit up, if the user does not have
 * the required resources then the button will be greyed out.
 *
 * The buttons will automatically turn grey or light up if the
 * user doesn't have enough resources or gains the right amount
 * of resources.
 */
public class BuildingResourceCostThread implements Runnable {


    BuildingResourceCostThread() {

        //make a new thread
        Thread buildingResourceCostThread = new Thread(this);

        //start the new thread
        buildingResourceCostThread.start();
    }

    public void run() {
        try {
            while(true) {

                //if the village HQ wood cost is > 0 then set hasCost flag as true
                if(Twfb.twfbAppGui.frame.getVillageHQWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setVillageHQHasCost(true);

                    //determines if the user has enough resources to build the village HQ
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getVillageHQWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getVillageHQClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getVillageHQIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setVillageHQButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //if the barracks wood cost is > 0 then set hasCost flag as true
                if(Twfb.twfbAppGui.frame.getBarracksWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setBarracksHasCost(true);

                    //determines if the user has enough resources to build the barracks
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getBarracksWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getBarracksClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getBarracksIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setBarracksButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //if the stable wood cost is > 0 then set hasCost flag as true
                if(Twfb.twfbAppGui.frame.getStableWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setStableHasCost(true);

                    //determines if the user has enough resources to build the stable
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getStableWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getStableClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getStableIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setStableButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //if the WorkShop wood cost is > 0 then set hasCost flag as true
                if(Twfb.twfbAppGui.frame.getWorkShopWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setWorkShopHasCost(true);

                    //determines if the user has enough resources to build the workshop
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getWorkShopWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getWorkShopClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getWorkShopIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setWorkShopButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //if the smithy wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getSmithyWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setSmithyHasCost(true);

                    //determines if the user has enough resources to build the smithy
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getSmithyWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getSmithyClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getSmithyIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setSmithyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //if the market wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getMarketWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setMarketHasCost(true);

                    //determines if the user has enough resources to build the market
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getMarketWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getMarketClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getMarketIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setMarketButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //if the timber wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getTimberWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setTimberHasCost(true);

                    //determines if the user has enough resources to build the timber
                    //if not then the button is greyed
                    if(Twfb.twfbAppGui.frame.getTimberWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getTimberClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getTimberIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setTimberButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //if the clay wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getClayWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setClayHasCost(true);

                    //determines if the user has enough resources to build the clay
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getClayWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getClayClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getClayIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setClayButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //if the iron wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getIronWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setIronHasCost(true);

                    //determines if the user has enough resources to build the iron
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getIronWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getIronClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getIronIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setIronButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //if the farm wood cost is > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getFarmWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setFarmHasCost(true);

                    //determines if the user has enough resources to build the farm
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getFarmWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getFarmClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getFarmIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setFarmButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //if the warehouse wood cost is > 0 then set the hasCOst flag as true
                if(Twfb.twfbAppGui.frame.getWareHouseWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setWareHouseHasCost(true);

                    //determines if the user has enough resources to build the warehouse
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getWareHouseWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getWareHouseClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getWareHouseIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setWareHouseButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //if the wall wood cost > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getWallWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setWallHasCost(true);

                    //determines if the user has enough resources to build the wall
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getWallWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getWallClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getWallIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setWallButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //if the academy wood cost > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getAcademyWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setAcademyHasCost(true);

                    //determines if the user has enough resources to build the academy
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getAcademyWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getAcademyClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getAcademyIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setAcademyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //if the hidingplace wood cost  > 0 then set the hasCost flag as true
                if(Twfb.twfbAppGui.frame.getHidingPlaceWoodCost() > 0) {
                    Twfb.twfbAppGui.frame.setHidingPlaceHasCost(true);

                    //determines if the user has enough resources to build the hidingplace
                    //if not then grey the button
                    if(Twfb.twfbAppGui.frame.getHidingPlaceWoodCost() > Twfb.twfbAppGui.frame.getCurrentWood() ||
                            Twfb.twfbAppGui.frame.getHidingPlaceClayCost() > Twfb.twfbAppGui.frame.getCurrentClay() ||
                            Twfb.twfbAppGui.frame.getHidingPlaceIronCost() > Twfb.twfbAppGui.frame.getCurrentIron()) {
                        BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                }



                //check if the village HQ costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getVillageHQWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getVillageHQClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getVillageHQIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.isVillageHQHasCost()) {
                    BuildPanel.setVillageHQButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //check if the barracks costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getBarracksWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getBarracksClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getBarracksIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.barracksHasCost()) {
                    BuildPanel.setBarracksButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //check if the stable costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getStableWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getStableClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getStableIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.stableHasCost()) {
                    BuildPanel.setStableButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //check if the workshop costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getWorkShopWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getWorkShopClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getWorkShopIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.workShopHasCost()) {
                    BuildPanel.setWorkShopButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //check if the smithy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getSmithyWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getSmithyClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getSmithyIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.smithyHasCost()) {
                    BuildPanel.setSmithyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //check if the market costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getMarketWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getMarketClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getMarketIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.marketHasCost()) {
                    BuildPanel.setMarketButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //check if the timber costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getTimberWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getTimberClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getTimberIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.timberHasCost()) {
                    BuildPanel.setTimberButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //check if the clay costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getClayWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getClayClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getClayIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.clayHasCost()) {
                    BuildPanel.setClayButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //check if the iron costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getIronWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getIronClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getIronIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.ironHasCost()) {
                    BuildPanel.setIronButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //check if the farm costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getFarmWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getFarmClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getFarmIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.farmHasCost()) {
                    BuildPanel.setFarmButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //check if the warehouse costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getWareHouseWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getWareHouseClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getWareHouseIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.wareHouseHasCost()) {
                    BuildPanel.setWareHouseButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //check if the wall costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getWallWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getWallClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getWallIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.wallHasCost()) {
                    BuildPanel.setWallButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //check if the academy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getAcademyWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getAcademyClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getAcademyIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.academyHasCost()) {
                    BuildPanel.setAcademyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //check if the hidingplace costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Twfb.twfbAppGui.frame.getHidingPlaceWoodCost() <= Twfb.twfbAppGui.frame.getCurrentWood() &&
                        Twfb.twfbAppGui.frame.getHidingPlaceClayCost() <= Twfb.twfbAppGui.frame.getCurrentClay() &&
                        Twfb.twfbAppGui.frame.getHidingPlaceIronCost() <= Twfb.twfbAppGui.frame.getCurrentIron() &&
                        Twfb.twfbAppGui.frame.hidingPlaceHasCost()) {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                }

                //make the thread sleep for 5 seconds
                Thread.sleep(5000);
            }
        }
        catch(NoSuchElementException e) {
        }
        catch (InterruptedException e) {
        }
        catch(StaleElementReferenceException e) {
        }

    }
}