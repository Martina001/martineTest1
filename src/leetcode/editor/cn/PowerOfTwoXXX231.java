//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
//
// Related Topics 位运算 递归 数学 👍 667 👎 0

package leetcode.editor.cn;
//Java：2 的幂
public class PowerOfTwoXXX231{
public static void main(String[] args) {
Solution solution = new PowerOfTwoXXX231().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 要不就是一直右移并且和1进行&操作，直到n为0，如果count==1就说明true
        /*int count =0;
        while(n>0){
            count += (n&1);
            n >>=1;
        }
        return count == 1;*/
        // 还有一个巧妙思路，如果是2的幂，n&(n-1)就是0
        return (n>0) && ((n & (n - 1)) == 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}