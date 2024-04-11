//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics 数组 数学 枚举 数论 👍 1052 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：计数质数
public class CountPrimesXXX204 {
    public static void main(String[] args) {
        Solution solution = new CountPrimesXXX204().new Solution();
// TO TEST
        int n = 10;
        int i = solution.countPrimes(n);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int countPrimes(int n) {
            int res =0;
            //注意从2开始
           for(int i = 2;i<n;i++){
               if(isPrime(i)){
                   res++;
               }
           }
           return res;
        }
        private boolean isPrime(int n){
            if(n <= 1) return false;
            for(int i = 2;i*i<=n;i++){
                if(n%i==0) return false;
            }
            return true;
        }*/
        // 埃式筛
        public int countPrimes(int n) {
            int[] isPrimes = new int[n];
            int res = 0;
            Arrays.fill(isPrimes, 1);
            // 注意这里是求比n小的所有质数，不包括n
            for (int i = 2; i < n; i++) {
                if (isPrimes[i] == 1) {
                    res++;
                    // 这里从i*i开始遍历，是因为之前小于i的数已经把i乘过了
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrimes[j] = 0;
                        }
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}