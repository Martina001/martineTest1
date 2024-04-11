//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2037 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：分割等和子集
public class PartitionEqualSubsetSumXXX416 {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSumXXX416().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            // 也是一个0-1背包问题的变形，都是正整数，所以找到是否可以使数组中某些元素的和为sum/2 即可
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;
            int target = sum / 2;
            // 再排除一种可能
            int max = Arrays.stream(nums).max().getAsInt();
            if (max > target) return false;
            int n = nums.length;
            // 目标是求dp[n][target]，也就是前n个数里是否有元素和为target，所以初始化长度要记得+1
            /*boolean dp[][] = new boolean[n + 1][target + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                // 注意别直接写成nums[i]了
                int num = nums[i - 1];
                // j从0开始遍历
                for (int j = 0; j <= target; j++) {
                    if (num <= j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][target];*/
            // 我们来换一种方式 优化一下空间复杂度
            // 因为每次只需要获取上一行的dp值，所以我们可以直接压缩空间到一维
            // 此时dp[i]则表示是否可取到和为i的元素
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                // 注意倒序，因为元素不可重复使用
                for (int j = target; j >= num; --j) {
                    dp[j] |= dp[j - num];
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}