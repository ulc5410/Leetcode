import java.util.*;

class Test{
    public static String customSortString(String order, String str) {
        char [] char_str = str.toCharArray();
        Map<Character, Integer> map_count = new HashMap<Character, Integer>();
        List<Integer> pos = new ArrayList<Integer>();
        Set<Character> keys = new HashSet<Character>();
        for(int i = 0; i < order.length(); i++){
            keys.add(order.charAt(i));
        }

        for(int i = 0; i < char_str.length; i++){
            if(keys.contains(char_str[i])){
                pos.add(i);
                map_count.put(char_str[i], map_count.getOrDefault(char_str[i], 0)+1);
            }
        }

        int pos_pointer = 0;
        for(int i = 0; i < order.length(); i++){
            for(int j = 0; j < map_count.getOrDefault(order.charAt(i), 0); j++){
                char_str[pos.get(pos_pointer)] = order.charAt(i);
                pos_pointer++;
            }
        }

        return new String(char_str);
    }

    public static void main(String[] args) {
        String order = "cba", str = "abcd";
        System.out.println(customSortString(order, str));
    }
}

