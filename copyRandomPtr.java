/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        // copy node
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }
        
        // copy random ptr
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // divide result to 2 LinkedList
        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode newCur = cur.next;
        while (newCur.next != null) {
            cur.next = cur.next.next;   // 先給cur改ptr再給newCur改。
            cur = cur.next;
            newCur.next = cur.next;
            newCur = newCur.next;
        }
        newCur.next = null;
        cur.next = null;
        return newHead;
    }
}