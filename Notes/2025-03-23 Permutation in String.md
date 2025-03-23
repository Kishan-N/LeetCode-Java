---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 567
link: https://leetcode.com/problems/permutation-in-string
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/two-pointers
  - leetcode/string
  - leetcode/sliding-window
  - programming/practice
  - leetcode/problem
---
# Permutation in String

## Question
Given two strings `s1` and `s2`, return `true` if `s2` contains a <span data-keyword="permutation-string">permutation</span> of `s1`, or `false` otherwise.

In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.

 

>[!Example]+ Example 1
>**Input**: `s1 = "ab", s2 = "eidbaooo"`
>**Output**: `true`
>**Explanation**:
>s2 contains one permutation of s1 ("ba"). 

>[!Example]+ Example 2
>**Input**: `s1 = "ab", s2 = "eidboaoo"`
>**Output**: `false
`

>[!warning]+ Constraints
>- `1 <= s1.length, s2.length <= 10^4`
>
>- `s1` and `s2` consist of lowercase English letters.
### Hints
>[!Hint]- Hint 1
>Obviously, brute force will result in TLE. Think of something else.

>[!Hint]- Hint 2
>How will you check whether one string is a permutation of another string?

>[!Hint]- Hint 3
>One way is to sort the string and then compare. But, Is there a better way?

>[!Hint]- Hint 4
>If one string is a permutation of another string then they must have one common metric. What is that?

>[!Hint]- Hint 5
>Both strings must have same character frequencies, if  one is permutation of another. Which data structure should be used to store frequencies?

>[!Hint]- Hint 6
>What about hash table?  An array of size 26?

---
## Solution

### Intuition
Create frequency count of both strings of length of first string.
now keep moving the window with size of first string and update the count for second string and keep checking if  counts are same.


### Approach
Create frequency count of both strings of length of first string.
now keep moving the window with size of first string and update the count for second string and keep checking if  counts are same.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] s1c= new int[26];
        int[] s2c= new int[26];
        int l=0,r=0;
        for(r=0;r<s1.length();r++){
            s1c[s1.charAt(r)-'a']++;
            s2c[s2.charAt(r)-'a']++;
        }
        while(r<s2.length()){
            if(Arrays.equals(s1c, s2c)){
                return true;
            }
            s2c[s2.charAt(r)-'a']++;
            s2c[s2.charAt(l)-'a']--;
            l++;
            r++;
        }
        if(Arrays.equals(s1c, s2c)){
            return true;
        }
        return false;
    }
}
```