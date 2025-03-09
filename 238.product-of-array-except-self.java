/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int i;
        int prod=1;
        for(i=0;i<nums.length;i++){
            res[i]=prod;
            prod*=nums[i];
        }
        prod=1;
        for(i=nums.length-1;i>=0;i--){
            res[i]*=prod;
            prod*=nums[i];
        }

        return res;
    }
}
// @lc code=end

