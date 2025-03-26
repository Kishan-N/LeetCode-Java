---
created: 2025-03-26
modified: 
completed: true
leetcode-index: 208
link: https://leetcode.com/problems/implement-trie-prefix-tree
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/string
  - leetcode/design
  - leetcode/trie
  - programming/practice
  - leetcode/problem
---
# Implement Trie (Prefix Tree)

## Question
A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank">trie</a> (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

	
- `Trie()` Initializes the trie object.
	
- `void insert(String word)` Inserts the string `word` into the trie.
	
- `boolean search(String word)` Returns `true` if the string `word` is in the trie (i.e., was inserted before), and `false` otherwise.
	
- `boolean startsWith(String prefix)` Returns `true` if there is a previously inserted string `word` that has the prefix `prefix`, and `false` otherwise.

 

>[!Example]+ Example 1

>[!warning]+ Constraints
>- `1 <= word.length, prefix.length <= 2000`
>
>- `word` and `prefix` consist only of lowercase English letters.
>
>- At most `3 * 10^4` calls in total will be made to `insert`, `search`, and `startsWith`.
### Hints
No hints available.

---
## Solution

### Intuition
Create a new class called TrieNode that stores the children of the TrieNode and is the node is the las letter of a word or not;

To Insert for every letter in the word see if the Node has a child with the letter and if not create a new node and  add the letter.

To search its the same as add but we just need to return false if the Node does not have a child with current letter, and return the enOfWord parameter of the current TrieNode if the loop finishes.

searchPrefix is exactly the same as search but just return true instead of endOfWord since even if the word does not end the prefix is present in the Trie. 


### Approach
Added all points in intuition.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(cur.children[c - 'a'] == null){

                cur.children[c - 'a'] = new TrieNode();
            }
            cur =cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur =cur.children[c - 'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c:prefix.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur =cur.children[c - 'a'];
        }
        return true;
    }
}

```