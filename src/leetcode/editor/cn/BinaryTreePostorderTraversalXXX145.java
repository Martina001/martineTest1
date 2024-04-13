//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1166 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.*;

//Java：二叉树的后序遍历
public class BinaryTreePostorderTraversalXXX145 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversalXXX145().new Solution();
// TO TEST
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            // 先递归
       /* traverse(root);
        return res;*/
            // 再迭代
//            return stackPost(root);
            // 这个迭代简单一点
//            return stackPost1(root);
            // 这个最好
            return  stackPostorderTraversal(root);
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            traverse(root.right);
            res.add(root.val);
        }

        /**
         * 借助前序遍历的简单写法，然后再reverse
         *
         * @param root
         * @return
         */
        private List<Integer> stackPost1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                while (node.right != null) {
                    stack.push(node.right);
                }
            }
            Collections.reverse(res);
            return res;
        }

        /**
         * 前中后序都可以用这个套路写，最优，mark
         * 但是多入栈了null节点，所以相对来说空间复杂度稍高，不过也不影响
         * @param root
         * @return
         */
        private List<Integer> stackPostorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            Stack<TreeNode> st = new Stack<>();
            if (root != null) st.push(root);
            while (!st.empty()) {
                TreeNode node = st.peek();
                if (node != null) {
                    // 入栈顺序：中-右-左
                    st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                    st.push(node);                          // 添加中节点
                    st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                    if (node.right != null) st.push(node.right);  // 添加右节点（空节点不入栈）
                    if (node.left != null) st.push(node.left);    // 添加左节点（空节点不入栈）

                } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                    st.pop();           // 将空节点弹出
                    // 重新取出栈中元素
                    TreeNode pop = st.pop();
                    result.add(pop.val); // 加入到结果集
                }
            }
            return result;
        }

        /**
         * 后序遍历的迭代写法，较难理解 可以不看
         *
         * @param root
         * @return
         */
        private List<Integer> stackPost(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 这里真的神级理解才可以 晕了 以后再看吧
                if (root.right == null || root.right == pre) {
                    res.add(root.val);
                    pre = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}