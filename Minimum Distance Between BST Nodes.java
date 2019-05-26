/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    
    void inOrder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        inOrder(cur.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(cur.val - pre.val));
        }
        pre = cur;
        inOrder(cur.right);
    }
}