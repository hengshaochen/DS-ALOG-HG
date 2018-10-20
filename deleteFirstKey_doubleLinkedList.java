// "static void main" must be defined in a public class.
public class Main {
    class ListNode {
        int val;
        ListNode next, pre;
        
        public ListNode(int val) {
            this.val = val;
            next = null;
            pre = null;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        ListNode dummy = new ListNode(0);
        
        ListNode head = new ListNode(1);
        dummy.next = head;
        head.pre = dummy;
        
        head.next = new ListNode(2);
        head.next.pre = head;
        
        head.next.next = new ListNode(3);
        head.next.next.pre = head.next.next;
        
        head.next.next.next = new ListNode(2);
        head.next.next.next.pre = head.next.next.next;
        deleteFirstKey(head, 2);
        
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    
    void deleteFirstKey(ListNode head, int del) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == del) {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                return;
            }
            cur = cur.next;
        }
    }
}

// 環形linkedlist 一個一個刪除
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public Main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head;
        
        deleteNode(head);
        ListNode cur = head;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != head);
    }
    
    void deleteNode(ListNode head) {
        if (head == null) {
            return;
        }
        // 1->1'
        if (head == head.next) {
            return;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        do {
            first.next = second.next;
            first = first.next;
            second = first.next;
        } while (first != head && second != head);
    }
}