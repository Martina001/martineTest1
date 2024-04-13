//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 940 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 Ⅳ
public class CombinationSumIvXXX377 {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIvXXX377().new Solution();
// TO TEST
        int[] arr = new int[]{1, 2, 3};
        int i = solution.combinationSum4(arr, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res;
        List<Integer> track = new ArrayList<>();

        public int combinationSum4(int[] nums, int target) {
            // 乍眼一看 这个题是一个找元素不重复可复选的排列个数 复杂度很高 估计会超时
           /* getPaiLie(nums, target);
            return res;*/
            // 换一种方式，这其实是一个背包问题的变形
//          dpIJ表示nums中前I个数构成总和为J的方案数。
//          如果是正常的背包问题：那么如果当前nums[i]（val）小于J，则dpIJ =dp[i-1][J](当前元素不被使用的方案数)+dp[i-1][j-val]（当前元素参与使用的方案数）
//          但是这道题需要考虑先放哪一个数来凑target，我们设定dpIJ为放入背包的第一个物品为0-i，恰好凑出j
//          那么 dp[i][j] = dp[i - 1][j]（i-1之前的物品是第一个放入的物品） + dp[n][j - weight[i]]（第一个放入的物品为i，剩下的物品可以任意选择）

            /*int n = nums.length;
            int dp[][] = new int[n + 1][target + 1];
            // 注意 结果中包含空字符串的情况 所以dp[i][0] =1
            for (int i = 0; i <=n; i++) {
                dp[i][0] = 1;
            }
            // 求dp[n][target]
            for (int j = 1; j <= target; j++) {
                if (j >= nums[0]) {
                    dp[1][j] = dp[n][j - nums[0]];
                }
                for (int i = 1; i <= n; i++) {
                    int val = nums[i - 1];
                    if (val <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[n][j - val];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][target];*/
            return dp1(nums, target);
        }

        /**
         * 直接背包的组合问题：由于需要区分顺序，所以先外层循环背包重量，内层循环物品
         * 由于数组中的数字（物品）可以重复使用，所以内层正序
         *
         * @param nums
         * @param target
         * @return
         */
        private int dp1(int nums[], int target) {
            int n = nums.length;
            int dp[] = new int[target + 1];
            dp[0] = 1;
            for (int j = 1; j <= target; j++) {
                for (int i = 0; i < n; i++) {
                    if (j >= nums[i]) {
                        dp[j] = dp[j] + dp[j - nums[i]];
                    }
                }
            }
            return dp[target];
        }

        private void getPaiLie(int nums[], int targetSum) {
            if (targetSum == 0) {
//            System.out.println(track);
                res++;
                return;
            }
            if (targetSum < 0) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                getPaiLie(nums, targetSum - nums[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}