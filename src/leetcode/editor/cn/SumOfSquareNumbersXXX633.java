//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
//
// Related Topics 数学 双指针 二分查找 👍 441 👎 0

package leetcode.editor.cn;

//Java：平方数之和
public class SumOfSquareNumbersXXX633 {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbersXXX633().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            // 就是说用一下函数sqrt就行了，然后双指针查找
            // 但是要注意的是，要用Long。防止溢出
            long left = 0, right = (long) Math.sqrt(c);
            // 注意这里是小于等于
            while (left <= right) {
                long sum = left * left + right * right;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}