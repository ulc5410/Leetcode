import java.util.Arrays;
// Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
public class Problem1465 {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
//        System.out.println(java.util.Arrays.toString(verticalCuts));
//        System.out.println(java.util.Arrays.toString(horizontalCuts));
        int newhorizon[] = new int[horizontalCuts.length+2];
        int newvertical[] = new int[verticalCuts.length+2];
// append 0s and h and w to
        for (int i = 1; i<newhorizon.length-1; i++){
            newhorizon[i] = horizontalCuts[i-1];
        }
        newhorizon[0] = 0;
        newhorizon[horizontalCuts.length+1] = h;

        for (int j = 1; j<newvertical.length-1; j++){
            newvertical[j] = verticalCuts[j-1];
        }
        newvertical[0] = 0;
        newvertical[verticalCuts.length+1] = w;

//        System.out.println(java.util.Arrays.toString(newvertical));
//        System.out.println(java.util.Arrays.toString(newhorizon));
// calculate diff
        for(int i = 0; i<newhorizon.length-1; i++){
            newhorizon[i] = newhorizon[i+1] - newhorizon[i];
        }
        for(int j = 0; j<newvertical.length-1; j++){
            newvertical[j] = newvertical[j+1] - newvertical[j];
        }
//        System.out.println(java.util.Arrays.toString(newvertical));
//        System.out.println(java.util.Arrays.toString(newhorizon));
//        find max diff
        int maxh=0, maxv=0;
        for (int i=0; i<newhorizon.length-1; i++) {
            if (newhorizon[i] > maxh) {
                maxh = newhorizon[i];   // new maximum
            }
        }
        for (int j=0; j<newvertical.length-1; j++) {
            if (newvertical[j] > maxv) {
                maxv = newvertical[j];   // new maximum
            }
        }
//        System.out.println(maxh+"\t"+maxv);
        return (int)((long)maxh * maxv % 1000000007);
    }

    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3, };
        int[] verticalCuts = {3};






        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
