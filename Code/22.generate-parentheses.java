/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder s= new StringBuilder(); 
        List<String> res = new ArrayList<>();
        dfs(0,0, s,n,res);

        return res;
    }

    public void dfs(int OpenC,int ClosedC,StringBuilder s,int n,List<String> res){
        if(OpenC==ClosedC && OpenC == n){
            res.add(s.toString());
            return;
        }

        if(OpenC<n){
            s.append("(");
            dfs(OpenC+1,ClosedC,s,n,res);
            s.deleteCharAt(s.length()-1);
        }
        if(ClosedC<OpenC){
            dfs(OpenC,ClosedC+1,s.append(")"),n,res);
            s.deleteCharAt(s.length()-1);
        }
    }
}
// @lc code=end

