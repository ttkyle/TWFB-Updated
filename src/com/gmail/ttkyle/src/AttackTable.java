package com.gmail.ttkyle.src;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class AttackTable extends JPanel {

    private static JTable table;
    private static DefaultTableModel model;
    private static JPopupMenu popupMenu;
    private static boolean haveDeletedFarm;

    public AttackTable() {
        super(new GridLayout(1, 0));
        Dimension size = getPreferredSize();
        size.width = 790;
        size.height = 137;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        String[] columnNames = {"Target ID",
                "Village",
                "X",
                "Y",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "Currently"};

        Object[][] data = {
        };


        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            /*
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
            */
        };

        table = new JTable(model);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        TableCellRenderer renderer = new JComponentTableCellRenderer();

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.setDefaultRenderer(String.class, centerRenderer);

        //Add the scroll pane to this panel.
        add(scrollPane);


        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(15).setPreferredWidth(70);


        JLabel label0 = new JLabel(model.getColumnName(4), TroopsDetailPanel.getSpearIcon(), JLabel.CENTER);
        label0.setBorder(headerBorder);
        TableColumnModel columnModel = AttackTable.table.getColumnModel();
        TableColumn column0 = columnModel.getColumn(4);
        table.getColumnModel().getColumn(4).setPreferredWidth(30);
        column0.setHeaderRenderer(renderer);
        column0.setHeaderValue(label0);

        JLabel label1 = new JLabel(model.getColumnName(5), TroopsDetailPanel.getSwordIcon(), JLabel.CENTER);
        label1.setBorder(headerBorder);
        TableColumn column1 = columnModel.getColumn(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        column1.setHeaderRenderer(renderer);
        column1.setHeaderValue(label1);

        JLabel label2 = new JLabel(model.getColumnName(6), TroopsDetailPanel.getArcherIcon(), JLabel.CENTER);
        label2.setBorder(headerBorder);
        TableColumn column2 = columnModel.getColumn(6);
        table.getColumnModel().getColumn(6).setPreferredWidth(30);
        column2.setHeaderRenderer(renderer);
        column2.setHeaderValue(label2);

        JLabel label3 = new JLabel(model.getColumnName(7), TroopsDetailPanel.getAxeIcon(), JLabel.CENTER);
        label3.setBorder(headerBorder);
        TableColumn column3 = columnModel.getColumn(7);
        table.getColumnModel().getColumn(7).setPreferredWidth(30);
        column3.setHeaderRenderer(renderer);
        column3.setHeaderValue(label3);

        JLabel label4 = new JLabel(model.getColumnName(8), TroopsDetailPanel.getMountedArcherIcon(), JLabel.CENTER);
        label4.setBorder(headerBorder);
        TableColumn column4 = columnModel.getColumn(8);
        table.getColumnModel().getColumn(8).setPreferredWidth(30);
        column4.setHeaderRenderer(renderer);
        column4.setHeaderValue(label4);

        JLabel label5 = new JLabel(model.getColumnName(9), TroopsDetailPanel.getScoutIcon(), JLabel.CENTER);
        label5.setBorder(headerBorder);
        TableColumn column5 = columnModel.getColumn(9);
        table.getColumnModel().getColumn(9).setPreferredWidth(30);
        column5.setHeaderRenderer(renderer);
        column5.setHeaderValue(label5);

        JLabel label6 = new JLabel(model.getColumnName(10), TroopsDetailPanel.getLightCalIcon(), JLabel.CENTER);
        label6.setBorder(headerBorder);
        TableColumn column6 = columnModel.getColumn(10);
        table.getColumnModel().getColumn(10).setPreferredWidth(30);
        column6.setHeaderRenderer(renderer);
        column6.setHeaderValue(label6);

        JLabel label7 = new JLabel(model.getColumnName(11), TroopsDetailPanel.getHeavyCalIcon(), JLabel.CENTER);
        label7.setBorder(headerBorder);
        TableColumn column7 = columnModel.getColumn(11);
        table.getColumnModel().getColumn(11).setPreferredWidth(30);
        column7.setHeaderRenderer(renderer);
        column7.setHeaderValue(label7);

        JLabel label8 = new JLabel(model.getColumnName(12), TroopsDetailPanel.getCatapultIcon(), JLabel.CENTER);
        label8.setBorder(headerBorder);
        TableColumn column8 = columnModel.getColumn(12);
        table.getColumnModel().getColumn(12).setPreferredWidth(30);
        column8.setHeaderRenderer(renderer);
        column8.setHeaderValue(label8);

        JLabel label9 = new JLabel(model.getColumnName(13), TroopsDetailPanel.getRamIcon(), JLabel.CENTER);
        label9.setBorder(headerBorder);
        TableColumn column9 = columnModel.getColumn(13);
        table.getColumnModel().getColumn(13).setPreferredWidth(30);
        column9.setHeaderRenderer(renderer);
        column9.setHeaderValue(label9);

        JLabel label10 = new JLabel(model.getColumnName(14), TroopsDetailPanel.getNobleIcon(), JLabel.CENTER);
        label10.setBorder(headerBorder);
        TableColumn column10 = columnModel.getColumn(14);
        table.getColumnModel().getColumn(14).setPreferredWidth(30);
        column10.setHeaderRenderer(renderer);
        column10.setHeaderValue(label10);

        table.setAutoCreateColumnsFromModel(false);
        table.changeSelection(0, 0, false, false);

        popupMenu = new JPopupMenu();

        MouseListener popupListener = new PopupListener();
        table.addMouseListener(popupListener);
        table.getTableHeader().addMouseListener(popupListener);
        JMenuItem menuItem = new JMenuItem("Search for Farms");
        JMenuItem deleteItem = new JMenuItem("Delete Farm");


        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)   {
                AddVillagePanel.findFarms("village.txt");
                try {

                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile("deleteBeforeExit.txt", "rw");
                        try {
                            if((randomAccessFile.readLine().equals("truee"))) {
                                AttackTable.setHaveDeletedFarm(true);
                            }
                            else {
                                AttackTable.setHaveDeletedFarm(false);
                            }
                            System.out.println(AttackTable.getHaveDeletedFarm());
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

                    File f = new File("village.txt");
                    if(f.exists()) {
                        MainFrame.addFarmsDialog.setVisible(true);

                        AddFarmsTable.getTable().changeSelection(0, 0, false, false);
                        AddVillagePanel.filterCurrentFarms();
                    }
                    else {
                        JOptionPane.showMessageDialog(MainFrame.serverNotOnAccountDialog,
                                "VILLAGE DATA NOT DONE DOWNLOADING, IT WILL BE DONE IN ~20 SECONDS",
                                "NO VILLAGE DATA",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch(ArrayIndexOutOfBoundsException e1) {
                    System.out.println("add farm array oob excep");
                }
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getValueForCell();

                if(AttackTable.table.getValueAt(table.getSelectedRow(), 0) == null ||
                        AttackTable.table.getValueAt(table.getSelectedRow(), 0) == "") {
                    //do nothing
                }
                else {
                    haveDeletedFarm = true;
                    System.out.println(haveDeletedFarm);
                    System.out.println("after have deleted true");
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile("deleteBeforeExit.txt", "rw");
                        try {
                            randomAccessFile.seek(0);
                            randomAccessFile.writeBytes("true");
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
                    try {
                        AddVillagePanel.removeLineFromFile("15000.txt");
                    }
                    catch (IOException e1) {
                        System.out.println("exception at AttackTable - removeLineFromFile");
                    }
                    try {
                        AddVillagePanel.displayFarmVillagesAfterDelete("15000.txt");
                    }
                    catch (IOException e1) {
                        System.out.println("exception at AttackTable - displayFarmVillagesAfterDelete");
                    }
                    AddVillagePanel.findFarmsAfterDelete("village.txt");
                    AddVillagePanel.filterCurrentFarms();
                    AddFarmsTable.sortAllRowsBy(AddFarmsTable.getModel(), 5, true);
                    AddFarmsTable.getTable().changeSelection(0, 0, false, false);
                }
            }
        });
        popupMenu.add(menuItem);
        popupMenu.add(deleteItem);
    }

    public static void getValueForCell() {
        table.getSelectedRow();
        /*
        columnZero = (String) table.getModel().getValueAt(selectedRowIndex, 0);
        columnOne = (String) table.getModel().getValueAt(selectedRowIndex, 1);
        columnTwo = (String) table.getModel().getValueAt(selectedRowIndex, 2);
        columnThree = (String) table.getModel().getValueAt(selectedRowIndex, 3);
        return columnZero + " " + columnOne + " " +columnTwo + " " + columnThree;
        */
    }

    public static JTable getTable() {
        return table;
    }

    public static void setTable(JTable table) {
        AttackTable.table = table;
    }

    public static DefaultTableModel getModel() {
        return model;
    }

    public static void setModel(DefaultTableModel model) {
        AttackTable.model = model;
    }

    public static JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    public static void setPopupMenu(JPopupMenu popupMenu) {
        AttackTable.popupMenu = popupMenu;
    }

    public static boolean getHaveDeletedFarm() {
        return haveDeletedFarm;
    }

    public static void setHaveDeletedFarm(boolean haveDeletedFarm) {
        AttackTable.haveDeletedFarm = haveDeletedFarm;
    }

    class JComponentTableCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (JComponent) value;
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
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}