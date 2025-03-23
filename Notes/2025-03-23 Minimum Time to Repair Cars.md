---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2594
link: https://leetcode.com/problems/minimum-time-to-repair-cars
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/binary-search
  - programming/practice
  - leetcode/problem
---
# Minimum Time to Repair Cars

## Question
You are given an integer array `ranks` representing the ranks of some mechanics. ranks<sub>i</sub> is the rank of the i^th mechanic. A mechanic with a rank `r` can repair n cars in `r * n^2` minutes.

You are also given an integer `cars` representing the total number of cars waiting in the garage to be repaired.

Return *the minimum time taken to repair all the cars.*

Note: All the mechanics can repair the cars simultaneously.

 

>[!Example]+ Example 1
>**Input**: `ranks = [4,2,3,1], cars = 10`
>**Output**: `16`
>**Explanation**:
>- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes. - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes. - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes. - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes. It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​ 

>[!Example]+ Example 2
>**Input**: `ranks = [5,1,8], cars = 6`
>**Output**: `16`
>**Explanation**:
>- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes. - The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes. - The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes. It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​ 

>[!warning]+ Constraints
>- `1 <= ranks.length <= 10^5`
>
>- `1 <= ranks[i] <= 100`
>
>- `1 <= cars <= 10^6`
### Hints
>[!Hint]- Hint 1
>For a predefined fixed time, can all the cars be repaired?

>[!Hint]- Hint 2
>Try using binary search on the answer.

---
## Solution

### Intuition
Binary Search

We can find the minimum time between 1 and Time taken if all cars are given to rank 1 mechanic and check if the time is enough the fix the N cars.


### Approach
TimeTaken by 1 mechanic to repair N cars =  `r * n^2`
So for all mechanics to repair N cars we need to do a for loop on  `r * n^2`

We need to check if the time taken is enough to fix N cars so we for loop on SQRT(TimeTaken/r) >= n and keep improving on this time.

### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long minRank=Integer.MAX_VALUE;
        for(int rank:ranks)
            minRank=Math.min(rank, minRank);
        long right = minRank*cars*cars;

        while(left<right){
            long timeTaken=(left+right)/2;
            if(isTimeEnough(timeTaken,cars,ranks)){
                right = timeTaken;
            }
            else{
                left = timeTaken+1;
            }
        }
        return left;

    }

    public boolean isTimeEnough(long timeTaken,int cars,int[] ranks){
        int totalCars=0;
        for(int rank:ranks){
            totalCars+=Math.sqrt(timeTaken/rank);
        }
        if(totalCars>=cars) return true;
        return false;
    }
}
```