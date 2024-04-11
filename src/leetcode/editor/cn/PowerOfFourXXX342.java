//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
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
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 位运算 递归 数学 👍 371 👎 0

package leetcode.editor.cn;
//Java：4的幂
public class PowerOfFourXXX342{
public static void main(String[] args) {
Solution solution = new PowerOfFourXXX342().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfFour(int n) {
       /* if(n == 0) return false;
        if(n == 1) return true;
        int count =0,totalCount = 0;
        while(n>0){
            count += (n & 1);
            n >>= 1;
            totalCount++;
        }
        return count == 1 && (totalCount>2 && totalCount%2 ==1);*/
        // 看一下人家写的 找到10101010..10 也就是0xaaaaaaaa 和他&就行
//        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
        // 或者找规律：4的幂处以3都是1，2的幂但不是4的幂处以3都为2
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}