package com.gmail.ttkyle.src;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;


public class AddFarmsTable extends JPanel {
    private static JTable table;
    private static DefaultTableModel model;
    private static JPopupMenu farmMenu;
    private static String columnZero;
    private static String columnOne;
    private static String columnTwo;
    private static String columnThree;
    public static DefaultTableCellRenderer centerRenderer;


    public AddFarmsTable() {
        super(new GridLayout(1, 0));
        Dimension size = getPreferredSize();
        size.width = 600;
        size.height = 550;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);


        String[] columnNames = {"Target ID",
                "Village",
                "X",
                "Y",
                "Points",
                "Distance"};

        Object[][] data = {
        };

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 4) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };

        table = new JTable(model);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        TableCellRenderer renderer = new JComponentTableCellRenderer();

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");



        //Add the scroll pane to this panel.
        add(scrollPane);


        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(45);
        table.getColumnModel().getColumn(5).setPreferredWidth(40 );

        table.setAutoCreateColumnsFromModel(false);

        farmMenu = new JPopupMenu();

        MouseListener popupListener = new PopupListener();
        table.addMouseListener(popupListener);
        table.getTableHeader().addMouseListener(popupListener);
        JMenuItem menuItem = new JMenuItem("Add Target to Farm List");

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(AddFarmsTable.table.getValueAt( AddFarmsTable.table.getSelectedRow(), 0)
                        == null || AddFarmsTable.table.getValueAt( AddFarmsTable.table.getSelectedRow(), 0) == "") {
                    //do nothing
                }
                else {
                    try {
                        DataManipulation.getValueforCell();
                        DataManipulation.createFile("15000.txt");
                        DataManipulation.writeToVillage2("15000.txt");
                        try {
                            if((AddFarmsTroops.getSpearTextFieldFarmAdder().equals("")     &&
                                    AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")         &&
                                    AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")        &&
                                    AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")           &&
                                    AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("") &&
                                    AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")         &&
                                    AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")      &&
                                    AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")      &&
                                    AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")      &&
                                    AddFarmsTroops.getRamTextFieldFarmAdder().equals("") )          &&
                                    AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")) {
                                //do nothing
                            }
                            else {
                                AddVillagePanel.displayFarmVillagesAfterVillageAdd("15000.txt");
                                AddVillagePanel.filterCurrentFarms();
                                sortAllRowsBy(model, 5, true);
                                table.changeSelection(0, 0, false, false);
                            }
                        }
                        catch (IOException e1) {
                            //Do nothing
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e1) {
                        //Do nothing
                    }
                }
            }
        });
        farmMenu.add(menuItem);

        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
    }

    public static void sortAllRowsBy(DefaultTableModel model, int colIndex, boolean ascending) {
        Vector data = model.getDataVector();
        Collections.sort(data, new ColumnSorter(colIndex, ascending));
        model.fireTableStructureChanged();
    }

    public static JTable getTable() {
        return table;
    }

    public static void setTable(JTable table) {
        AddFarmsTable.table = table;
    }

    public static DefaultTableModel getModel() {
        return model;
    }

    public static void setModel(DefaultTableModel model) {
        AddFarmsTable.model = model;
    }

    public static JPopupMenu getFarmMenu() {
        return farmMenu;
    }

    public static void setFarmMenu(JPopupMenu farmMenu) {
        AddFarmsTable.farmMenu = farmMenu;
    }

    public static String getColumnZero() {
        return columnZero;
    }

    public static void setColumnZero(String columnZero) {
        AddFarmsTable.columnZero = columnZero;
    }

    public static String getColumnOne() {
        return columnOne;
    }

    public static void setColumnOne(String columnOne) {
        AddFarmsTable.columnOne = columnOne;
    }

    public static String getColumnTwo() {
        return columnTwo;
    }

    public static void setColumnTwo(String columnTwo) {
        AddFarmsTable.columnTwo = columnTwo;
    }

    public static String getColumnThree() {
        return columnThree;
    }

    public static void setColumnThree(String columnThree) {
        AddFarmsTable.columnThree = columnThree;
    }

    class JComponentTableCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (JComponent) value;
        }
    }

    static class DataManipulation {

        public static String getValueforCell() {
            int selectedRowIndex = table.getSelectedRow();
            columnZero = (String) table.getModel().getValueAt(selectedRowIndex, 0);
            columnOne = (String) table.getModel().getValueAt(selectedRowIndex, 1);
            columnTwo = (String) table.getModel().getValueAt(selectedRowIndex, 2);
            columnThree = (String) table.getModel().getValueAt(selectedRowIndex, 3);
            return columnZero + " " + columnOne + " " +columnTwo + " " + columnThree;
        }

        public static void writeFarms() {

            try {
                RandomAccessFile raf = new RandomAccessFile("currentFarmList.txt", "rw");
                if(AttackTable.getHaveDeletedFarm()) {
                    raf.skipBytes((int)raf.length()-2);
                    raf.writeBytes(columnZero + ",");
                    raf.close();
                }
                if(!AttackTable.getHaveDeletedFarm()) {
                    raf.skipBytes((int)raf.length());   //-2 works after delete
                    raf.writeBytes(columnZero + ",");
                    raf.close();
                }
                AttackTable.setHaveDeletedFarm(false);

                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("deleteBeforeExit.txt", "rw");
                    try {
                        randomAccessFile.seek(0);
                        randomAccessFile.writeBytes("false");
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    catch(NullPointerException e2) {
                        e2.printStackTrace();
                    }

                    randomAccessFile.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
            catch (IOException ex ) {
                ex.printStackTrace();
            }
        }

        public static void writeToVillage2(String village) {
            try {
                if((AddFarmsTroops.getSpearTextFieldFarmAdder().equals("")     &&
                        AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")         &&
                        AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")        &&
                        AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")           &&
                        AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("") &&
                        AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")         &&
                        AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")      &&
                        AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")      &&
                        AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")      &&
                        AddFarmsTroops.getRamTextFieldFarmAdder().equals("") )          &&
                        AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")) {
                    //do nothing
                }

                else {
                    FileWriter writer = new FileWriter(village, true);

                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(columnZero);
                    bufferedWriter.write(", ");
                    bufferedWriter.write(columnOne);
                    bufferedWriter.write(", ");
                    bufferedWriter.write(columnTwo);
                    bufferedWriter.write(", ");
                    bufferedWriter.write(columnThree);
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getSpearTextFieldFarmAdder().equals(""))
                    {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getSpearTextFieldFarmAdder());
                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getSwordTextFieldFarmAdder());

                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getArcherTextFieldFarmAdder());

                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getAxeTextFieldFarmAdder());
                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getMountedArcherTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getScoutTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getLightCalTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getHeavyCalTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getCatapultTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getRamTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getRamTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getNobleTextFieldFarmAdder());
                    }
                    bufferedWriter.write(", ");
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                    writer.close();
                    DataManipulation.writeFarms();
                }
            }
            catch (IOException e) {
            }
            finally {
            }
        }

        public static File createFile(String name) {
            File file = new File(name);
            return file;
        }
    }

    class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            showPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            showPopup(e);
        }

        private void showPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                farmMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    // This comparator is used to sort vectors of data
    public static class ColumnSorter implements Comparator {
        int colIndex;
        boolean ascending;
        ColumnSorter(int colIndex, boolean ascending) {
            this.colIndex = colIndex;
            this.ascending = ascending;
        }
        public int compare(Object a, Object b) {
            Vector v1 = (Vector)a;
            Vector v2 = (Vector)b;
            Object o1 = v1.get(colIndex);
            Object o2 = v2.get(colIndex);

            //Treat empty strains like nulls
            if (o1 instanceof String && ((String)o1).length() == 0) {
                o1 = null;
            }
            if (o2 instanceof String && ((String)o2).length() == 0) {
                o2 = null;
            }

            // Sort nulls so they appear last, regardless
            // of sort order
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            } else if (o1 instanceof Comparable) {
                if (ascending) {
                    return ((Comparable)o1).compareTo(o2);
                } else {
                    return ((Comparable)o2).compareTo(o1);
                }
            } else {
                if (ascending) {
                    return o1.toString().compareTo(o2.toString());
                } else {
                    return o2.toString().compareTo(o1.toString());
                }
            }
        }
    }
}