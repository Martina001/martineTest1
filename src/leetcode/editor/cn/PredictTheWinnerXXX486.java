//给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。 
//
// 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0
//] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取
//时，游戏结束。 
//
// 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分
//数最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,2]
//输出：false
//解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
//如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）
//可选。 
//所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
//因此，玩家 1 永远不会成为赢家，返回 false 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,233,7]
//输出：true
//解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
//最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 递归 数组 数学 动态规划 博弈 👍 690 👎 0

package leetcode.editor.cn;

//Java：预测赢家
public class PredictTheWinnerXXX486 {
    public static void main(String[] args) {
        Solution solution = new PredictTheWinnerXXX486().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean predictTheWinner(int[] nums) {
            // 如果没有控制石头堆数和石子总数（控制了的题目见877，一行代码即可），那就需要动规
            // 状态方程一下子就可以得到：dp[i][j] 表示nums[i..j]之间当前玩家和对手之间分数差的最大值（注意不是表示：nums[i..j]之间可得的最大值）
            // 那么baseCase dp[i][i]=nums[i] 题目求的就是dp[0][n-1]是否大于0 所以注意循环顺序（也可以画一个二维矩阵确定顺序）
            // dp[i][j] =Max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            int n = nums.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    // 注意这里的公式，想要证明，重点在于明确dp概念和我们已经认定了出发点是当前玩家
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            return dp[0][n - 1] >= 0;


            // 如果这道题变成要求先手后手之间的差值，状态方程就比较麻烦了
//        dp[i][j].first nums[i..j]之间作为先手可得的最大值
//        dp[i][j].sec nums[i..j]之间作为后手可得的最大值
            // base case就是dp[i][i].first为nums[i] dp[i][i].sec = 0
//        那么 dp[i][j].first = pile[i] + dp[i+1][j].sec, pile[j] +dp[i][j-1].sec
            // 解释：i到j之间的先手，如果选了i，那么i+1到j之间自己就是作为后手；如果选了j，那么i到j-1之间自己就是作为后手

            // 如果pile[i] + dp[i+1][j].sec >pile[j] +dp[i][j-1].sec（注意不是比较nums[i]>nums[j]） 先手选左，dp[i][j].sec = dp[i+1][j].first，
            // 否则 先手选右，dp[i][j].sec = dp[i][j-1].first
            // 根据方程可知，i从n-2开始逆序，j从2开始正序

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}