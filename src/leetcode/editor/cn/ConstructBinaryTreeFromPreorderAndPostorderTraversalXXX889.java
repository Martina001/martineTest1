//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 315 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：根据前序和后序遍历构造二叉树
public class ConstructBinaryTreeFromPreorderAndPostorderTraversalXXX889 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversalXXX889().new Solution();
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if (null == preorder || postorder == null || preorder.length == 0 || postorder.length == 0) return null;
            return traverse(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd) return null;
            // 当preStart == preEnd时候，就return当前节点
            // 这里比较容易忽略，因为preStart一直在++，一定要注意，以防下一步preStart+1已经超过了前序总长度
            if (preStart == preEnd) return new TreeNode(preorder[preStart]);
            int leftRootVal = preorder[preStart + 1];
            int postIndex = 0;
            for (int i = 0; i < postorder.length; i++) {
                if (postorder[i] == leftRootVal) {
                    postIndex = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            // 这时候用的是左子树的根节点leftRootVal来计算postIndex，所以左子树的节点数要加上leftRootVal，也就是+1
            int leftSize = postIndex - postStart + 1;
            root.left = traverse(preorder, preStart + 1, preStart + leftSize, postorder, postStart, postIndex - 1);
            root.right = traverse(preorder, preStart + leftSize + 1, preEnd, postorder, postIndex + 1, postEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}