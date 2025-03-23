---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 3
link: https://leetcode.com/problems/longest-substring-without-repeating-characters
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/string
  - leetcode/sliding-window
  - programming/practice
  - leetcode/problem
---
# Longest Substring Without Repeating Characters

## Question
Given a string `s`, find the length of the longest <span data-keyword="substring-nonempty">substring</span> without duplicate characters.

 

>[!Example]+ Example 1
>**Input**: `s = "abcabcbb"`
>**Output**: `3`
>**Explanation**:
>The answer is "abc", with the length of 3. 

>[!Example]+ Example 2
>**Input**: `s = "bbbbb"`
>**Output**: `1`
>**Explanation**:
>The answer is "b", with the length of 1. 

>[!Example]+ Example 3
>**Input**: `s = "pwwkew"`
>**Output**: `3`
>**Explanation**:
>The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. 

>[!warning]+ Constraints
>- `0 <= s.length <= 5 * 10^4`
>
>- `s` consists of English letters, digits, symbols and spaces.
### Hints
>[!Hint]- Hint 1
>Generate all possible substrings & check for each substring if it's valid and keep updating maxLen accordingly.

---
## Solution

### Intuition
Need something to store chars in window so will use hashset.
if element in hashset will shrink window until it isnt.


### Approach
sliding window and hashset.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res=0;
        int l=0,r=0;
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
```