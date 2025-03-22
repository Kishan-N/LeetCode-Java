/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-prices[i-1];
            if(profit>0)
                maxProfit+=profit;
        }
        return maxProfit;
    }
}
// @lc code=end

