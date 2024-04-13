//给你一棵二叉树的根节点 root ，返回所有 重复的子树 。 
//
// 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。 
//
// 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在 [1, 5000] 范围内。 
// -200 <= NodeChildren.val <= 200
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 684 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;
import leetcode.editor.cn.mystructure.TreeNode;

import java.util.*;

//Java：寻找重复的子树
public class FindDuplicateSubtreesXXX652{
public static void main(String[] args) {
Solution solution = new FindDuplicateSubtreesXXX652().new Solution();
// TO TEST
  /*  TreeNode root = new TreeNode(2);
    TreeNode l = new TreeNode(1, null, new TreeNode(7));
    TreeNode r = new TreeNode(3, new TreeNode(2), new TreeNode(4));
    root.left = r;
    root.right = l;*/
    TreeNode r = new TreeNode(2, new TreeNode(1), new TreeNode(1));

    List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(r);
    System.out.println(duplicateSubtrees.size());
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
    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<String, Pair<TreeNode, Integer>>();
    HashSet<TreeNode> repeat = new HashSet<TreeNode>();
    Map<String,Integer> his =new HashMap<>();
//    这种方式不太行，因为这样会把val相同的两个不同节点当成两个子树，题目要求是当成一个子树
//    Map<String,TreeNode> his =new HashMap<>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        getRepeat(root);
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    private String getRepeat(TreeNode node){
        if(node == null) return "#";
        String left = getRepeat(node.left);
        String right = getRepeat(node.right);
        String sb= new StringBuffer(left).append(",").append(right).append(",").append(node.val).toString();
        Integer frequency = his.getOrDefault(sb, 0);
        if(frequency == 1){
            repeat.add(node);
        }
        his.put(sb,frequency+1);
        /*
        // 这种方式不太行，因为这样会把val相同的两个不同节点当成两个子树，题目要求是当成一个子树
        if(his.containsKey(sb)){
            repeat.add(node);
        }else{
            his.put(sb,node);
        }*/
        return sb;
    }

    /**
     * 这个是题解的hash实现 我们也可以用四维数组实现
     * 这个更优是因为当树过大的时候生成的String非常长
     * @param node
     * @return
     */
    // 给树编序号，每个树都由（根结点、左子树序号、右子树序号）组成
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = {node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            // 注意这里用了Pair 这个类一般都是用于和Map结合，和Map的区别在于Pair更像元素 Map更像是一个容器
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.getKey());
            return pair.getValue();
        } else {
            // 从叶子节点开始编序，每次++
            seen.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
            return idx;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
