//给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。 
//
// 提醒一下， 二叉搜索树 满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 
//输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 100] 范围内。 
// 0 <= Node.val <= 100 
// 树中的所有值均 不重复 。 
// 
//
// 
//
// 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 282 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：从二叉搜索树到更大和树
public class BinarySearchTreeToGreaterSumTreeXXX1038{
public static void main(String[] args) {
Solution solution = new BinarySearchTreeToGreaterSumTreeXXX1038().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        // 每个节点的值就是其大于等于val值的累加和，由于是二叉搜索树，所以相当于右中左遍历后的右中的累加
        traverse(root);
        return root;
    }

    int sum = 0;
    private TreeNode traverse(TreeNode root){
        if(root == null) return null;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
        return  root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}