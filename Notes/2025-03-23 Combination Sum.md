---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 39
link: https://leetcode.com/problems/combination-sum
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Combination Sum

## Question
Given an array of distinct integers `candidates` and a target integer `target`, return *a list of all unique combinations of *`candidates`* where the chosen numbers sum to *`target`*.* You may return the combinations in any order.

The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the <span data-keyword="frequency-array">frequency</span> of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to `target` is less than `150` combinations for the given input.

 

>[!Example]+ Example 1
>**Input**: `candidates = [2,3,6,7], target = 7`
>**Output**: `[[2,2,3],[7]]`
>**Explanation**:
>2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times. 7 is a candidate, and 7 = 7. These are the only two combinations. 

>[!Example]+ Example 2
>**Input**: `candidates = [2,3,5], target = 8`
>**Output**: `[[2,2,2,2],[2,3,3],[3,5]]
`

>[!Example]+ Example 3
>**Input**: `candidates = [2], target = 1`
>**Output**: `[]
`

>[!warning]+ Constraints
>- `1 <= candidates.length <= 30`
>
>- `2 <= candidates[i] <= 40`
>
>- All elements of `candidates` are distinct.
>
>- `1 <= target <= 40`
### Hints
No hints available.

---
## Solution

### Intuition

We have to find all permutation that can give sum = target.
To get permutations we use backtracking.

Backtracking
Base case sum == target

Use i to go through every level.
if sum> target or i> nums.length return.

Main part here is we can use the same number again so dont increment i in first call and only increment in the second call.



### Approach
<!-- Describe your approach to solving the problem. -->


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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        build(candidates,target,0,0);
        return res;
    }
    public void build(int[] candidates, int target, int sum,int i){
        if(sum == target){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(sum>target || i>=candidates.length)
            return;

        sub.add(candidates[i]);
        build(candidates,target,sum+candidates[i],i);
        sub.remove(sub.size()-1);
        build(candidates,target,sum,i+1);

    }
}
```