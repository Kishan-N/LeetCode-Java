---
created: 2025-03-30
modified: 
completed: true
leetcode-index: 647
link: https://leetcode.com/problems/palindromic-substrings
difficulty: Medium
tags:
  - leetcode/two-pointers
  - leetcode/string
  - leetcode/dynamic-programming
  - programming/practice
  - leetcode/problem
---
# Palindromic Substrings

## Question
Given a string `s`, return *the number of palindromic substrings in it*.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

>[!Example]+ Example 1
>**Input**: `s = "abc"`
>**Output**: `3`
>**Explanation**:
>Three palindromic strings: "a", "b", "c". 

>[!Example]+ Example 2
>**Input**: `s = "aaa"`
>**Output**: `6`
>**Explanation**:
>Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa". 

>[!warning]+ Constraints
>- `1 <= s.length <= 1000`
>
>- `s` consists of lowercase English letters.
### Hints
>[!Hint]- Hint 1
>How can we reuse a previously computed palindrome to compute a larger palindrome?

>[!Hint]- Hint 2
>If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?

>[!Hint]- Hint 3
>Complexity based hint:
>If we use brute force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some previous computation?

---
## Solution

### Intuition
Same Logic as Longest palindromic Substring but make sure you start i from end of the string and j from i to the end of the string.

We just need to increment the count of valid palindrome and return the same.


### Approach



### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int countSubstrings(String s) {
        int i,j;
        int res=0;
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(i=n-1;i>=0;i--){
            for(j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==true)){
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }
}
```