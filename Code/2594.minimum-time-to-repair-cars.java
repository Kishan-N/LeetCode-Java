/*
 * @lc app=leetcode id=2594 lang=java
 *
 * [2594] Minimum Time to Repair Cars
 */

// @lc code=start
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
// @lc code=end

