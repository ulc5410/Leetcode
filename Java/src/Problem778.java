import java.util.*;

class Test{
    static class Block{
        int x, y, value;
        Block (int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static class BlockComparator implements Comparator<Block>{
        // for descending order of value
        public int compare(Block b1, Block b2) {
            return (b1.value - b2.value);
        }
    }

    public static int swimInWater(int[][] grid) {
        int [][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int [][] Dijkstra = new int [grid.length][grid.length];

        for (int i = 0; i < Dijkstra.length; i++)
            for(int j = 0; j < Dijkstra.length; j++)
                Dijkstra[i][j] = -1;

        PriorityQueue<Block> q = new PriorityQueue<Block>( new BlockComparator());
        q.add(new Block(0,0,grid[0][0]));
        Dijkstra[0][0] = grid[0][0];

        while (Dijkstra[Dijkstra.length-1][Dijkstra.length-1] == -1){
            Block current = q.poll();
            for (int i = 0; i < directions.length; i++){
                int a = current.x + directions[i][0];
                int b = current.y + directions[i][1];
                if ( (a>=0) && (a<Dijkstra.length) && (b>=0) && (b<Dijkstra.length) && (Dijkstra[a][b] == -1)){
                    Block tmp = new Block(a, b, Math.max(grid[a][b], current.value));
                    Dijkstra[a][b] = tmp.value;
                    q.add(tmp);
                }
            }
        }


        return Dijkstra[Dijkstra.length-1][Dijkstra.length-1];
    }

    public static void main(String[] args) {
//        int [][] grid = {{0,2},{1,3}};
//        int [][] grid = {{3,2},{0,1}};
        int [][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(swimInWater(grid));
    }
}

