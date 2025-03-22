/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four


Binary Search Sol:
int l=0;
        int r = n;
        if(n>=Integer.MAX_VALUE)
            return false;
        int mid;
        while(l<r){
            mid=l+(r-l)/2;
            int pow=(int) Math.pow(4,(int) mid) ;
            if(pow == n)
                return true;
            if(pow<n){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return false;

using no loop(check if Math.log(n,4) is an integer to see if n is perfect):
if (n <= 0) {
            return false;
        }
return Math.log(n)/Math.(4) % 1 == 0;

 */
// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        
        return true;
    }
}
// @lc code=end

