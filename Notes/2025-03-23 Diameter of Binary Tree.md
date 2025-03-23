---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 543
link: https://leetcode.com/problems/diameter-of-binary-tree
difficulty: Easy
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Diameter of Binary Tree

## Question
Given the `root` of a binary tree, return *the length of the diameter of the tree*.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.

The length of a path between two nodes is represented by the number of edges between them.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg)
>
>**Input**: `root = [1,2,3,4,5]`
>**Output**: `3`
>**Explanation**:
>3 is the length of the path [4,2,1,3] or [5,2,1,3]. 

>[!Example]+ Example 2
>**Input**: `root = [1,2]`
>**Output**: `1
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[1, 10^4]`.
>
>- `-100 <= Node.val <= 100`
### Hints
No hints available.

---
## Solution

### Intuition
DFS

Same as find height of tree but you need to add left and right height together and compare with existing diameter.


### Approach
Same as find height of tree but you need to add left and right height together and compare with existing diameter.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    //Understand and watch the solution video again for other solutions.
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }
}
```