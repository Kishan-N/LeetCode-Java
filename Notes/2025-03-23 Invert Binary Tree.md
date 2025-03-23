---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 226
link: https://leetcode.com/problems/invert-binary-tree
difficulty: Easy
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/breadth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Invert Binary Tree

## Question
Given the `root` of a binary tree, invert the tree, and return *its root*.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)
>
>**Input**: `root = [4,2,7,1,3,6,9]`
>**Output**: `[4,7,2,9,6,3,1]
`

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg)
>
>**Input**: `root = [2,1,3]`
>**Output**: `[2,3,1]
`

>[!Example]+ Example 3
>**Input**: `root = []`
>**Output**: `[]
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 100]`.
>
>- `-100 <= Node.val <= 100`
### Hints
No hints available.

---
## Solution

### Intuition
Put right node in left and left node in right using DFS.


### Approach
Put right node in left and left node in right using DFS.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    // Create New Tree but give right to left and left to right.
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        
        return node ;

    }
}
```