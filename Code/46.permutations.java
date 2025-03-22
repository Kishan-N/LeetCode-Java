/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] pick = new int[nums.length];
        build(nums,pick);
        return res;
    }

    public void build(int[] nums,int[] pick){
        if(sub.size()==nums.length){
            res.add(new ArrayList<Integer>(sub));
            return;
        }


        for(int j=0;j<nums.length;j++){
            if(pick[j]!=1){
                sub.add(nums[j]);
                pick[j]=1;
                build(nums,pick);
                sub.remove(sub.size()-1);
                pick[j]=0;
            }
        }
    }
}
// @lc code=end

