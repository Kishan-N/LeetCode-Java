---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 121
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
difficulty: Easy
tags:
  - leetcode/array
  - leetcode/dynamic-programming
  - programming/practice
  - leetcode/problem
---
# Best Time to Buy and Sell Stock

## Question
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i^th` day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

 

>[!Example]+ Example 1
>**Input**: `prices = [7,1,5,3,6,4]`
>**Output**: `5`
>**Explanation**:
>Buy on day 2 (price = 
> 1) and sell on day 5 (price = 
> 6) , profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell. 

>[!Example]+ Example 2
>**Input**: `prices = [7,6,4,3,1]`
>**Output**: `0`
>**Explanation**:
>In this case, no transactions are done and the max profit = 0. 

>[!warning]+ Constraints
>- `1 <= prices.length <= 10^5`
>
>- `0 <= prices[i] <= 10^4`
### Hints
No hints available.

---
## Solution

### Intuition
Use 2 pointers left=0 and right=1


### Approach
if left is smaller than right calc profit and check if its bigger than pre profit else left=right.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0,r=1;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                maxProfit=Math.max(maxProfit,prices[r]-prices[l]);
            }
            else
                l=r;
            r++;
        }
        return maxProfit;
    }
}
```