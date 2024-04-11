//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 972 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：排序数组
public class SortAnArrayXXX912 {
    public static void main(String[] args) {
        Solution solution = new SortAnArrayXXX912().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
           /* // 快排都超时
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int k = i+random.nextInt(nums.length-i);
                swap(nums,i,k);
            }
            quickSort(nums,0,nums.length-1);*/
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int nums[], int l, int r) {
            if (l >= r) return;

            int mid = (r - l) / 2 + l;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }

        private void merge(int nums[], int l, int mid, int r) {
            int temp[] = new int[r - l + 1];
            int i = l, j = mid + 1;
            int k = 0;
            while (i <= mid && j <= r) {
                if (nums[i] >= nums[j]) {
                    temp[k++] = nums[j++];
                } else {
                    temp[k++] = nums[i++];
                }
            }

            while (i <= mid) {
                temp[k++] = nums[i++];
            }
            while (j <= r) {
                temp[k++] = nums[j++];
            }
            // 回归到原数组
            for (int kk = 0; kk < temp.length; kk++) {
                nums[kk + l] = temp[kk];
            }
        }


        private void quickSort(int nums[], int l, int r) {
            if (l >= r) return;
            int p = getP(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }

        private int getP(int num[], int l, int r) {
            int p = num[l];
            int temp = l;
            for (int i = l + 1; i <= r; i++) {
                if (num[i] <= p) {
                    temp++;
                    swap(num, temp, i);
                }
            }
            swap(num, l, temp);
            return temp;
        }

        private void swap(int nums[], int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}