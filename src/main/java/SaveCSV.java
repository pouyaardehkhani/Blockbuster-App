import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCSV implements ActionListener {

    private JFrame frame;

    SaveCSV(JFrame FRAME){
        this.frame=FRAME;
    }

    //saving a csv file gui
    public void actionPerformed(ActionEvent e){
        //making a saving pop up window
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save (dont forget to write a name and a format like: ali.csv)");
        int userSelection = fileChooser.showSaveDialog(frame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            //saving the selected path
            String path = fileToSave.getAbsolutePath();

            //creating a csv file
            try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
                writer.writeAll(Main.getData());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
