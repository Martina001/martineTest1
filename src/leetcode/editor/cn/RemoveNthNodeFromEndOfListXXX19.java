//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= NodeChildren.val <= 100
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2497 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;

//Java：删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfListXXX19{
public static void main(String[] args) {
Solution solution = new RemoveNthNodeFromEndOfListXXX19().new Solution();
// TO TEST
    ListNode a = new  ListNode(1);
    ListNode b = new  ListNode(2);
    ListNode c = new  ListNode(3);
    a.next = b;b.next = c;
    ListNode d = new  ListNode(4);
    c.next = d;
    ListNode e = new  ListNode(5);
    d.next = e;
    solution.removeNthFromEnd(a,5);
    PriorityQueue<ListNode> pq = new PriorityQueue<>(2, (x, y)->(x.val - y.val));
    System.out.println();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*ListNode dummy = new ListNode(-1);
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
        dummy.next = head;
        for(int i =0;i<n;i++){
            if(fast == null) return head;
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return dummy.next;*/
        // 尝试写一次栈 LinkedList属于是双向链表，可以当队列也可以当栈
        // 注意LinkedList的add是addLast，对应是removeLast；
        // push是addFirst，pop对应removeFirst
        /*if(head == null) return null;
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode t = head;
        while(t != null){
            stack.push(t);
            t = t.next;
        }
        ListNode pop = null;
        for(int i = 0;i<n;i++){
             pop = stack.pop();
        }
        // 一看这里的判断就知道是可以优化的，那么该怎么优化呢？见下文
        if(stack.isEmpty()){
            return pop.next;
        }else{
            stack.pop().next = null == pop.next?null:pop.next;
        }
        return head;*/
       LinkedList<ListNode> stack = new LinkedList<>();

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // dummy的存在就是为了能够让stack一直不会为empty，就很棒棒
        ListNode t = dummy;
        while(t != null){
            stack.push(t);
            t = t.next;
        }
        for(int i =0;i<n;i++){
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}