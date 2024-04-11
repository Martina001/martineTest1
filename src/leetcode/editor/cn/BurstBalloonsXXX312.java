//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1322 👎 0

package leetcode.editor.cn;

//Java：戳气球
public class BurstBalloonsXXX312 {
    public static void main(String[] args) {
        Solution solution = new BurstBalloonsXXX312().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] num) {
            int n = num.length;
            // 类似1563 石子游戏V 也是在i和j循环之内还有一次比大小的循环
            // 重点在于把dp数组定义为从i-j（开区间）的气球戳破所得乘积，在气球两边加两个数字为1的虚拟气球，更好算
            // i-j之间一定有一个值k，假如最后一个被戳爆的气球是k，找出使得dp[i][k] + dp[k][j] +num[i]*num[k]*num[j]最大即可
            // 时间复杂度是o(n^3)
            int dp[][] = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                dp[i][i] = 1;
            }
            int[] val = new int[n + 2];
            val[0] = val[n + 1] = 1;
            // 注意别直接用num数组哦
            for (int i = 1; i <= n; i++) {
                val[i] = num[i - 1];
            }
            for (int i = n + 1; i >= 0; i--) {
                for (int j = i + 1; j < n + 2; j++) {
                    // 假设k是i-j之间最后一个戳爆了的气球
                    for (int k = i + 1; k < j ; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + val[i] * val[k] * val[j]);
                    }
                }
            }
            return dp[0][n + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}