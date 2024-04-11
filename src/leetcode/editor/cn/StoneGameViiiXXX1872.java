//Alice 和 Bob 玩一个游戏，两人轮流操作， Alice 先手 。 
//
// 总共有 n 个石子排成一行。轮到某个玩家的回合时，如果石子的数目 大于 1 ，他将执行以下操作： 
//
// 
// 选择一个整数 x > 1 ，并且 移除 最左边的 x 个石子。 
// 将 移除 的石子价值之 和 累加到该玩家的分数中。 
// 将一个 新的石子 放在最左边，且新石子的值为被移除石子值之和。 
// 
//
// 当只剩下 一个 石子时，游戏结束。 
//
// Alice 和 Bob 的 分数之差 为 (Alice 的分数 - Bob 的分数) 。 Alice 的目标是 最大化 分数差，Bob 的目标是 最小化 
//分数差。 
//
// 给你一个长度为 n 的整数数组 stones ，其中 stones[i] 是 从左边起 第 i 个石子的价值。请你返回在双方都采用 最优 策略的情况下，
//Alice 和 Bob 的 分数之差 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [-1,2,-3,4,-5]
//输出：5
//解释：
//- Alice 移除最左边的 4 个石子，得分增加 (-1) + 2 + (-3) + 4 = 2 ，并且将一个价值为 2 的石子放在最左边。stones 
//= [2,-5] 。
//- Bob 移除最左边的 2 个石子，得分增加 2 + (-5) = -3 ，并且将一个价值为 -3 的石子放在最左边。stones = [-3] 。
//两者分数之差为 2 - (-3) = 5 。
// 
//
// 示例 2： 
//
// 输入：stones = [7,-6,5,10,5,-2,-6]
//输出：13
//解释：
//- Alice 移除所有石子，得分增加 7 + (-6) + 5 + 10 + 5 + (-2) + (-6) = 13 ，并且将一个价值为 13 的石子放
//在最左边。stones = [13] 。
//两者分数之差为 13 - 0 = 13 。
// 
//
// 示例 3： 
//
// 输入：stones = [-10,-12]
//输出：-22
//解释：
//- Alice 只有一种操作，就是移除所有石子。得分增加 (-10) + (-12) = -22 ，并且将一个价值为 -22 的石子放在最左边。
//stones = [-22] 。
//两者分数之差为 (-22) - 0 = -22 。
// 
//
// 
//
// 提示： 
//
// 
// n == stones.length 
// 2 <= n <= 10⁵ 
// -10⁴ <= stones[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 前缀和 👍 51 👎 0

package leetcode.editor.cn;

//Java：石子游戏 VIII
public class StoneGameViiiXXX1872 {
    public static void main(String[] args) {
        Solution solution = new StoneGameViiiXXX1872().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        Alice 先手 。

    总共有 n 个石子排成一行。轮到某个玩家的回合时，如果石子的数目 大于 1 ，他将执行以下操作：

    选择一个整数 x > 1 ，并且 移除 最左边的 x 个石子。
    将 移除 的石子价值之 和 累加到该玩家的分数中。
    将一个 新的石子 放在最左边，且新石子的值为被移除石子值之和。
    当只剩下 一个 石子时，游戏结束。

    Alice 和 Bob 的 分数之差 为 (Alice 的分数 - Bob 的分数) 。 Alice 的目标是 最大化 分数差，Bob 的目标是 最小化 分数差。
         */
        public int stoneGameVIII(int[] stones) {
            int n = stones.length;
            int[] prefix = new int[n + 1];
            // 前缀和，一般前缀和都是初始化长度为n+1
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + stones[i - 1];
            }
            // 因为每次当前选手移除之后，还会放一个等值的石头在最左侧，所以每个选手每次取值都是某个前缀和的值，理解了这个就可以简单的再套用"分数差=当前值-上个分数差"的公式了
            // dp[i] 表示当可选择下标 [i: n) 个石头时的分差：
            // 如果选择的是下标 i，则当前选手获得 prefix[i + 1]，对手在 [i + 1: n) 的石头内继续，得分差为 dp[i + 1]，
            // 则对当前选手而言得分差为 prefix[i + 1] - dp[i + 1]（公式，自己推理或者记忆）；
            // 如果不选择下标 i，则会在 [i + 1, n) 内做选择，dp[i] = dp[i + 1]。
            // 取两种情况的最大值作为 dp[i]，转移方程为：dp[i] = max(prefix[i + 1] - dp[i + 1], dp[i + 1])
            int dp[] = new int[n];
            dp[n - 1] = prefix[n];
            // 因为i最少是1，所以i>0
            for (int i = n - 2; i > 0; i--) {
                dp[i] = Math.max(prefix[i + 1] - dp[i + 1], dp[i + 1]);
            }
            // 注意这里范围dp[1] 因为i的定义是可选择i个石头时的分数差，其中1<=i<n
            return dp[1];
            /*
            //压缩空间：dp[i] 只转移自 dp[i + 1]，可以只设立一个变量 dp 表示当前的得分差。
            int dp = prefix[n];
            for (int i = n - 2; i > 0; i--){
                dp = Math.max(prefix[i + 1] - dp, dp);
            }
            return dp;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}