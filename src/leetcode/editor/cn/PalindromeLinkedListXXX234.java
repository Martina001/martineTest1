//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= NodeChildren.val <= 9
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1650 👎 0

package leetcode.editor.cn;
//Java：回文链表
public class PalindromeLinkedListXXX234{
public static void main(String[] args) {
Solution solution = new PalindromeLinkedListXXX234().new Solution();
// TO TEST
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
    public boolean isPalindrome(ListNode head) {
// 所以可以截取后半部分的链表进行反转
        // 需要注意的是，使用length找中间节点的方式当节点数为偶数时返回的是中间靠右的那个节点，而使用快慢指针可以根据循环结束条件决定找到的是中间靠左or靠右的节点；length为奇数时两者一致。
        // 这里需要获取前半段的最后一个节点，所以应该使用快慢指针而非使用len/2轮询
        /*if(head == null || head.next == null){
            return true;
        }
        ListNode halfNode = endOfHalfNew(head);
        // 反转的时候已经把halfNode.next（newTailhead）本身就是反转链表的末尾节点，也就是newTailhead.next为置为null了,原来链表的末节点也就是newTailhead了
        ListNode reverseTail = reverseListNode(halfNode.next);

        ListNode p1 = head;
        ListNode p2 = reverseTail;
        // 注意一定是后半部分短一些
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1= p1.next;
            p2 = p2.next;
        }
        // 重新反转以保持head不变，不然不够完整，把人家head都截断了
        halfNode.next = reverseListNode(reverseTail);
        return true;*/
        if(head == null ) return true;
        ListNode midNode = endOfHalfNew(head);
        ListNode reverseN = reverseListNode(midNode.next);
        ListNode temp = reverseN;
        ListNode tHead = head;
        while(temp != null){
            if(tHead.val != temp.val) return false;
            tHead = tHead.next;
            temp = temp.next;
        }
        return true;
    }
    ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head ;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 也可以记录前一个指针去找到两个节点的偏左节点
    private ListNode endOfHalfNew(ListNode head){
        // if(head == null) return head;
        ListNode f = head;
        ListNode s = head;
        ListNode pre=null;
        while(f != null && f.next != null){
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        if(f == null){
            // 偶数
            return pre;
        }
        if(f.next == null){
            // 奇数
            return s;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
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
    }}
}