
/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 1/18/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
package com.gmail.ttkyle.src;

import org.openqa.selenium.By;
import static org.apache.commons.lang.StringUtils.substring;

public class VillageBuildings {

    private String buildingName;
    private int startOfBuildingName;
    private int endOfBuildingName;
    private int startOfLevelBuilding;
    private int endOfLevelBuilding;

    public VillageBuildings(String name, int startOfBuildingName, int endOfBuildingName, int startOfLevelBuilding,
                            int endOfLevelBuilding) {
        buildingName = name;
        this.startOfBuildingName = startOfBuildingName;
        this.endOfBuildingName = endOfBuildingName;
        this.startOfLevelBuilding = startOfLevelBuilding;
        this.endOfLevelBuilding = endOfLevelBuilding;
    }

    public void setBuilding() {

        for(int i = 2; i < 20; i++) {

                String buildingName = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(buildingName, startOfBuildingName, endOfBuildingName).equals(this.buildingName)) {
                    if(this.buildingName.equals("Stable")) {
                        BuildPanel.setStableLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Village")) {
                        BuildPanel.setVillageHQLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Barracks")) {
                        BuildPanel.setBarracksLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Workshop")) {
                        BuildPanel.setWorkShopLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Smithy")) {
                        BuildPanel.setSmithyLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Market")) {
                        BuildPanel.setMarketLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Timber")) {
                        BuildPanel.setTimberLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Clay")) {
                        BuildPanel.setClayLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Iron")) {
                        BuildPanel.setIronLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Farm")) {
                        BuildPanel.setFarmLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Warehouse")) {
                        BuildPanel.setWareHouseLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Hiding")) {
                        BuildPanel.setHidingPlaceLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Wall")) {
                        BuildPanel.setWallLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(this.buildingName.equals("Academy")) {
                        BuildPanel.setAcademyLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    }
                    if(substring(buildingName, startOfLevelBuilding, endOfLevelBuilding).equals("")) {

                        if(this.buildingName.equals("Stable")) {
                            BuildPanel.setStableLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setStableButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Village")) {
                            BuildPanel.setVillageHQLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setVillageHQButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Barracks")) {
                            BuildPanel.setBarracksLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setBarracksButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Workshop")) {
                            BuildPanel.setWorkShopLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setWorkShopButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Smithy")) {
                            BuildPanel.setSmithyLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setSmithyButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Market")) {
                            BuildPanel.setMarketLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setMarketButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Timber")) {
                            BuildPanel.setTimberLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setTimberButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Clay")) {
                            BuildPanel.setClayLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setClayButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Iron")) {
                            BuildPanel.setIronLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setIronButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Farm")) {
                            BuildPanel.setFarmLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setFarmButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Warehouse")) {
                            BuildPanel.setWareHouseLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setWareHouseButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Hiding")) {
                            BuildPanel.setHidingPlaceLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Wall")) {
                            BuildPanel.setWallLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setWallButtonTrueOrFalse(false);
                        }
                        if(this.buildingName.equals("Academy")) {
                            BuildPanel.setAcademyLabel(this.buildingName + " (Level 0)");
                            BuildPanel.setAcademyButtonTrueOrFalse(false);
                        }
                    }
                    break;
                }
                else {
                    if(this.buildingName.equals("Stable")) {
                        BuildPanel.setStableLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Village")) {
                        BuildPanel.setVillageHQLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Barracks")) {
                        BuildPanel.setBarracksLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Workshop")) {
                        BuildPanel.setWorkShopLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Smithy")) {
                        BuildPanel.setSmithyLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Market")) {
                        BuildPanel.setMarketLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Timber")) {
                        BuildPanel.setTimberLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Clay")) {
                        BuildPanel.setClayLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Iron")) {
                        BuildPanel.setIronLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Farm")) {
                        BuildPanel.setFarmLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Warehouse")) {
                        BuildPanel.setWareHouseLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Hiding")) {
                        BuildPanel.setHidingPlaceLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Wall")) {
                        BuildPanel.setWallLabel(this.buildingName + " (Level 0)");
                    }
                    if(this.buildingName.equals("Academy")) {
                        BuildPanel.setAcademyLabel(this.buildingName + " (Level 0)");
                    }
                }
        }
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getStartOfBuildingName() {
        return startOfBuildingName;
    }

    public void setStartOfBuildingName(int startOfBuildingName) {
        this.startOfBuildingName = startOfBuildingName;
    }

    public int getEndOfBuildingName() {
        return endOfBuildingName;
    }

    public void setEndOfBuildingName(int endOfBuildingName) {
        this.endOfBuildingName = endOfBuildingName;
    }

    public int getStartOfLevelBuilding() {
        return startOfLevelBuilding;
    }

    public void setStartOfLevelBuilding(int startOfLevelBuilding) {
        this.startOfLevelBuilding = startOfLevelBuilding;
    }

    public int getEndOfLevelBuilding() {
        return endOfLevelBuilding;
    }

    public void setEndOfLevelBuilding(int endOfLevelBuilding) {
        this.endOfLevelBuilding = endOfLevelBuilding;
    }
}

