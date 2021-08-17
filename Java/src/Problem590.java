/*
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
*/

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        postorder_traverse(root);
        return result;
    }

    void postorder_traverse(Node root){
        if(root!=null){
            for(int i = 0; i < root.children.size();i++){
                postorder_traverse(root.children.get(i));
            }
            result.add(root.val);
        }
    }
}