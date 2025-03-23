---
created: 2025-03-23
modified: 
completed: false
leetcode-index: 2011 
link: https://leetcode.com/problems/final-value-of-variable-after-performing-operations
difficulty: Easy 
tags:
   - leetcode/array
   - leetcode/string
   - leetcode/simulation 
   - programming/practice
   - leetcode/problem
---
# Final Value of Variable After Performing Operations

## Question
There is a programming language with only four operations and one variable `X`:

	
- `++X` and `X++` increments the value of the variable `X` by `1`.
	
- `--X` and `X--` decrements the value of the variable `X` by `1`.

Initially, the value of `X` is `0`.

Given an array of strings `operations` containing a list of operations, return *the final value of *`X` *after performing all the operations*.

 

>[!Example]+ Example 1
>**Input**: `operations = ["--X","X++","X++"]`
>**Output**: `1`
>**Explanation**:
>The operations are performed as follows: Initially, X = 0. --X: X is decremented by 1, X =  0 - 1 = -1. X++: X is incremented by 1, X = -1 + 1 =  0. X++: X is incremented by 1, X =  0 + 1 =  1. 

>[!Example]+ Example 2
>**Input**: `operations = ["++X","++X","X++"]`
>**Output**: `3`
>**Explanation**:
>The operations are performed as follows: Initially, X = 0. ++X: X is incremented by 1, X = 0 + 1 = 1. ++X: X is incremented by 1, X = 1 + 1 = 2. X++: X is incremented by 1, X = 2 + 1 = 3. 

>[!Example]+ Example 3
>**Input**: `operations = ["X++","++X","--X","X--"]`
>**Output**: `0`
>**Explanation**:
>The operations are performed as follows: Initially, X = 0. X++: X is incremented by 1, X = 0 + 1 = 1. ++X: X is incremented by 1, X = 1 + 1 = 2. --X: X is decremented by 1, X = 2 - 1 = 1. X--: X is decremented by 1, X = 1 - 1 = 0. 

>[!warning]+ Constraints
>- `1 <= operations.length <= 100`
>
>- `operations[i]` will be either `"++X"`, `"X++"`, `"--X"`, or `"X--"`.
### Hints
>[!Hint]- Hint 1
>There are only two operations to keep track of.

>[!Hint]- Hint 2
>Use a variable to store the value after each operation.

---
## Solution

### Intuition
<!--Describe your first thoughts on how to solve this problem -->


### Approach
<!-- Describe your approach to solving the problem. -->


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java

```