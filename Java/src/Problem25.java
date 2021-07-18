import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Test{
    // O(N)
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head, next_k = head;
        ListNode answer = new ListNode(-1), ans_pointer = answer;
        int count = 0;
        Stack<ListNode> stack = new Stack<ListNode>();

        while(current != null){
            stack.push(current);
            current = current.next;
            count += 1;

            if(count == k){
                next_k = current;
                while(!stack.isEmpty()){
                    ans_pointer.next = stack.pop();
                    ans_pointer = ans_pointer.next;
                }
                count = 0;
            }
        }

        ans_pointer.next = next_k;

        return answer.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), current = head;
        int k = 2;

        for(int i = 2; i < 3; i++){
            ListNode tmp = new ListNode(i);
            current.next = tmp;
            current = tmp;
        }

        head = reverseKGroup(head, k);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

