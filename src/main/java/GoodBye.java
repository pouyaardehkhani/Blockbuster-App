import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoodBye implements ActionListener {
    public void actionPerformed(ActionEvent e){
        int response1 = JOptionPane.showConfirmDialog(null, "Do You Really Want to Quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (response1 == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
