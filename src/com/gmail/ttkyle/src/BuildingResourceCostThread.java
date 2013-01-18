package com.gmail.ttkyle.src;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.awt.*;

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
                if(Village.getVillageHQWoodCost() > 0) {
                    Village.setVillageHQHasCost(true);

                    //determines if the user has enough resources to build the village HQ
                    //if not then the button is greyed
                    if(Village.getVillageHQWoodCost() > Village.getCurrentWood() ||
                    Village.getVillageHQClayCost() > Village.getCurrentClay() ||
                    Village.getVillageHQIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setVillageHQButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //if the barracks wood cost is > 0 then set hasCost flag as true
                if(Village.getBarracksWoodCost() > 0) {
                    Village.setBarracksHasCost(true);

                    //determines if the user has enough resources to build the barracks
                    //if not then the button is greyed
                    if(Village.getBarracksWoodCost() > Village.getCurrentWood() ||
                    Village.getBarracksClayCost() > Village.getCurrentClay() ||
                    Village.getBarracksIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setBarracksButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //if the stable wood cost is > 0 then set hasCost flag as true
                if(Village.getStableWoodCost() > 0) {
                    Village.setStableHasCost(true);

                    //determines if the user has enough resources to build the stable
                    //if not then the button is greyed
                    if(Village.getStableWoodCost() > Village.getCurrentWood() ||
                    Village.getStableClayCost() > Village.getCurrentClay() ||
                    Village.getStableIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setStableButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //if the WorkShop wood cost is > 0 then set hasCost flag as true
                if(Village.getWorkShopWoodCost() > 0) {
                    Village.setWorkShopHasCost(true);

                    //determines if the user has enough resources to build the workshop
                    //if not then the button is greyed
                    if(Village.getWorkShopWoodCost() > Village.getCurrentWood() ||
                    Village.getWorkShopClayCost() > Village.getCurrentClay() ||
                    Village.getWorkShopIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setWorkShopButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //if the smithy wood cost is > 0 then set the hasCost flag as true
                if(Village.getSmithyWoodCost() > 0) {
                    Village.setSmithyHasCost(true);

                    //determines if the user has enough resources to build the smithy
                    //if not then the button is greyed
                    if(Village.getSmithyWoodCost() > Village.getCurrentWood() ||
                    Village.getSmithyClayCost() > Village.getCurrentClay() ||
                    Village.getSmithyIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setSmithyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //if the market wood cost is > 0 then set the hasCost flag as true
                if(Village.getMarketWoodCost() > 0) {
                    Village.setMarketHasCost(true);

                    //determines if the user has enough resources to build the market
                    //if not then the button is greyed
                    if(Village.getMarketWoodCost() > Village.getCurrentWood() ||
                    Village.getMarketClayCost() > Village.getCurrentClay() ||
                    Village.getMarketIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setMarketButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //if the timber wood cost is > 0 then set the hasCost flag as true
                if(Village.getTimberWoodCost() > 0) {
                    Village.setTimberHasCost(true);

                    //determines if the user has enough resources to build the timber
                    //if not then the button is greyed
                    if(Village.getTimberWoodCost() > Village.getCurrentWood() ||
                    Village.getTimberClayCost() > Village.getCurrentClay() ||
                    Village.getTimberIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setTimberButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //if the clay wood cost is > 0 then set the hasCost flag as true
                if(Village.getClayWoodCost() > 0) {
                    Village.setClayHasCost(true);

                    //determines if the user has enough resources to build the clay
                    //if not then grey the button
                    if(Village.getClayWoodCost() > Village.getCurrentWood() ||
                    Village.getClayClayCost() > Village.getCurrentClay() ||
                    Village.getClayIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setClayButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //if the iron wood cost is > 0 then set the hasCost flag as true
                if(Village.getIronWoodCost() > 0) {
                    Village.setIronHasCost(true);

                    //determines if the user has enough resources to build the iron
                    //if not then grey the button
                    if(Village.getIronWoodCost() > Village.getCurrentWood() ||
                    Village.getIronClayCost() > Village.getCurrentClay() ||
                    Village.getIronIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setIronButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //if the farm wood cost is > 0 then set the hasCost flag as true
                if(Village.getFarmWoodCost() > 0) {
                    Village.setFarmHasCost(true);

                    //determines if the user has enough resources to build the farm
                    //if not then grey the button
                    if(Village.getFarmWoodCost() > Village.getCurrentWood() ||
                    Village.getFarmClayCost() > Village.getCurrentClay() ||
                    Village.getFarmIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setFarmButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //if the warehouse wood cost is > 0 then set the hasCOst flag as true
                if(Village.getWareHouseWoodCost() > 0) {
                    Village.setWareHouseHasCost(true);

                    //determines if the user has enough resources to build the warehouse
                    //if not then grey the button
                    if(Village.getWareHouseWoodCost() > Village.getCurrentWood() ||
                    Village.getWareHouseClayCost() > Village.getCurrentClay() ||
                    Village.getWareHouseIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setWareHouseButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //if the wall wood cost > 0 then set the hasCost flag as true
                if(Village.getWallWoodCost() > 0) {
                    Village.setWallHasCost(true);

                    //determines if the user has enough resources to build the wall
                    //if not then grey the button
                    if(Village.getWallWoodCost() > Village.getCurrentWood() ||
                    Village.getWallClayCost() > Village.getCurrentClay() ||
                    Village.getWallIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setWallButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //if the academy wood cost > 0 then set the hasCost flag as true
                if(Village.getAcademyWoodCost() > 0) {
                    Village.setAcademyHasCost(true);

                    //determines if the user has enough resources to build the academy
                    //if not then grey the button
                    if(Village.getAcademyWoodCost() > Village.getCurrentWood() ||
                    Village.getAcademyClayCost() > Village.getCurrentClay() ||
                    Village.getAcademyIronCost() > Village.getCurrentIron()) {
                        BuildPanel.setAcademyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //if the hidingplace wood cost  > 0 then set the hasCost flag as true
                if(Village.getHidingPlaceWoodCost() > 0) {
                    Village.setHidingPlaceHasCost(true);

                    //determines if the user has enough resources to build the hidingplace
                    //if not then grey the button
                    if(Village.getHidingPlaceWoodCost() > Village.getCurrentWood() ||
                    Village.getHidingPlaceClayCost() > Village.getCurrentClay() ||
                    Village.getHidingPlaceIronCost() > Village.getCurrentIron()) {
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
                if(Village.getVillageHQWoodCost() <= Village.getCurrentWood() &&
                Village.getVillageHQClayCost() <= Village.getCurrentClay() &&
                Village.getVillageHQIronCost() <= Village.getCurrentIron() &&
                Village.isVillageHQHasCost()) {
                    BuildPanel.setVillageHQButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //check if the barracks costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getBarracksWoodCost() <= Village.getCurrentWood() &&
                Village.getBarracksClayCost() <= Village.getCurrentClay() &&
                Village.getBarracksIronCost() <= Village.getCurrentIron() &&
                Village.isBarracksHasCost()) {
                    BuildPanel.setBarracksButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //check if the stable costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getStableWoodCost() <= Village.getCurrentWood() &&
                Village.getStableClayCost() <= Village.getCurrentClay() &&
                Village.getStableIronCost() <= Village.getCurrentIron() &&
                Village.isStableHasCost()) {
                    BuildPanel.setStableButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //check if the workshop costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getWorkShopWoodCost() <= Village.getCurrentWood() &&
                Village.getWorkShopClayCost() <= Village.getCurrentClay() &&
                Village.getWorkShopIronCost() <= Village.getCurrentIron() &&
                Village.isWorkShopHasCost()) {
                    BuildPanel.setWorkShopButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //check if the smithy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getSmithyWoodCost() <= Village.getCurrentWood() &&
                Village.getSmithyClayCost() <= Village.getCurrentClay() &&
                Village.getSmithyIronCost() <= Village.getCurrentIron() &&
                Village.isSmithyHasCost()) {
                    BuildPanel.setSmithyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //check if the market costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getMarketWoodCost() <= Village.getCurrentWood() &&
                Village.getMarketClayCost() <= Village.getCurrentClay() &&
                Village.getMarketIronCost() <= Village.getCurrentIron() &&
                Village.isMarketHasCost()) {
                    BuildPanel.setMarketButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //check if the timber costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getTimberWoodCost() <= Village.getCurrentWood() &&
                Village.getTimberClayCost() <= Village.getCurrentClay() &&
                Village.getTimberIronCost() <= Village.getCurrentIron() &&
                Village.isTimberHasCost()) {
                    BuildPanel.setTimberButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //check if the clay costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getClayWoodCost() <= Village.getCurrentWood() &&
                Village.getClayClayCost() <= Village.getCurrentClay() &&
                Village.getClayIronCost() <= Village.getCurrentIron() &&
                Village.isClayHasCost()) {
                    BuildPanel.setClayButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //check if the iron costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getIronWoodCost() <= Village.getCurrentWood() &&
                Village.getIronClayCost() <= Village.getCurrentClay() &&
                Village.getIronIronCost() <= Village.getCurrentIron() &&
                Village.isIronHasCost()) {
                    BuildPanel.setIronButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //check if the farm costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getFarmWoodCost() <= Village.getCurrentWood() &&
                Village.getFarmClayCost() <= Village.getCurrentClay() &&
                Village.getFarmIronCost() <= Village.getCurrentIron() &&
                Village.isFarmHasCost()) {
                    BuildPanel.setFarmButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //check if the warehouse costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getWareHouseWoodCost() <= Village.getCurrentWood() &&
                Village.getWareHouseClayCost() <= Village.getCurrentClay() &&
                Village.getWareHouseIronCost() <= Village.getCurrentIron() &&
                Village.isWareHouseHasCost()) {
                    BuildPanel.setWareHouseButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //check if the wall costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getWallWoodCost() <= Village.getCurrentWood() &&
                Village.getWallClayCost() <= Village.getCurrentClay() &&
                Village.getWallIronCost() <= Village.getCurrentIron() &&
                Village.isWallHasCost()) {
                    BuildPanel.setWallButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //check if the academy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getAcademyWoodCost() <= Village.getCurrentWood() &&
                Village.getAcademyClayCost() <= Village.getCurrentClay() &&
                Village.getAcademyIronCost() <= Village.getCurrentIron() &&
                Village.isAcademyHasCost()) {
                    BuildPanel.setAcademyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //check if the hidingplace costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.getHidingPlaceWoodCost() <= Village.getCurrentWood() &&
                Village.getHidingPlaceClayCost() <= Village.getCurrentClay() &&
                Village.getHidingPlaceIronCost() <= Village.getCurrentIron() &&
                Village.isHidingPlaceHasCost()) {
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
