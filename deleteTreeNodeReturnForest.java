// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public Main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        
        List<Integer> del = new ArrayList<>();
        del.add(1);
        del.add(6);
        
        List<TreeNode> ans = deleteNode(root, del);
        for (TreeNode cur : ans) {
            System.out.print(cur.val + " ");
        }
    }
    
    List<TreeNode> deleteNode(TreeNode root, List<Integer> del) {
        List<TreeNode> ansList = new ArrayList<>();
        ansList.add(root);
        for (int curDelNode : del) {
            // traverse 所有森林的樹
            int curRootIdx = 0;
            for (TreeNode curRoot : ansList) {
                if (dfs(curRoot, curDelNode, ansList, null, false, curRootIdx)) {
                    break;
                }
                curRootIdx++;
            }
        }
        return ansList;
        
    }
    
    boolean dfs(TreeNode root, int del, List<TreeNode> ansList, TreeNode parent, boolean leftChild, int curRootIdx) {
        if (root == null) {
            return false;
        }
        
        if (root.val == del) {
            if (parent == null) {
                // 如果現在要刪的點剛好是ansList中的root, 要把這個root從ansList移除
                ansList.remove(curRootIdx);
            } else {
                // 如果不是root, 要把父親到當前點的link設為null
                if (leftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (root.left != null) {
                ansList.add(root.left);
            }
            if (root.right != null) {
                ansList.add(root.right);
            }
            return true;
        }
        
        boolean left = dfs(root.left, del, ansList, root, true, curRootIdx);
        boolean right = dfs(root.right, del, ansList, root, false, curRootIdx);

        return left || right;
    }
    
    
}