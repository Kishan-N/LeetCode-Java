/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        
        int l=0,r=0;
        int minLen=Integer.MAX_VALUE;
        int[] res = new int[]{-1,-1};
        int have=0,need=0;
        
        HashMap<Character,Integer> countT = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(r=0;r<t.length();r++)
            countT.put(t.charAt(r),countT.getOrDefault(t.charAt(r),0)+1);
        
        need = countT.size();

        for(r=0;r<s.length();r++){
            window.put(s.charAt(r),window.getOrDefault(s.charAt(r),0)+1);
            if(countT.containsKey(s.charAt(r)) && window.get(s.charAt(r)).intValue() == countT.get(s.charAt(r)).intValue()) // Use .intValue() to compare to pass last test case.
                have++;
            
            while(have==need){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                window.put(s.charAt(l),window.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l)))
                    have--;
                l++;
            }
        }
        return res[0]==-1?"":s.substring(res[0],res[1]+1);
        
        
    }
}
// @lc code=end

