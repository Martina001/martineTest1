//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
//
//
// 示例 1:
//
//
//
//
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
//
//
// 示例 2:
//
//
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
//
//
// 示例 3:
//
//
//输入: root = [], key = 0
//输出: []
//
//
//
// 提示:
//
//
// 节点数的范围 [0, 10⁴].
// -10⁵ <= NodeChildren.val <= 10⁵
// 节点值唯一
// root 是合法的二叉搜索树
// -10⁵ <= key <= 10⁵
//
//
//
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
// Related Topics 树 二叉搜索树 二叉树 👍 1165 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：删除二叉搜索树中的节点
public class DeleteNodeInABstXXX450 {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABstXXX450().new Solution();
// TO TEST
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(6, null, new TreeNode(7));
        TreeNode r = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.left = r;
        root.right = l;
        TreeNode treeNode = solution.deleteNode(root, 7);
        System.out.println(treeNode);
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
        public TreeNode deleteNode(TreeNode root, int key) {
//            TreeNode treeNode = circleDelete(root, key);
            TreeNode treeNode = traverse(root, key);
            return treeNode;
        }

        /**
         * 递归并且承接的方式 可以有效的传入当前节点的父节点，相较于循环（迭代）来说会看起来更整洁一些，但是需要理解
         *
         * @param root
         * @param key
         * @return
         */
        private TreeNode traverse(TreeNode root, int key) {
            if (root == null) return null;
            int curVal = root.val;
            if (curVal == key) {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                // 先找到右子树的最左节点
                TreeNode rightMin = getRightMin(root.right);
                // 然后删除右子树中的最左节点
                root.right = traverse(root.right, rightMin.val);

                // 替换当前节点为rightMin
                rightMin.left = root.left;
                rightMin.right = root.right;
                root = rightMin;
            } else if (key < curVal) {
                // 注意这里不是return traverse；而是和父节点互相传递
                root.left = traverse(root.left, key);
            } else {
                root.right = traverse(root.right, key);
            }
            return root;
        }

        private TreeNode getRightMin(TreeNode node) {
            TreeNode cur = node;
            while (cur != null && cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        private TreeNode circleDelete(TreeNode root, int key) {
            TreeNode cur = root;
            TreeNode curP = null;
            while (cur != null) {
                int curVal = cur.val;
                if (key == curVal) {
                    if (cur.right == null) {
                        cur = cur.left;
                        break;
                    } else if (cur.left == null) {
                        cur = cur.right;
                        break;
                    }
                    TreeNode p = cur;
                    TreeNode rightL = cur.right;
                    while (rightL != null && rightL.left != null) {
                        p = rightL;
                        rightL = rightL.left;
                    }
                    if (p.val == cur.val) {
                        p.right = rightL.right;
                    } else {
                        p.left = rightL.right;
                    }
                    rightL.left = cur.left;
                    rightL.right = cur.right;
                    cur = rightL;
                    break;
                } else if (key < curVal) {
                    curP = cur;
                    cur = cur.left;
                } else {
                    curP = cur;
                    cur = cur.right;
                }
            }
            if (curP == null) {
                return cur;
            }
            if (curP.left != null && curP.left.val == key) {
                curP.left = cur;
            } else {
                curP.right = cur;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}