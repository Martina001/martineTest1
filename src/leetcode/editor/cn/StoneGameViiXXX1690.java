//石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。 
//
// 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得
//分较高者获胜。 
//
// 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。 
//
// 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分
//的差值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [5,3,1,4,2]
//输出：6
//解释：
//- 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
//- 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
//- 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
//- 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
//- 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
//得分的差值 18 - 12 = 6 。
// 
//
// 示例 2： 
//
// 
//输入：stones = [7,90,5,1,100,10,10,2]
//输出：122 
//
// 
//
// 提示： 
//
// 
// n == stones.length 
// 2 <= n <= 1000 
// 1 <= stones[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 142 👎 0

package leetcode.editor.cn;

//Java：石子游戏 VII
public class StoneGameViiXXX1690 {
    public static void main(String[] args) {
        Solution solution = new StoneGameViiXXX1690().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*  有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
          鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
          给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。*/
        public int stoneGameVII(int[] stones) {
            // 也是个数学游戏，
            // 我们先看怎么动态规划，直接定义dp[i][j]表示从i到j之间Alice的总和Bob的总和最大差，那么直接套用"分数差=当前值-上个分数差"的公式
            // 选i，当前值就是rangeSum（i+1,j）选j就是rangeSum(i,j-1)，当前最大差就取这俩值的最大值就行。这就很简单了。

            // 接下来我们来推理一下状态方程式dp[i][j]=？（如果已经知道公式的证明，下面这个推理可以不用看了）
            // 对于dp[0][1]来说，就是简单的Max(nums[0]-nums[1],nums[1]-nums[0]) 也就是a-b，b-a
            // 对于dp[0][2]，如果alice选了最右边石子(a b c中的c)，就是两人的总和之差就是(a+b)-(b)+a 或者 (a+b)-a+b，就是(a+b)-Max(b-a,a-b) 不就是（a+b）-dp[0][1]吗
            // 所以dp[i][j] = Math.max(getRangeSum(i+1,j) - dp[i + 1][j], getRangeSum(i,j-1) - dp[i][j - 1]);
            // 首先前缀和
            int n = stones.length;
            int[][] dp = new int[n][n];
            int[] preSumArr = getPreSumArr(stones);
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Math.max(getRangeSum(preSumArr,i+1,j) - dp[i + 1][j], getRangeSum(preSumArr,i,j-1) - dp[i][j - 1]);
                }
            }
            return dp[0][n-1];
        }

        /**
         * 一般初始化前缀和都用n+1 这里其实也行
         * @param nums
         * @return
         */
        private int[] getPreSumArr(int[] nums) {
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                preSum[i + 1] = preSum[i] + nums[i + 1];
            }
            return preSum;
        }

        private int getRangeSum(int[] preSum, int left, int right) {
            if (left == 0) {
                return preSum[right];
            }
            return preSum[right] - preSum[left - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}