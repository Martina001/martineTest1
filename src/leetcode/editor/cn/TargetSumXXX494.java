//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1883 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：目标和
public class TargetSumXXX494 {
    public static void main(String[] args) {
        Solution solution = new TargetSumXXX494().new Solution();
// TO TEST
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // 因为总个数也就最大1000个，所以可以直接回溯
            // findTargetSum(nums,0,target);
            // return res;

            // 第二种办法有点巧妙：nums的总和值为sum，假设所有添加负号的值总和为 y，那么所有添加正号的值总和为 sum-y
            // 如果想要最终加完符号后 和为target 则有：target = (sum-y)-y = sum-2y
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            // 因为题目说明nums中的数值都是非负整数，所以y必然是非负整数，所以sum-target得是非负偶数
            if(sum-target<0 || (sum-target)%2 ==1) return 0;
            int y = (sum - target)/2;
            // 现在目标就变成了在数组中找到和为y的n个元素
            // 类似0-1背包问题，dp[i][j]表示在前i个元素中找到和为j的方案数，那么dp[i][j] =dp[i-1][j] + dp[i-1][j-nums[i-1]]
            int dp[][]= new int[n+1][y+1]; // 目标是返回dp[n][y]，所以初始化数组长度要+1
            dp[0][0] = 1;
            for(int i=1;i<=n;i++) {
                int num = nums[i-1];
                for(int j =0;j<=y;j++){
                    if(num <= j){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][y];
        }

        int res = 0;

        private void findTargetSum(int[] nums, int start, int target) {
            if (target == 0 && start == nums.length) {
                res++;
                return;
            } else if (start >= nums.length) {
                return;
            }
            findTargetSum(nums, start + 1, target - nums[start]);
            findTargetSum(nums, start + 1, target + nums[start]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}