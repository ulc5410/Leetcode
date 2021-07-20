import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Test{
    // O(N)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l == null) return r;
        else if (r == null) return l;
        else return root;
    }

    static TreeNode makeTree(TreeNode current, int val){ //binary search tree
        TreeNode new_node = new TreeNode(val);
        if(current == null) return new_node;

        if(current.val < val){
            current.right = makeTree(current.right, val);
        }else if(current.val > val){
            current.left = makeTree(current.left, val);
        }

        return current;
    }

    public static void main(String[] args) {
        int [] vals = {3,5,1,6,2,0,8,7,4};
        int p = 2, q = 0;

        TreeNode root = null;
        for(int i = 0; i < vals.length; i++){
            root = makeTree(root, vals[i]);
        }

        System.out.println(lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q)).val);
    }
}

