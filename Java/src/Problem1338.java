import java.util.*;

class Test{

    public static int minSetSize(int[] arr) {
        //counts
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        //sort counts
        List<Integer> values = new ArrayList<Integer>();
        int k = 0;
        Set s = map.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();
            values.add((Integer) m.getValue());
            k += 1;
        }
        Collections.sort(values,Collections.reverseOrder());
        //find min removal to make half or less
        int target_length = arr.length/2;
        int count = 0, a = 0;
        while(count<target_length){
            count += values.get(a);
            a++;
        }
        return a;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(minSetSize(arr));
    }
}

