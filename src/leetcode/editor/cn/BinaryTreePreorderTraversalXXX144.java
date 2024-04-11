//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1235 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.*;

//Java：二叉树的前序遍历
public class BinaryTreePreorderTraversalXXX144{
public static void main(String[] args) {
Solution solution = new BinaryTreePreorderTraversalXXX144().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // 先写一下递归
//        traverse(root);
        // 再写一下迭代
//        return breadthFirst(root);
        // 这里也记录一下和中序后序可以统一的一种写法，虽然比breadthFirst复杂，但是胜在可以一起记忆前中后序的写法
        return preOrderStackTraverse(root);
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    private List<Integer> breadthFirst(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        // 用栈 先进后出  所以先push右节点
        LinkedList<TreeNode> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

    private List<Integer> preOrderStackTraverse(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        // 用栈 先进后出  所以先push右节点
        LinkedList<TreeNode> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                // 先弹出 以防下面重复
                node = stack.pop();
                // 按照右左中的顺序入栈
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
                stack.push(node);
                // 在中节点后面跟一个空节点 用于判断
                stack.push(null);
            }
            // 遇到空节点的时候就可以把栈中的值弹出并保存到结果集了
            else{
                //先将空节点pop出来
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}