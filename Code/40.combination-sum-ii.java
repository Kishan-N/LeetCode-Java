/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        build(candidates,target,0,0);
        return res;
    }

    public void build(int[] candidates, int target,int sum, int i) {
        if(sum==target){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(sum>target || i >=candidates.length)
            return;
        
        
        sub.add(candidates[i]);
        build(candidates, target, sum+candidates[i], i+1);
        sub.remove(sub.size()-1);
        while(i+1<candidates.length && candidates[i+1]==candidates[i] ){
            i++;
        }
        build(candidates, target, sum, i+1);
    }
}
// @lc code=end

