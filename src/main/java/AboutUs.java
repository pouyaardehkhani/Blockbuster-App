import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String Massage="This Program is Written by Pouya Ardehkhani\n";
        Massage +="June,2021";

        JOptionPane.showMessageDialog(null,Massage);
    }
}
