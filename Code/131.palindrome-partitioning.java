/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> sub = new ArrayList<>();
    public List<List<String>> partition(String s) {
        
        build(s,0);
        return res;
    }

    public void build(String s,int i){
        if(i>=s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)){
                sub.add(s.substring(i,j+1));
                build(s,j+1);
                sub.remove(sub.size()-1);
            }
        }
    }

    public boolean isPali(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

