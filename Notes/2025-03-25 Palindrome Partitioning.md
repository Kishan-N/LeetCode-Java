---
created: 2025-03-25
modified: 
completed: true
leetcode-index: 131
link: https://leetcode.com/problems/palindrome-partitioning
difficulty: Medium
tags:
  - leetcode/string
  - leetcode/dynamic-programming
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Palindrome Partitioning

## Question
Given a string `s`, partition `s` such that every <span data-keyword="substring-nonempty">substring</span> of the partition is a <span data-keyword="palindrome-string">palindrome</span>. Return *all possible palindrome partitioning of *`s`.

 

>[!Example]+ Example 1
>**Input**: `s = "aab"`
>**Output**: `[["a","a","b"],["aa","b"]]
`

>[!Example]+ Example 2
>**Input**: `s = "a"`
>**Output**: `[["a"]]
`

>[!warning]+ Constraints
>- `1 <= s.length <= 16`
>
>- `s` contains only lowercase English letters.
### Hints
No hints available.

---
## Solution

### Intuition
Backtracking
In backtracking logic we make a choice of taking i or not and for each i we select the subset of i to s.length() and make the same decision.


### Approach
Use a for loop to start from i and end at s.length().
every loop check if the substring is a palindrome.
If it is then add to subres and pass to function as i is choosen.
and then Remove i again.

![[Pasted image 20250325195048.png]]
### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> sub = new ArrayList<>();
    public List<List<String>> partition(String s) {
        build(s,0);
        return res;
    }

    public void build(String s,int i) {
        if(i>=s.length()){
            res.add(new ArrayList(sub));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)){
                sub.add(s.substring(i,j+1));
                build(s,j+1);
                sub.remove(sub.size()-1);
            }
        }
    }

    public boolean isPali(String s,int l,int r) {
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            r--;
            l++;
        }
        return true;
    }
}
```