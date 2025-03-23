---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 1108
link: https://leetcode.com/problems/defanging-an-ip-address
difficulty: Easy
tags:
  - leetcode/string
  - programming/practice
  - leetcode/problem
---
# Defanging an IP Address

## Question
Given a valid (IPv4) IP `address`, return a defanged version of that IP address.


A *defanged IP address* replaces every period `"."` with `"[.]"`.


 

>[!Example]+ Example 1
>**Input**: `address = "1.1.1.1"`
>**Output**: `"1[.]1[.]1[.]1"
`

>[!Example]+ Example 2
>**Input**: `address = "255.100.50.0"`
>**Output**: `"255[.]100[.]50[.]0"
`

>[!warning]+ Constraints
>- The given `address` is a valid IPv4 address.
### Hints
No hints available.

---
## Solution

### Intuition
If i == '.' append '[.]' else append i.


### Approach
If i == '.' append '[.]' else append i.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder(address.length()+6);
        int i=0;
        while(i<address.length()){
            char curr = address.charAt(i);
            if(curr == '.'){
                res.append("[.]");
            }else
                res.append(curr);
            i++;
        }
        return res.toString();
    }
}
```