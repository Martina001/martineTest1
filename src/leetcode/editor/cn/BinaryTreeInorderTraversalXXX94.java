//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2054 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的中序遍历
public class BinaryTreeInorderTraversalXXX94{
public static void main(String[] args) {
Solution solution = new BinaryTreeInorderTraversalXXX94().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 先写递归
//        traverse(root);
//        return res;
        // 再写迭代
//        return stackMid(root);
        // 这个更好
//        return stackMid1(root);
        // 这个最统一，但是效率稍低，可记忆
        return stackMidOrderTraverse(root);
    }

    private void traverse(TreeNode node){
        if(node == null) return;
        traverse(node.left);
        res.add(node.val);
        traverse(node.right);
    }

    private List<Integer> stackMidOrderTraverse(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                node = stack.pop();
                // 中序遍历为左中右 所以入栈顺序为右中左
                if(node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
                if(node.left != null) stack.push(node.left);
            }
            // 遇到了中节点
            else{
                // 先pop空节点
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    private List<Integer> stackMid1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 先把左节点遍历push进去，直到遇到最左子节点
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 然后遍历父节点的右节点，再从该节点的左节点重复遍历
                // 这里说明一下为啥可以找到父节点的右节点，因为root本身在一直遍历，有一个判断root != null才往左走的判断
                // 其实就是用栈保存了父节点，这一点一定要搞清楚
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


    private List<Integer> stackMid(TreeNode root){
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 注意点：1。 linkedList实现栈和队列的不同 2。循环将左节点加入stack的写法
        // 3。只要stack不为空 或者 当前节点不为null都别结束循环
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}