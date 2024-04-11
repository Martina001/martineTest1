//沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。 
//
// 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。 
//
// 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。 
//
// 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。 
//
// 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。 
//
// 返回小偷的 最小 窃取能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,5,9], k = 2
//输出：5
//解释：
//小偷窃取至少 2 间房屋，共有 3 种方式：
//- 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
//- 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
//- 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
//因此，返回 min(5, 9, 9) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1], k = 2
//输出：2
//解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= (nums.length + 1)/2 
// 
//
// Related Topics 数组 二分查找 👍 221 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.mystructure.TreeNode;

import java.util.Collections;

//Java：打家劫舍 IV
public class HouseRobberIvXXX2560 {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIvXXX2560().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        一排房屋，不能相邻被偷，k为至少偷的房屋数，求最小的窃取能力，窃取能力就是单间最大金额
        k>1,很明显，题目所求一定在nums的最小值和最大值中间取，二分法就行了
        从min到max之间找中点x，只要小于x的时候就偷，看总共偷的次数是不是大于等同于k ，找到所有大于等于k的x的最小值，也就是左边界
        根据之前的打家劫舍问题198的解法，
         */
        public int minCapability(int[] nums, int k) {
            // 由于最小窃取能力越小，盗取房屋数就越小，
            // 假设最小窃取能力为x，dp(x)表示盗取房屋数目，那么dp(x)单调递增，所以找到dp(x)>=k时的x的最小值即可
            int left = 0, right = 0;
            for (int x : nums) {
                right = Math.max(right, x);
                left = Math.min(left, x);
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                // 按照隔间偷一次的情况将价值不大于mid的房屋都偷了的话，被偷房屋总数
                int cnt = getCount(nums, mid);
                // 判断房屋总数是否大于k，如果房屋总数满足要求，最小窃取能力就可以再减少
                if (cnt >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 因为题目要求 窃取能力是只要能偷就得偷
         * 所以要求count最大，所以忽略连着两个num都满足小于max但是两个都不偷的情况
         *
         * @param nums
         * @param max
         * @return
         */
        private int getCount(int nums[], int max) {
            int n = nums.length;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                // 只要小于能窃取的最大值，就偷
                if (nums[i] <= max) {
                    cnt++;
                    i++;
                }
            }
            return cnt;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}