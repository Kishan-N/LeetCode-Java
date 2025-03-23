---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 128
link: https://leetcode.com/problems/longest-consecutive-sequence
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/hash-table
  - leetcode/union-find
  - programming/practice
  - leetcode/problem
---
# Longest Consecutive Sequence

## Question
Given an unsorted array of integers `nums`, return *the length of the longest consecutive elements sequence.*

You must write an algorithm that runs in `O(n)` time.

 

>[!Example]+ Example 1
>**Input**: `nums = [100,4,200,1,3,2]`
>**Output**: `4`
>**Explanation**:
>The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is 4. 

>[!Example]+ Example 2
>**Input**: `nums = [0,3,7,2,5,8,4,6,0,1]`
>**Output**: `9
`

>[!Example]+ Example 3
>**Input**: `nums = [1,0,1,2]`
>**Output**: `3
`

>[!warning]+ Constraints
>- `0 <= nums.length <= 10^5`
>
>- `-10^9 <= nums[i] <= 10^9`
### Hints
No hints available.

---
## Solution

### Intuition
Use a HashSet to store the values in the give input.
If i-1 is not in the set it means it is the start of the sequence.
If it is add 1 to the curr element and check if there in set while incrementing the length.



### Approach
use 1st loop to go through each element index.
Use 2nd loop to check if curr+len in set if yes len++ else maxlen=len and len=1 


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int length;
        int res=0;
        HashSet<Integer> set = new HashSet<>(); 
        for(int n:nums)
            set.add(n);
        int i=0;
        while(i<nums.length){
            int curr=nums[i];
            if(!set.contains(curr-1)){
                length =1;
                while(set.contains(curr+length)){
                    length++;
                }
                res=Math.max(length,res);
            }
            i++;
        }
        

        return res;
    }
}
```