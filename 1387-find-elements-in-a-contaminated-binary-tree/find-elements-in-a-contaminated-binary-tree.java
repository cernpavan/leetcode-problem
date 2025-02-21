/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FindElements {
    ArrayList<Integer> list = new ArrayList<>();

    public void postOrder(TreeNode root) {
        if (root != null) {
            list.add(root.val + 1);
            if (root.right != null) {
                root.right.val = 2 * (root.val + 1) + 1;

            }
            if (root.left != null) {
                root.left.val = 2 * (root.val + 1);
            }
            postOrder(root.left);
            postOrder(root.right);
        }
    }

    public FindElements(TreeNode root) {
        postOrder(root);
    }

    public boolean find(int target) {
        return list.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */