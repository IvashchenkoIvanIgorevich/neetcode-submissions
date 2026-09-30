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
    List<TreeNode> pRoots = new ArrayList<>();
    List<TreeNode> qRoots = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p.val, pRoots);
        findNode(root, q.val, qRoots);

        TreeNode result = null;
        // Collections.reverse(pRoots);
        // Collections.reverse(qRoots);
        for (TreeNode pR : pRoots) {
            for (TreeNode qR : qRoots) {
                if (pR.val == qR.val) {
                    return pR;
                }
            }
        }
        return null;
    }

    private void findNode(TreeNode r, int val, List<TreeNode> roots) {
        if (r == null)
            return;
        if (r.val == val) {
            roots.add(r);
            return;
        }
        if (r.val > val) {
            findNode(r.left, val, roots);
        } else {
            findNode(r.right, val, roots);
        }
        roots.add(r);
    }
}