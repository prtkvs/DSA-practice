
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public void reorderList(ListNode head) {
        if(head == null||head.next==null){
            return;
        }
        ListNode mid = middle(head);
        ListNode hs = reverse(mid);
        ListNode hf = head;
        while(hf!=null &&hs!=null){
        ListNode temp = hf.next;
        hf.next = hs;
        hf = temp; // got next first head using temp

        temp = hs.next;
        hs.next = hf;
        hs = temp;
        }
        if (hf!=null){
            hf.next = null;
        }
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