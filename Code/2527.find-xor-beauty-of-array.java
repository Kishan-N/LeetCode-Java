/*
 * @lc app=leetcode id=2527 lang=java
 *
 * [2527] Find Xor-Beauty of Array
 */

// @lc code=start
class Solution {
    public int xorBeauty(int[] nums) {
        int xor=0;
        for(int num:nums)
            xor ^=num;
        return xor;
    }
}
// @lc code=end

