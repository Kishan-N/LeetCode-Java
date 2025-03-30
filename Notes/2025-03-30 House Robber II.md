---
created: 2025-03-30
modified: 
completed: true
leetcode-index: 213
link: https://leetcode.com/problems/house-robber-ii
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/dynamic-programming
  - programming/practice
  - leetcode/problem
---
# House Robber II

## Question
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight without alerting the police*.

 

>[!Example]+ Example 1
>**Input**: `nums = [2,3,2]`
>**Output**: `3`
>**Explanation**:
>You cannot rob house 1 (money => 2) and then rob house 3 (money => 2) , because they are adjacent houses. 

>[!Example]+ Example 2
>**Input**: `nums = [1,2,3,1]`
>**Output**: `4`
>**Explanation**:
>Rob house 1 (money => 1) and then rob house 3 (money => 2) . Total amount you can rob = 1 + 3 = 4. 

>[!Example]+ Example 3
>**Input**: `nums = [1,2,3]`
>**Output**: `3
`

>[!warning]+ Constraints
>- `1 <= nums.length <= 100`
>
>- `0 <= nums[i] <= 1000`
### Hints
>[!Hint]- Hint 1
>Since House[1] and House[n] are adjacent, they cannot be robbed together. Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers more money. Now the problem has degenerated to the House Robber, which is already been solved.

---
## Solution

### Intuition
The problem is same as House robber 1 but since last and first houses are adjacent we need to stop before we reach last house if we start from first house.

If we start from Second house we can reach the last house.

Just perform the same logic for both cases and find the max value.


### Approach
Use helper function to run same logic on 2 slices of nums and get max between both the results. 


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums,1,nums.length)),helper(Arrays.copyOfRange(nums,0,nums.length-1)));
    }

    public int helper(int[] nums){
        int len=nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int i=0;

        for(i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[i-1];
    }
}

```