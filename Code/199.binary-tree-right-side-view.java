package Code;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root!=null)
            q.add(root);
        while(!q.isEmpty()){
            TreeNode node = null;
            int size=q.size();
            for(int r=0;r<size;r++){
                node = q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(node!=null)
                res.add(node.val);
        }
        return res;
    }
}
// @lc code=end



