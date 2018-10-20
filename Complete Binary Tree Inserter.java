// init:O(1) insert:O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root = null;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }
    
    public int insert(int v) {
        if (root == null) {
            TreeNode newNode = new TreeNode(v);
            root = newNode;
            return root.val;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur.left != null) {
                q.add(cur.left);
            } else {
                TreeNode newNode = new TreeNode(v);
                cur.left = newNode;
                return cur.val;
            }
            if (cur.right != null) {
                q.add(cur.right);
            } else {
                TreeNode newNode = new TreeNode(v);
                cur.right = newNode;
                return cur.val;
            }
        }
        return -1;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */

// init:O(n) insert:O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root = null;
    Queue<TreeNode> q;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.add(root);
        while (q.peek().left != null && q.peek().right != null) {
            q.add(q.peek().left);
            q.add(q.poll().right);
        }
    }
    
    public int insert(int v) {
        if (q.peek().left == null) {
            TreeNode newNode = new TreeNode(v);
            q.peek().left = newNode;
            //  q.add(newNode);  還不用加入, 到時right填滿了會一起加入
            return q.peek().val;
        } else {
            TreeNode newNode = new TreeNode(v);
            q.peek().right = newNode;
            q.add(q.peek().left);
            q.add(newNode);
            return q.remove().val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */