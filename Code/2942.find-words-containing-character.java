/*
 * @lc app=leetcode id=2942 lang=java
 *
 * [2942] Find Words Containing Character
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int j =0;j<words.length;j++){
            String s= words[j];
            for(int i=0;i<s.length();i++)
                if(s.charAt(i) == x){
                    res.add(j);
                    break;
                }
        }
        return res;
    }
}

// @lc code=end

