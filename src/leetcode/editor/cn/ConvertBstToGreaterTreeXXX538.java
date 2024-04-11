//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
//sum-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 905 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：把二叉搜索树转换为累加树
public class ConvertBstToGreaterTreeXXX538{
public static void main(String[] args) {
Solution solution = new ConvertBstToGreaterTreeXXX538().new Solution();
// TO TEST
    TreeNode root = new TreeNode(3);
    TreeNode l = new TreeNode(1, null, new TreeNode(2));
    root.left = l;
    TreeNode r = new TreeNode(4);
    root.right = r;
    TreeNode treeNode = solution.convertBST(root);
    System.out.println(treeNode);
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
    public TreeNode convertBST(TreeNode root) {
//        traverse(root);
        morris(root);
        return root;
    }
    public int sum = 0;

    public void traverse(TreeNode node){
        if(node == null) return;
        // 就是中序遍历的反向：右根左
        traverse(node.right);
        sum+= node.val;
        node.val = sum;
        traverse(node.left);
    }

    // morris方法，利用空余的右子针来进行中序遍历（以下是反向中序遍历的morris方法的实现）
    // 如果右子节点为空，处理当前节点Cur，并遍历左子节点
    // 如果右子节点不为空，找到右子树的最左节点A：
        // 最左节点A的左子针为空，A的左子针指向当前节点，遍历当前节点的右子节点
        // A的左子针不为空，将其置为空（恢复树原状），处理当前节点，然后当前节点Cur置为Cur.left
    public void morris(TreeNode cur){
//        TreeNode cur = root;
        while(cur != null){
            if(null == cur.right){
                sum += cur.val;
                cur.val  = sum;
                cur = cur.left;
            }else{
                TreeNode mostLeft = getMostLeft(cur);
                if(mostLeft.left == null){
                    mostLeft.left = cur;
                    cur = cur.right;
                }else{
                    mostLeft.left = null;
                    sum+=cur.val;
                    cur.val  = sum;
                    cur = cur.left;
                }
            }
        }
    }
    private TreeNode getMostLeft(TreeNode node){
        TreeNode res = node.right;
        // 注意还要判断res不等于node
        while(res!=null && res.left!=null && res.left != node){
            res = res.left;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}