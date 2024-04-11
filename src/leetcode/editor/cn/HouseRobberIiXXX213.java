//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1572 👎 0

package leetcode.editor.cn;

//Java：打家劫舍 II
public class HouseRobberIiXXX213 {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIiXXX213().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            // 搞成一个环，其实就是第一家和最后一家不能同时打劫，借用一下198的代码并指定区间即可
            int length = nums.length;
            if (length == 1) return nums[0];
//            return Math.max(robBasic(nums, 0, length - 2), robBasic(nums, 1, length - 1));
            return Math.max(robBasic2(nums, 0, length - 2), robBasic2(nums, 1, length - 1));
        }

        /**
         * 定义dp[i]为打劫i家时候的最大分数，压缩空间后的解法
         *
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int robBasic(int[] nums, int start, int end) {
            int dp0 = 0;
            int dp1 = nums[start];
            for (int i = start + 1; i <= end; i++) {
                int temp = dp1;
                dp1 = Math.max(dp1, dp0 + nums[i]);
                dp0 = temp;
            }
            return dp1;
        }

        /**
         * 定义dp[i]为从i家开始打劫的最大分数，压缩空间后的解法
         *
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int robBasic2(int[] nums, int start, int end) {
            int dp0 = 0, dp1 = 0, dp2 = 0;
            for (int i = end; i >= start; i--) {
                dp0 = Math.max(dp1, dp2 + nums[i]);
                dp2 = dp1;
                dp1 = dp0;
            }
            return dp0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}