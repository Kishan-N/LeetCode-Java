/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
            while(node!=null){
                if(p.val<node.val && q.val<node.val){
                    node = node.left;
                }
                else if(p.val>node.val && q.val>node.val){
                    node = node.right;
                }
                else
                    return node;
            }
        return node;
    }
}
// @lc code=end

