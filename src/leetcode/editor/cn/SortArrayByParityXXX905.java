//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
//
// Related Topics 数组 双指针 排序 👍 373 👎 0

package leetcode.editor.cn;

//Java：按奇偶排序数组
public class SortArrayByParityXXX905 {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityXXX905().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 兄弟双指针调换
         * @param nums
         * @return
         */
        public int[] sortArrayByParity(int[] nums) {
            int l = 0,r = 0;
            while(r<nums.length){
                if((nums[r] & 1) == 0){
                    swap(nums,l,r);
                    l++;
                }
                r++;
            }
            return nums;
        }

        /**
         * 前后双指针调换，这样不能保证原有数组的顺序
         *
         * @param nums
         * @return
         */
        private int[] notByIndex(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                while (l <= r && (nums[l] & 1) == 0) {
                    l++;
                }
                while (l <= r && (nums[r] & 1) == 1) {
                    r--;
                }
                swap(nums, l, r);
                l++;
                r--;
            }
            return nums;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}