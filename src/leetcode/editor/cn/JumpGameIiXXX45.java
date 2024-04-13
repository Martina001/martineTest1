//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2467 👎 0

package leetcode.editor.cn;

//Java：跳跃游戏 II
public class JumpGameIiXXX45{
public static void main(String[] args) {
Solution solution = new JumpGameIiXXX45().new Solution();
// TO TEST
    int jump = solution.jump(new int[]{5, 0, 3, 1, 0, 0});
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        /*double dp[] = new double[n];
        Arrays.fill(dp,Math.pow(10,5));
        dp[n-1]= 0;
        for(int i = n-2;i>=0;i--){
            int val =nums[i];
            for(int j = i+1;j<=Math.min(i+val,n-1);j++){
                dp[i] = Math.min(dp[i],dp[j]+1);
            }
        }
        return (int)dp[0];*/
        // 还是简单点好
        int right = 0,end =0,step =0;
        // i只用到n-2就可以了
        for(int i =0;i<n-1;i++) {
            // 如果这时候right已经在i的左边了，说明已经跳不到了
            if (i <= right) {
                int val = nums[i];
                // 最远边界
                right = Math.max(right, i + val);
                // 更新end为最远边界
                if (i == end) {
                    end = right;
                    step++;
                }
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}