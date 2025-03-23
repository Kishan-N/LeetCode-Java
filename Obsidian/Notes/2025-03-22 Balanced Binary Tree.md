---
created: 2025-03-22
modified: 
completed: false
leetcode-index: 110
link: https://leetcode.com/problems/balanced-binary-tree
difficulty: Easy
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Balanced Binary Tree

## Question
Given a binary tree, determine if it is <span data-keyword="height-balanced">height-balanced</span>.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)
>
>**Input**: `root = [3,9,20,null,null,15,7]`
>**Output**: `true
`

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)
>
>**Input**: `root = [1,2,2,3,3,null,null,4,4]`
>**Output**: `false
`

>[!Example]+ Example 3
>**Input**: `root = []`
>**Output**: `true
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 5000]`.
>
>- `-10^4 <= Node.val <= 10^4`
### Hints
No hints available.

---
## Solution

### Intuition
If height between left and right of the tree is >1 tree is not balanced.


### Approach
Use DFS and return -1 if Math.abs(left,right) >1 
Propagate the -1 to the root and check if root is -1 or 1 to return answer.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfs(root)==-1?false:true;
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0;

        int left = dfs(root.left);
        if(left==-1) return -1;

        int right = dfs(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1)
            return -1;
        
        return Math.max(left,right)+1;
    }
}
```