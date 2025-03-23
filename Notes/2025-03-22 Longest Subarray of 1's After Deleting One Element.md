---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 1493
link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/dynamic-programming
  - leetcode/sliding-window
  - programming/practice
  - leetcode/problem
---
# Longest Subarray of 1's After Deleting One Element

## Question
Given a binary array `nums`, you should delete one element from it.

Return *the size of the longest non-empty subarray containing only *`1`*'s in the resulting array*. Return `0` if there is no such subarray.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,1,0,1]`
>**Output**: `3`
>**Explanation**:
>After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's. 

>[!Example]+ Example 2
>**Input**: `nums = [0,1,1,1,0,1,1,0,1]`
>**Output**: `5`
>**Explanation**:
>After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1]. 

>[!Example]+ Example 3
>**Input**: `nums = [1,1,1]`
>**Output**: `2`
>**Explanation**:
>You must delete one element. 

>[!warning]+ Constraints
>- `1 <= nums.length <= 10^5`
>
>- `nums[i]` is either `0` or `1`.
### Hints
>[!Hint]- Hint 1
>Maintain a sliding window where there is at most one zero in it.

---
## Solution

### Intuition
Problem wants you to find subarray (widow) of consecutive 1's with max 1 zero,
so start from left and keep increasing window to right and keep track is curr element is 0.

If it is and count of zero > 1 then shrink the window until we have only 1 zero.


### Approach
Sliding Window with zero max count 1 constraint.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int longestSubarray(int[] nums) {
        int l=0;
        int r=0;
        int zero=0;
        int res=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==0)
                zero++;
            else{
                while(zero>1){
                    if(nums[l]==0)
                        zero--;
                    l++;
                }
            }
            res=Math.max(res,r-l+1-zero);
        }
        return res==nums.length?res-1:res;
    }
}
```