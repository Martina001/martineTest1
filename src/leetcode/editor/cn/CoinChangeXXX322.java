//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2761 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class CoinChangeXXX322 {
    public static void main(String[] args) {
        Solution solution = new CoinChangeXXX322().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 直接dp写一下先
            /*int n = coins.length;
            // dp[I][J]表示前i个硬币凑出j的时候的最少硬币个数
            int dp[][] = new int[n + 1][amount + 1];
            // 都赋值amount+1 因为最大硬币数就是amount，amount+1取不到
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], amount + 1);
            }
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <= n; i++) {
                int val = coins[i - 1];
                for (int j = 1; j <= amount; j++) {
                    if (j >= val) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - val] + 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];*/
            // 压缩一下空间
            return coinChange1(coins, amount);
        }

        public int coinChange1(int[] coins, int amount) {
            // dp表示凑出i的时候的最少硬币数
            int n = coins.length;
            int dp[] = new int[amount + 1];
            // 记得初始化给出最大值
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                int val = coins[i];
                for (int j = 1; j <= amount; j++) {
                    if (val <= j) {
                        // 如果val比j大，就说明要用i之前的硬币求j，也就是dp[j] 已经算过了 这里只用处理val不比j大的场景
                        dp[j] = Math.min(dp[j], dp[j - val] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}