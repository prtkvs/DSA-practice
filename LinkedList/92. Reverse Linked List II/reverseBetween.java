
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = current.next;
    if (left==right){
        return head;
    }
    // reaching by skipping left-1 nodes
        for (int i = 0; current!=null && i< left-1; i++) {
            prev = current;
            current = current.next;
        }
    ListNode last = prev; // cuz ab reach kar chuka hai
    ListNode newEnd = current;
    // reversing
        for (int i = 0; current!=null&& i< right-left+1 ; i++) {
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
        newEnd.next = current;
        return head;
    }
}