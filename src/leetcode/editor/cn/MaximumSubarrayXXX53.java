//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
//
// Related Topics 数组 分治 动态规划 👍 6623 👎 0

package leetcode.editor.cn;

//Java：最大子数组和
public class MaximumSubarrayXXX53 {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarrayXXX53().new Solution();
// TO TEST
        int i = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            // 以当前索引位的数字为子数组结尾数字时的最大值
        /*int dp[] = new int[n];
        dp[0]=nums[0];
        for(int i = 1;i<n;i++){
            int val = nums[i];
            dp[i] = Math.max(val, dp[i - 1]+ val);
        }
        int  max = Integer.MIN_VALUE;
        for(int num:dp){
            if(num>max){
                max = num;
            }
        }
        return max;*/
            // try一下分治解法 这个需要动点脑子，可以再看看
            return mergeM(nums, 0, n - 1);
        }

        int max = Integer.MIN_VALUE;

        private int mergeM(int nums[], int left, int right) {
            if (left > right) {
                return max;
            }
            if (left == right) {
                return nums[left];
            }
            int mid = (right - left) / 2 + left;
            int leftMax = mergeM(nums, left, mid);
            int rightMax = mergeM(nums, mid + 1, right);
        /*int sum = 0;
        for(int i = left;i<=right;i++){
            sum+=nums[i];
        }*/
            // 还缺一个包含了mid和mid+1的子数组
            int sum = getMaxCrossing(nums, left, mid, right);
            return Math.max(Math.max(leftMax, rightMax), sum);
        }

        private int getMaxCrossing(int nums[], int left, int mid, int right) {
            // 分别从mid和mid+1开始向两边扩散，找出包含mid和mid+1的连续子数组的最大和
            int sum = 0, leftSumMax = Integer.MIN_VALUE;
            for (int i = mid; i >= left; i--) {
                sum += nums[i];
                if (sum > leftSumMax) {
                    leftSumMax = sum;
                }
            }

            sum = 0;
            int rightSumMax = Integer.MIN_VALUE;
            // 计算以 mid+1 开始的最大的子数组的和
            for (int i = mid + 1; i <= right; i++) {
                sum += nums[i];
                if (sum > rightSumMax) {
                    rightSumMax = sum;
                }
            }
            return leftSumMax + rightSumMax;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}