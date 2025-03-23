---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2942
link: https://leetcode.com/problems/find-words-containing-character
difficulty: Easy
tags:
  - leetcode/array
  - leetcode/string
  - programming/practice
  - leetcode/problem
---
# Find Words Containing Character

## Question
You are given a 0-indexed array of strings `words` and a character `x`.

Return *an array of indices representing the words that contain the character *`x`.

Note that the returned array may be in any order.

 

>[!Example]+ Example 1
>**Input**: `words = ["leet","code"], x = "e"`
>**Output**: `[0,1]`
>**Explanation**:
>"e" occurs in both words: "l<u>ee</u>t", and "cod<u>e</u>". Hence, we return indices 0 and 1. 

>[!Example]+ Example 2
>**Input**: `words = ["abc","bcd","aaaa","cbc"], x = "a"`
>**Output**: `[0,2]`
>**Explanation**:
>"a" occurs in "<u>a</u>bc", and "<u>aaaa</u>". Hence, we return indices 0 and 2. 

>[!Example]+ Example 3
>**Input**: `words = ["abc","bcd","aaaa","cbc"], x = "z"`
>**Output**: `[]`
>**Explanation**:
>"z" does not occur in any of the words. Hence, we return an empty array. 

>[!warning]+ Constraints
>- `1 <= words.length <= 50`
>
>- `1 <= words[i].length <= 50`
>
>- `x` is a lowercase English letter.
>
>- `words[i]` consists only of lowercase English letters.
### Hints
>[!Hint]- Hint 1
>Use two nested loops.

---
## Solution

### Intuition
Nested loop


### Approach
Nested loop


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int j =0;j<words.length;j++){
            String s= words[j];
            for(int i=0;i<s.length();i++)
                if(s.charAt(i) == x){
                    res.add(j);
                    break;
                }
        }
        return res;
    }
}
```