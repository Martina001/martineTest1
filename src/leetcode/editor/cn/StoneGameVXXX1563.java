//几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。 
//
// 游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最
//大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。 
//
// 只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。 
//
// 返回 Alice 能够获得的最大分数 。 
//
// 
//
// 示例 1： 
//
// 输入：stoneValue = [6,2,3,4,5,5]
//输出：18
//解释：在第一轮中，Alice 将行划分为 [6，2，3]，[4，5，5] 。左行的值是 11 ，右行的值是 14 。Bob 丢弃了右行，Alice 的分数现
//在是 11 。
//在第二轮中，Alice 将行分成 [6]，[2，3] 。这一次 Bob 扔掉了左行，Alice 的分数变成了 16（11 + 5）。
//最后一轮 Alice 只能将行分成 [2]，[3] 。Bob 扔掉右行，Alice 的分数现在是 18（16 + 2）。游戏结束，因为这行只剩下一块石头了。
//
// 
//
// 示例 2： 
//
// 输入：stoneValue = [7,7,7,7,7,7,7]
//输出：28
// 
//
// 示例 3： 
//
// 输入：stoneValue = [4]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stoneValue.length <= 500 
// 1 <= stoneValue[i] <= 10^6 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 58 👎 0

package leetcode.editor.cn;

//Java：石子游戏 V
public class StoneGameVXXX1563 {
    public static void main(String[] args) {
        Solution solution = new StoneGameVXXX1563().new Solution();
// TO TEST
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] preSumArr = solution.getPreSumArr(a);
        int rangeSum = solution.getRangeSum(preSumArr, 0, 1);
        int i = solution.stoneGameV(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* 几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。

            游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。
            Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。
            如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。

            只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。

            返回 Alice 能够获得的最大分数 。*/
        public int stoneGameV(int[] stoneValue) {
            // 定义dp[i][j]表示从i到j Alice能获取的最大分数
            // 要求的就是dp[0][n-1],所以i--，j++
            // 题目说的是随意切分为两份，不是均分两份 所以内层还有一个循环，时间复杂度为o(n^3)
            int n = stoneValue.length;
            int dp[][] = new int[n][n];
            int[] preSumArr = getPreSumArr(stoneValue);
        /*
//       312题 戳气球那个跟这个很像，重点在于把dp数组定义为从i-j（开区间）的气球戳破所得乘积，在气球两边加两个数字为1的虚拟气球，更好算
        for(int i = n-1;i>=0;i--){
            for(int j =i+1;j<n;j++){
                for (int k = i; k < j; k++) {
                    int sumLeft = getRangeSum(preSumArr,i,k);
                    int sumRight = getRangeSum(preSumArr,k+1,j);
                    if(sumLeft < sumRight){
                        dp[i][j] =Math.max(dp[i][j],  sumLeft + dp[i][k]);
                    }else if(sumLeft > sumRight){
                        dp[i][j] =Math.max(dp[i][j], sumRight + dp[k+1][j]);
                    }else{
                        dp[i][j] = Math.max(dp[i][j],Math.max(sumLeft + dp[i][k], sumRight + dp[k+1][j]));
                    }
                }
            }*/

            // 优化时间复杂度为o(n^2),找到i到j之间的中间点，中间点定义：该点左半边和>=右半边和
            // 此方法时间复杂度和下面的动规都是O(n^2)
            int[][] halfPoints = new int[n][n];
            for (int i = 0; i < n; i++) {
                int leftSum = 0, totalSum = 0;
                for (int j = i, k = i - 1; j < n; j++) {
                    totalSum += stoneValue[j];
                    while (leftSum < totalSum - leftSum) {
                        k++;
                        leftSum += stoneValue[k];
                    }
                    halfPoints[i][j] = k;
                }
            }
            //然后根据这个中间点数组去简化动规
            for(int i = n-1;i>=0;i--){
                for(int j =i+1;j<n;j++){
                    int k = halfPoints[i][j];
                        int sumLeft = getRangeSum(preSumArr,i,k);
                        int sumRight = getRangeSum(preSumArr,k+1,j);
                        if(sumLeft < sumRight){
                            dp[i][j] =Math.max(dp[i][j],  sumLeft + dp[i][k]);
                        }else if(sumLeft > sumRight){
                            dp[i][j] =Math.max(dp[i][j], sumRight + dp[k+1][j]);
                        }else{
                            dp[i][j] = Math.max(dp[i][j],Math.max(sumLeft + dp[i][k], sumRight + dp[k+1][j]));
                        }
                }
        }

        return dp[0][n-1];
    }

    private int[] getPreSumArr(int nums[]) {
        int preSum[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return preSum;
    }

    private int getRangeSum(int preSumArr[], int left, int right) {
        return preSumArr[right + 1] - preSumArr[left];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}