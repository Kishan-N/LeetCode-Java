/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.isEmpty()){
            return res;
        }

            
        build(digits,0,new StringBuilder());
        return res;
    }

    public void build(String digits,int i,StringBuilder s){
        if(i>=digits.length()){
            res.add(s.toString());
            return;
        }
        

        for(char c:map.get(digits.charAt(i)).toString().toCharArray()){
            s.append(c);
            build(digits,i+1,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}


// @lc code=end

