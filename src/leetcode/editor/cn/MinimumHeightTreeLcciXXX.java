//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。 
//示例:
// 给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：     
//      0          / \  -3 9  / /  -10 5 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 156 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

//Java：最小高度树
public class MinimumHeightTreeLcciXXX {
public static void main(String[] args) {
Solution solution = new MinimumHeightTreeLcciXXX().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 找到中间值 类似归并
        if(nums == null || nums.length ==0) return null;
        TreeNode traverse = traverse(nums, 0, nums.length-1);
        return traverse;

    }

    private TreeNode traverse(int nums[],int low,int high){
        if(low<0 || low>=high) return null;
        int mid = (high-low)/2+low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = traverse(nums,low,mid-1);
        root.right = traverse(nums,mid+1,high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}