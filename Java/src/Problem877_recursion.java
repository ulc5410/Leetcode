class Solution {
    int flag = 0;

    public boolean stoneGame(int[] piles) {
        return play(piles, 0, 0);
    }

    public boolean play(int[] piles, int score_a, int score_b) {
        if(piles.length == 2){
            if(score_a+piles[0] > score_b+piles[1]) return true;
            else if(score_a+piles[1] > score_b+piles[0]) return true;
            return false;
        }

        if(flag == 0){// a turn
            flag = 1;
            return play(Arrays.copyOfRange(piles,0, piles.length-1),score_a+piles[piles.length-1], score_b) || play(Arrays.copyOfRange(piles,1, piles.length),score_a+piles[0], score_b);
        }
        else{//b turn
            flag = 0;
            return play(Arrays.copyOfRange(piles,0, piles.length-1),score_a, score_b+piles[piles.length-1]) || play(Arrays.copyOfRange(piles,1, piles.length),score_a, score_b+piles[0]);
        }
    }
}