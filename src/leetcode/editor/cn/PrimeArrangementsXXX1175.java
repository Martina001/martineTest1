//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
//
// Related Topics 数学 👍 115 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：质数排列
public class PrimeArrangementsXXX1175 {
    public static void main(String[] args) {
        Solution solution = new PrimeArrangementsXXX1175().new Solution();
// TO TEST
        int i = solution.countPrimes(2);
        System.out.println(i);
        int i1 = solution.numPrimeArrangements(2);
        System.out.println(i1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = 1000000007;

        public int numPrimeArrangements(int n) {
//            int primesNum = countPrimes(n);
            int primesNum = 0; //计算质数的个数
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) primesNum++;
            }
            return (int) (deal(primesNum) * deal(n - primesNum) % MOD);
        }

        // n的阶乘
        private long deal(int n) {
            long res = 1;
            for (int i =1; i <= n; i++) {
                res *= i;
                res %= MOD;
            }
            return res;
        }

        private boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        private int countPrimes(int n) {
            if (n <= 1) return 0;
            if (n == 2) return 1;
            int[] primes = new int[n];
            int res = 0;
            Arrays.fill(primes, 1);
            for (int i = 2; i < n; i++) {
                if (primes[i] == 1) {
                    res++;
                    if (i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            primes[j] = 0;
                        }
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}