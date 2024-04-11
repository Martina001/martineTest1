//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
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
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1489 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：二叉树展开为链表
public class FlattenBinaryTreeToLinkedListXXX114 {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedListXXX114().new Solution();
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
        public void flatten(TreeNode root) {
            if (root == null) return;
            flat(root);
//            traverse(root);
//            afterTrav(root);
        }

        /**
         * 很明显这道题是需要拿到左右子树的信息之后再进行拼接，所以是后序遍历
         * @param root
         */
        private void flat(TreeNode root){
            if(root == null) return ;
            flat(root.left);
            flat(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;

            TreeNode cur = root;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = right;
        }



        /**
         * 原地展开，后续遍历
         *
         * @param root
         */
        public void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.left);
            traverse(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;

            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right;
        }

        /**
         * 后续遍历的变种，先右后左，遍历
         */
        TreeNode preNode = null;

        private void afterTrav(TreeNode root) {
            if (root == null) return;
            // 注意是先右后左
            afterTrav(root.right);
            afterTrav(root.left);

            root.left = null;
            root.right = preNode;
            preNode = root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}