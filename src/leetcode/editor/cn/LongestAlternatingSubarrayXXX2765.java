//给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ： 
//
// 
// m 大于 1 。 
// s1 = s0 + 1 。 
// 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - 
//s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)ᵐ 。 
// 
//
// 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。 
//
// 子数组是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,3,4]
//输出：4
//解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6]
//输出：2
//解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 枚举 👍 37 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java：最长交替子数组
public class LongestAlternatingSubarrayXXX2765{
public static void main(String[] args) {
Solution solution = new LongestAlternatingSubarrayXXX2765().new Solution();
// TO TEST
    int[] nums =new int[]{2,3,4,3,4};
    int i = solution.alternatingSubarray(nums);
    System.out.println(i);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int alternatingSubarray(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int len = nums.length;
        int firstIndex = 0;
        int res =0;
       for(int i =0;i<len;i++){
           int size = i-firstIndex+1;
           // 首先必须要知道有这种规律，内外层循环的序号和（size-1）%2数值之间的关系
           if(nums[i]-nums[firstIndex] == (size-1)%2){
               res = Math.max(res,size);
           }else{
               // 这里是为了不用双层循环，当内循环结束的时候，直接判断外层循环firstIndex从i-1开始还是从i开始即可
               if(nums[i] - nums[i-1] == 1){
                   firstIndex = i-1;
                   res = Math.max(res,2);
               }else{
                   firstIndex = i;
               }
           }
       }
       return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}