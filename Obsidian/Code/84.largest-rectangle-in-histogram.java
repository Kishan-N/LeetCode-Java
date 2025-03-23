/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int maxArea=0;
        
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!stack.isEmpty() && stack.peek().getval()>heights[i]){
                    Pair<Integer,Integer> pair = stack.pop();
                    int height = pair.getval();
                    int width = pair.getkey();
                    maxArea = Math.max(maxArea,height*(i-width));
                    start = width;
            }
            stack.push(new Pair<>(start, heights[i]));
        }
        for(Pair<Integer,Integer> p: stack){
                int height = p.getval();
                int width = p.getkey();
                maxArea = Math.max(maxArea,height*(heights.length-width));
        }
        return maxArea;
    }

    
}

class Pair<K, V>{

    private K key;
    private V value;

    public Pair(K key,V value){
        this.key=key;
        this.value=value;
    }

    public K getkey(){
        return key;
    }

    public V getval(){
        return value;
    }
}
// @lc code=end

