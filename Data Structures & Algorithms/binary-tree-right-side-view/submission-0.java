/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        process(root, 0);
        List<Integer> rightResult = new ArrayList();
        for(List<Integer> v : result) {
            rightResult.add(v.getLast());
        }
        return rightResult;
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

    
