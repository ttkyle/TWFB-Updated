package com.gmail.ttkyle.src;

import javax.swing.*;
import java.io.IOException;

/**
 * The driver for the GUI
 */
public class AppGui {

    public MainFrame frame;
    public void drawUI() {

        //Draws the UI at 800x780 pixels and sets the title
        //of the frame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    frame = new MainFrame("TWFB - Tribal Wars Farm Bot");
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                frame.setSize(800, 825);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}