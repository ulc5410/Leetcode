import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;  //true if no violations
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        int rH=height(node.right);

        //previous violations
        if(lH==-1 || rH==-1){
            return -1;
        }
        //current violations
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        //else return height
        return Math.max(lH,rH)+1;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
    }
}


