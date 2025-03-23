package Code;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {

    Stack<Long> stack;
    long min = 0;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            this.min=val;
            stack.push((long) val);
        }
        else{
            if(val<min){
                stack.push(2L*val-min); //Multiply with 2L to pass long integer test case.
                min = val;
            }else{
                stack.push((long) val);
            }
        }
                
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        long top = stack.pop();
        if(top<min){
            min = 2*min-top;
        }
    }
    
    public int top() {
        if(stack.isEmpty())
            throw new RuntimeException("Stack is empty");
        long top =stack.peek();
        if(top<min){
            return (int)min;
        }
        else return (int)top;
        
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

