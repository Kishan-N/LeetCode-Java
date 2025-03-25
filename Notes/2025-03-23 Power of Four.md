---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 342
link: https://leetcode.com/problems/power-of-four
difficulty: Easy
tags:
  - leetcode/math
  - leetcode/bit-manipulation
  - leetcode/recursion
  - programming/practice
  - leetcode/problem
---
# Power of Four

## Question
Given an integer `n`, return *`true` if it is a power of four. Otherwise, return `false`*.

An integer `n` is a power of four, if there exists an integer `x` such that `n == 4^x`.

 

>[!Example]+ Example 1
>**Input**: `n = 16`
>**Output**: `true
`

>[!Example]+ Example 2
>**Input**: `n = 5`
>**Output**: `false
`

>[!Example]+ Example 3
>**Input**: `n = 1`
>**Output**: `true
`

>[!warning]+ Constraints
>- `-2^31 <= n <= 2^31 - 1`
>
>
>
>
>
>
>Follow up: Could you solve it without loops/recursion?
### Hints
No hints available.

---
## Solution

### Intuition
We can check every number to find the perfect number.
Use binary search to optimize the search.


### Approach
Binary Search.

There is also another solution which uses maths.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
Binary Search Sol:
int l=0;
        int r = n;
        if(n>=Integer.MAX_VALUE)
            return false;
        int mid;
        while(l<r){
            mid=l+(r-l)/2;
            int pow=(int) Math.pow(4,(int) mid) ;
            if(pow == n)
                return true;
            if(pow<n){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return false;

Without Binary Search Sol:
if (n <= 0) {
            return false;
        }
return Math.log(n)/Math.(4) % 1 == 0;
```