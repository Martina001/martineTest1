//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2768 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

//Java：合并 K 个升序链表
public class MergeKSortedListsXXX23 {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedListsXXX23().new Solution();
// TO TEST
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
        // 方法1 顺序循环合并
        // 方法2 归并递归合并，每次合并merge(lists,l,r) 找mid 再mergeTwo 见提交记录1
        // 方法3 优先队列合并
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            for (int i = 0; i < lists.length; i++) {
                res = mergeTwo(res, lists[i]);
            }
            return res;
        }

        private ListNode mergeTwo(ListNode a, ListNode b) {
            if (null == a) {
                return b;
            }
            if (null == b) {
                return a;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    cur.next = a;
                    a = a.next;
                } else {
                    cur.next = b;
                    b = b.next;
                }
                cur = cur.next;
            }
            if (a != null) {
                cur.next = a;
            }
            if (b != null) {
                cur.next = b;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}