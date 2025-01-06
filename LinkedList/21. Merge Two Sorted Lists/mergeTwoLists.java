 class LL {
     private Node head;
     private Node tail;
     private int size;

     public LL() {
         this.size = 0;
     }

     public void insertFirst(int value) {
         Node node = new Node(value);
         node.next = head;
         head = node;
         if (tail == null) {        //only 1 node = head =tail
             tail = head;
         }
         size++;
     }

     public void insertLast(int value) {
         if (tail == null) {
             insertFirst(value);

         } else {
             Node node = new Node(value);
             tail.next = node;
             tail = node;
             size++;
         }
     }

     public void display() {
         Node temp = head;
         while (temp != null) {
             System.out.print(temp.value + " -> ");
             temp = temp.next;
         }
         System.out.println("END");
     }

     private class Node {
         private int value;
         private Node next;

         public Node(int value) {
             this.value = value;
         }

         public Node(int value, Node next) {   //overloading of Node
             this.value = value;
             this.next = next;
         }
     }

     public static LL merge(LL list1, LL list2) {
         Node f = list1.head;
         Node s = list2.head;
         LL ans = new LL();

         while (f != null && s != null) {
             if (f.value < s.value) {
                 ans.insertLast(f.value);
                 f = f.next;
             } else {
                 ans.insertLast(s.value);
                 s = s.next;
             }
         }
         while (f != null) {
             ans.insertLast(f.value);
             f = f.next;
         }
         while (s != null) {
             ans.insertLast(s.value);
             s = s.next;
         }
         return ans;
     }


     public static void main(String[] args) {
         LL first = new LL();
         LL second = new LL();

         first.insertLast(1);
         first.insertLast(3);
         first.insertLast(5);

         second.insertLast(1);
         second.insertLast(2);
         second.insertLast(9);
         second.insertLast(14);

         LL ans = LL.merge(first, second);
         ans.display();
     }
 }
