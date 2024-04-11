//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= NodeChildren.val <= 2³¹ - 1
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2050 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：验证二叉搜索树
public class ValidateBinarySearchTreeXXX98 {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTreeXXX98().new Solution();
// TO TEST
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4, null, null);
        TreeNode r = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        root.left = l;
        root.right = r;
        boolean validBST = solution.isValidBST(root);

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
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
//        boolean res = traverse(root,root.val,null);
            boolean res = traverse(root, null, null);
            return res;
        }

        private boolean traverse(TreeNode node, TreeNode min, TreeNode max) {
            if (node == null) return true;
            if (min != null && node.val <= min.val) return false;
            if (max != null && node.val >= max.val) return false;
            // 限定左右子树的最值即可
            return traverse(node.left, min, node) && traverse(node.right, node, max);
        }


        // 错误解法
    /*private boolean traverse(TreeNode root,int parentVal,String isLeft){
        if(null == root) return true;
        // 注意，二叉搜索树的节点是不允许重复的
        if(root.left != null){
            if(root.left.val >= root.val || ("Y".equalsIgnoreCase(isLeft) && root.left.val >= parentVal) || ("N".equalsIgnoreCase(isLeft) && root.left.val <= parentVal)){
                return false;
            }
        }
        if(root.right != null ){
            if(root.right.val <= root.val || ("Y".equalsIgnoreCase(isLeft) && root.right.val >= parentVal) || ("N".equalsIgnoreCase(isLeft) && root.right.val <= parentVal)){
                return false;
            }
        }
        return traverse(root.left,root.val,"Y") && traverse(root.right,root.val,"N");
    }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}