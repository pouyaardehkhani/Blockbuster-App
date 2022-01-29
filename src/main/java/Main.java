
//using java swing for gui
import javax.swing.*;
import java.awt.*;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {

    private static File file=null;
//    private static List<Object> readAll=null;
    private static List data=null;
    private static JTable jTable=null;
    public static List<Map<String,String>> list=new ArrayList<Map<String,String>>();

    public static void setList(List<Map<String, String>> list) {
        Main.list = list;
    }
//    public static void setReadAll(List<Object> readAll) {
//        Main.readAll = readAll;
//    }
    public static void setjTable(JTable jTable) {
        Main.jTable = jTable;
    }
    public static void setFile(File file) {
        Main.file = file;
    }
    public static void setData(List data) {
        Main.data = data;
    }

    public static List<Map<String, String>> getList() {
        return list;
    }
//    public static List<Object> getReadAll() {
//        return readAll;
//    }
    public static JTable getjTable() {
        return jTable;
    }
    public static List getData() {
        return data;
    }
    public static File getFile() {
        return file;
    }


    Main(){
        JFrame frame=new JFrame("Farabi Blockbuster");
        Container pane=frame.getContentPane();

        //--------------------creating a menu bar----------------------
        JMenuBar menuBar=new JMenuBar();
        JMenu filemenu=new JMenu("File");
        filemenu.setMnemonic('F');
        JMenu optionsmenu=new JMenu("Options");
        optionsmenu.setMnemonic('O');
        JMenu helpmenu=new JMenu("Help");
        helpmenu.setMnemonic('H');
        menuBar.add(filemenu);
        menuBar.add(optionsmenu);
        menuBar.add(helpmenu);
        frame.setJMenuBar(menuBar);
        //--------------------------------------------------------------

        //-----------------------file menu-------------------------------
        //add items to filemenu
        JMenuItem open=new JMenuItem("Open",'O');
        open.addActionListener(new Open(frame));
        filemenu.add(open);

        //first sub menu in filemenu
        JMenu save=new JMenu("Save");
        save.setMnemonic('S');

        //adding sub menu for save then add everything in the file menu
        JMenuItem saveCSV=new JMenuItem("Save CSV File",'F');
        JMenuItem saveJSON=new JMenuItem("Save Json File",'F');
        saveCSV.addActionListener(new SaveCSV(frame));
        saveJSON.addActionListener(new SaveJson(frame));
        save.add(saveCSV);
        save.add(saveJSON);
        filemenu.add(save);

        //add items to file menu
        JMenuItem exit=new JMenuItem("Exit",'E');
        exit.addActionListener(new GoodBye());
        filemenu.add(exit);
        //-----------------------------------------------------------------

        //----------------------------help menu-----------------------------
        JMenuItem help=new JMenuItem("Help",'H');
        help.addActionListener(new Help());
        helpmenu.add(help);

        JMenuItem aboutUs=new JMenuItem("About Us",'A');
        aboutUs.addActionListener(new AboutUs());
        helpmenu.add(aboutUs);
        //------------------------------------------------------------------

        //--------------------------option menu-----------------------------
        JMenuItem edit=new JMenuItem("Edit a Cell",'E');
        edit.addActionListener(new Edit());
        optionsmenu.add(edit);

        JMenuItem add =new JMenuItem("Add a Row(Film)",'A');
        add.addActionListener(new Add());
        optionsmenu.add(add);

        JMenuItem find =new JMenuItem("Search",'S');
        find.addActionListener(new find());
        optionsmenu.add(find);

        JMenuItem Advancesearch =new JMenuItem("Advance Search",'S');
        Advancesearch.addActionListener(new AdvanceFind());
        optionsmenu.add(Advancesearch);

        JMenuItem delete =new JMenuItem("Delete a Row",'D');
        delete.addActionListener(new delete());
        optionsmenu.add(delete);

        JMenuItem rownumber =new JMenuItem("How Many Rows",'R');
        rownumber.addActionListener(new row());
        optionsmenu.add(rownumber);
        //------------------------------------------------------------------

        //------------------packing everything uo---------------------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setVisible(true);
        //------------------------------------------------------------------

        //---------------some information about the program-----------------
        String massage="WELCOME BUT BEFORE YOU RUN THE PROGRAM PLEASE SEE OUR PROGRAMS HELP\n\n";
        massage +="Seeing Our Programs help Will Let You Know How This Programs Work\n";
        massage +="Help option -> Help";
        JOptionPane.showMessageDialog(null,massage);
        //------------------------------------------------------------------

    }

    public static void main(String[] args){
        new Main();
    }
}
