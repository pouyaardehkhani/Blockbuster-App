import java.util.*;

//main search function
public class SEARCH {
    public static List search(String[] args,String[] search){
        //in this method we are saving the result of our search
        List<Map<String,String>> result=new ArrayList<Map<String,String>>();
        List<Map<String,String>> finalresult=new ArrayList<Map<String,String>>();
        int number_of_args = args.length;
        List<Map<String,String>> data=Main.getList();

        for (int j=0;j< data.size();j++){
            Map<String,String> obj=new LinkedHashMap<String,String>();
            obj=data.get(j);
            for (int i=0;i<number_of_args;i++){
                if (obj.get(args[i]).equals(search[i])){
                    result.add((Map<String, String>) data.get(j));
                }
            }
        }

        if (number_of_args>1){
            for (int i=0;i<result.size();i++){
                int equals=0;
                for (int j=1;j<result.size();j++){
                    if (result.get(i).equals(result.get(j))){
                        equals++;
                    }
                }
                if (equals==number_of_args){
                    finalresult.add(result.get(i));
                }
            }
            return finalresult;
        }

        return result;
    }
}
