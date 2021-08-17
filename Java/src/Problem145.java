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

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder_traverse(root);
        return result;
    }


    void postorder_traverse(TreeNode root){
        if(root!=null){
            postorder_traverse(root.left);
            postorder_traverse(root.right);
            result.add(root.val);
        }
    }
}

//
//    //postorder
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            list.add(0,curr.val);
//            if(curr.left!=null) {
//                stack.push(curr.left);
//            }
//            if(curr.right!=null) {
//                stack.push(curr.right);
//            }
//        }
//        return list;
//    }