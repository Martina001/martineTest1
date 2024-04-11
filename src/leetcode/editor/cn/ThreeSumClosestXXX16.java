//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1588 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：最接近的三数之和
public class ThreeSumClosestXXX16 {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosestXXX16().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            //三数之和就是在两数之和的基础上多了一层循环，两数之和可以用双指针，三数也同理
            // 第一层循环+双指针解决第二第三层循环
            // 第一步，先排序
            int n = nums.length;
            Arrays.sort(nums);
            int tempSum = 0;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int k = n - 1;
                int j = i + 1;
                while (j < k) {
                    // 这一段优化：找出最大值和最小值，如果target不在这个范围内，就不必要继续循环
                    int min = nums[i] + nums[j] + nums[j + 1];
                    if (target < min) {
                        if (Math.abs(res - target) > Math.abs(min - target))
                            res = min;
                        break;
                    }
                    int max = nums[i] + nums[k] + nums[k - 1];
                    if (target > max) {
                        if (Math.abs(res - target) > Math.abs(max - target))
                            res = max;
                        break;
                    }
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    tempSum = nums[j] + nums[k] + nums[i];
                    if (tempSum == target) return target;
                    if (Math.abs(tempSum - target) < Math.abs(res - target)) {
                        res = tempSum;
                    }
                    // 第二个指针必须保持在第三个指针前面
                    if (tempSum > target) {
                        k--;
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (tempSum < target) {
                        j++;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}