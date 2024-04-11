//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 91 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：数组中的第 K 个最大元素
public class Xx4gT2XXXLCR076 {
    public static void main(String[] args) {
        Solution solution = new Xx4gT2XXXLCR076().new Solution();
// TO TEST
        int a = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (k > nums.length) return -1;
            random(nums);
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length - k];
        }

        /**
         * 快排会超时
         *
         * @param nums
         * @param l
         * @param r
         */
        private void quickSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int p = getPartition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }

        private int getPartition(int[] nums, int l, int r) {
            int pivot = nums[l];
            int temp = l;
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] < pivot) {
                    ++temp;
                    swap(nums, i, temp);
                }
            }
            swap(nums, temp, l);
            return temp;
        }

        private void swap(int nums[], int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

        private void random(int[] nums) {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int r = i + random.nextInt(nums.length - i);
                swap(nums, i, r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

// 先写一个快速排序吧
// 然后在写一个归并和堆排序


}