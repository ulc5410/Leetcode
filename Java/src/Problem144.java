/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder_traverse(root);
        return result;
    }


    void preorder_traverse(TreeNode root){
        if(root!=null){
            result.add(root.val);
            preorder_traverse(root.left);
            preorder_traverse(root.right);
        }
    }
}