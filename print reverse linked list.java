// "static void main" must be defined in a public class.
public class Main {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        
        printRev(head, null);
    }
    
    void printRev(ListNode head, ListNode boundary) {
        // base case
        if (head.next == boundary) {
            System.out.println(head.val);
            return;
        }
        
        // divide
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != boundary && fast.next != boundary) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow.next代表rightStart
        ListNode rightStart = slow.next;
        printRev(rightStart, boundary);
        printRev(head, rightStart);
    }
}