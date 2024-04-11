//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= NodeChildren.val <= 100
// 
//
// Related Topics 递归 链表 👍 1801 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

//Java：两两交换链表中的节点
public class SwapNodesInPairsXXX24 {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairsXXX24().new Solution();
// TO TEST
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(5);
//    d.next = e;
        ListNode listNode = solution.swapPairs(a);
        System.out.println(listNode.val);
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
        public ListNode swapPairs1(ListNode head) {
            if (null == head || null == head.next) return head;
            // 本题重点是掌握什么时候递归，怎么交换
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode cur = pre;
            while (cur.next != null && cur.next.next != null) {
                ListNode begin = cur.next;
                ListNode next = cur.next.next;
                cur.next = next;
                begin.next = next.next;
                next.next = begin;
                cur = begin;
            }
            return pre.next;
        }

        /*private ListNode swap(ListNode a) {
            if(a == null) return null;
            ListNode s = swapW(a,a.next);
            return swap(s.next.next);
        }*/
        private ListNode swapW(ListNode a, ListNode b) {
            if (null == a) return b;
            if (null == b) return a;
            ListNode next = b.next;
            a.next = next;
            b.next = a;
            return b;
        }

        /**
         * 递归解法
         *
         * @param head
         * @return
         */
        public ListNode swapPairs11(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs11(next.next);
            next.next = head;
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}