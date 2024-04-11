//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 292 👎 0

package leetcode.editor.cn;
//Java：排列硬币
public class ArrangingCoinsXXX441{
public static void main(String[] args) {
Solution solution = new ArrangingCoinsXXX441().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        // 根据等差数列的公式 x(x-1)/2 <=n 可以得到x<(2y-0.25)的根号-0.5
        return (int)(Math.sqrt((long)2*n+0.25)-0.5);
        // 二分查找也可以 但是感觉不用直接从0-n进行二分，找到比Math.sqrt(2*n+0.25)-0.5大的整数就行
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}