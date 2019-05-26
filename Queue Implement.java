// "static void main" must be defined in a public class.
public class Main {
    class myQueue<T> {
        class ListNode {
            T val;
            ListNode next;
            ListNode(T val) {
                this.val = val;
                next = null;
            }
            ListNode() {
                next = null;
            }
        }
        ListNode head, tail;
        
        public myQueue() {
            //head = new ListNode();
            //tail = new ListNode();
            
        }
        public void add(T element) {
            // 當queue為空
            ListNode newElement = new ListNode(element);
            if (tail == null) {
                head = newElement;
                tail = newElement;
            } else {
                tail.next = newElement;
                tail = tail.next;
            }
        }
        
        public T remove() {
            if (head == null) {
                return null;
            } else {
                ListNode deleteNode = head;
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                return deleteNode.val;
            }
        }
        
        
    }
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        myQueue<String> q = new myQueue();
        q.add("Henry");
        q.add("Chen");
        q.add("Laura");
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add("Amazon");
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}