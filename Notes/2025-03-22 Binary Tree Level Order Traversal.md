---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 102
link: https://leetcode.com/problems/binary-tree-level-order-traversal
difficulty: Medium
tags:
  - leetcode/tree
  - leetcode/breadth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Binary Tree Level Order Traversal

## Question
Given the `root` of a binary tree, return *the level order traversal of its nodes' values*. (i.e., from left to right, level by level).

 

>[!example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)
>
>**Input**: `root = [3,9,20,null,null,15,7]`
>**Output**: `[[3],[9,20],[15,7]]
`

>[!Example]+ Example 2
>**Input**: `root = [1]`
>**Output**: `[[1]]
`

>[!Example]+ Example 3
>**Input**: `root = []`
>**Output**: `[]
`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 2000]`.
>
>- `-1000 <= Node.val <= 1000`
### Hints
>[!Hint]- Hint 1
>Use a queue to perform BFS.

---
## Solution

### Intuition
Use BFS.
Only change is use a for loop in the while loop to add the elements in the level first then go into the next steps.


### Approach
Use Queue to store next values is a new ArrayList and add the list to another list at the end of the level.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
       ;
        if(root !=null){
            q.offer(root);
        }
        
        while(!q.isEmpty()){
            ArrayList<Integer> sub= new ArrayList<>(); 
            for(int n=q.size();n>0;n--){
                TreeNode node = q.poll();
                sub.add(node.val);
                if(node.left !=null){
                    q.offer(node.left);
                }
                if(node.right !=null){
                    q.offer(node.right);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
```