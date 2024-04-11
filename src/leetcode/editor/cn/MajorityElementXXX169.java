//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2158 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：多数元素
public class MajorityElementXXX169 {
    public static void main(String[] args) {
        Solution solution = new MajorityElementXXX169().new Solution();
// TO TEST
        int[] a = new int[]{-1, 100, 2, 100, 100, 4, 100};
        int i = solution.majorityElement(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 时间复杂度是O(n) 空间复杂度也是O(n) 简单 用hashMap就行 这里我们直接看进阶版本 限制空间复杂度O(1)
            // 自己写的：先排序，然后双指针，但是性能不高，时间复杂度是o(nlogn)，空间复杂度o(1)
        /*Arrays.sort(nums);
        int n = nums.length;
        if(n == 1){
            return nums[n-1];
        }
        int k = n/2;
        int left=0,right=1;
        int maxK = 1;
        while(right<n){
            while(right<n &&  nums[right] == nums[left]){
                right++;
            }
            maxK = Math.max(maxK,right-left);
            if(maxK > k){
                return nums[left];
            }
            left = right;
        }
        return -1;*/
            // 进阶1（最建议的解法）：先排序，所求的数其实就是排序后索引位置为n/2的数 时间复杂度是o(nlogn)，空间复杂度o(1)
           /* Arrays.sort(nums);
            return nums[nums.length / 2];*/
            // 进阶 投票，时间复杂度是o(n)，空间复杂度o(1)
            // 其实就是一个找规律的题目，由于众数总是最多的那个，所以遇到众数就+1，否则-1，
            // 那么每次count==0 的时候就是找到了一个新的频率较高的数，循环结束后，这个数字就是众数
            int count = 0;
            Integer candidate = null;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
            // 以下进阶解法都不符合题目复杂度的要求，只是用来拓展思路
            // 进阶2：随机选一位，判断count是否>n/2，但是这样最坏的时间复杂度很高，不建议
            // 进阶3 分治 有点复杂

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}