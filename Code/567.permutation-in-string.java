/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] s1c= new int[26];
        int[] s2c= new int[26];
        int l=0,r=0;
        for(r=0;r<s1.length();r++){
            s1c[s1.charAt(r)-'a']++;
            s2c[s2.charAt(r)-'a']++;
        }
        while(r<s2.length()){
            if(Arrays.equals(s1c, s2c)){
                return true;
            }
            s2c[s2.charAt(r)-'a']++;
            s2c[s2.charAt(l)-'a']--;
            l++;
            r++;
        }
        if(Arrays.equals(s1c, s2c)){
            return true;
        }
        return false;
    }
}
// @lc code=end

