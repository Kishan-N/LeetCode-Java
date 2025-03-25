---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2206
link: https://leetcode.com/problems/divide-array-into-equal-pairs
difficulty: Easy
tags:
  - leetcode/array
  - leetcode/hash-table
  - leetcode/bit-manipulation
  - leetcode/counting
  - programming/practice
  - leetcode/problem
---
# Divide Array Into Equal Pairs

## Question
You are given an integer array `nums` consisting of `2 * n` integers.

You need to divide `nums` into `n` pairs such that:

	
- Each element belongs to exactly one pair.
	
- The elements present in a pair are equal.

Return `true` *if nums can be divided into* `n` *pairs, otherwise return* `false`.

 

>[!Example]+ Example 1
>**Input**: `nums = [3,2,3,2,2,2]`
>**Output**: `true`
>**Explanation**:
>There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs. If nums is divided into the pairs (2, 
> 2) , (3, 
> 3) , and (2, 
> 2) , it will satisfy all the conditions. 

>[!Example]+ Example 2
>**Input**: `nums = [1,2,3,4]`
>**Output**: `false`
>**Explanation**:
>There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition. 

>[!warning]+ Constraints
>- `nums.length == 2 * n`
>
>- `1 <= n <= 500`
>
>- `1 <= nums[i] <= 500`
### Hints
>[!Hint]- Hint 1
>For any number x in the range [1, 500], count the number of elements in nums whose values are equal to x.

>[!Hint]- Hint 2
>The elements with equal value can be divided completely into pairs if and only if their count is even.

---
## Solution

### Intuition
Just need to make sure there are no odd count numbers.
We cannot make pairs if and count is odd


### Approach
Maintain Freq map of values in nums and return false if ant count is odd.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int num:nums)
            count.put(num,count.getOrDefault(num, 0)+1);
        
        for(int num:count.values())
            if(num%2!=0)
                return false;
        
        return true;
    }
}
```