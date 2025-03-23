/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int l=0;
        int r=0;
        int zero=0;
        int res=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==0)
                zero++;
            else{
                while(zero>1){
                    if(nums[l]==0)
                        zero--;
                    l++;
                }
            }
            res=Math.max(res,r-l+1-zero);
        }
        return res==nums.length?res-1:res;
    }
}
// @lc code=end

