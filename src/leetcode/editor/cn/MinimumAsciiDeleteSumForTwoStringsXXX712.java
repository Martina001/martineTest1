//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 378 👎 0

package leetcode.editor.cn;

//Java：两个字符串的最小ASCII删除和
public class MinimumAsciiDeleteSumForTwoStringsXXX712 {
    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStringsXXX712().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String word1, String word2) {
            // 这题和583不一样，不可用最长公共子序列的方式进行计算，可直接动规
            int m = word1.length();
            int n = word2.length();


            //dp[i][j]数组表示俩字符串从i-1到j-1之间相同的话，需要删除字符的Ascii值最小和
            int dp[][] = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + word1.codePointAt(i - 1);
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + word2.codePointAt(j - 1);

            }

//        List<Character> res = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int i1 = word1.codePointAt(i - 1);
                    int i2 = word2.codePointAt(j - 1);
                    if (i1 == i2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 注意这里不是直接判断i1和i2的大小来取dp[i][j]值，而是判断dp[i-1][j] + i1和dp[i][j-1] + i2的大小
                        dp[i][j] = Math.min(dp[i - 1][j] + i1, dp[i][j - 1] + i2);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}