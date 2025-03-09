/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 */

// @lc code=start

import java.util.Stack;

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
    int count=0;
    public int countNodes(TreeNode root) {
        // Stack<TreeNode> stack = new Stack<>();
        // int count=0;
        // if(root!=null){
        //     stack.add(root);
        //     count++;
        // }
        // while(!stack.isEmpty()){
        //     TreeNode node = stack.pop();
        //     if(node.left != null){
        //         stack.add(node.left);
        //         count++;
        //     }
        //     if(node.right != null){
        //         stack.add(node.right);
        //         count++;
        //     }
        // }
        // return count;

        if(root==null)
            return 0;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
// @lc code=end

