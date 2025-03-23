package Code;
/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        build(s,n,0,0);
        return res;
    }

    public void build(StringBuilder s,int n,int countO,int countC) {
        if(countC==countO && countO==n){
            res.add(s.toString());
            return;
        }
        
        if(countO<n){
            s.append('(');
            build(s,n,countO+1,countC);
            s.deleteCharAt(s.length()-1);
        }

        if(countC<countO){
            s.append(')');
            build(s,n,countO,countC+1);
            s.deleteCharAt(s.length()-1);
        }
  
    }

}
// @lc code=end

