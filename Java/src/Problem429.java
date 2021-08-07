import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        int pos = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> resultLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                Node current = q.poll();
                resultLevel.add(current.val);
                for(int j = 0; j < current.children.size(); j++){
                    q.add(current.children.get(j));
                }
            }
            pos++;
            result.add(resultLevel);
        }

        return result;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.levelOrder());
    }
}
