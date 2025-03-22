/*
 * @lc app=leetcode id=1400 lang=java
 *
 * [1400] Construct K Palindrome Strings
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k) return false;

        HashMap<Character,Integer> count = new HashMap<>();

        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);
        }

        int oddCount=0;
        for(int freq:count.values()){
            if(freq%2==1) oddCount++; 
        }

        return oddCount<=k;
    }
}
// @lc code=end

