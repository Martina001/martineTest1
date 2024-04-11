//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1990 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversalXXX105 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversalXXX105().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (null == preorder || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
            return traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if(preStart>preEnd){
                return null;
            }
            int rootVal = preorder[preStart];
            int inorderRootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    inorderRootIndex = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(rootVal);

            // 重点是根据中序数组中根节点的位置判断左子树在前序数组中的长度：inorderRootIndex-inStart
            // 另外注意要preStart+1
            root.left = traverse(preorder, preStart+1, preStart + (inorderRootIndex-inStart), inorder, inStart, inorderRootIndex-1);
            root.right = traverse(preorder, preStart + (inorderRootIndex-inStart)+1, preEnd, inorder, inorderRootIndex + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}