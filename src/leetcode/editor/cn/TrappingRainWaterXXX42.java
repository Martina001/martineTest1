//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5074 👎 0

package leetcode.editor.cn;
//Java：接雨水
public class TrappingRainWaterXXX42{
public static void main(String[] args) {
Solution solution = new TrappingRainWaterXXX42().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 直观一点 题目所求可以分成子问题来看，当前位置可接的雨水可以用 Min(当前值左边最高柱，当前值右边最高柱)-当前值高度 来计算
        // 那么剩下的就是如何简化这个计算
        // 优化1 类似前缀和，提前算好每个位置的两侧最大值
        /*int n = height.length;
        int [] left = new int[n];
        int [] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];
        // left[i]表示i位置左边的最大值（包含i位置本身）
        for(int i = 1;i<n;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int i = n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }

        int sum =0;
        for(int i = 1;i<n-1;i++){
            int val= Math.min(left[i],right[i])-height[i];
            sum += val;
        }

        return sum;*/
        return trap1(height);
    }
    // 优化2 采用的双指针，空间复杂度降为O1
    private int trap1(int [] nums){
        int n = nums.length;
        int leftMax =0,rightMax = 0;
        int left = 0,right = n-1;
        int res = 0;
        while(left < right){
            leftMax = Math.max(leftMax,nums[left]);
            rightMax =  Math.max(rightMax,nums[right]);

            // 每次找左右两侧最大值的较小值进行计算，该位置随之移动
            if(leftMax<rightMax){
                res += leftMax-nums[left];
                left++;
            }else{
                res += rightMax -nums[right];
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}