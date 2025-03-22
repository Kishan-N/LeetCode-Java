/*
 * @lc app=leetcode id=2011 lang=java
 *
 * [2011] Final Value of Variable After Performing Operations
 */

// @lc code=start
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String op : operations){
            res+= 44 - op.charAt(1);   
        }
        return res;
    }
}
// @lc code=end

