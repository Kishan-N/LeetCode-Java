/*
 * @lc app=leetcode id=3289 lang=java
 *
 * [3289] The Two Sneaky Numbers of Digitville
 */

// @lc code=start
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[nums.length];
        int dupCount=0;
        for(int num:nums){
            freq[num]+=1;
            if(freq[num]>1){
                res[dupCount++]=num;
            }
            if(dupCount==2)
                return res;
        }
        return res;
    }
}
// @lc code=end

