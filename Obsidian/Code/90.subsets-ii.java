/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        build(nums,i+1);
    }
}
// @lc code=end

