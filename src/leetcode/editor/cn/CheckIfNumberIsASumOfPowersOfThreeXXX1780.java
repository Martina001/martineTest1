//给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。 
//
// 对于一个整数 y ，如果存在整数 x 满足 y == 3ˣ ，我们称这个整数 y 是三的幂。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：true
//解释：12 = 3¹ + 3²
// 
//
// 示例 2： 
//
// 输入：n = 91
//输出：true
//解释：91 = 3⁰ + 3² + 3⁴
// 
//
// 示例 3： 
//
// 输入：n = 21
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁷ 
// 
//
// Related Topics 数学 👍 120 👎 0

package leetcode.editor.cn;
//Java：判断一个数字是否可以表示成三的幂的和
public class CheckIfNumberIsASumOfPowersOfThreeXXX1780{
public static void main(String[] args) {
Solution solution = new CheckIfNumberIsASumOfPowersOfThreeXXX1780().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        // 巧妙数学题 转换为3进制之后，如果3进制中有一位为2就表示n是由两个相同的3的幂加和而来，所以目标是判断n的三进制的每一位都不为2
        while(n!=0)
        {
            if(n%3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}