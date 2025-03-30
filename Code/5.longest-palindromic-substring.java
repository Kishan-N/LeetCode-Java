/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int i,j;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] resIndex = new int[2];
        int resLen=-1;
        for(i=0;i<s.length();i++){
            for(j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1]==true)){
                    dp[j][i]=true;
                    if(resLen<i-j+1){
                        resLen=i-j+1;
                        resIndex[0]=j;
                        resIndex[1]=i;
                    }
                    
                }
            }
        }
        return s.substring(resIndex[0],resIndex[1]+1);
    }
}
// @lc code=end

