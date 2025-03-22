/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        build(candidates,target,0,0);
        return res;
    }
    public void build(int[] candidates, int target, int sum,int i){
        if(sum == target){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(sum>target || i>=candidates.length)
            return;

        sub.add(candidates[i]);
        build(candidates,target,sum+candidates[i],i);
        sub.remove(sub.size()-1);
        build(candidates,target,sum,i+1);

    }
}
// @lc code=end

