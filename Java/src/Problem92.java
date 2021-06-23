import java.util.*;

class Test{
    //use stack structure to reverse might be cleaner
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //move values into an array
        int [] vals = new int [500];
        int n = 1;
        ListNode pointer = head;
        vals[n] = pointer.val;
        while(pointer.next!=null){
            n += 1;
            pointer = pointer.next;
            vals[n] = pointer.val;
        }
        //reverse setup
        ListNode reverse;
        int rev_counter = 0;
        if(left == 1 && right!=1) {
            reverse = new ListNode(vals[right]);
            rev_counter += 1;
        }
        else {
            reverse = new ListNode(vals[1]);
        }
        pointer = reverse;

        for (int i = 2; i <= n; i++){
            if ((i<left) || (i>right)) {//&& (left!=right)
                ListNode tmp = new ListNode(vals[i]);
                pointer.next = tmp;
                pointer = pointer.next;
            }
            else{
                ListNode tmp = new ListNode(vals[right - rev_counter]);
                rev_counter += 1;
                pointer.next = tmp;
                pointer = pointer.next;
            }
        }

        return reverse;
    }

    public static void main(String[] args) {
//        int [] values = {3,5};
//        int left = 1, right = 1;
        int [] values = {1,2,3,4,5};
        int left = 4, right = 5;
//        int [] values = {5,3,1,2,4};
//        int left = 1, right = 2;
        ListNode head = new ListNode(values[0]);
        ListNode pointer = head;
        for(int i = 1; i < values.length; i++){
            ListNode tmp = new ListNode(values[i]);
            pointer.next = tmp;
            pointer = pointer.next;
        }


//        head = [5], left = 1, right = 1

        ListNode result = reverseBetween(head, left, right);
    }
}

