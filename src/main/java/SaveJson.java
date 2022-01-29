//using jackson library for building a json file via objectmapper and a list of maps
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveJson implements ActionListener {

    private JFrame frame;

    SaveJson(JFrame FRAME){
        this.frame=FRAME;
    }

    //saving a .json file gui
    public void actionPerformed(ActionEvent e){
        //making a saving pop up window
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save (dont forget to write a name and a format like: ali.json)");
        int userSelection = fileChooser.showSaveDialog(frame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            //getting the selected path
            String path=fileToSave.getAbsolutePath();

            File result=new File(path);

            //making a json file
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                mapper.writeValue(result,Main.getList());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
