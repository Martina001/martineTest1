//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在
// [1, 10⁴]范围内
// 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 133 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Java：最大层内元素和
public class MaximumLevelSumOfABinaryTreeXXX1161 {
    public static void main(String[] args) {
        Solution solution = new MaximumLevelSumOfABinaryTreeXXX1161().new Solution();
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
        public int maxLevelSum(TreeNode root) {
            // 写BFS好像简单一点 直接BFS来一下
            /*ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int max = Integer.MIN_VALUE;
            int res = -1, num = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                num++;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    sum += cur.val;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                if (sum > max) {
                    max = sum;
                    res = num;
                }
            }
            return res;
*/
            // 再来写一下深度遍历dfs
            dfs(root, 0);
            int res =0;
            for(int i =1;i<sum.size();i++){
                if(sum.get(i)>sum.get(res)){
                    res = i;
                }
            }
            return res+1;
        }

        private List<Integer> sum = new ArrayList<Integer>();
        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            // 关注点1：每层的起始点的表示如下
            if(level == sum.size()){
                sum.add(root.val);
            }else {
                sum.set(level,sum.get(level)+ root.val);
            }
            if(root.left != null){
                dfs(root.left,level+1);
            }
            if(root.right != null){
                dfs(root.right,level+1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}