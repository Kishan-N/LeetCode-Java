/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len=temperatures.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int index=stack.pop();
                res[index]=i-index;
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

