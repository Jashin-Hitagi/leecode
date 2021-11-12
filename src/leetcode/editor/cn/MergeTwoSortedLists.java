package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2023 👎 0

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int b = 0;
        int val = l1.val + l2.val;
        if (val > 10){
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

    public ListNode getNext(ListNode l1, ListNode l2, int a){
        int b = 0;
        int val = l1.val + l2.val + a;
        if (val > 10){
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
            return getNext(new ListNode(0),l2.next,b);
        }else if (l2.next == null){
            return getNext(l1.next,new ListNode(0),b);
        }else {
            return getNext(l1.next,l2.next,b);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}