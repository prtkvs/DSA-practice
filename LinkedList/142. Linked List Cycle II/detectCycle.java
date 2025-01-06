
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length =0;
        while (fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                length = lengthCycle(slow);
                break;
            }
        }
        if (length==0)
            return null;

        // now to find the start node
        ListNode f = head;
        ListNode s = head;

        while(length>0){
            s=s.next;
            length--;
        }
        while(f!=s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
}