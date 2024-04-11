//有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作： 
//
// 
// 提供 100ml 的 汤A 和 0ml 的 汤B 。 
// 提供 75ml 的 汤A 和 25ml 的 汤B 。 
// 提供 50ml 的 汤A 和 50ml 的 汤B 。 
// 提供 25ml 的 汤A 和 75ml 的 汤B 。 
// 
//
// 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。
//当两种类型的汤都分配完时，停止操作。 
//
// 注意 不存在先分配 100 ml 汤B 的操作。 
//
// 需要返回的值： 汤A 先分配完的概率 + 汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10⁻⁵ 的范围内将被认为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 50
//输出: 0.62500
//解释:如果我们选择前两个操作，A 首先将变为空。
//对于第三个操作，A 和 B 会同时变为空。
//对于第四个操作，B 首先将变为空。
//所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
// 
//
// 示例 2: 
//
// 
//输入: n = 100
//输出: 0.71875
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 数学 动态规划 概率与统计 👍 236 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：分汤
public class SoupServingsXXX808 {
    public static void main(String[] args) {
        Solution solution = new SoupServingsXXX808().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double soupServings(int n) {
//        谁能想到这个是一个动归题，还需要排除n比较大的时候的情况
//        先n/25 四种选择就是（4，0）（3，1）（2，2）（1，3）每种可能性都是0.25
//        设 dp为A和B分别还剩下n份时所求概率值，A先分完的概率为 0.25*（(n-4，n)+(n-3,n-1)+(n-2,n-2)+(n-1,n-3)），但是n很大，所以还需要排除一些情况
//        根据数学概率可以推测，当n非常大的时候，A先分完的概率趋近1 我们可以取n=200*25的时候为极限
//        另外，题目所求A被分完的概率="A别分完B还有"的概率+"A和B都被分完"的概率的二分之一
            // 先除以25 取最接近结果的较小值
            n = (int) Math.ceil((double) n / 25);
            // 如果n大于等于200 直接return 1
            if (n >= 200) return 1.0;
            double[][] dp = new double[n + 1][n + 1];
            // B还有A已被分完
            Arrays.fill(dp[0], 1.0);
            //当A和B都剩0份，A和B同时被分完的概率为1，A先被分完的概率就是0。所以A被分完的概率为1*1/2+0=0.5
            dp[0][0] = 0.5;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    double p = dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)];
                    dp[i][j] = p * 0.25;
                }
            }
            return dp[n][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}