/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.*;


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
       ;
        if(root !=null){
            q.offer(root);
        }
        
        while(!q.isEmpty()){
            ArrayList<Integer> sub= new ArrayList<>(); 
            for(int n=q.size();n>0;n--){
                TreeNode node = q.poll();
                sub.add(node.val);
                if(node.left !=null){
                    q.offer(node.left);
                }
                if(node.right !=null){
                    q.offer(node.right);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
// @lc code=end

