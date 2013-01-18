package com.gmail.ttkyle.src;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

/**
 *This thread runs every 10 seconds and determines if the
 * current user village is under attack.
 */
public class IsAttackedThread implements Runnable {



    IsAttackedThread() {
        //create the new thread
        Thread isAttacked = new Thread(this);

        //start the thread
        isAttacked.start();
    }


    public void run() {
        try {
            while(true) {
                Village.isAttacked();

                //piggy back off the isAttacked thread to update server time
                ServerTimePanel.setServerTime("Server time: " + WebAutomation.driver.findElement(By.xpath("//*[@id=\"serverTime\"]")).getText());

                //make the thread sleep for 10 secs
                Thread.sleep(10000);
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
