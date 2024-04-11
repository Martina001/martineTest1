//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 727 👎 0

package leetcode.editor.cn;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Objects;

//Java：验证回文串
public class ValidPalindromeXXX125 {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeXXX125().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先转为有效字符串再用双指针判断
         *
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            // StringBuffer比StringBuilder好
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            // 用自带反转函数，注意不能直接用sb.reverse(),要新建对象
            StringBuffer reverse = new StringBuffer(sb).reverse();
            return reverse.toString().equalsIgnoreCase(sb.toString());
            // 用双指针
           /* int l = 0, r = sb.length() - 1;
            while (l < r) {
                if (sb.charAt(l) != sb.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;*/
            //  字符串原地判断是否是回文串
            // 用此方法必须要注意时刻判断l和r的关系
            /*if (Objects.isNull(s)) {
                return false;
            }
            int l = 0, r = s.length() - 1;
            while (l <= r) {
                while (l<=r && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(l)))) {
                    l++;
                }
                while (l<=r && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(r)))) {
                    r--;
                }
                if(l>r){
                    return true;
                }
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
            return true;*/
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)



}