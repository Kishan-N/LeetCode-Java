---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2469
link: https://leetcode.com/problems/convert-the-temperature
difficulty: Easy
tags:
  - leetcode/math
  - programming/practice
  - leetcode/problem
---
# Convert the Temperature

## Question
You are given a non-negative floating point number rounded to two decimal places `celsius`, that denotes the temperature in Celsius.

You should convert Celsius into Kelvin and Fahrenheit and return it as an array `ans = [kelvin, fahrenheit]`.

Return *the array `ans`. *Answers within `10^-5` of the actual answer will be accepted.

Note that:

	
- `Kelvin = Celsius + 273.15`
	
- `Fahrenheit = Celsius * 1.80 + 32.00`

 

>[!Example]+ Example 1
>**Input**: `celsius = 36.50`
>**Output**: `[309.65000,97.70000]`
>**Explanation**:
>Temperature at 36.50 Celsius converted in Kelvin is 309.65 and converted in Fahrenheit is 97.70. 

>[!Example]+ Example 2
>**Input**: `celsius = 122.11`
>**Output**: `[395.26000,251.79800]`
>**Explanation**:
>Temperature at 122.11 Celsius converted in Kelvin is 395.26 and converted in Fahrenheit is 251.798. 

>[!warning]+ Constraints
>- `0 <= celsius <= 1000`
### Hints
>[!Hint]- Hint 1
>Implement formulas that are given in the statement.

---
## Solution

### Intuition
Simple Calculation.


### Approach
Simple Calculation.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0]=celsius+273.15;
        res[1]=celsius * 1.80 + 32.00;
        return res;
    }
}
```