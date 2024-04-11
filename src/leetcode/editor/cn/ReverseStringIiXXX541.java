//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 547 👎 0

package leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

//Java：反转字符串 II
public class ReverseStringIiXXX541 {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIiXXX541().new Solution();
// TO TEST

        String abcdkl = solution.reverseStr("abcdkl", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            int left = 0, right = k-1;
            while (left < s.length()) {
                int ll = left,rr = Math.min(right,a.length-1);
                while(ll < rr){
                    swap(a, ll, rr);
                    ll++;
                    rr--;
                }
                left += 2 * k;
                right += 2 * k;
            }
            return String.copyValueOf(a);
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}