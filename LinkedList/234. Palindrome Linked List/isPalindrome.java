
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public boolean isPalindrome(ListNode head) {
    ListNode mid = middle(head);
    ListNode headSecond = reverse(mid);
    while(head!=null&&headSecond!=null){
        if (head.val!=headSecond.val){
            break;
        }
        head = head.next;
        headSecond = headSecond.next;
    }
    reverse(headSecond);
    if (head==null || headSecond==null){
        return true;
    }
    return false;
    }
    private ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        while(pres!=null){
            //assigning backwards
            pres.next = prev;
            // traversing earlier
            prev = pres;
            pres = next;
            if (next!=null)
            next = next.next;
        }
        return prev;
    }
}
