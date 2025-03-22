/*
 * @lc app=leetcode id=2401 lang=java
 *
 * [2401] Longest Nice Subarray
 */

// @lc code=start
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sum=0;
        int maxLen=0;
        int r=0;
        int l=0;
        for(r=0;r<nums.length;r++){
                

            while((sum & nums[r]) != 0){
                sum^=nums[l];
                l++;
            }
            
            sum|=nums[r];
            maxLen=Math.max(maxLen,r-l+1); 
        }
        return maxLen;
    }
}
// @lc code=end

