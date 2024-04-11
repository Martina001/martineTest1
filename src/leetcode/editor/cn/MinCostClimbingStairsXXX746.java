//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// Related Topics 数组 动态规划 👍 1461 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：使用最小花费爬楼梯
public class MinCostClimbingStairsXXX746{
public static void main(String[] args) {
Solution solution = new MinCostClimbingStairsXXX746().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
       /* int n = cost.length;
        int memo[] = new int[n];
        Arrays.fill(memo,-1);
        memo[0] = cost[0];
        memo[1] = cost[1];
        dfs(cost,n-1,memo);
        return Math.min(memo[n-1],memo[n-2]);*/
        return dp1(cost);
    }

    private int dfs(int[] cost,int i,int []memo){
        if(memo[i] != -1) return memo[i];
        if(i == 0){
            return memo[i];
        }
        if(i == 1){
            return memo[i];
        }
        memo[i] = Math.min(dfs(cost,i-1,memo),dfs(cost,i-2,memo))+cost[i];
        return memo[i];
    }

    /**
     * 再来根据dfs写一下动规
     * @param cost
     * @return
     */
    private int dp1(int []cost){
        int n = cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i<n;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}