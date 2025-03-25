---
created: 2025-03-23
modified: 
completed: true
leetcode-index: 4
link: https://leetcode.com/problems/median-of-two-sorted-arrays
difficulty: Hard
tags:
  - leetcode/array
  - leetcode/binary-search
  - leetcode/divide-and-conquer
  - programming/practice
  - leetcode/problem
---
# Median of Two Sorted Arrays

## Question
Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays.

The overall run time complexity should be `O(log (m+n))`.

 

>[!Example]+ Example 1
>**Input**: `nums1 = [1,3], nums2 = [2]`
>**Output**: `2.00000`
>**Explanation**:
>merged array = [1,2,3] and median is 2. 

>[!Example]+ Example 2
>**Input**: `nums1 = [1,2], nums2 = [3,4]`
>**Output**: `2.50000`
>**Explanation**:
>merged array = [1,2,3,4] and median is (2 + 
> 3) / 2 = 2.5. 

>[!warning]+ Constraints
>- `nums1.length == m`
>
>- `nums2.length == n`
>
>- `0 <= m <= 1000`
>
>- `0 <= n <= 1000`
>
>- `1 <= m + n <= 2000`
>
>- `-10^6 <= nums1[i], nums2[i] <= 10^6`
### Hints
No hints available.

---
## Solution

### Intuition
You need to split the 2 arrays into 4 parts depending on a logic.
Use Binary search to get to a valid index to split 2 arrays into 4.

Find the median by using the left most or right most elements in the splits.


### Approach
<!-- Describe your approach to solving the problem. -->


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);

        int lenX = nums1.length;
        int lenY = nums2.length;

        int start = 0;
        int end = lenX;

        while(start<=end){
            int partX = (start+end)/2;
            int partY = ((lenX+lenY+1)/2)-partX;

            int XLeft = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            int XRight = partX==lenX?Integer.MAX_VALUE:nums1[partX];
            int YLeft = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            int YRight = partY==lenY?Integer.MAX_VALUE:nums2[partY];

            if(XLeft<=YRight && YLeft<=XRight){
                if((lenX+lenY)%2 == 0){
                    return ((double) Math.max(XLeft,YLeft)+Math.min(YRight,XRight))/2;
                }
                else
                    return Math.max(XLeft,YLeft);
            }
            if(XLeft > YRight)
                end=partX-1;
            if(YLeft > XRight)
                start=partX+1;
        }
        
        return 0;
    }
}
```