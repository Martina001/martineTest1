//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= NodeChildren.val <= 1000
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1022 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的最小深度
public class MinimumDepthOfBinaryTreeXXX111 {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTreeXXX111().new Solution();
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
        int res = Integer.MAX_VALUE;
        int depth = 0;

        public int minDepth(TreeNode root) {
            /*if (root == null) return 0;
            traverse(root);
            return res;*/
//            int i = breadthFirstFindMinDepth(root);
            int i = traverGetMinDepth(root);
            return i;
        }

        /**
         * 前序遍历，递归找最小深度
         *
         * @param root
         */
        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (root.left == null && root.right == null) {
                res = Math.min(res, depth);
            }
            traverse(root.left);
            traverse(root.right);
            depth--;
        }

        /**
         * 广度优先遍历获取最小深度
         *
         * @param root
         * @return
         */
        private int breadthFirstFindMinDepth(TreeNode root) {
            Queue<TreeNode> stack = new LinkedList<>();
            stack.offer(root);
            int h = 0;
            while (!stack.isEmpty()) {
                int size = stack.size();
                h++;
                while (size > 0) {
                    TreeNode node = stack.poll();
                    if (node.left == null && node.right == null) return h;
                    if (node.left != null) stack.offer(node.left);
                    if (node.right != null) stack.offer(node.right);
                    size--;
                }
            }
            return h;
        }

        /**
         * 递归找最小深度，
         *
         * @param root
         * @return
         */
        private int traverseGetMin(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.right == null && root.left == null) return 1;
            int res = Integer.MAX_VALUE;
            if (root.left != null) {
                res = Math.min(traverseGetMin(root.left), res);
            }
            if (root.right != null) {
                res = Math.min(traverseGetMin(root.right), res);
            }
            // 注意不能写成以下这种，不然对只有一个子树的情况就只会返回1
            // 理解了这个之后就很容易理解下面的解法了
            /*int minChild = Math.min(traverseGetMin(root.left),traverseGetMin(root.right));
            res = Math.min(res,minChild);*/
            return res + 1;
        }

        /**
         * 递归找最小深度，略难理解
         *
         * @param root
         * @return
         */
        private int traverGetMinDepth(TreeNode root) {
            if (root == null) return 0;
            int minLeft = traverGetMinDepth(root.left);
            int minRight = traverGetMinDepth(root.right);
            // 注意这里，没有直接return min(left,right)+1就是为了排除只有单个子树的情况
            if (root.left == null || root.right == null) return minRight + minLeft + 1;
            return Math.min(minRight, minLeft) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}