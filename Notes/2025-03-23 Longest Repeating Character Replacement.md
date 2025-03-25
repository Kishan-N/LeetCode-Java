---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 424
link: https://leetcode.com/problems/longest-repeating-character-replacement
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/string
  - leetcode/sliding-window
  - programming/practice
  - leetcode/problem
---
# Longest Repeating Character Replacement

## Question
You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return *the length of the longest substring containing the same letter you can get after performing the above operations*.

 

>[!Example]+ Example 1
>**Input**: `s = "ABAB", k = 2`
>**Output**: `4`
>**Explanation**:
>Replace the two 'A's with two 'B's or vice versa. 

>[!Example]+ Example 2
>**Input**: `s = "AABABBA", k = 1`
>**Output**: `4`
>**Explanation**:
>Replace the one 'A' in the middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest repeating letters, which is 4. There may exists other ways to achieve this answer too.

>[!warning]+ Constraints
>- `1 <= s.length <= 10^5`
>
>- `s` consists of only uppercase English letters.
>
>- `0 <= k <= s.length`
### Hints
No hints available.

---
## Solution

### Intuition
Sliding Window

You always have to invert the Character that is less frequent in the array so keep the count of the character with highest occurrence in maxChar.

The lees frequent chars can be calculated using windowsize - maxChar 

If the windowsize - maxChar value is more than K decrease the window.


### Approach
keep increasing window and decrease if the windowsize - maxChar is greater that K
If the maxChar value is more than K decrease the window.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int minChar=0;
        int l=0,r=0;
        while(r<s.length()){
            char curr=s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            maxChar=Math.max(maxChar,map.get(curr));
            while((r-l+1)-maxChar>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
```