//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 333 👎 0

package leetcode.editor.cn;

//Java：反转字符串中的元音字母
public class ReverseVowelsOfAStringXXX345 {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAStringXXX345().new Solution();
// TO TEST
        String s = solution.reverseVowels(",.ba.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] a = s.toCharArray();
            int l = 0, r = a.length - 1;
            while (l <= r) {
                while (l < r && !isVowel(a[l])) {
                    l++;
                }
                while (r > l && !isVowel(a[r])) {
                    r--;
                }
                swap(a, l, r);
                l++;
                r--;
            }
            return new String(a);
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private boolean isVowel(char s) {
            return "aeiouAEIOU".indexOf(s) >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}