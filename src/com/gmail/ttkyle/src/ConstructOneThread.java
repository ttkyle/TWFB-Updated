/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/16/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
package com.gmail.ttkyle.src;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

/**
 *This thread runs every 10 seconds and determines if the
 * current user is building anything and displays the current time
 * left if they are
 */
public class ConstructOneThread implements Runnable {
   public static boolean constructionFlagOne = false;


    ConstructOneThread() {
        //create the new thread
        Thread constructOne = new Thread(this);

        //start the thread
        constructOne.start();
    }

    public void run() {
        //always need the thread running
        while(true) {
            try {
                //if total time is less than 10 seconds break out the 2nd while
                if(Village.getTotalOne() <= 10000) {
                    constructionFlagOne = false;

                    if(Village.getTotalOne() == 0) {
                        Thread.sleep(10000);
                    }

                    //if neither total has time then nothing is building
                    if(Village.getTotalTwo() == 0 && Village.getTotalOne() == 0) {

                        BuildingConstructionPanel.setAssignmentOne("No Construction");
                        BuildingConstructionPanel.setDurationOne("N/A");
                        BuildingConstructionPanel.setCompletionOne("N/A");

                        BuildingConstructionPanel.setAssignmentTwo("No Construction");
                        BuildingConstructionPanel.setDurationTwo("N/A");
                        BuildingConstructionPanel.setCompletionTwo("N/A");
                    }

                    //if the second total has a value then we need to transfer values over
                    //and get back in the 2nd while
                    if(Village.getTotalTwo() != 0) {
                        Village.setTotalOne(Village.getTotalTwo());
                        Village.setTotalOneOne(Village.getTotalTwoOne());
                        Village.setTotalOneSecond(Village.getTotalTwoSecond());
                        Village.setTotalOneThird(Village.getTotalTwoThird());
                        Village.setTotalOneFourth(Village.getTotalTwoFourth());
                        Village.setTotalOneFifth(Village.getTotalTwoFifth());
                        Village.setTotalOneSixth(Village.getTotalTwoSixth());
                        Village.setTotalOneSeventh(Village.getTotalTwoSeventh());
                        Village.setTotalOneEighth(Village.getTotalTwoEighth());

                        BuildingConstructionPanel.setAssignmentOne(BuildingConstructionPanel.getAssignmentTwo().getText());
                        BuildingConstructionPanel.setDurationOne(BuildingConstructionPanel.getDurationTwo().getText());
                        BuildingConstructionPanel.setCompletionOne(BuildingConstructionPanel.getCompletionTwo().getText());

                        BuildingConstructionPanel.setAssignmentTwo("No Construction");
                        BuildingConstructionPanel.setDurationTwo("N/A");
                        BuildingConstructionPanel.setCompletionTwo("N/A");

                        Village.setTotalTwo(0);
                        Village.setTotalTwoOne(0);
                        Village.setTotalTwoSecond(0);
                        Village.setTotalTwoThird(0);
                        Village.setTotalTwoFourth(0);
                        Village.setTotalTwoFifth(0);
                        Village.setTotalTwoSixth(0);
                        Village.setTotalTwoSeventh(0);
                        Village.setTotalTwoEighth(0);

                        constructionFlagOne = true;
                    }
                }

                //runs the timber  until it's less than 10 seconds
                while(constructionFlagOne) {
                    if(Village.getTotalOne() > 10000) {
                        Village.constructionOneTimer();
                        Thread.sleep(10000);
                    }
                    else {
                        Village.setTotalOne(0);
                        constructionFlagOne = false;
                    }
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
}