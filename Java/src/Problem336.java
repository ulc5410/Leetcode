import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test{
    class Problem336 {
        public static List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Map<String, Integer> reverse = new HashMap<String, Integer>();
            for (int i = 0; i <words.length; i++){
                reverse.put(new StringBuilder(words[i]).reverse().toString(), i);
            }

            for (int i = 0; i <words.length; i++){
                for( int j =0; j< words.length; j++){
                    if((i!=j) && ((words[i]+words[j]).equals(new StringBuilder(words[i]+words[j]).reverse().toString()) )){
                        List<Integer> tmp =  new ArrayList<Integer>();
                        tmp.add(0,i);
                        tmp.add(1,j);
                        result.add(tmp);
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        String [] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = Problem336.palindromePairs(words);
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}

