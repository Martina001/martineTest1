//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1628 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的最大深度
public class MaximumDepthOfBinaryTreeXXX104 {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTreeXXX104().new Solution();
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
        int res = 0;

        /**
         * 递归获取树的最大深度
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            /*int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            res = Math.max(leftMaxDepth, rightMaxDepth) + 1;
            return res;*/
            return breadthFirstGetMaxDepth(root);
        }

        List<TreeNode> list = new ArrayList<>();

        /**
         * 层序遍历
         *
         * @param root
         * @return
         */
        public List<TreeNode> breadthFirst(TreeNode root) {
            if (root == null) return list;
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            while (!que.isEmpty()) {
                TreeNode node = que.poll();
                list.add(node);
                if (null != node.left) {
                    que.offer(node.left);
                }
                if (null != node.right) {
                    que.offer(node.right);
                }
            }
            return list;
        }

        /**
         * 层序遍历获取树的最大高度
         *
         * @param root
         * @return
         */
        public int breadthFirstGetMaxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> stack = new LinkedList<>();
            stack.offer(root);
            int h = 0;
            while (!stack.isEmpty()) {
                int size = stack.size();
                h++;
                while (size > 0) {
                    TreeNode node = stack.poll();
                    if (null != node.left) {
                        stack.offer(node.left);
                    }
                    if (null != node.right) {
                        stack.offer(node.right);
                    }
                    size--;
                }
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}