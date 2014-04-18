package com.gmail.ttkyle.src;

import com.gmail.ttkyle.src.AddFarmsOptionsPanel;
import com.gmail.ttkyle.src.AddFarmsTable;
import com.gmail.ttkyle.src.AttackTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.awt.geom.Point2D.distance;

/**
 * The GUI element that will eventually allow the user to add
 * the villages they currently own.
 *
 * This class is still a work in progress!!
 */
public class AddVillagePanel extends JPanel {

    public static int countCurrentFarms;
    public static String[] currentFarms;

    public AddVillagePanel() {

        //create size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 150;

        //set size of panel
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create the colors used for the background and border line
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the border color and title of the JPanel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Add New Village"));


        //labels to describe what to put in textfields
        final JLabel villageIDLabel = new JLabel("ID");
        final JLabel villageXCoord = new JLabel("X");
        final JLabel villageYCoord = new JLabel("Y");
        final JLabel villageNameLabel = new JLabel("Name");


        //JTextFields for various village elements that will add info
        //to a text file and will be loaded when GUI is created
        final JTextField villageIDTextField = new JTextField(12);
        final JTextField villageXCoordTextField = new JTextField(12);
        final JTextField villageYCoordTextField = new JTextField(12);
        final JTextField villageNameTextField = new JTextField(12);


        //a button that will eventually write the data from the textfields
        //to a textfile
        JButton addVillageButton = new JButton("     Add Village        ");
        addVillageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String villageID = villageIDTextField.getText();
                String villageX = villageXCoordTextField.getText();
                String villageY = villageYCoordTextField.getText();
                String villageName = villageNameTextField.getText();

                writeToVillage(createFile(villageID + ".txt"), villageID, villageName, villageX, villageY);

                try {
                    removeLineFromFile("15000.txt");
                }
                catch (IOException e1) {

                }
            }
        });

        //Set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx =  0;
        gc.gridy = 0;
        add(villageIDLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(villageXCoord, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(villageYCoord, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(villageNameLabel, gc);

        ////// Second column /////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(villageIDTextField, gc);

        gc.gridx= 1;
        gc.gridy=1;
        add(villageXCoordTextField, gc);

        gc.gridx= 1;
        gc.gridy=2;
        add(villageYCoordTextField, gc);

        gc.gridx= 1;
        gc.gridy=3;
        add(villageNameTextField, gc);

        ///final row
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .0;
        gc.weighty = .0;

        gc.gridx = 1;
        gc.gridy = 4;
        add(addVillageButton, gc);
    }

    static public File createFile(String name) {
        File file = new File(name);
        return file;
    }

    static public void writeToVillageList(File village, String ID) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(ID);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e) {
        }
    }

    static public void writeToVillage(File village,String villageID, String name,  String xCoord, String yCoord) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(villageID);
            bufferedWriter.write(", ");
            bufferedWriter.write(name);
            bufferedWriter.write(", ");
            bufferedWriter.write(xCoord);
            bufferedWriter.write(", ");
            bufferedWriter.write(yCoord);
            bufferedWriter.write(", ");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e) {
        }
    }

    static public void writeToVillage2(File village) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("lol");
            bufferedWriter.write(", ");
            bufferedWriter.write("500");
            bufferedWriter.write(", ");
            bufferedWriter.write("600");
            bufferedWriter.write(", ");
            bufferedWriter.write("10");
            bufferedWriter.write(", ");
            bufferedWriter.write("11 ");
            bufferedWriter.write(", ");
            bufferedWriter.write("12 ");
            bufferedWriter.write(", ");
            bufferedWriter.write("13");
            bufferedWriter.write(", ");
            bufferedWriter.write("14");
            bufferedWriter.write(", ");
            bufferedWriter.write("15");
            bufferedWriter.write(", ");
            bufferedWriter.write("16");
            bufferedWriter.write(", ");
            bufferedWriter.write("17");
            bufferedWriter.write(", ");
            bufferedWriter.write("18");
            bufferedWriter.write(", ");
            bufferedWriter.write("19");
            bufferedWriter.write(", ");
            bufferedWriter.write("20");
            bufferedWriter.write(", ");
            bufferedWriter.write("21");
            bufferedWriter.write(", ");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e) {
        }
    }

    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);

            for(int i = 0; i < lines.size() ; i++) {
                AttackTable.getTable().setValueAt(lines.get(i), 0, i);
            }
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void find(String fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        LineNumberReader ln = new LineNumberReader(fr);
        String s;

        int number = 0;
        int number2 = 0;
        int count = 0;
        String[] values = new String[1];

        if((s = ln.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                try {
                    values = s.split(",");
                }
                catch(NullPointerException e) {
                    //do nothing but load
                }

                if(i >= 0 && i < 15) {
                    AttackTable.getTable().setValueAt(values[i], 0, i);
                }
                if(i >= number && i < number2 ) {
                    AttackTable.getTable().setValueAt(values[i], count, i - (15 * count));
                }

                if(i > 0 && i % 15 == 14) {
                    number = number + 15;
                    number2 = number + 15;
                    count++;
                }
            }
        }
        fr.close();
        ln.close();
    }

    public static void populateArray(String fileName) throws IOException {

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new LineNumberReader(fr);
        String s = null;

        currentFarms = new String[1];

        while((s = br.readLine()) != null) {
            currentFarms = s.split(",");
            System.out.println("Farms = " + s);
        }
        fr.close();
        br.close();
    }

    public static void filterCurrentFarms() {
        // filterByPoints();
        double maxPointValue = 30000;
        if(AddFarmsOptionsPanel.pointField.getText().equals("0") || AddFarmsOptionsPanel.pointField.getText().equals("")) {
            maxPointValue = 30000;
            System.out.println(maxPointValue + " in if");
        }
        else {
            maxPointValue = Double.parseDouble(AddFarmsOptionsPanel.pointField.getText());
            System.out.println(maxPointValue + " in else");
        }

        try {
            populateArray("currentFarmList.txt");
        }
        catch (IOException e) {
        }
        try {
            for(String s : currentFarms) {
                for(int i = 0; i < AddFarmsTable.getTable().getRowCount(); i++) {
                    String value = AddFarmsTable.getTable().getValueAt(i,0).toString();

                    String pointValue = AddFarmsTable.getTable().getValueAt(i, 4).toString();
                    double newValue = Double.parseDouble(pointValue);

                    String villageName = AddFarmsTable.getTable().getValueAt(i, 1).toString();

                    if (AddFarmsOptionsPanel.barbOnly.isSelected()) {
                        if(s.equals(value) || newValue > maxPointValue || !villageName.equals("Barbarian+village")) {
                            System.out.println("removing rows " + i);
                            AddFarmsTable.getModel().removeRow(i);
                        }
                    }
                    else {
                        if(s.equals(value) || newValue > maxPointValue) {
                            System.out.println("removing row " + i);
                            AddFarmsTable.getModel().removeRow(i);
                        }
                    }
                }
            }
        }
        catch(NullPointerException e) {
            System.out.println("Null pointer filterCurrentFarms");
        }
        AddFarmsTable.getTable().changeSelection(0, 0, false, false);
    }

    public static void filterByPoints() {
        double maxPointValue = 30000;
        if(AddFarmsOptionsPanel.pointField.getText().equals("0") || AddFarmsOptionsPanel.pointField.getText().equals(null)) {
            maxPointValue = 30000;
            System.out.println(maxPointValue + " in if");
        }
        else {
            maxPointValue = Double.parseDouble(AddFarmsOptionsPanel.pointField.getText());
            System.out.println(maxPointValue + " in else");
        }
        try {
            for(int i = 0; i < AddFarmsTable.getTable().getRowCount(); i++) {
                String value = AddFarmsTable.getTable().getValueAt(i, 4).toString();

                double newValue = Double.parseDouble(value);
                System.out.println(newValue + " value as double");

                if(maxPointValue < newValue) {
                    //System.out.println(newValue);
                    System.out.println("row removed " + "Point value " + newValue + " row " + i);
                    AddFarmsTable.getModel().removeRow(i);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("numberFormatWrong");
        }
    }


    public static void deleteStringFromFile(String file, String delete)   {
        //File inFile = new File(file);
        try {
            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            for(String line; (line = br.readLine()) != null;) {
                line = line.replace(delete, "");
                pw.println(line);
                pw.flush();
            }

            br.close();
            pw.close();

            inFile.delete();
            tempFile.renameTo(inFile);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeLineFromFile(String file) throws IOException {

        int rowNumber = AttackTable.getTable().getSelectedRow();
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            pw = null;
            br = null;
            try {
                File inFile = new File(file);

                if (!inFile.isFile()) {
                    System.out.println("Parameter is not an existing file");
                    return;
                }

                File tempFile = new File(inFile.getAbsolutePath() + ".tmp");


                br = new BufferedReader(new FileReader(file));
                pw = new PrintWriter(new FileWriter(tempFile));

                String line = null;
                String lineToRemove = null;

                lineToRemove = AttackTable.getTable().getValueAt(rowNumber, 0) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 1) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 2) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 3) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 4) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 5) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 6) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 7) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 8) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 9) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 10) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 11) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 12) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 13) + "," +
                        AttackTable.getTable().getValueAt(rowNumber, 14) + ",";

                if (AttackTable.getTable().getValueAt(rowNumber, 0) != null && AttackTable.getTable().getValueAt(rowNumber, 0) != "") {
                    deleteStringFromFile("currentFarmList.txt", AttackTable.getTable().getValueAt(rowNumber, 0) + ",");
                    System.out.println("delete the ID from farmList" + " ");
                    System.out.println(AttackTable.getTable().getValueAt(rowNumber,0));
                }

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                AttackTable.getModel().removeRow(rowNumber);
                while ((line = br.readLine()) != null) {
                    if (!line.trim().equals(lineToRemove)) {
                        pw.println(line);
                        pw.flush();
                    }
                }
                br.close();
                pw.close();

                //Delete the original file
                if (!inFile.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }

                //Rename the new file to the filename the original file had.
                if (!tempFile.renameTo(inFile)) {
                    System.out.println("Could not rename file");
                }

            } finally {
                br.close();
                pw.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            br.close();
            pw.close();
            System.out.println("aaa FileNotFound");
        } catch (IOException ex) {
            ex.printStackTrace();
            br.close();
            pw.close();
            System.out.println("aaa IOexception");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("aaa Array oOB");
            br.close();
            pw.close();
        }
    }


    public static void findFarmsOG(String fileName, String list) throws IOException{
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String farms;
        int count = 0;
        String[] values = new String[1];

        FileReader fr2 = new FileReader(list);
        BufferedReader br2 = new LineNumberReader(fr2);
        String s;

        String[] farmList = new String[1000];


        while((farms = br.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                try {
                    values = farms.split(",");
                }
                catch(NullPointerException e) {
                    //do nothing but load
                }

                if((s = br2.readLine()) != null) {
                    for (int t = 0; t < farmList.length; t++) {
                        try {
                            farmList = s.split(",");
                        }
                        catch(NullPointerException e) {
                            //do nothing but load
                        }
                    }
                }

                if(i >= 0  && i < 1 ) {
                    if(distanceMethod(Double.parseDouble(values[2]), 346.0,
                            Double.parseDouble(values[3]), 243.0) <= 15 &&
                            distanceMethod(Double.parseDouble(values[2]), 346.0,
                                    Double.parseDouble(values[3]), 243.0) != 0.0 ) {

                        Double newValue = distanceMethod(Double.parseDouble(values[2]), 346.0,
                                Double.parseDouble(values[3]), 243.0);

                        //AddFarmsTargetJTable.addFarmsTable.setValueAt(values[0], count, 0);
                        // AddFarmsTargetJTable.addFarmsTable.setValueAt(values[1], count, 1);
                        // AddFarmsTargetJTable.addFarmsTable.setValueAt(values[2], count, 2);
                        // AddFarmsTargetJTable.addFarmsTable.setValueAt(values[3], count, 3);
                        // AddFarmsTargetJTable.addFarmsTable.setValueAt(newValue, count, 4);
                        count++;
                    }
                }
            }
        }
        fr.close();
        br.close();
    }

    public static void findFarms(String fileName) {
        int rows = AddFarmsTable.getModel().getRowCount();
        for(int i = rows - 1; i >=0; i--){
            AddFarmsTable.getModel().removeRow(i);
        }
        double distanceSearch = 15;
        if(AddFarmsOptionsPanel.distanceField.getText().equals("") || AddFarmsOptionsPanel.distanceField.getText().equals("0")) {
            distanceSearch = 15;
        }
        else {
            distanceSearch = Double.parseDouble(AddFarmsOptionsPanel.distanceField.getText());
        }
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String farms;
            int count = 0;

            String[] values;

            while((farms = br.readLine()) != null) {
                for (int i = 0; i <  1; i++) {
                    try {
                        values = farms.split(",");

                        if(distanceMethod(Double.parseDouble(values[2]), 500.0, Double.parseDouble(values[3]), 314.0) <= distanceSearch &&
                                distanceMethod(Double.parseDouble(values[2]), 500.0, Double.parseDouble(values[3]), 314.0) != 0.0
                                ) {
                            AddFarmsTable.getModel().addRow(new Object[]{});
                            Double newValue = distanceMethod(Double.parseDouble(values[2]), 500.0, Double.parseDouble(values[3]), 314.0);
                            AddFarmsTable.getTable().setValueAt(values[0], count, 0);
                            AddFarmsTable.getTable().setValueAt(values[1], count, 1);
                            AddFarmsTable.getTable().setValueAt(values[2], count, 2);
                            AddFarmsTable.getTable().setValueAt(values[3], count, 3);
                            AddFarmsTable.getTable().setValueAt(values[5], count, 4);
                            AddFarmsTable.getTable().setValueAt(newValue, count, 5);
                            count++;
                        }
                    }
                    catch(NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
            AddFarmsTable.getTable().changeSelection(0, 0, false, false);
        }
        catch(IOException e) {
            System.out.println("find Farms IO exception");

            //MainFrame.addFarmsDialog.setVisible(false);

        }
        AddVillagePanel.filterCurrentFarms();
        AddFarmsTable.sortAllRowsBy(AddFarmsTable.getModel(), 5, true);
    }

    public static void findFarmsAfterDelete(String fileName) {

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String farms;
            int count = 0;

            String[] values;

            while((farms = br.readLine()) != null) {
                for (int i = 0; i <  1; i++) {
                    try {
                        values = farms.split(",");

                        if(distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0) <= 15 &&
                                distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0) != 0.0
                                ) {
                            Double newValue = distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0);
                            AddFarmsTable.getTable().setValueAt(values[0], count, 0);
                            AddFarmsTable.getTable().setValueAt(values[1], count, 1);
                            AddFarmsTable.getTable().setValueAt(values[2], count, 2);
                            AddFarmsTable.getTable().setValueAt(values[3], count, 3);
                            AddFarmsTable.getTable().setValueAt(values[5], count, 4);
                            AddFarmsTable.getTable().setValueAt(newValue, count, 5);
                            count++;
                            //break
                        }
                    }
                    catch(NullPointerException e) {
                        //do nothing but load
                    }
                }
            }
            AddFarmsTable.getTable().changeSelection(0, 0, false, false);
        }
        catch(IOException e) {
            System.out.println("find Farms IO exception");
        }
        catch(ArrayIndexOutOfBoundsException e) {

        }
        AddFarmsTable.sortAllRowsBy(AddFarmsTable.getModel(), 5, true);
    }


    public static void displayFarmVillagesInitial(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        }
        catch(FileNotFoundException e) {
            createFile(fileName);
        }

        String currentFarms;
        countCurrentFarms = 0;

        String[] currentFarmArray = new String[1];

        try {
            while((currentFarms = br.readLine()) != null) {
                for (int i = 0; i < currentFarmArray.length; i++) {
                    try {
                        currentFarmArray = currentFarms.split(",");
                    }
                    catch(NullPointerException e) {
                        //do nothing but load
                    }
                    try {
                        if(i >= 0  && i < 1 ) {
                            AttackTable.getModel().addRow(new Object[] {});

                            AttackTable.getTable().setValueAt(currentFarmArray[0], countCurrentFarms, 0);
                            AttackTable.getTable().setValueAt(currentFarmArray[1], countCurrentFarms, 1);
                            AttackTable.getTable().setValueAt(currentFarmArray[2], countCurrentFarms, 2);
                            AttackTable.getTable().setValueAt(currentFarmArray[3], countCurrentFarms, 3);
                            AttackTable.getTable().setValueAt(currentFarmArray[4], countCurrentFarms, 4);
                            AttackTable.getTable().setValueAt(currentFarmArray[5], countCurrentFarms, 5);
                            AttackTable.getTable().setValueAt(currentFarmArray[6], countCurrentFarms, 6);
                            AttackTable.getTable().setValueAt(currentFarmArray[7], countCurrentFarms, 7);
                            AttackTable.getTable().setValueAt(currentFarmArray[8], countCurrentFarms, 8);
                            AttackTable.getTable().setValueAt(currentFarmArray[9], countCurrentFarms, 9);
                            AttackTable.getTable().setValueAt(currentFarmArray[10], countCurrentFarms, 10);
                            AttackTable.getTable().setValueAt(currentFarmArray[11], countCurrentFarms, 11);
                            AttackTable.getTable().setValueAt(currentFarmArray[12], countCurrentFarms, 12);
                            AttackTable.getTable().setValueAt(currentFarmArray[13], countCurrentFarms, 13);
                            AttackTable.getTable().setValueAt(currentFarmArray[14], countCurrentFarms, 14);
                            AttackTable.getTable().setValueAt(currentFarmArray[15], countCurrentFarms, 15);
                            countCurrentFarms++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
            fr.close();
            br.close();
        }
        catch(NullPointerException e) {
        }
    }

    public static void displayFarmVillagesAfterVillageAdd(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        }
        catch(FileNotFoundException e) {
            createFile(fileName);
        }

        String currentFarms;
        countCurrentFarms = 0;
        AttackTable.getModel().addRow(new Object[] {});
        String[] currentFarmArray = new String[1];

        try {
            while((currentFarms = br.readLine()) != null) {
                for (int i = 0; i < currentFarmArray.length; i++) {
                    try {
                        currentFarmArray = currentFarms.split(",");
                    }
                    catch(NullPointerException e) {
                        //do nothing but load
                    }
                    try {
                        if(i >= 0  && i < 1 ) {
                            AttackTable.getTable().setValueAt(currentFarmArray[0], countCurrentFarms, 0);
                            AttackTable.getTable().setValueAt(currentFarmArray[1], countCurrentFarms, 1);
                            AttackTable.getTable().setValueAt(currentFarmArray[2], countCurrentFarms, 2);
                            AttackTable.getTable().setValueAt(currentFarmArray[3], countCurrentFarms, 3);
                            AttackTable.getTable().setValueAt(currentFarmArray[4], countCurrentFarms, 4);
                            AttackTable.getTable().setValueAt(currentFarmArray[5], countCurrentFarms, 5);
                            AttackTable.getTable().setValueAt(currentFarmArray[6], countCurrentFarms, 6);
                            AttackTable.getTable().setValueAt(currentFarmArray[7], countCurrentFarms, 7);
                            AttackTable.getTable().setValueAt(currentFarmArray[8], countCurrentFarms, 8);
                            AttackTable.getTable().setValueAt(currentFarmArray[9], countCurrentFarms, 9);
                            AttackTable.getTable().setValueAt(currentFarmArray[10], countCurrentFarms, 10);
                            AttackTable.getTable().setValueAt(currentFarmArray[11], countCurrentFarms, 11);
                            AttackTable.getTable().setValueAt(currentFarmArray[12], countCurrentFarms, 12);
                            AttackTable.getTable().setValueAt(currentFarmArray[13], countCurrentFarms, 13);
                            AttackTable.getTable().setValueAt(currentFarmArray[14], countCurrentFarms, 14);
                            AttackTable.getTable().setValueAt(currentFarmArray[15], countCurrentFarms, 15);
                            countCurrentFarms++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        fr.close();
                        br.close();
                    }
                }
            }
            fr.close();
            br.close();
        }
        catch(NullPointerException e) {
        }
    }

    public static void displayFarmVillagesAfterDelete(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        }
        catch(FileNotFoundException e) {
            createFile(fileName);
        }

        String currentFarms;
        countCurrentFarms = 0;
        String[] currentFarmArray = new String[1];

        try {
            while((currentFarms = br.readLine()) != null) {
                for (int i = 0; i < currentFarmArray.length; i++) {
                    try {
                        currentFarmArray = currentFarms.split(",");
                    }
                    catch(NullPointerException e) {
                        //do nothing but load
                    }
                    try {
                        if(i >= 0  && i < 1 ) {
                            AttackTable.getTable().setValueAt(currentFarmArray[0], countCurrentFarms, 0);
                            AttackTable.getTable().setValueAt(currentFarmArray[1], countCurrentFarms, 1);
                            AttackTable.getTable().setValueAt(currentFarmArray[2], countCurrentFarms, 2);
                            AttackTable.getTable().setValueAt(currentFarmArray[3], countCurrentFarms, 3);
                            AttackTable.getTable().setValueAt(currentFarmArray[4], countCurrentFarms, 4);
                            AttackTable.getTable().setValueAt(currentFarmArray[5], countCurrentFarms, 5);
                            AttackTable.getTable().setValueAt(currentFarmArray[6], countCurrentFarms, 6);
                            AttackTable.getTable().setValueAt(currentFarmArray[7], countCurrentFarms, 7);
                            AttackTable.getTable().setValueAt(currentFarmArray[8], countCurrentFarms, 8);
                            AttackTable.getTable().setValueAt(currentFarmArray[9], countCurrentFarms, 9);
                            AttackTable.getTable().setValueAt(currentFarmArray[10], countCurrentFarms, 10);
                            AttackTable.getTable().setValueAt(currentFarmArray[11], countCurrentFarms, 11);
                            AttackTable.getTable().setValueAt(currentFarmArray[12], countCurrentFarms, 12);
                            AttackTable.getTable().setValueAt(currentFarmArray[13], countCurrentFarms, 13);
                            AttackTable.getTable().setValueAt(currentFarmArray[14], countCurrentFarms, 14);
                            AttackTable.getTable().setValueAt(currentFarmArray[15], countCurrentFarms, 15);
                            countCurrentFarms++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        fr.close();
                        br.close();
                    }
                }
            }
            fr.close();
            br.close();
        }
        catch(NullPointerException e) {
            System.out.println("null point After Delete");
        }
    }

    public static Double distanceMethod(Double x2, Double x1, Double y2, Double y1) {
        Double distance = Math.round(((distance(x1, y1, x2, y2)) * 100.0)) / 100.0;
        return distance;
    }
}


