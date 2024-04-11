//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1635 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

//Java：路径总和 III
public class PathSumIiiXXX437 {
    public static void main(String[] args) {
        Solution solution = new PathSumIiiXXX437().new Solution();
// TO TEST
        // [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(1000000000);
        TreeNode llll = new TreeNode(1000000000, new TreeNode(1000000000), null);
        TreeNode lll = new TreeNode(1000000000, llll, null);
        TreeNode ll = new TreeNode(294967296, lll, null);
        TreeNode l = new TreeNode(1000000000, ll, null);
        root.left = l;
        /*TreeNode r = new TreeNode(4);
        root.right = r;*/
        int i = solution.pathSum(root, 0);
        int tep = -2000000000 - 294967296;
        System.out.println(tep);
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
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            // 这道题最好还是用前缀和，但是略难理解，多看一下
//            int res = traverse(root, targetSum);
            // prefix代表含义：前缀和为key的个数为value
            Map<Long,Integer> prefix = new HashMap<>();

            // 首先，前缀和为0的个数为1
            prefix.put(0L,1);
            int res = dfsPreFix(root,targetSum,prefix,0);
            return res;
        }

        public int dfsPreFix(TreeNode root,int targetSum,Map<Long,Integer> prefix,long curPrefixSum){
            if(root == null) return 0;
            int res = 0;
            int val = root.val;
            curPrefixSum+=val;
            // 曾经有过前缀和正好等于 当前前缀和-targetSum。
            // 例如 前缀和分别为0-1-2-3-7，target为5，那么此时 7-5 =2，第二个节点的前缀和为2，就说明有满足要求的路径。是3-7对应的节点路径，3和7对应的节点和为5。
            res = prefix.getOrDefault(curPrefixSum - targetSum,0);

            // 前缀和为cur的个数++
            prefix.put(curPrefixSum,prefix.getOrDefault(curPrefixSum,0)+1);
            res += dfsPreFix(root.left,targetSum,prefix,curPrefixSum);
            res += dfsPreFix(root.right,targetSum,prefix,curPrefixSum);

            // 回退：去除当前路径上的此节点，前缀和为cur的个数--
            prefix.put(curPrefixSum,prefix.getOrDefault(curPrefixSum,0)-1);
            return res;
        }


        private int traverse(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            // 从每个节点开始获取以当前节点为根节点的路径树的满足要求数量
            int rootNum = traverseRoot(root, Long.valueOf(sum));
            // 然后获取其左右子树的数量
            rootNum += traverse(root.left, sum);
            rootNum += traverse(root.right, sum);
            return rootNum;
        }

        /**
         * 这里类似路径总和||题目的解法
         *
         * @param root
         * @param sum
         * @return
         */
        private int traverseRoot(TreeNode root, Long sum) {
            // 注意每次都是从0开始。
            int res = 0;
            if (root == null || sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) return 0;
            if (sum == root.val) {
                res++;
            }

            // 左右子树遍历
            res += traverseRoot(root.left, sum - root.val);
            res += traverseRoot(root.right, sum - root.val);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}