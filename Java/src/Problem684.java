import java.util.*;

public class Test{

    static int [] parent = new int [1001];


    static int find_parent(int i){
        if(parent[i] == -1) return i;
        else return find_parent(parent[i]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int [] ans = new int [2];
        //minimum spanning tree
        //disjoint set
        Arrays.fill(parent, -1);

        for (int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            if(find_parent(x) == find_parent(y)){
                ans = edges[i];
            }
            else if ((parent[x] == -1) && (parent[y] != -1) ){
                parent[x] = find_parent(y);
            }
            else if ((parent[x] != -1) && (parent[y] == -1) ){
                parent[y] = find_parent(x);
            }
            else if ((parent[x] == -1) && (parent[y] == -1) ){
                parent[y] = x;
            }
            else{
                parent[find_parent(x)] = parent[y];
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,3},{2,3}};
//        int [][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
//        int [][] edges = {{1,5},{5,8},{7,8},{2,6},{6,7},{1,2}};
        System.out.println( Arrays.toString(findRedundantConnection(edges)));
    }
}

