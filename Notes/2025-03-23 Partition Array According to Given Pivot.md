---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 2161
link: https://leetcode.com/problems/partition-array-according-to-given-pivot
difficulty: Medium
tags:
  - leetcode/array
  - leetcode/two-pointers
  - leetcode/simulation
  - programming/practice
  - leetcode/problem
---
# Partition Array According to Given Pivot

## Question
You are given a 0-indexed integer array `nums` and an integer `pivot`. Rearrange `nums` such that the following conditions are satisfied:

	
- Every element less than `pivot` appears before every element greater than `pivot`.
	
- Every element equal to `pivot` appears in between the elements less than and greater than `pivot`.
	
- The relative order of the elements less than `pivot` and the elements greater than `pivot` is maintained.

- More formally, consider every p<sub> i </sub>, p<sub>j</sub> where p<sub>i</sub> is the new position of the `i^th` element and p<sub>j</sub> is the new position of the `j^th` element. If `i < j` and both elements are smaller (*or larger*) than `pivot`, then p<sub>i</sub> < p<sub>j</sub> .


Return `nums`* after the rearrangement.*

 

>[!Example]+ Example 1
>**Input**: `nums = [9,12,5,10,14,3,10], pivot = 10`
>**Output**: `[9,5,3,10,10,12,14]`
>**Explanation**:
>The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array. The elements 12 and 14 are greater than the pivot so they are on the right side of the array. The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings. 

>[!Example]+ Example 2
>**Input**: `nums = [-3,4,3,2], pivot = 2`
>**Output**: `[-3,2,4,3]`
>**Explanation**:
>The element -3 is less than the pivot so it is on the left side of the array. The elements 4 and 3 are greater than the pivot so they are on the right side of the array. The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings. 

>[!warning]+ Constraints
>- `1 <= nums.length <= 10^5`
>
>- `-10^6 <= nums[i] <= 10^6`
>
>- `pivot` equals to an element of `nums`.
### Hints
>[!Hint]- Hint 1
>Could you put the elements smaller than the pivot and greater than the pivot in a separate list as in the sequence that they occur?

>[!Hint]- Hint 2
>With the separate lists generated, could you then generate the result?

---
## Solution

### Intuition
Just have to go through nums twice, instead you can use left and right pointers to make it one pass.


### Approach
Use left and right pointers to go through nums and if left is smaller than pivot add to left of res and if right is greater that pivot add to right of res.
If left pointer is <= right pointer in res fill left with pivot.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int left=0,right=nums.length-1;
        for(int i=0, j=nums.length-1;i<nums.length;i++,j--){
            if(nums[i]<pivot){
                res[left]=nums[i];
                left++;
            }
            if(nums[j]>pivot){
                res[right]=nums[j];
                right--;
            }
        }
        while(left<=right){
            res[left]=pivot;
            left++;
        }
        return res;
    }
}
```