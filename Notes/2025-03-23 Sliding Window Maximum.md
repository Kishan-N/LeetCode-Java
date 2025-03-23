---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 239
link: https://leetcode.com/problems/sliding-window-maximum
difficulty: Hard
tags:
  - leetcode/array
  - leetcode/queue
  - leetcode/sliding-window
  - leetcode/heap-priority-queue
  - leetcode/monotonic-queue
  - programming/practice
  - leetcode/problem
---
# Sliding Window Maximum

## Question
You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return *the max sliding window*.

 

>[!Example]+ Example 1
>**Input**: `nums = [1,3,-1,-3,5,3,6,7], k = 3`
>**Output**: `[3,3,5,5,6,7]`
>**Explanation**:
>Window position                Max ---------------               ----- [1  3  -1] -3  5  3  6  7       3  1 [3  -1  -3] 5  3  6  7       3  1  3 [-1  -3  5] 3  6  7       5  1  3  -1 [-3  5  3] 6  7       5  1  3  -1  -3 [5  3  6] 7       6  1  3  -1  -3  5 [3  6  7]      7 

>[!Example]+ Example 2
>**Input**: `nums = [1], k = 1`
>**Output**: `[1]
`

>[!warning]+ Constraints
>- `1 <= nums.length <= 10^5`
>
>- `-10^4 <= nums[i] <= 10^4`
>
>- `1 <= k <= nums.length`
### Hints
>[!Hint]- Hint 1
>How about using a data structure such as deque (double-ended queue)?

>[!Hint]- Hint 2
>The queue size need not be the same as the window’s size.

>[!Hint]- Hint 3
>Remove redundant elements and the queue should store only elements that need to be considered.

---
## Solution

### Intuition
You will need to keep track of the max in the window if the max moved out of the window.
Use a Deque to do that.

EG:

assume q= [5,4,2]
new element is 3
we need to check with last element and remove elements until new element is < q.lastElement.

hence, q=[5,4,3]

Like this q will always have the max element at first and next max element at 2nd index and so on ...



### Approach
Maintain a Deque to add INDEXES of new max elements and remove INDEXES of old max elements.
Every time window is >=k we can add the First ele from queue to res and move left pointer.
If left index is > Index from q.first remove q.first.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int l=0,r=0;
        for(r=0;r<nums.length;r++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[r])
                q.removeLast();
            q.addLast(r);
            if(l>q.getFirst())
                q.removeFirst();
            if((r+1)>=k){
                res[l]=nums[q.getFirst()];
                l++;
            }
        }
        return res;
    }
}
```