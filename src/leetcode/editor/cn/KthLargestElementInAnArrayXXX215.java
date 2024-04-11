//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2430 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：数组中的第K个最大元素
public class KthLargestElementInAnArrayXXX215 {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArrayXXX215().new Solution();
// TO TEST
        int kthLargest = solution.findKthLargest(new int[]{99, 99}, 1);
        System.out.println(kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 乍眼一看 直接排序，或者放入优先队列 那复杂度是O(NLogN) 优先级队列是O(NLogK) 但是题目要求 是O(N)
            // 直接使用快速选择算法，快速选择算法是基于快排的一个的求TopK的优秀解法
            int n = nums.length;
            if (null == nums || nums.length == 0 || k > n) return -1;
            // 注意快速选择算法是基于快排，一定要先打乱 或者在getP的时候取随机或者中位数为起始中枢点
            // shuffle(nums);
            // 找第k大，就是找第n-k+1小，索引就是n-k 下面这两种都超时
//            return getK(nums, 0, n - 1, n - k);
//            return getK1(nums, 0, n - 1, n - k);
            // 采用三数取中+荷兰国旗的写法
            return quickSelect(nums,0,n-1,n-k);
        }

        /**
         * 荷兰国旗问题（Dutch National Flag Problem）这个名称是由著名的计算机科学家 Edsger W. Dijkstra 提出的。
         * 这个问题和算法的名称来自荷兰国旗的三种颜色：红色、白色和蓝色。要求一次遍历就将同颜色的球放在一起
         * @param nums
         * @param low
         * @param high
         * @param k
         * @return
         */
        private int quickSelect(int nums[],int low,int high,int k){
            // 随机选择一个元素开始执行
            // 这里可以用三数取中的方式获取
            int medianOfThreeIndex = medianOfThree(nums, low, high);
            swap(nums,medianOfThreeIndex,low);
            int pivot = nums[low];
            // 荷兰国旗，三向划分，定义：[low,left)是小于pivot的， [left,right]是等于pivot的，(right,high]是大于pivot的
            int left = low,right =high,i = low+1;
            while(i<=right){
                // 注意这里的left不断后移，right不断前移，和right互换后i不用动。保证i一直在left和right之间
                if(nums[i]<pivot) swap(nums,left++,i++);
                else if(nums[i]>pivot) swap(nums,right--,i);
                else i++;
            }
            // 划分区间
            if(k<left) return quickSelect(nums,low,left-1,k);
            if(k>right) return quickSelect(nums,right+1,high,k);
            // k属于[left,right] 返回pivot 可以跳过重复的数字 避免这些数字在后序递归中被重复调用
            return pivot;
        }


        // 这里直接写一下荷兰国旗划分的方法
        // 调用之前记得先随机，int pivotIndex = low + rand.nextInt(high - low + 1);
        private int[] dutchFlagPartition(int[] nums, int low, int high, int pivotIndex) {
            int pivot = nums[pivotIndex];
            int smaller = low; // 小于枢轴的元素的末尾
            int greater = high; // 大于枢轴的元素的开头
            int i = low;
            while (i <= greater) {
                if (nums[i] < pivot) {
                    swap(nums, smaller++, i++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, greater--);
                } else {
                    i++;
                }
            }
            return new int[]{smaller, greater}; // 返回等于枢轴部分的索引范围，左闭右开
        }

        // 普通的找枢纽的写法
        // 这种写法，当数组中存在大量的重复元素的时候就会有很多不必要的开销 所以不行
        private int getP(int nums[], int low, int high) {
            if (low > high) {
                return -1;
            }
            int pivotIndex = low + random.nextInt(high - low);
            swap(nums, pivotIndex, low);
            int tempP = nums[low];
            int temp = low;
            for (int i = low + 1; i <= high; i++) {
                if (nums[i] <= tempP) {
                    temp++;
                    swap(nums, temp, i);
                }
            }
            swap(nums, low, temp);
            return temp;
        }

        /**
         * 获取中位数的索引
         * @param nums
         * @param left
         * @param right
         * @return
         */
        private int medianOfThree(int[] nums, int left, int right) {
            int middle = left + (right - left) / 2;

            return nums[left] > nums[middle] ? (nums[left] > nums[right] ? right : left) : (nums[middle] > nums[right] ? right : middle);
        }

        private int getK(int nums[], int left, int right, int k) {
            if (left == right) return nums[left];
            int p = getP(nums, left, right);
            if (p == k) {
                return nums[p];
            }
            if (p < k) {
                return getK(nums, p + 1, right, k);
            } else {
                return getK(nums, left, p - 1, k);
            }
        }

        private int getK1(int[] nums, int left, int right, int k) {
            while (true) {
                int p = getP(nums, left, right);
                if (p == k) {
                    return nums[p];
                } else if (p < k) {
                    left = p + 1;
                } else {
                    // pivotIndex > target
                    right = p - 1;
                }
            }
        }


        private void swap(int nums[], int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

        Random random = new Random();

        private void shuffle(int nums[]) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int indexRandom = random.nextInt(n - i);
                swap(nums, i, i + indexRandom);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}