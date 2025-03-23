/*
 * @lc app=leetcode id=1108 lang=java
 *
 * [1108] Defanging an IP Address
 */

// @lc code=start
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder(address.length()+6);
        int i=0;
        while(i<address.length()){
            char curr = address.charAt(i);
            if(curr == '.'){
                res.append("[.]");
            }else
                res.append(curr);
            i++;
        }
        return res.toString();
    }
}
// @lc code=end

