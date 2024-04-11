//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 40 👎 0

package leetcode.editor.cn;

//Java：公因子的数目
public class NumberOfCommonFactorsXXX2427 {
    public static void main(String[] args) {
        Solution solution = new NumberOfCommonFactorsXXX2427().new Solution();
// TO TEST
        int res = solution.commonFactors(12, 6);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            if (a == 0 || b == 0) return 0;
            int res = 0;
            // 要从1开始遍历，别傻啦吧唧的直接写0
            /*for (int i = 1; i <= Math.min(a, b); i++) {
                if (a % i == 0 && b % i == 0) res++;
            }*/
            // 用最大公约数,时间复杂度为Ogcd
            int gcd = gcd(a, b);
            /*for (int i = 1; i <= gcd; i++) {
                if (a % i == 0 && b % i == 0) res++;
            }*/
            // 用最大公约数，因为公因子一定是成对出现的，所以公因子x的平方一定不大于最大公约数（需要动点脑筋）
            for (int i = 1; i * i <= gcd; i++) {
                if (gcd % i == 0) {
                    res++;
                    // 如果的i的平方是公因子且不是最大公约数，公因子对数再加一
                    if (i * i != gcd) res++;
                }
            }
            return res;
        }

        /*
           求最大公约数 GCD greatest common divisor
         */
        // 辗转相除法 1
        private int gcd(int a, int b) {
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }

        // 2
        private int gcd2(int a, int b) {
            while (b != 0) {
                a %= b;
                a ^= b;
                b ^= a;
                a ^= b;
            }
            return a;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}