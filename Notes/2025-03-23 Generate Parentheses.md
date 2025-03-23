---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 22
link: https://leetcode.com/problems/generate-parentheses
difficulty: Medium
tags:
  - leetcode/string
  - leetcode/dynamic-programming
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Generate Parentheses

## Question
Given `n` pairs of parentheses, write a function to *generate all combinations of well-formed parentheses*.

 

>[!Example]+ Example 1
>**Input**: `n = 3`
>**Output**: `["((()))","(()())","(())()","()(())","()()()"]
`

>[!Example]+ Example 2
>**Input**: `n = 1`
>**Output**: `["()"]
`

>[!warning]+ Constraints
>- `1 <= n <= 8`
### Hints
No hints available.

---
## Solution

### Intuition
Backtracking Problem.

Base case would be if Number of Open Brackets == Number of Closed Brackets and Number of Open Brackets = N.

There will also be 2 constraints:
1. If No of Open Brackets < No we can add more Open Brackets.
2. If No of Closed Brackets < No of Open Brackets add more Closed Brackets.


### Approach
Base case would be if Number of Open Brackets == Number of Closed Brackets and Number of Open Brackets = N.

There will also be 2 constraints:
1. If No of Open Brackets < No we can add more Open Brackets.
2. If No of Closed Brackets < No of Open Brackets add more Closed Brackets.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        build(s,n,0,0);
        return res;
    }
    
    public void build(StringBuilder s,int n,int countO,int countC) {
        if(countC==countO && countO==n){
            res.add(s.toString());
            return;
        }
        
        if(countO<n){
            s.append('(');
            build(s,n,countO+1,countC);
            s.deleteCharAt(s.length()-1);
        }
        
        if(countC<countO){
            s.append(')');
            build(s,n,countO,countC+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
```