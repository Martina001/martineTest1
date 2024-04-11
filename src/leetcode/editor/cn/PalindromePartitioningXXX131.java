//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1715 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：分割回文串
public class PalindromePartitioningXXX131 {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningXXX131().new Solution();
// TO TEST
        String s = "aab";
        List<List<String>> partition = solution.partition(s);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        boolean dp[][];
        List<List<String>> ret = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], true);
            }

            // 初始化状态转移数组
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    // 注意，dp[i][j]表示的是s中i到j都是回文，所以循环是i--，j++
                    // 状态转移方程中就是要i+1到j-1为true，以及s中i和j的字符相等
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }

            //
            dfs(s, 0);
            return ret;
        }

        /**
         * 回溯
         *
         * @param s
         * @param i
         */
        private void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<>(ans));
                return;
            }
            for (int j = i; j < n; j++) {
                // 如果是回文串，就继续往下走
                // 如果不是就跳过
                if (dp[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}