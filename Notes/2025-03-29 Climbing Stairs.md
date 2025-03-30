---
created: 2025-03-29
modified: 
completed: true
leetcode-index: 70
link: https://leetcode.com/problems/climbing-stairs
difficulty: Easy
tags:
  - leetcode/math
  - leetcode/dynamic-programming
  - leetcode/memoization
  - programming/practice
  - leetcode/problem
---
# Climbing Stairs

## Question
You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

 

>[!Example]+ Example 1
>**Input**: `n = 2`
>**Output**: `2`
>**Explanation**:
>There are two ways to climb to the top. 1. 1 step + 1 step 2. 2 steps 

>[!Example]+ Example 2
>**Input**: `n = 3`
>**Output**: `3`
>**Explanation**:
>There are three ways to climb to the top. 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step 

>[!warning]+ Constraints
>- `1 <= n <= 45`
### Hints
>[!Hint]- Hint 1
>To reach nth step, what could have been your previous steps? (Think about the step sizes)

---
## Solution

### Intuition
Fibonacci Series.
We can use Dynamic programing memoization specifically to make it the Recursive method more efficient but it will still give us a TLE since we are still doing multiple recursive call for a large enough data set.
Instead we can use tabulation since we will need all the solutions while doing the top down approach and all solutions required for the next subproblem will already be calculated.


### Approach
Create an int[] to store result for n=0 and n=1.
Use these values for calculation for further n values. 


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n<2) return n;
        dp[0]=1;
        dp[1]=1;
        int i;
        for(i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
}

/* Another Top-Down approach with O(1) space complexity
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int prev1 = 1, prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}
*/
```