//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。 
//
// 设计一个算法使得这 k 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 947 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：分割数组的最大值
public class SplitArrayLargestSumXXX410{
public static void main(String[] args) {
Solution solution = new SplitArrayLargestSumXXX410().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int k) {
        // 求和的最大值最小，分段之后，最大值的范围为[max(nums),sum(nums)]
        // 在此范围内，分别进行分段 看段数和k之间的对比即可得到当段数趋近于k的时候，结果值的最小值
        // 即找左侧边界 对应1011 在D天内送达包裹的能力
        // 画图可以得到 随着 数组和最大值的增加，k变小，所以单调减，根据图可以判断找左区间还是右区间
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        // 因为k至少是1，所以right可以取到
        right += 1;
        while(left < right){
            int mid=(right-left)/2+left;
            int tempK = split(nums,mid);
            // 如果分段比k小，说明mid和的值偏大，要继续往左侧走
            if(tempK<=k){
                right =mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    private int split(int nums[],int midSum){
        int sum =0,k = 1;
        for(int i =0;i<nums.length;i++){
            if(sum+nums[i] > midSum){
                k++;
                sum = 0;
            }
            sum += nums[i];
        }
        return k;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}