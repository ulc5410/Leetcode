import java.util.*;

class Test{
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map_s = new HashMap<Character,Integer>();
        Map<Character,Integer> map_t = new HashMap<Character,Integer>();
        int match;
        int counter_s = 0, counter_t = 0;

        for(int i = 0; i < s.length(); i++){
            if(map_s.containsKey(s.charAt(i))){
                match = map_s.get(s.charAt(i));
                if(match != map_t.getOrDefault(t.charAt(i), -1)){
                    return false;
                }
            }
            else{
                map_s.put(s.charAt(i), counter_s);
                counter_s++;
                if(map_t.containsKey(t.charAt(i))){
                    return false;
                }else{
                    map_t.put(t.charAt(i), counter_t);
                    counter_t++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper", t = "title";

        System.out.println(isIsomorphic(s, t));
    }
}

