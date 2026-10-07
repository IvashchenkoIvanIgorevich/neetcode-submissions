class Solution {

    private List<Integer> smallest = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dive(root);
        return smallest.get(k - 1);
    }

    private void dive(TreeNode node) {
        if (node == null) return;

        dive(node.left);
        smallest.add(node.val);
        dive(node.right);
    }
}
