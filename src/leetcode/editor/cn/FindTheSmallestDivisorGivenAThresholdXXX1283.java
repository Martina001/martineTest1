//给你一个整数数组 nums 和一个正整数 threshold ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。 
//
// 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。 
//
// 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。 
//
// 题目保证一定有解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,5,9], threshold = 6
//输出：5
//解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
//如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,5,7,11], threshold = 11
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [19], threshold = 5
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10^4 
// 1 <= nums[i] <= 10^6 
// nums.length <= threshold <= 10^6 
// 
//
// Related Topics 数组 二分查找 👍 109 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：使结果不超过阈值的最小除数
public class FindTheSmallestDivisorGivenAThresholdXXX1283{
public static void main(String[] args) {
Solution solution = new FindTheSmallestDivisorGivenAThresholdXXX1283().new Solution();
// TO TEST
    int[] a = new int[]{1,2,5,9};
    System.out.println(solution.smallestDivisor(a, 6));
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // 这题比吃香蕉的珂珂还容易看出来 就是个二分搜索 除数最小为1，最大为nums中的最大值
        int left =1,right = Arrays.stream(nums).max().getAsInt();
        while(left<right){
            int mid = (right-left)/2+left;
            int sum = getSum(nums,mid);
            if(sum<=threshold){
                right =mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    private int getSum(int nums[],int m){
        int sum = 0;
        for(int num:nums){
            // 向上取整的公式 x小于或者大于y的时候也成立：x/y =（x+y-1）/y
            // 这里不要直接num/m 不然会有0的存在。题目要求1/2=1 而不是为0
            sum+= ((num+m-1)/m);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}