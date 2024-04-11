//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树的深度不会超过 1000 。 
// 树的节点数目位于 [0, 10⁴] 之间。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 👍 346 👎 0

package leetcode.editor.cn;

//Java：N 叉树的最大深度
public class MaximumDepthOfNAryTreeXXX559 {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTreeXXX559().new Solution();
// TO TEST
    }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a NodeChildren.
class NodeChildren {
    public int val;
    public List<NodeChildren> children;

    public NodeChildren() {}

    public NodeChildren(int _val) {
        val = _val;
    }

    public NodeChildren(int _val, List<NodeChildren> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        int res = 0;
        int depth = 0;

        public int maxDepth(NodeChildren root) {
       /* traverse(root);
        return res;*/
            return getMaxDepth(root);
        }

        private void traverse(NodeChildren root) {
            if (root == null) return;
            depth++;
            if (root.children.isEmpty()) {
                res = Math.max(res, depth);
            }
            for (NodeChildren nodeChildren : root.children) {
                traverse(nodeChildren);
            }
            depth--;
        }

        /**
         * 递归遍历
         *
         * @param root
         * @return
         */
        private int getMaxDepth(NodeChildren root) {
            if (root == null) return 0;
            int res = 0;
            for (NodeChildren nodeChildren : root.children) {
                int maxDepth = getMaxDepth(nodeChildren);
                res = Math.max(maxDepth, res);
            }
            return res + 1;
        }
        // todo 还有一个广度优先遍历获取n叉树的最大深度，类似二叉树的广度优先获取最大深度
    }
//leetcode submit region end(Prohibit modification and deletion)

}