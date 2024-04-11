//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2468 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Java：下一个排列
public class NextPermutationXXX31{
public static void main(String[] args) {
Solution solution = new NextPermutationXXX31().new Solution();
// TO TEST
    solution.nextPermutation(new int[]{1,3,2});
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        // 这道题是个找规律题，下一个排列数满足条件：1 升序较小数X尽可能往右 2 降序的较大数Y尽可能小 3 X和Y交换之后从现在Y的位置往后的数字升序排列即可
        int min = n-2;
        //找到第一个[min+1，n)为降序的min索引
        while(min>=0 && nums[min]>=nums[min+1]){
            min--;
        }
        // 如果一直都是降序，直接反转即为结果
        if(min<0){
            reverse(nums,min+1);
            return;
        }

        // 找到比num[min]大的最右的数，俩数交换，此时min索引位后面都是降序，直接reverse变成升序即可
        // 根据min的定义，所以一定会有比num[min]大的数，所以max索引不会为-1。
        int max = n-1;
        while(max>=0 && nums[min]>=nums[max]){
            max--;
        }
        swap(nums,max,min);
        reverse(nums,min+1);
    }

    private void reverse(int nums[],int start){
        int left = start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;right--;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}