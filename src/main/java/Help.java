import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String massage = "Welcome to Farabi Blockbuster Program!\n\n";
        massage +="-------------------------------------------------------------\n";
        massage +="For Opening a File Just Select Your CSV File\n";
        massage +="Use File Option to Upload Your File,Save and Exit the Program\n";
        massage +="When Your Saving a File Dont Forget Writing a File Name and a Format at the Chosen Directory (Like: a.json or a.csv)\n";
        massage +="If You Select Exit the Program Will Stop\n";
        massage +="-------------------------------------------------------------\n";
        massage +="When You Upload Your File Wait a Few Seconds Then Hit the File Option or Other Options of the Menu So That Your CSV file Load Onto the Screen \n";
        massage +="-------------------------------------------------------------\n";
        massage +="After Uploading Your File Use Option Menu For Cool Stuffs\n";
        massage +="For Editing a Cell You Must Have It's Row and Column Number\n";
        massage +="For Editing a Cell Just Remember You Cant Change the First Row\n";
        massage +="For Adding a Row Just Enter Your Value If You Want to Add Enters to Your Value Add a \",\" to Your Value\n";
        massage +="if Your Wanna Search a Value You Just Enter It In the Box But You Must Know If Your Data In the Dataset Have a Enter In It :\n";
        massage +="So You Must Add a \",\" Between the Values When Your Data Value Has Enters In It\n";
        massage +="JUST REMEMBER THAT YOU MUST ENTER EXACT LIKE THE VALUES IN THE DATASET\n";
        massage +="For Advance Search Use \"_\" Between the Items as an Separator Then Write Your Value as the Order You Just Enter\n";
        massage +="And Remember If Your Data Value Has Enters In It You Must Add a \",\" Between the Values\n";
        massage +="For Deleting a Row Just Enter It's Row Number\n";
        massage +="If You Dont Know How Many Rows You Have Use the (How Many Rows) in the (options) menu (use the second value in option)\n";
        massage +="-------------------------------------------------------------\n";
        massage +="FOR FURTHER KNOWLEDGE WE ADD THESE INFORMATION IN EVERY OPTION YOU CHOOSE\n";
        massage +="SO THAT YOU CAN REMEMBER WHAT TO DO IN EVERY PLACE OF THE PROGRAM\n";
        massage +="-------------------------------------------------------------\n";
        massage +="If You Want to Know About Us Use the ABOUT US Bottom in Help Option\n";
        massage +="-------------------------------------------------------------\n";
        massage +="Thanks For Your Time";

        JOptionPane.showMessageDialog(null,massage);
    }
}