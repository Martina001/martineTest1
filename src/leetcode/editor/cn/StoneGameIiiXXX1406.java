//Alice 和 Bob 继续他们的石子游戏。几堆石子 排成一行 ，每堆石子都对应一个得分，由数组 stoneValue 给出。 
//
// Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所
//有石头都被拿走。 
//
// 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。 
//
// 比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。 
//
// 假设 Alice 和 Bob 都采取 最优策略 。 
//
// 如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，分数相同返回 "Tie" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [1,2,3,7]
//输出："Bob"
//解释：Alice 总是会输，她的最佳选择是拿走前三堆，得分变成 6 。但是 Bob 的得分为 7，Bob 获胜。
// 
//
// 示例 2： 
//
// 
//输入：values = [1,2,3,-9]
//输出："Alice"
//解释：Alice 要想获胜就必须在第一个回合拿走前三堆石子，给 Bob 留下负分。
//如果 Alice 只拿走第一堆，那么她的得分为 1，接下来 Bob 拿走第二、三堆，得分为 5 。之后 Alice 只能拿到分数 -9 的石子堆，输掉比赛。
//
//如果 Alice 拿走前两堆，那么她的得分为 3，接下来 Bob 拿走第三堆，得分为 3 。之后 Alice 只能拿到分数 -9 的石子堆，同样会输掉比赛。
//
//注意，他们都应该采取 最优策略 ，所以在这里 Alice 将选择能够使她获胜的方案。 
//
// 示例 3： 
//
// 
//输入：values = [1,2,3,6]
//输出："Tie"
//解释：Alice 无法赢得比赛。如果她决定选择前三堆，她可以以平局结束比赛，否则她就会输。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stoneValue.length <= 5 * 10⁴ 
// -1000 <= stoneValue[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 122 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：石子游戏 III
public class StoneGameIiiXXX1406 {
    public static void main(String[] args) {
        Solution solution = new StoneGameIiiXXX1406().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
         每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。
         比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
         假设 Alice 和 Bob 都采取 最优策略 。*/
        public String stoneGameIII(int[] nums) {
            // 定义dp[i]表示从索引i到最后一堆之间的当前选手和另一位选手的差（如果是从0取到i之间的差 就不好算了）,如果每次拿x堆， 那么dp[i] = sum(i-x)-dp[i-x](题目要求x在1到3之间)
            // 用公式："分数差=当前值-上个分数差"
            // 所以dp[n-3]=sum(后三堆)-0,下一步如果取一堆dp[n-4] = num(n-4)-dp[n-3]
            // 要求的就是dp[0]，因为此时Alice就是当前选手，所以dp[0]就是题目所求
            int n = nums.length;
            int dp[] = new int[n + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[n] = 0;
            /*for (int i = n - 1; i >= 0; i--) {
                int sum = 0;
                // 这里比较容易糊涂，注意写下来搞清楚
                for (int k = 1; k <= 3; k++) {
                    if (i + k > n) break;
                    sum += nums[i + k - 1];
                    dp[i] = Math.max(dp[i], sum - dp[i + k]);
                }
            }
            if (dp[0] == 0) {
                return "Tie";
            }
            return dp[0] > 0 ? "Alice" : "Bob";*/
            // 我们来试一下，dp[i]用来表示从i到n的总分，dp[n]=0
            // dp[n-1]就是sum(n-1到n-1)-dp[n]
            // dp[i]就是 i位置的后缀和 - dp[i-1]
            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                //由于有负值分数，这里注意一下
                dp[i] = Integer.MIN_VALUE;
                sum += nums[i];
                // 此时alice能得到的分数就是i到n的后缀和 减去 bob取1到3堆时候的总分
                for (int j = i; j < i + 3 && j < n; j++) {
                    dp[i] = Math.max(dp[i], sum - dp[j + 1]);
                }
            }
            int alice = dp[0];
            int bob = sum - dp[0];
            if (alice == bob) return "Tie";
            if (alice > bob) return "Alice";
            return "Bob";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}