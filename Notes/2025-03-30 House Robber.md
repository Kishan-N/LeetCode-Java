---
created: 2025-03-30
modified: 
completed: true
leetcode-index: 198
link: https://leetcode.com/problems/house-robber
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/dynamic-programming
  - programming/practice
  - leetcode/problem
---
# House Robber

## Question
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight <b>without alerting the police</b>*.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,2,3,1]`
>**Output**: `4`
>**Explanation**:
>Rob house 1 (money => 1) and then rob house 3 (money => 1) . 
>Total amount you can rob = 1 + 3 = 4. 

>[!Example]+ Example 2
>**Input**: `nums = [2,7,9,3,1]`
>**Output**: `12`
>**Explanation**:
>Rob house 1 (money => 2) , rob house 3 (money => 2) and rob house 5 (money => 2).
>Total amount you can rob = 2 + 9 + 1 = 12. 

>[!warning]+ Constraints
>- `1 <= nums.length <= 100`
>
>- `0 <= nums[i] <= 400`
### Hints
No hints available.

---
## Solution

### Intuition

At every house `i`, you have **two choices**:
- **Rob the current house (`nums[i]`)**
    - If you rob it, you must skip the previous house (`i - 1`).
    - Your new total becomes: `nums[i] + amount robbed until house (i-2)`.
- **Skip the current house**
    - If you skip, you keep whatever amount you robbed until house `(i-1)`.
Mathematically, the best amount we can have at house `i` is:
![[Pasted image 20250330133840.png]]

### Approach
- Start from house `0`, keep track of `prevTwo` (two houses behind) and `prevOne` (one house behind).
- Iterate through the array, updating these values as you go.
- At the end, `prevOne` holds the maximum amount you can rob.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int rob(int[] nums) {

        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int p1=0;
        int p2=0;
        int i=0;
        for(i=0;i<nums.length;i++){
            int curr = Math.max(p1+nums[i],p2);
            p1=p2;
            p2=curr;
        } 
        return p2;
    }
}
//[5,1,2,10,6,2,7,9,3,1]
```