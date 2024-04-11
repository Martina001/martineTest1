//给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。 
//
// 
//
// 示例 1: 
//
// 
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// 示例 2: 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= NodeChildren.val <= 10⁷
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 409 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：二叉搜索树中的搜索
public class SearchInABinarySearchTreeXXX700{
public static void main(String[] args) {
Solution solution = new SearchInABinarySearchTreeXXX700().new Solution();
// TO TEST
    TreeNode root = new TreeNode(5);
    TreeNode l = new TreeNode(4, null, null);
    TreeNode r = new TreeNode(6, new TreeNode(3), new TreeNode(7));
    root.left = l;
    root.right = r;
    TreeNode treeNode = solution.circleFind(root, 4);
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = traverse(root,val);
//        TreeNode node = circleFind(root,val);
        return node;
    }
    public TreeNode traverse(TreeNode node,int val){
        if(node == null) return null;
        int cur = node.val;
        if(val == cur){
            return node;
        }
        if(val < cur){
            return traverse(node.left,val);
        }else{
            return traverse(node.right,val);
        }
    }
    public TreeNode circleFind(TreeNode root ,int val){
        TreeNode cur = root;
        while(cur != null){
            int curVal = cur.val;
            if(curVal == val){
                break;
            }
            if(val < curVal) {
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}