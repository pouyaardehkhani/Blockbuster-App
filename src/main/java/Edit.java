import javax.swing.*;
//import java.awt.*;
//import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Edit implements ActionListener {

    private JTable jTable=null;

    //editing a specific cell
    public void actionPerformed(ActionEvent e){
        //knowing a exact cell's dimensions
        int row=Integer.parseInt(JOptionPane.showInputDialog("Enter Cell Row Number (column names row is 1 (Not Editable) (From 2 to n)) :"))-1;
        int column=Integer.parseInt(JOptionPane.showInputDialog("Enter Cell Column Number (From 1 to n) :")) -1;

        //must not be the first row
        if(row>0){
            String edited=JOptionPane.showInputDialog("Enter Cell's New Record :");

            //setting our current data
            List data=Main.getData();

            String[] edit=(String[])data.get(row);
            edit[column]=edited;

            data.set(row,edit);

            //saving the changes
            Main.setData(data);

            //changing the displayed table on the window
            this.jTable=Main.getjTable();

            jTable.setValueAt(edited,row-1,column);
            Main.setjTable(jTable);


            //saving the changes
            try {
                Table.jsonFormat2(data);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        else {
            String massage="You Cant Change the Column name row and column!!!!";
            JOptionPane.showMessageDialog(null,massage);
        }

    }
}
