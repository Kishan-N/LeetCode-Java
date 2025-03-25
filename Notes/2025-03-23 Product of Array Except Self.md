---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 238
link: https://leetcode.com/problems/product-of-array-except-self
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/prefix-sum
  - programming/practice
  - leetcode/problem
---
# Product of Array Except Self

## Question
Given an integer array `nums`, return *an array* `answer` *such that* `answer[i]` *is equal to the product of all the elements of* `nums` *except* `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,2,3,4]`
>**Output**: `[24,12,8,6]
`

>[!Example]+ Example 2
>**Input**: `nums = [-1,1,0,-3,3]`
>**Output**: `[0,0,9,0,0]
`

>[!warning]+ Constraints
>- `2 <= nums.length <= 10^5`
>
>- `-30 <= nums[i] <= 30`
>
>- The input is generated such that `answer[i]` is guaranteed to fit in a 32-bit integer.
>
>
>
>
>
>
>
>
>Follow up: Can you solve the problem in `O(1)` extra space complexity? (The output array does not count as extra space for space complexity analysis.)
### Hints
>[!Hint]- Hint 1
>Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index. Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?

>[!Hint]- Hint 2
>Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?

---
## Solution

### Intuition
Prefix Postfix problem, I think most problems involving calculating something for each index in nums can be done using Prefix, Postfix arrays.


### Approach
Create Pre-fix and Post-fix product arrays and multiply at each index to get final result.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int i;
        int prod=1;
        for(i=0;i<nums.length;i++){
            res[i]=prod;
            prod*=nums[i];
        }
        prod=1;
        for(i=nums.length-1;i>=0;i--){
            res[i]*=prod;
            prod*=nums[i];
        }

        return res;
    }
}
```