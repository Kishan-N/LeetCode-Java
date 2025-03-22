/*
 * @lc app=leetcode id=1689 lang=java
 *
 * [1689] Partitioning Into Minimum Number Of Deci-Binary Numbers
 */

// @lc code=start
class Solution {
    public int minPartitions(String n) {
        for(int i=9;i>=0;i--){
            if(n.contains(String.valueOf(i))){
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

