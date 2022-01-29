import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//delete a row in table and data
public class delete implements ActionListener {

    private JTable jTable=null;

    public void actionPerformed(ActionEvent e){

        //getting the instance table for adding a row
        this.jTable=Main.getjTable();

        int row=Integer.parseInt(JOptionPane.showInputDialog("Enter the Row You Want to Remove (from 1 to n)(first row is 0 and not removable) : "));

        //must not be the first row
        if(row>0){

            List<String[]> data=new ArrayList<String[]>();
            data=Main.getData();
            List<Map<String,String>> list=new ArrayList<Map<String,String>>();
            list=Main.getList();

            data.remove(row);
            list.remove(row-1);

            Main.setData(data);
            Main.setList(list);

            //deleting a  row from the data and the table
            DefaultTableModel model=(DefaultTableModel) jTable.getModel();
            model.removeRow(row-1);

            jTable.setModel(model);
        }
        else {
            String massage="You Cant Delete the Column name row!!!!";
            JOptionPane.showMessageDialog(null,massage);
        }
    }
}
