//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1734 👎 0

package leetcode.editor.cn;

import java.util.Objects;

//Java：除自身以外数组的乘积
public class ProductOfArrayExceptSelfXXX238 {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelfXXX238().new Solution();
// TO TEST
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(ints.length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (Objects.isNull(nums)) return null;
            // 这题明显是一个前缀和的题
            // 先写一个前缀和（前缀积）
       /* int [] pre = new int[nums.length+1];
        pre[0] = 1;
        for(int i = 0;i<nums.length;i++){
            pre[i+1] = pre[i]*nums[i];
        }
        // 再写一个后缀积
        int[] suffix = new int[nums.length+1];
        int len = nums.length;
        suffix[0] = 1;
        for(int i = nums.length-1;i>=0;i--){
            suffix[len-i] = suffix[len-i-1]*nums[i];
        }
        int res[] = new int[len];
        for(int i = 0;i<nums.length;i++){
            res[i] = pre[i]*suffix[len-i-1];
        }
        return res;*/

            // 简单一点 pre和suffix都指定len长度
            // pre只乘到倒数第二个，pre[0]=1（第一位左侧无值），pre[len-1]=除了倒数第一个值以外的乘积
            // suffix[0]=1（最后一位右侧无值）,suffix[len-1]=除了第一个值之外的乘积
            int len = nums.length;
            int[] pre = new int[nums.length];
            int[] suffix = new int[len];

            pre[0] = 1;
            suffix[len - 1] = 1;

            for (int i = 1; i < len; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }

            for (int i = len - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }

            int res[] = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = pre[i] * suffix[i];
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}