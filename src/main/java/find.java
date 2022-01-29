import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class find implements ActionListener {

    //search a specific field
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

        String massage="Enter One of the Items Below: \n";
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
        massage += "when your entering this enter it like this: Action,Adventure,Drama\n";

        String massage2 ="Enter the Search Data : \n";
        massage2 += "if your value in data set has enters so you must add \",\" Between the Values when your writing it otherwise you wont get the result of the search";
        massage2 += "like your data it's like this :\n";
        massage2 += "Action\n";
        massage2 += "Adventure\n";
        massage2 += "Drama\n";
        massage2 += "when your entering this enter it like this: Action,Adventure,Drama\n";

//        massage +="\nNote : If You Have More Than One Entry Do It With This Format (like : genre1,genre2)\n";
//        massage +="This Means You Search A Word In genre1 and genre2 column";

        String UserInput= JOptionPane.showInputDialog(massage);

        String SearchData=JOptionPane.showInputDialog(massage2);

        String[] strings=SearchData.split(",");

        String intel="";

        for (int i=0;i<strings.length;i++){
            intel += strings[i];
            if (i<strings.length-1){
                intel += "\n";
            }
        }

        String[] arg=new String[1]; arg[0]=UserInput;
        String[] search=new String[1]; search[0]=intel;

        List<Map<String,String>> result=new ArrayList<Map<String,String>>();
        result=SEARCH.search(arg,search);

//        String print="";
//        for (int i=0;i<result.size();i++){
//            print=result.toString();
//        }

        JFrame frame=new JFrame("result of search");
        List search_result=Table.jsonData_to_CsvData(result);
        JTable MyJTable=Table.table(search_result);
        frame.add(new JScrollPane(MyJTable));
        frame.setSize(700,600);
        frame.setVisible(true);

    }

}
