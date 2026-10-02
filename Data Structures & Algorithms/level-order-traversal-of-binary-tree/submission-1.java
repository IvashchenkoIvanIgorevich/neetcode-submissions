class Solution {

    private List<List<Integer>> result = new ArrayList<>(); 

    public List<List<Integer>> levelOrder(TreeNode root) {
        process(root, 0);
        return result;
    }

    private void process(TreeNode root, int level) {
        if(root == null) return;

        if(result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        process(root.left, level+1);
        process(root.right, level+1);
    }
}
