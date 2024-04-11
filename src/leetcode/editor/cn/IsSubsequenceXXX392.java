//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。
//
// 进阶：
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？
//
// 致谢：
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
//
//
//
// 示例 1：
//
//
//输入：s = "abc", t = "ahbgdc"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "axc", t = "ahbgdc"
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// 两个字符串都只由小写字符组成。
//
//
// Related Topics 双指针 字符串 动态规划 👍 1027 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：判断子序列
public class IsSubsequenceXXX392 {
    public static void main(String[] args) {
        Solution solution = new IsSubsequenceXXX392().new Solution();
// TO TEST
        boolean subsequence = solution.isSubsequence("abc", "aabc");
//        solution.getChildSequence("abc",0,3,new StringBuffer());
        System.out.println("n");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int n = t.length();
            int m = s.length();
            // 换一种定义，学习一下官方解法
            // dp[i][j]中的j为26个字母之一，dp表示在t中i的位置往后，j字符出现的第一个位置
            // 把dp算出来以后，只用遍历s中的字符JJ，判断dp[i][JJ]是否超过了n，而且i不用在0-m之间每次+1的遍历，只用每次根据dp获取下一个i的位置即可
            int dp[][] = new int[n+1][26];
            Arrays.fill(dp[n],n);

            // 要判断字符j出现的首位置，所以i要倒序
            for(int i = n-1;i>=0;i--){
                for(int j = 0;j<26;j++){
                    char c = t.charAt(i);
                    int  cc =c-'a';
                    if(j == cc){
                        dp[i][j] = i;
                    }else{
                        dp[i][j]= dp[i+1][j];
                    }
                }
            }

            // 根据dp数组的结果遍历s，判断是否s中字符在t中的首位置已经超过了n
            int index =0;
            for(int i=0;i<m;i++){
                int cc = s.charAt(i)-'a';
                if(dp[index][cc] >= n){
                    return false;
                }
                // 没超过n说明s中的当前字符可以在t中找到，就需要到t的下一个索引位置上找了
                index = dp[index][cc]+1;
            }
            return true;
            // 试一下动态规划
            // dp[i][j]表示s中前i个字符是否是t中前j个字符的子序列 可以 但是效率不高
           /* boolean dp[][] = new boolean[m+1][n+1];
            Arrays.fill(dp[0],true);
            for(int i=1;i<=m;i++){
                dp[i][0]=false;
            }
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            return dp[m][n];*/
            // 获取所有子序列（不重复的子集） 超时
            /*getChildJi(t, 0, n, new StringBuffer());
            return res.contains(s);*/
            /*
            // 经典双指针
            int left = 0;
            int l = 0;
            while (l < m && left < n) {
                // 这里别直接用left进行while循环，不然在s和t都只有一个字符且不相等的时候会返回为true
                if(l<m && s.charAt(l) == t.charAt(left)){
                    l++;
                }
                left++;
            }
            if(l<m) return false;
            return true;*/
        }

        // 如果S是传入了一个size超大的列表，每个都要判断是否为T的子序列，那么乍眼一看应该是直接把T的子序列都拿出来 每个判断
        // 写一下获取所有子序列的函数 有可能超时
        Set<String> res = new HashSet<>();

        private void getChildJi(String t, int start, int n, StringBuffer track) {

            res.add(new StringBuffer(track.toString()).toString());

            for (int i = start; i < n; i++) {
                // 不可复选子集
                getChildJi(t, i + 1, n, track.append(t.charAt(i)));
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}