---
created: 2025-03-22
modified: 
completed: true
leetcode-index: 122
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/dynamic-programming
  - leetcode/greedy
  - programming/practice
  - leetcode/problem
---
# Best Time to Buy and Sell Stock II

## Question
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i^th`day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return *the maximum profit you can achieve*.

 

>[!Example]+ Example 1
>**Input**: `prices = [7,1,5,3,6,4]`
>**Output**: `7`
>**Explanation**:
 Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

>[!Example]+ Example 2
>**Input**: `prices = [1,2,3,4,5]`
>**Output**: `4`
>**Explanation**:
>Buy on day 1 (price = 
> 1) and sell on day 5 (price = 
> 5) , profit = 5-1 = 4. Total profit is 4. 

>[!Example]+ Example 3
>**Input**: `prices = [7,6,4,3,1]`
>**Output**: `0`
>**Explanation**:
>There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0. 

>[!warning]+ Constraints
>- `1 <= prices.length <= 3 * 10^4`
>
>- `0 <= prices[i] <= 10^4`
### Hints
No hints available.

---
## Solution

### Intuition
The problem tells you to find the max profit you can achieve with multiple transactions.
Try to get the sum of profits where profit > 0 and you will get the ans.

Disclaimer:
Don't try to find a way to get only the transactions with highest profit which will minimize the number of transactions.
We can get the same by adding the profits between 2 consecutive days is profit is >0.

### Approach
Find diff between prev day and curr day and is profit > 0 ad to maxProfit.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-prices[i-1];
            if(profit>0)
                maxProfit+=profit;
        }
        return maxProfit;
    }
}
```