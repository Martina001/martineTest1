//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1347 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：二叉树的直径
public class DiameterOfBinaryTreeXXX543 {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTreeXXX543().new Solution();
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
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            traverseFindDiameter(root);
            // 返回最大直径上的节点数-1
            return maxDiameterNodes - 1;
        }

        /**
         * 这个是递归找最大深度
         *
         * @param node
         * @return
         */
        public int traverse(TreeNode node) {
            if (node == null) return 0;
            int leftMax = traverse(node.left);
            int rightMax = traverse(node.right);
            return Math.max(leftMax, rightMax) + 1;
        }

        int maxDiameterNodes = 0;

        /**
         * 递归找最大直径上的节点数
         *
         * @param node
         * @return
         */
        public int traverseFindDiameter(TreeNode node) {
            if (node == null) return 0;
            int leftMax = traverseFindDiameter(node.left);
            int rightMax = traverseFindDiameter(node.right);
            // 每次都要和左右子树的节点数和再加一比较
            maxDiameterNodes = Math.max(maxDiameterNodes, leftMax + rightMax + 1);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}