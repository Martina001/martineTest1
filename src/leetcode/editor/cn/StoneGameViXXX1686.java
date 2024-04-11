//Alice 和 Bob 轮流玩一个游戏，Alice 先手。 
//
// 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方
//都知道对方的评判标准。 
//
// 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 
//Alice 和 Bob 认为第 i 个石子的价值。 
//
// 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。 
//
// 请你推断游戏的结果，用如下的方式表示： 
//
// 
// 如果 Alice 赢，返回 1 。 
// 如果 Bob 赢，返回 -1 。 
// 如果游戏平局，返回 0 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：aliceValues = [1,3], bobValues = [2,1]
//输出：1
//解释：
//如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
//Bob 只能选择石子 0 ，得到 2 分。
//Alice 获胜。
// 
//
// 示例 2： 
//
// 
//输入：aliceValues = [1,2], bobValues = [3,1]
//输出：0
//解释：
//Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
//打平。
// 
//
// 示例 3： 
//
// 
//输入：aliceValues = [2,4,3], bobValues = [1,6,7]
//输出：-1
//解释：
//不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
//比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
//Bob 会获胜。
// 
//
// 
//
// 提示： 
//
// 
// n == aliceValues.length == bobValues.length 
// 1 <= n <= 10⁵ 
// 1 <= aliceValues[i], bobValues[i] <= 100 
// 
//
// Related Topics 贪心 数组 数学 博弈 排序 堆（优先队列） 👍 121 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：石子游戏 VI
public class StoneGameViXXX1686 {
    public static void main(String[] args) {
        Solution solution = new StoneGameViXXX1686().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {/*
    每次可以移除一个石子，位置随意，获取当前石子的值
    给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。

    所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。*/

        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            // 这是个数学问题
            // 由于两人对价值判断不一，要想Alice得分高，就需要ai-bj>aj-bi,两个分数差之间的差为ai+bi-(aj+bj)
            // 所以只要ai+bi-（aj+bj）大于0就能保证alice能赢 所以她可以每次都先选ai+bi最大的那个石头
            // 那么先把俩数组加和，然后从大到小排序，alice每次都取索引为偶数的就行 最后判断两人的sum大小
            int n = aliceValues.length;
            int val[][] = new int[n][3];
            // 用二维数组表示每个索引位置对应的value值
            for (int i = 0; i < n; i++) {
                val[i][0] = aliceValues[i] + bobValues[i];
                val[i][1] = aliceValues[i];
                val[i][2] = bobValues[i];
            }
            // 逆序排序
            Arrays.sort(val, (a, b) -> (b[0] - a[0]));
            int aSum = 0, bSum = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    aSum += val[i][1];
                } else {
                    bSum += val[i][2];
                }
            }
            if (aSum > bSum) {
                return 1;
            } else if (aSum == bSum) {
                return 0;
            } else {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}