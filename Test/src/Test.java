import java.util.*;

class TreeNode { // binary tree
    int val;
    int pos;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, int pos) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.pos = pos;
    }

    static void insert(int target_pos, int val, TreeNode root){
        if(target_pos==2*root.pos){
            root.left = new TreeNode(val, null, null, target_pos);
            return;
        }else if (target_pos==(2*root.pos+1)){
            root.right = new TreeNode(val, null, null, target_pos);
            return;
        }

        int next_pos = target_pos;
        while((next_pos!=2*root.pos) && (next_pos!=(2*root.pos+1)) || next_pos==0) next_pos = next_pos/2;
        if(next_pos == 0) System.out.println("invalid insert");
        else if(next_pos == 2*root.val){
            if(root.left == null) System.out.println("invalid insert");
            else insert(target_pos, val, root.left);
        }else if(next_pos == (2*root.val+1)){
            if(root.right == null) System.out.println("invalid insert");
            else insert(target_pos, val, root.right);
        }
    }

    static void preorder(TreeNode root)
    {
        if(root != null){
            System.out.printf("%2d",root.val);
            preorder(root.left);
            preorder(root.right);
        }else System.out.printf(" null");
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null) return null;
        return  root;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();

        TreeNode root = new TreeNode(1, null, null, 1);
        TreeNode.insert(2, 0, root);
        TreeNode.insert(3, 0, root);
        TreeNode.insert(4, 0, root);
        TreeNode.insert(5, 0, root);
        TreeNode.insert(6, 0, root);
        TreeNode.insert(7, 1, root);

        root = obj.pruneTree(root);
        TreeNode.preorder(root);

        System.out.println("done");
    }
}
