//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1,2], targetSum = 0
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点总数在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 990 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.*;

//Java：路径总和 II
public class PathSumIiXXX113 {
    public static void main(String[] args) {
        Solution solution = new PathSumIiXXX113().new Solution();
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
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) return res;
            // 建议用traverse，这里写一下breadTh就是为了手感，很明显递归更清晰容易懂
//            traverse(root, targetSum, new ArrayDeque<>());
//            return res;
            return breadth(root, targetSum);
        }

        /**
         * 递归遍历/深度遍历
         *
         * @param root
         * @param t
         * @param track
         */
        private void traverse(TreeNode root, int t, Deque<Integer> track) {
            if (root == null) return;
            track.addLast(root.val);
            if (root.left == null && root.right == null) {
                if (root.val == t) {
                    res.add(new ArrayList<>(track));
                }
            }
            traverse(root.left, t - root.val, track);
            traverse(root.right, t - root.val, track);
            track.removeLast();
        }

        /**
         * 广度遍历，记录每个节点的父节点来确定每次的路径
         *
         * @param root
         * @param targetSum
         * @return
         */
        private List<List<Integer>> breadth(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            // 用hashmap存储每个节点的父节点
            Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
            Queue<Integer> queueSum = new LinkedList<Integer>();
            queue.offer(root);
            queueSum.offer(0);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                // queueSum中截止前一个节点的sum值
                int tempSum = queueSum.poll() + node.val;
                if (node.left == null && node.right == null && tempSum == targetSum) {
                    List<Integer> path = getPath(map, node);
                    if (!path.isEmpty()) {
                        res.add(path);
                    }
                }
                if (node.left != null) {
                    map.put(node.left, node);
                    queue.offer(node.left);
                    queueSum.offer(tempSum);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue.offer(node.right);
                    queueSum.offer(tempSum);
                }
            }
            return res;
        }

        /**
         * 获取整个链路上的值，注意直接用Collections.reverse()
         *
         * @param map
         * @param node
         * @return
         */
        private List<Integer> getPath(Map<TreeNode, TreeNode> map, TreeNode node) {
            List<Integer> res = new ArrayList<>();
            // 注意map是可以为empty的，此时就只有一个单节点
            if (map == null) return res;

            while (Objects.nonNull(node)) {
                res.add(node.val);
                node = map.get(node);
            }
            Collections.reverse(res);
            return res;
        }

        private List<Integer> getPath(Map<TreeNode, TreeNode> map, TreeNode node, int targetSum) {
            List<Integer> res = new ArrayList<>();
            if (map == null || map.isEmpty()) return res;

            Deque<TreeNode> stack = new LinkedList<>();
            while (Objects.nonNull(map.get(node))) {
                stack.push(node);
                targetSum -= node.val;
                node = map.get(node);
            }
            if (targetSum == 0) {
                return getRes(stack);
            }
            return res;
        }

        private List<Integer> getRes(Deque<TreeNode> stack) {
            List<Integer> res = new ArrayList<>();
            while (!stack.isEmpty()) {
                res.add(stack.pop().val);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}