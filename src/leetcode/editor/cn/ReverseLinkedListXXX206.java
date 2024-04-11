//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= NodeChildren.val <= 5000
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3075 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

//Java：反转链表
public class ReverseLinkedListXXX206{
public static void main(String[] args) {
Solution solution = new ReverseLinkedListXXX206().new Solution();
// TO TEST
    ListNode a = new  ListNode(1);
    ListNode b = new  ListNode(2);
    ListNode c = new  ListNode(3);
    a.next = b;b.next = c;
    ListNode d = new  ListNode(4);
    c.next = d;
    ListNode e = new  ListNode(5);
    d.next = e;
    System.out.println(getMid(a).val);
    System.out.println(getMid(b).val);
    System.out.println(getMid(c).val);
    System.out.println(getMid(d).val);
    System.out.println(getMid(e).val);
}
private static ListNode getMid(ListNode head){
    ListNode fast = head;
    ListNode slow = head;
    ListNode pre = new ListNode(-1);
    pre.next = slow;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        pre = pre.next;
    }
    // fast为null时 偶
    if(fast == null){
        // 这时候可以按需选择返回中间两个节点的哪个节点，pre就是靠前那个，返回靠后那个就直接返回slow 用不上pre
        return pre;
    }else{
        return slow;
    }
}
private ListNode getKthDesc(ListNode head){
    Solution solution = new ReverseLinkedListXXX206().new Solution();
    ListNode reverseNode = solution.reverseList(head);
    // 找到a的倒数第k个链表节点（自己写的）：
    // 正常是用栈或者双指针（快指针先走k slow再走，等fast走到头slow就是倒数第k个节点）
    int k =6;
    ListNode dummy = new ListNode(-1);
    dummy.next  = reverseNode;
    ListNode temp = reverseNode;
    int i = 0;
    while (i < k-1 && temp!=null) {
        temp = temp.next;
        i++;
    }
    if(temp != null){
        temp.next = null;
    }
    ListNode listNode = solution.reverseList(dummy.next);
    return listNode;
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
    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion
}