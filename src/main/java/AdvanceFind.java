import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvanceFind implements ActionListener {
    public void actionPerformed(ActionEvent e){
        List data=Main.getData();
        String[] firstrow= (String[]) data.get(0);
        String[] row=(String[]) data.get(1);

        ArrayList<Integer> indexSPACE=new ArrayList<>();

        for (int i=0;i< row.length;i++){
            if (row[i].contains("\n")){
                indexSPACE.add(i);
            }
        }

        String massage="FOR SEARCH YOU HAVE TO WRITE IT EXACT LIKE THE DATA AND IT'S VALUES\n";
        massage +="AND FOR THE EACH VALUES WRITE IT IN THE SAME ORDER YOU HAVE IN YOUR DATASET\n\n";
        massage +="Enter Some of the Items Below: Don't Forget to Use \"_\" Between These Items \n";
        for (int i=0;i<firstrow.length;i++){
            if (i<firstrow.length-1){
                if (i==0){
                    massage += firstrow[0];
                    massage += "  ,  ";
                }
                else {
                    if (i%5==0){
                        massage +="\n";
                    }
                    massage += firstrow[i];
                    massage += "  ,  ";
                }
            }
            if (i== firstrow.length-1){
                massage += firstrow[i];
            }
        }
        massage += "\n\n";
        massage += "If You Select These : ";
        for (int select:indexSPACE){
            massage += " ( ";
            massage += firstrow[select];
            massage += " ) ";
        }
        massage += "if your entering a information for search for next line add \",\" to your original information\n";
        massage += "if your value in data set has enters so you must add \",\" Between the Values when your writing it otherwise you wont get the result of the search";
        massage += "like your data it's like this :\n";
        massage += "Action\n";
        massage += "Adventure\n";
        massage += "Drama\n";
        massage += "when your entering this enter it like this: Action,Adventure,Drama_another data value\n";

        String massage2="FOR SEARCH YOU HAVE TO WRITE IT EXACT LIKE THE DATA AND IT'S VALUES\n";
        massage2 +="AND FOR THE EACH VALUES WRITE IT IN THE SAME ORDER YOU HAVE IN YOUR DATASET\n\n";
        massage2 +="Enter the Search Data : for every Items you select use \"_\" as an separator \n";
        massage2 += "if your value in data set has enters so you must add \",\" Between the Values when your writing it otherwise you wont get the result of the search";
        massage2 += "like your data it's like this :\n";
        massage2 += "Action\n";
        massage2 += "Adventure\n";
        massage2 += "Drama\n";
        massage2 += "when your entering this enter it like this: Action,Adventure,Drama_PG for Example of another values between these Items (genres_rating)\n";

        String[] UserInput= JOptionPane.showInputDialog(massage).split("_");
        String[] UserData= JOptionPane.showInputDialog(massage2).split("_");

        String[] input=new String[UserData.length];

        for (int i=0;i<UserData.length;i++){

            String intel="";
            String[] strings=UserData[i].split(",");

            if (UserData[i].contains(",")){
                for (int j = 0; j <strings.length; j++){
                    intel += strings[j];
                    if (j <strings.length-1){
                        intel += "\n";
                    }
                }
                UserData[i]=intel;
            }
            else {
                intel=UserData[i];
            }

            input[i]=intel;
        }

        List<Map<String,String>> result=new ArrayList<Map<String,String>>();
        result=SEARCH.search(UserInput,input);

        JFrame frame=new JFrame("result of search");
        List search_result=Table.jsonData_to_CsvData(result);
        JTable MyJTable=Table.table(search_result);
        frame.add(new JScrollPane(MyJTable));
        frame.setSize(700,600);
        frame.setVisible(true);

    }
}
