class Solution {

    private int index = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        dive(root);
        return result;
    }

    private void dive(TreeNode node) {
        if (node == null || index == 0) return;

        dive(node.left);
        index--;
        if (index == 0) {
            result = node.val;
            return;
        }
        dive(node.right);
    }
}
