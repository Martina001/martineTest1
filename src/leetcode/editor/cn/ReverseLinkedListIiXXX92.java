//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= NodeChildren.val <= 500
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1541 👎 0

package leetcode.editor.cn;

//Java：反转链表 II
public class ReverseLinkedListIiXXX92 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIiXXX92().new Solution();
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
        ListNode listNode = solution.reverseBetween(a, 3, 5);
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            /*ListNode pre = new ListNode(-1);
            pre.next = head;
            int i = 0;
            while (pre != null && i < left - 1) {
                pre = pre.next;
                i++;
            }
            ListNode midHead = pre.next;
            ListNode tailHead = midHead;
            while (tailHead != null && i < right - 1) {
                tailHead = tailHead.next;
                i++;
            }
            ListNode rNode = tailHead.next;
            tailHead.next = null;
            ListNode reverseNode = reverseList(midHead);
            pre.next = reverseNode;
            while(reverseNode != null && reverseNode.next != null){
                reverseNode = reverseNode.next;
            }
            reverseNode.next = rNode;
            ListNode res = left == 1?pre.next:head;
            return res;*/

            // 方法1，单独反转left-right之间的部分，然后重新接进来
            /*if (head == null || left <= 0 || left > right) return null;
            // 记得不要直接用pre = newListNode(-1),而是用dummy保存一下起始节点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;

            for(int i =0;i < left-1;i++) {
                pre = pre.next;
            }
            ListNode midHead = pre.next;
            ListNode tailHead = pre;
            // 注意这里的判断条件 r-l+1
            for(int i =0;i < right-left+1;i++) {
                tailHead = tailHead.next;
            }

            ListNode rNode = tailHead == null ? null : tailHead.next;
            tailHead.next = null;

            ListNode reverseNode = reverseList(midHead);
            pre.next = reverseNode;
            if (rNode != null) {
                midHead.next = rNode;
            }
            return dummy.next;*/

            // 方法二：只遍历一次，直接指定到对应位置
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            int i = 0;
            while (pre != null && i < left - 1) {
                pre = pre.next;
                i++;
            }
            ListNode cur = pre.next;
            ListNode next;
            int k = 0;
            while(k < right-left){
                // 每次把后一位插入前面
                next = cur.next;
                cur.next =next.next;
                next.next = pre.next;
                pre.next = next;

                k++;
            }
            return dummy.next;

        }

        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}