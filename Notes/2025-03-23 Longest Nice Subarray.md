---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2401
link: https://leetcode.com/problems/longest-nice-subarray
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/bit-manipulation
  - leetcode/sliding-window
  - programming/practice
  - leetcode/problem
---
# Longest Nice Subarray

## Question
You are given an array `nums` consisting of positive integers.

We call a subarray of `nums` nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to `0`.

Return *the length of the longest nice subarray*.

A subarray is a contiguous part of an array.

Note that subarrays of length `1` are always considered nice.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,3,8,48,10]`
>**Output**: `3`
>**Explanation**:
>The longest nice subarray is [3,8,48]. This subarray satisfies the conditions: - 3 AND 8 = 0. - 3 AND 48 = 0. - 8 AND 48 = 0. It can be proven that no longer nice subarray can be obtained, so we return 3.

>[!Example]+ Example 2
>**Input**: `nums = [3,1,5,11,13]`
>**Output**: `1`
>**Explanation**:
>The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen. 

>[!warning]+ Constraints
>- `1 <= nums.length <= 10^5`
>
>- `1 <= nums[i] <= 10^9`
### Hints
>[!Hint]- Hint 1
>What is the maximum possible length of a nice subarray?

>[!Hint]- Hint 2
>If two numbers have bitwise AND equal to zero, they do not have any common set bit. A number x 9 only has 30 bits, hence the length of the longest nice subarray cannot exceed 30.

---
## Solution

### Intuition
Sliding window.
Use a accumulation variable (SUM).
You can accumulate previous values 1 bits by OR ( | ).
We can then check if new element AND ( & ) SUM !=0 and remove left variable until AND is 0.
Update Max Length every time.


### Approach
Sliding window.
Use a accumulation variable (SUM).
You can accumulate previous values 1 bits by OR ( | ).
We can then check if new element AND ( & ) SUM !=0 and remove left variable until AND is 0.
Update Max Length every time.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sum=0;
        int maxLen=0;
        int r=0;
        int l=0;
        for(r=0;r<nums.length;r++){
                

            while((sum & nums[r]) != 0){
                sum^=nums[l];
                l++;
            }
            
            sum|=nums[r];
            maxLen=Math.max(maxLen,r-l+1); 
        }
        return maxLen;
    }
}
```