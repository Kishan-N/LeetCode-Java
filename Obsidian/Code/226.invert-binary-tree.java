/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 */

// @lc code=start
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
    // Create New Tree but give right to left and left to right.
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        
        return node ;

    }
}
// @lc code=end

