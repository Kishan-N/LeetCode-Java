/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n<2) return n;
        dp[0]=1;
        dp[1]=1;
        int i;
        for(i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
}
// @lc code=end

