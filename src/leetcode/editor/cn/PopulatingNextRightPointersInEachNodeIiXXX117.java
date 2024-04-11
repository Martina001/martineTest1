//给定一个二叉树： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。 
//
// 初始状态下，所有 next 指针都被设置为 NULL 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 6000] 内 
// -100 <= Node.val <= 100 
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。 
// 
//
// 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 834 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.Node;

import java.util.LinkedList;
import java.util.Queue;

//Java：填充每个节点的下一个右侧节点指针 II
public class PopulatingNextRightPointersInEachNodeIiXXX117{
public static void main(String[] args) {
Solution solution = new PopulatingNextRightPointersInEachNodeIiXXX117().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // 非完美二叉树的填充和完美二叉树的填充（116题） 都可以用层序遍历，简单清晰
        // 但是性能不够好
//        breadthDeal(root);
        // 我们来看一下每一层当成一个链表实现，重点在于添加一个dummy头节点
        Node cur = root;
        while(cur != null){
            // 每层循环都加一个dummy头节点，pre用来往后走
            Node dummy = new Node(0);
            Node pre = dummy;
            while(cur != null){
                // 当前层为cur的下层。pre指向了下层
                if(cur.left != null){
                    pre.next  = cur.left;
                    pre = pre.next;
                }
                if(cur.right != null){
                    pre.next  = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // cur进入下层循环，此时dummy.next就是下层的链表：pre为头节点，一直到最右侧节点
            cur = dummy.next;
        }
        return root;
    }


    private void breadthDeal(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for(int i =sz;i>=1;i--){
                Node node = queue.poll();
                if (i != 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}