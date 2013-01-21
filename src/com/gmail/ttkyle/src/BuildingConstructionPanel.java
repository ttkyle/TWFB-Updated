package com.gmail.ttkyle.src;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import javax.swing.*;
import java.awt.*;

import static org.apache.commons.lang.StringUtils.substring;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/10/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingConstructionPanel extends JPanel {

    private static JLabel assignmentOneLabel;
    private static JLabel durationOneLabel;
    private static JLabel completionOneLabel;
    private static JButton cancelOneButton;

    private static JLabel assignmentTwoLabel;
    private static JLabel durationTwoLabel;
    private static JLabel completionTwoLabel;
    private static JButton cancelTwoButton;

    private String durationOne;
    private double totalOne = 0;
    private double totalOneOne;
    private double totalOneThird;
    private double totalOneFourth;
    private double totalOneSixth;
    private double totalOneSeventh;
    private double totalOneSecond;
    private double totalOneEighth;
    private double totalOneFifth;


    private String durationTwo;
    private double totalTwo = 0;
    private double totalTwoOne;
    private double totalTwoThird;
    private double totalTwoFourth;
    private double totalTwoSixth;
    private double totalTwoSeventh;
    private double totalTwoSecond;
    private double totalTwoEighth;
    private double totalTwoFifth;

    private String buildingNameOne;
    private String completionOne;
    private String buildingNameTwo;
    private String completionTwo;

    public BuildingConstructionPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 600;
        size.height = 100;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        //create the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //set the border color and title of the panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Tribal Wars Building Queue"));

        //swing components
        JLabel constructionAssignment;
        JLabel durationTime;
        JLabel completionTime;
        JLabel cancel;



        //////////Labels to mimic Tribalwars build queue////////////
        constructionAssignment = new JLabel ("Construction assignment");
        constructionAssignment.setVerticalTextPosition(JLabel.TOP);
        constructionAssignment.setHorizontalTextPosition(JLabel.RIGHT);
        constructionAssignment.setBackground(bgColor);
        constructionAssignment.setOpaque(true);
        constructionAssignment.setBorder(null);

        durationTime = new JLabel ("Duration");
        durationTime.setVerticalTextPosition(JLabel.TOP);
        durationTime.setHorizontalTextPosition(JLabel.RIGHT);
        durationTime.setBackground(bgColor);
        durationTime.setOpaque(true);
        durationTime.setBorder(null);

        completionTime = new JLabel ("Completion");
        completionTime.setVerticalTextPosition(JLabel.TOP);
        completionTime.setHorizontalTextPosition(JLabel.RIGHT);
        completionTime.setBackground(bgColor);
        completionTime.setOpaque(true);
        completionTime.setBorder(null);

        cancel = new JLabel ("Cancellation");
        cancel.setVerticalTextPosition(JLabel.TOP);
        cancel.setHorizontalTextPosition(JLabel.RIGHT);
        cancel.setBackground(bgColor);
        cancel.setOpaque(true);
        cancel.setBorder(null);

        assignmentOneLabel = new JLabel ("No Construction");
        assignmentOneLabel.setVerticalTextPosition(JLabel.TOP);
        assignmentOneLabel.setHorizontalTextPosition(JLabel.RIGHT);
        assignmentOneLabel.setBackground(bgColor);
        assignmentOneLabel.setOpaque(true);
        assignmentOneLabel.setBorder(null);

        durationOneLabel = new JLabel ("N/A");
        durationOneLabel.setVerticalTextPosition(JLabel.TOP);
        durationOneLabel.setHorizontalTextPosition(JLabel.RIGHT);
        durationOneLabel.setBackground(bgColor);
        durationOneLabel.setOpaque(true);
        durationOneLabel.setBorder(null);

        completionOneLabel = new JLabel ("N/A");
        completionOneLabel.setVerticalTextPosition(JLabel.TOP);
        completionOneLabel.setHorizontalTextPosition(JLabel.RIGHT);
        completionOneLabel.setBackground(bgColor);
        completionOneLabel.setOpaque(true);
        completionOneLabel.setBorder(null);

        cancelOneButton = new JButton("Cancel");


        assignmentTwoLabel = new JLabel ("No Construction");
        assignmentTwoLabel.setVerticalTextPosition(JLabel.TOP);
        assignmentTwoLabel.setHorizontalTextPosition(JLabel.RIGHT);
        assignmentTwoLabel.setBackground(bgColor);
        assignmentTwoLabel.setOpaque(true);
        assignmentTwoLabel.setBorder(null);

        durationTwoLabel = new JLabel ("N/A");
        durationTwoLabel.setVerticalTextPosition(JLabel.TOP);
        durationTwoLabel.setHorizontalTextPosition(JLabel.RIGHT);
        durationTwoLabel.setBackground(bgColor);
        durationTwoLabel.setOpaque(true);
        durationTwoLabel.setBorder(null);

        completionTwoLabel = new JLabel ("N/A");
        completionTwoLabel.setVerticalTextPosition(JLabel.TOP);
        completionTwoLabel.setHorizontalTextPosition(JLabel.RIGHT);
        completionTwoLabel.setBackground(bgColor);
        completionTwoLabel.setOpaque(true);
        completionTwoLabel.setBorder(null);

        cancelTwoButton = new JButton("Cancel");


        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;


        gc.gridx =  0;
        gc.gridy = 0;
        add(constructionAssignment, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(assignmentOneLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(assignmentTwoLabel, gc);


        //////////Second Column//////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx =  1;
        gc.gridy = 0;
        add(durationTime, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(durationOneLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(durationTwoLabel, gc);

        //////////Third Column//////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx =  2;
        gc.gridy = 0;
        add(completionTime, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(completionOneLabel, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(completionTwoLabel, gc);

        //////////Fourth Column//////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx =  3;
        gc.gridy = 0;
        add(cancel, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        add(cancelOneButton, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        add(cancelTwoButton, gc);





       //*[@id="buildqueue"]/tr[2]/td[1]
       //*[@id="buildqueue"]/tr[2]/td[2]/span
       //*[@id="buildqueue"]/tr[2]/td[3]
       //*[@id="buildqueue"]/tr[2]/td[4]/a    //*[@id="buildqueue"]/tr[2]/td[4]
       //*[@id="confirmation-box"]/div/button[1]
   }


    //////////////setters for labels////////////////
    public static void setAssignmentOneLabel(String label) {
        assignmentOneLabel.setText(label);
    }

    public static void setDurationOneLabel(String label) {
        durationOneLabel.setText(label);
    }

    public static void setCompletionOneLabel(String label) {
        completionOneLabel.setText(label);
    }

    public static void setCancelOneButton(String label) {
        cancelOneButton.setText(label);
    }

    public static void setAssignmentTwoLabel(String label) {
        assignmentTwoLabel.setText(label);
    }

    public static void setDurationTwoLabel(String label) {
        durationTwoLabel.setText(label);
    }

    public static void setCompletionTwoLabel(String label) {
        completionTwoLabel.setText(label);
    }

    public static void setCancelTwoButton(String label) {
        cancelTwoButton.setText(label);
    }

    public static JLabel getCompletionTwoLabel() {
        return completionTwoLabel;
    }

    public static JLabel getDurationTwoLabel() {
        return durationTwoLabel;
    }

    public static JLabel getAssignmentTwoLabel() {
        return assignmentTwoLabel;
    }

    public static JLabel getCompletionOneLabel() {
        return completionOneLabel;
    }

    public static JLabel getDurationOneLabel() {
        return durationOneLabel;
    }

    public static JLabel getAssignmentOneLabel() {
        return assignmentOneLabel;
    }

    //update build queue one with building name
    public void constructionOne() {

        try {
            buildingNameOne = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[1]")).getText();
            BuildingConstructionPanel.setAssignmentOneLabel(buildingNameOne);

            durationOne = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[2]/span")).getText();
            BuildingConstructionPanel.setDurationOneLabel(durationOne);

            completionOne = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[3]")).getText();
            BuildingConstructionPanel.setCompletionOneLabel(completionOne);
        }
        catch(NoSuchElementException e) {
        }
    }

    public void constructionOneTimer() throws InterruptedException {

        int hours = (int) (totalOne / (60 * 60 * 1000));
        int minutes = (int) ((totalOne / (60 * 1000)) % 60);
        int seconds = (int) ((totalOne / 1000) % 60);

        if(seconds > 10 && minutes > 10) {
            BuildingConstructionPanel.setDurationOneLabel(hours + ":" + minutes + ":" + seconds);
        }
        if(seconds < 10) {
            BuildingConstructionPanel.setDurationOneLabel(hours + ":" + minutes + ":" + "0" + seconds);
        }
        if(minutes < 10) {
            BuildingConstructionPanel.setDurationOneLabel(hours + ":" + "0" + minutes + ":" + seconds);
        }
        if(seconds < 10 && minutes < 10) {
            BuildingConstructionPanel.setDurationOneLabel(hours + ":" + "0" + minutes + ":" + "0" + seconds);
        }

        totalOne = totalOne - 10000;
    }

    public  void constructionOneGetTime() {
        try {
            if(substring(durationOne, 1, 2).equals(":")) {
                if(totalOneOne == 0) {
                    totalOneOne = 0;
                }
                else {
                    totalOneOne = totalOneOne * 3600000;
                }

                if(totalOneThird == 0) {
                    totalOneThird = 0;
                }
                else {
                    totalOneThird *= 600000;
                }

                if(totalOneFourth == 0) {
                    totalOneFourth = 0;
                }
                else {
                    totalOneFourth *= 60000;
                }

                if(totalOneSixth == 0) {
                    totalOneSixth = 0;
                }
                else {
                    totalOneSixth *= 10000;
                }

                if(totalOneSeventh == 0) {
                    totalOneSeventh = 0;
                }
                else {
                    totalOneSeventh *= 1000;
                }
                totalOne = totalOneOne +  totalOneThird + totalOneFourth + totalOneSixth + totalOneSeventh;
            }
            else {

            }
        }
        catch(NullPointerException e) {
        }
    }

    public  void constructionOneGetNumbers() {
        try {
            totalOneOne = Integer.parseInt(substring(durationOne, 0, 1));
            // String second =  :
            totalOneThird = Integer.parseInt(substring(durationOne, 2, 3));
            totalOneFourth = Integer.parseInt(substring(durationOne, 3, 4));
            //int fifth =  :
            totalOneSixth = Integer.parseInt(substring(durationOne, 5, 6));
            totalOneSeventh = Integer.parseInt(substring(durationOne, 6, 7));
        }
        catch(NumberFormatException e) {
        }
        //int eight =  would be last number
    }


    //update build queue two with building name
    public  void constructionTwo() {

        try {
            buildingNameTwo = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[1]")).getText();
            BuildingConstructionPanel.setAssignmentTwoLabel(buildingNameTwo);

            durationTwo = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[2]/span")).getText();
            BuildingConstructionPanel.setDurationTwoLabel(durationTwo);

            completionTwo = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[3]")).getText();
            BuildingConstructionPanel.setCompletionTwoLabel(completionTwo);
        }
        catch(NoSuchElementException e) {
        }
    }

    public  void constructionTwoGetTime() {
        try {
            if(substring(durationTwo, 1, 2).equals(":")) {
                if(totalTwoOne == 0) {
                    totalTwoOne = 0;
                }
                else {
                    totalTwoOne = totalTwoOne * 3600000;
                }

                if(totalTwoThird == 0) {
                    totalTwoThird = 0;
                }
                else {
                    totalTwoThird *= 600000;
                }

                if(totalTwoFourth == 0) {
                    totalTwoFourth = 0;
                }
                else {
                    totalTwoFourth *= 60000;
                }

                if(totalTwoSixth == 0) {
                    totalTwoSixth = 0;
                }
                else {
                    totalTwoSixth *= 10000;
                }

                if(totalTwoSeventh == 0) {
                    totalTwoSeventh = 0;
                }
                else {
                    totalTwoSeventh *= 1000;
                }
                totalTwo = totalTwoOne +  totalTwoThird + totalTwoFourth + totalTwoSixth + totalTwoSeventh;
            }
            else {
            }
        }
        catch(NullPointerException e) {
        }
    }

    public  void ConstructionTwoTimer() {

        int hours = (int) (totalTwo / (60 * 60 * 1000));
        int minutes = (int) ((totalTwo / (60 * 1000)) % 60);
        int seconds = (int) ((totalTwo / 1000) % 60);

        if(seconds > 10 && minutes > 10) {
            BuildingConstructionPanel.setDurationTwoLabel(hours + ":" + minutes + ":" + seconds);
        }
        if(seconds < 10) {
            BuildingConstructionPanel.setDurationTwoLabel(hours + ":" + minutes + ":" + "0" + seconds);
        }
        if(minutes < 10) {
            BuildingConstructionPanel.setDurationTwoLabel(hours + ":" + "0" + minutes + ":" + seconds);
        }
        if(seconds < 10 && minutes < 10) {
            BuildingConstructionPanel.setDurationTwoLabel(hours + ":" + "0" + minutes + ":" + "0" + seconds);
        }
    }

    public  void constructionTwoGetNumbers() {
        try {
            totalTwoOne = Integer.parseInt(substring(durationTwo, 0, 1));
            // String second =  :
            totalTwoThird = Integer.parseInt(substring(durationTwo, 2, 3));
            totalTwoFourth = Integer.parseInt(substring(durationTwo, 3, 4));
            //int fifth =  :
            totalTwoSixth = Integer.parseInt(substring(durationTwo, 5, 6));
            totalTwoSeventh = Integer.parseInt(substring(durationTwo, 6, 7));
        }
        catch(NumberFormatException e) {
        }
        //int eight =  would be last number
    }

    public String getDurationOne() {
        return durationOne;
    }

    public void setDurationOne(String newString) {
        durationOne = newString;
    }

    public double getTotalOne() {
        return totalOne;
    }

    public void setTotalOne(double newNumber) {
        totalOne = newNumber;
    }

    public double getTotalOneOne() {
        return totalOneOne;
    }

    public void setTotalOneOne(double newNumber) {
        totalOneOne = newNumber;
    }

    public double getTotalOneThird() {
        return totalOneThird;
    }

    public void setTotalOneThird(double newNumber) {
        totalOneThird = newNumber;
    }

    public double getTotalOneFourth() {
        return totalOneFourth;
    }

    public void setTotalOneFourth(double newNumber) {
        totalOneFourth = newNumber;
    }

    public double getTotalOneSixth() {
        return totalOneSixth;
    }

    public void setTotalOneSixth(double newNumber) {
        totalOneSixth = newNumber;
    }

    public double getTotalOneSeventh() {
        return totalOneSeventh;
    }

    public void setTotalOneSeventh(double newNumber) {
        totalOneSeventh = newNumber;
    }

    public double getTotalOneSecond() {
        return totalOneSecond;
    }

    public void setTotalOneSecond(double newNumber) {
        totalOneSecond = newNumber;
    }

    public double getTotalOneEighth() {
        return totalOneEighth;
    }

    public void setTotalOneEighth(double newNumber) {
        totalOneEighth = newNumber;
    }

    public String getDurationTwo() {
        return durationTwo;
    }

    public void setDurationTwo(String newString) {
        durationTwo = newString;
    }

    public double getTotalTwo() {
        return totalTwo;
    }

    public void setTotalTwo(double newNumber) {
        totalTwo = newNumber;
    }

    public double getTotalTwoOne() {
        return totalTwoOne;
    }

    public void setTotalTwoOne(double newNumber) {
        totalTwoOne = newNumber;
    }

    public double getTotalTwoThird() {
        return totalTwoThird;
    }

    public void setTotalTwoThird(double newNumber) {
        totalTwoThird = newNumber;
    }

    public double getTotalTwoFourth() {
        return totalTwoFourth;
    }

    public void setTotalTwoFourth(double newNumber) {
        totalTwoFourth = newNumber;
    }

    public double getTotalTwoSixth() {
        return totalTwoSixth;
    }

    public void setTotalTwoSixth(double newNumber) {
        totalTwoSixth = newNumber;
    }

    public double getTotalTwoSeventh() {
        return totalTwoSeventh;
    }

    public void setTotalTwoSeventh(double newNumber) {
        totalTwoSeventh = newNumber;
    }

    public double getTotalTwoSecond() {
        return totalTwoSecond;
    }

    public void setTotalTwoSecond(double newNumber) {
        totalTwoSecond = newNumber;
    }

    public double getTotalTwoEighth() {
        return totalTwoEighth;
    }

    public void setTotalTwoEighth(double newNumber) {
        totalTwoEighth = newNumber;
    }

    public double getTotalTwoFifth() {
        return totalTwoFifth;
    }

    public void setTotalTwoFifth(double newNumber) {
        totalTwoFifth = newNumber;
    }

    public double getTotalOneFifth() {
        return totalOneFifth;
    }

    public void setTotalOneFifth(double newNumber) {
        totalOneFifth = newNumber;
    }

    public String getBuildingNameOne() {
        return buildingNameOne;
    }

    public void setBuildingNameOne(String newString) {
        buildingNameOne = newString;
    }

    public String getCompletionOne() {
        return completionOne;
    }

    public void setCompletionOne(String newString) {
        completionOne = newString;
    }

    public String getBuildingNameTwo() {
        return buildingNameTwo;
    }

    public void setBuildingNameTwo(String newString) {
        buildingNameTwo = newString;
    }

    public String getCompletionTwo() {
        return completionTwo;
    }

    public void setCompletionTwo(String newString) {
        completionTwo = newString;
    }

}
