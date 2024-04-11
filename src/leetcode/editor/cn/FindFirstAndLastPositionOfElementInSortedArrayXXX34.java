//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2528 👎 0

package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArrayXXX34 {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArrayXXX34().new Solution();
// TO TEST
        int[] nums = {5, 7, 7, 8, 8, 10};
//    solution.searchLeft(nums,0,6,8);

        solution.searchRight(nums, 0, 6, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            /*int l = searchLeft(nums, 0, nums.length, target);
            int r = searchRight(nums, 0, nums.length, target);
            return new int[]{l, r};*/
            return new int[]{binarySearch(nums,target,0),binarySearch(nums,target,1)};
        }

        /**
         * 二分查找：左闭右开搜索左边界
         *
         * @param nums
         * @param l
         * @param r
         * @param target
         * @return
         */
        private int searchLeft(int[] nums, int l, int r, int target) {
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (target < nums[mid]) {
                    r = mid;
                } else if (target == nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l >= 0 && l < nums.length && nums[l] == target) {
                return l;
            } else {
                return -1;
            }
        }

        private int searchRight(int[] nums, int l, int r, int target) {
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (target < nums[mid]) {
                    r = mid;
                } else if (target == nums[mid]) {
                    l = mid + 1;
                } else {
                    l = mid + 1;
                }
            }
            // 注意我们是左闭右开，所以r指向的不等于target的边界，要返回r-1
            if (r > 0 && r - 1 < nums.length && nums[r - 1] == target) {
                return r - 1;
            } else {
                return -1;
            }
        }

        /**
         * 我们用一个方法传参来决定到底是拿右边界还是左边界
         *
         * @param nums
         * @param target
         * @param leftOrRight
         * @return
         */
        private int binarySearch(int[] nums, int target, int leftOrRight) {
            int l = 0,r =nums.length;
            while(l<r){
                int mid =(r-l)/2+l;
                if(target<nums[mid]){
                    r=mid;
                }else if(target == nums[mid]){
                    if(leftOrRight == 0){
                        r=mid;
                    }else{
                        l = mid+1;
                    }
                }else if(target>nums[mid]){
                    l = mid+1;
                }
            }
            int res = l-leftOrRight;
            if(res >=0 && res < nums.length && nums[res] == target){
                return res;
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}