
/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 1/18/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
package com.gmail.ttkyle.src;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
            try {
                String buildingName = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(buildingName, startOfBuildingName, endOfBuildingName).equals(this.buildingName)) {
                    BuildPanel.setStableLabel(this.buildingName + substring(buildingName, startOfLevelBuilding, endOfLevelBuilding));
                    if(substring(buildingName, startOfLevelBuilding, endOfLevelBuilding).equals("")) {
                        BuildPanel.setStableLabel(this.buildingName + "  (Level 0)");
                        BuildPanel.setStableButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setStableLabel(this.buildingName + " (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeStableLabel("Cannot upgrade");
                BuildPanel.setStableButtonTrueOrFalse(false);
                BuildPanel.setStableLabel(this.buildingName + " max level");
            }
        }
    }
}
