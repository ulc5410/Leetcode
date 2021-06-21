import java.util.*;

class Test{
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();

        pascal.add(new ArrayList<>(0));
        pascal.get(0).add(1);

        for (int i = 1; i<numRows; i++){ //rows
            pascal.add(new ArrayList<>(0));
            pascal.get(i).add(1);

            for(int j = 1; j < i; j++){
                int num;
                num = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j) ;
                pascal.get(i).add(num);
            }
            pascal.get(i).add(1);
        }

        return pascal;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}

