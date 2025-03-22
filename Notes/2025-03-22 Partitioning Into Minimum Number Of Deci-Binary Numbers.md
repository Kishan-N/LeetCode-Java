---
created: 2025-03-22
modified: 
completed: false
leetcode-index: 1689 
link: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
difficulty: Medium 
tags:
   - leetcode/string
   - leetcode/greedy 
   - programming/practice
   - leetcode/problem
---
# Partitioning Into Minimum Number Of Deci-Binary Numbers

## Question
A decimal number is called deci-binary if each of its digits is either `0` or `1` without any leading zeros. For example, `101` and `1100` are deci-binary, while `112` and `3001` are not.

Given a string `n` that represents a positive decimal integer, return *the minimum number of positive deci-binary numbers needed so that they sum up to *`n`*.*

 

>[!Example]+ Example 1
>**Input**: `n = "32"`
>**Output**: `3`
>**Explanation**:
>10 + 11 + 11 = 32 

>[!Example]+ Example 2
>**Input**: `n = "82734"`
>**Output**: `8
`

>[!Example]+ Example 3
>**Input**: `n = "27346209830709182346"`
>**Output**: `9
`

>[!warning]+ Constraints
>- `1 <= n.length <= 10^5`
>
>- `n` consists of only digits.
>
>- `n` does not contain any leading zeros and represents a positive integer.
### Hints
>[!Hint]- Hint 1
>Think about if the input was only one digit. Then you need to add up as many ones as the value of this digit.

>[!Hint]- Hint 2
>If the input has multiple digits, then you can solve for each digit independently, and merge the answers to form numbers that add up to that input.

>[!Hint]- Hint 3
>Thus the answer is equal to the max digit.

---
## Solution

### Intuition
Notice that the max digit in the number is always the answer because you need to add at the most max_digit * position in digit e.g if number is 3857 3000 + 800 + 50 + 70 so you have to split 800 into deci binary numbers.


### Approach
for loop to find max digit in the number and return the same. 


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int minPartitions(String n) {
        for(int i=9;i>=0;i--){
            if(n.contains(String.valueOf(i))){
                return i;
            }
        }
        return 0;
    }
}
```