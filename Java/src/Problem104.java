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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(1+maxDepth(root.left), 1+maxDepth(root.right));
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
    }
}


