//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7051 👎 0

package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArraysXXX4 {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArraysXXX4().new Solution();
// TO TEST
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{}, new int[]{1});
        System.out.println(medianSortedArrays);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 如果题目不要求时间复杂度是O(log(m+n)) 我们可以直接合并两个数组，归并找中位数，时间复杂度为O(n)
            // （假如nums1长度小于nums2）这里以二分法的解法做一下，
            // 最妙的点在于 二分找的是满足要求的nums1的分割点所在位置，要找中位数，知道了nums1的分割点，就可以知道了nums2的分割点，
            // 这样，分割点的概念为 "nums1左边+nums2左边的个数"与"nums1右边+nums2右边的个数"之差在1以内，且此时nums1分割点处的值一定小于nums2分割点处后一位的值
            // 所以 二分法找到了满足要求的分割点后，中位数就可由两个分割点左右两边的四个数值来确定
       /* if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        // 不管m+n是奇数还是偶数，中位数左边的个数都为 (m+n+1)/2，因为int类型向下取整
        int totalLeft = (m+n+1)/2;
        //开始二分查找最左边界
        int left = 0,right = m;

        // 左闭右开
        while(left<right){
            // 如果数组个数是奇数 我们就假设左边的个数为多一方
            // 所以这里记得+1，因为mid要-1
            int mid = (right-left+1)/2+left;
            int j = totalLeft -mid;
            if(nums1[mid-1]>nums2[j]){
                // 这里是要比较mid-1，所以right赋值也是mid-1
                right = mid-1;
            }else{
                left = mid;// 也就是（mid-1）+1
            }
        }
        // 找到了满足要求的分割点的最左边界
        int i = left;
        int j = totalLeft -i;

        int nums1LeftMax = (i==0)? Integer.MIN_VALUE:nums1[i-1];
        int nums2LeftMax = (j==0)?Integer.MIN_VALUE:nums2[j-1];

        int nums1RightMin = (i==m)?Integer.MAX_VALUE:nums1[i];
        int nums2RightMin = (j==n)?Integer.MAX_VALUE:nums2[j];

        if((m+n)%2 ==0){
            int maxAndMin = Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin);
            // 注意 这里返回值是double 别直接除以2
            return maxAndMin/2.0;
        }else{
            return Math.max(nums1LeftMax,nums2LeftMax);
        }*/
//            return findMedian(nums1, nums2);
            // 用findK来解题
            double medianSortedByK = findMedianSortedByK(nums1, nums2);
            return medianSortedByK;
        }

        // 上述的解法中，二分法找分割点边界有点不够清晰，我们换一种方式
        private double findMedian(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedian(nums2, nums1);
            }
            int m = nums1.length;
            int n = nums2.length;

            int leftMax = 0, rightMin = 0;
            // 不管m+n是奇数还是偶数，中位数左边元素的个数总是可以用(m+n+1)/2个来表示（如果是奇数，中位数本身也在左侧） 这里证明省略，自己代入验证即可
            // 知道了两个数组的中位数左边元素的个数，又知道了第一个数组的左边元素个数，就可以得出另一个数组中在左边的元素个数
            int totalLeftCount = (m + n + 1) / 2;

            int left = 0, right = m;
            // 左闭右闭
            while (left <= right) {
                // mid：数组1中左边元素的个数
                int mid = (right - left) / 2 + left;
                // j：数组2中左边元素的个数
                int j = totalLeftCount - mid;

                // 这时索引为mid-1的数值就是数组1中左边元素的最大值；索引为j的数值就是数组2右边元素的最小值
                int leftMax1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
                int rightMin1 = (mid == m) ? Integer.MAX_VALUE : nums1[mid];

                int leftMax2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
                int rightMin2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

                // 边界收缩 要找的就是满足leftMax1<=rightMin2时的mid的最大值 也就是右边界
                // 注意不可直接判读 nums1[mid-1]<=nums2[j] 因为可能mid为0或者j为n，数组索引就溢出了
                if (leftMax1 <= rightMin2) {
                    left = mid + 1;
                    // 这里是数值 不是索引
                    leftMax = Math.max(leftMax1, leftMax2);
                    rightMin = Math.min(rightMin1, rightMin2);
                } else {
                    right = mid - 1;
                }
            }

            // 二分结束后，leftMax和rightMin就是我们的目标了
            if ((m + n) % 2 == 0) {
                return (leftMax + rightMin) / 2.0;
            } else {
                // 前面totalLeftCount = (m+n+1)/2的定义中已经说明，如果总数为奇数，中位数在左侧
                return leftMax;
            }
        }

        // 再来写一个在两个数组中找第k大的数，findKth
        // 首先 单个数组找第K大的数见215题，解法为快速选择法结合荷兰国旗提升效率
        // 双数组找第K大（或者第K小）的数 思路跟单个的很像，每次排除一些，就可以降低复杂度
        // 重点就在每次要排除的到底是哪些，我们来分析一下：

        // 首先要找第k小的数，两个数组中各找k/2个，也就是索引位为 k/2-1 这样的索引对应两个数组中的两个数，如果哪个小（例如A[k/2-1]较小），其左边元素就是为两个数组中索引数为[0,k/2-1]的元素，总个数k/2-2,说明A[k/2-1]左侧肯定都不会是第k/2小的数，就可以将其左边排除
        // 每次排除一些数（例如排除了x个）之后，要找的第K小就变成第K-x小
        // 很明显需要用到循环/递归，结束条件就是此时较小的数组已经被排除完了；或者要找的K已经变成1了
        // 注意边界情况 如果k/2-1已经溢出 要赋值为索引最大值
        public double findMedianSortedByK(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;

            // 注意中位数的取法
            int midLeft = (n + m + 1) / 2;
            int midRight = (n + m + 2) / 2;
            // 找中位数 就是找第 (n + m + 1) / 2 小的数 和第(n + m + 2) / 2小的数，两数除以2
            // 如果是总长度为奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, midLeft) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, midRight)) * 0.5;
        }

        private double getKth(int[] nums1, int start, int end, int[] nums2, int left, int right, int k) {
            int len1 = end - start + 1;
            int len2 = right - left + 1;
            if (len1 > len2) return getKth(nums2, left, right, nums1, start, end, k);

            if (len1 == 0) return nums2[left + k - 1];
            if (k == 1) return Math.min(nums1[start], nums2[left]);

            int mid1 = start + Math.min(len1, k / 2) - 1;
            int mid2 = left + Math.min(len2, k / 2) - 1;

            if (nums1[mid1] <= nums2[mid2]) {
                return getKth(nums1, mid1 + 1, end, nums2, left, right, k - (mid1 - start + 1));
            } else {
                return getKth(nums1, start, end, nums2, mid2 + 1, right, k - (mid2 - left + 1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}