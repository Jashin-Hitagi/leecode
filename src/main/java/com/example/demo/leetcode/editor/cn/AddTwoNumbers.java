package com.example.demo.leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7038 👎 0

public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0,getNext(l1,l2,0));
        return node.next;
    }

    //获取下一位指针
    public ListNode getNext(ListNode l1, ListNode l2, int a){
        //判断是否有进位
        int b = 0;
        int val = l1.val + l2.val + a;
        if (val >= 10){
            val = val - 10;
            b = 1;
        }
        if (l1.next == null && l2.next == null){
            if (b == 0){
                return new ListNode(val);
            }else {
                return new ListNode(val,new ListNode(1));
            }
        }else if (l1.next == null){
            return new ListNode(val,getNext(new ListNode(0), l2.next, b));
        }else if (l2.next == null){
            return new ListNode(val,getNext(l1.next, new ListNode(0), b));
        }else {
            return new ListNode(val, getNext(l1.next, l2.next, b));
        }
    }
}
//        //示例
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //res存放结果，cur为res的尾指针
//        ListNode res = new ListNode();
//        ListNode cur = res;
//        //表示进位
//        int carry = 0;
//        while (l1 != null || l2 != null){
//            //如果其中有一个到达结尾了，那么这个链表这一位的的数字就为0。
//            int a = l1 == null ? 0 : l1.val;
//            int b = l2 == null ? 0 : l2.val;
//            //两个链表的两位相加
//            int sum = a + b + carry;
//            //大于10进位
//            carry = sum / 10;
//            //进位完剩下的余数
//            sum %= 10;
//            //创建一个节点接入res后面
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            //分别后移
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        //如果最后还有进位的话，增加一个节点
//        if (carry == 1) cur.next = new ListNode(1);
//        return res.next;
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)

}