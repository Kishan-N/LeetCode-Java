/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int minChar=0;
        int l=0,r=0;
        while(r<s.length()){
            char curr=s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            minChar=Math.max(minChar,map.get(curr));
            while((r-l+1)-minChar>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
// @lc code=end

