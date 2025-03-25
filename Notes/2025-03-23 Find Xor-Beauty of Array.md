---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2527
link: https://leetcode.com/problems/find-xor-beauty-of-array
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/math
  - leetcode/bit-manipulation
  - programming/practice
  - leetcode/problem
---
# Find Xor-Beauty of Array

## Question
You are given a 0-indexed integer array `nums`.

The effective value of three indices `i`, `j`, and `k` is defined as `((nums[i] | nums[j]) & nums[k])`.

The xor-beauty of the array is the XORing of the effective values of all the possible triplets of indices `(i, j, k)` where `0 <= i, j, k < n`.

Return *the xor-beauty of* `nums`.

Note that:

	
- `val1 | val2` is bitwise OR of `val1` and `val2`.
	
- `val1 & val2` is bitwise AND of `val1` and `val2`.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,4]`
>**Output**: `5`
>**Explanation**:
>The triplets and their corresponding effective values are listed 
below :
(0,0,0) with effective value ((1 | 1) & 1) = 1 
(0,0,1) with effective value ((1 | 1) & 4) = 0 
(0,1,0) with effective value ((1 | 4) & 1) = 1
(0,1,1) with effective value ((1 | 4) & 4) = 4
(1,0,0) with effective value ((4 | 1) & 1) = 1
(1,0,1) with effective value ((4 | 1) & 4) = 4
(1,1,0) with effective value ((4 | 4) & 1) = 0
(1,1,1) with effective value ((4 | 4) & 4) = 4 
Xor-beauty of array will be bitwise XOR of all beauties = 1 ^ 0 ^ 1 ^ 4 ^ 1 ^ 4 ^ 0 ^ 4 = 5. 

>[!Example]+ Example 2
>**Input**: `nums = [15,45,20,2,34,35,5,44,32,30]`
>**Output**: `34`
>**Explanation**:
>`The xor-beauty of the given array is 34.` 

>[!warning]+ Constraints
>- `1 <= nums.length <= 10^5`
>
>- `1 <= nums[i] <= 10^9`
### Hints
>[!Hint]- Hint 1
>Try to simplify the given expression.

>[!Hint]- Hint 2
>Try constructing the answer bit by bit.

---
## Solution

### Intuition
If we focus on only input with size 2 we see the only the Results of OR and AND with the same index are left out i.e, a and b rest all are canceled out by the XORs.

Even with more that  2 indices we get the same result i.e, ( a | a ) & a ^ ( b | b ) & b ^ ( c | c ) ^ c hence we can just XOR all elements.

(a | a) & a = a


### Approach
If we focus on only input with size 2 we see the only the Results of OR and AND with the same index are left out i.e, a and b rest all are canceled out by the XORs.

Even with more that  2 indices we get the same result i.e, ( a | a ) & a ^ ( b | b ) & b ^ ( c | c ) ^ c hence we can just XOR all elements.

(a | a) & a = a



### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
```cpp
class Solution {
    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return xor;
    }
}
```
```