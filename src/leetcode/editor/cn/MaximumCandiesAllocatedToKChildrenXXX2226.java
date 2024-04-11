//给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆
// ，但 无法 再将两堆合并到一起。 
//
// 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。 
//
// 返回每个小孩可以拿走的 最大糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：candies = [5,8,6], k = 3
//输出：5
//解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分
//别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：candies = [2,5], k = 11
//输出：0
//解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 
//。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candies.length <= 10⁵ 
// 1 <= candies[i] <= 10⁷ 
// 1 <= k <= 10¹² 
// 
//
// Related Topics 数组 二分查找 👍 64 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：每个小孩最多能分到多少糖果
public class MaximumCandiesAllocatedToKChildrenXXX2226 {
    public static void main(String[] args) {
        Solution solution = new MaximumCandiesAllocatedToKChildrenXXX2226().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            // 理解题意之后很快就能得出 随着单个堆的数目x增加，拿到x的小孩个数y变小，所以y=f(x)单调减，使用二分法非常快速
            // 要求最大x，也就是右边界
            // 关注点在于 每次得到的mid值是要去被nums[i]除的，0不能做除数，所以左边界要从1开始。由于左闭右开的循环，所以right为最大值+1，最后right-1
            // 下面这种左闭右闭的循环也可，因为right是可以被取到的
            int left = 1, right = Arrays.stream(candies).max().getAsInt();
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                long childNum = getChildNum(candies, mid);
                if (childNum >= k) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
            return right;
        }

        private long getChildNum(int[] nums, int targetNum) {
            // 备注 这里一定要是long。int会溢出 结果就不对了
            long res = 0;
            for (int num : nums) {
                res += num / targetNum;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}