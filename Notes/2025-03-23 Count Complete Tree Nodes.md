---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 222
link: https://leetcode.com/problems/count-complete-tree-nodes
difficulty: Easy
tags:
  - leetcode/binary-search
  - leetcode/bit-manipulation
  - leetcode/tree
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Count Complete Tree Nodes

## Question
Given the `root` of a complete binary tree, return the number of the nodes in the tree.

According to <a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">Wikipedia</a>, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between `1` and `2^h` nodes inclusive at the last level `h`.

Design an algorithm that runs in less than `O(n)` time complexity.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/01/14/complete.jpg)
>
>**Input**: `root = [1,2,3,4,5,6]`
>**Output**: `6`


>[!Example]+ Example 2
>**Input**: `root = []`
>**Output**: `0`


>[!Example]+ Example 3
>**Input**: `root = [1]`
>**Output**: `1`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 5 * 10^4]`.
>
>- `0 <= Node.val <= 5 * 10^4`
>
>- The tree is guaranteed to be complete.
### Hints
No hints available.

---
## Solution

### Intuition
Just increment count (global variable) before going to next node.


### Approach
Increment count before calling recursive function on left and right nodes.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    int count=0;
    public int countNodes(TreeNode root) {
        // Stack<TreeNode> stack = new Stack<>();
        // int count=0;
        // if(root!=null){
        //     stack.add(root);
        //     count++;
        // }
        // while(!stack.isEmpty()){
        //     TreeNode node = stack.pop();
        //     if(node.left != null){
        //         stack.add(node.left);
        //         count++;
        //     }
        //     if(node.right != null){
        //         stack.add(node.right);
        //         count++;
        //     }
        // }
        // return count;

        if(root==null)
            return 0;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
```