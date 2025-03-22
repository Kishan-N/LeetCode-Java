/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] pair = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(a[0], b[0]));
        for(int i=0;i<position.length;i++){
            double timeTaken =(double)(target - pair[i][0])/pair[i][1];
            while(!stack.isEmpty() && timeTaken>=stack.peek()){
                stack.pop();
            }
            stack.push(timeTaken);
        }
        return stack.size();
    }
}
// @lc code=end

