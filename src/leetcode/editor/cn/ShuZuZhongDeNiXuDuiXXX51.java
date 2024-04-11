//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1014 👎 0

package leetcode.editor.cn;
//Java：数组中的逆序对
public class ShuZuZhongDeNiXuDuiXXX51 {
public static void main(String[] args) {
Solution solution = new ShuZuZhongDeNiXuDuiXXX51().new Solution();
// TO TEST
    int nums[] = new int[]{3,5};
    solution.reversePairs(nums);
    System.out.println(res);
}
//leetcode submit region begin(Prohibit modification and deletion)
public static int res=0;

    class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        reversePairs(copy, 0, len - 1, temp);
        return res;
    }

    private void reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        reversePairs(nums, left, mid, temp);
        reversePairs(nums, mid + 1, right, temp);

        mergeAndCount(nums, left, mid, right, temp);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                res += (mid - i + 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}