---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 104
link: https://leetcode.com/problems/maximum-depth-of-binary-tree
difficulty: Easy
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/breadth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Maximum Depth of Binary Tree

## Question
Given the `root` of a binary tree, return *its maximum depth*.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)
>
>**Input**: `root = [3,9,20,null,null,15,7]`
>**Output**: `3
`

>[!Example]+ Example 2
>**Input**: `root = [1,null,2]`
>**Output**: `2
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 10^4]`.
>
>- `-100 <= Node.val <= 100`
### Hints
No hints available.

---
## Solution

### Intuition
Keep finding the height of left and right and return max of both +1.


### Approach
Keep finding the height of left and right and return max of both +1.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1; 
    }
}
```