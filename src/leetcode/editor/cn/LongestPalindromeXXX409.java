//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 566 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：最长回文串
public class LongestPalindromeXXX409 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromeXXX409().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isOdd = false;

        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>(s.length());
            for (Character c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int res = 0;
            for (Character c : map.keySet()) {
                Integer temp = map.get(c);
                res += getNearByEven(temp);
                // 如果当前数为奇数，res为偶数，则历史没有加过回文中心，可+1
                if ((temp & 1) == 1 && (res & 1) == 0) res++;
            }
//            if (isOdd) res += 1;
            return res;
        }

        private int getNearByEven(int i) {
            // 快速获取最近的偶数
            return i / 2 * 2;
            /*while (i >= 0 && (i & 1) != 0) {
                i--;
                isOdd = true;
            }
            return i;*/
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}