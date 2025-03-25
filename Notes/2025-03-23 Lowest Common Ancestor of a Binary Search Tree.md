---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 235
link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
difficulty: Medium
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/binary-search-tree
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Lowest Common Ancestor of a Binary Search Tree

## Question
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself)."

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)
>
>**Input**: `root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8`
>**Output**: `6`
>**Explanation**:
>The LCA of nodes 2 and 8 is 6. 

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)
>
>**Input**: `root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4`
>**Output**: `2`
>**Explanation**:
>The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition. 

>[!Example]+ Example 3
>**Input**: `root = [2,1], p = 2, q = 1`
>**Output**: `2
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[2, 10^5]`.
>
>- `-10^9 <= Node.val <= 10^9`
>
>- All `Node.val` are unique.
>
>- `p != q`
>
>- `p` and `q` will exist in the BST.
### Hints
No hints available.

---
## Solution

### Intuition
Answer is in the question, tree is a Binary Search Tree, so if p < node < q return the node.
if p < node > q then move node to the left.
If p > node < q then move node to the right.


### Approach
Answer is in the question, tree is a Binary Search Tree, so if p < node < q return the node.
if p < node > q then move node to the left.
If p > node < q then move node to the right.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
            while(node!=null){
                if(p.val<node.val && q.val<node.val){
                    node = node.left;
                }
                else if(p.val>node.val && q.val>node.val){
                    node = node.right;
                }
                else
                    return node;
            }
        return node;
    }
}
```