import java.util.*;

class Test{
    static class SortbyUnits implements Comparator<int []>
    {
        // Used for sorting in descending order
        public int compare(int []a, int []b)
        {
            return b[1] - a[1];
        }
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new SortbyUnits());

        int total = 0;

        for (int i = 0; i < boxTypes.length; i++){
            if (truckSize >= boxTypes[i][0]){
                total += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
            else{
                total += boxTypes[i][1] * truckSize;
                break;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int [][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize = 10;

//        int [][] boxTypes = {{1,3},{2,2},{3,1}};
//        int truckSize = 4;

        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}

