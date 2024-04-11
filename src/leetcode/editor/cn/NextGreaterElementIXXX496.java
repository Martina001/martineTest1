//nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。 
//
// 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。 
//
// 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 
//nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。 
//
// 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出：[-1,3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4], nums2 = [1,2,3,4].
//输出：[3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 10⁴ 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
//
// Related Topics 栈 数组 哈希表 单调栈 👍 1033 👎 0

package leetcode.editor.cn;

import netscape.javascript.JSObject;

import java.util.*;

//Java：下一个更大元素 I
public class NextGreaterElementIXXX496 {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIXXX496().new Solution();
// TO TEST
        solution.danDiaoStack(new int[]{1,3,4,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] resNums2 = danDiaoStack(nums2);
            Map<Integer,Integer> biggerMap = new HashMap<>();
            for(int i= 0;i<nums2.length;i++){
                biggerMap.put(nums2[i],resNums2[i]);
            }
            int res[] = new int[nums1.length];
            Arrays.fill(res,-1);
            for(int i = 0;i<nums1.length;i++){
                res[i] = biggerMap.get(nums1[i]);
            }
            return res;
        }

        /**
         * 单调栈找下一个较大元素
         *
         * @param nums
         * @return
         */
        private int[] danDiaoStack(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            // java中的栈一般是Deque（双端队列），不用Stack是因为其暴露了set/get方法，且没有先进后出的语义
            // deque一般就是ArrayDeque或者linkedList。一般用前者稍好。
            // 注意一般栈就是push和pop，队列是offer和poll。双端队列的offer/push，poll和pop都有。他也有removeFirst和removeLast
            Deque<Integer> stack = new ArrayDeque<>();
            // 单调栈的特殊就是要倒着走
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    res[i] = stack.peek();
                }
                stack.push(nums[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}