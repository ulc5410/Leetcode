import java.util.*;

class Test{
    public static int numMatchingSubseq(String s, String[] words) {
        int matched = 0;
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

        for(int i = 0; i < s.length(); i++){
            if( !map.containsKey(s.charAt(i)) ){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                map.put(s.charAt(i), tmp);
            }
            else{
                map.get(s.charAt(i)).add(i);;
            }
        }

        for (int i = 0; i < words.length; i++){
            int word_pointer = 0;
            int s_pointer = -1;

            for (int j = 0; j < words[i].length(); j++){
                if (!map.containsKey(words[i].charAt(j))) break;
                else{
                    List<Integer> tmp = map.get(words[i].charAt(j));
                    int flag = 0;

                    for(int k = 0; k < tmp.size(); k++){
                        if (tmp.get(k) > s_pointer){
                            s_pointer = tmp.get(k);
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==0) break;
                }
                word_pointer += 1;
            }
            if(word_pointer == words[i].length()) matched += 1;
        }

        return matched;
    }

    public static void main(String[] args) {
//        String s = "abcde";
//        String [] words = {"a","bb","acd","ace"};

        String s = "dsahjpjauf";
        String [] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};

        System.out.println(numMatchingSubseq(s, words));
    }
}

