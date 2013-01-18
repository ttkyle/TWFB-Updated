/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 10/29/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
package com.gmail.ttkyle.src;

import javax.swing.*;
import java.awt.*;

public class serverNotOnAccountDialog extends JDialog {

    public serverNotOnAccountDialog() {
        setModal(true);

        setLocation(400, 0);
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 200;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        //create the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the border color and title of the panel
        setTitle("NO VILLAGE IN THIS WORLD");

        /*
        //Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel text = new JLabel("THERE IS NO VILLAGE CREATED IN THIS WORLD!!!!!");
        JButton okButton = new JButton("Ok");

        Dimension okDimension = new Dimension(2,20);
        //okButton.setPreferredSize(okDimension);
        okButton.setMaximumSize(okDimension);


        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.gridx =  0;
        gc.gridy = 0;
        add(text, gc);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.gridx =  0;
        gc.gridy = 1;
        add(okButton, gc);

        setVisible(true);

        */

    }
}