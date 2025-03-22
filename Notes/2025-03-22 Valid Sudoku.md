---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 36
link: https://leetcode.com/problems/valid-sudoku
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/hash-table
  - leetcode/matrix
  - programming/practice
  - leetcode/problem
---
# Valid Sudoku

## Question
Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

	
1. Each row must contain the digits `1-9` without repetition.
	
2. Each column must contain the digits `1-9` without repetition.
	
3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.

Note:

	
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	
- Only the filled cells need to be validated according to the mentioned rules.

 

>[!Example]+ Example 1
>![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)
>
>**Input**: `board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]`
>**Output**: `true
`

>[!Example]+ Example 2
>**Input**: `board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]`
>**Output**: `false`
>**Explanation**:
>Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid. 

>[!warning]+ Constraints
>- `board.length == 9`
>
>- `board[i].length == 9`
>
>- `board[i][j]` is a digit `1-9` or `'.'`.
### Hints
No hints available.

---
## Solution

### Intuition
Use HashMaps for with HasSets as values to store values is rows, cols and squares.
Values should not repeat in any of these set.


### Approach
Use 2 for loops to loop through every cell and calc square by creating a String to denote each Square (String square = row/3 +","+col/3).

### Complexity

#### Time complexity
O(1)/O(N^2)

#### Space complexity
O(1)/O(N^3)

### Code
---
```java
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        HashMap<String,HashSet<Character>> squares = new HashMap<>();
        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++){
                if (board[row][col] == '.') continue;
                String square = row/3 +","+col/3;
                if( rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) || 
                    cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                    squares.computeIfAbsent(square, k -> new HashSet<>()).contains(board[row][col]))
                    return false;
                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(square).add(board[row][col]);
            }
        }
        return true;
    }
}
```