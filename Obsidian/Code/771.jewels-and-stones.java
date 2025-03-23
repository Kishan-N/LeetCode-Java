/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> valid = new HashSet<>();
        int res=0;
        for(char c:jewels.toCharArray()){
            valid.add(c);
        }
        for(char c:stones.toCharArray()){
            if(valid.contains(c))
                res++;
        }
        return res;
    }
}
// @lc code=end

