//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3346 👎 0

package leetcode.editor.cn;
//Java：编辑距离
public class EditDistanceXXX72{
public static void main(String[] args) {
Solution solution = new EditDistanceXXX72().new Solution();
// TO TEST
    int i = solution.minDistance("sea", "eat");
    System.out.println(i);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        // 经典动归，如果只可以删除一个元素，我们就直接用最长公共子序列的办法，求出最长公共子序列，然后加上两个字符串剩余的字符数即可
//        这道题需要我们直接写一下动归试试。假设由s1变成s2：由于每个字符如果不等，可以插入（i不变 j+1）、删除（i+1，j不变）、替换（i+1,j+1）
//        定义dp[i][j]为将s1的i到最后变成s2的j到最后 所需的操作次数
        int m = word1.length(),n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i =1;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j =1;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i =1;i<=m;i++) {
            char c = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char d = word2.charAt(j-1);
                if(c == d){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 不等，就选择删除、插入和替换的最小操作数，操作数++
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
//        为啥倒着算不对，todo 待check
        /*if(m==0) return n;
        if(n==0) return m;
        for(int i =1;i<m;i++){
            dp[i][n]=i;
        }
        for(int j =1;j<n;j++){
            dp[m][j]=j;
        }
        dp[m][n] =0;
        for(int i =m-1;i>=0;i--){
            char c = word1.charAt(i);
            for(int j = n-1;j>=0;j--){
                char d = word2.charAt(j);
                if(c == d){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    // 不等，就选择删除、插入和替换的最小操作数，操作数++
                    dp[i][j] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])+1;
                }
            }
        }
        return dp[0][0];*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}