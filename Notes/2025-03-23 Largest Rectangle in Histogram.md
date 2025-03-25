---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 84
link: https://leetcode.com/problems/largest-rectangle-in-histogram
difficulty: Hard
tags:
  - leetcode/array
  - leetcode/stack
  - leetcode/monotonic-stack
  - programming/practice
  - leetcode/problem
---
# Largest Rectangle in Histogram

## Question
Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return *the area of the largest rectangle in the histogram*.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)
>
>**Input**: `heights = [2,1,5,6,2,3]`
>**Output**: `10`
>**Explanation**:
>The above is a histogram where width of each bar is 1. The largest rectangle is shown in the red area, which has an area = 10 units. 

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg)
>
>**Input**: `heights = [2,4]`
>**Output**: `4
`

>[!warning]+ Constraints
>- `1 <= heights.length <= 10^5`
>
>- `0 <= heights[i] <= 10^4`
### Hints
No hints available.

---
## Solution

### Intuition
We push the Height and index of the column every time.
Before pushing we see if the prev column height is greater than top column or not.

If yes we take the top column and calculate the area and maxArea.
we do this until current height is > top height.

1 Very important part is we usually push the current index with the height but if the column height is less we have to push the index of prev column with height lowest height since the area can go until the lowest height column.


### Approach
We can use Pair to push height and index.
the index pushed is mostly the current index but for small columns we get the index of the recently popped column and push that.

Also don't forget to calculate the area for columns still remaining in the stack.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int maxArea=0;
        
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!stack.isEmpty() && stack.peek().getval()>heights[i]){
                    Pair<Integer,Integer> pair = stack.pop();
                    int height = pair.getval();
                    int width = pair.getkey();
                    maxArea = Math.max(maxArea,height*(i-width));
                    start = width;
            }
            stack.push(new Pair<>(start, heights[i]));
        }
        for(Pair<Integer,Integer> p: stack){
                int height = p.getval();
                int width = p.getkey();
                maxArea = Math.max(maxArea,height*(heights.length-width));
        }
        return maxArea;
    }

    
}

class Pair<K, V>{

    private K key;
    private V value;

    public Pair(K key,V value){
        this.key=key;
        this.value=value;
    }

    public K getkey(){
        return key;
    }

    public V getval(){
        return value;
    }
}
```