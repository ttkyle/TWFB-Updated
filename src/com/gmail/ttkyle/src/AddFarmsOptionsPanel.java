package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 10/29/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddFarmsOptionsPanel extends JPanel{

    public static JTextField distanceField;
    public static JTextField pointField;
    public static JCheckBox barbOnly;
    public AddFarmsOptionsPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 180;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //sets the border color and title
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Village Filter Options"));

        JLabel distanceLabel = new JLabel("Distance:");
        JLabel pointLabel = new JLabel("Points:");
        JButton searchButton = new JButton("Search");
        barbOnly = new JCheckBox("Only Barb");

        distanceField = new JTextField(10);
        pointField = new JTextField(10);

        distanceField.setText("0");
        pointField.setText("0");

        distanceField.setPreferredSize(new Dimension(50,25));
        pointField.setPreferredSize(new Dimension(50,25));
        searchButton.setPreferredSize(new Dimension(110,30));

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String points = pointField.getText();
                String distance = distanceField.getText();
                AddVillagePanel.findFarms("village.txt");
            }
        });

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx =  0;
        gc.gridy = 0;
        add(distanceLabel, new GridBagConstraints( 0, 0, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                 new Insets(0, -4, 0, 0 ), 0, 0 ) );

        gc.gridx = 0;
        gc.gridy = 1;
        add(pointLabel, new GridBagConstraints( 0, 1, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets( 0, -18, 0, 0 ), 0, 0 ) );

        ////// Second column /////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(distanceField,   new GridBagConstraints( 1, 0, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets( 0, 0, 0, 0 ), 0, 0 ) );

        gc.gridx = 1;
        gc.gridy = 1;
        add(pointField, new GridBagConstraints( 1, 1, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets( 0, 0, 0, 0 ), 0, 0 ) );

        ///final row
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .0;
        gc.weighty = .0;

        gc.gridx = 1;
        gc.gridy = 4;
        add(barbOnly, new GridBagConstraints( 1, 2, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets( 0, 0, 0, 0 ), 0, 0 ));

        gc.gridx = 1;
        gc.gridy = 3;
        add(searchButton, new GridBagConstraints( 1, 2, 1, 1, 1.0,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets( 0, 0, 75, 0 ), 0, 0 ));
    }
}
