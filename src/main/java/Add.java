import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Add implements ActionListener {

    private JTable jTable=null;

    //adding a row option
    public void actionPerformed(ActionEvent e){

        //setting the already save data formats for adding a row
        List<String[]> data=new ArrayList<String[]>();
        data=Main.getData();
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        list=Main.getList();
        Map<String,String> obj = new LinkedHashMap<>();

        //getting the instance table for adding a row
        this.jTable=Main.getjTable();

        //setting the needed add instances
        String[] columnnames=(String[])data.get(0);
        int length=columnnames.length;
        String[] column=new String[length];

        //user entry instances
        for (int i=0;i<length;i++){
            String entries="Enter the ";
            entries += columnnames[i];
            entries +=" : \n";
            entries += "if you want to add enters to data use \",\" between the values";

            column[i]=JOptionPane.showInputDialog(entries);

            String intel="";

            if (column[i].contains(",")){
                String[] strings=column[i].split(",");

                for (int j=0;j<strings.length;j++){
                    intel += strings[j];
                    if (j<strings.length-1){
                        intel += "\n";
                    }
                }

                column[i]=intel;
            }
            else {
                intel=column[i];
            }


            obj.put(columnnames[i],intel);
        }

        //adding to our data
        list.add(obj);
        Main.setList(list);
        data.add(column);
        Main.setData(data);

        //adding the row to table
        DefaultTableModel model=(DefaultTableModel) jTable.getModel();
        model.addRow(column);

        jTable.setModel(model);

    }
}
