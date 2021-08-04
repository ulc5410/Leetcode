import java.util.*;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int pos;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right,int pos) {
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
        else if(next_pos == 2*root.pos){
            if(root.left == null) System.out.println("invalid insert");
            else insert(target_pos, val, root.left);
        }else if(next_pos == (2*root.pos+1)){
            if(root.right == null) System.out.println("invalid insert");
            else insert(target_pos, val, root.right);
        }
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        addResult(root, targetSum);
        return result;
    }

    void addResult(TreeNode root, int targetSum){
        if(root == null) return;

        int nextVal = targetSum - root.val;

        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                List<Integer> subList = new ArrayList<>(curList);
                subList.add(root.val);
                result.add(subList);
            }
        }else{
            curList.add(root.val);
            addResult(root.left, nextVal);
            addResult(root.right, nextVal);
            curList.remove(curList.size()-1);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int target = 22;

        TreeNode root = new TreeNode(5, null, null, 1);
        TreeNode.insert(2, 4, root);
        TreeNode.insert(3, 8, root);
        TreeNode.insert(4, 11, root);
        TreeNode.insert(6, 13, root);
        TreeNode.insert(7, 4, root);
        TreeNode.insert(8, 7, root);
        TreeNode.insert(9, 2, root);
        TreeNode.insert(14, 5, root);
        TreeNode.insert(15, 1, root);

        List<List <Integer>> result = obj.pathSum(root, target);

        for(int i = 0; i < result.size(); i++){
            System.out.println( result.get(i).toString());
        }
    }
}
