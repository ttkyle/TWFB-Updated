package com.gmail.ttkyle.src;

import org.openqa.selenium.NoSuchElementException;

/**
 * This is the troop thread that continuously updates the troop count
 */
public class TroopThread implements Runnable {

    Thread troopThread;

    TroopThread() {
        //create a new thread
        troopThread = new Thread(this);

        //start the new thread
        troopThread.start();
    }


    public void run() {
        try {
            while(true) {
                Village.updateTroops();
                Thread.sleep(30000);
            }
        }
        catch (InterruptedException e) {
        }
        catch (NoSuchElementException e) {
        }
    }
}