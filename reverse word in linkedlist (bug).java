/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode first = head;
        ListNode newHead = null;
        
        while (cur != null) {
            System.out.println(cur.val);
            //while (cur.val != -1) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            //}
            // cur == " " or cur == NULL
            if (cur != null && cur.val == -1) {
                if (newHead == null) {
                    newHead = pre;
                    first.next = cur; 
                } else {
                    first.next = pre;
                }
                first = cur;
                pre = cur.next;
                cur = pre.next;
            }
        }
        
        System.out.println("pre:" + pre.val);
        // cur == NULL
        first.next.next = null;
        first.next = pre;
        
        return newHead;
    }
}