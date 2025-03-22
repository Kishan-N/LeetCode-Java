/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
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
// @lc code=end

