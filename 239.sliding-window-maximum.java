/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int l=0,r=0;
        for(r=0;r<nums.length;r++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[r])
                q.removeLast();
            q.addLast(r);
            if(l>q.getFirst())
                q.removeFirst();
            if((r+1)>=k){
                res[l]=nums[q.getFirst()];
                l++;
            }
        }
        return res;
    }
}
// @lc code=end
