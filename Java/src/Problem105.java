import java.util.Arrays;

public class Problem105 {
    //      Definition for a binary tree node.
    public static class TreeNode {
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
        public void preorder_print(){
            System.out.println(this.val);
            if (this.left!=null) this.left.preorder_print();
            if (this.right!=null) this.right.preorder_print();
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int root = preorder[0];
        TreeNode current_node = new TreeNode(root);
        if (preorder.length == 1) return current_node;

        // find root
        int i = 0;
        while ( inorder[i]!= root) i++;

        int [] left_inorder = Arrays.copyOfRange(inorder, 0, i);
        int [] right_inorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
        int [] left_preorder = Arrays.copyOfRange(preorder, 1,  left_inorder.length+1);
        int [] right_preorder = Arrays.copyOfRange(preorder, left_preorder.length+1, preorder.length);

        current_node.left = buildTree(left_preorder, left_inorder);
        current_node.right = buildTree(right_preorder, right_inorder);


        return current_node;
    }

    public static void main(String[] args) {
        int []  preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
//       int []  preorder = {1,2};
//       int [] inorder = {2,1};

        buildTree(preorder, inorder).preorder_print();
    }
}
