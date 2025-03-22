/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        
        if(root==null)
            return false;

        if(dfs(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean dfs(TreeNode root,TreeNode subroot){
        if(root == null && subroot == null)
            return true;
        
        if(root == null || subroot == null || root.val != subroot.val)
            return false;

        return dfs(root.left,subroot.left) && dfs(root.right,subroot.right);
        
    }
}
// @lc code=end

