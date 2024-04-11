//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1164 👎 0

package leetcode.editor.cn;

import com.sun.tools.javac.util.StringUtils;

import java.util.Objects;

//Java：最长回文子序列
public class LongestPalindromicSubsequenceXXX516{
public static void main(String[] args) {
Solution solution = new LongestPalindromicSubsequenceXXX516().new Solution();
// TO TEST
    int cbbd = solution.longestPalindromeSubseq("cbbd");
    System.out.println(cbbd);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(Objects.isNull(s) || s.isEmpty()) return 0;
        return getRes(s);
    }
    public int getRes(String s){
        int x = s.length();
        // dp代表的是s中从索引i到j中的最长回文子序列，题目所求即dp[0][x-1]
        int dp[][] = new int[x][x];
        //注意因为是dp[i][j]是由dp[i+1][j-1]来的，所以i是从后往前，j是从i+1往后
        for(int i =x-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j = i+1;j<x;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][x-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}