package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/10/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingConstructionPanel extends JPanel {

    private static JLabel assignmentOne;
    private static JLabel durationOne;
    private static JLabel completionOne;
    private static JButton cancelOneButton;

    private static JLabel assignmentTwo;
    private static JLabel durationTwo;
    private static JLabel completionTwo;
    private static JButton cancelTwoButton;

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

        assignmentOne = new JLabel ("No Construction");
        assignmentOne.setVerticalTextPosition(JLabel.TOP);
        assignmentOne.setHorizontalTextPosition(JLabel.RIGHT);
        assignmentOne.setBackground(bgColor);
        assignmentOne.setOpaque(true);
        assignmentOne.setBorder(null);

        durationOne = new JLabel ("N/A");
        durationOne.setVerticalTextPosition(JLabel.TOP);
        durationOne.setHorizontalTextPosition(JLabel.RIGHT);
        durationOne.setBackground(bgColor);
        durationOne.setOpaque(true);
        durationOne.setBorder(null);

        completionOne = new JLabel ("N/A");
        completionOne.setVerticalTextPosition(JLabel.TOP);
        completionOne.setHorizontalTextPosition(JLabel.RIGHT);
        completionOne.setBackground(bgColor);
        completionOne.setOpaque(true);
        completionOne.setBorder(null);

        cancelOneButton = new JButton("Cancel");


        assignmentTwo = new JLabel ("No Construction");
        assignmentTwo.setVerticalTextPosition(JLabel.TOP);
        assignmentTwo.setHorizontalTextPosition(JLabel.RIGHT);
        assignmentTwo.setBackground(bgColor);
        assignmentTwo.setOpaque(true);
        assignmentTwo.setBorder(null);

        durationTwo = new JLabel ("N/A");
        durationTwo.setVerticalTextPosition(JLabel.TOP);
        durationTwo.setHorizontalTextPosition(JLabel.RIGHT);
        durationTwo.setBackground(bgColor);
        durationTwo.setOpaque(true);
        durationTwo.setBorder(null);

        completionTwo = new JLabel ("N/A");
        completionTwo.setVerticalTextPosition(JLabel.TOP);
        completionTwo.setHorizontalTextPosition(JLabel.RIGHT);
        completionTwo.setBackground(bgColor);
        completionTwo.setOpaque(true);
        completionTwo.setBorder(null);

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
        add(assignmentOne, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(assignmentTwo, gc);


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
        add(durationOne, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(durationTwo, gc);

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
        add(completionOne, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(completionTwo, gc);

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
    public void setAssignmentOne(String label) {
        assignmentOne.setText(label);
    }

    public void setDurationOne(String label) {
        durationOne.setText(label);
    }

    public void setCompletionOne(String label) {
        completionOne.setText(label);
    }

    public void setCancelOneButton(String label) {
        cancelOneButton.setText(label);
    }

    public void setAssignmentTwo(String label) {
        assignmentTwo.setText(label);
    }

    public void setDurationTwo(String label) {
        durationTwo.setText(label);
    }

    public void setCompletionTwo(String label) {
        completionTwo.setText(label);
    }

    public static void setCancelTwoButton(String label) {
        cancelTwoButton.setText(label);
    }

    public static JLabel getCompletionTwo() {
        return completionTwo;
    }

    public static JLabel getDurationTwo() {
        return durationTwo;
    }

    public static JLabel getAssignmentTwo() {
        return assignmentTwo;
    }

    public static JLabel getCompletionOne() {
        return completionOne;
    }

    public static JLabel getDurationOne() {
        return durationOne;
    }

    public static JLabel getAssignmentOne() {
        return assignmentOne;
    }
}