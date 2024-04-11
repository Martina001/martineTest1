//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= NodeChildren.val <= 1000
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2034 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

import java.util.Objects;

//Java：K 个一组翻转链表
public class ReverseNodesInKGroupXXX25 {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroupXXX25().new Solution();
// TO TEST
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(5);
        d.next = e;
        ListNode listNode = solution.reverseKGroup(a, 2);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (Objects.isNull(head)) return null;
            ListNode a = head, b = head;
            for (int i = 0; i < k; i++) {
                if (null == b) return head;
                b = b.next;
            }
            //此时b已经指向了第k+1个元素,开始反转a-b
            ListNode newHead = reverseFromAToB(a, b);
            // 每次就把原来的头节点的next指向下一次翻转的结果
            a.next = reverseKGroup(b, k);
            return newHead;
        }

        /**
         * 翻转从a到b
         *
         * @param a
         * @param b
         * @return
         */
        public ListNode reverseFromAToB(ListNode a, ListNode b) {
            ListNode pre = null, cur = a;
            while (cur != b) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}