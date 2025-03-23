---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 1400
link: https://leetcode.com/problems/construct-k-palindrome-strings
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/string
  - leetcode/greedy
  - leetcode/counting
  - programming/practice
  - leetcode/problem
---
# Construct K Palindrome Strings

## Question
Given a string `s` and an integer `k`, return `true` if you can use all the characters in `s` to construct non-empty `k` <span data-keyword="palindrome-string">palindrome strings</span> or `false` otherwise.

 

>[!Example]+ Example 1
>**Input**: `s = "annabelle", k = 2`
>**Output**: `true`
>**Explanation**:
>You can construct two palindromes using all characters in s. Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b" 

>[!Example]+ Example 2
>**Input**: `s = "leetcode", k = 3`
>**Output**: `false`
>**Explanation**:
>It is impossible to construct 3 palindromes using all the characters of s. 

>[!Example]+ Example 3
>**Input**: `s = "true", k = 4`
>**Output**: `true`
>**Explanation**:
>The only possible solution is to put each character in a separate string. 

>[!warning]+ Constraints
>- `1 <= s.length <= 10^5`
>
>- `s` consists of lowercase English letters.
>
>- `1 <= k <= 10^5`
### Hints
>[!Hint]- Hint 1
>If the s.length < k we cannot construct k strings from s and answer is false.

>[!Hint]- Hint 2
>If the number of characters that have odd counts is > k then the minimum number of palindrome strings we can construct is > k and answer is false.

>[!Hint]- Hint 3
>Otherwise you can construct exactly k palindrome strings and answer is true (why ?).

---
## Solution

### Intuition
This is a type of problem where we need to focus on the properties of a valid input instead of finding the possible answers using an input.

If there are no even character counts then we need to have enough characters in the word with odd count while making sure its less than k if not we sill simply have characters left over in the word which is not a valid output hence return false.


### Approach
Maintain a frequency map and is number of odd characters are <=k return true.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.HashMap;

class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k) return false;

        HashMap<Character,Integer> count = new HashMap<>();

        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);
        }

        int oddCount=0;
        for(int freq:count.values()){
            if(freq%2==1) oddCount++; 
        }

        return oddCount<=k;
    }
}
```