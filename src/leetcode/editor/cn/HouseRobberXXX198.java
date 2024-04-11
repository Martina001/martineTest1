//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2942 👎 0

package leetcode.editor.cn;
//Java：打家劫舍
public class HouseRobberXXX198{
public static void main(String[] args) {
Solution solution = new HouseRobberXXX198().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 重点在定义，定义dp[i]为从i开始打劫得到的最大分数，那么后面需要有两个虚拟的房间
        int n = nums.length;
       /* int dp[] = new int[n+2];
        dp[n+1]= 0;
        dp[n] = 0;
        for(int i = n-1;i >=0;i--){
            dp[i] = Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        return dp[0];*/
        // 我们再来尝试一下定义dp[i]为打劫了i家时的最大分数 那么dp[0]就是0，dp[1]就是num[0] dp[2]=Max(dp[1],nums[1]+dp[0])
        // 所以 dp[i] = Max(dp[i-1],dp[i-2]+num[i-1])
        /*int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i <=n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];*/
        // 再来尝试一下空间压缩，先压缩第一种dp定义
        /*int dp0 = 0,dp1= 0,dp2 = 0;
        for(int i = n-1;i >=0;i--){
            dp0 = Math.max(dp1,dp2+nums[i]);
            dp2 = dp1;
            dp1 = dp0;
        }
        return dp0;
        */
        // 再压缩第二种dp定义
//        int dp0 = nums[0],dp1= Math.max(nums[0],nums[1]);
        int dp0=0,dp1=0;
        for(int i=0;i<n;i++){
            int temp = dp1;
            dp1 = Math.max(dp0+nums[i],dp1);
            dp0 = temp;
        }
        return dp1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}