//给你一个链表的头节点 head 。 
//
// 链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目
//。换句话说： 
//
// 
// 节点 1 分配给第一组 
// 节点 2 和 3 分配给第二组 
// 节点 4、5 和 6 分配给第三组，以此类推 
// 
//
// 注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。 
//
// 反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,6,3,9,1,7,3,8,4]
//输出：[5,6,2,3,9,1,4,8,3,7]
//解释：
//- 第一组长度为 1 ，奇数，没有发生反转。
//- 第二组长度为 2 ，偶数，节点反转。
//- 第三组长度为 3 ，奇数，没有发生反转。
//- 最后一组长度为 4 ，偶数，节点反转。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,1,0,6]
//输出：[1,0,1,6]
//解释：
//- 第一组长度为 1 ，没有发生反转。
//- 第二组长度为 2 ，节点反转。
//- 最后一组长度为 1 ，没有发生反转。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [2,1]
//输出：[2,1]
//解释：
//- 第一组长度为 1 ，没有发生反转。
//- 最后一组长度为 1 ，没有发生反转。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目范围是 [1, 10⁵] 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 链表 👍 30 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

//Java：反转偶数长度组的节点
public class ReverseNodesInEvenLengthGroupsXXX2074 {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInEvenLengthGroupsXXX2074().new Solution();
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
        public ListNode reverseEvenLengthGroups(ListNode head) {
            ListNode node = head;
            int groupSize = 2;
            while (node.next != null) {
                ListNode beforeGroup = node;
                ListNode lastOne = node;
                int tempSize = 0;
                while (tempSize < groupSize && lastOne.next != null) {
                    lastOne = lastOne.next;
                    tempSize++;
                }
                if (tempSize % 2 == 0) {
                    ListNode afterGroup = lastOne.next;
                    ListNode start = beforeGroup.next;
                    ListNode pre = null, curr = start;
                    for (int i = 0; i < tempSize; i++) {
                        ListNode next = curr.next;
                        curr.next = pre;
                        pre = curr;
                        curr = next;
                    }
                    beforeGroup.next = pre;
                    start.next = afterGroup;

                    // 记录下一个group的beforeGroup节点
                    node = start;
                } else {
                    node = lastOne;
                }
                groupSize++;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}