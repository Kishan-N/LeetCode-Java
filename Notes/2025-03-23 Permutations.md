---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 46
link: https://leetcode.com/problems/permutations
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Permutations

## Question
Given an array `nums` of distinct integers, return all the possible <span data-keyword="permutation-array">permutations</span>. You can return the answer in any order.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,2,3]`
>**Output**: `[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
`

>[!Example]+ Example 2
>**Input**: `nums = [0,1]`
>**Output**: `[[0,1],[1,0]]
`

>[!Example]+ Example 3
>**Input**: `nums = [1]`
>**Output**: `[[1]]
`

>[!warning]+ Constraints
>- `1 <= nums.length <= 6`
>
>- `-10 <= nums[i] <= 10`
>
>- All the integers of `nums` are unique.
### Hints
No hints available.

---
## Solution

### Intuition
Permutations so backtracking.
We need to get every permutation with all elements so we need to add subsets with length = nums.length

The trick here is to create a pick array that tracks if the elements is already used.

Now loop through all the elements and check if its already picked, if not add to sub and make pick to true.

Pass it to the build function and revert pick and remove it from sub.

No need for a second call since we dont want any answer with size less than nums.length.


### Approach
The trick here is to create a pick array that tracks if the elements is already used.

Now loop through all the elements and check if its already picked, if not add to sub and make pick to true.

Pass it to the build function and revert pick and remove it from sub.

No need for a second call since we dont want any answer with size less than nums.length.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] pick = new int[nums.length];
        build(nums,pick);
        return res;
    }

    public void build(int[] nums,int[] pick){
        if(sub.size()==nums.length){
            res.add(new ArrayList<Integer>(sub));
            return;
        }


        for(int j=0;j<nums.length;j++){
            if(pick[j]!=1){
                sub.add(nums[j]);
                pick[j]=1;
                build(nums,pick);
                sub.remove(sub.size()-1);
                pick[j]=0;
            }
        }
    }
}
```