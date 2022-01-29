import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//we must know how many rows we have
public class row implements ActionListener {
    public void actionPerformed(ActionEvent e){
        List DATA=Main.getData();

        Integer total_rows= DATA.size();

        String massage="this data contain ";
        massage += total_rows.toString();
        massage += " rows\n";
        massage += "if you remove the column names row we have ";
        total_rows--;
        massage += total_rows.toString();
        massage += " rows which we use it for our options menu.";

        JOptionPane.showMessageDialog(null,massage);
    }
}
