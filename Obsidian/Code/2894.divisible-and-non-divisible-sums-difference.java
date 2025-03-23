/*
 * @lc app=leetcode id=2894 lang=java
 *
 * [2894] Divisible and Non-divisible Sums Difference
 */

// @lc code=start
class Solution {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for(int i=1;i<=n;i++){
            res += (i%m==0)? -1*i:i;
        }
        return res;
    }
}
// @lc code=end

