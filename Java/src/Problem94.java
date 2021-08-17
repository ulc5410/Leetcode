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

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder_traverse(root);
        return result;
    }


    void inorder_traverse(TreeNode root){
        if(root!=null){
            inorder_traverse(root.left);
            result.add(root.val);
            inorder_traverse(root.right);
        }
    }
}

//
//    //inorder
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<>();
//        if (root==null) return res;
//
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode curr=root;
//
//        while(curr!=null || !stack.isEmpty()){
//            while (curr!=null){
//                stack.push(curr);
//                curr=curr.left;
//            }
//            curr=stack.pop();
//            res.add(curr.val);
//            curr=curr.right;
//        }
//        return res;
//    }