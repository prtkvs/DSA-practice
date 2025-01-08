
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        int length = getLength(head);
        int count = length/k;
        while(count>0){
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;
            for (int i = 0; current!=null && i <k ; i++) {
                //assign backwards
                current.next = prev;
                //move forward now
                prev = current;
                current = next;
                if (next!=null) {
                    next = next.next; // gives null pointer exception
                }
            }
            if (last!=null){
                last.next= prev;
            }else{
                head = prev;
            }
            // after reversing ab agle k group mein same operation perform krne ke liye
            // just visualise
            newEnd.next = current;
            prev = newEnd;
            count--;
            }
        return head;
        }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length ++; // first node DO COUNT!
            temp = temp.next;
        }
        return length;
    }
}