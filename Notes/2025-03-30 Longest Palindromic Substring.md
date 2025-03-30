---
created: 2025-03-30
modified: 
completed: true
leetcode-index: 5
link: https://leetcode.com/problems/longest-palindromic-substring
difficulty: Medium
tags:
  - leetcode/two-pointers
  - leetcode/string
  - leetcode/dynamic-programming
  - programming/practice
  - leetcode/problem
---
# Longest Palindromic Substring

## Question
Given a string `s`, return *the longest* <span data-keyword="palindromic-string">*palindromic*</span> <span data-keyword="substring-nonempty">*substring*</span> in `s`.

 

>[!Example]+ Example 1
>**Input**: `s = "babad"`
>**Output**: `"bab"`
>**Explanation**:
>"aba" is also a valid answer. 

>[!Example]+ Example 2
>**Input**: `s = "cbbd"`
>**Output**: `"bb"
`

>[!warning]+ Constraints
>- `1 <= s.length <= 1000`
>
>- `s` consist of only digits and English letters.
### Hints
>[!Hint]- Hint 1
>How can we reuse a previously computed palindrome to compute a larger palindrome?

>[!Hint]- Hint 2
>If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?

>[!Hint]- Hint 3
>Complexity based hint:
>If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.

---
## Solution

### Intuition
We can take every character as the center of the string and getting the substrings for both even and odd cases and checking if its a palindrome or not.

Instead of checking if its a palindrome every time we can optimize the algorithm by making save if a substring i a palindrome or not and for a new substring we check if the inner substring is a palindrome or not instead of checking it through an algorithm.


### Approach
Focus on the if condition:
We check if outermost letters in the substring is same or not.
If it is the same we check if inner substring is palindrome or if the length of outer substring is <= 2, and since its a palindrome if the starting letters are same we store it as true and reuse when required.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public String longestPalindrome(String s) {
        int i,j;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] resIndex = new int[2];
        int resLen=-1;
        for(i=0;i<s.length();i++){
            for(j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1]==true)){
                    dp[j][i]=true;
                    if(resLen<i-j+1){
                        resLen=i-j+1;
                        resIndex[0]=j;
                        resIndex[1]=i;
                    }
                    
                }
            }
        }
        return s.substring(resIndex[0],resIndex[1]+1);
    }
}
```