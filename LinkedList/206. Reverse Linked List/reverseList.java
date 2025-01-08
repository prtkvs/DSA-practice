
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
    ListNode prev = null;
    ListNode pres = head;
    ListNode next = pres.next;

    while(pres!=null){
        //assign backwards
        pres.next = prev;
        //move forward now
        prev = pres;
        pres = next;
        if (next!=null) {
            next = next.next; // gives null pointer exception
        }
    }
    prev = head;
    return prev;
    }
}