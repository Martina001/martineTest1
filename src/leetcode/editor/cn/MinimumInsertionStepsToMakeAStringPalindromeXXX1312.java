//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
//
// Related Topics 字符串 动态规划 👍 227 👎 0

package leetcode.editor.cn;
//Java：让字符串成为回文串的最少插入次数
public class MinimumInsertionStepsToMakeAStringPalindromeXXX1312{
public static void main(String[] args) {
Solution solution = new MinimumInsertionStepsToMakeAStringPalindromeXXX1312().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        // 先把对角线初始化为1，就是说自己让自己成为回文串需要1次
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        // 然后找s中最长回文子序列，用n减去这个值，就是可以变成回文串的最小次数
        // 以下见题目：最长回文子序列
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return n - f[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}