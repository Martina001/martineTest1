//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 214 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：跳跃游戏 VI
public class JumpGameViXXX1696 {
    public static void main(String[] args) {
        Solution solution = new JumpGameViXXX1696().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
        /*
        // 这个好像通过不了所有的测试用例 估计是上限问题
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[n-1]= nums[n-1];
        for(int i = n-2;i>=0;i--){
            int val = nums[i];
            for(int j = i+1;j<=Math.min(i+k,n-1);j++){
                dp[i] = Math.max(dp[i],dp[j]+val);
            }
        }
        return dp[0];*/

            // 尝试从dp[0]推演到dp[n]
            // 跟上面一样 超时了
       /* int dp[] = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = nums[0];
        for(int i =1;i<n;i++) {
            int val = nums[i];
            for(int j =Math.max(i-k,0);j< i;j++){
                dp[i] = Math.max(dp[i],dp[j]+val);
            }
        }
        return dp[n-1];*/

            // 每位置的最值取决于前k个位置的最大值
            // 我们来改善一下 把内层循环替换成优先队列（O(NLogN)）或者双端队列（O(n)）
            // 这里我们用双端队列 每次存储前k里最大值的索引
            int dp[] = new int[n];
//        Arrays.fill(dp,Integer.MIN_VALUE);
            dp[0] = nums[0];
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(0);
            for (int i = 1; i < n; i++) {
                //取到i-k处的索引
                while (queue.peekFirst() < i - k) {
                    queue.pollFirst();
                }
                dp[i] = dp[queue.peekFirst()] + nums[i];

                // 将当前索引插入队列中，保证当前索引前面的索引处的dp值都比现在的大
                while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}