package com.gmail.ttkyle.src;

/**
 TWFB (Tribalwars Farm Bot) will eventually be a full fledged bot.
 It will farm barbarian villages and players a like once it's fully done.
 It will have automated troop recruiting based on user desires.
 It will have automated building construction based on user desires.
 The goal is to have the bot highly configurable with a clean easy to use GUI.

 The bot will also offer increased speed in manually recruiting troops
 and constructing buildings by giving the user a GUI that displays
 all the relevant information.  This will provide a vast increase
 in efficiency, more so when your village count increases.
 */

import java.io.IOException;

public class Twfb {
    public static void main(String[] args) throws IOException, InterruptedException {
        AppGui twfbAppGui = new AppGui();
        twfbAppGui.drawUI();
    }
}