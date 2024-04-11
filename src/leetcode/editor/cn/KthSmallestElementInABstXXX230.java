//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= NodeChildren.val <= 10⁴
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 744 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：二叉搜索树中第K小的元素
public class KthSmallestElementInABstXXX230 {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABstXXX230().new Solution();
// TO TEST
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(1, null, new TreeNode(2));
        root.left = l;
        TreeNode r = new TreeNode(4);
        root.right = r;
//        int nodesNum = solution.getNodesNum(l);
        int i = solution.kthSmallest(root, 1);
        System.out.println(i);
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
        public int kthSmallest(TreeNode root, int k) {
            if (null == root || k <= 0) return -1;
//            traverse(root, k);
            res = getRes(root, k);
            return res;
        }

        public int res = 0;

        public int getRes(TreeNode root, int k) {
            TreeNode cur = root;
            while (cur != null) {
                // 获取左子树的节点总数
                int num = getNodesNum(cur.left);
                if (num == k - 1) break;
                if (num > k - 1) {
                    cur = cur.left;
                } else if (num < k - 1) {
                    cur = cur.right;
                    // 注意这里k要排掉左侧的计数，从右节点重新开始算
                    k = k - num -1;
                }
            }
            return cur.val;
        }

        /*public int rank = 0;

        // 二叉搜索树的中序遍历就是顺序的
        public void traverse(TreeNode root, int k) {
            if (root == null) return;
            traverse(root.left,k);
            rank ++;
            if(rank == k){
                res =root.val;
                return;
            }
            traverse(root.right, k);
        }*/


        /**
         * 获取树的节点总数
         *
         * @param root
         * @return
         */
        public int getNodesNum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftNodes = getNodesNum(root.left);
            int rightNodes = getNodesNum(root.right);
            return leftNodes + rightNodes + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}