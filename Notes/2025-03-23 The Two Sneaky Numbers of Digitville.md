---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 3289
link: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville
difficulty: Easy
tags:
  - leetcode/array
  - leetcode/hash-table
  - leetcode/math
  - programming/practice
  - leetcode/problem
---
# The Two Sneaky Numbers of Digitville

## Question
In the town of Digitville, there was a list of numbers called `nums` containing integers from `0` to `n - 1`. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an *additional time*, making the list longer than usual.<!-- notionvc: c37cfb04-95eb-4273-85d5-3c52d0525b95 -->

As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in *any order*), so peace can return to Digitville.<!-- notionvc: 345db5be-c788-4828-9836-eefed31c982f -->

 

>[!Example]+ Example 1
>**Input**: `nums = [0,1,1,0]`
>**Output**: `[0,1]`
>**Explanation**:
>The numbers 0 and 1 each appear twice in the array. 

>[!Example]+ Example 2
>**Input**: `nums = [0,3,2,1,3,2]`
>**Output**: `[2,3]`
>**Explanation**:
>The numbers 2 and 3 each appear twice in the array. 

>[!Example]+ Example 3
>**Input**: `nums = [7,1,5,4,3,4,6,0,9,5,8,2]`
>**Output**: `[4,5]`
>**Explanation**:
>The numbers 4 and 5 each appear twice in the array. 

>[!warning]+ Constraints
>`2 <= n <= 100`
>`nums.length == n + 2`
> `0 <= nums[i] < n
> The input is generated such that `nums` contains exactly two repeated elements.
### Hints
>[!Hint]- Hint 1
>To solve the problem without the extra space, we need to think about how many times each number occurs in relation to the index.

---
## Solution

### Intuition
Find freq map and check if any number is greater than 1 and add to res.


### Approach
Find freq map and check if any number is greater than 1 and add to res.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[nums.length];
        int dupCount=0;
        for(int num:nums){
            freq[num]+=1;
            if(freq[num]>1){
                res[dupCount++]=num;
            }
            if(dupCount==2)
                return res;
        }
        return res;
    }
}
```