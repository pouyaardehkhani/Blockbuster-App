import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
//opencsv library for reading a cdv file and other tools
import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import java.io.FileReader;

public class Open implements ActionListener {

    private JFrame frame;

    Open(JFrame frame){
        this.frame=frame;
    }

    public void actionPerformed(ActionEvent e) {
        Component parent = (JComponent) e.getSource();
        //pop-up a file chooser that lets you select a file
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(parent);
        File file = chooser.getSelectedFile();

        Main.setFile(file);

        //having a list of all the data for other purposes
        try {

            CSVReader CSVFileReader;
            CSVFileReader = new CSVReader(new FileReader(file));
            List myEntries = CSVFileReader.readAll();
            Main.setData(myEntries);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        try {
//            Table.jsonFormat1(Main.getReadAll(),file);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

        //creat json format data
        try {
            Table.jsonFormat2(Main.getData());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //showing the table
        JTable MyJTable = Table.CSV_to_JTable();
        Table.showTabel(frame, MyJTable);

    }
}
