---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2181
link: https://leetcode.com/problems/merge-nodes-in-between-zeros
difficulty: Medium
tags:
  - leetcode/linked-list
  - leetcode/simulation
  - programming/practice
  - leetcode/problem
---
# Merge Nodes in Between Zeros

## Question
You are given the `head` of a linked list, which contains a series of integers separated by `0`'s. The beginning and end of the linked list will have `Node.val == 0`.

For every two consecutive `0`'s, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any `0`'s.

Return *the* `head` *of the modified linked list*.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2022/02/02/ex1-1.png)
>
>**Input**: `head = [0,3,1,0,4,5,2,0]`
>**Output**: `[4,11]`
>**Explanation**:
>The above figure represents the given linked list. The modified list contains - The sum of the nodes marked in green: 3 + 1 = 4. - The sum of the nodes marked in red: 4 + 5 + 2 = 11. 

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2022/02/02/ex2-1.png)
>
>**Input**: `head = [0,1,0,3,0,2,2,0]`
>**Output**: `[1,3,4]`
>**Explanation**:
>The above figure represents the given linked list. The modified list contains - The sum of the nodes marked in green: 1 = 1. - The sum of the nodes marked in red: 3 = 3. - The sum of the nodes marked in yellow: 2 + 2 = 4. 

>[!warning]+ Constraints
>- The number of nodes in the list is in the range `[3, 2 * 10^5]`.
>
>- `0 <= Node.val <= 1000`
>
>- There are no two consecutive nodes with `Node.val == 0`.
>
>- The beginning and end of the linked list have `Node.val == 0`.
### Hints
>[!Hint]- Hint 1
>How can you use two pointers to modify the original list into the new list?

>[!Hint]- Hint 2
>Have a pointer traverse the entire linked list, while another pointer looks at a node that is currently being modified.

>[!Hint]- Hint 3
>Keep on summing the values of the nodes between the traversal pointer and the modifying pointer until the former comes across a ‘0’. In that case, the modifying pointer is incremented to modify the next node.

>[!Hint]- Hint 4
>Do not forget to have the next pointer of the final node of the modified list point to null.

---
## Solution

### Intuition
Just go through the Linked List while node is not null.
Carry the rolling Sum and if the val of node is 0 then create a new node with val sum and add it to dummy node.
Return the start of new Linked List at the end.

### Approach
Just go through the Linked List while node is not null.
Carry the rolling Sum and if the val of node is 0 then create a new node with val sum and add it to dummy node.
Return the start of new Linked List at the end.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int sum=0;
        while(head!=null){
            sum+=head.val;
            if(head.val==0){
                ListNode node = new ListNode(sum);
                dummy.next = node;
                dummy = node;
                sum=0;
            }
            head=head.next;
        }
    return res.next.next;
    }
}
```