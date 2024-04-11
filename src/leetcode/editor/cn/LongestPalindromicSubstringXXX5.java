//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6911 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstringXXX5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstringXXX5().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 方法1自然是中心扩散法，注意除了中心点为奇数的情况还要考虑中心点为偶数的情况
            /*String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 单个i为中心
                String tempLongestOdd = getLongBetter(s, i, i);
                // i和i+1为中心
                String tempLongestEven = getLongBetter(s, i, i + 1);

                String tempLongest = (tempLongestOdd.length() > tempLongestEven.length()) ? tempLongestOdd : tempLongestEven;
                res = (res.length() < tempLongest.length()) ? tempLongest : res;
            }
            return res;*/
            // 方法2是简单的动态规划
            // dp[i][j]表示i-j之间的字符串是否为回文串
            int n = s.length();
            if(n <2){
                return s;
            }
            // 注意是1
            int maxLen = 1;
            int maxLenStart = 0;
            boolean dp[][] = new boolean[n][n];

            // 外循环为右边界，直接遍历；内循环在右边界内遍历（从左到右）
            /*
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            for(int j =1;j<n;j++){
                for(int i = 0;i<j;i++){
                    // 注意判断
                    if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1]))
                    {
                        dp[i][j] = true;
                        if(j-i+1 > maxLen){
                            maxLen = j-i+1;
                            maxLenStart = i;
                        }
                    }
                }
            }*/

            // 直接借用求最长回文子序列的动归方式进行循环
            // 外循环为左边界，在右边界内从i+1开始，左到右
            for(int i =n-1;i>=0;i--) {
                dp[i][i] = true;
                for (int j = i + 1; j < n; j++) {
                    // 注意判断j-i<=2
                    if(s.charAt(i) == s.charAt(j) && (j-i<=2||dp[i+1][j-1]))
                    {
                        dp[i][j] = true;
                        if(j-i+1 > maxLen){
                            maxLen = j-i+1;
                            maxLenStart = i;
                        }
                    }
                }
            }
            /* // 先遍历子串长度，这样可以快速根据j和len的大小决定是否结束循环
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i < n; i++) {
                    dp[i][i] = true;
                    int j = len + i - 1;
                    if(j >= n){
                        break;
                    }
                    char c = s.charAt(i);
                    if(c == s.charAt(j)){
                        if(j-i<=2){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j] && len > maxLen){
                        maxLen = len;
                        maxLenStart = i;
                    }
                }
            }*/

            return s.substring(maxLenStart,maxLenStart+maxLen);
        }

        private String getLongBetter(String a, int l, int r) {
            while (l >= 0 && r < a.length() && a.charAt(l) == a.charAt(r)) {
                l--;
                r++;
            }
            return a.substring(l + 1, r);
        }

        /**
         * 这种只能找到中心点为奇数的回文串
         *
         * @param s
         * @param i
         * @return
         */
        private int getLong(char[] s, int i) {
            int l = i, r = i;
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--;
                r++;
            }
            return r - l - 1;
        }

        private String getLong(String a, int i) {
            char[] s = a.toCharArray();
            int l = i, r = i;
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--;
                r++;
            }
            return a.substring(l + 1, r);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}