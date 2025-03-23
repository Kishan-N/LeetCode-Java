---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 3191
link: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/bit-manipulation
  - leetcode/queue
  - leetcode/sliding-window
  - leetcode/prefix-sum
  - programming/practice
  - leetcode/problem
---
# Minimum Operations to Make Binary Array Elements Equal to One I

## Question
You are given a <span data-keyword="binary-array">binary array</span> `nums`.

You can do the following operation on the array any number of times (possibly zero):

	
- Choose any 3 consecutive elements from the array and flip all of them.

Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in `nums` equal to 1. If it is impossible, return -1.

 

>[!Example]+ Example 1
>**Input**: `nums = [0,1,1,1,0,0]`
>**Output**: `3`
>**Explanation**:
><br /> We can do the following operations:    	 - Choose the elements at indices 0, 1 and 2. The resulting array is `nums = [1,0,0,1,0,0]`. 	 - Choose the elements at indices 1, 2 and 3. The resulting array is `nums = [1,1,1,0,0,0]`. 	 - Choose the elements at indices 3, 4 and 5. The resulting array is `nums = [1,1,1,1,1,1]`.   

>[!Example]+ Example 2
>**Input**: `nums = [0,1,1,1]`
>**Output**: `-1`
>**Explanation**:
><br /> It is impossible to make all elements equal to 1. 

>[!warning]+ Constraints
>- `3 <= nums.length <= 10^5`
>
>- `0 <= nums[i] <= 1`
### Hints
>[!Hint]- Hint 1
>If nums[0] is 0, then the only way to change it to 1 is by doing an operation on the first 3 elements of the array.

>[!Hint]- Hint 2
>After Changing nums[0] to 1, use the same logic on the remaining array.

---
## Solution

### Intuition
Just start from index 0  and if its 0 invert next 2 indexes using XOR.
If all 1 are ones by the end of loop the return number of inversions.
If there are still 0 at the last 3 elements after the loop we can return -1.


### Approach
Just start from index 0  and if its 0 invert next 2 indexes using XOR.
If all 1 are ones by the end of loop the return number of inversions.
If there are still 0 at the last 3 elements after the loop we can return -1.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int minOperations(int[] nums) {
        int res = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                continue;
            
            if(i <= nums.length-3){
                nums[i+1]^=1;
                nums[i+2]^=1;
                res+=1;
            }
            else
                return -1;
        }
        return res;
    }
}
```