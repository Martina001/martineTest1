//给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。 
//
// 两个数的 最大公约数 是能够被两个数整除的最大正整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,5,6,9,10]
//输出：2
//解释：
//nums 中最小的数是 2
//nums 中最大的数是 10
//2 和 10 的最大公约数是 2
// 
//
// 示例 2： 
//
// 输入：nums = [7,5,6,8,3]
//输出：1
//解释：
//nums 中最小的数是 3
//nums 中最大的数是 8
//3 和 8 的最大公约数是 1
// 
//
// 示例 3： 
//
// 输入：nums = [3,3]
//输出：3
//解释：
//nums 中最小的数是 3
//nums 中最大的数是 3
//3 和 3 的最大公约数是 3
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 数论 👍 36 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：找出数组的最大公约数
public class FindGreatestCommonDivisorOfArrayXXX1979 {
    public static void main(String[] args) {
        Solution solution = new FindGreatestCommonDivisorOfArrayXXX1979().new Solution();
// TO TEST
        int gcd = solution.findGCD(new int[]{});
        System.out.println(gcd);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findGCD(int[] nums) {
            // 排序 找最大值和最小值
            // 快排
            Arrays.sort(nums);
            int max = nums[nums.length - 1];
            int min = nums[0];
            return gcd(min, max);
        }

        // greatest common divisor
        public int gcd(int max, int min) {
            if (max == 0) return min;
            if (min == 0) return max;
            return gcd(min, max % min);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}