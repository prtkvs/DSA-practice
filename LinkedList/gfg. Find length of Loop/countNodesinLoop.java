//https://www.geeksforgeeks.org/problems/find-length-of-loop/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; next = null;
    }
}
// Function should return the length of the loop in LL.
class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast!=null &&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                Node temp = slow;
                int length=0;
                do{
                    temp= temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
}