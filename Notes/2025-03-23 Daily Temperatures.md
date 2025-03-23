---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 739
link: https://leetcode.com/problems/daily-temperatures
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/stack
  - leetcode/monotonic-stack
  - programming/practice
  - leetcode/problem
---
# Daily Temperatures

## Question
Given an array of integers `temperatures` represents the daily temperatures, return *an array* `answer` *such that* `answer[i]` *is the number of days you have to wait after the* `i^th` *day to get a warmer temperature*. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

 

>[!Example]+ Example 1
>**Input**: `temperatures = [73,74,75,71,69,72,76,73]`
>**Output**: `[1,1,4,2,1,1,0,0]
`

>[!Example]+ Example 2
>**Input**: `temperatures = [30,40,50,60]`
>**Output**: `[1,1,1,0]
`

>[!Example]+ Example 3
>**Input**: `temperatures = [30,60,90]`
>**Output**: `[1,1,0]
`

>[!warning]+ Constraints
>- `1 <= temperatures.length <= 10^5`
>
>- `30 <= temperatures[i] <= 100`
### Hints
>[!Hint]- Hint 1
>If the temperature is say, 70 today, then in the future a warmer temperature must be either 71, 72, 73, ..., 99, or 100.  We could remember when all of them occur next.

---
## Solution

### Intuition
Stack

For each temp before adding to the stack check if the top most temp is less than current temp.
If it is pop the temp from stack and use the index from the pop to find the diff in index and add to res.
If its curr temp < top temp then we can simply push the curr temp into the stack.


### Approach
Add index of the temp instead of the temp so we can get the difference of indexed easily. 


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
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
```