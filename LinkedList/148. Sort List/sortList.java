
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

   class Solution {
       public ListNode sortList(ListNode head) {
           if (head == null || head.next == null) {
               return head;
           }
           ListNode prev = head;
           ListNode fast = head;
           ListNode slow = head;
           while (fast != null && fast.next != null) {
               fast = fast.next.next;
               prev = slow;
               slow = slow.next;
           }
           prev.next = null;
           ListNode s = sortList(head);
           ListNode b = sortList(slow);
           ListNode dummy = new ListNode(0);
           ListNode cur = dummy;
           while (s != null && b != null) {
               if (s.val > b.val) {
                   cur.next = b;
                   b = b.next;
               } else {
                   cur.next = s;
                   s = s.next;
               }
               cur = cur.next;
           }

           if (s != null) {
               cur.next = s;
           }
           if (b != null) {
               cur.next = b;
           }
           return dummy.next;
       }
   }