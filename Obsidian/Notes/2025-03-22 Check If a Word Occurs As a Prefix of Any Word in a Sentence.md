---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 1455
link: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
difficulty: Easy
tags:
  - leetcode/two-pointers
  - leetcode/string
  - leetcode/string-matching
  - programming/practice
  - leetcode/problem
---
# Check If a Word Occurs As a Prefix of Any Word in a Sentence

## Question
Given a `sentence` that consists of some words separated by a single space, and a `searchWord`, check if `searchWord` is a prefix of any word in `sentence`.

Return *the index of the word in *`sentence`* (1-indexed) where *`searchWord`* is a prefix of this word*. If `searchWord` is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return `-1`.

A prefix of a string `s` is any leading contiguous substring of `s`.

 

>[!Example]+ Example 1
>**Input**: `sentence = "i love eating burger", searchWord = "burg"`
>**Output**: `4`
>**Explanation**:
>"burg" is prefix of "burger" which is the 4th word in the sentence. 

>[!Example]+ Example 2
>**Input**: `sentence = "this problem is an easy problem", searchWord = "pro"`
>**Output**: `2`
>**Explanation**:
>"pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index. 

>[!Example]+ Example 3
>**Input**: `sentence = "i am tired", searchWord = "you"`
>**Output**: `-1`
>**Explanation**:
>"you" is not a prefix of any word in the sentence. 

>[!warning]+ Constraints
>- `1 <= sentence.length <= 100`
>
>- `1 <= searchWord.length <= 10`
>
>- `sentence` consists of lowercase English letters and spaces.
>
>- `searchWord` consists of lowercase English letters.
### Hints
>[!Hint]- Hint 1
>First extract the words of the sentence.

>[!Hint]- Hint 2
>Check for each word if searchWord occurs at index 0, if so return the index of this word (1-indexed)

>[!Hint]- Hint 3
>If searchWord doesn't exist as a prefix of any word return the default value (-1).

---
## Solution

### Intuition
Split on " " and check if word startswith input word.


### Approach
Split on " " and check if word startswith input word.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(searchWord))
                return i+1;
        }
        return -1;
    }
}
```