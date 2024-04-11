//Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。 
//
// 一开始，有 n 个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。 
//
// 如果石子堆里没有石子了，则无法操作的玩家输掉游戏。 
//
// 给你正整数 n ，且已知两个人都采取最优策略。如果 Alice 会赢得比赛，那么返回 True ，否则返回 False 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：Alice 拿走 1 个石子并赢得胜利，因为 Bob 无法进行任何操作。 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
//解释：Alice 只能拿走 1 个石子，然后 Bob 拿走最后一个石子并赢得胜利（2 -> 1 -> 0）。 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：true
//解释：n 已经是一个平方数，Alice 可以一次全拿掉 4 个石子并赢得胜利（4 -> 0）。
// 
//
// 示例 4： 
//
// 
//输入：n = 7
//输出：false
//解释：当 Bob 采取最优策略时，Alice 无法赢得比赛。
//如果 Alice 一开始拿走 4 个石子， Bob 会拿走 1 个石子，然后 Alice 只能拿走 1 个石子，Bob 拿走最后一个石子并赢得胜利（7 ->
// 3 -> 2 -> 1 -> 0）。
//如果 Alice 一开始拿走 1 个石子， Bob 会拿走 4 个石子，然后 Alice 只能拿走 1 个石子，Bob 拿走最后一个石子并赢得胜利（7 ->
// 6 -> 2 -> 1 -> 0）。 
//
// 示例 5： 
//
// 
//输入：n = 17
//输出：false
//解释：如果 Bob 采取最优策略，Alice 无法赢得胜利。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 
//
// Related Topics 数学 动态规划 博弈 👍 59 👎 0

package leetcode.editor.cn;
//Java：石子游戏 IV
public class StoneGameIvXXX1510{
public static void main(String[] args) {
Solution solution = new StoneGameIvXXX1510().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    一开始，有 n 个石子堆在一起。每个人轮流操作，
//    正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。
    // 判断先手是否能胜，也就是先手拿最后一堆
    public boolean winnerSquareGame(int n) {
        // 定义dp[i]表示还剩i个的时候先手是否能赢，也就是后手没得拿了，那么i最大应为n，故初始化长度n+1
        boolean dp[] = new boolean[n+1];
        // 也就是先手也没得拿 返回false，dp[0] = false;

        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(!dp[i-j*j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        /*
        // 下面这种定义不行，但是没看出来哪里不行 todo
        // 一样的定义dp[i]表示从第i个开始拿是否能赢，如果i=n-1一定返回true
        boolean dp[] = new boolean[n];
        dp[n-1] = true;
        for(int i = n-1;i>=0;i--){
            for(int j = 1;i+j*j<n;j++){
                if(!dp[i+j*j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}