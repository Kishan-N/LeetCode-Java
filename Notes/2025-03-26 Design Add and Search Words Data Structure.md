---
created: 2025-03-26
modified: 
completed: true
leetcode-index: 211
link: https://leetcode.com/problems/design-add-and-search-words-data-structure
difficulty: Medium
tags:
  - leetcode/string
  - leetcode/depth-first-search
  - leetcode/design
  - leetcode/trie
  - programming/practice
  - leetcode/problem
---
# Design Add and Search Words Data Structure

## Question
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the `WordDictionary` class:

	
- `WordDictionary()` Initializes the object.
	
- `void addWord(word)` Adds `word` to the data structure, it can be matched later.
	
- `bool search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise. `word` may contain dots `'.'` where dots can be matched with any letter.

 

Example:

`
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
`

 

>[!warning]+ Constraints
>- `1 <= word.length <= 25`
>
>- `word` in `addWord` consists of lowercase English letters.
>
>- `word` in `search` consist of `'.'` or lowercase English letters.
>
>- There will be at most `2` dots in `word` for `search` queries.
>
>- At most `10^4` calls will be made to `addWord` and `search`.
### Hints
>[!Hint]- Hint 1
>You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.

---
## Solution

### Intuition
Just Create a normal Trie for until the add function.

For the search function we have to backtrack every node in the Trie from the curr node if the curr letter is a '.'

To do this we call a DFS function in the search function with index 0 and pass the root of the Trie as well.

In the DFS function we use the same logic as a normal Trie but in case the current letter is a '.' we backtrack for every choice available in the Trie from the current node. 


### Approach
We use a for loop with i starting from j to length of the word and add an if to check if the character is '.'

If the character is a '.' go through all the children of the current child and pass it to the DFS function to start backtracking.

Make sure the current child is not null and return true once DFS is at the last level.
If the loop finished and dint return true it means a match was not found so we return false.

The remaining is the same as a regular Trie.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0,root,word);
    }

    public boolean dfs(int j,TrieNode root,String word) {
        TrieNode cur = root;
        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c == '.'){
                for(TrieNode child: cur.children){
                    if(child != null && dfs(i+1,child,word))
                        return true;
                }
                return false;
            }
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.endOfWord;
    }
}

```