---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 199
link: https://leetcode.com/problems/binary-tree-right-side-view
difficulty: Medium
tags:
  - leetcode/tree
  - leetcode/depth-first-search
  - leetcode/breadth-first-search
  - leetcode/binary-tree
  - programming/practice
  - leetcode/problem
---
# Binary Tree Right Side View

## Question
Given the `root` of a binary tree, imagine yourself standing on the right side of it, return *the values of the nodes you can see ordered from top to bottom*.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png)
>
>**Input**: `root = [1,2,3,null,5,null,4]`
>**Output**: `[1,3,4]`
>**Explanation**:
>![](https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png) 

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png)
>
>**Input**: `root = [1,2,3,4,null,null,null,5]`
>**Output**: `[1,3,4,5]`
>**Explanation**:
>![](https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png) 

>[!Example]+ Example 3
>**Input**: `root = [1,null,3]`
>**Output**: `[1,3]`

>[!Example]+ Example 4
>**Input**: `root = []`
>**Output**: `[]`

>[!warning]+ Constraints
>- The number of nodes in the tree is in the range `[0, 100]`.
>
>- `-100 <= Node.val <= 100`
### Hints
No hints available.

---
## Solution

### Intuition
At Each level print add 1 element to res list from the right. 


### Approach
2 Methods :

DFS:
DFS the tree but perform the right side first instead of left and keep track of the depth/level.

If level == size(res) then add current node val to res.
No else

BFS:
Use a loop in the while loop the go through all the elements at every level until the rightmost node.
 Make sure in the inner loop is you are using q.size in the loop q.size will change when new elements get added.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
//DFS
/* class Solution {

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root,int depth) {
        if(root==null)
            return;
            
        if(depth == res.size())
            res.add(root.val);

        dfs(root.right,depth + 1);
        dfs(root.left,depth + 1);
    }
} */


//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root!=null)
            q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = null;
            for(int n=q.size();n>0;n--){
                node = q.poll();
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            res.add(node.val);
        }
        return res;

    }
}

```