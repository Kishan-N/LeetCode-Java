/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)),
        helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int helper(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        int i;
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[i-1];
    }
}
// @lc code=end

