//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
// 
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
//
// Related Topics 字符串 动态规划 👍 988 👎 0

package leetcode.editor.cn;

//Java：交错字符串
public class InterleavingStringXXX97 {
    public static void main(String[] args) {
        Solution solution = new InterleavingStringXXX97().new Solution();
// TO TEST
        boolean interleave = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
//        直接动归获取s1和s2可构成的交错字符串，判断当前结果是否等于S3
//        设 dp[i][j]为s1的0到i和s2的0-j构成的交错字符串个数 这样可以得到dp[i][j]=dp[i-1][j]+1=dp[i][j-1]+1
//        但是得到对应交错字符串结果需要存储很多数据 不可
//        要不考虑从s3出发，每个都判断一波 试一下 这样就是双指针 也不行 因为s1和s2可能有重复字符

//            可以定义dp[i][j]为s1的0到i和s2的0-j构成的交错字符串是否包含s3的0-(i+j+1)的字符串
            int n = s3.length();
            int n1 = s1.length();
            int n2 = s2.length();
            if (n != n1 + n2) {
                return false;
            }
            boolean dp[][] = new boolean[n1 + 1][n2 + 1];
            dp[0][0] = true;
            for (int i = 0; i <= n1; i++) {
                for (int j = 0; j <= n2; j++) {
                    int k = i + j - 1;
                    boolean b = false;
                    if (i > 0) {
                        b = dp[i - 1][j] && s3.charAt(k) == s1.charAt(i-1);
                        dp[i][j] = dp[i][j] || b;
                    }
//                    i-1和j-1的位置 任意一个位置符合都可以，所以 dp[i][j] = dp[i][j] || b 这一行不能抽出来放在最后哦
                    if (j > 0) {
                        b = dp[i][j - 1] && s3.charAt(k) == s2.charAt(j-1);
                        dp[i][j] = dp[i][j] || b;
                    }
                }

            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}