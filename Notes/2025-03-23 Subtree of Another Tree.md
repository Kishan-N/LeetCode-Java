---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 572
link: https://leetcode.com/problems/subtree-of-another-tree
difficulty: Easy
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/string-matching
  - leetcode/binary-tree
  - leetcode/hash-function
  - programming/practice
  - leetcode/problem
---
# Subtree of Another Tree

## Question
Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of` subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg)
>
>**Input**: `root = [3,4,5,1,2], subRoot = [4,1,2]`
>**Output**: `true
`

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg)
>
>**Input**: `root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]`
>**Output**: `false
`

>[!warning]+ Constraints
>- The number of nodes in the `root` tree is in the range `[1, 2000]`.
>
>- The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.
>
>- `-10^4 <= root.val <= 10^4`
>
>- `-10^4 <= subRoot.val <= 10^4`
### Hints
>[!Hint]- Hint 1
>Which approach is better here- recursive or iterative?

>[!Hint]- Hint 2
>If recursive approach is better, can you write recursive function with its parameters?

>[!Hint]- Hint 3
>Two trees s and t are said to be identical if their root values are same and their left and right subtrees are identical. Can you write this in form of recursive formulae?

>[!Hint]- Hint 4
>Recursive formulae can be: 
>isIdentical(s,t)= s.val==t.val AND isIdentical(s.left,t.left) AND isIdentical(s.right,t.right)

---
## Solution

### Intuition
Same as is same tree but we need to do this for every node in the tree.


### Approach
First check for the root node.
If no check for all the other nodes.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        
        if(root==null)
            return false;

        if(dfs(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean dfs(TreeNode root,TreeNode subroot){
        if(root == null && subroot == null)
            return true;
        
        if(root == null || subroot == null || root.val != subroot.val)
            return false;

        return dfs(root.left,subroot.left) && dfs(root.right,subroot.right);
        
    }
}
```