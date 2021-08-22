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
    public boolean isSymmetric(TreeNode root) {
        return checkChild(root.left, root.right);
    }

    boolean checkChild(TreeNode child1, TreeNode child2){
        if(child1 == null && child2 == null) return true;
        else if(child1 == null || child2 == null) return false;

        if(child1.val == child2.val) {
            return checkChild(child1.left, child2.right) && checkChild(child1.right, child2.left);
        }
        else return false;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
    }
}


