/*
 * @lc app=leetcode id=2206 lang=java
 *
 * [2206] Divide Array Into Equal Pairs
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int num:nums)
            count.put(num,count.getOrDefault(num, 0)+1);
        
        for(int num:count.values())
            if(num%2!=0)
                return false;
        
        return true;
    }
}
// @lc code=end

