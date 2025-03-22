/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int length;
        int res=0;
        HashSet<Integer> set = new HashSet<>(); 
        for(int n:nums)
            set.add(n);
        int i=0;
        while(i<nums.length){
            int curr=nums[i];
            if(!set.contains(curr-1)){
                length =1;
                while(set.contains(curr+length)){
                    length++;
                }
                res=Math.max(length,res);
            }
            i++;
        }
        

        return res;
    }
}
// @lc code=end

