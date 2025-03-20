/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        build(nums,0);
        return res;
    }
    public void build(int[] nums,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
            
        
        sub.add(nums[i]);
        build(nums,i+1);
        sub.remove(sub.size()-1);
        build(nums,i+1);
    }
}
// @lc code=end

