/*
 * @lc app=leetcode id=2181 lang=java
 *
 * [2181] Merge Nodes in Between Zeros
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int sum=0;
        while(head!=null){
            sum+=head.val;
            if(head.val==0){
                ListNode node = new ListNode(sum);
                dummy.next = node;
                dummy = node;
                sum=0;
            }
            head=head.next;
        }
    return res.next.next;
    }
}
// @lc code=end

