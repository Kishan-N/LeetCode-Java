/*
 * @lc app=leetcode id=3191 lang=java
 *
 * [3191] Minimum Operations to Make Binary Array Elements Equal to One I
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int res = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                continue;
            
            if(i <= nums.length-3){
                nums[i+1]^=1;
                nums[i+2]^=1;
                res+=1;
            }
            else
                return -1;
        }
        return res;
    }
}
// @lc code=end

