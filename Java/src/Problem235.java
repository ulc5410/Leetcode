import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Test{
    // O(N)
    static Stack ancestor_stack(TreeNode current, TreeNode node, Stack s){
        while(current.val != node.val){
            s.push(current);
            if(current.val < node.val) current = current.right;
            else current = current.left;
        }
        s.push(current);
        return s;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> p_ancestor = new Stack<TreeNode>(), q_ancestor = new Stack<TreeNode>();

        p_ancestor = ancestor_stack(root, p, p_ancestor);
        q_ancestor = ancestor_stack(root, q, q_ancestor);

        while(p_ancestor.peek().val != q_ancestor.peek().val){
            if(p_ancestor.size() > q_ancestor.size()) p_ancestor.pop();
            else q_ancestor.pop();
        }

        return p_ancestor.peek();
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
        int [] vals = {6,2,8,0,4,7,9,3,5};
        int p = 3, q = 5;

        TreeNode root = null;
        for(int i = 0; i < vals.length; i++){
            root = makeTree(root, vals[i]);
        }

        System.out.println(lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q)).val);
    }
}

