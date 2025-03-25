---
created: 2025-03-25
modified: 
completed: true
leetcode-index: 17
link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
difficulty: Medium
tags:
  - leetcode/hash-table
  - leetcode/string
  - leetcode/backtracking
  - programming/practice
  - leetcode/problem
---
# Letter Combinations of a Phone Number

## Question
Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
![](https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png)

 

>[!Example]+ Example 1
>**Input**: `digits = "23"`
>**Output**: `["ad","ae","af","bd","be","bf","cd","ce","cf"]
`

>[!Example]+ Example 2
>**Input**: `digits = ""`
>**Output**: `[]
`

>[!Example]+ Example 3
>**Input**: `digits = "2"`
>**Output**: `["a","b","c"]
`

>[!warning]+ Constraints
>- `0 <= digits.length <= 4`
>
>- `digits[i]` is a digit in the range `['2', '9']`.
### Hints
No hints available.

---
## Solution

### Intuition
We need to store the keypad in a Data structure , I used a HashMap.
Now for every digit in digits we get its mapped characters and choose it or choose the next character.
We use i to point to the current index.



### Approach
for loop through all the characters for digit 1 and add it to the string. 
Increment current char i is pointing to in digits so it points to the next Character.
do the same for loop to the next set of characters as well.

![[Pasted image 20250325200711.png]]
### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.isEmpty()){
            return res;
        }

            
        build(digits,0,new StringBuilder());
        return res;
    }

    public void build(String digits,int i,StringBuilder s){
        if(i>=digits.length()){
            res.add(s.toString());
            return;
        }
        

        for(char c:map.get(digits.charAt(i)).toString().toCharArray()){
            s.append(c);
            build(digits,i+1,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
```