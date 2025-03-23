---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 40
link: https://leetcode.com/problems/combination-sum-ii
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Combination Sum II

## Question
Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

>[!Example]+ Example 1
>**Input**: `candidates = [10,1,2,7,6,1,5], target = 8`
>**Output**: `[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
`

>[!Example]+ Example 2
>**Input**: `candidates = [2,5,2,1,2], target = 5`
>**Output**: `[
[1,2,2],
[5]
]
`

>[!warning]+ Constraints
>- `1 <= candidates.length <= 100`
>
>- `1 <= candidates[i] <= 50`
>
>- `1 <= target <= 30`
### Hints
No hints available.

---
## Solution

### Intuition
Same as combination sum 1 but we cant use same number again so use i+1 in first function also.

Sort the array.
Use a while loop because you have same elements in the array and you don't want to repeat the elements or you get duplicate answers.


### Approach
Same as combination sum 1 but we cant use same number again so use i+1 in first function also.

Sort the array.
Use a while loop because you have same elements in the array and you don't want to repeat the elements or you get duplicate answers.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        build(candidates,target,0,0);
        return res;
    }

    public void build(int[] candidates, int target,int sum, int i) {
        if(sum==target){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(sum>target || i >=candidates.length)
            return;
        
        
        sub.add(candidates[i]);
        build(candidates, target, sum+candidates[i], i+1);
        sub.remove(sub.size()-1);
        while(i+1<candidates.length && candidates[i+1]==candidates[i] ){
            i++;
        }
        build(candidates, target, sum, i+1);
    }
}
```