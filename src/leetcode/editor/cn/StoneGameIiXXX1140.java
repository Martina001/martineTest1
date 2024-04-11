//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 前缀和 👍 300 👎 0

package leetcode.editor.cn;

//Java：石子游戏 II
public class StoneGameIiXXX1140 {
    public static void main(String[] args) {
        Solution solution = new StoneGameIiXXX1140().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。

        在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。

        游戏一直持续到所有石子都被拿走。

        假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。*/
        public int stoneGameII(int[] piles) {
            int n = piles.length;
            // 有点像打家劫舍的问题，如果只剩1堆了其实就很好算了，所以必定是从后向前逆序遍历
            // 我们尝试一下这么定义dp数组，dp[i][j]代表从第i堆开始拿，M=j时 爱丽丝（先手）可得到的最大数量
            // 那么当i+2j>=n的时候 剩下的可以直接一次性取走，所以dp[i][j]就是从i到最后一堆的总和，即=sum[i~n-1]
            // 如果i+2j<n,那剩下的无法一次性取走，所以就在x取值范围为1到2M的情况下，dp[i][j]=sum[i~n-1]-dp[i+x][max(M,x)]
            // 这里最难的就是理解这个x和m的关系，别陷进去，把M带入dp数组就行
            int dp[][] = new int[n][n+1];//因为M从1开始 所以对应下标从1开始 申请数组空间大小为n+1
            int sum =0;// 后缀和数组
            for (int i = n - 1; i >= 0; i--) {
                sum += piles[i];
                // 这里有个小优化，极端情况每次都拿2M，i=2M-2，其他情况i>=2M-2，所以M小于等于i/2+1
                // 如果get不到这个值，直接m<=n也行
                for (int M = 1; M <= i/2+1; M++) {
                    if (i + 2 * M >= n) {
                        dp[i][M] = sum;
                    } else {
                        int minRight =Integer.MAX_VALUE;
                        for (int x = 1; x <= 2 * M; x++) {
                            // 从i+x的时候开始取 所能拿到的最小值
                            minRight = Math.min(minRight, dp[i + x][Math.max(M, x)]);
                        }
                        dp[i][M] = sum - minRight;
                    }
                }
            }
            return dp[0][1];
            // 这道题的回溯算法转动规还挺麻烦的，有空了可以看一下思路
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}