//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.opencsv.CSVReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.awt.*;
import java.util.*;
//import java.io.File;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Table {

    //showing a table in the window display
    public static void showTabel(JFrame frame,JTable MyJTable){
        frame.add(new JScrollPane(MyJTable));
    }

    //convert a csv file to jtable for showing purposes
    public static JTable CSV_to_JTable() {
        Object[] columnnames;
        JTable MyJTable = null;

        List myEntries = Main.getData();
        columnnames = (String[]) myEntries.get(0);
        DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size() - 1);
        int rowcount = tableModel.getRowCount();
        for (int x = 0; x < rowcount + 1; x++) {
            int columnnumber = 0;
            // if x = 0 this is the first row...skip it... data used for columnnames
            if (x > 0) {
                for (String thiscellvalue : (String[]) myEntries.get(x)) {
                    tableModel.setValueAt(thiscellvalue, x - 1, columnnumber);
                    columnnumber++;
                }
            }
        }
        MyJTable = new JTable(tableModel){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        Main.setjTable(MyJTable);

        return MyJTable;
    }

    //creating a table of the json format data
    public static JTable table(List<String[]> myEntries){

        JTable MyJTable = null;

        String[] columnnames =myEntries.get(0);
        DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size() - 1);
        int rowcount = tableModel.getRowCount();
        for (int x = 0; x < rowcount + 1; x++) {
            int columnnumber = 0;
            // if x = 0 this is the first row...skip it... data used for columnnames
            if (x > 0) {
                for (String thiscellvalue : myEntries.get(x)) {
                    tableModel.setValueAt(thiscellvalue, x - 1, columnnumber);
                    columnnumber++;
                }
            }
        }
        MyJTable = new JTable(tableModel){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        return MyJTable;
    }

    //using jackson
//    public static void jsonFormat1(List<Object> readAll, File csv) throws Exception {
//        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
//        CsvMapper csvMapper = new CsvMapper();
//
//        // Read data from CSV file
//        Main.setReadAll(csvMapper.readerFor(Map.class).with(csvSchema).readValues(csv).readAll());
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Write JSON formated data to output.json file
//        mapper.writerWithDefaultPrettyPrinter().writeValue(json, readAll);
//
//        Main.setJson(json);
//    }

    //using json simple
    public static void jsonFormat2(List data) throws Exception{
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();

        Object[] columnnames = (String[]) data.get(0);

        for (int i=1;i< data.size();i++){
            Object[] columndatas = (String[]) data.get(i);
            Map<String,String> obj = new LinkedHashMap<String,String>();
            for (int j=0;j<columnnames.length;j++){
                obj.put((String)columnnames[j], (String)columndatas[j]);
            }
            list.add(obj);
        }

        Main.setList(list);

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        mapper.writeValue(System.out, list);
    }

    public static List jsonData_to_CsvData(List<Map<String,String>> data){

        List<String[]> stringList=new ArrayList<String[]>();

        List maindata=Main.getData();

        String[] entry= (String[]) maindata.get(0);
        Map<String,String> obj=new LinkedHashMap<String,String>();
        stringList.add(entry);

        for (int i=0;i<data.size();i++){
            String[] add=new String[entry.length];
            obj=data.get(i);
            for (int j=0;j< entry.length;j++){
                add[j]=obj.get(entry[j]);
            }
            stringList.add(add);
        }
        return stringList;
    }


}
