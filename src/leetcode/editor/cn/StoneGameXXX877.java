//Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。 
//
// Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此
//时手中 石子最多 的玩家 获胜 。 
//
// 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [5,3,4,5]
//输出：true
//解释：
//Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
//如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：piles = [3,7,2,3]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是 偶数 
// 1 <= piles[i] <= 500 
// sum(piles[i]) 是 奇数 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 533 👎 0

package leetcode.editor.cn;
//Java：石子游戏
public class StoneGameXXX877{
public static void main(String[] args) {
Solution solution = new StoneGameXXX877().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        // 这道题是数学游戏，因为题目指定了共偶数堆，总数是奇数，那么索引为偶数的堆和索引为奇数的堆的总和一定不一样
        // 既然是Alice先拿，她可以先算出堆总和较大的是索引为奇数的堆还是偶数的堆，每次就只拿对应索引的石头就行了
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}