//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2695 👎 0

package leetcode.editor.cn;
//Java：跳跃游戏
public class JumpGameXXX55{
public static void main(String[] args) {
Solution solution = new JumpGameXXX55().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        // 很明显是一个动规的题目，我们设计dp[i]为从第i步跳到n-1步的时候是否可行
        /*if(null == nums || nums.length == 0) return true;
        int n = nums.length;
        boolean dp[] = new boolean[n];
        dp[n-1]= true;
        for(int i = n-2;i>=0;i--){
            int val =nums[i];
            for(int j = i+1;j<=Math.min(i+val,n-1);j++){
                // 这里可以做一个优化 // dp[i] = dp[i]||dp[j];
                if(dp[j]){
                    dp[i] = true;break;
                }

            }
        }
        return dp[0];*/
        return canJump1(nums);
    }
    // 写一下题解 换一种思路 从前到后
    private boolean canJump1(int[] nums) {
        int n = nums.length;
        int right = 0;
        for(int i =0;i<n;i++) {
            // 如果这时候right已经在i的左边了，说明已经跳不到了
            if (i <= right) {
                int val = nums[i];
                // 只要能跳到最后就行
                right = Math.max(right, i + val);
                if (right >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}