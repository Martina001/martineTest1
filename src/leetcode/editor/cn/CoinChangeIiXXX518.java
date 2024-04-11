//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1236 👎 0

package leetcode.editor.cn;

//Java：零钱兑换 II
public class CoinChangeIiXXX518 {
    public static void main(String[] args) {
        Solution solution = new CoinChangeIiXXX518().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            // 压缩空间后，注意要从i=0开始 dp[i]表示凑出i的时候可能得方案数
           /* int n = coins.length;
            int dp[] = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= amount; j++) {
                    int val = coins[i];
                    if (j >= val) {
                        dp[j] = dp[j] + dp[j - val];
                    }
                }
            }
            return dp[amount];*/
            return changeDp(coins,amount);
        }
        private int changeDp(int [] coins,int amount){
            // 我们再写一下直接dp的情况
            int  n = coins.length;
            // 重点在于dp表示的是前n个硬币凑出amount的个数，所以需要求dp[N][amount] 初始化长度要+1
            int dp[][] = new int[n+1][amount+1];
            for(int i =0;i<=n;i++){
                dp[i][0] =1;
            }
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=amount;j++){
                    int val = coins[i-1];
                    if(j>=val){
                        dp[i][j] = dp[i-1][j] + dp[i][j-val];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}